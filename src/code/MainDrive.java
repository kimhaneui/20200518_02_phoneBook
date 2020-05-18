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
			
			if(menuInput ==0) {
				System.out.println("전화번호부를 종료합니다.");
				break;//끝내기 위해서
			}
			else if(menuInput == 1) {
//				전화번호 추가하는 기능
				
			}
			else if(menuInput == 2) {
//				목록 조회하는 기능
				
			}
			else {
//				해당사항이 없는 번호를 누르면 이렇게된다
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
		
	}

}
