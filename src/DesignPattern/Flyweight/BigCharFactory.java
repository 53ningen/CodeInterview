package DesignPattern.Flyweight;

import java.util.HashMap;

public class BigCharFactory {
    private HashMap<Character, BigChar> pool = new HashMap();
    private static BigCharFactory singleton = new BigCharFactory();
    private BigCharFactory(){}

    public static BigCharFactory getInstance() {
        return singleton;
    }
    public synchronized BigChar getBigChar(char charname) {
        BigChar bigChar = pool.get(charname);
        if(bigChar == null) {
            bigChar = new BigChar(charname);
            pool.put(charname,bigChar);
        }
        return bigChar;
    }
}
