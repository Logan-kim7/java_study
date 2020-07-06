package com.biz.homework.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.homework.domain.ScoreVO;

public class ScoreServiceImplV1 implements ScoreService {
	List<ScoreVO> scoreList;
	public ScoreServiceImplV1() {
		scoreList = new ArrayList<ScoreVO>();
		
	}
	
	public void inputStudent() {
		//주소값에 있는 경로설정
		String studentFile = "src/com/biz/homework/service/student.txt";
		// 문자열 객체 선언 및 선언
		String[] students;
		//파일 읽어오기 & 저장공간 확보를 위한 초기화
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		//try 문을 활용하여 예외 처리
		try {
			// fileReader생성자에 매개변수로 studentFile을 담는다
			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);
			int count = 0;
			String reader = "";
			while(true) {
				//textfile을 한줄씩 읽어서 가져온다.
				
				reader = buffer.readLine();
				
				if(reader == null || count == 30) {
					break;
				}
				students = reader.split(":");
				
				ScoreVO vo = new ScoreVO();
				vo.setNum(students[0]);
				vo.setName(students[1]);
				vo.setGrade((students[2]));
				vo.setDeep((students[4]));
				scoreList.add(vo);
				count++;
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void inputScore() {
		//주소값에 있는 경로설정
		String studentFile = "src/com/biz/homework/service/score.txt";
		// 문자열 객체 선언 및 선언
		String[] students;
		//파일 읽어오기 & 저장공간 확보를 위한 초기화
		FileReader fileReader = null;
		BufferedReader buffer = null;
		int i = 0;
		int count = 0;
		//try 문을 활용하여 예외 처리
		try {
			// fileReader생성자에 매개변수로 studentFile을 담는다
			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);
			
			String reader = "";
			
			while(true) {
				// textfile을 한줄씩 읽어서 가져온다.
				reader = buffer.readLine();
				
				if(reader == null || count == 30) {
					break;
				}
				students = reader.split(":");
				
				scoreList.get(i).setKor(Integer.valueOf(students[1]));
				scoreList.get(i).setEng(Integer.valueOf(students[2]));
				scoreList.get(i).setMath(Integer.valueOf(students[3]));
				i++;
				count++;
			}
			buffer.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void calcSum() {
		int d = 0;
		int b = 0;
		int c = 0;
		
		for(ScoreVO a : scoreList ) {
			d = a.getKor();
			b = a.getEng();
			c = a.getMath();
			a.setSum(b+c+d);
		}
		
		
	}

	@Override
	public void calcAvg() {
		
		for(ScoreVO a : scoreList) {
			a.setAvg((float)(a.getSum())/3f);
			
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void studentList() {
		
		System.out.println("=======================================");
		System.out.println(" 학생성적 일람표 ");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("=======================================");
		System.out.println();
		for(ScoreVO a : scoreList) {
			System.out.print(a.getNum()+"\t");
			System.out.print(a.getName()+"\t");
			System.out.print(a.getKor()+"\t");
			System.out.print(a.getEng()+"\t");
			System.out.print(a.getMath()+"\t");
			System.out.print(a.getSum()+"\t");
			System.out.println(a.getAvg());
			System.out.println("=======================================");
		}
		
	
		// TODO Auto-generated method stub
		
	}
	
	

}
