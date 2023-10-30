import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Student {
    private String name;
    private int daysRemaining;

    public Student(String name, int daysRemaining) {
        this.name = name;
        this.daysRemaining = daysRemaining;
    }
 public String getName() {
        return name;
    }
    

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Days Remaining in Meal Plan: " + daysRemaining);
    }

    public void decrementDays(int days) {
        if (daysRemaining >= days) {
            daysRemaining -= days;
            System.out.println("Deducted " + days + " days from the meal plan.");
        } else {
            System.out.println("Not enough days in the meal plan.");
        }
    }
}

class MainWindow {
    public void MainMenu() {
        System.out.println("\n--------------------------Menu-----------------------------");
        System.out.println("                      1. Display Menu");
        System.out.println("                      2. Display Details");
        System.out.println("                      3. Daily entry");
        System.out.println("                      4. Student Register");
        System.out.println("                      0. Exit");
        System.out.print("Enter your choice:");
    }

    public Student registerStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter the number of days in the meal plan: ");
        int daysRemaining = sc.nextInt();
        return new Student(name, daysRemaining);
    }

    public void PassDetail() {
        System.out.println("15 days plan - Rs." + (15 * 55) + "(Rs.55 per Pass)");
        System.out.println("30 days plan - Rs." + (30 * 50) + "(Rs.50 per Pass)");
        System.out.println("45 days plan - Rs." + (45 * 45) + "(Rs.45 per Pass)");
        System.out.println("60 days plan - Rs." + (60 * 45) + "(Rs.40 per Pass)");
    }
}

class MenuAndDate {
    public void DisplayDateAndDay() {
        LocalDate currentDate = LocalDate.now();
        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("Day: " + dayOfWeek);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println("Date: " + formattedDate);
    }

    public void AutomaticMenuViewer() {
        String MondayMenu = "Monday    :  Dish A Dish B Dish C";
        // Define menus for other days

        System.out.println("---------------------------Weekly Menu----------------------------");
        System.out.println("                     " + MondayMenu);
        // Display menus for other days
    }
}

public class Mess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuAndDate mnd = new MenuAndDate();
        MainWindow mw = new MainWindow();
        System.out.println("------------------------College Mess Manager--------------------------");
        mnd.DisplayDateAndDay();

        int choice;
        ArrayList<Student> students = new ArrayList<>(); // Store multiple students

        do {
            mw.MainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    mnd.AutomaticMenuViewer();
                    break;
                case 2:
                    if (!students.isEmpty()) {
                        for (Student student : students) {
                            student.displayInfo();
                        }
                    } else {
                        System.out.println("No students registered.");
                    }
                    break;
                case 3:
                    if (!students.isEmpty()) {
                        // You can choose a student to deduct days from their meal plan here
                        System.out.print("Enter the student name: ");
                        sc.nextLine(); // Consume the newline character
                        String studentName = sc.nextLine();
                        for (Student student : students) {
                            if (student.getName().equals(studentName)) {
                                System.out.print("Enter the number of days to deduct from the meal plan: ");
                                int daysToDeduct = sc.nextInt();
                                student.decrementDays(daysToDeduct);
                            }
                        }
                    } else {
                        System.out.println("No students registered.");
                    }
                    break;
                case 4:
                    students.add(mw.registerStudent());
                    break;
               
            }
        } while (choice != 0);
    }
}
