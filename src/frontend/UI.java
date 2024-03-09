package frontend;

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

        //application.startApplication();
    }
    

    public void run() {
        System.out.println("got here 2");
        int userChoice = displayMainMenu();
        System.out.println("got here 4");
        switch (userChoice) {
            case 1:
                System.out.println("Logging in...");
                scenario1();
                break;
            case 2:
                scenario2();
                break;
            case 3:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
        
    }

    public int displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println("Enter your choice:");

        int choice = scanner.nextInt();
        
        return choice;
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

  


    //For user to login
    public void loginUser() {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
    
        if (application.login(username, password)) {
            System.out.println("Login successful!");
            // Proceed with the application
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
    



    public boolean register(String userName, String password) {
        //return application.register(userName, password);
        return true;
    }

    public static void main(String[] args) {
        UI ui = new UI();
        System.out.println("got here 1");
        ui.run();
    }

}