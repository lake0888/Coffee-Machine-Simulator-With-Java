package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //INIT COFFEE MACHINE
        CMachine cMachine = new CMachine(400, 540, 120, 9, 550);
        showMenu(cMachine);
    }
    public static void showMenu(CMachine cMachine) {
        String action = "";
        while (!action.equals("exit")) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit)");
            action = scanner.next();
            switch (action) {
                case "buy" -> makeCoffee(cMachine);
                case "fill" -> fillCoffeeMachine(cMachine);
                case "take" -> {
                    System.out.printf("I gave you $%d%n", cMachine.getMoney());
                    cMachine.takeMoney();
                }
                case "remaining" -> System.out.println(cMachine.toString());
            }
        }
    }

    public static int initCoffeeMachine() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();

        return cupsOfCoffeeAllows(water, milk, beans);
    }

    public static int cupsOfCoffeeAllows(int water, int milk, int beans) {
        int cups = 0;
        while (water >= 200 && milk >= 50 && beans >= 15) {
            cups++;
            water -= 200;
            milk -= 50;
            beans -= 15;
        }
        return cups;
    }

    public static void showEstimate(int cupsOfCoffee, int cups) {
        if (cups == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups < cupsOfCoffee) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", cupsOfCoffee - cups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", cupsOfCoffee);
        }
    }

    public static void makeCoffee(CMachine cMachine) {
        String message = "Sorry, not enough %s!%n";
        String value = "";
        String type = "";
        boolean flag = true;
        while (flag) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

            type = scanner.next();

            switch (type) {
                case "1" -> {
                    if (cMachine.getWater() < 250)
                        value = "water";
                    else if (cMachine.getCoffeeBeans() < 16)
                        value = "coffee beans";
                    flag = false;
                }
                case "2" -> {
                    if (cMachine.getWater() < 350)
                        value = "water";
                    else if (cMachine.getMilk() < 75)
                        value = "milk";
                    else if (cMachine.getCoffeeBeans() < 20)
                        value = "coffee beans";
                    flag = false;
                }
                case "3" -> {
                    if (cMachine.getWater() < 200)
                        value = "water";
                    else if (cMachine.getMilk() < 100)
                        value = "milk";
                    else if (cMachine.getCoffeeBeans() < 12)
                        value = "coffee beans";
                    flag = false;
                }
                case "back" -> {
                    flag = false;
                }
                default -> flag = true;
            }
        }

        if (!value.isEmpty()) {
            System.out.printf(message, value);
        } else if (!type.equals("back")){
            cMachine.makeCoffee(Integer.parseInt(type));
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public static void fillCoffeeMachine(CMachine cMachine) {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();
        cMachine.addWater(water);

        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();
        cMachine.addMilk(milk);

        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeans = scanner.nextInt();
        cMachine.addCoffeeBeans(coffeeBeans);

        System.out.println("Write how many disposable cups you want to add:");
        int disposableCups = scanner.nextInt();
        cMachine.addDisposableCups(disposableCups);
    }

    public static void makeCoffee() {
        String makingCoffee = """
            Starting to make a coffee
            Grinding coffee beans
            Boiling water
            Mixing boiled water with crushed coffee beans
            Pouring coffee into the cup
            Pouring some milk into the cup
            Coffee is ready!""";
        System.out.println(makingCoffee);
    }

    public static void showRequiredIngredients(int cups) {
        int water = 200 * cups;
        int milk = 50 * cups;
        int beans = 15 * cups;
        System.out.printf("For %d cups of coffee you will need:%n", cups);
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", beans);
    }
}
