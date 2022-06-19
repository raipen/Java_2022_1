import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class Palindrome extends JFrame {
	
	public Palindrome() {
		setTitle("환율 계산기");
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		Container topContent = new JPanel();
		topContent.setLayout(new GridLayout(1,2));
		JTextField edit = new JTextField("");
		topContent.add(edit);
		
		JButton button = new JButton("회문 검사");
		topContent.add(button);
		contentPane.add(topContent,BorderLayout.NORTH);
		
		JLabel label = new JLabel("Press Enter or Click Button");
		label.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		contentPane.add(label,BorderLayout.CENTER);
		
		ActionListener checkPalin = new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e){
		    	String checkString = edit.getText();
		    	for(int i=0,j=checkString.length()-1;i<j;i++,j--) {
		    		if(checkString.charAt(i)!=checkString.charAt(j)) {
		    			label.setText("No Palindrome");
		    			return;
		    		}
		    	}
		        label.setText("Palindrome");
		    }
		};
		
		edit.addActionListener(checkPalin);
		button.addActionListener(checkPalin);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Palindrome();
	}
}
