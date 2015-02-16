package com.example.easycare;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Register extends Activity {
	Nurse_GS p;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	DAO_Nurse dao = new DAO_Nurse(this);
	
	Patient_GS pp;
	DAO_Patient pdao = new DAO_Patient(this);
RadioButton nurse, patient;
EditText name, uname, pass, confirm;
Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		dbHelper = new MySQLiteHelper(getApplicationContext());
		dbHelper.getWritableDatabase();
		p = new Nurse_GS();
		pp = new Patient_GS();
		
		nurse = (RadioButton)findViewById(R.id.radio0);
		patient = (RadioButton)findViewById(R.id.radio1);
		
		
		
		register = (Button)findViewById(R.id.button1);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = (EditText)findViewById(R.id.editText1);
				uname = (EditText)findViewById(R.id.editText2);
				pass = (EditText)findViewById(R.id.editText3);
				confirm = (EditText)findViewById(R.id.editText4);
				
				if (nurse.isChecked()) {
					dao.open();
					p.setNurse_name(name.getText().toString());
					p.setUsername(uname.getText().toString());
					p.setPassword(pass.getText().toString());
					p.setConfirm(confirm.getText().toString());
					dao.createUser(p);
					dao.close();
					//Toast.makeText(getApplicationContext(), "Nurse",Toast.LENGTH_SHORT).show();
				} else {
					pdao.open();
					pp.setPatient_name(name.getText().toString());
					pp.setUsername(uname.getText().toString());
					pp.setPassword(pass.getText().toString());
					pp.setConfirm(confirm.getText().toString());
					pdao.createUser(pp);
					pdao.close();
					//Toast.makeText(getApplicationContext(), "Patient",Toast.LENGTH_SHORT).show();
				}
			}
		});
		finish();
	}
}
