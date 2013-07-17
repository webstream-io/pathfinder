package io.webstream.pathfinder;

//import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayTimezoneActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_display_timezone);
		ListView lv = (ListView) findViewById(R.id.list_current_time);
		//Calendar current = Calendar.getInstance();
		//TimeZone timezone = TimeZone.getTimeZone("Asia/Kolkata");
		//String TimeZoneName = timezone.getDisplayName();
		//String str = "Current Time:" + current.getTime() + "\n" +"TimeZone ID:   " +timezone.getID()+ "\n" +"Timezone name:"+TimeZoneName;
		
		String[] availableID = TimeZone.getAvailableIDs();
		
		// Define a new Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, availableID);
		// Assign adapter to ListView
		lv.setAdapter(adapter);
		
	}
	
}
