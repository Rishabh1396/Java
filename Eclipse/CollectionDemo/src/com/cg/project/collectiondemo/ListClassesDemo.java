package com.cg.project.collectiondemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import com.cg.project.beans.Associate;

public class ListClassesDemo {
	public static void arrayListClassWork() {
		LinkedList<String> strList = new LinkedList<>();
		strList.add("Satish");
		strList.add("Kumar");
		strList.add("Nilesh");
		strList.add("Satish");
		strList.add("Rakesh");
		strList.add("Kunal");
		System.out.println(strList.contains("Satish"));
		System.out.println(strList.indexOf("Satish"));
		Collections.sort(strList);
		for (String name : strList) {
			System.out.println(name);
		}
		ArrayList<Associate> associateList = new ArrayList<>();
		associateList.add(new Associate(101,15000,"Satish"));
		associateList.add(new Associate(103,16742,"Kumar"));
		associateList.add(new Associate(102,173378,"Nilesh"));
		associateList.add(new Associate(104,13463,"Rakesh"));
		Associate associateToBeSearch = new Associate(102, 173378, "Nilesh");
		System.out.println(associateList.indexOf(associateToBeSearch));
		System.out.println(associateList.contains(associateToBeSearch));
		Collections.sort(associateList,new AssociateComparator());
		for (Associate associate : associateList) {
			if (associate.getAssociateId()==103 && associate.getName().equals("Nilesh")); {
				
			}
		}
	}

}
