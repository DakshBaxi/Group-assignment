import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import java.time.DayOfWeek;

class MainWindow {
    public void MainMenu() {
        System.out.println("\n--------------------------Menu-----------------------------");
        System.out.println("                      1. Display Menu");
        System.out.println("                      2. Display Pass Details");
        System.out.println("                      3. Buy Passes");
        System.out.println("                      4. Admin Login");
        System.out.println("                      5. New Entry");
        System.out.println("                      6. Daily Entry");
        System.out.println("                      0. Exit");
        System.out.print("Enter your choice:");
    }

    public void AdminLogin() {

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
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Display the current day of the week
        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("Day: " + dayOfWeek);

        // You can also format the date as per your requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println("Date: " + formattedDate);
    }

    public void AutomaticMenuViewer() {

        // Define menus for each day
        String MondayMenu = "Monday    :  Dish A Dish B Dish C";
        String TuesdayMenu = "Tuesday   : Dish X Dish Y Dish Z";
        String WednesdayMenu = "Wednesday : Dish P Dish Q Dish R";
        String ThursdayMenu = "Thursday  : Dish M Dish N Dish O";
        String FridayMenu = "Friday    : Dish J Dish K Dish L";
        String SaturdayMenu = "Saturday  : Dish U Dish V Dish W";
        String SundayMenu = "Sunday    : Special Dish 1 Special Dish 2 Special Dish 3";

        System.out.println("---------------------------Weekly Menu----------------------------");
        System.out.println("                     " + MondayMenu);
        System.out.println("                     " + TuesdayMenu);
        System.out.println("                     " + WednesdayMenu);
        System.out.println("                     " + ThursdayMenu);
        System.out.println("                     " + FridayMenu);
        System.out.println("                     " + SaturdayMenu);
        System.out.println("                     " + SundayMenu);
    }
}

public class MessManager {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        MenuAndDate mnd = new MenuAndDate();
        MainWindow mw = new MainWindow();
        System.out.println("------------------------College Mess Manager--------------------------");
        mnd.DisplayDateAndDay();

        int choice;
        // mnd.AutomaticMenuViewer();
        do {
            mw.MainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    mnd.AutomaticMenuViewer();
                    break;
                case 2:
                    mw.PassDetail();
                    break;

            }
        } while (choice != 0);
    }

}
