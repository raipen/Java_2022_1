import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

interface KtxReservationCallback{
	void updateSeat(String seat,int type);
}

public class KtxReservationApp extends JFrame{
	private HashMap<String, JLabel> seat = new HashMap();
	public KtxReservationApp() {		
		
		setTitle("KTX 예약 시스템");
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JLabel top = new JLabel("KTX 좌석 현황");
		contentPane.add(top,BorderLayout.NORTH);
		
		Container center = new JPanel();
		center.setLayout(new GridLayout(4,10));
		for(char i='D';i>='A';i--) {
			for(int j=1;j<=10;j++) {
				String temp = i+Integer.toString(j);
				System.out.println(temp);
				JLabel tempLabel = new JLabel(temp);
				tempLabel.setBackground(Color.WHITE);
				
				seat.put(temp,tempLabel);
				center.add(tempLabel);
			}
		}
		contentPane.add(center,BorderLayout.CENTER);
		
		JButton button = new JButton("예약 시작");
		contentPane.add(button,BorderLayout.SOUTH);		
		
		KtxSeat ktxSeat = new KtxSeat();
		//스레드 설정
//		ktxSeat.setCallback(new KtxReservationCallback() {
//			@Override
//			public void updateSeat(String seat,int type) {
//				top.setText("스레드 실행됨"+seat);
//			}
//		});
		
		button.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e){
		    	button.setEnabled(false);
				//ktxSeat.start();
		    }
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("시작");
		new KtxReservationApp();
	}
}
