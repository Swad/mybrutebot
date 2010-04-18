package GraphicGraph;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import no.ntnu.fp.su.Well;

public class GraphicValueAndGraphPanel extends JPanel implements Runnable {
	private GraphicValuePanel valuePanel;
	private GraphicGraphPanel graphPanel;
	private boolean isRunning;
	private Well well;
	
	public GraphicValueAndGraphPanel() {
		setPreferredSize(new Dimension(800,600));
		valuePanel = new GraphicValuePanel();
		graphPanel = new GraphicGraphPanel();
		well = new Well();
		add(graphPanel);
		add(valuePanel);
		isRunning = false;
		
	}
	
	public void run(){
		while(true) {
			double[] poll = well.sample();
			Value value = new Value(0, "hh:mm:ss", poll[2], 0, poll[3], 1);
			valuePanel.addValue(value);
			graphPanel.addValue(value);
			valuePanel.repaint();
			graphPanel.repaint();
	
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("GraphicValueAndGraph Thread was Interrupted: "+e.toString());
			}
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		GraphicValueAndGraphPanel panel = new GraphicValueAndGraphPanel();
		frame.setContentPane(panel);
		frame.pack();
		
		(new Thread(panel)).start();
//		panel.repaint();
	}
}
