package com.biz.homework.main;

import com.biz.homework.service.ScoreService;
import com.biz.homework.service.ScoreServiceImplV1;

public class Main {
	public static void main(String[] args) {
		ScoreService sService = new ScoreServiceImplV1();
		sService.inputScore();
		sService.inputStudent();
		sService.calcSum();
		sService.calcAvg();
		sService.studentList();
				
		
	}

}
