package DesignPattern.AbstractFactory.listfactory;

import DesignPattern.AbstractFactory.factory.Item;
import DesignPattern.AbstractFactory.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(
               "<li>\n" +
               caption + "\n" +
               "<ul>\n");
        Iterator it = tray.iterator();
        while(it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append(
                "</ul>\n" +
                "</li>");

        return buffer.toString();
    }
}
