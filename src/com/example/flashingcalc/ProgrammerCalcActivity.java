package com.example.flashingcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

public class ProgrammerCalcActivity extends Activity {

	private Button buttonOfChangeModeToSt = null;
	private StringBuffer StandardExpression;
	//
	private Button tansform;
	private Button clean;
	private Button backward;
	private EditText two = null;
	private EditText eight = null;
	private EditText ten = null;
	private EditText sixteen = null;
	//
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
	//
	private Button buttonOfA = null;
	private Button buttonOfB = null;
	private Button buttonOfC = null;
	private Button buttonOfD = null;
	private Button buttonOfE = null;
	private Button buttonOfF = null;
	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_programmer_calc);

		buttonOfChangeModeToSt = (Button) findViewById(R.id.changemodetost);
		buttonOfChangeModeToSt.setOnClickListener(new buttonOfChangeModeListener());

		StandardExpression = new StringBuffer("");

		tansform = (Button) findViewById(R.id.trans);
		clean = (Button) findViewById(R.id.clean);
		backward = (Button) findViewById(R.id.backward);
		two = (EditText) findViewById(R.id.two);
		eight = (EditText) findViewById(R.id.eight);
		ten = (EditText) findViewById(R.id.ten);
		sixteen = (EditText) findViewById(R.id.sixteen);

		tansform.setOnClickListener(new buttonOfTransListener());
		clean.setOnClickListener(new buttonOfTransListener());
		backward.setOnClickListener(new buttonOfBackListener());

		two.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				two.setInputType(InputType.TYPE_NULL); // 关闭软键盘
				return false;
			}
		});
		eight.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				eight.setInputType(InputType.TYPE_NULL); // 关闭软键盘
				return false;
			}
		});
		ten.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				ten.setInputType(InputType.TYPE_NULL); // 关闭软键盘
				return false;
			}
		});
		sixteen.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				sixteen.setInputType(InputType.TYPE_NULL); // 关闭软键盘
				return false;
			}
		});

		// 数字按钮点击响应函数
		// 0
		buttonOfNumZero = (Button) findViewById(R.id.zerop);
		buttonOfNumZero.setOnClickListener(new buttonOfNumZeroListener());
		// 1
		buttonOfNumOne = (Button) findViewById(R.id.onep);
		buttonOfNumOne.setOnClickListener(new buttonOfNumOneListener());
		// 2
		buttonOfNumTwo = (Button) findViewById(R.id.twop);
		buttonOfNumTwo.setOnClickListener(new buttonOfNumTwoListener());
		// 3
		buttonOfNumThree = (Button) findViewById(R.id.threep);
		buttonOfNumThree.setOnClickListener(new buttonOfNumThreeListener());
		// 4
		buttonOfNumFour = (Button) findViewById(R.id.fourp);
		buttonOfNumFour.setOnClickListener(new buttonOfNumFourListener());
		// 5
		buttonOfNumFive = (Button) findViewById(R.id.fivep);
		buttonOfNumFive.setOnClickListener(new buttonOfNumFiveListener());
		// 6
		buttonOfNumSix = (Button) findViewById(R.id.sixp);
		buttonOfNumSix.setOnClickListener(new buttonOfNumSixListener());
		// 7
		buttonOfNumSeven = (Button) findViewById(R.id.sevenp);
		buttonOfNumSeven.setOnClickListener(new buttonOfNumSevenListener());
		// 8
		buttonOfNumEight = (Button) findViewById(R.id.eightp);
		buttonOfNumEight.setOnClickListener(new buttonOfNumEightListener());
		// 9
		buttonOfNumNine = (Button) findViewById(R.id.ninep);
		buttonOfNumNine.setOnClickListener(new buttonOfNumNineListener());
		//
		buttonOfA = (Button) findViewById(R.id.A);
		buttonOfA.setOnClickListener(new buttonOfAListener());
		//
		buttonOfB = (Button) findViewById(R.id.B);
		buttonOfB.setOnClickListener(new buttonOfBListener());
		//
		buttonOfC = (Button) findViewById(R.id.C);
		buttonOfC.setOnClickListener(new buttonOfCListener());
		//
		buttonOfD = (Button) findViewById(R.id.D);
		buttonOfD.setOnClickListener(new buttonOfDListener());
		//
		buttonOfE = (Button) findViewById(R.id.E);
		buttonOfE.setOnClickListener(new buttonOfEListener());
		//
		buttonOfF = (Button) findViewById(R.id.F);
		buttonOfF.setOnClickListener(new buttonOfFListener());

	}
	class buttonOfBackListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (StandardExpression.length() > 0) {
				StandardExpression
						.deleteCharAt(StandardExpression.length() - 1);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}
	
	class buttonOfChangeModeListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {

			Intent intentToSt = new Intent();
			intentToSt.setClass(ProgrammerCalcActivity.this,
					StandardCalcActivity.class);
			ProgrammerCalcActivity.this.startActivity(intentToSt);
		}
	}

	class buttonOfTransListener implements View.OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String temp = null, num1 = null, num2 = null, num3 = null, num4 = null;
			switch (v.getId()) {
			case R.id.trans: {

				if (two.hasFocus()) {
					try {
						temp = two.getText().toString();
						num3 = Integer.valueOf(temp, 2).toString();// 将二进制转换为十进制；
						num2 = Integer.toOctalString(Integer.parseInt(num3));
						num4 = Integer.toHexString(Integer.parseInt(num3));
						eight.setText(num2);
						ten.setText(num3);
						sixteen.setText(num4.toUpperCase());
					} catch (Exception e) {

					}
				} else if (eight.hasFocus()) {
					try {
						temp = eight.getText().toString();
						num3 = Integer.valueOf(temp, 8).toString();
						num1 = Integer.toBinaryString(Integer.parseInt(num3));
						num4 = Integer.toHexString(Integer.parseInt(num3));
						two.setText(num1);
						ten.setText(num3);
						sixteen.setText(num4.toUpperCase());
					} catch (Exception e) {

					}
				} else if (ten.hasFocus()) {
					try {
						num3 = ten.getText().toString();
						num1 = Integer.toBinaryString(Integer.parseInt(num3));
						num2 = Integer.toOctalString(Integer.parseInt(num3));
						num4 = Integer.toHexString(Integer.parseInt(num3));
						two.setText(num1);
						eight.setText(num2);
						sixteen.setText(num4.toUpperCase());
					} catch (Exception e) {

					}
				} else if (sixteen.hasFocus()) {
					try {
						temp = sixteen.getText().toString();
						num3 = Integer.valueOf(temp, 16).toString();
						num1 = Integer.toBinaryString(Integer.parseInt(num3));
						num2 = Integer.toOctalString(Integer.parseInt(num3));
						two.setText(num1);
						eight.setText(num2);
						ten.setText(num3);
						sixteen.setText(temp.toUpperCase());
					} catch (Exception e) {

					}
				}
				StandardExpression.delete(0, StandardExpression.length());
			}
				break;
			case R.id.clean:
				two.setText("");
				eight.setText("");
				ten.setText("");
				sixteen.setText("");
				break;
			
			}
		}
	};

	private EditText editTextFocus() {
		if (two.hasFocus()) {
			return two;
		}
		if (eight.hasFocus()) {
			return eight;
		}
		if (ten.hasFocus()) {
			return ten;
		}
		if (sixteen.hasFocus()) {
			return sixteen;
		}
		return null;
	}

	// 数字按键响应
	class buttonOfNumZeroListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(0);
			editTextFocus().setText(StandardExpression);
			editTextFocus().setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumOneListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			StandardExpression.append(1);
			editTextFocus().setText(StandardExpression);
			editTextFocus().setSelection(StandardExpression.length());
		}
	}

	class buttonOfNumTwoListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() != two) {
				StandardExpression.append(2);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumThreeListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() != two) {
				StandardExpression.append(3);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumFourListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() != two) {
				StandardExpression.append(4);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumFiveListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() != two) {
				StandardExpression.append(5);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumSixListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() != two) {
				StandardExpression.append(6);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumSevenListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() != two) {
				StandardExpression.append(7);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumEightListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen || editTextFocus() == ten) {
				StandardExpression.append(8);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfNumNineListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen || editTextFocus() == ten) {
				StandardExpression.append(9);
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfAListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen) {
				StandardExpression.append('A');
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfBListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen) {
				StandardExpression.append('B');
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfCListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen) {
				StandardExpression.append('C');
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfDListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen) {
				StandardExpression.append('D');
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfEListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen) {
				StandardExpression.append('E');
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}

	class buttonOfFListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			if (editTextFocus() == sixteen) {
				StandardExpression.append('F');
				editTextFocus().setText(StandardExpression);
				editTextFocus().setSelection(StandardExpression.length());
			}
		}
	}
}
