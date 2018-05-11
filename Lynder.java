import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();

    public HashMap<Integer, String> popularity;


    public void sortPopularity()
    {

    }


    /**
     * creates a hashmap with poparity
     */
    public void compilePopularity()
    {

        for ( Student s : masterList ) // for every single student
        {
            int pop = 0; 
            String name = s.getName();
            for ( Student ss : masterList ) // every student's rating of this single student
            {
                pop += ss.getRating( name ); // adding up all the ratings
            }
            popularity.put( pop, name ); // put it into the hashmap
        }
    }


    public static void addNewStud( Student student )

    {
        masterList.add( student );
    }


    public static ArrayList<Student> getMasterList()
    {
        return masterList;
    }
    
    public HashMap<Integer, String> getPopularityList()
    {
        return popularity;
    }

}
