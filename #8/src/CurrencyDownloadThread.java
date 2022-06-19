/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 환율 계산기 프로그램
 * CurrencyDownloadThread.java
 * @date 2022-06-03
 * @copyright © KNU CSE student 박지원
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class CurrencyDownloadThread extends Thread{
	String url;
	CurrencyConverterFrame callback;
	HashMap<String,String> currencyMap= new HashMap<>(){{//초기값 지정
		put("100&yen;","일본JPY(100엔)");
	    put("1USD","미국USD");
	    put("1CNY","중국CNY");
	    put("1EUR","EU(EURO)");
	}};
	
	public CurrencyDownloadThread(String url,CurrencyConverterFrame caller) {
		this.url = url;
		this.callback = caller;
	}
	
	public void getLatestCurrency() {
		String line = "";
		int responseCode = 0;
		try {
			URL currencyUrl = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection)currencyUrl.openConnection();
			httpConn.setRequestMethod("GET");
			responseCode = httpConn.getResponseCode();
			System.out.println("responseCode: " + responseCode);
			if(responseCode == HttpURLConnection.HTTP_OK) {
				InputStreamReader inReader = new
						InputStreamReader(httpConn.getInputStream(), "euc-kr");
				BufferedReader reader = new BufferedReader(inReader);
				while((line = reader.readLine()) != null) {
					// 아래 문자열을 만나면 Html 문서를 파싱하기 시작
					if(line.contains("<td class='nation'>")) {
						
						String currencyName = currencyMap.get(line.replaceAll("\\<.*?>",""));
						line = reader.readLine();
						Double exchangeRate = Double.parseDouble(line.replaceAll("\\<.*?>",""));
						System.out.println(currencyName+exchangeRate);
						callback.updateCurrencyData(currencyName, exchangeRate);
					}
					// 아래 문자열을 만나면 Html 파싱을 종료함
					if(line.contains("<div class='date'>")) {
						callback.updateCurrencyRate();
						line = reader.readLine();
						String updateDate = line.replaceAll("\\<.*?>","");
						System.out.println(updateDate);
						callback.updateLatestDate(updateDate);
						break;
					}
				}
				httpConn.disconnect();
				inReader.close();
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		getLatestCurrency();
		callback.setComboBox();
		while(true) {
			try {
				sleep(60000);
			}catch(InterruptedException e) {
				return;
			}
			getLatestCurrency();
		}
	}
}
