class Student {
    private String studentId;
    private String name;
    private String mealPlan;
   

    public Student(String studentId, String name, String mealPlan) {
        // Constructor logic
        this.studentId = studentId;
        this.name = name;
        this.mealPlan=mealPlan;
    }
  
        public void registerMeal(Sring meal) {
        // Logic to register a meal for the student
                
    }

    public void cancelMeal(String meal) {
        // Logic to cancel a meal for the student

    }

    public double calculateMonthlyFee() {
        // Logic to calculate the monthly fee based on the meal plan
        return 5;
    }
}

class Meal {
    private String mealId;
    private String date;

    public Meal(String mealId, String date) {
        // Constructor logic
    }
}

public class Project{
    public static void main(String[] args) {
        
    }
}