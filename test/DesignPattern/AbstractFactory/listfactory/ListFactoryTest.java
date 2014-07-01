package DesignPattern.AbstractFactory.listfactory;

import DesignPattern.AbstractFactory.factory.Factory;
import DesignPattern.AbstractFactory.factory.Item;
import DesignPattern.AbstractFactory.factory.Page;
import DesignPattern.AbstractFactory.factory.Tray;
import org.junit.Test;

public class ListFactoryTest {
    @Test
    public void Test() {
        Factory factory = Factory.getFactory("DesignPattern.AbstractFactory.listfactory.ListFactory");
        Item asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
        Item yomiuri = factory.createLink("読売新聞", "http://wwww.yomiuri.co.jp/");
        Item us_yahoo = factory.createLink("Yahoo! UN", "http://www.yahoo.com/");
        Item jp_yahoo = factory.createLink("Yahoo! Japan", "http://www.yahoo.co.jp");

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