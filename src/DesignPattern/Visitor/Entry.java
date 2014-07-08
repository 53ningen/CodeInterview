package DesignPattern.Visitor;

public abstract class Entry implements Element {
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws Exception {
        throw new Exception();
    }
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
