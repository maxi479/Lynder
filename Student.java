import java.util.*;


public class Student
{
    // total added score from all other students
    private double popularity;

    // whether or not he has rated every other student in the class
    private boolean rated;

    // name of student
    private String name;

    // GPA of student
    private double GPA;

    // map of all students for rating, pull from array
    public HashMap<String, Integer> ratings;

    // priority queue of the ratings of other students
    public ArrayList<Integer> gee = new ArrayList<Integer>();


    /**
     * default constructor
     */
    public Student()
    {
        popularity = 0;
        rated = false;
        name = "";
        GPA = 0;
    }


    /**
     * constructor with parameters
     * 
     * @param fullName
     *            name
     * @param gradePointAvg
     *            GPA
     */
    public Student( String fullName, double gradePointAvg )
    {
        popularity = 0;
        rated = false;
        name = fullName;
        GPA = gradePointAvg;
    }


    /**
     * creates and updates map from master array
     */
    public void updateMap()
    {
        ArrayList<Student> temp = Lynder.getMasterList();
        for(Student s : temp)
        {
            ratings.put( s.getName(), 0 );
        }
    }
    public void rateInput(String name, int rating)
    {
        if(rating < 0 || rating > 5)
        {
            throw new NullPointerException();
        }
        ratings.put( name, rating );
    }

    /**
     * tells whether or not the student has rated others
     */
    public void ratedStudents()
    {
        rated = true;
    }


    /**
     * returns the name of the student
     * 
     * @return the name of the student
     */
    public String getName()
    {
        return name;
    }


    /**
     * returns the GPA of the student
     * 
     * @return the GPA of the student
     */
    public double getGPA()
    {
        return GPA;
    }
    
    public void sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int left = low;
        int right = high;
        int pivot = arr[mid]; // select middle element as pivot
        while (left <= right) {
            while (arr[left] < pivot)
                left++;// find element which is greater than pivot
            while (arr[right] > pivot)
                right--;// //find element which is smaller than pivot
            // System.out.println(arrA[left] + " " + pivot + " " + arrA[right]
            // );
            // if we found the element on the left side which is greater than
            // pivot
            // and element on the right side which is smaller than pivot
            // Swap them, and increase the left and right
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        // Recursion on left and right of the pivot
        if (low < right)
            sort(arr, low, right);
        if (left < high)
            sort(arr, left, high);
    }
}
