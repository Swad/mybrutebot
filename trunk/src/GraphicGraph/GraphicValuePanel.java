package GraphicGraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicValuePanel extends JPanel {
	ArrayList<Value> values;
	
	public void addValue(Value value) {
		if (values.size() > 9){
			values.remove(0);
		}
		values.add(value);
	}
	
	public GraphicValuePanel() {
		setPreferredSize(new Dimension(800,230));
		setSize(new Dimension(200,200));
		values = new ArrayList<Value>();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.drawString("Pollid", 15, 25);
		g2.drawString("Timestamp",148, 25);
		g2.drawString("Pressure", 281, 25);
		g2.drawString("Resistance", 414, 25);
		g2.drawString("Temperature", 547, 25);
		g2.drawString("Change in R", 680, 25);
		g2.draw(new Line2D.Double(0, 30, 800, 30));
		for (int i = 0; i < 5; i++) {
			g2.draw(new Line2D.Double(133*(i+1), 10, 133*(i+1), 380));
		}
		int spacing = 0;
		int count = 0;
		for (int i = values.size()-1; i > 0; i--) {
			Value value = values.get(i);
			if (i == values.size()-1) { spacing = 50; }
			else { spacing = 20; }
			String[] st = value.toStringTable();
			g2.drawString(st[0], 15, 50+spacing*(count));
			g2.drawString(st[1], 148, 50+spacing*(count));
			g2.drawString(st[2], 281, 50+spacing*(count));
			g2.drawString(st[3], 414, 50+spacing*(count));
			g2.drawString(st[4], 547, 50+spacing*(count));
			g2.drawString(st[5], 680, 50+spacing*(count));
			count++;
		}
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		GraphicValuePanel panel = new GraphicValuePanel();
		frame.setContentPane(panel);
		frame.pack();
		panel.repaint();
	}
}
