package io.webstream.pathfinder;

import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayTimezoneActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_display_timezone);
		TextView tv = (TextView) findViewById(R.id.tz);
		Calendar current = Calendar.getInstance();
		//TimeZone tzcurrent = current.getTimeZone();
		//tz.setID("GMT+05:30");
		TimeZone timezone = TimeZone.getTimeZone("Asia/Kolkata");
		String TimeZoneName = timezone.getDisplayName();
		tv.setText("Current Time:" + current.getTime() + "\n" +"TimeZone ID:   " +timezone.getID()+ "\n" +"Timezone name:"+TimeZoneName);
		//setContentView(R.layout.activity_display_timezone);
	}
	
}
