package com.example.easycare;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import android.app.Activity;


	public class Main extends Activity {
		

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			final Button login = (Button) findViewById(R.id.button1);
			login.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Main.this,Login.class);
					startActivity(intent);
				}
			});
			final Button register = (Button) findViewById(R.id.button2);
			register.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Main.this,Register.class);
					startActivity(intent);
				}
			});
		}
	}