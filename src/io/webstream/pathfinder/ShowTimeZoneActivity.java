package io.webstream.pathfinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowTimeZoneActivity extends Activity {
	
	TextView tv;
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String itemValue = intent.getStringExtra(DisplayTimezoneActivity.EXTRA_MESSAGE);

	    // Set the activity_main layout
	    setContentView(R.layout.activity_show_time_zone);
	    tv = (TextView) findViewById(R.id.show_tz);
	    
	    Date date = new Date();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    df.setTimeZone(TimeZone.getTimeZone(itemValue));
	    tv.setText("Current time in "+itemValue+":   "+df.format(date)+","+" "+TimeZone.getTimeZone(itemValue).getDisplayName());
	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
	    //lv.setAdapter(adapter);
	}
    /* when the user clicks the Time zone button */
    public void selectTimeZone(View view) {
    	Intent intent = new Intent(this, DisplayTimezoneActivity.class);
    	startActivity(intent);
    }
    
}
