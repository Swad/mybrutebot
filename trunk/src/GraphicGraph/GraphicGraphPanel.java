package GraphicGraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import no.ntnu.fp.su.Well;

public class GraphicGraphPanel extends JPanel {
	
	private List<Value> values;
	private boolean isRunning;
//	private Well well;
	private double lastTempValue = 0;
	private double lastPressureValue = 0;
	public GraphicGraphPanel() {
		values = new ArrayList<Value>();
		isRunning = false;
//		well = new Well();
		setPreferredSize(new Dimension(800,375));
		setBackground(Color.WHITE);
		
		
		
	}
	
	public void addValue(Value value){
		if (values.size() > 129){
			values.remove(0);
		}
		values.add(value);
	}
	
	// paint into the JPanel board
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		for (int i=1; i < 14; i++) {
			g2.drawString("Line "+(14-i)+".", 5, i*25);
			g2.draw(new Line2D.Double(70, (i)*25-4, 730, (i)*25-4));
		}
		
		for (int i=0; i < 14; i++){
			g2.drawString(""+i*10+"", 66+(50*i), 350 );
			g2.draw(new Line2D.Double(75+(50*i), 20, 75+(50*i), 330));
		}
		
		// Paint the temprature graph
		int count = 0;
		double scale = 1;
		int lastX = 0;
		g2.setColor(Color.BLUE);
		for (Value value : values) {
			g2.draw(new Line2D.Double(75+lastX,330-lastTempValue*scale,75+lastX+5,330-value.getTemperature()*scale));
			System.out.println(value.getTemperature()*scale);
			lastTempValue = value.getTemperature();
			lastX = lastX + 5;
			count++;
		}
		
		// Paint the pressure graph
		count = 0;
		scale = 0.0001;
		lastX = 0;
		g2.setColor(Color.RED);
		for (Value value : values) {
			g2.draw(new Line2D.Double(75+lastX,330-lastPressureValue*scale,75+lastX+5,330-value.getPressure()*scale));
			System.out.println(value.getPressure()*scale);
			lastPressureValue = value.getPressure();
			System.out.println("--------");
			lastX = lastX + 5;
			count++;
			
		}
	}
		
	
//	@Override
//	public void run() {
//		isRunning = true;
//		while(isRunning){
////			double[] poll = well.sample();
//			if(tempValues.size() > 129) tempValues.remove((int)0);
//			if(pressureValues.size() > 129) pressureValues.remove(0);
////			tempValues.add(poll[3]);
////			pressureValues.add(poll[2]);
//			repaint();
//			try {
//				Thread.sleep(50);
//			} catch(InterruptedException e) {
//				System.out.println("Thread Interrupted");
//			}
//		}
//		
//	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
//		GraphicGraphPanel panel = new GraphicGraphPanel();
//		(new Thread(panel)).start(); 
//		frame.setContentPane(panel);
//	
//		frame.pack();
//	}


}
