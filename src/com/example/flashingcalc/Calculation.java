package com.example.flashingcalc;

import java.util.ArrayList;

public class Calculation {
	static ArrayList<String> expList;

	public String result(String expreString) {
		expList = new ArrayList<String>();
		try {
			String stringOfParsed = (parseExp(expreString));// 在expList中通过$进行索引
			String stringOfResult = "" + recurCal(stringOfParsed);
			return stringOfResult;
		} catch (Exception e) {
			return "FalseGrammar";//如果算式解析或者计算出现错误，则返回提示信息。
		}
	}

	// 在expList中通过$进行索引
	public static String parseExp(String expStr) throws ArithmeticException {
		if (expStr.matches("[+-//*/]{2,}")) {	//如果算式中出现2个以上连续符号则抛出异常
			throw new ArithmeticException();
		}
		int first=0;
		int last=0;
		if ((first = expStr.lastIndexOf("(")) != -1) {
			for (int i = first; i < expStr.length(); i++) {
				if (expStr.charAt(i) == ')') {
					last = i;
					String str = expStr.substring(first + 1, last);
					String stransstr = expStr.substring(0, first) + "$" + expList.size()+ expStr.substring(last + 1, expStr.length());
					expList.add(str);
					return parseExp(stransstr);
				}
			}
		}
		return expStr;
	}

	// 递归地求解算式
	public static double recurCal(String expStr) throws ArithmeticException {

		try {
			// 由上向下递归地求解，保证优先级顺序
			if (expStr.lastIndexOf("+") != -1 || expStr.lastIndexOf("-") != -1) {
				return plusOrMinus(expStr);
			}
			if (expStr.lastIndexOf("*") != -1 || expStr.lastIndexOf("/") != -1|| expStr.lastIndexOf("%") != -1) {
				return mulOrDivOrRem(expStr);
			}
			// 处理后若为单符号算式则运算
			if (expStr.indexOf("√") == 0) {
				return sqrt(expStr);
			}
			if (expStr.indexOf("sin") == 0) {
				return sin(expStr);
			}
			if (expStr.indexOf("cos") == 0) {
				return cos(expStr);
			}
			if (expStr.indexOf("tan") == 0) {
				return tan(expStr);
			}
			// 最高优先级，将()看做一个字符串处理，由$索引在List中引用
			if (expStr.indexOf("$") == 0) {
				return moneySign(expStr);
			}
			// 若只剩单个数字，直接返回
			return Double.parseDouble(expStr);
		} catch (Exception e) {
			throw new ArithmeticException();
		}

	}

	public static double plusOrMinus(String s) {
		if (s.lastIndexOf("+") - s.lastIndexOf("-") > 0) {
			int i = s.lastIndexOf("+");
			return (s.substring(0, i).equals("") ? 0 : recurCal(s.substring(0,i))) + recurCal(s.substring(i + 1, s.length()));
		} 
		else {
			int i = s.lastIndexOf("-");
			return (s.substring(0, i).equals("") ? 0 : recurCal(s.substring(0,i))) - recurCal(s.substring(i + 1, s.length()));
		}
	}

	public static double mulOrDivOrRem(String s) {
		int i1 = s.lastIndexOf("*");
		int i2 = s.lastIndexOf("/");
		int i3 = s.lastIndexOf("%");
		if (i1 > i2 && i1 > i3) {
			return recurCal(s.substring(0, s.lastIndexOf("*")))	* recurCal(s.substring(s.lastIndexOf("*") + 1, s.length()));
		} 
		else if (i2 > i1 && i2 > i3) {
			return recurCal(s.substring(0, s.lastIndexOf("/")))	/ recurCal(s.substring(s.lastIndexOf("/") + 1, s.length()));
		} 
		else {
			System.out.println("%");
			return recurCal(s.substring(0, s.lastIndexOf("%")))	% recurCal(s.substring(s.lastIndexOf("%") + 1, s.length()));
		}
	}
	// 取出ArrayList索引中的字符串，放入recurCal中递归
	public static double moneySign(String s) {
		String[] str = s.split("\\$");
		return recurCal(expList.get(Integer.parseInt(str[1])));
	}
	//加减
	public static double plus(String s) {
		String[] str = s.split("\\+");
		double d = str[0].equals("") ? 0 : recurCal(str[0]);
		for (int i = 1; i < str.length; i++) {

			d += recurCal(str[i]);
		}
		return d;
	}
	public static double minus(String s) {
		String[] str = s.split("-");
		double d = str[0].equals("") ? 0 : recurCal(str[0]);
		for (int i = 1; i < str.length; i++) {

			d -= recurCal(str[i]);
		}
		return d;
	}
	//乘除
	public static double multiply(String s) {
		String[] str = s.split("\\*");
		double d = recurCal(str[0]);
		for (int i = 1; i < str.length; i++) {
			d *= recurCal(str[i]);
		}
		return d;
	}
	public static double division(String s) {
		String[] str = s.split("\\/");
		double d = recurCal(str[0]);
		for (int i = 1; i < str.length; i++) {
			d /= recurCal(str[i]);
		}
		return d;
	}
	// 三角函数
	private static double sin(String s) {
		String[] str = s.split("sin");
		return Math.sin(Math.PI / 180 * recurCal(str[1]));
	}
	private static double cos(String s) {
		String[] str = s.split("cos");
		return Math.cos(Math.PI / 180 * recurCal(str[1]));
	}
	private static double tan(String s) {
		String[] str = s.split("tan");
		return Math.tan(Math.PI / 180 * recurCal(str[1]));
	}
	// 开方
	public static double sqrt(String s) {
		String[] str = s.split("√");
		return recurCal("" + Math.sqrt(recurCal(str[1])));
	}
}