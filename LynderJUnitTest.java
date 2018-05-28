import java.util.ArrayList;
import org.junit.Test;

import junit.framework.TestCase;


public class LynderJUnitTest extends TestCase
{

    // Lynder tests
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


    // Student tests
    @Test
    public void testStudentConstructorNoParams()
    {
        Student denver = new Student();
        assertNotNull( denver );
    }


    @Test
    public void testStudentConstructorParams()
    {
        Student denver = new Student( "Denver", 4.0 );
        assertNotNull( denver );
    }


    @Test
    public void testUpdateMap()
    {
        Student denver = new Student( "Denver", 4.0 );
        denver.updateMap();
        // System.out.println(denver.ratings);
        assertTrue( denver.ratings.size() == 0 );
    }


    @Test
    public void testRateInput()
    {
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        denver.rateInput( "Anson", 5 );
        anson.rateInput( "Denver", 5 );
        // System.out.println( denver.ratings );
        assertTrue( !denver.ratings.isEmpty() );
    }


    @Test
    public void testGetRating()
    {
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        denver.rateInput( "Anson", 5 );
        anson.rateInput( "Denver", 5 );
        // System.out.println( denver.getRating( "Anson" ) );
        assertEquals( 5, denver.getRating( "Anson" ) );
    }


    @Test
    public void testRemove()
    {
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        denver.rateInput( "Anson", 5 );
        anson.rateInput( "Denver", 5 );
        denver.remove( "Anson" );
        // System.out.println( denver.ratings );
        assertTrue( denver.ratings.isEmpty() );
    }


    @Test
    public void testRatedStudents()
    {
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        denver.rateInput( "Anson", 5 );
        anson.rateInput( "Denver", 5 );
        denver.ratedStudents();
        // System.out.println( denver.getRated() );
        assertEquals( true, denver.getRated() );
    }


    @Test
    public void testGetName()
    {
        Student denver = new Student( "Denver", 4.0 );
        // System.out.println( denver.getName() );
        assertEquals( "Denver", denver.getName() );
    }


    @Test
    public void testGetPopularity2()
    {
        Student denver = new Student( "Denver", 4.0 );
        // System.out.println( denver.getPopularity() );
        assertEquals( 0.0, denver.getPopularity() );
    }


    @Test
    public void testGetRated()
    {
        Student denver = new Student( "Denver", 4.0 );
        assertEquals( false, denver.getRated() );
    }


    @Test
    public void testReturnArray()
    {
        Student denver = new Student( "Denver", 4.0 );
        assertEquals( denver.ratings, denver.returnArray() );
    }


    @Test
    public void testGetGPA()
    {
        Student denver = new Student( "Denver", 4.0 );
        assertEquals( 4.0, denver.getGPA() );
    }


    @Test
    public void testToString()
    {
        Student denver = new Student( "Denver", 4.0 );
        assertEquals( "Denver", denver.toString() );
    }


    // StudentGroup tests
    @Test
    public void testStudentGroupConstructor()
    {
        StudentGroup sg = new StudentGroup();
        assertNotNull( sg );
    }


    @Test
    public void testGetNth()
    {
        StudentGroup sg = new StudentGroup();
        Student denver = new Student( "Denver", 4.0 );
        sg.addStudent( denver );
        // System.out.println(sg.getNth( 0 ));
        assertEquals( denver, sg.getNth( 0 ) );
    }


    @Test
    public void testAddStudentNoParams()
    {
        StudentGroup sg = new StudentGroup();
        Student denver = new Student( "Denver", 4.0 );
        sg.addStudent( denver );
        // System.out.println( sg.group );
        assertTrue( sg.group.contains( denver ) );
    }


    @Test
    public void testAddStudentParams()
    {
        StudentGroup sg = new StudentGroup();
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        sg.addStudent( 0, denver );
        sg.addStudent( 0, anson );
        // System.out.println( sg.group );
        assertEquals( anson, sg.group.get( 0 ) );
    }


    @Test
    public void testComplete()
    {
        @SuppressWarnings("unused")
        Lynder lyn = new Lynder( 2 );
        StudentGroup sg = new StudentGroup();
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        sg.addStudent( denver );
        sg.addStudent( anson );
        // System.out.println( sg.size );
        assertEquals( true, sg.complete() );
    }


    @Test
    public void testReturnArray2()
    {
        StudentGroup sg = new StudentGroup();
        assertEquals( sg.group, sg.returnArray() );
    }


    @Test
    public void testRemoveTemp()
    {
        StudentGroup sg = new StudentGroup();
        Student denver = new Student( "Denver", 4.0 );
        sg.addStudent( denver );
        sg.removeTemp( 0 );
        // System.out.println( sg.group );
        assertTrue( sg.group.size() == 0 );
    }


    @Test
    public void testToString2()
    {
        StudentGroup sg = new StudentGroup();
        Student denver = new Student( "Denver", 4.0 );
        Student anson = new Student( "Anson", 1.0 );
        sg.addStudent( denver );
        sg.addStudent( anson );
        // System.out.println( sg.group );
        // System.out.println( sg.toString() );
        assertEquals( "Denver Anson ", sg.toString() );
    }
}
