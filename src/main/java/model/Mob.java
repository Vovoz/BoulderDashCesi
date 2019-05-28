package model;

abstract class Mob  extends Block{
    public Mob(final int level){
        super(level);
        this.breakable = false;
    }
}
