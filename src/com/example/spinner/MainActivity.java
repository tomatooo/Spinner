package com.example.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private Spinner spinner = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner = (Spinner) findViewById(R.id.spinnerld);
		//通过createFromResource方法创建一个ArrayAdapter对象
		//第二个参数 引用了在strings。xml文件中定义的string数组
		//第三个参数用来指定spinner的样式，是布局文件ID，用系统的。
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.planets_array,
				android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setPrompt("测试");
		spinner.setOnItemSelectedListener(new SpinnerOnSelectedListener());
	}
	class  SpinnerOnSelectedListener implements OnItemSelectedListener{
		//当用户选中一个条目 调用此方法
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View arg1, int position,
				long arg3) {
			// TODO Auto-generated method stub
			String selected=adapterView.getItemAtPosition(position).toString();
			System.out.println(selected);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			System.out.println("onNothingSelected");
		}

	}
}
