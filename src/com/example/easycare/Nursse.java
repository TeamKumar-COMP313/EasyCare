package com.example.easycare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Nursse extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nursse);
		
		
		Button btnAddLog = (Button) findViewById(R.id.btnAddLogRecord);
		Button btnViewLogRecord = (Button) findViewById(R.id.btnViewLogRecords);
		Button btnFindMedCond = (Button)findViewById(R.id.vitalsign);		
		
		

		
		btnAddLog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Nursse.this, AddPatientLog.class);
				startActivity(intent);
			}
		});
		
		btnViewLogRecord.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Nursse.this, ViewPatientLogs.class);
				startActivity(intent);
			}
		});
		
		btnFindMedCond.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Nursse.this, SmsForNurse.class);
				startActivity(intent);
			}
		});
		
		
	}

	
}
