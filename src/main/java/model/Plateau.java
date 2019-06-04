package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Plateau {
    public Block blocks[][];

    public int xplayer;
    public int yplayer;

    public int ndiamond;

    public int xmax;
    public int ymax;

    public int level;

    public boolean exit;

    private Block wall;
    private Block dirt;
    private Block diamond;
    private Block player;
    private Block vide;
    private Block rock;
    private Block mob1;
    private Block mob2;

    /**
     * Instantiates a new Plateau.
     *
     * @param map
     *          the map
     * @param ndiamond
     *           the number of diamond
     * @param level
     *           the level
     *
     */

    public Plateau(String map, int ndiamond, int level) {
        this.level = 1;
        this.level = level;
        this.ndiamond = ndiamond;

        this.xmax = 0;
        this.ymax = 1;

        this.wall = new Wall(this.level);
        this.dirt = new Dirt(this.level);
        this.diamond = new Diamond(this.level);
        this.player = new Player(this.level);
        this.vide = new Vide(this.level);
        this.rock = new Rock(this.level);
        this.mob1 =  new Mob1(this.level);
        this.mob2 =  new Mob2(this.level);



        for (int n = 0; map.charAt(n) != '$'; n++)
            this.xmax++;

        for (int n = 0; n < map.length(); n++)
            if (map.charAt(n) == '$')
                this.ymax++;


        this.blocks = new Block[this.ymax][this.xmax];




        exit = false;

        for (int n = 0; n < this.ymax; n++) {
            this.blocks[n][0] = this.wall;
            this.blocks[n][this.xmax - 1] = this.wall;
        }

        for (int i = 0; i < this.xmax; i++) {
            this.blocks[0][i] = this.wall;
            this.blocks[this.ymax - 1][i] = this.wall;
        }


        for (int n = 1; n < this.ymax - 1; n++) {
            for (int i = 1; i < this.xmax - 1; i++) {
                this.blocks[n][i] = this.dirt;
            }
        }

        int x = 0;
        int y = 0;
        for (int n = 0; n < map.length(); n++) {
            char c = map.charAt(n);
            System.out.println("x:" + x + " y:" + y + "c:" + c);
            if (c == '$') {
                y++;
                x -= this.xmax;
            } else {
                switch (c) {
                    case '#':
                        this.blocks[y][x] = this.wall;
                        break;
                    case 'd':
                        this.blocks[y][x] = this.diamond;
                        break;
                    case 'P':
                        this.blocks[y][x] = this.player;
                        this.xplayer = x;
                        this.yplayer = y;
                        break;
                    case 'X':
                        this.blocks[y][x] = this.dirt;
                        break;
                    case ' ':
                        this.blocks[y][x] = this.vide;
                        break;
                    case 'O':
                        this.blocks[y][x] = this.rock;
                        break;
                    default:
                        this.blocks[y][x] = this.dirt;


                }
                x++;
            }


        }


        this.blocks[9][9] = this.mob2;

        this.blocks[7][15] = this.player;

        this.blocks[3][22] = new FinalBlock(this.level);

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
        if (this.blocks[yplayer + y][xplayer + x].getBreakable()) {
            if (this.blocks[yplayer + y][xplayer + x].getLootable())
                if (ndiamond > 0)
                    ndiamond--;
            this.blocks[yplayer + y][xplayer + x] = this.blocks[yplayer][xplayer];
            this.blocks[yplayer][xplayer] = this.vide;
            this.yplayer += y;
            this.xplayer += x;
        } else {
            if (y == 0 && (this.blocks[yplayer][xplayer + x] instanceof Rock)) {
                if (this.blocks[yplayer][xplayer + x * 2] instanceof Vide) {
                    this.blocks[yplayer][xplayer + x * 2] = this.blocks[yplayer][xplayer + x];
                    this.blocks[yplayer][xplayer + x] = this.blocks[yplayer][xplayer];
                    this.blocks[yplayer][xplayer] = vide;
                    this.xplayer += x;
                }
            } else {
                if (this.blocks[yplayer + y][xplayer + x] instanceof FinalBlock) {
                    if (this.ndiamond == 0) {
                        System.out.println("You Win !!!!!!!!!!!!");
                        this.blocks[yplayer][xplayer].setDirection("WIN");
                        exit = true;
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
                if (this.blocks[n][i].getFall())
                this.blocks[n][i].setUpdate(false);



        for (int n = this.ymax - 1; n >= 0; n--)
            for (int i = this.xmax - 1; i >= 0; i--)
                if (this.blocks[n][i] instanceof Mob && !this.blocks[n][i].getUpdate())
                    updatemob(i, n);

        for (int n = this.ymax - 1; n >= 0; n--)
            for (int i = this.xmax - 1; i >= 0; i--)
                if (this.blocks[n][i] instanceof Mob)
                    this.blocks[n][i].setUpdate(false);
    }

    private void updateVide(int x, int y) {
        if (this.blocks[y - 1][x].getFall() && !this.blocks[y - 1][x].getUpdate() ) {
            this.updatefall(x, y - 1);
        }
        if (this.blocks[y - 1][x - 1].getFall()&& !this.blocks[y - 1][x - 1].getUpdate() ) {
            this.updatefall(x - 1, y - 1);
        }
        if (this.blocks[y - 1][x + 1].getFall()&& !this.blocks[y - 1][x + 1].getUpdate()) {
            this.updatefall(x + 1, y - 1);
        }

    }

    private void updatefall(int x, int y) {

        this.blocks[y][x].setUpdate(true);

        if (move(x, y,"DOWN")) {
            this.blocks[y + 1][x].setFalling(true);
            return;
        }
        if (this.blocks[y + 1][x].getFall() || this.blocks[y + 1][x] instanceof Wall) {
            if (this.blocks[y][x - 1] instanceof Vide)
                if (move(x, y, x - 1, y + 1)) {
                    this.blocks[y + 1][x - 1].setFalling(true);
                    return;
                }

            if (this.blocks[y][x + 1] instanceof Vide)
                if (move(x, y, x + 1, y + 1)) {
                    this.blocks[y + 1][x + 1].setFalling(true);
                    return;
                }
        }
        if ((this.blocks[y + 1][x] instanceof Player) && (this.blocks[y][x].getFalling())) {
            System.out.println("rock falling on player");

            this.blocks[y + 1][x].setDirection("DEATH");
            exit = true;
            return;
        }

        if ((this.blocks[y + 1][x] instanceof Mob) && (this.blocks[y][x].getFalling())) {
            if (this.blocks[y + 1][x] instanceof Player)
                exit = true;
            this.blocks[y + 1][x] = diamond;

            if (this.blocks[y + 1][x + 1] instanceof Player)
                exit = true;
            this.blocks[y + 1][x + 1] = diamond;

            if (this.blocks[y + 1][x - 1] instanceof Player)
                exit = true;
            this.blocks[y + 1][x - 1] = diamond;

            if (this.blocks[y - 1][x] instanceof Player)
                exit = true;
            this.blocks[y - 1][x] = diamond;

            if (this.blocks[y - 1][x + 1] instanceof Player)
                exit = true;
            this.blocks[y - 1][x + 1] = diamond;

            if (this.blocks[y - 1][x - 1] instanceof Player)
                exit = true;
            this.blocks[y - 1][x - 1] = diamond;

            if (this.blocks[y][x] instanceof Player)
                exit = true;
            this.blocks[y][x] = diamond;

            if (this.blocks[y][x + 1] instanceof Player)
                exit = true;
            this.blocks[y][x + 1] = diamond;

            if (this.blocks[y][x - 1] instanceof Player)
                exit = true;
            this.blocks[y][x - 1] = diamond;

        }


        this.blocks[y][x].setFalling(false);
    }

    private void updatemob(int x, int y) {
        this.blocks[y][x].setUpdate(true);

        switch (this.blocks[y][x].direction) {
            case "UP":
                if (this.blocks[y - 1][x] instanceof Player) {
                    System.out.println("mob eat player");
                    this.blocks[y - 1][x].setDirection("DEATH");
                    exit = true;
                } else if (move(x, y, "UP")) ;
                else if (move(x, y, "RIGHT")) ;
                else if (move(x, y, "LEFT")) ;
                else {
                    move(x, y, "DOWN");
                }
                break;
            case "DOWN":
                if (this.blocks[y + 1][x] instanceof Player){
                    System.out.println("mob eat player");
                    this.blocks[y - 1][x].setDirection("DEATH");
                    exit = true;
                }else if (move(x, y, "DOWN")) ;
                else if (move(x, y, "LEFT")) ;
                else if (move(x, y, "RIGHT")) ;
                else {
                    move(x, y, "UP");
                }
                break;
            case "LEFT":
                if (this.blocks[y][x - 1] instanceof Player){
                    System.out.println("mob eat player");
                    this.blocks[y - 1][x].setDirection("DEATH");
                    exit = true;
                }else if (move(x, y, "LEFT")) ;
                else if (move(x, y, "UP")) ;
                else if (move(x, y, "DOWN")) ;
                else {
                    move(x, y, "RIGHT");
                }
                break;
            case "RIGHT":
                if (this.blocks[y][x + 1] instanceof Player){
                    System.out.println("mob eat player");
                    this.blocks[y - 1][x].setDirection("DEATH");
                    exit = true;
                } else if (move(x, y, "RIGHT")) ;
                else if (move(x, y, "DOWN")) ;
                else if (move(x, y, "UP")) ;
                else {
                    move(x, y, "LEFT");
                }
                break;
        }
    }

    private boolean move(int x1, int y1, int x2, int y2) {
        if (this.blocks[y2][x2] instanceof Vide) {
            this.blocks[y2][x2] = this.blocks[y1][x1];
            this.blocks[y1][x1] = vide;
            if (y2 < y1)
                this.blocks[y2][x2].setDirection("UP");
            else
                this.blocks[y2][x2].setDirection("DOWN");
            if (x2 < x1)
                this.blocks[y2][x2].setDirection("LEFT");
            else
                this.blocks[y2][x2].setDirection("RIGHT");
            return true;
        }
        return false;
    }

    private boolean move(int x, int y, String direction) {
        switch (direction) {
            case "UP":
                if (this.blocks[y - 1][x] instanceof Vide) {
                    this.blocks[y - 1][x] = this.blocks[y][x];
                    this.blocks[y][x] = vide;
                    this.blocks[y - 1][x].setDirection(direction);
                    return true;
                }
                break;
            case "DOWN":
                if (this.blocks[y + 1][x] instanceof Vide) {
                    this.blocks[y + 1][x] = this.blocks[y][x];
                    this.blocks[y][x] = vide;
                    this.blocks[y + 1][x].setDirection(direction);
                    return true;
                }
                break;
            case "LEFT":
                if (this.blocks[y][x - 1] instanceof Vide) {
                    this.blocks[y][x - 1] = this.blocks[y][x];
                    this.blocks[y][x] = vide;
                    this.blocks[y][x - 1].setDirection(direction);
                    return true;
                }
                break;
            case "RIGHT":
                if (this.blocks[y][x + 1] instanceof Vide) {
                    this.blocks[y][x + 1] = this.blocks[y][x];
                    this.blocks[y][x] = vide;
                    this.blocks[y][x + 1].setDirection(direction);
                    return true;
                }
                break;
        }
        return false;
    }
}



