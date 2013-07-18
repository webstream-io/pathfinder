package io.webstream.pathfinder;

import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayTimezoneActivity extends Activity {
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_display_timezone);
		lv = (ListView) findViewById(R.id.list_current_time);
		String[] availableID = TimeZone.getAvailableIDs();
		
		// Define a new Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, availableID);
		// Assign adapter to ListView
		lv.setAdapter(adapter);
		
		// ListView Item Click Listener
		lv.setOnItemClickListener(new OnItemClickListener() {
			//@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				//int itemPosition = position;
				String  itemValue  = (String) lv.getItemAtPosition(position);
				//Calendar current = Calendar.getInstance();
				//Show Alert 
				//Toast.makeText(getApplicationContext(), "Position: "+itemPosition+" Time zone: " +TimeZone.getTimeZone(itemValue), Toast.LENGTH_LONG).show();
				Intent i = new Intent(v.getContext(), ShowTimeZoneActivity.class);
				i.putExtra("TimeZoneName" ,itemValue);
				startActivity(i);
			}
		});
	}
	
}
