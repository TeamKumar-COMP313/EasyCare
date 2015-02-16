package com.example.easycare;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Nurse_home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nurse_home);

		final Button add = (Button)findViewById(R.id.button1);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Nurse_home.this, Nurse_AddData.class);
				startActivity(intent);
			}
		});
		final Button view = (Button)findViewById(R.id.button2);
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Nurse_home.this, Nurse_Previous.class);
				startActivity(intent);
			}
		});
		final Button motivational = (Button)findViewById(R.id.button3);
		motivational.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Nurse_home.this, Nurse_Message.class);
				startActivity(intent);
			}
		});
	}
}

