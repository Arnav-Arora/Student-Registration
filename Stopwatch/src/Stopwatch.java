import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{

	JFrame frame=new JFrame();
	JButton startbutton=new JButton("Start");
	JButton resetbutton=new JButton("Reset");
	JLabel timelabel=new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			elapsedTime=elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string= String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		}
		
	});
	
	Stopwatch(){
		
		startbutton.setBounds(100,200,100,50);
		startbutton.setFont(new Font("Ink Free",Font.PLAIN,20));
		startbutton.setFocusable(false);
		startbutton.addActionListener(this);
		
		resetbutton.setBounds(200,200,100,50);
		resetbutton.setFont(new Font("Ink Free",Font.PLAIN,20));
		resetbutton.setFocusable(false);
		resetbutton.addActionListener(this);
		
		timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timelabel.setBounds(100,100,200,100);
		timelabel.setFont(new Font("Verdana",Font.BOLD,35));
		timelabel.setBorder(BorderFactory.createBevelBorder(1));
		timelabel.setOpaque(true);
		timelabel.setHorizontalAlignment(JTextField.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(timelabel);
		frame.add(resetbutton);
		frame.add(startbutton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startbutton) {
			timer.start();
			if(started==false) {
				started=true;
				startbutton.setText("Stop");
				start();
			}
			else {
				started=false;
				startbutton.setText("Stop");
				stop();
			}
		}
		
		if(e.getSource()==resetbutton) {
			started=false;
			startbutton.setText("Start");
			reset();
		}
		
	}

	void start() {
		timer.start();
	}
	
void stop() {
		timer.stop();
	}

void reset() {
	timer.stop();
	elapsedTime=0;
	seconds=0;
	minutes=0;
	hours=0;
	seconds_string = String.format("%02d", seconds);
	minutes_string= String.format("%02d", minutes);
	hours_string = String.format("%02d", hours);
	timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
}

}
