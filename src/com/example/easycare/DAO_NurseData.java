package com.example.easycare;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DAO_NurseData {
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	String data;
	Context context;
	StringBuilder s;
	private String[] allColumns = { MySQLiteHelper.NurseName,
			MySQLiteHelper.NurseTemperature, MySQLiteHelper.NurseHeartRate,
			MySQLiteHelper.NurseBP, MySQLiteHelper.NurseRespiratoryRate,
			MySQLiteHelper.NurseID };

	public DAO_NurseData(Context c) {
		dbHelper = new MySQLiteHelper(c);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public long createUser(NurseData_GS event) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.NurseName, event.getName());
		values.put(MySQLiteHelper.NurseTemperature, event.getTemp());
		values.put(MySQLiteHelper.NurseHeartRate, event.getHR());
		values.put(MySQLiteHelper.NurseBP, event.getBP());
		values.put(MySQLiteHelper.NurseRespiratoryRate, event.getRR());
		long insertId = database.insert(MySQLiteHelper.TABLE_NurseData, null,
				values);
		return insertId;

	}

	public int update(NurseData_GS event, String name) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.NurseName, event.getName());
		values.put(MySQLiteHelper.NurseTemperature, event.getTemp());
		values.put(MySQLiteHelper.NurseHeartRate, event.getHR());
		values.put(MySQLiteHelper.NurseBP, event.getBP());
		values.put(MySQLiteHelper.NurseRespiratoryRate, event.getRR());
		int updte = database.update(MySQLiteHelper.TABLE_NurseData, values,
				"Nurse_Name = ?", new String[] { name });
		return updte;
	}

	public void deleteUser(String Name) {
		Log.i("Deleted", "User deleted with id: " + Name);
		database.delete(MySQLiteHelper.TABLE_NurseData, "Nurse_Name = ?",
				new String[] { Name });
	}

	// public List<event_getterSetter> getAllUser(String name) {
	// List<event_getterSetter> EventList = new ArrayList<event_getterSetter>();
	//
	// Cursor cursor = database.query(MySQLiteHelper.TABLE_Event, allColumns,
	// "Organiser_Name = ?", new String[] { name }, null, null, null);
	//
	// cursor.moveToFirst();
	// while (!cursor.isAfterLast()) {
	// event_getterSetter event = getEvent(cursor);
	// EventList.add(event);
	// cursor.moveToNext();
	// }
	// // make sure to close the cursor
	// cursor.close();
	// return EventList;
	// }

	public List<NurseData_GS> getAll() {
		List<NurseData_GS> EventList = new ArrayList<NurseData_GS>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_NurseData,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			NurseData_GS event = getEvent(cursor);
			EventList.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return EventList;
	}

	public List<NurseData_GS> getAll_nurse(String name) {
		List<NurseData_GS> EventList = new ArrayList<NurseData_GS>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_NurseData,
				allColumns, "Nurse_Name = ?", new String[] { name }, null,
				null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			NurseData_GS event = getEvent(cursor);
			EventList.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return EventList;
	}
	
	public List<NurseData_GS> getAll_record(String name) {
		List<NurseData_GS> EventList = new ArrayList<NurseData_GS>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_NurseData,
				allColumns, "Nurse_id = ?", new String[] { name }, null,
				null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			NurseData_GS event = getEvent(cursor);
			EventList.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return EventList;
	}

	private NurseData_GS getEvent(Cursor cursor) {
		NurseData_GS event = new NurseData_GS();
		event.setName(cursor.getString(0));
		event.setTemp(cursor.getString(1));
		event.setHR(cursor.getString(2));
		event.setBP(cursor.getString(3));
		event.setRR(cursor.getString(4));
		event.setID(cursor.getString(5));
		return event;
	}
}