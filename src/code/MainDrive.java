package code;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		printMenu();
	}
	
	static void printMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***전화번호부***");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전체 목록 조회");
		System.out.println("0. 프로그램 종료");
		System.out.println("***************");
		
		while(true) {
			System.out.println("메뉴입력 : ");
			
			int menuInput = scan.nextInt();
		}
		
	}

}
