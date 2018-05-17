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
    
    public Student getNth(int n)
    {
        return group.get( n );
    }
 
    public void addStudent(Student s )
    {
        group.add( s );
    }
    
    
    public boolean complete()
    {       
        if( group.size() == size)
        {
            return true;
        }
        return false;
    }

}
