package webalk1;

import java.util.Scanner;

public class Webalk1 {

	public static void main(String[] args) {
		int a;
		int b;
		System.out.println("1: ");
		a=Integer.parseInt(beolvas());
		System.out.println("2: ");
		b=Integer.parseInt(beolvas());
		System.out.println("jel:");
		String j=beolvas();
		
		switch (j) {
		case "+": System.out.println(a+b);break;
		case "-": System.out.println(a-b);break;
		}
	}
	
	public static String beolvas() {
		Scanner sc = new Scanner(System.in);
		String x;
		x=sc.nextLine();
		sc.close();
		return x;
				
	}
	
}
