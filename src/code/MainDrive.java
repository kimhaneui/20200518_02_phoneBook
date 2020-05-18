package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
				writeUserInfoToFile();
				
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
	
	static void writeUserInfoToFile() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		
		System.out.println("폰번 입력 : ");
		String phone = scan.nextLine();
		
		System.out.println("생년 입력 : ");
		int year = scan.nextInt();
		
//		File 자동완성 시켜야됌 (ios)
		File phoneBookFile = new File("phoneBook.csv");
		
		try {
			FileWriter fw = new FileWriter(phoneBookFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String inputContent = String.format("%s,%s,%d", name,phone,year);
			
			bw.append(inputContent);
			bw.newLine(); //줄바꿔라
			
			bw.close();
			fw.close();
			
			System.out.println("연락처 저장이 완료되었습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
