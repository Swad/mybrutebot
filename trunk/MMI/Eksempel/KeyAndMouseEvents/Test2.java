
/**
  Example 1B, TDT4180-2005.
  This example shows the use of an action listener by
  letting the JPanel have an innner class "MyButtonAction" that
  implements the ActionListener interface.   **/

import javax.swing.*;
import java.awt.event.*;

import javax.swing.event.*; 
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 

public class Test2 extends JPanel
{   
   private JTextField myTextField, myTextField2;
   
    /**  Constructor for objects of class ButtonExample_Innerclass */
    public Test2()
    {
       myTextField  = new JTextField();
       myTextField.setColumns(20);       
       add(myTextField);
       myTextField.setText("...");
       myTextField.addActionListener(new MyTextAction());
       myTextField.addKeyListener(new MyKeyAction()); 
       
       myTextField2  = new JTextField();
       myTextField2.setColumns(20);       
       add(myTextField2);     
    }
  
    /** Actions for text  **/
    class MyTextAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myTextField.setText("Action");
        }
    }
    
    /** Actions for key input  **/
    class MyKeyAction implements KeyListener {
        public void keyTyped(KeyEvent e)  {
      //    myTextField2.setText(myTextField.getText()); 
        }

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
	        myTextField2.setText(myTextField.getText()); 		
		}
        
    }    

    public static void main (String args[]) {
        JFrame frame = new JFrame("Lexical events example");
        frame.getContentPane().add(new Test2());
        frame.pack(); 
        frame.setVisible(true);  
    }
}