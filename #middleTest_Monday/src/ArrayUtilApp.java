public class ArrayUtilApp {
	private int a[];
	private int b[];
	
	public ArrayUtilApp() {
		a = new int[10];
		b = new int[10];
	}

	public void run() {
		System.out.println("fill(a) 수행\n"
				+ "< 배열 a 인덱스 및 내용 출력 >");
		ArrayUtil.fill(a);
		ArrayUtil.print(a);
		System.out.println("\nfill(b) 수행\n"
				+ "< 배열 b 인덱스 및 내용 출력 >");
		ArrayUtil.fill(b);
		ArrayUtil.print(b);
		
		System.out.println("\nconcat(a, b) 수행 및 배열 c 생성\r\n"
				+ "< 배열 c 인덱스 및 내용 출력 >");
		ArrayUtil.print(ArrayUtil.concat(a, b));
		
		System.out.println("\ncompare(a, b) 수행");
		switch(ArrayUtil.compare(a,b)){
		case 1:
			System.out.println("a > b");
			break;
		case 0:
			System.out.println("a == b");
			break;
		case -1:
			System.out.println("a < b");
			break;
		}
	}
	
	public static void main(String[] args) {
		ArrayUtilApp app = new ArrayUtilApp();
		app.run();
	}

}
