package com.javakc.mbti.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.javakc.mbti.service.Service;
import com.javakc.mbti.service.factory.ServiceFactory;
import com.javakc.mbti.vo.Option;
import com.javakc.mbti.vo.Question;
import com.javakc.mbti.vo.Result;

public class App {
  Service service=ServiceFactory.getService();
   public static final String[]arr={"A","B"};
   public void start() {
	   Scanner scan=new Scanner(System.in);
	System.out.println("≤‚ ‘Œ æÌ:");
	try {
		List<Question> qs=service.readQuestion();
		List result = new ArrayList();
		for (Question q:qs) {
			System.out.println(q.getTitle());
			for (int i = 0; i < q.getOptions().size(); i++) {
				System.out.println(arr[i]+" ");
				Option o=q.getOptions().get(i);
				System.out.println(o.getTitle());
			}
			System.out.println("«Î ‰»Îƒ„µƒ—°‘Ò£∫");
			String answer = scan.next();
			if (answer.matches("[abAB]")) {
				if (answer.equalsIgnoreCase("A")) {
					System.out.println(q.getOptions().get(0).getScore());
					result.add(q.getOptions().get(0).getScore());
				}else {
					System.out.println(q.getOptions().get(1).getScore());
					result.add(q.getOptions().get(1).getScore());
				}
			}
			System.out.println();
		}
		String s=service.parseResult(result);
		System.out.println(s);
		
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
}
   public static void main(String[] args) {
	App app=new App();
	app.start();
}
}
