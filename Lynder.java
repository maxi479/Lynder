import java.util.*;


// this will be the classroom class
public class Lynder
{
    public static ArrayList<Student> masterList = new ArrayList<Student>();


    public void sortPopularity()
    {

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
