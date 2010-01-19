/**
  **/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestMouseEvent extends JPanel {
	private JPanel myRect;

	/** Constructor for objects of class ButtonExample_Innerclass */
	public TestMouseEvent() {

		myRect = new JPanel();
		myRect.setBackground(Color.white);
		myRect.addMouseListener(new MyMouseActions());
		myRect.setPreferredSize(new Dimension(100, 100));
		add(myRect);
	}

	/** Actions for mouse * */
	class MyMouseActions implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			// Mouse clicked (Down + Up)
			// myRect.setBackground(Color.blue);
		}

		public void mouseEntered(MouseEvent arg0) {
			// Mouse enters rectangle
			myRect.setBackground(Color.red);
		}

		public void mouseExited(MouseEvent arg0) {
			// Mouse exits rectangle
			myRect.setBackground(Color.yellow);
		}

		public void mousePressed(MouseEvent arg0) {
			// Mouse button pressed
			myRect.setBackground(Color.green);
		}

		public void mouseReleased(MouseEvent arg0) {
			// Mouse button released
			myRect.setBackground(Color.orange);
		}
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Lexical events example");
		frame.getContentPane().add(new TestMouseEvent());
		frame.pack();
		frame.setVisible(true);
	}
}