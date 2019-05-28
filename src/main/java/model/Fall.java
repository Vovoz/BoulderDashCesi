package model;

abstract public class Fall extends  Block{
    public Fall(int level) {
        super(level);
        this.fall = true;
    }
}
