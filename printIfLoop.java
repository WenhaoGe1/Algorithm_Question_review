import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printIfLoop {


	public static void printBlock(int n){
		char[] array = new char[n * 2];
		printB(array, n, n, 0);
	}

	private static void printB(char[] array, int left, int right, int pos){
		if (left == 0 && right == 0){
			print(array);
			return;
		}
		if (left > 0){
			array[pos] = '{';
			printB(array, left - 1, right, pos + 1);
		}
		if (right > left){
			array[pos] = '}';
			printB(array, left, right - 1, pos + 1);
		}
	}
	private static void print(char[] array){
		int heading = 0;
		for (int i = 0; i < array.length; i++){
			if (array[i] == '{'){
				printSpace(heading);
				System.out.println("if {");

				heading += 2;
			}
			else {
				heading -= 2;
				printSpace(heading);
				System.out.println("}");
				
			}
		}
		System.out.println("=========");
	}

	private static void printSpace(int space){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < space; i++) {
			sb.append(" ");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) {
		printBlock(2);
	}
	
}
