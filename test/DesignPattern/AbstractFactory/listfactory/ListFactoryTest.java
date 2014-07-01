package DesignPattern.AbstractFactory.listfactory;

import DesignPattern.AbstractFactory.factory.*;
import org.junit.Test;

public class ListFactoryTest {
    @Test
    public void Test() {
        Factory factory = Factory.getFactory("DesignPattern.AbstractFactory.listfactory.ListFactory");
        Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
        Link yomiuri = factory.createLink("読売新聞", "http://wwww.yomiuri.co.jp/");
        Link us_yahoo = factory.createLink("Yahoo! UN", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo! Japan", "http://www.yahoo.co.jp");

        Tray traynews = factory.createTray("新聞");
        traynews.add(asahi);
        traynews.add(yomiuri);

        Tray traysearch = factory.createTray("サーチエンジン");
        traysearch.add(us_yahoo);
        traysearch.add(jp_yahoo);

        Page page = factory.createPage("Link", "gomi_ningen");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}