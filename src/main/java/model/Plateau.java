package model;

public class Plateau {
    public Block blocks[][];

    public int xplayer;
    public int yplayer;

    public int ndiamond;

    public int xmax;
    public int ymax;

    public Plateau(int x, int y) {
        this.ndiamond = 4;
        this.blocks = new Block[y][x];

        this.xmax = x;
        this.ymax = y;

        for (int n = 0; n < this.ymax; n++) {
            this.blocks[n][0] = new Wall();
            this.blocks[n][this.xmax - 1] = new Wall();
        }

        for (int i = 0; i < this.xmax; i++) {
            this.blocks[0][i] = new Wall();
            this.blocks[this.ymax - 1][i] = new Wall();
        }


        for (int n = 1; n < this.ymax - 1; n++) {
            for (int i = 1; i < this.xmax - 1; i++) {
                this.blocks[n][i] = new Dirt();
            }
        }
        this.blocks[5][13] = new Wall();
        this.blocks[5][14] = new Wall();
        this.blocks[5][15] = new Wall();
        this.blocks[5][16] = new Wall();

        this.blocks[4][16] = new Diamond();
        this.blocks[3][16] = new Diamond();
        this.blocks[4][17] = new Diamond();
        this.blocks[3][17] = new Diamond();

        this.blocks[4][18] = new Rock();
        this.blocks[3][19] = new Rock();
        this.blocks[2][17] = new Rock();
        this.blocks[3][18] = new Rock();

        this.blocks[8][18] = new Vide();
        this.blocks[8][19] = new Vide();
        this.blocks[9][18] = new Vide();
        this.blocks[9][19] = new Vide();

        this.blocks[9][19] = new Mob1();

        this.blocks[8][8] = new Vide();
        this.blocks[8][9] = new Vide();
        this.blocks[9][8] = new Vide();
        this.blocks[9][9] = new Vide();
        this.blocks[10][8] = new Vide();
        this.blocks[10][9] = new Vide();

        this.blocks[9][9] = new Mob2();

        this.blocks[7][15] = new Player();

        this.blocks[3][22] = new FinalBlock();

        this.xplayer = 15;
        this.yplayer = 7;
    }

    public void movePlayer(String direction) {
        int x = 0;
        int y = 0;
        switch (direction) {
            case "UP":
                y = -1;
                break;
            case "DOWN":
                y = 1;
                break;
            case "LEFT":
                x = -1;
                break;
            case "RIGHT":
                x = 1;
                break;
        }
        this.blocks[yplayer][xplayer].setDirection(direction);
        if (this.blocks[yplayer + y][xplayer + x].breakable) {
            if (this.blocks[yplayer + y][xplayer + x].lootable)
                if (ndiamond > 0)
                    ndiamond--;
            this.blocks[yplayer + y][xplayer + x] = this.blocks[yplayer][xplayer];
            this.blocks[yplayer][xplayer] = new Vide();
            this.yplayer += y;
            this.xplayer += x;
        } else {
            if (y == 0 && (this.blocks[yplayer][xplayer + x] instanceof Rock)) {
                if (this.blocks[yplayer][xplayer + x * 2] instanceof Vide) {
                    this.blocks[yplayer][xplayer + x * 2] = this.blocks[yplayer][xplayer + x];
                    this.blocks[yplayer][xplayer + x] = this.blocks[yplayer][xplayer];
                    this.blocks[yplayer][xplayer] = new Vide();
                    this.xplayer += x;
                }
            }
            else {
                    if (this.blocks[yplayer + y][xplayer + x] instanceof FinalBlock) {
                        if (ndiamond == 0) {
                            System.out.println("You Win !!!!!!!!!!!!");
                            System.exit(0);
                        }
                    }
                }
        }
    }

    public void update() {
        for (int n = this.ymax - 1; n >= 0; n--)
            for (int i = this.xmax - 1; i >= 0; i--)
                if ((this.blocks[n][i] instanceof Vide) || (this.blocks[n][i] instanceof Player))
                    updateVide(i, n);


        for (int n = this.ymax - 1; n >= 0; n--)
            for (int i = this.xmax - 1; i >= 0; i--)
                if (this.blocks[n][i] instanceof Mob && !this.blocks[n][i].update)
                    updatemob(i, n);

        for (int n = this.ymax - 1; n >= 0; n--)
            for (int i = this.xmax - 1; i >= 0; i--)
                if (this.blocks[n][i] instanceof Mob)
                    this.blocks[n][i].update = false;
    }

    private void updateVide(int x, int y) {
        if (this.blocks[y - 1][x].fall) {
            this.updatefall(x, y - 1);
        }
        if (this.blocks[y - 1][x - 1].fall) {
            this.updatefall(x - 1, y - 1);
        }
        if (this.blocks[y - 1][x + 1].fall) {
            this.updatefall(x + 1, y - 1);
        }
    }

    private void updatefall(int x, int y) {

        if (move(x, y, x, y + 1)) {
            this.blocks[y + 1][x].falling = true;
            return;
        }
        if (this.blocks[y + 1][x].fall || this.blocks[y + 1][x] instanceof Wall) {
            if (this.blocks[y][x - 1] instanceof Vide)
                if (move(x, y, x - 1, y + 1)) {
                    this.blocks[y + 1][x + 1].falling = true;
                    return;
                }
            if (this.blocks[y][x + 1] instanceof Vide)
                if (move(x, y, x + 1, y + 1)) {
                    this.blocks[y + 1][x + 1].falling = true;
                    return;
                }
        }
        if ((this.blocks[y + 1][x] instanceof Player) && (this.blocks[y][x].falling)) {
            System.out.println("rock falling on player");
            System.exit(0);
        }

        if ((this.blocks[y + 1][x] instanceof Mob) && (this.blocks[y][x].falling)) {
            this.blocks[y + 1][x] = new Diamond();
            this.blocks[y + 1][x + 1] = new Diamond();
            this.blocks[y + 1][x - 1] = new Diamond();
            this.blocks[y - 1][x] = new Diamond();
            this.blocks[y - 1][x + 1] = new Diamond();
            this.blocks[y - 1][x - 1] = new Diamond();
            this.blocks[y][x] = new Diamond();
            this.blocks[y][x + 1] = new Diamond();
            this.blocks[y][x - 1] = new Diamond();
        }

        this.blocks[y][x].falling = false;
    }

    private void updatemob(int x, int y) {
        this.blocks[y][x].update = true;

        switch (this.blocks[y][x].direction) {
            case "UP":
                if (this.blocks[y - 1][x] instanceof Player) {
                    System.out.println("mob eat player");
                    System.exit(0);
                } else if (move(x, y, "UP")) ;
                else if (move(x, y, "RIGHT")) ;
                else if (move(x, y, "LEFT")) ;
                else if (move(x, y, "DOWN")) ;
                break;
            case "DOWN":
                if (this.blocks[y + 1][x] instanceof Player)
                    System.exit(0);
                else if (move(x, y, "DOWN")) ;
                else if (move(x, y, "LEFT")) ;
                else if (move(x, y, "RIGHT")) ;
                else if (move(x, y, "UP")) ;
                break;
            case "LEFT":
                if (this.blocks[y][x - 1] instanceof Player)
                    System.exit(0);
                else if (move(x, y, "LEFT")) ;
                else if (move(x, y, "UP")) ;
                else if (move(x, y, "DOWN")) ;
                else if (move(x, y, "RIGHT")) ;
                break;
            case "RIGHT":
                if (this.blocks[y][x + 1] instanceof Player)
                    System.exit(0);
                else if (move(x, y, "RIGHT")) ;
                else if (move(x, y, "DOWN")) ;
                else if (move(x, y, "UP")) ;
                else if (move(x, y, "LEFT")) ;
                break;
        }
    }

    private boolean move(int x1, int y1, int x2, int y2) {
        if (this.blocks[y2][x2] instanceof Vide) {
            this.blocks[y2][x2] = this.blocks[y1][x1];
            this.blocks[y1][x1] = new Vide();
            if (y2 < y1)
                this.blocks[y2][x2].direction = "UP";
            else
                this.blocks[y2][x2].direction = "DOWN";
            if (x2 < x1)
                this.blocks[y2][x2].direction = "LEFT";
            else
                this.blocks[y2][x2].direction = "RIGHT";
            return true;
        }
        return false;
    }

    private boolean move(int x, int y, String direction) {
        switch (direction) {
            case "UP":
                if (this.blocks[y - 1][x] instanceof Vide) {
                    this.blocks[y - 1][x] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide();
                    this.blocks[y - 1][x].direction = direction;
                    return true;
                }
                break;
            case "DOWN":
                if (this.blocks[y + 1][x] instanceof Vide) {
                    this.blocks[y + 1][x] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide();
                    this.blocks[y + 1][x].direction = direction;
                    return true;
                }
                break;
            case "LEFT":
                if (this.blocks[y][x - 1] instanceof Vide) {
                    this.blocks[y][x - 1] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide();
                    this.blocks[y][x - 1].direction = direction;
                    return true;
                }
                break;
            case "RIGHT":
                if (this.blocks[y][x + 1] instanceof Vide) {
                    this.blocks[y][x + 1] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide();
                    this.blocks[y][x + 1].direction = direction;
                    return true;
                }
                break;
        }
        return false;
    }
}
