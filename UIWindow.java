import java.awt.*;
import java.awt.event.*;


public class UIWindow extends Frame implements ActionListener
{
    private Label label; // Declare a Label component

    private TextField tfCount; // Declare a TextField component

    private Button btnCount; // Declare a Button component

    private int count = 0;


    public UIWindow()
    {
        setLayout( new FlowLayout() );
        label = new Label( "maxwell is unhappy man hehehehe" );
        add( label );
        setVisible( true );
    }


    public void actionPerformed( ActionEvent e )
    {
        // TODO Auto-generated method stub

    }


    public static void main( String[] args )
    {
        UIWindow app = new UIWindow();
    }

}
