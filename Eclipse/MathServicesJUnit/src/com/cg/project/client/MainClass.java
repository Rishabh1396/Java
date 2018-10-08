package com.cg.project.client;

import com.cg.project.mathservices.MathServices;
import com.cg.project.mathservices.MathServicesImpl;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			MathServices services = new MathServicesImpl() {

				@Override
				public int subNums(int n1, int n2) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public int multiNums(int n1, int n2) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public int addNums(int n1, int n2) {
					// TODO Auto-generated method stub
					return 0;
				}
			};
		} catch (Exception e) {
			
		}

	}

}
