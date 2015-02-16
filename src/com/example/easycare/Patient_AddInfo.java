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
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Patient_AddInfo extends Activity {
	Button add,send;
	EditText temp, bp, rr, hr;
	PatientData_GS p;
	String SP;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	DAO_PatientData dao = new DAO_PatientData(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient__add_info);
		dbHelper = new MySQLiteHelper(getApplicationContext());
		dbHelper.getWritableDatabase();
		p = new PatientData_GS();
		
		//SP = getDefaults("user", getApplicationContext());
		
		add = (Button)findViewById(R.id.button1);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				temp = (EditText)findViewById(R.id.editText1);
				rr = (EditText)findViewById(R.id.editText4);
				bp = (EditText)findViewById(R.id.editText3);
				hr = (EditText)findViewById(R.id.editText2);
				dao.open();
				p.setTemp(temp.getText().toString());
				p.setRR(rr.getText().toString());
				p.setBP(bp.getText().toString());
				p.setHR(hr.getText().toString());
				p.setName(SP);
				dao.createUser(p);
				dao.close();
				finish();
			}
			
		});
	}
}
		
		