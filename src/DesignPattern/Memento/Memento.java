package DesignPattern.Memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;
    ArrayList fruits = new ArrayList();
    public int getMoney() {
        return money;
    }
    Memento(int money) {
        this.money = money;
    }
    void addFruit(String fruit) {
        fruits.add(fruit);
    }
    List getFruits() {
        return (List)fruits.clone();
    }
}
