import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class LynderUI extends Frame implements ActionListener
{

    private JFrame frame;

    private JTextField textField;

    private JTextField textField_1;

    private JLabel lblNewLabel_1;

    private String name;

    private double gpa;

    private JLabel lblNewLabel_2;


    /**
     * Launch the application.
     */
    public static void main( String[] args )
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
        frame.setBounds( 100, 100, 450, 300 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        JLabel lblNewLabel = new JLabel( "Enter Your Name: " );
        lblNewLabel.setBounds( 57, 41, 126, 43 );
        frame.getContentPane().add( lblNewLabel );

        textField = new JTextField();
        textField.setBounds( 229, 49, 130, 26 );
        frame.getContentPane().add( textField );
        textField.setColumns( 10 );

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
        lblNewLabel_1.setBounds( 114, 226, 199, 26 );
        frame.getContentPane().add( lblNewLabel_1 );

        lblNewLabel_2 = new JLabel( "" );
        lblNewLabel_2.setFont( new Font( "Lucida Grande", Font.PLAIN, 8 ) );
        lblNewLabel_2.setBounds( 108, 258, 205, 14 );
        frame.getContentPane().add( lblNewLabel_2 );
        lblNewLabel_1.setVisible( false );
        btnNewButton.addActionListener( this );

    }


    @Override
    public void actionPerformed( ActionEvent e )
    {
        lblNewLabel_1.setVisible( true );
        name = textField.getText();
        gpa = Double.parseDouble( textField_1.getText() );
        lblNewLabel_2.setText( "Your name is " + name + " with a GPA of " + gpa);
    }
    
    
}
