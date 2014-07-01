package DesignPattern.AbstractFactory.listfactory;

import DesignPattern.AbstractFactory.factory.Factory;
import DesignPattern.AbstractFactory.factory.Link;
import DesignPattern.AbstractFactory.factory.Page;
import DesignPattern.AbstractFactory.factory.Tray;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
