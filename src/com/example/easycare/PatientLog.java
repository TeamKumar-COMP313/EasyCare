package com.example.easycare;

public class PatientLog {
	
	private int log_id;
	private String bodyTemp;
	private String heartRate;
	private String bloodPressure;
	private String respRate;
	private String dataTime;

	public PatientLog() {
		// TODO Auto-generated constructor stub
		
	}
	
	

	public PatientLog(String bodyTemp, String heartRate, String bloodPressure,
			String respRate) {
		super();
		this.bodyTemp = bodyTemp;
		this.heartRate = heartRate;
		this.bloodPressure = bloodPressure;
		this.respRate = respRate;
	}



	public PatientLog(String bodyTemp, String heartRate, String bloodPressure,
			String respRate, String dataTime) {
		super();
		this.bodyTemp = bodyTemp;
		this.heartRate = heartRate;
		this.bloodPressure = bloodPressure;
		this.respRate = respRate;
		this.dataTime = dataTime;
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public String getBodyTemp() {
		return bodyTemp;
	}

	public void setBodyTemp(String bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getRespRate() {
		return respRate;
	}

	public void setRespRate(String respRate) {
		this.respRate = respRate;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	
	

}