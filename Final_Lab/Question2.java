import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {
    
	public static void main(String[] args){
		Scanner in=new Scanner(System.in); //input
		System.out.println("Enter length of Arrays:");
		int n=in.nextInt();
		int[] a= new int[n];
		System.out.println("Enter array-1:");
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
		}
		int[] b= new int[n];
		System.out.println("Enter array-2:");
		for(int i=0;i<n;i++) {
			b[i]=in.nextInt();
		}
		int[] m=new int[n*2];
		ArrayList<Integer> aa=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			aa.add(a[i]);
		}
		for(int i=0;i<b.length;i++) {
			aa.add(b[i]);
		}
		java.util.Collections.sort(aa);
		java.util.Collections.reverse(aa);
		for(int i=0;i<m.length;i++) {
			m[i]=aa.get(i);
		}
		System.out.println("Merged Array:");
		for(int i=0;i<m.length;i++) {
			System.out.print(m[i]+" ");
		}
		System.out.println();
		while(true) {
		System.out.println("Enter an index of merged Array:");
		try {
			int index=in.nextInt();
			System.out.println(m[index]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Bound");
			in.hasNextLine();
		}
		}
		
	}
}
