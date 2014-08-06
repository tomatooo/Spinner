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
		//ͨ��createFromResource��������һ��ArrayAdapter����
		//�ڶ������� ��������strings��xml�ļ��ж����string����
		//��������������ָ��spinner����ʽ���ǲ����ļ�ID����ϵͳ�ġ�
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.planets_array,
				android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setPrompt("����");
		spinner.setOnItemSelectedListener(new SpinnerOnSelectedListener());
	}
	class  SpinnerOnSelectedListener implements OnItemSelectedListener{
		//���û�ѡ��һ����Ŀ ���ô˷���
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
