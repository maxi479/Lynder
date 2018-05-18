import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();//b4 popularity

    public HashMap<Integer, String> popularity;//by popularity
    
    public HashMap<String, Integer> popularity2;//by name
    
    public HashMap<String, Student> masterList2 = new HashMap<String, Student>();
    
    public ArrayList<StudentGroup> finalList = new ArrayList<StudentGroup>();

    public static int groupSize;


    public Lynder( int size )
    {
        groupSize = size;
    }


    public void sortPopularity()
    {
        Map<Integer, String> treeMap = new TreeMap<Integer, String>( new Comparator<Integer>()
        {

            @Override
            public int compare( Integer o1, Integer o2 )
            {
                return o2.compareTo( o1 );
            }

        } );

        /*
         * For Java 8, try this lambda Map<Integer, String> treeMap = new
         * TreeMap<>( (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1) );
         */
        treeMap.putAll( popularity );
    }


    /**
     * creates a hashmap with poparity
     */
    public void compilePopularity()
    {
        // this is to make the popularity map
        for ( Student s : masterList ) // for every single student
        {
            int pop = 0;
            String name = s.getName();
            for ( Student ss : masterList ) // every student's rating of this
                                            // single student
            {
                pop += ss.getRating( name ); // adding up all the ratings
            }
            popularity.put( pop, name ); // put it into the hashmap
        }
        for ( Student s : masterList ) // for every single student
        {
            int pop = 0;
            String name = s.getName();
            for ( Student ss : masterList ) // every student's rating of this
                                            // single student
            {
                pop += ss.getRating( name ); // adding up all the ratings
            }
            popularity2.put(name, pop); // put it into the hashmap
        }
        //this is just for another copy map making our lives easier
        for ( Student s : masterList ) // for every single student
        {
            
            masterList2.put( s.getName(), s );
        }
    }
    
    


    public void makeGroup()
    {
        while ( !popularity.isEmpty() )
        {
             String str = popularity.getTop();
             Student s = masterList2.get( str );
             StudentGroup temp = new StudentGroup();
             for(int i = 0; i < groupSize; i++)
             {
                 
             }
             
             finalList.add( temp );
        }
        
    }
    
    /**
     * remove every instance of this student everywhere where they exist
     * @param str
     */
    public void removeAll(String str)
    {
        Student stu = masterList2.get( str );
        int pop = popularity2.get( str );
        for(Student s : masterList)
        {
            s.remove( str );
        }
        masterList.remove( stu );
        masterList2.remove( str );
        popularity.remove( pop );
        popularity2.remove( str );
        
    }
    
    public static int getGroupSize()
    {
        return groupSize;
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