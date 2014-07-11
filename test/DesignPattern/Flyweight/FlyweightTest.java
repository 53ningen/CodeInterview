package DesignPattern.Flyweight;

import org.junit.Test;

public class FlyweightTest {
    @Test
    public void flyweightTest() {
        BigString bigString = new BigString("0");
        bigString.print();
    }

}