package com.example.easycare;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class DAO_Nurse {
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	String data;
	Context context;
	StringBuilder s;
	private String[] allColumns = { MySQLiteHelper.Nurse_Username, MySQLiteHelper.Nurse_Name,
			MySQLiteHelper.Nurse_Password, MySQLiteHelper.Nurse_Confirm};


	public DAO_Nurse(Context c) {
		dbHelper = new MySQLiteHelper(c);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public long createUser(Nurse_GS event) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.Nurse_Username, event.getUsername());
		values.put(MySQLiteHelper.Nurse_Name, event.getNurse_name());
		values.put(MySQLiteHelper.Nurse_Password, event.getPassword());
		values.put(MySQLiteHelper.Nurse_Confirm, event.getConfirm());
		
		long insertId = database.insert(MySQLiteHelper.TABLE_Nurse, null,
				values);
		return insertId;

	}

	public int update(Nurse_GS event, String name) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.Nurse_Username, event.getUsername());
		values.put(MySQLiteHelper.Nurse_Name, event.getNurse_name());
		values.put(MySQLiteHelper.Nurse_Password, event.getPassword());
		values.put(MySQLiteHelper.Nurse_Confirm, event.getConfirm());
		int updte = database.update(MySQLiteHelper.TABLE_Nurse, values,
				"username = ?", new String[] { name });
		return updte;
	}

	

	public void deleteUser(String Name) {
		Log.i("Deleted", "User deleted with id: " + Name);
		database.delete(MySQLiteHelper.TABLE_Nurse, "username = ?",
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

	public List<Nurse_GS> getAll() {
		List<Nurse_GS> EventList = new ArrayList<Nurse_GS>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_Nurse, allColumns,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Nurse_GS event = getEvent(cursor);
			EventList.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return EventList;
	}

	private Nurse_GS getEvent(Cursor cursor) {
		Nurse_GS event = new Nurse_GS();
		event.setUsername(cursor.getString(0));
		event.setNurse_name(cursor.getString(1));
		event.setPassword(cursor.getString(2));
		event.setConfirm(cursor.getString(3));
		return event;
	}
	
}



