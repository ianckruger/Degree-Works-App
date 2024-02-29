package src.frontend;

import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private RoadmapApplication application;

    public UI() {
        this.scanner = new Scanner(System.in);
        this.application = new RoadmapApplication();
    }

    public void start() {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to the Roadmap Application.");

        application.startApplication();
    }

    public void run() {
        displayMainMenu();
        scenario1();
        scenario2();
    }

    public void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println("Enter your choice:");
    }

    public void scenario1() {
        System.out.println();

        if (!application.login("cmcdavid", "9797")) {
            System.out.println("Username or Password is not correct.");
            return;
        }

        System.out.println("Connor is now logged in");
    }

    public void scenario2() {
        System.out.println();

        System.out.println("Enter a username for registration:");
        String userName = "aovechkin";
        System.out.println("Enter a password for registration:");
        String password = "great8!";

        if (register(userName, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }

        if (!application.login("aovechkin", "great8!")) {
            System.out.println("Username or Password is not correct.");
            return;
        }

        System.out.println("Alex is now logged in");
    }

    }

    public boolean register(String userName, String password) {
        return application.register(userName, password);
    }
}
