package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int maxWater;
    int maxBeans;
    int maxMilk;
    int maxCoffee = 0;
    int numberOfCoffee;
    int water;
    int milk;
    int beans;
    int cups;
    int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        coffeeMachine.calculateMax();
        coffeeMachine.prompt();

    }

    private void calculateMax() {
        this.maxWater = water / 200;
        this.maxMilk = milk / 50;
        this.maxBeans = beans / 15;

        if (maxWater < maxMilk && maxWater < maxBeans) {
            maxCoffee = maxWater;
        } else if (maxMilk <= maxBeans) {
            maxCoffee = maxMilk;
        }else if (maxBeans <= maxMilk){
            maxCoffee = maxBeans;
        }
    }

    private void prompt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit)");
        String input = scanner.next();

        while(!input.equals("exit")) {

            switch (input) {
                case "buy":
                    this.buy();
                    break;
                case "fill":
                    this.fill();
                    break;
                case "take":
                    this.take();
                    break;
                case "remaining":
                    this.printStatus();
                    break;
                case "exit":
                    System.exit(10);
            }

            System.out.println("Write action (buy, fill, take, remaining, exit)");
            input = scanner.next();
        }
    }

    private void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.cups += scanner.nextInt();
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String selection = scanner.next();

        switch(selection) {
            case "1":
                if(water - 250 >= 0 && beans - 16 >= 0) {
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee");
                }else{
                    if(water - 250 < 0) {
                        System.out.println("Sorry, not enough water!");
                    }

                    if( beans - 16 < 0) {
                        System.out.println("Sorry, not enough beans!");
                    }
                }

                break;
            case "2":
                if(water - 350 >= 0 && milk - 75 >= 0 && beans - 20 >= 0) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee");
                }else{
                    if(water - 350 < 0) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if(milk - 75 < 0) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if( beans - 20 < 0) {
                        System.out.println("Sorry, not enough beans!");
                    }
                }

                break;
            case "3":
                if(water - 200 >= 0 && milk - 100 >= 0 && beans - 12 >= 0) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee");
                }else{
                    if(water - 200 < 0) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if(milk - 100 < 0) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if( beans - 12 < 0) {
                        System.out.println("Sorry, not enough beans!");
                    }

                }
                break;
            case "back":
                return;

        }

    }

    private void printStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");

    }
}
