package com.example.easycare;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "patientdb";
	private static final int DATABASE_VERSION = 1;
	
	public static final String CREATE_PATIENTLOG_TABLE = "CREATE TABLE PatientLog( log_id INTEGER PRIMARY KEY AUTOINCREMENT, bodyTemp TEXT, heartRate TEXT, bloodPressure TEXT, respRate TEXT, dateTime TEXT)";
	
	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public DataBaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PATIENTLOG_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void addPatientLog(PatientLog log)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put("bodyTemp", log.getBodyTemp());
		values.put("heartRate", log.getHeartRate());
		values.put("bloodPressure", log.getBloodPressure());
		values.put("respRate", log.getRespRate());
		values.put("dateTime", log.getDataTime());
		
		db.insert("PatientLog", null, values);
		
		db.close();		
	}
	
	public void updatePatientLog(PatientLog log, String log_id) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put("bodyTemp", log.getBodyTemp());
		values.put("heartRate", log.getHeartRate());
		values.put("bloodPressure", log.getBloodPressure());
		values.put("respRate", log.getRespRate());
		
		db.update("PatientLog", values, "log_id = " + log_id, null);
		
		db.close();
	}
	
	public void deletePatientLog(String log_id)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete("PatientLog", "log_id = " + log_id, null);
		
		db.close();
	}
	
	public ArrayList<PatientLog> getAllRecords()
	{
		ArrayList<PatientLog> records = new ArrayList<PatientLog>();
		
		String GET_PLAYERS = "SELECT * FROM PatientLog Order By dateTime";
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(GET_PLAYERS, null);
		while(cursor.moveToNext())
		{
			PatientLog log = new PatientLog();
			log.setLog_id(cursor.getInt(0));
			log.setBodyTemp(cursor.getString(1));
			log.setHeartRate(cursor.getString(2));
			log.setBloodPressure(cursor.getString(3));
			log.setRespRate(cursor.getString(4));
			log.setDataTime(cursor.getString(5));
			
			records.add(log);
		}
		db.close();
		
		return records;
		
	}

}
