package com.example.easycare;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainC extends Activity {
	private MySQLiteHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_c);
		dbHelper = new MySQLiteHelper(getApplicationContext());
		dbHelper.getWritableDatabase();

		final Button login = (Button) findViewById(R.id.button1);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainC.this,Login.class);
				startActivity(intent);
			}
		});
		final Button register = (Button) findViewById(R.id.button2);
		register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainC.this,Register.class);
				startActivity(intent);
			}
		});
	}
}
