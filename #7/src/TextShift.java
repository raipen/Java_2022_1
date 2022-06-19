/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 Textshift 및 글자색 변경 프로그램
 * TextShift.java
 * @date 2022-05-29
 * @copyright © KNU CSE student 박지원
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class TextShift extends JFrame{
	public TextShift() {
		setTitle("움직이는 텍스트");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JTextField edit = new JTextField("I Love Java Programming!");
		contentPane.add(edit,BorderLayout.NORTH);
	
		JLabel label = new JLabel("I Love Java Programming!");
		label.setFocusable(true);
		label.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		label.setForeground(Color.BLACK); // 글자색 변경
		label.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(label,BorderLayout.CENTER);
		
		JLabel bottomLabel = new JLabel("Key Pressed:");
		bottomLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(bottomLabel,BorderLayout.SOUTH);
		
		//텍스트 변경
		edit.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e){
		        label.setText(edit.getText());
		        label.requestFocus();
		    }
		});
		
		//키 입력
		label.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				char keyChar = e.getKeyChar();
				if(keyChar>='a'&&keyChar<='z')
					keyChar -= 32;
				String temp = label.getText();
				switch(keyCode) {
				case KeyEvent.VK_LEFT:
					temp += temp.charAt(0);
					temp = temp.substring(1);
					label.setText(temp);
					keyChar = '←';
					break;
				case KeyEvent.VK_RIGHT:
					temp = temp.charAt(temp.length()-1)+temp.substring(0,temp.length()-1);
					label.setText(temp);
					keyChar = '→';
					break;
				case KeyEvent.VK_R:
					label.setForeground(Color.RED);
					break;
				case KeyEvent.VK_G:
					label.setForeground(Color.GREEN);
					break;
				case KeyEvent.VK_B:
					label.setForeground(Color.BLUE);
					break;
				default:
					label.setForeground(Color.BLACK);
					break;
				}
				bottomLabel.setText("KeyEvent: "+keyChar+" pressed");
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TextShift app = new TextShift();
	}
}
