import java.util.*;


public class StudentGroup
{
    public ArrayList<Student> group = new ArrayList<Student>();

    private boolean completeGroup;

    public int size;


    public StudentGroup()
    {
        completeGroup = false;
        size = Lynder.getGroupSize();
        
    }


    /**
     * gets the nth student
     * 
     * @param n
     * @return
     */
    public Student getNth( int n )
    {

        return group.get( n );

    }


    public void addStudent( Student s )
    {
        group.add( s );

    }


    /**
     * TODO Write your method description here.
     * @param i
     * @param s
     */
    public void addStudent( int i, Student s )
    {
        // make this shit work so that it adds a student if there is nothing at the index and replaces the student if there is a student there
        group.add( i, s );
    }


    public boolean complete()
    {
        if ( group.size() == size )
        {
            return true;
        }
        return false;
    }


    public ArrayList<Student> returnArray()
    {
        return group;
    }


    public void removeTemp( int i )
    {
        group.remove( i );
    }


    public String toString()
    {
        String s = "";
        for ( Student stud : group )
        {
            s = stud.getName() + " ";
        }
        return s;
    }

}