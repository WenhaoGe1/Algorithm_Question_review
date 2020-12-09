package reviewlaiooffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.*;

public class test extends StackByArray {
	
	public static void main(String[] args) {
		System.out.print((double)(1 / 2));
		
	}
//	public static <Object> Object[] run(Object[] array) {
//		for (Object e : array) {
//			System.out.printf("%s ", e);
//		}
//		System.out.println();
//		return array;
//	}
	public static <E extends Comparable<E>> E[] run(E[] array) {
		for (E e : array) {
			System.out.printf("%s     ", e);
		}
		System.out.println();
		return array;
	}
}

