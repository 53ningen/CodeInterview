package DesignPattern.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Dir extends Entry {
    private String name;
    private ArrayList<Entry> dir = new ArrayList<Entry>();
    public Dir(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        int size = 0;
        for(Entry entry: dir) {
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
    public Iterator<Entry> iterator() {
        return dir.iterator();
    }
}
