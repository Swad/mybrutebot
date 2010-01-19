
/**
 * A simple JButton in a JPanel
 * The JPanel lives in the contentPane of a JFrame.
 * DS 2005, TDT4180
 */
import javax.swing.*;

public class MousePanelExample extends JPanel
{   
    /**
     * Constructor for objects of class ButtonExample
     */
    public MousePanelExample()
    {
       add(new MousePanelSimple());
       add(new MousePanelSimple());
       add(new MousePanelSimple());
       add(new MousePanelSimple());
       add(new MousePanelSimple());

    }
  
    public static void main (String args[]) {
        JFrame frame = new JFrame("Button example");
        frame.getContentPane().add(new MousePanelExample());
        frame.pack();
        frame.setVisible(true);  
    }
}
