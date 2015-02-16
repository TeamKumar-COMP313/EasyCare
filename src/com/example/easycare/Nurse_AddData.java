package com.example.easycare;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Nurse_AddData extends Activity {
	Button add;
	EditText temp, bp, rr, hr;
	NurseData_GS p;
	String SP;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	DAO_NurseData dao = new DAO_NurseData(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nurse__add_data);
		dbHelper = new MySQLiteHelper(getApplicationContext());
		dbHelper.getWritableDatabase();
		p = new NurseData_GS();

		SP = getDefaults("user", getApplicationContext());

		add = (Button) findViewById(R.id.button1);
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				temp = (EditText) findViewById(R.id.editText1);
				rr = (EditText) findViewById(R.id.editText4);
				bp = (EditText) findViewById(R.id.editText3);
				hr = (EditText) findViewById(R.id.editText2);
				dao.open();
				p.setTemp(temp.getText().toString());
				p.setRR(rr.getText().toString());
				p.setBP(bp.getText().toString());
				p.setHR(hr.getText().toString());
				p.setName(SP);
				dao.createUser(p);
				dao.close();
			}
		});

	}

	public static String getDefaults(String key, Context context) {
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return preferences.getString(key, null);
	}

}
