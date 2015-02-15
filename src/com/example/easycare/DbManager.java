package com.example.easycare;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
  
public class DbManager extends SQLiteOpenHelper { 

	public static String TBL_USER = "User";
	public static String TBL_PATIENT = "Patient";
	public static String TBL_TEST = "Test";
	public static String TBL_NURSE = "Nurse";
	public static String TBL_DOCTOR = "Doctor";

	public static String CREATE_TB_USER = "CREATE TABLE User (userId INTEGER PRIMARY KEY, username TEXT, password TEXT);";
	public static String CREATE_TB_PATIENT = "CREATE TABLE Patient (patientId INTEGER PRIMARY KEY, firstName TEXT, lastName TEXT, department TEXT, doctorId NUMERIC, room TEXT);";
	public static String CREATE_TB_TEST = "CREATE TABLE Test (testId INTEGER PRIMARY KEY, patientId NUMERIC,nurseId NUMERIC, BPL TEXT, BPH TEXT, temprature TEXT);"; 
	public static String CREATE_TB_NURSE = "CREATE TABLE Nurse (nurseId INTEGER PRIMARY KEY, firstName TEXT, lastName TEXT, department TEXT);";
	public static String CREATE_TB_DOCTOR = "CREATE TABLE Doctor (doctorId INTEGER PRIMARY KEY, firstName TEXT, lastName TEXT, department TEXT);";
	public static String INSERT_ADMIN_USER = "insert into User values(1, 'admin', '123456');";
	
	private static final String DATABASE_NAME = "Hospital.db";
    private static final int DATABASE_VERSION = 1;
    private String tables[] = {TBL_USER, TBL_DOCTOR, TBL_PATIENT, TBL_TEST, TBL_NURSE, TBL_DOCTOR};
    private String tableCreatorString[] = {CREATE_TB_USER, CREATE_TB_PATIENT, CREATE_TB_TEST, CREATE_TB_NURSE, CREATE_TB_DOCTOR, INSERT_ADMIN_USER};
    
    public DbManager(Context context) { 
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        createDatabase(context);
    } 
    
    @Override
    public void onCreate(SQLiteDatabase db) { 
    	for (int i=0;i<tables.length;i++)
    		db.execSQL("DROP TABLE IF EXISTS " + tables[i]);
    	for (int i=0;i<tables.length;i++)
    		db.execSQL(tableCreatorString[i]);
    } 

    public void createDatabase(Context context)
    {
    	SQLiteDatabase mDatabase = context.openOrCreateDatabase(
    	DATABASE_NAME,
    	SQLiteDatabase.CREATE_IF_NECESSARY,
    	null);
    }
   
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
    	for (int i=0;i<tables.length;i++)
    		db.execSQL("DROP TABLE IF EXISTS " + tables[i]);
                 
        onCreate(db); 
    }
    
    public void deleteDatabase(Context context)
    {
    	context.deleteDatabase(DATABASE_NAME);
    } 
    
    public void addRecord(ContentValues values, String tableName) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
        db.insert(tableName, null, values); 
        db.close(); //close database connection 
    } // end of addRecord
  
    public String getFieldValue(String fieldName, String tableName)
    {
    	String fieldValue="";
        String selectQuery = "SELECT " + fieldName + " FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) 
        { 
        	fieldValue = cursor.getString(cursor.getColumnIndex(fieldName));
        } 
        return fieldValue; 
    }

	
		
	
	public User loginUser(String username, String password){
		List<User> users = new ArrayList<User>();
		String loginUser = "Select * from User where username = '"+username+"' and password = '"+password+"';";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(loginUser, null);
		
		if(cursor.moveToFirst()){
			do{
				User u = new User();
				u.setId(Integer.parseInt(cursor.getString(0)));
				u.setUsername(cursor.getString(1));
				u.setPassword(cursor.getString(2));
				users.add(u);
			}
			while(cursor.moveToNext());
		}
		return users.size() > 0 ? users.get(0): null;		
	}    
} 
