/**
  **/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MousePanelSimple extends JPanel {


	/** Constructor for objects of class ButtonExample_Innerclass */
	public MousePanelSimple() {
		setBackground(Color.white);
		addMouseListener(new MyMouseActions());
		setPreferredSize(new Dimension(100, 100));
	}

	/** Actions for mouse * */
	class MyMouseActions implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			// Mouse clicked (Down + Up)
			// myRect.setBackground(Color.blue);
		}

		public void mouseEntered(MouseEvent arg0) {
			// Mouse enters rectangle
			setBackground(Color.red);
		}

		public void mouseExited(MouseEvent arg0) {
			// Mouse exits rectangle
			setBackground(Color.yellow);
		}

		public void mousePressed(MouseEvent arg0) {
			// Mouse button pressed
			setBackground(Color.green);
		}

		public void mouseReleased(MouseEvent arg0) {
			// Mouse button released
			setBackground(Color.orange);
		}
	}

}