package frontend;

import java.util.Scanner;

import backend.CourseList;
import backend.Roadmap;
import backend.User;
import backend.UserList;

public class UI {
    private Scanner scanner;
    private RoadmapApplication application;

    public UI() {
        this.scanner = new Scanner(System.in);
        this.application = new RoadmapApplication();
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }

    
    public void start() {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to the Roadmap Application.");

        //application.startApplication();
    }
    

    public void run() {
        int userChoice = displayMainMenu();
        switch (userChoice) {
            case 1:
                System.out.println("Logging in...");
                userLogin();
                break;
            case 2:
                userRegister();
                break;
            case 3:
                System.out.println("Exiting...");
                return;
            case 4:
                scenario3(); // Creating a Student Account
                break;
            case 5:
                scenario4(); // Creating a Parent Account
                break;
            case 6:
                scenario5(); // Creating an Advisor Account
                break;
            case 7:
                scenario1(); // Running scenario 1
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
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

    public void userLogin() {
        scanner.nextLine();
        System.out.println("Enter a username:");
        String userName = scanner.nextLine();
        System.out.println("Enter a password:");
        String password = scanner.nextLine();

        if (!application.login(userName, password)) {
            System.out.println("Username or Password is not correct.");
            return;
        }
        
        System.out.println(userName+" is now logged in");
        application.printStudentProgress();

        
    }

    public void userRegister() {
        scanner.nextLine();
        while (true) {
            System.out.println("Enter a username for registration:");
            String userName = scanner.nextLine();
    
            // Check if the username is taken
            if (application.isUsernameTaken(userName)) {
                System.out.println("Username already exists. Please choose a different Username !");
                continue; // Continue to prompt for username input
            }
        
        System.out.println("Enter a password for registration:");
        String password = scanner.nextLine();
        System.out.println("Enter your first name for registration:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name for registration:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your User Type (Student/Parent/Advisor) for registration:");
        String userType = scanner.nextLine();
         
        if (register(userName, password, firstName, lastName, userType)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }

        if (!application.login(userName, password)) {
            System.out.println("Username or Password is not correct.");
            return;
        }
        

        System.out.println(firstName+ " is now logged in");
        break;
    }
     
}


    public void scenario3() {
        System.out.println("Creating a Student Account...");
        // Hard-coded student account details
        String userName = "seabass20";
        String firstName = "Sebastian";
        String lastName = "Aho";
        String password = "TheFish20!";
        String userType = "student";
        // Additional student details (e.g., GPA, year, current major) would go here
    
        if (application.register(userName, firstName, lastName, password, userType)) {
            System.out.println("Student account created successfully!");
        } else {
            System.out.println("Failed to create student account.");
        }
    }
    
    public void scenario4() {
        System.out.println("Creating a Parent Account...");
        // Hard-coded parent account details
        String userName = "lzenker";
        String firstName = "Lisa";
        String lastName = "Zenker";
        String password = "Peake21146!";
        String userType = "parent";
        // Additional parent details (e.g., children) would go here
    
        if (application.register(userName, firstName, lastName, password, userType)) {
            System.out.println("Parent account created successfully!");
        } else {
            System.out.println("Failed to create parent account.");
        }
    }
    
    public void scenario5() {
        System.out.println("Creating an Advisor Account...");
        // Hard-coded advisor account details
        String userName = "rkeafe";
        String firstName = "Ryanne";
        String lastName = "Keafe";
        String password = "Mrs.Advisor8829!";
        String userType = "advisor";
        // Additional advisor details (e.g., students advising) would go here
    
        if (application.register(userName, firstName, lastName, password, userType)) {
            System.out.println("Advisor account created successfully!");
        } else {
            System.out.println("Failed to create advisor account.");
        }
    }
    
    public boolean register(String userName, String password, String firstName, String lastName, String userType) {
        return application.register(userName, firstName, lastName, password , userType);
    }

    public void scenario1() {
        if (!application.login("braxwest", "westbrax")) {
            System.out.println("Sorry we couldn't log you in.");
        } else {
            System.out.println("Brax West is now logged in\nGenerating student's current progress...");

            if(application.printStudentProgress()) {
                System.out.println("Student's progress printed successfully.");
                
            }
            else {
                System.out.println("Failed to print student's progress.");
            }

        }


    }


}