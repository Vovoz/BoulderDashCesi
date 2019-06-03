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

        Block wall = new Wall(this.level);
        Block dirt = new Dirt(this.level);
        Block diamond = new Diamond(this.level);
        Block player = new Player(level);



        for (int n = 0; map.charAt(n) != '$'; n++)
            this.xmax++;

        for (int n = 0; n < map.length(); n++)
            if (map.charAt(n) == '$')
                this.ymax++;


        this.blocks = new Block[this.ymax][this.xmax];




        exit = false;

        for (int n = 0; n < this.ymax; n++) {
            this.blocks[n][0] = new Wall(this.level);
            this.blocks[n][this.xmax - 1] = wall;
        }

        for (int i = 0; i < this.xmax; i++) {
            this.blocks[0][i] = new Wall(this.level);
            this.blocks[this.ymax - 1][i] = wall;
        }


        for (int n = 1; n < this.ymax - 1; n++) {
            for (int i = 1; i < this.xmax - 1; i++) {
                this.blocks[n][i] = dirt;
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
                        this.blocks[y][x] = wall;
                        break;
                    case 'd':
                        this.blocks[y][x] = diamond;
                        break;
                    case 'P':
                        this.blocks[y][x] =player;
                        this.xplayer = x;
                        this.yplayer = y;
                        break;
                    case 'X':
                        this.blocks[y][x] = dirt;
                        break;
                    case ' ':
                        this.blocks[y][x] = new Vide(level);
                        break;
                    case 'O':
                        this.blocks[y][x] = new Rock(level);
                        break;
                    default:
                        this.blocks[y][x] = dirt;


                }
                x++;
            }


        }


        this.blocks[9][9] = new Mob2(this.level);

        this.blocks[7][15] = new Player(this.level);

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
            this.blocks[yplayer][xplayer] = new Vide(this.level);
            this.yplayer += y;
            this.xplayer += x;
        } else {
            if (y == 0 && (this.blocks[yplayer][xplayer + x] instanceof Rock)) {
                if (this.blocks[yplayer][xplayer + x * 2] instanceof Vide) {
                    this.blocks[yplayer][xplayer + x * 2] = this.blocks[yplayer][xplayer + x];
                    this.blocks[yplayer][xplayer + x] = this.blocks[yplayer][xplayer];
                    this.blocks[yplayer][xplayer] = new Vide(this.level);
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
                if (this.blocks[n][i] instanceof Mob && !this.blocks[n][i].getUpdate())
                    updatemob(i, n);

        for (int n = this.ymax - 1; n >= 0; n--)
            for (int i = this.xmax - 1; i >= 0; i--)
                if (this.blocks[n][i] instanceof Mob)
                    this.blocks[n][i].setUpdate(false);
    }

    private void updateVide(int x, int y) {
        if (this.blocks[y - 1][x].getFall()) {
            this.updatefall(x, y - 1);
        }
        if (this.blocks[y - 1][x - 1].getFall()) {
            this.updatefall(x - 1, y - 1);
        }
        if (this.blocks[y - 1][x + 1].getFall()) {
            this.updatefall(x + 1, y - 1);
        }
    }

    private void updatefall(int x, int y) {

        if (move(x, y, x, y + 1)) {
            this.blocks[y + 1][x].setFalling(true);
            return;
        }
        if (this.blocks[y + 1][x].getFall() || this.blocks[y + 1][x] instanceof Wall) {
            if (this.blocks[y][x - 1] instanceof Vide)
                if (move(x, y, x - 1, y + 1)) {
                    this.blocks[y + 1][x + 1].setFalling(true);
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
        }

        if ((this.blocks[y + 1][x] instanceof Mob) && (this.blocks[y][x].getFalling())) {
            if (this.blocks[y + 1][x] instanceof Player)
                exit = true;
            this.blocks[y + 1][x] = new Diamond(this.level);

            if (this.blocks[y + 1][x + 1] instanceof Player)
                exit = true;
            this.blocks[y + 1][x + 1] = new Diamond(this.level);

            if (this.blocks[y + 1][x - 1] instanceof Player)
                exit = true;
            this.blocks[y + 1][x - 1] = new Diamond(this.level);

            if (this.blocks[y - 1][x] instanceof Player)
                exit = true;
            this.blocks[y - 1][x] = new Diamond(this.level);

            if (this.blocks[y - 1][x + 1] instanceof Player)
                exit = true;
            this.blocks[y - 1][x + 1] = new Diamond(this.level);

            if (this.blocks[y - 1][x - 1] instanceof Player)
                exit = true;
            this.blocks[y - 1][x - 1] = new Diamond(this.level);

            if (this.blocks[y][x] instanceof Player)
                exit = true;
            this.blocks[y][x] = new Diamond(this.level);

            if (this.blocks[y][x + 1] instanceof Player)
                exit = true;
            this.blocks[y][x + 1] = new Diamond(this.level);

            if (this.blocks[y][x - 1] instanceof Player)
                exit = true;
            this.blocks[y][x - 1] = new Diamond(this.level);
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
            this.blocks[y1][x1] = new Vide(this.level);
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
                    this.blocks[y][x] = new Vide(this.level);
                    this.blocks[y - 1][x].setDirection(direction);
                    return true;
                }
                break;
            case "DOWN":
                if (this.blocks[y + 1][x] instanceof Vide) {
                    this.blocks[y + 1][x] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide(this.level);
                    this.blocks[y + 1][x].setDirection(direction);
                    return true;
                }
                break;
            case "LEFT":
                if (this.blocks[y][x - 1] instanceof Vide) {
                    this.blocks[y][x - 1] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide(this.level);
                    this.blocks[y][x - 1].setDirection(direction);
                    return true;
                }
                break;
            case "RIGHT":
                if (this.blocks[y][x + 1] instanceof Vide) {
                    this.blocks[y][x + 1] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide(this.level);
                    this.blocks[y][x + 1].setDirection(direction);
                    return true;
                }
                break;
        }
        return false;
    }
}



