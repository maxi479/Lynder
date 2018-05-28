import java.util.ArrayList;
import org.junit.Test;

import junit.framework.TestCase;


public class LynderJUnitTest extends TestCase
{

    @Test
    public void testLynderConstructor()
    {
        Lynder lyn = new Lynder( 2 );
        assertNotNull( lyn );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testTopStudent()
    {
        Lynder lyn = new Lynder( 2 );
        lyn.popularity.put( 0, "denver" );
        // System.out.println( lyn.topStudent() );
        assertEquals( lyn.popularity.get( 0 ), lyn.topStudent() );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testCompilePopularity()
    {
        Lynder lyn = new Lynder( 2 );
        ArrayList<Student> test = new ArrayList<Student>();
        // System.out.println( test );
        Student denver = new Student( "Denver", 4.0 );
        test.add( denver );
        // System.out.println( lyn.masterList );
        // System.out.println( test );
        assertFalse( lyn.masterList == test );
    }


     @SuppressWarnings("static-access")
     @Test
     public void testMakeGroup()
     {
     Lynder lyn = new Lynder( 2 );
     Lynder lyn2 = lyn;
     lyn.makeGroup();
     assertEquals( lyn, lyn2 );
     }

    @SuppressWarnings("static-access")
    @Test
    public void testGroupAvg()
    {
        Lynder lyn = new Lynder( 2 );
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        Student peyton = new Student( "Peyton", 3.0 );
        Student daniel = new Student( "Daniel", 3.0 );
        denver.rateInput( "Anson", 5 );
        denver.rateInput( "Peyton", 1 );
        denver.rateInput( "Daniel", 1 );
        anson.rateInput( "Denver", 5 );
        anson.rateInput( "Peyton", 1 );
        anson.rateInput( "Daniel", 1 );
        peyton.rateInput( "Denver", 1 );
        peyton.rateInput( "Anson", 1 );
        peyton.rateInput( "Daniel", 5 );
        daniel.rateInput( "Denver", 1 );
        daniel.rateInput( "Anson", 1 );
        daniel.rateInput( "Peyton", 5 );
        // System.out.println(denver.returnArray());
        // System.out.println( anson.returnArray() );
        // System.out.println( peyton.returnArray() );
        // System.out.println( daniel.returnArray() );
        StudentGroup sg = new StudentGroup();
        StudentGroup sg2 = new StudentGroup();
        sg.addStudent( denver );
        sg.addStudent( anson );
        sg2.addStudent( peyton );
        sg2.addStudent( daniel );
        // System.out.println( lyn.groupAvg( sg ) );
        // System.out.println( lyn.groupAvg( sg2 ) );
        assertTrue( lyn.groupAvg( sg ) == lyn.groupAvg( sg2 ) );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testPrint()
    {
        Lynder lyn = new Lynder( 2 );
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        Student peyton = new Student( "Peyton", 3.0 );
        Student daniel = new Student( "Daniel", 3.0 );
        StudentGroup sg = new StudentGroup();
        StudentGroup sg2 = new StudentGroup();
        sg.addStudent( denver );
        sg.addStudent( anson );
        sg2.addStudent( peyton );
        sg2.addStudent( daniel );
        lyn.finalList.add( sg );
        lyn.finalList.add( sg2 );
        lyn.print();
        assertTrue( lyn.finalList.contains( sg ) && lyn.finalList.contains( sg2 ) );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testRemoveAll()
    {
        Lynder lyn = new Lynder( 2 );
        Student denver = new Student( "Denver", 4.0 );
        lyn.masterList.add( denver );
        // System.out.println( lyn.masterList );
        lyn.removeAll( "Denver" );
        // System.out.println( lyn.masterList );
        assertTrue( !lyn.masterList.contains( denver ) );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testGetGroupSize()
    {
        Lynder lyn = new Lynder( 2 );
        assertEquals( 2, lyn.getGroupSize() );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testAddNewStud()
    {
        Lynder lyn = new Lynder( 2 );
        Student denver = new Student( "Denver", 1.0 );
        lyn.addNewStud( denver );
        // System.out.println( lyn.getMasterList() );
        assertTrue( lyn.masterList.contains( denver ) );
        lyn.masterList.remove( denver );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testGetMasterList()
    {
        Lynder lyn = new Lynder( 2 );
        // System.out.println( lyn.getMasterList());
        Student denver = new Student( "Denver", 4.0 );
        lyn.masterList.add( denver );
        assertTrue( lyn.getMasterList().contains( denver ) );
        lyn.masterList.remove( denver );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testGetPopularityList()
    {
        Lynder lyn = new Lynder( 2 );
        lyn.popularity.put( 0, "Denver" );
        // System.out.println( lyn.popularity );
        assertTrue( lyn.getPopularityList().get( 0 ).equals( "Denver" ) );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testGetPopularity()
    {
        Lynder lyn = new Lynder( 2 );
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        denver.rateInput( "Anson", 5 );
        anson.rateInput( "Denver", 5 );
        lyn.popularity2.put( "Denver", 5 );
        // System.out.println( lyn.getPopularity( "Denver" ) );
        assertEquals( 5, lyn.getPopularity( "Denver" ) );
    }


    @SuppressWarnings("static-access")
    @Test
    public void testIterator()
    {
        Lynder lyn = new Lynder( 2 );
        lyn.iterator();
        // System.out.println( lyn.i );
        assertEquals( 2, lyn.i );
    }
}
