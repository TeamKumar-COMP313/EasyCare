package com.example.easycare;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Patient_Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient__home);
		
		final Button alert = (Button)findViewById(R.id.button1);
		alert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Patient_Home.this, Patient_Alert.class);
				startActivity(intent);
			}
		});
		final Button Media = (Button)findViewById(R.id.button2);
		Media.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Patient_Home.this, Patient_Media.class);
				startActivity(intent);
			}
		});
		final Button info = (Button)findViewById(R.id.button3);
		info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Patient_Home.this, Patient_AddInfo.class);
				startActivity(intent);
			}
		});
		final Button checklist = (Button)findViewById(R.id.button4);
		checklist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Patient_Home.this, Patient_checklist.class);
				startActivity(intent);
			}
		});
		final Button location = (Button)findViewById(R.id.button5);
		location.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Patient_Home.this, Patient_Location.class);
				startActivity(intent);
			}
		});
	}
}

    