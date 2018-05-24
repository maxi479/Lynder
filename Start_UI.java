import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;


public class Start_UI
{

    private JFrame frame;

    private JTextField textField;


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
                    Start_UI window = new Start_UI();
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
    public Start_UI()
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

        JLabel lblGroupSize = new JLabel( "Group Size: " );
        lblGroupSize.setFont( new Font( "Lucida Grande", Font.PLAIN, 19 ) );
        lblGroupSize.setBounds( 69, 88, 119, 45 );
        frame.getContentPane().add( lblGroupSize );

        textField = new JTextField();
        textField.setBounds( 246, 89, 130, 45 );
        frame.getContentPane().add( textField );
        textField.setColumns( 10 );

        JButton btnEnter = new JButton( "Enter!" );
        btnEnter.setBounds( 154, 186, 117, 29 );
        frame.getContentPane().add( btnEnter );
        btnEnter.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                Lynder lynd = new Lynder( Integer.parseInt( textField.getText() ) );
                lynd.main( null );
            }
        } );
        ;
    }
}
