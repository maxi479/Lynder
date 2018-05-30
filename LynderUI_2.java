import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class LynderUI_2
{

    private JFrame frame;

    @SuppressWarnings("rawtypes")
    private JList list;

    @SuppressWarnings("unused")
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
        frame.setBounds( 300, 300, 600, 600 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );
        final DefaultListModel<String> model = new DefaultListModel<String>();
        for ( Student stu : Lynder.getMasterList() )
        {
            if ( stu.getName().equals( stud.getName() ) )
            {
                stu.rateInput( stu.getName(), 1 );
            }
            else
            {
                model.addElement( stu.toString() + "      " + "GPA: " + stu.getGPA() );
            }

        }
        list = new JList<String>( model );
        list.setVisibleRowCount( model.size() );
        list.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
        list.setBounds( 50, 50, 100, 50 );
        JScrollPane pane = new JScrollPane( list );
        pane.setBounds( 50, 50, 150, 50 );
        frame.add( pane );
        final JLabel lblNewLabel = new JLabel(
            "Selected Student Name: " + list.getSelectedValue() );
        lblNewLabel.setBounds( 200, 60, 400, 100 );
        lblNewLabel.setVisible( false );
        frame.add( lblNewLabel );
        final JLabel name = new JLabel( "Your name is " + stud.getName() );
        name.setBounds( 150, 230, 300, 100 );
        frame.add( name );
        list.addListSelectionListener( new ListSelectionListener()
        {
            public void valueChanged( ListSelectionEvent e )
            {
                lblNewLabel.setText( "selected student name: " + list.getSelectedValue() );
                index = list.getSelectedIndex();
                if ( list.getSelectedValue() == null )
                    lblNewLabel.setText( "no student selected" );
                lblNewLabel.setVisible( true );
            }
        } );
        final JLabel lable = new JLabel( "Rating: " );
        lable.setBounds( 50, 150, 100, 25 );
        frame.add( lable );
        final JTextField textField = new JTextField();
        textField.setBounds( 200, 150, 100, 25 );
        frame.add( textField );
        final JButton button = new JButton();
        button.setText( "enter" );
        button.addActionListener( new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
               
                ListSelectionModel selmodel = list.getSelectionModel();
                int index = selmodel.getMinSelectionIndex();
                String name = model.elementAt( index );
                if ( index >= 0 )
                    model.remove( index );
                System.out.println( name + " " + Integer.parseInt( textField.getText() ) );
                stud.rateInput( name, Integer.parseInt( textField.getText() ) );
                textField.setText( "" );
            }
        } );
        button.setBounds( 50, 200, 100, 50 );
        frame.add( button );
        final JButton LastEntry = new JButton();
        LastEntry.setText( "Last Entry" );
        LastEntry.setBounds( 200, 200, 150, 50 );
        LastEntry.addActionListener( new ActionListener()
        {
            @SuppressWarnings("static-access")
            public void actionPerformed( ActionEvent e )
            {
                frame.setVisible( false );
                int i = Lynder.iterator();
                if ( i < Lynder.getMasterList().size() )
                {
                    LynderUI_2 next = new LynderUI_2( Lynder.getMasterList().get( i ) );
                    next.main( null );
                }
                else
                {
                    Lynder.compilePopularity();
                    Lynder.makeGroup();
                    Lynder.print();
                }

            }
        } );
        frame.add( LastEntry );

    }

}
