package src.frontend;

import java.util.Scanner;

public class UI<RoadmapApplication> {
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
        scenario1();
        scenario2();
    }

    public void scenario1() {
        System.out.println();

        if (!application.login("cmcdavid", "9797")) {
            System.out.println("Username or Password is not correct.");
            return;
        }

        System.out.println("Connor is now logged in");
    }

}
