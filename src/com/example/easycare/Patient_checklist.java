package com.example.easycare;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Patient_checklist extends Activity {
	RadioButton r5, r2, r3, r9;
	RadioButton r1, r6, r7, r01;
	RadioButton r4, r0, r8, r02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_checklist);
		r2 = (RadioButton)findViewById(R.id.radio2);
		r3 = (RadioButton)findViewById(R.id.RadioButton03);
		r9 = (RadioButton)findViewById(R.id.RadioButton09);
		r5 = (RadioButton)findViewById(R.id.RadioButton05);
		
		r1 = (RadioButton)findViewById(R.id.radio1);
		r6 = (RadioButton)findViewById(R.id.RadioButton06);
		r7 = (RadioButton)findViewById(R.id.RadioButton07);
		r01 = (RadioButton)findViewById(R.id.RadioButton01);
		
		r0 = (RadioButton)findViewById(R.id.radio0);
		r4 = (RadioButton)findViewById(R.id.RadioButton04);
		r8 = (RadioButton)findViewById(R.id.RadioButton08);
		r02 = (RadioButton)findViewById(R.id.RadioButton02);
		
		final Button send = (Button)findViewById(R.id.button1);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(r0.isChecked()||r4.isChecked()||r8.isChecked()||r02.isChecked()){
					Toast.makeText(getApplicationContext(),"You need to see doctor", Toast.LENGTH_LONG).show();
					
				}
					else if(r1.isChecked()||r6.isChecked()||r7.isChecked()||r01.isChecked()){
						
						Toast.makeText(getApplicationContext(),"You are doing good today!", Toast.LENGTH_LONG).show();
					}
					else{
						Toast.makeText(getApplicationContext(),"Take some Rest", Toast.LENGTH_LONG).show();
					}
					
				}
		});
				
	}
}
