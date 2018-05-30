import java.util.*;


public class StudentGroup
{
    public ArrayList<Student> group = new ArrayList<Student>();

    @SuppressWarnings("unused")
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


    /**
     * add student to the group
     * @param s
     */
    public void addStudent( Student s )
    {
        group.add( s );

    }


    /**
     * TODO Write your method description here.
     * 
     * @param i
     * @param s
     */
    public void addStudent( int i, Student s )
    {
        // make this shit work so that it adds a student if there is nothing at
        // the index and replaces the student if there is a student there
        if ( group.size() - 1 >= i )
        {
            group.set( i, s );
        }
        else
        {
            group.add( s );
        }

    }


    /**
     * we dont need this
     * @return true or false
     */
    public boolean complete()
    {
        if ( group.size() == size )
        {
            return true;
        }
        return false;
    }


    /**
     * returns final array
     * @return group
     */
    public ArrayList<Student> returnArray()
    {
        return group;
    }


    /**
     * remove person i in the student group
     * @param i
     */
    public void removeTemp( int i )
    {
        if ( group.size() > i )
        {
            group.remove( i );
        }

    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        String s = "";
        for ( Student stud : group )
        {
            s += stud.getName() + " ";
        }
        return s;
    }

}