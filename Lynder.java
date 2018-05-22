import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();// b4
                                                                           // popularity

    public HashMap<Integer, String> popularity;// by popularity

    public HashMap<String, Integer> popularity2;// by name

    public HashMap<String, Student> masterList2 = new HashMap<String, Student>();

    public ArrayList<StudentGroup> finalList = new ArrayList<StudentGroup>();

    public Map<Integer, String> treeMap;

    public static int groupSize;


    public Lynder( int size )
    {
        groupSize = size;
    }


    // SORRY DARREN DONT NEED UR CODE
    // public void sortPopularity()
    // {
    // Map<Integer, String> treeMap = new TreeMap<Integer, String>( new
    // Comparator<Integer>()
    // {
    //
    // @Override
    // public int compare( Integer o1, Integer o2 )
    // {
    // return o2.compareTo( o1 );
    // }
    //
    // } );
    //
    // /*
    // * For Java 8, try this lambda Map<Integer, String> treeMap = new
    // * TreeMap<>( (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1) );
    // */
    // treeMap.putAll( popularity );
    // }

    public String topStudent()
    {
        int topPop = 0;
        for ( Map.Entry<Integer, String> s : popularity.entrySet() )
        {
            if ( topPop <= (int)s.getKey() )
            {
                topPop = (int)s.getKey();
            }
        }
        String s = popularity.get( topPop );
        return s;
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
            popularity2.put( name, pop ); // put it into the hashmap
        }
        // this is just for another copy map making our lives easier
        for ( Student s : masterList ) // for every single student
        {

            masterList2.put( s.getName(), s );
        }
    }


    public void makeGroup()
    {
        while ( !popularity.isEmpty() )
        {
            String str = topStudent();
            Student top = masterList2.get( str );
            StudentGroup temp = new StudentGroup();
            temp.addStudent( top );

            removeAll( str );
            for ( int i = 0; i < groupSize; i++ )
            {

                String name = "";
                for ( Student s : masterList )
                {
                    int avg = 0;
                    name = s.getName();
                    temp.addStudent( s );
                    if ( groupAvg( temp ) > avg )
                    {
                        avg = groupAvg( temp );
                        break;

                    }
                    else
                    {
                        temp.removeTemp();
                    }
                }

                removeAll( name );

            }

            finalList.add( temp );
        }

    }


    public int groupAvg( StudentGroup sg )
    {
        int sum = 0;
        int size = sg.returnArray().size();
        for ( Student s : sg.returnArray() )
        {
            for ( Student st : sg.returnArray() )
            {
                String stu = st.getName();
                sum += s.getRating( stu );
            }
        }
        return sum / size;
    }


    public void print( ArrayList<StudentGroup> input )
    {
        for ( StudentGroup s : input )
        {
            for ( Student stu : s.returnArray() )
            {
                System.out.print( stu.getName() );
            }
            System.out.println();
        }
    }


    /**
     * remove every instance of this student everywhere where they exist
     * 
     * @param str
     */
    public void removeAll( String str )
    {
        Student stu = masterList2.get( str );
        int pop = popularity2.get( str );
        for ( Student s : masterList )
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


    public int getPopularity( String name )
    {
        return popularity2.get( name );
    }


    public static void main( String[] args )
    {
        Lynder main = new Lynder( 2 );
        main.addStudents();
        LynderUI dar = new LynderUI();
        dar.createAndShow();
        for ( Student s : masterList )
        {
            LynderUI_2 temp = new LynderUI_2( s );

        }
    }


    public void addStudents()
    {
        masterList.add( new Student( "Washwin", 4.0 ) );
        masterList.add( new Student( "Wandrew", 4.0 ) );
        masterList.add( new Student( "Wames", 6.0 ) );
        masterList.add( new Student( "Winja", 4.0 ) );
        masterList.add( new Student( "Waya", 3.5 ) );
        masterList.add( new Student( "Wanusha", 4.0 ) );
        masterList.add( new Student( "Woshua", 4.0 ) );
        masterList.add( new Student( "Wiroki", 3.9 ) );
        masterList.add( new Student( "Wichard", 3.5 ) );
        masterList.add( new Student( "Wrish", 2.0 ) );
        masterList.add( new Student( "Wason", 4.0 ) );
        masterList.add( new Student( "Wai", 3.8 ) );
        masterList.add( new Student( "WindianWirl", 3.6 ) );
        masterList.add( new Student( "Wasta", 3.4 ) );
        masterList.add( new Student( "Wrace", 3.0 ) );
        masterList.add( new Student( "Wottem", 1.0 ) );
        masterList.add( new Student( "Wian", 3.9 ) );
        masterList.add( new Student( "Warren", 3.9 ) );
        masterList.add( new Student( "Waxwell", 4.0 ) );
        masterList.add( new Student( "Wamol", 4.0 ) );
        masterList.add( new Student( "Warles", 3.8 ) );
        masterList.add( new Student( "Wansen", 4.0 ) );
        masterList.add( new Student( "Wason2", 3.0 ) );
        masterList.add( new Student( "WindianWoy", 3.8 ) );
        masterList.add( new Student( "WindianWirl2", 3.0 ) );
        masterList.add( new Student( "Wangela", 3.7 ) );
        masterList.add( new Student( "WasianWirl", 3.6 ) );
        masterList.add( new Student( "WasianWirl2", 3.0 ) );
        masterList.add( new Student( "Lishika", 3.8 ) );
        masterList.add( new Student( "Lishita", 3.9 ) );
        masterList.add( new Student( "Illiam", 4.0 ) );
        masterList.add( new Student( "WindianWirl5", 3.0 ) );
    }

}
