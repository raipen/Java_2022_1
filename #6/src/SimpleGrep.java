/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 단어 검색 및 검색된 결과 파일 저장 프로그램
 * SimpleGrep.java
 * @date 2022-05-15
 * @copyright © KNU CSE student 박지원
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class SimpleGrep {
	static File[] files;
	static Vector<String> result = new Vector<>();
	static char option;
	static String searchword;
	
	static void search(File f) {
		try {
			FileReader fin = new FileReader(f);
            BufferedReader buf = new BufferedReader(fin);
        	String line = "";
            switch(option) {
            case 'c':
            	int cnt;
                for(cnt = 0;(line = buf.readLine()) != null;){
                	for(int j=0;line.indexOf(searchword,j)!=-1;j=line.indexOf(searchword,j)+1) {
                		cnt++;
                	}
                }
                System.out.println(f.getName()+":"+cnt);
                result.add(f.getName()+":"+cnt);
            	break;
            case 'n':
                for(int i=1;(line = buf.readLine()) != null;i++){
                    if(line.contains(searchword)) {
                    	System.out.println(f.getName()+":"+i+":"+line);
                    	result.add(f.getName()+":"+i+":"+line);
                    }
                }
            	break;
            case 'i':
            	for(int i=1;(line = buf.readLine()) != null;i++){
                    if(line.toUpperCase().contains(searchword.toUpperCase())) {
                    	System.out.println(f.getName()+":"+i+":"+line);
                    	result.add(f.getName()+":"+i+":"+line);
                    }
                }
            	break;
            }                     
            buf.close();
            fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if(args.length!=3) {
			System.out.println("Usage: SimpleGrep [option] [searchword] [dir]");
			System.exit(0);
		}
		//명령행 인자들 정리
		option = args[0].charAt(1);
		searchword = args[1];
		File parent = new File(args[2]);
		files = parent.listFiles();
		Arrays.sort(files);
		
		//실행 정보 출력
		System.out.println("----------------------------------------------------\r\n"
				+ "Working dir: "+parent.getPath()+"\r\n"
				+ "Search Result: option: "+option+", keyword: "+searchword+"\r\n"
				+ "----------------------------------------------------");
		
		//결과 작성
		for(File f : files) {
			search(f);
		}
		
		File fout = new File(".\\Result.txt");
		fout.delete();
		
		if(result.size()==0) {
			System.out.println(searchword+" not found!");
			System.exit(0);
		}
		
		//파일 출력
		FileWriter fwrite = null;
		try {
			fwrite = new FileWriter(fout);
			for(int i=0;i<result.size();i++) {
				fwrite.write(result.elementAt(i));
				fwrite.write("\r\n");
			}
			fwrite.close();
			System.out.println("Result.txt saved.");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
