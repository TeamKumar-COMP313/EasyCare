package com.example.easycare;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nurse_Message extends Activity {
	EditText phone, msg;
	final int RQS_PICKCONTACT = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nurse__message);

		phone = (EditText) findViewById(R.id.editText1);
		msg = (EditText) findViewById(R.id.editText2);
		final Button send = (Button) findViewById(R.id.btnSendLocationSMS);
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendSMSMessage();
			}
		});

		final Button add = (Button) findViewById(R.id.button2);
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Uri uriContact = ContactsContract.Contacts.CONTENT_URI;
				Intent intentPickContact = new Intent(Intent.ACTION_PICK,
						uriContact);
				startActivityForResult(intentPickContact, RQS_PICKCONTACT);
			}
		});

	}

	protected void sendSMSMessage() {

		String phoneNo = phone.getText().toString();
		String message = msg.getText().toString();

		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS faild, please try again.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == RESULT_OK) {
			if (requestCode == RQS_PICKCONTACT) {
				Uri returnUri = data.getData();
				Cursor cursor = getContentResolver().query(returnUri, null,
						null, null, null);

				if (cursor.moveToNext()) {
					int columnIndex_ID = cursor
							.getColumnIndex(ContactsContract.Contacts._ID);
					String contactID = cursor.getString(columnIndex_ID);

					int columnIndex_HASPHONENUMBER = cursor
							.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
					String stringHasPhoneNumber = cursor
							.getString(columnIndex_HASPHONENUMBER);

					if (stringHasPhoneNumber.equalsIgnoreCase("1")) {
						Cursor cursorNum = getContentResolver()
								.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
										null,
										ContactsContract.CommonDataKinds.Phone.CONTACT_ID
												+ "=" + contactID, null, null);

						// Get the first phone number
						if (cursorNum.moveToNext()) {
							int columnIndex_number = cursorNum
									.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
							String stringNumber = cursorNum
									.getString(columnIndex_number);
							phone.setText(stringNumber);

						}

					} else {
						Toast.makeText(getApplicationContext(),
								"No Phone Number", Toast.LENGTH_LONG).show();
					}

				} else {
					Toast.makeText(getApplicationContext(), "NO data!",
							Toast.LENGTH_LONG).show();
				}
			}
		}
	}
}
	