package DesignPattern.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList();
    private Random random = new Random();
    private static String[] fruitsname = {"リンゴ", "ぶどう", "バナナ", "みかん"};
    public Gamer(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if(dice == 1) {
            money += 100;
            System.out.println("所持金が増えました");
        }
        else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました");
        }
        else if (dice == 6) {
            String f = getFruits();
            System.out.println("フルーツ " + f + "を貰いました");
            fruits.add(f);
        }
        else {
            System.out.println("何も起こりませんでした．");
        }
    }
    public Memento createMemento() {
        Memento m = new Memento(money);
        for(String s: fruits) {
            if(s.startsWith("おいしい"))
                m.addFruit(s);
        }
        return m;
    }
    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
    public String getFruits() {
        String prefix = "";
        if(random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
