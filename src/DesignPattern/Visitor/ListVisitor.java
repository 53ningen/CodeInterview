package DesignPattern.Visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }
    public void visit(Dir dir) {
        System.out.println(currentdir + "/" + dir);
        String savedir = currentdir;
        currentdir = currentdir + "/" + dir.getName();
        Iterator<Entry> it = dir.iterator();
        while(it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
