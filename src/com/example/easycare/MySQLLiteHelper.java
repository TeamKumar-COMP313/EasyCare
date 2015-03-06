package com.example.easycare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_PatientDate = "PatientDateTable";
	public static final String PatientName = "Patient_Name";
	public static final String PatientID = "Patient_id";
	public static final String PatientTemperature = "Temperature";
	public static final String PatientHeartRate = "HeartRate";
	public static final String PatientBP = "BP";
	public static final String PatientRespiratoryRate = "RespiratoryRate";

	public static final String TABLE_NurseData = "NurseDataTable";
	public static final String NurseName = "Nurse_Name";
	public static final String NurseID = "Nurse_id";
	public static final String NurseTemperature = "Temperature";
	public static final String NurseHeartRate = "HeartRate";
	public static final String NurseBP = "BP";
	public static final String NurseRespiratoryRate = "RespiratoryRate";

	public static final String TABLE_Nurse = "NurseTable";
	public static final String Nurse_Name = "Nurse_Name";
	public static final String Nurse_ID = "Nurse_ID";
	public static final String Nurse_Username = "username";
	public static final String Nurse_Password = "password";
	public static final String Nurse_Confirm = "Confirm_Password";

	public static final String TABLE_Patient = "PatientTable";
	public static final String Patient_Name = "Patient_Name";
	public static final String Patient_ID = "Patient_ID";
	public static final String Patient_Username = "username";
	public static final String Patient_Password = "password";
	public static final String Patient_Confirm = "Confirm_Password";

	private static final String DATABASE_NAME = "Hospital1.db";
	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_PatientDate = "create table "
			+ TABLE_PatientDate + "(" + PatientID
			+ " integer primary key autoincrement not null, " + PatientName
			+ " text, " + PatientTemperature + " text, " + PatientHeartRate
			+ " text," + PatientBP + " text, " + PatientRespiratoryRate
			+ " text);";

	private static final String DATABASE_NurseData = "create table "
			+ TABLE_NurseData + "(" +NurseID
			+ " integer primary key autoincrement not null, " + NurseName
			+ " text, "+Patient_Name+"  text, " + NurseTemperature + " text, " + NurseHeartRate
			+ " text not null," + NurseBP + " text," + NurseRespiratoryRate
			+ " text);";

	private static final String DATABASE_Nurse = "create table " + TABLE_Nurse
			+ "(" + Nurse_Username + " text primary key unique not null, "
			+ Nurse_Name + " text, " + Nurse_Password + " text not null,"
			+ Nurse_Confirm + " text);";

	private static final String DATABASE_Patient = "create table "
			+ TABLE_Patient + "(" + Patient_Username
			+ " text primary key unique not null, " + Patient_Name + " text, "
			+ Patient_Password + " text not null," + Patient_Confirm
			+ " text);";

	public MySQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_PatientDate);
		db.execSQL(DATABASE_NurseData);
		db.execSQL(DATABASE_Nurse);
		db.execSQL(DATABASE_Patient);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PatientDate);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NurseData);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_Nurse);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_Patient);
		onCreate(db);
	}

}
