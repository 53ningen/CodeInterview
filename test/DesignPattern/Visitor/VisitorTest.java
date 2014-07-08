package DesignPattern.Visitor;

import org.junit.Test;

public class VisitorTest {
    @Test
    public void VisitorPatternテスト() {
        System.out.println("Making root entries...");
        Dir rootdir = new Dir("root");
        Dir bindir = new Dir("bin");
        Dir tmpdir = new Dir("tmp");
        Dir usrdir = new Dir("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));
        rootdir.accept(new ListVisitor());

    }
}