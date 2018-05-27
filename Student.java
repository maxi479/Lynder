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
        ratings = new HashMap<String, Integer>();
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
        ratings = new HashMap<String, Integer>();
    }


    /**
     * creates and updates map from master array
     */
    public void updateMap()
    {
        ArrayList<Student> temp = Lynder.getMasterList();
        for ( Student s : temp )
        {
            ratings.put( s.getName(), 0 );
        }
    }


    /**
     * input rating for a particular student 
     * @param name string
     * @param rating 1-5
     */
    public void rateInput( String name, int rating )
    {
        ratings.put( name, rating );
    }


    /**
     * get the rating of any rated student that this student has rated
     * 
     * @param name
     * @return int from 1-5
     */
    public int getRating( String name )
    {
        if(!ratings.containsKey( name ))
        {
        return 0;
        }
        else
        {
            return ratings.get(name);
        }
    }


    /**
     * after been added to a group remove them from the lsit of ratings
     * @param name
     */
    public void remove( String name )
    {
        ratings.remove( name );
    }


    /**
     * tells whether or not the student has rated others write code for input
     * here
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


    public HashMap<String, Integer> returnArray()
    {
        return ratings;
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


    public String toString()
    {
        return getName();

    }

}