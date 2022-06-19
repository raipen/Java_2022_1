public class ArrayUtil {
	public static void fill(int[] a) {
		for(int i=0;i<10;i++) {
			a[i] = (int) (Math.random() *99 +1);
		}
	}
	
	public static int[] concat(int[] a,int[] b) {
		int[] result = new int[a.length+b.length];
		for(int i=0;i<a.length;i++) {
			result[i] = a[i];
		}
		for(int i=0;i<b.length;i++) {
			result[i+a.length] = b[i];
		}
		return result;
	}
	
	private static int max(int[] a) {
		int m=0;
		for(int i=1;i<a.length;i++) {
			m = a[m]>a[i]?m:i;
		}
		return a[m];
	}
	
	public static int compare(int[] a,int[] b) {
		int ma = max(a);
		int mb = max(b);
		System.out.printf("a의 최대값: %2d, b의 최대값: %2d\n",ma,mb);
		return ma>mb?1:(ma==mb?0:-1);
	}
	
	public static void print(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.printf(" %2d ",i);
		System.out.print("\n[");
		for(int i=0;i<a.length-1;i++)
			System.out.printf("%2d, ",a[i]);
		System.out.printf("%2d]\n",a[a.length-1]);
	}
}
