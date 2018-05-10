import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();

    public HashMap<String, Integer> popularity;

    
    public void sortPopularity()
    {

    }

    public void compilePopularity()
    {
        
        for(Student s : masterList)
        {
            int pop = 0;
            String name = s.getName();
            for(Student ss: masterList)
            {
                
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
