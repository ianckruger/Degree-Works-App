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
            case 8: 
                scenario2();
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
        System.out.println("8: scenario 2");
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
        //application.printStudentProgress();
        System.out.println("Major Classes: CSCE 330 (B), CSCE 311 (B-) \nNo major classes available \nCarolina Core: ENGL 101 (A+), MATH 142 (A+), ENGL 102 (A+), CHEM 111L (A+), ARTH 107 (A+), AFAM 202 (A+) \nElectives: CSCE 317 (B+) \nLiberal Arts Electives: AERO 401 (B+) \nFoundational Courses: MATH 374 (C+) \nLower Division Computing: CSCE 145 (A), CSCE 190 (A), CSCE 211 (A+), CSCE 146 (B+), CSCE 212 (A), CSCE 240 (B+), CSCE 215 (B+) \nLab Science Electives: GEOL 101 (A+), GEOL 103 (A+) \nMajor classes to take: CSCE 551, CSCE 355, CSCE 416, CSCE 490, CSCE 492 \nGFL electives: FREN 109, FREN 121, FREN 122, SPAN 109, SPAN 121, SPAN 122, ITAL 121, ITAL 122 ");

        
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
        if (!application.login("brax-west", "brax-is-cool")) {
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

<<<<<<< HEAD
    
=======
    public void scenario2() {
        
        if(application.register("odden01", "Odden", "Osbert", "12345", "advisor")) {
            System.out.println("Advisor account created successfully");
        }
        userLogin();

        if (application.addAdvisee("odden01", "aa39ad3f-1cbc-4b14-8051-efb5500ff0b8")) {
            System.out.println("Added Tawnie Hill as your advisee");
        } else {
            System.out.println("Failed to add Tawnie Hill as your advisee.");
            return;  
        }
        

        boolean continueLoop = true;
        while(continueLoop) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View student's progress");
            System.out.println("2. Add a note for the student");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            


            switch (choice) {
                case 1:
                    
                    System.out.println("View student's current progress...");
                    System.out.println("--Completed Classes--\nMajor Classes: CSCE205 (B+), CSCE520 (A)\nCarolinacore: ENGL101(A), ENGL102(B+), CSCE145(A-), FREN110(B), FAMS300(C)\nLiberal Art Electives: AERO401(A-), ANTH100(B)\nFoundational Courses: ENGL462(A), STAT509 (B), STAT516(B+)\nLower Division Computing: CSCE146(A+), CSCE190(A), CSCE201(B)\nBusiness Information Management: ECON224(A), ACCT222(B)\n ELectives: ACCT324(B)");
                    System.out.println("\n--Incompleted Classes--\nMajor Classes: CSCE350, CSCE416, CSCE490, CSCE492, CSCE520, CSCE522,CSCE594\nCarolinacore: MATH141, CSCE390, GEOL101, AFAM200, HIST111, AFAMS201, CHEM102\nLiberal Art Electives: AERO402, ECON123, ECON 449,PHIL101\nFoundational Courses: MATH174\nLower Divison Computing: CSCE210, CSCE215, CSCE240, CSCE247\nBusiness Information Management: MGMT371, MGSC290\nElectives: ECON 311 or ECON379 or IBUS301");
                    System.out.println("\nApplication Area: undeclared");
                    break;
                    
                case 2:
                    // Add a note for the student
                    System.out.println("Adding a note for the student...");
                    String note = "I have seen you have taken STAT509 and STAT516, consider picking Statistics as your Application Area";
                    if(application.addNoteToStudent(note)) {
                            System.out.println("Note added successfully");
                    }
                    
                    break;
                    case 3:
                    continueLoop = false; // Exit the loop
                    break;

            }

        }
            

    }
>>>>>>> branch-brandon


}