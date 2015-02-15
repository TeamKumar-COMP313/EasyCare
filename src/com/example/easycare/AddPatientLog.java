package com.example.easycare;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class AddPatientLog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_patient_log);
		
		final EditText bodyTemp = (EditText)findViewById(R.id.bodyTemp);
	    final EditText heartRate = (EditText)findViewById(R.id.heartRate);
	    final EditText bloodPressure = (EditText)findViewById(R.id.bloodPressure);
	    final EditText respRate = (EditText)findViewById(R.id.respRate);
	    
	    Button addLogRecord = (Button)findViewById(R.id.addPatientLog);
	    
	    final DataBaseHelper db = new DataBaseHelper(this);
	    
	    addLogRecord.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(bodyTemp.getText().toString().length() == 0)
				{
	    			bodyTemp.setError("Please don't leave body temperature blank.");
				}
				if(heartRate.getText().toString().length() == 0)
				{
	    			heartRate.setError("Please don't leave heart rate blank.");
				}
				if(bloodPressure.getText().toString().length() == 0)
				{
	    			bloodPressure.setError("Please don't leave blood pressure blank.");
				}
				if(respRate.getText().toString().length() == 0)
				{
	    			respRate.setError("Please don't leave respiratory rate blank.");
				}
				else
				{
					String patient_bodyTemp = bodyTemp.getText().toString();
					String patient_heartRate = heartRate.getText().toString();
					String patient_bloodPressure = bloodPressure.getText().toString();
					String patient_respRate = respRate.getText().toString();
					
					
					String patient_logTime = new SimpleDateFormat("MMM d, yyyy - hh:mm:ss a").format(Calendar.getInstance().getTime());
					PatientLog log = new PatientLog(patient_bodyTemp, patient_heartRate, patient_bloodPressure, patient_respRate, patient_logTime);
					db.addPatientLog(log);
					db.close();
					Toast.makeText(getApplicationContext(), "Record added.", Toast.LENGTH_SHORT).show();
					
					bodyTemp.getText().clear();
					heartRate.getText().clear();
					bloodPressure.getText().clear();
					respRate.getText().clear();
					
				}
				
			}
		});
	   
	}

}