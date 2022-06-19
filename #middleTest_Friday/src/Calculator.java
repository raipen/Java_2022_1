import java.util.Scanner;
import java.util.regex.Pattern;

class Calc {
	protected int a, b;
	public Calc() {
		a = b = 0;
	}
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() { // 서브 클래스에서 재정의
		return 0;
	}
}

class Add extends Calc{
	public int calculate() { // 서브 클래스에서 재정의
		System.out.println("덧셈 연산");
		return a+b;
	}
	public String toString() {
		return "Add: "+a+" + "+b+" = ";
	}
}

class Sub extends Calc{
	public int calculate() { // 서브 클래스에서 재정의
		System.out.println("뺄셈 연산");
		return a-b;
	}
	public String toString() {
		return "Sub: "+a+" - "+b+" = ";
	}
}

class Mul extends Calc{
	public int calculate() { // 서브 클래스에서 재정의
		System.out.println("곱셈 연산");
		return a*b;
	}
	public String toString() {
		return "Mul: "+a+" * "+b+" = ";
	}
}

class Div extends Calc{
	public int calculate() throws ArithmeticException { // 서브 클래스에서 재정의
		System.out.println("나눗셈 연산");
		return a/b;
	}
	public String toString() {
		return "Div: "+a+" / "+b+" = ";
	}
}

public class Calculator {
	private Scanner scan;
	
	public Calculator() {
		scan = new Scanner(System.in);
	}
	
	public Calc input() {
		while(true) {
			System.out.print("두 정수와 연산자를 입력하세요(종료: -1 -1): ");
			String str = scan.nextLine();
			if(str.equals("-1 -1")) return null;
			if(!Pattern.matches("^[0-9]+ [0-9]+ [-+*/]$",str)) {
				if(Pattern.matches("^[0-9]+ [0-9]+ .$",str))
					System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
				else
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}
			String splitStr[] = str.split(" ");
			Calc calc = null;
			switch(splitStr[2]) {
			case "+":
				calc = new Add();
				break;
			case "-":
				calc = new Sub();
				break;
			case "*":
				calc = new Mul();
				break;
			case "/":
				calc = new Div();
				break;
			}
			calc.setValue(Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[1]));
			return calc;
		}
	}
	
	public void run() {
		while(true) {
			Calc calc = input();
			if(calc==null) {
				System.out.println("종료합니다.");
				break;
			}
			try {
			System.out.println(calc.toString() + calc.calculate());
			}catch (ArithmeticException e){
				if(e.getMessage().equals("/ by zero"))
					System.out.println("0으로 나눌 수 없습니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		Calculator app = new Calculator();
		app.run();
	}
}
