package io.webstream.pathfinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowTimeZoneActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String itemValue = intent.getStringExtra(DisplayTimezoneActivity.EXTRA_MESSAGE);

	    // Set the activity_show_time_zone layout
	    setContentView(R.layout.activity_main);
	    TextView textView = (TextView) findViewById(R.id.show_tz);
	    
	    Date date = new Date();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    df.setTimeZone(TimeZone.getTimeZone(itemValue));
	    
	    textView.setText("Time zone ID:   "+itemValue+"\n"+"Time zone name:   "+TimeZone.getTimeZone(itemValue).getDisplayName()+"\n"+"Current time:"+df.format(date));	
	}

}
