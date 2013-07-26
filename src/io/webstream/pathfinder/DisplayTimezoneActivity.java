package io.webstream.pathfinder;

import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayTimezoneActivity extends Activity {
	public final static String SELECTED_TIME_ZONE = "io.webstream.pathfinder.selectedTimeZone";
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_display_timezone);
		lv = (ListView) findViewById(R.id.list_available_tz);
		String[] availableID = TimeZone.getAvailableIDs();
		
		// Define a new Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, availableID);
		
		// Assign adapter to ListView
		lv.setAdapter(adapter);
		
		// ListView Item Click Listener
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			//@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){ 				
				Intent intent = new Intent(v.getContext(), ShowTimeZoneActivity.class);
				String  itemValue  = (String) lv.getItemAtPosition(position);
				intent.putExtra(SELECTED_TIME_ZONE, itemValue);
				startActivity(intent);
			}
		});
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_timezone, menu);        
        return true;
	}
}
