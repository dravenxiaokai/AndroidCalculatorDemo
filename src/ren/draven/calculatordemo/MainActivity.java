package ren.draven.calculatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_0;// 0数字按钮
	private Button btn_1;// 1数字按钮
	private Button btn_2;// 2数字按钮
	private Button btn_3;// 3数字按钮
	private Button btn_4;// 4数字按钮
	private Button btn_5;// 5数字按钮
	private Button btn_6;// 6数字按钮
	private Button btn_7;// 7数字按钮
	private Button btn_8;// 8数字按钮
	private Button btn_9;// 9数字按钮
	private Button btn_point;// 小数点按钮
	private Button btn_clear;// 清除按钮
	private Button btn_del;// 删除按钮
	private Button btn_plus;// 加号按钮
	private Button btn_minus;// 减号按钮
	private Button btn_multiply;// 乘号按钮
	private Button btn_divide;// 除号按钮
	private Button btn_equal;// 等于按钮
	EditText ed_input;// 显示输入内容的显示屏
	boolean clear_flag;//清空标识

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 实例化按钮
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_plus = (Button) findViewById(R.id.btn_plus);
		btn_minus = (Button) findViewById(R.id.btn_minus);
		btn_multiply = (Button) findViewById(R.id.btn_multiply);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		// 实例化显示屏
		ed_input = (EditText) findViewById(R.id.ed_input);

		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_equal.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		String str = ed_input.getText().toString();
		switch (v.getId()) {
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:
			if(clear_flag){
				clear_flag = false;
				str = "";
				ed_input.setText("");
			}
			ed_input.setText(str + ((Button) v).getText());
			break;
		case R.id.btn_plus:
		case R.id.btn_minus:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			if(clear_flag){
				clear_flag = false;
				str = "";
				ed_input.setText("");
			}
			ed_input.setText(str + " " + ((Button) v).getText() + " ");
			break;
		case R.id.btn_clear:
			clear_flag=false;
			ed_input.setText("");
			break;
		case R.id.btn_del:
			if(clear_flag){
				clear_flag = false;
				str = "";
				ed_input.setText("");
			}else if (str!=null&&!str.equals("")) {
				ed_input.setText(str.substring(0,str.length()-1));
			}
			break;
		case R.id.btn_equal:
			getResult();
			break;

		default:
			break;
		}
	}
	/*
	 * 运算结果
	 */
	private void getResult(){
		String exp = ed_input.getText().toString();
		if (exp==null||exp.equals("")) {
			return;
		}
		if (!exp.contains(" ")) {
			return;
		}
		if (clear_flag) {
			clear_flag = false;
			return;
		}
		clear_flag = true;
		double result = 0;
		String s1 = exp.substring(0,exp.indexOf(" "));//运算符前面的字符串
		String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//运算符
		String s2 = exp.substring(exp.indexOf(" ")+3);//运算符后面的字符串
		if (!s1.equals("")&&!s2.equals("")) {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if (op.equals("+")) {
				result = d1 + d2;
			}else if (op.equals("-")) {
				result = d1 - d2;
			}else if (op.equals("×")) {
				result = d1 * d2;
			}else if (op.equals("÷")) {
				if (d2==0) {
					result = 0;
				}else {
					result = d1 / d2;
				}
			}
			if (!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")) {
				int r = (int)result;
				ed_input.setText(r+"");
			}else {
				ed_input.setText(result+"");
			}
		}else if (!s1.equals("")&&s2.equals("")) {
			ed_input.setText(exp);
		}else if (s1.equals("")&&!s2.equals("")) {
			double d2 = Double.parseDouble(s2);
			if (op.equals("+")) {
				result = 0 + d2;
			}else if (op.equals("-")) {
				result = 0 - d2;
			}else if (op.equals("×")) {
				result = 0 * d2;
			}else if (op.equals("÷")) {
				result = 0;
			}
			if (!s1.contains(".")&&!s2.contains(".")) {
				int r = (int)result;
				ed_input.setText(r+"");
			}else {
				ed_input.setText(result+"");
			}
		}else {
			ed_input.setText("");
		}
	}
}
