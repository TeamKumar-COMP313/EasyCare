package com.example.easycare;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DAO_Patient {
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	String data;
	Context context;
	StringBuilder s;
	private String[] allColumns = { MySQLiteHelper.Patient_Username, MySQLiteHelper.Patient_Name,
			MySQLiteHelper.Patient_Password, MySQLiteHelper.Patient_Confirm};


	public DAO_Patient(Context c) {
		dbHelper = new MySQLiteHelper(c);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public long createUser(Patient_GS event) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.Patient_Username, event.getUsername());
		values.put(MySQLiteHelper.Patient_Name, event.getPatient_name());
		values.put(MySQLiteHelper.Patient_Password, event.getPassword());
		values.put(MySQLiteHelper.Patient_Confirm, event.getConfirm());
		
		long insertId = database.insert(MySQLiteHelper.TABLE_Patient, null,
				values);
		return insertId;

	}

	public int update(Patient_GS event, String name) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.Patient_Username, event.getUsername());
		values.put(MySQLiteHelper.Patient_Name, event.getPatient_name());
		values.put(MySQLiteHelper.Patient_Password, event.getPassword());
		values.put(MySQLiteHelper.Patient_Confirm, event.getConfirm());
		int updte = database.update(MySQLiteHelper.TABLE_Patient, values,
				"username = ?", new String[] { name });
		return updte;
	}

	

	public void deleteUser(String Name) {
		Log.i("Deleted", "User deleted with id: " + Name);
		database.delete(MySQLiteHelper.TABLE_Patient, "username = ?",
				new String[] { Name });
	}

//	public List<event_getterSetter> getAllUser(String name) {
//		List<event_getterSetter> EventList = new ArrayList<event_getterSetter>();
//
//		Cursor cursor = database.query(MySQLiteHelper.TABLE_Event, allColumns,
//				"Organiser_Name = ?", new String[] { name }, null, null, null);
//
//		cursor.moveToFirst();
//		while (!cursor.isAfterLast()) {
//			event_getterSetter event = getEvent(cursor);
//			EventList.add(event);
//			cursor.moveToNext();
//		}
//		// make sure to close the cursor
//		cursor.close();
//		return EventList;
//	}

	public List<Patient_GS> getAll() {
		List<Patient_GS> EventList = new ArrayList<Patient_GS>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_Patient, allColumns,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Patient_GS event = getEvent(cursor);
			EventList.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return EventList;
	}

	private Patient_GS getEvent(Cursor cursor) {
		Patient_GS event = new Patient_GS();
		event.setUsername(cursor.getString(0));
		event.setPatient_name(cursor.getString(1));
		event.setPassword(cursor.getString(2));
		event.setConfirm(cursor.getString(3));
		return event;
	}
}



