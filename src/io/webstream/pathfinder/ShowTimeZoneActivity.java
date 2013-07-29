package io.webstream.pathfinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class ShowTimeZoneActivity extends Activity {
	
	static List<String> timeZoneList = new ArrayList<String>();

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String itemValue = intent.getStringExtra(DisplayTimezoneActivity.SELECTED_TIME_ZONE);   
	    
	    timeZoneList.add(itemValue);

	    // Set the activity_main layout
	    setContentView(R.layout.activity_show_time_zone);
	    Date date = new Date();
	    DateFormat df = new SimpleDateFormat("hh:mm a");
	    SimpleDateFormat sdf = new SimpleDateFormat("ZZZZ");
	    	    
	    List<RowItem> rowItems;
	    rowItems = new ArrayList<RowItem>();
	    
	    // First row entry
	    String curr = TimeZone.getDefault().getID().toString();
	    RowItem item1 = new RowItem(df.format(date), curr, TimeZone.getDefault().getDisplayName(), "GMT"+sdf.format(date));
	    rowItems.add(item1);
	    
	    for (int i = 0; i < timeZoneList.size(); i++) {
	    	String timeZone = timeZoneList.get(i);
	    	String timeZoneName = TimeZone.getTimeZone(timeZone).getDisplayName();
		    df.setTimeZone(TimeZone.getTimeZone(timeZone));
		    sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
	    	String currentTime =  df.format(date);
	    	String abbrevTimeZone = sdf.format(date);
	    	RowItem item = new RowItem(currentTime, timeZone, timeZoneName, "GMT"+abbrevTimeZone);
	    	rowItems.add(item);
	    }
	    
	    final ListView lv = (ListView) findViewById(R.id.show_tz);
	    CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
	    lv.setAdapter(adapter);
	    
	    lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
				// Auto-generated method stub
				lv.removeViewAt(position);
				return false;
			}
	    	
		});
	}

	
    /* when the user clicks the Time zone button */
    public void selectTimeZone(View view) {
    	Intent intent = new Intent(this, DisplayTimezoneActivity.class);
    	startActivity(intent);
    }
    
}
