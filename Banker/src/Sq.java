import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Sq extends JFrame{
	private JPanel contentPane;
	private Vector ways;
	
	public Sq(Vector w) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ways=w;
		setBounds(100, 100, 513, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 491, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("°²È«ÐòÁÐ:");
		lblNewLabel.setBounds(14, 11, 84, 33);
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(108, 16, 373, 288);
		for(int i=0;i<ways.size();i++) {
			textArea.append(ways.get(i).toString());
			textArea.append("\n");
		}
		panel.add(textArea);
		this.setVisible(true);
	}
}
