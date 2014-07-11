package DesignPattern.Memento;

import org.junit.Test;

public class MementoTest {
    @Test
    public void mementoTest() {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for(int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("現状:" + gamer);

            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円になりました．");
            if(gamer.getMoney() > memento.getMoney()) {
                System.out.println("(snapshoted...)");
                memento = gamer.createMemento();
            }
            else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("(loaded...)");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }

}