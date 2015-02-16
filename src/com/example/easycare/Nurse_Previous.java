package com.example.easycare;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Nurse_Previous extends Activity {
	TextView view1, view2, view3, view4, view5;
	NurseData_GS p;
	String SP;
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	ArrayList<String> listRecord = new ArrayList<String>();
	DAO_NurseData dao = new DAO_NurseData(this);
	private ArrayAdapter<String> listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nurse__previous);
		dbHelper = new MySQLiteHelper(getApplicationContext());
		dbHelper.getWritableDatabase();
		p = new NurseData_GS();
		SP = getDefaults("user", getApplicationContext());

		dao.open();
		p.setName(SP);
		List<NurseData_GS> ss = new ArrayList<NurseData_GS>();
		ss = dao.getAll_nurse(p.getName());

		NurseData_GS up = new NurseData_GS();
		for (int i = 0; i < ss.size(); i++) {
			up = ss.get(i);
			listRecord.add(up.getID());
		}
		dao.close();

		ListView lv = (ListView) findViewById(R.id.listView1);
		listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listRecord);
		lv.setAdapter(listAdapter);
		listAdapter.notifyDataSetChanged();

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				view1 = (TextView) findViewById(R.id.textView2);
				view2 = (TextView) findViewById(R.id.textView3);
				view3 = (TextView) findViewById(R.id.textView4);
				view4 = (TextView) findViewById(R.id.textView5);
				view5 = (TextView) findViewById(R.id.textView6);
				String val = (String) parent.getItemAtPosition(position);

				dao.open();

				List<NurseData_GS> ss = new ArrayList<NurseData_GS>();
				ss = dao.getAll_record(val);

				NurseData_GS up = new NurseData_GS();
				for (int i = 0; i < ss.size(); i++) {
					up = ss.get(i);
					view1.setText(up.getTemp());
					view2.setText(up.getBP());
					view3.setText(up.getHR());
					view4.setText(up.getRR());
					view5.setText(val);
				}
				dao.close();
				// Toast.makeText(getApplicationContext(),
				// "hi"+ val, Toast.LENGTH_LONG).show();
			}
		});
		// Toast.makeText(getApplicationContext(),
		// ""+ss.get(1), Toast.LENGTH_LONG).show();
	}

	public static String getDefaults(String key, Context context) {
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return preferences.getString(key, null);
	}
}
