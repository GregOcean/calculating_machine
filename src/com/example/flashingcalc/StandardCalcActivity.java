package com.example.flashingcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

public class StandardCalcActivity extends Activity {
	// Xpression
	private StringBuffer StandardExpression;
	private String StExp;

	// changemode
	private Button buttonOfChangeModeToPro = null;
	// 计算
	private Button buttonOfCalc = null;
	// number
	private Button buttonOfNumZero = null;
	private Button buttonOfNumOne = null;
	private Button buttonOfNumTwo = null;
	private Button buttonOfNumThree = null;
	private Button buttonOfNumFour = null;
	private Button buttonOfNumFive = null;
	private Button buttonOfNumSix = null;
	private Button buttonOfNumSeven = null;
	private Button buttonOfNumEight = null;
	private Button buttonOfNumNine = null;
	// opr
	private Button buttonOfPlus = null;
	private Button buttonOfMinus = null;
	private Button buttonOfMultiply = null;
	private Button buttonOfDivide = null;
	private Button buttonOfRemainder = null;// 求余
	private Button buttonOfReciprocal = null;// 求倒数
	// parentheses
	private Button buttonOfLeftQuote = null;
	private Button buttonOfRightQuote = null;
	// Dot
	private Button buttonOfDot = null;
	// Ans
	private Button buttonOfAns = null;
	// Editor
	private EditText editTextOfStandard = null;

	private Integer strSaveNum = 0;
	private Integer strShowPointer = 0;
	// 计算结果
	private Calculation answer = new Calculation();
	// Ans
	private String Ans;
	//
	private Button buttonOfCe;
	private Button buttonOfBack;
	private Button buttonOfPre;
	private Button buttonOfNext;
	//
	private Button buttonOfSin;
	private Button buttonOfCos;
	private Button buttonOfTan;
	//
	private Button buttonOfRoot;
	//
	private String preStr = "";
	private String nextStr = "";
	//
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_standard_calc);
		// 表达式字符串
		StandardExpression = new StringBuffer("");
		// 模式转换
		buttonOfChangeModeToPro = (Button) findViewById(R.id.changemodetopro);
		buttonOfChangeModeToPro.setOnClickListener(new buttonOfChangeModeListener());
		// 屏蔽软键盘
		editTextOfStandard = (EditText) findViewById(R.id.editTextOfSt);
		editTextOfStandard.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				editTextOfStandard.setInputType(InputType.TYPE_NULL); // 关闭软键盘
				return false;
			}
		});

		// 计算
		buttonOfCalc = (Button) findViewById(R.id.equal);
		buttonOfCalc.setOnClickListener(new buttonOfCalcListener());
		// 数字按钮点击响应函数
		// 0
		buttonOfNumZero = (Button) findViewById(R.id.zero);
		buttonOfNumZero.setOnClickListener(new buttonOfNumZeroListener());
		// 1
		buttonOfNumOne = (Button) findViewById(R.id.one);
		buttonOfNumOne.setOnClickListener(new buttonOfNumOneListener());
		// 2
		buttonOfNumTwo = (Button) findViewById(R.id.two);
		buttonOfNumTwo.setOnClickListener(new buttonOfNumTwoListener());
		// 3
		buttonOfNumThree = (Button) findViewById(R.id.three);
		buttonOfNumThree.setOnClickListener(new buttonOfNumThreeListener());
		// 4
		buttonOfNumFour = (Button) findViewById(R.id.four);
		buttonOfNumFour.setOnClickListener(new buttonOfNumFourListener());
		// 5
		buttonOfNumFive = (Button) findViewById(R.id.five);
		buttonOfNumFive.setOnClickListener(new buttonOfNumFiveListener());
		// 6
		buttonOfNumSix = (Button) findViewById(R.id.six);
		buttonOfNumSix.setOnClickListener(new buttonOfNumSixListener());
		// 7
		buttonOfNumSeven = (Button) findViewById(R.id.seven);
		buttonOfNumSeven.setOnClickListener(new buttonOfNumSevenListener());
		// 8
		buttonOfNumEight = (Button) findViewById(R.id.eight);
		buttonOfNumEight.setOnClickListener(new buttonOfNumEightListener());
		// 9
		buttonOfNumNine = (Button) findViewById(R.id.nine);
		buttonOfNumNine.setOnClickListener(new buttonOfNumNineListener());
		// Opr
		// +
		buttonOfPlus = (Button) findViewById(R.id.plus);
		buttonOfPlus.setOnClickListener(new buttonOfPlusListener());
		// -
		buttonOfMinus = (Button) findViewById(R.id.minus);
		buttonOfMinus.setOnClickListener(new buttonOfMinusListener());
		// *
		buttonOfMultiply = (Button) findViewById(R.id.multiply);
		buttonOfMultiply.setOnClickListener(new buttonOfMultiplyListener());
		// /
		buttonOfDivide = (Button) findViewById(R.id.divide);
		buttonOfDivide.setOnClickListener(new buttonOfDivideListener());
		// %
		buttonOfRemainder = (Button) findViewById(R.id.remainder);
		buttonOfRemainder.setOnClickListener(new buttonOfRemainderListener());
		// 1/x
		buttonOfReciprocal = (Button) findViewById(R.id.reciprocal);
		buttonOfReciprocal.setOnClickListener(new buttonOfReciprocalListener());
		// dot .
		buttonOfDot = (Button) findViewById(R.id.dot);
		buttonOfDot.setOnClickListener(new buttonOfDotListener());
		// ans
		buttonOfAns = (Button) findViewById(R.id.ans);
		buttonOfAns.setOnClickListener(new buttonOfAnsListener());
		// parentheses
		buttonOfLeftQuote = (Button) findViewById(R.id.leftquote);
		buttonOfLeftQuote.setOnClickListener(new buttonOfLeftQuoteListener());
		// ()
		buttonOfRightQuote = (Button) findViewById(R.id.rightquote);
		buttonOfRightQuote.setOnClickListener(new buttonOfRightQuoteListener());
		//
		buttonOfSin = (Button) findViewById(R.id.sin);
		buttonOfSin.setOnClickListener(new buttonOfSinListener());
		buttonOfCos = (Button) findViewById(R.id.cos);
		buttonOfCos.setOnClickListener(new buttonOfCosListener());
		buttonOfTan = (Button) findViewById(R.id.tan);
		buttonOfTan.setOnClickListener(new buttonOfTanListener());
		// CE
		buttonOfCe = (Button) findViewById(R.id.CE);
		buttonOfCe.setOnClickListener(new buttonOfCeListener());
		//
		buttonOfBack = (Button) findViewById(R.id.backspace);
		buttonOfBack.setOnClickListener(new buttonOfBackListener());
		//
		buttonOfPre = (Button) findViewById(R.id.previousX);
		buttonOfPre.setOnClickListener(new buttonOfPreListener());
		//
		buttonOfNext = (Button) findViewById(R.id.nextX);
		buttonOfNext.setOnClickListener(new buttonOfNextListener());
		// 开方
		buttonOfRoot = (Button) findViewById(R.id.root);
		buttonOfRoot.setOnClickListener(new buttonOfRootListener());
	}

	class StrArray {
		public String strArray;
	}

	// pre
	class buttonOfPreListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (strShowPointer == 0) {
				editTextOfStandard.setText(preStr);
				editTextOfStandard.setSelection(preStr.length());
				strShowPointer = 1;
			}
		}
	}

	// next
	class buttonOfNextListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (strShowPointer == 1) {
				editTextOfStandard.setText(nextStr);
				editTextOfStandard.setSelection(nextStr.length());
				strShowPointer = 0;
			}
		}
	}

	// 计算//
	class buttonOfCalcListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StExp = StandardExpression.toString();
			Ans = answer.result(StExp);
			if(Ans.charAt(Ans.length()-1)=='0'&&Ans.charAt(Ans.length()-2)=='.')
			{
				Ans=Ans.substring(0,Ans.length()-2);
			}
			///////////////////////////////////////////////////////////
			editTextOfStandard.setText(Ans);
			editTextOfStandard.setSelection(Ans.length());
			preStr = nextStr;
			nextStr = StExp;
			strShowPointer = 0;

			StandardExpression.delete(0, StandardExpression.length());
		}
	}

	//
	// 跳转Activity
	class buttonOfChangeModeListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intentToPro = new Intent();
			intentToPro.setClass(StandardCalcActivity.this,
					ProgrammerCalcActivity.class);
			StandardCalcActivity.this.startActivity(intentToPro);
		}
	}

	/*
     *  
     */
	// 数字按键响应
	class buttonOfNumZeroListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(0);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumOneListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(1);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumTwoListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(2);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumThreeListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(3);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumFourListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(4);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumFiveListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(5);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumSixListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(6);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumSevenListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(7);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumEightListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(8);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumNineListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(9);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	//
	// OprClickListener
	class buttonOfPlusListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('+');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfMinusListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('-');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfMultiplyListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('*');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfDivideListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('/');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfRemainderListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('%');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfRootListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('√');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	// 1/x
	class buttonOfReciprocalListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StExp = editTextOfStandard.getText().toString();
			if (StExp.length() > 0) {
				// StExp = StandardExpression.toString();
				Ans = answer.result(StExp);
				double reciAns = Double.parseDouble(Ans);
				reciAns = 1 / reciAns;
				Ans = Double.toString(reciAns);
				if(Ans.charAt(Ans.length()-1)=='0'&&Ans.charAt(Ans.length()-2)=='.')
				{
					Ans=Ans.substring(0,Ans.length()-2);
				}
				StandardExpression.delete(0, StandardExpression.length());
				StandardExpression.append(Ans);
				editTextOfStandard.setText(StandardExpression);

				editTextOfStandard.setSelection(StandardExpression.length());
				StandardExpression.delete(0, StandardExpression.length());
			}
		}
	}

	//
	// DotClickListener
	class buttonOfDotListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('.');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	// ans
	class buttonOfAnsListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(Ans);
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	// CE
	class buttonOfCeListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.delete(0, StandardExpression.length());
			editTextOfStandard.setText(StandardExpression);

		}
	}

	// Back
	class buttonOfBackListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (StandardExpression.length() > 0) {
				StandardExpression
						.deleteCharAt(StandardExpression.length() - 1);
				editTextOfStandard.setText(StandardExpression);
				editTextOfStandard.setSelection(StandardExpression.length());
			}
		}
	}

	// sin
	class buttonOfSinListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append("sin");
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	//
	class buttonOfCosListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append("cos");
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	//
	class buttonOfTanListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append("tan");
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	// parentheses
	class buttonOfLeftQuoteListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append('(');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	class buttonOfRightQuoteListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(')');
			editTextOfStandard.setText(StandardExpression);
			editTextOfStandard.setSelection(StandardExpression.length());
		}
	}

	// Menu响应（Seems Useless）
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_standard_calc, menu);
		return true;
	}
}
