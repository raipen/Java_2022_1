/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 환율 계산기 프로그램
 * CurrencyConverterFrame.java
 * @date 2022-06-03
 * @copyright © KNU CSE student 박지원
 */

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class CurrencyConverterFrame extends JFrame{
	private String url;
	private JLabel comboLabel;
	private JComboBox<String> comboBox;
	private JLabel updateTime;
	private JLabel fromCurrency;
	private JLabel toCurrency;
	private JTextArea showRate;
	private JTextField fromMoney;
	private JTextField toMoney;
	private HashMap<String,Double> exchangeRate;
	
	public CurrencyConverterFrame(String url) {
		this.url = url;
		setTitle("환율 계산기");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3,3,5,5));
	
		comboLabel = new JLabel("환율 변환");
		comboLabel.setHorizontalAlignment(JLabel.RIGHT);
		contentPane.add(comboLabel);
		
		comboBox = new JComboBox<String>();
		contentPane.add(comboBox);
		
		updateTime = new JLabel("Updated");
		updateTime.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(updateTime);
		
		fromCurrency = new JLabel("통화1");
		fromCurrency.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(fromCurrency);
		
		toCurrency = new JLabel("한국KRW");
		toCurrency.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(toCurrency);
		
		showRate = new JTextArea("");
		contentPane.add(showRate);
		
		fromMoney = new JTextField("0");
		fromMoney.setHorizontalAlignment(JLabel.RIGHT);
		contentPane.add(fromMoney);
		
		toMoney = new JTextField("0");
		toMoney.setHorizontalAlignment(JLabel.RIGHT);
		contentPane.add(toMoney);
		
		// ComboBox에 ActionListener 연결
		comboBox.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				int comboSelectedIndex = comboBox.getSelectedIndex();
				changeUnitText(comboSelectedIndex);
			}
		});		
		
		fromMoney.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				double temp = Double.parseDouble(fromMoney.getText());
				double temp2 = exchangeRate.get(fromCurrency.getText());
				if(fromCurrency.getText().equals("일본JPY(100엔)"))
					temp2 /=100;
				toMoney.setText(String.format("%.2f",temp*temp2));
			}
		});	
		
		toMoney.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					double temp = Double.parseDouble(toMoney.getText());
					double temp2 = exchangeRate.get(fromCurrency.getText());
					if(fromCurrency.getText().equals("일본JPY(100엔)"))
						temp2 /=100;
					fromMoney.setText(String.format("%.2f",temp/temp2));
				}
			});	
		
		exchangeRate = new HashMap<>();
		
		setVisible(true);
		CurrencyDownloadThread th = new CurrencyDownloadThread(url, this);
		th.start();
	}
	
	private void changeUnitText(int index) {
		//System.out.println(index);
		String temp = comboBox.getItemAt(index);
		fromCurrency.setText(temp.split("<->")[0]);
		toCurrency.setText(temp.split("<->")[1]);
		fromMoney.setText("0");
		toMoney.setText("0");
	}
	
	public void setComboBox() {
		for(String i : exchangeRate.keySet()){
			comboBox.addItem(i+"<->한국KRW");
		}
	}
	
	public void updateCurrencyData(String name, Double exchange) {
		exchangeRate.put(name,exchange);
	}
	
	public void updateCurrencyRate() {
		showRate.setText("");
		for(String i : exchangeRate.keySet()){
			showRate.append(i+":"+exchangeRate.get(i)+"\n");
		}
	}
	
	public void updateLatestDate(String date) {
		updateTime.setText("Updated "+date);
	}
	
	public static void main(String[] args) {
		new CurrencyConverterFrame("http://fx.kebhana.com/fxportal/jsp/RS/DEPLOY_EXRATE/fxrate_all.html");
	}

}
