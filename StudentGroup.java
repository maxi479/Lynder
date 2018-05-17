import java.util.*;

public class StudentGroup
{
    public ArrayList<Student> group = new ArrayList<Student>();
    private boolean completeGroup;
    
    public StudentGroup()
    {
        
    }
    
    public Student getNth(int n)
    {
        return group.get( n );
    }
    
    public boolean complete()
    {
        return completeGroup;
    }

}
