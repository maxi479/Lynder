
public class Student
    {
        // total added score from all other students
        private int popularity;
        // whether or not he has rated every other student in the class
        private boolean rated; 
        //name of student
        private String name;
        //GPA of student
        private double GPA;
        
        /**
         * default constructor
         */
        public Student()
        {
            popularity = 0;
            rated = false;
            name = "";
            GPA = 0;
        }
        
        public Student(String fullName, double gradePointAvg)
        {
            popularity = 0;
            rated = false;
            name = fullName;
            GPA = gradePointAvg;
        }
        
        
    }
