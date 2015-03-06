package com.example.easycare;

import java.util.ArrayList;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;

public class Patient_Media extends Activity {
	ListView select;
	 VideoView video;
	 private ArrayAdapter<String> listAdapter;
	 ArrayList<String> listRecord = new ArrayList<String>();
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient__media);
		 video = (VideoView) findViewById(R.id.video);
		 select = (ListView) findViewById(R.id.listView1);
		 listRecord.add("Video 1");
		 listRecord.add("Video 2");
		 listRecord.add("Video 3");
		 
		 listAdapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, listRecord);
			select.setAdapter(listAdapter);
			listAdapter.notifyDataSetChanged();
			
		//select.setOnItemClickListener(new OnItemClickListener() {

		//	@Override
			//public void onItemClick(AdapterView<?> parent, View view,
				//	int position, long id) {
				// TODO Auto-generated method stub
			//	switch (position) {
			//	case 0:
			//		Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/"
			//				+ R.raw.vid1);
			//		video.setVideoURI(video1);
			//		video.start();
			//		break;
			//	case 1:
			//		Uri video2 = Uri.parse("android.resource://" + getPackageName() + "/"
			//				+ R.raw.vid2);
			//		video.setVideoURI(video2);
			//		video.start();
			//		break;
			//	case 2:
			//		Uri video3 = Uri.parse("android.resource://" + getPackageName() + "/"
			//				+ R.raw.vid3);
			//		video.setVideoURI(video3);
			//		video.start();
			//		break;

			//	}
		//	}
		//});

		
		// Load and start the movie
		
	}

}

