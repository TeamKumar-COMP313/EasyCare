package com.example.easycare;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

public class Login extends Activity {
	Nurse_GS p;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	DAO_Nurse dao = new DAO_Nurse(this);

	Patient_GS pp;
	DAO_Patient pdao = new DAO_Patient(this);

	EditText username, password;
	Button login;
	ArrayList<String> l = new ArrayList<String>();
	ArrayList<String> l1 = new ArrayList<String>();
	ArrayList<String> ll = new ArrayList<String>();
	ArrayList<String> ll1 = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		dbHelper = new MySQLiteHelper(getApplicationContext());
		dbHelper.getWritableDatabase();
		p = new Nurse_GS();
		pp = new Patient_GS();

		login = (Button) findViewById(R.id.button1);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				username = (EditText) findViewById(R.id.editText1);
				password = (EditText) findViewById(R.id.editText2);
				String u = username.getText().toString();
				String p = password.getText().toString();
				dao.open();
				List<Nurse_GS> ss = new ArrayList<Nurse_GS>();
				ss = dao.getAll();

				Nurse_GS up = new Nurse_GS();
				for (int i = 0; i < ss.size(); i++) {
					up = ss.get(i);

					l.add(up.getUsername());

					l1.add(up.getPassword());

				}
				dao.close();
				pdao.open();
				List<Patient_GS> sss = new ArrayList<Patient_GS>();
				sss = pdao.getAll();

				Patient_GS uup = new Patient_GS();
				for (int i = 0; i < sss.size(); i++) {
					uup = sss.get(i);

					ll.add(uup.getUsername());

					ll1.add(uup.getPassword());

				}
				pdao.close();
				if ((l.contains(u) || ll.contains(u))
						&& (l1.contains(p) || ll1.contains(p))) {

					if (l.contains(username.getText().toString())) {
						Intent in = new Intent(Login.this, Nurse_home.class);
						startActivity(in);

						setDefaults("user", u, getApplicationContext());
						finish();
					} else {

						Intent in = new Intent(Login.this, Patient_Home.class);
						startActivity(in);

						setDefaults("user", u, getApplicationContext());
						finish();
					}

				} else {
					Toast.makeText(getApplicationContext(),
							" Wrong Username or Password", Toast.LENGTH_SHORT)
							.show();
					

				}
			}
		});
	}
	public static void setDefaults(String key, String value, Context context) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(key, value);
		editor.commit();
	}
}
