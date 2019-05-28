package dao;

public class RawElement {

    private ObjectType objectType;
    private int x;
    private int y;

    public RawElement(final ObjectType objectType, final int x, final int y) {
        this.objectType = objectType;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public ObjectType getObjectType() {
        return objectType;
    }
}
