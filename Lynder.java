import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();

    public HashMap<Integer, String> popularity;
    public int groupSize;
    
    public Lynder(int size)
    {
        groupSize = size;
    }
    
    public void sortPopularity()
    {
        Map<Integer, String> treeMap = new TreeMap<Integer, String>(
                        new Comparator<Integer>() {

                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o2.compareTo(o1);
                            }

                        });

                /* For Java 8, try this lambda
                Map<Integer, String> treeMap = new TreeMap<>(
                                (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
                        );
                */
                treeMap.putAll(popularity);
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
    public void makeGroup()
    {
        while(!popularity.isEmpty())
        {
            //take first one
            
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