package machine;

import java.util.Objects;

public class CMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addWater(int water) {
        setWater(this.water + water);
    }

    public void addMilk(int milk) {
        setMilk(this.milk + milk);
    }

    public void addCoffeeBeans(int coffeeBeans) {
        setCoffeeBeans(this.coffeeBeans + coffeeBeans);
    }

    public void addDisposableCups(int disposableCups) {
        setDisposableCups(this.disposableCups + disposableCups);
    }

    public void makeCoffee(int type) {
        switch (type) {
            case 1 -> {
                setWater(this.water - 250);
                setCoffeeBeans(this.coffeeBeans - 16);
                money += 4;
            }
            case 2 -> {
                setWater(this.water - 350);
                setMilk(this.milk - 75);
                setCoffeeBeans(this.coffeeBeans - 20);
                money += 7;
            }
            case 3 -> {
                setWater(this.water - 200);
                setMilk(this.milk - 100);
                setCoffeeBeans(this.coffeeBeans - 12);
                money += 6;
            }
        }
        this.disposableCups--;
    }

    public void takeMoney() {
        setMoney(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CMachine cMachine = (CMachine) o;
        return water == cMachine.water && milk == cMachine.milk && coffeeBeans == cMachine.coffeeBeans &&
                disposableCups == cMachine.disposableCups && money == cMachine.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(water, milk, coffeeBeans, disposableCups, money);
    }

    @Override
    public String toString() {
        return String.format("The coffee machine has:%n" +
                            "%d ml of water%n%d ml of milk%n" +
                            "%d g of coffee beans%n%d disposable cups%n" +
                            "$%d of money", water, milk, coffeeBeans, disposableCups, money);
    }
}
