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
        for ( Student s : temp )
        {
            ratings.put( s.getName(), 0 );
        }
    }


    public void rateInput( String name, int rating )
    {
        if ( rating < 0 || rating > 5 )
        {
            throw new NullPointerException();
        }
        ratings.put( name, rating );
    }


    /**
     * get the rating of any rated student that this student has rated
     * @param name
     * @return int from 1-5
     */
    public int getRating( String name )
    {
        return ratings.get( name );
    }
    
    public void remove(String name)
    {
        ratings.remove( name );
    }
    

    /**
     * tells whether or not the student has rated others
     *  write code for input
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

}
