package DesignPattern.AbstractFactory.listfactory;

import DesignPattern.AbstractFactory.factory.Item;
import DesignPattern.AbstractFactory.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(
                "<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<h1>" + title + "</h1>" +
                "<ul>\n");

        Iterator it = content.iterator();
        while(it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append(
                "<ul>\n" +
                "<hr><address>" + author + "</address>" +
                "</body></html>\n");

        return buffer.toString();
    }
}
