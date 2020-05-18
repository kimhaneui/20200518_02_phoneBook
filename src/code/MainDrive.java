package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import code.datas.User;

public class MainDrive {
	
	public static void main(String[] args) {
//		메뉴를 출력하는 기능 실행
		printMenu();
	}
	
	static void printMenu() {
//		메뉴를 출력하고 입력을 받을 스캐너
		Scanner scan = new Scanner(System.in);
		
//		메뉴를 알아보기 쉽게 출력
		System.out.println("***전화번호부***");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전체 목록 조회");
		System.out.println("0. 프로그램 종료");
		System.out.println("***************");
		
//		0번을 눌러서 종료할때까지 무한반복
		while(true) {
			
//			실제로 어디로 가고싶은지 입력받는 부분
			System.out.println("메뉴입력 : ");			
			int menuInput = scan.nextInt();
			
//			입력값에 따른 대응 방법 분기처리
			if(menuInput ==0) {
//				프로그램 종료 => 무한반복만 빠져나가면 그 뒤는 알아서 종료
//				안내만 찍고 바로 break; 해서 (무한반복) 종료
				System.out.println("전화번호부를 종료합니다.");
				break;//끝내기 위해서
			}
			else if(menuInput == 1) {
//				파일에 전화번호 추가하는 기능
				writeUserInfoToFile();
				
			}
			else if(menuInput == 2) {
//				파일안에 목록 모두 조회하는 기능
				printUsers();
			}
			else {
//				0,1,2 이외의 값은 잘못된 값
//				해당사항이 없는 번호를 누르면 이렇게된다
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
		
	}
	
	
	static void printUsers() {
		
//		저장된 파일위치 불러오기
		File phoneBookFile = new File("phoneBook.csv");
		
//		배열만들어서 유저갯수 파악하기
		List<User> myFriends = new ArrayList<User>();
		
		try {
			
			FileReader fr = new FileReader(phoneBookFile);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				
				String line = br.readLine();
				
				if(line==null) {
					System.out.println("모두 읽었습니다");
					System.out.println(String.format("연락처에 총 %d명이 저장되어있습니다.", myFriends.size()));
					break;
				}
				
//				유저정보 "," 기준으로 나누기
				String[] userInfos = line.split(",");
				String userName = userInfos[0];
				String userPhone = userInfos[1];
				int userYear = Integer.parseInt(userInfos[2]);
				
//				System.out.println(String.format("%s(%d세) : %s", userName,userYear,userPhone)); //순서를 잘맞춰야됌
			
				
				User user = new User(userName,userYear,userPhone);
				
//				유저 몆명인지 추가하면서 파악
				myFriends.add(user);
				
				System.out.println(user);
				
			}
//			사용한 파일 닫아주기
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			
			System.out.println("아직 저장한 사람이 없습니다.");
		} catch (IOException e) {
//			e.printStackTrace();
			
			System.out.println("파일을 읽는중에 문제가 생겼습니다.");
		}
	}
	
	static void writeUserInfoToFile() {
		
//		스캐너로 이름 /폰번 /생년을 입력받는다
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		
		System.out.println("폰번 입력 : ");
		String phone = scan.nextLine();
		
		System.out.println("생년 입력 : ");
		int year = scan.nextInt();
		
//		입력된 값을 파일에저장 어느파일에 저장할지 경로부터지정
//		File 자동완성 시켜야됌 (ios)
		File phoneBookFile = new File("phoneBook.csv");
		
//		파일 출력중에 예외 발생 소지가 있다 => FileWriter 쓸때 에러발생
		try {
			
//			실제로 파일에 접근해주는 변수 이어붙이기모드 활성화 (true)
			FileWriter fw = new FileWriter(phoneBookFile, true);
			
//			String을 한번에 기록해주기 위해 (작업의 편의성을 위해) 사용하는 변수
			BufferedWriter bw = new BufferedWriter(fw);
			
//			입력된 값을 한줄의 String으로 가공 (한번에 다 기록하려고)
			String inputContent = String.format("%s,%s,%d", name,phone,year);
			
//			실제파일에 추가 기록+줄바꿈
			bw.append(inputContent);
			bw.newLine(); //줄바꿔라
			
//			파일사용 마쳤으면 닫아주자
			bw.close();
			fw.close();
			
//			저장이 완료되었을때
			System.out.println("연락처 저장이 완료되었습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
