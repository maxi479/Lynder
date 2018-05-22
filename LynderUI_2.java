import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class LynderUI_2
{

    private JFrame frame;

    private JList list;

    private int index;

    private static Student stud;


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
                    LynderUI_2 window = new LynderUI_2( stud );
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
    public LynderUI_2( Student stu )
    {
        stud = stu;
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
        final DefaultListModel<String> model = new DefaultListModel<String>();
        for ( Student stu : Lynder.getMasterList() )
        {
            model.addElement( stu.toString() );
        }
        list = new JList<String>( model );
        list.setVisibleRowCount( model.size() );
        list.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
        list.setBounds( 50, 50, 100, 50 );
        JScrollPane pane = new JScrollPane( list );
        frame.add( list );
        final JLabel lblNewLabel = new JLabel(
            "Selected Student Name: " + list.getSelectedValue() );
        lblNewLabel.setBounds( 80, 80, 200, 100 );
        lblNewLabel.setVisible( false );
        frame.add( lblNewLabel );
        list.addListSelectionListener( new ListSelectionListener()
        {
            public void valueChanged( ListSelectionEvent e )
            {
                lblNewLabel.setText( "selected student name: " + list.getSelectedValue() );
                index = list.getSelectedIndex();
                lblNewLabel.setVisible( true );
            }
        } );
        final JTextField textField = new JTextField();
        textField.setText( "enter rating" );
        textField.setBounds( 90, 120, 100, 25 );
        frame.add( textField );
        final JButton button = new JButton();
        button.setText( "enter" );
        button.addActionListener( new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                ListSelectionModel selmodel = list.getSelectionModel();
                String name = (String)list.getSelectedValue();
                int index = selmodel.getMinSelectionIndex();
                if ( index >= 0 )
                    model.remove( index );
                stud.rateInput( name, Integer.parseInt( textField.getText() ) );
            }
        } );
        button.setBounds( 95, 150, 100, 50 );
        frame.add( button );

        final JButton butt = new JButton();
        butt.setText( "Last Entry" );
        butt.setBounds( 200, 40, 150, 30 );
        butt.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                setVisible( false );
                frame.dispose();
            }
        } );
        frame.add( butt );

    }


    public void setVisible( boolean b )
    {
        if ( b == true )
        {
            setVisible( true );
        }
        setVisible( false );

    }
}
