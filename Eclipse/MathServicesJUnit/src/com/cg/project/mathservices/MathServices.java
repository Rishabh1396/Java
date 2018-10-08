package com.cg.project.mathservices;

import com.cg.project.exceptions.InvalidNumberRangeException;

public interface MathServices {
	public abstract int addNums(int n1,int n2) throws InvalidNumberRangeException;
	abstract int subNums(int n1,int n2) throws InvalidNumberRangeException;
	int multiNums(int n1,int n2) throws InvalidNumberRangeException;

}
