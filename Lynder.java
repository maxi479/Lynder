import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();

    private  Map<String, Integer> popularity = new HashMap<String, Integer>();


    public void sortPopularity()
    {
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(popularity);
    }


    public void compilePopularity()
    {

        for ( Student s : masterList )
        {
            int pop = 0;
            String name = s.getName();
            for ( Student ss : masterList )
            {
                pop += ss.getRating( name );
            }
            popularity.put( name, pop );
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

}
