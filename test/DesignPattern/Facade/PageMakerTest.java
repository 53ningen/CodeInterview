package DesignPattern.Facade;

import org.junit.Test;

public class PageMakerTest {
    @Test
    public void PageMakerTest() {
        PageMaker.makeWelcomePage("yuki_yanagi@dwango.co.jp", "welcome.html");
    }
}