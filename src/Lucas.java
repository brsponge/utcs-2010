public class Lucas {
	public static void main(String[] args) {
		int x = 2;
		int y = 1;
		int i = 3;
		while (i <= 17) {
			System.out.println(x);
			System.out.println(y);
			x = y + x;
			y = y + x;
			i++;
		}
		System.out.println(x + y);
	}
}
