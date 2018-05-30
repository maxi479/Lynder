import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class LynderUI extends Frame implements ActionListener
{

    private JFrame frame;

    private JTextField textField;

    private JTextField textField_1;

    private JLabel lblNewLabel_1;

    private String name;

    private double gpa;

    private JLabel lblNewLabel_2;

    private JLabel lblNewLabel_3;

    private JLabel allOK;


    /**
     * Launch the application.
     */
    public void main( String[] args )
    {
        EventQueue.invokeLater( new Runnable()
        {
            public void run()
            {
                try
                {
                    LynderUI window = new LynderUI();
                    window.frame.setVisible( true );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
            }
        } );
    }


    /**
     * Create the application.
     */
    public LynderUI()
    {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds( 300, 200, 450, 500 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        JLabel lblNewLabel = new JLabel( "Enter Your Name: " );
        lblNewLabel.setBounds( 57, 41, 126, 43 );
        frame.getContentPane().add( lblNewLabel );

        textField = new JTextField();
        textField.setBounds( 229, 49, 130, 26 );
        frame.getContentPane().add( textField );
        textField.setColumns( 10 );

        allOK = new JLabel( "You have not entered a GPA Value!" );
        allOK.setBounds( 110, 280, 250, 50 );
        allOK.setVisible( false );
        frame.getContentPane().add( allOK );

        JLabel lblEnterYourGpa = new JLabel( "Enter Your GPA: " );
        lblEnterYourGpa.setBounds( 57, 121, 126, 43 );
        frame.getContentPane().add( lblEnterYourGpa );

        textField_1 = new JTextField();
        textField_1.setBounds( 229, 129, 130, 26 );
        frame.getContentPane().add( textField_1 );
        textField_1.setColumns( 10 );

        JButton btnNewButton = new JButton( "Enter!" );
        btnNewButton.setBounds( 147, 198, 117, 29 );
        frame.getContentPane().add( btnNewButton );

        lblNewLabel_1 = new JLabel( "Congrats! You've been added to the system!" );
        lblNewLabel_1.setFont( new Font( "Lucida Grande", Font.PLAIN, 9 ) );
        lblNewLabel_1.setBounds( 108, 226, 199, 26 );
        lblNewLabel_1.setVisible( true );
        frame.getContentPane().add( lblNewLabel_1 );

        lblNewLabel_2 = new JLabel( "" );
        lblNewLabel_2.setFont( new Font( "Lucida Grande", Font.PLAIN, 10 ) );
        lblNewLabel_2.setBounds( 108, 270, 400, 14 );
        frame.getContentPane().add( lblNewLabel_2 );
        lblNewLabel_1.setVisible( false );
        btnNewButton.addActionListener( this );

        lblNewLabel_3 = new JLabel( "" );
        lblNewLabel_3.setFont( new Font( "Lucida Grande", Font.PLAIN, 10 ) );
        lblNewLabel_3.setBounds( 108, 320, 400, 14 );
        lblNewLabel_3.setText( "Click 'NEXT' if you are the last entry!" );
        frame.getContentPane().add( lblNewLabel_3 );

        JButton btnNewButton1 = new JButton( "Next!" );
        btnNewButton1.setBounds( 147, 350, 117, 40 );
        frame.getContentPane().add( btnNewButton1 );
        btnNewButton1.addActionListener( new ActionListener()
        {
            @SuppressWarnings("static-access")
            public void actionPerformed( ActionEvent e )
            {
                frame.setVisible( false );
                // for ( Student s : Lynder.getMasterList() )
                {
                    LynderUI_2 temp = new LynderUI_2( Lynder.getMasterList().get( 0 ) );
                    temp.main( null );
                }
            }
        } );

    }


    public void createAndShow()
    {
        JFrame frame = new JFrame( "LynderUI" );
        frame.setVisible( true );
    }


    @Override
    public void actionPerformed( ActionEvent e )
    {
        try
        {
            name = textField.getText();
            gpa = Double.parseDouble( textField_1.getText() );
            lblNewLabel_2.setText( "Your name is " + name + " with a GPA of " + gpa );
            Student newStudent = new Student( name, gpa );
            Lynder.addNewStud( newStudent );
            lblNewLabel_1.setVisible( true );
            lblNewLabel_3.setVisible( true );
            allOK.setVisible( false );
        }
        catch ( NumberFormatException a )
        {
            allOK.setVisible( true );
            frame.getContentPane().add( allOK );
            lblNewLabel_1.setVisible( false );
            lblNewLabel_3.setVisible( false );
        }


    }

}
