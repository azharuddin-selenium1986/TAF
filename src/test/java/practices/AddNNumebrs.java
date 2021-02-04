package practices;

public class AddNNumebrs {

	
	public static int addNumbers(int...number) {
		if(number.length<=0) {
			System.out.println("No Numebrs to be add");
		}
		int sum=0;
		for(int i=0;i<number.length;i++) {
			sum+=number[i];
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(addNumbers(-1,3));
	}
}
