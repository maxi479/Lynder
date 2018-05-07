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
    private double gpa;

    // map of all students for rating, pull from array
    public HashMap<String, Integer> ratings;


    /**
     * default constructor
     */
    public Student()
    {
        popularity = 0;
        rated = false;
        name = "";
        gpa = 0;
    }


    public Student( String fullName, double gradePointAvg )
    {
        popularity = 0;
        rated = false;
        name = fullName;
        gpa = gradePointAvg;
    }


    /**
     * creates and updates map from master array
     */
    public void updateMap()
    {

    }


    public void rateStudents()
    {
        rated = true;
    }


    public String getName()
    {
        return name;
    }


    public double getGPA()
    {
        return gpa;
    }

}
