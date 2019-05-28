package dao;

public class Parameters<T> {

    private T obj;
    private TypeParameters typeParameters;

    public Parameters(final T obj, final TypeParameters typeParameters) {
        this.obj = obj;
        this.typeParameters = typeParameters;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getParameters() {
        return obj;
    }

    public TypeParameters getTypeParameters() {
        return typeParameters;
    }
}
