package com.example.easycare;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DAO_PatientData {
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	String data;
	Context context;
	StringBuilder s;
	private String[] allColumns = { MySQLiteHelper.PatientName, MySQLiteHelper.PatientTemperature,
			MySQLiteHelper.PatientHeartRate, MySQLiteHelper.PatientBP, MySQLiteHelper.PatientRespiratoryRate};


	public DAO_PatientData(Context c) {
		dbHelper = new MySQLiteHelper(c);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public long createUser(PatientData_GS event) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.PatientName, event.getName());
		values.put(MySQLiteHelper.PatientTemperature, event.getTemp());
		values.put(MySQLiteHelper.PatientHeartRate, event.getHR());
		values.put(MySQLiteHelper.PatientBP, event.getBP());
		values.put(MySQLiteHelper.PatientRespiratoryRate, event.getRR());
		long insertId = database.insert(MySQLiteHelper.TABLE_PatientDate, null,
				values);
		return insertId;

	}

	public int update(PatientData_GS event, String name) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.PatientName, event.getName());
		values.put(MySQLiteHelper.PatientTemperature, event.getTemp());
		values.put(MySQLiteHelper.PatientHeartRate, event.getHR());
		values.put(MySQLiteHelper.PatientBP, event.getBP());
		values.put(MySQLiteHelper.PatientRespiratoryRate, event.getRR());
		int updte = database.update(MySQLiteHelper.TABLE_PatientDate, values,
				"Patient_Name = ?", new String[] { name });
		return updte;
	}

	

	public void deleteUser(String Name) {
		Log.i("Deleted", "User deleted with id: " + Name);
		database.delete(MySQLiteHelper.TABLE_PatientDate, "Patient_Name = ?",
				new String[] { Name });
	}



	public List<PatientData_GS> getAll() {
		List<PatientData_GS> EventList = new ArrayList<PatientData_GS>();

	Cursor cursor = database.query(MySQLiteHelper.TABLE_NurseData, allColumns,
			null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			PatientData_GS event = getEvent(cursor);
			EventList.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return EventList;
	}

	private PatientData_GS getEvent(Cursor cursor) {
		PatientData_GS event = new PatientData_GS();
		event.setName(cursor.getString(0));
		event.setTemp(cursor.getString(1));
		event.setHR(cursor.getString(2));
		event.setBP(cursor.getString(3));
		event.setRR(cursor.getString(4));
		return event;
	}
}
