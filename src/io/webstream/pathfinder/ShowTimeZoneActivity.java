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
import android.widget.ListView;

public class ShowTimeZoneActivity extends Activity {
	
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String itemValue = intent.getStringExtra(DisplayTimezoneActivity.EXTRA_MESSAGE);

	    // Set the activity_main layout
	    setContentView(R.layout.activity_show_time_zone);
	    
	    Date date = new Date();
	    DateFormat df = new SimpleDateFormat("hh:mm:ss a Z");
	    df.setTimeZone(TimeZone.getTimeZone(itemValue));
	    String[] row11 = new String[] {itemValue, itemValue, itemValue};
	    String[] row21 = new String[] {TimeZone.getTimeZone(itemValue).getDisplayName(), TimeZone.getTimeZone(itemValue).getDisplayName(), TimeZone.getTimeZone(itemValue).getDisplayName()};
	    String[] row12 = new String[] {df.format(date), df.format(date), df.format(date)};
	    ListView lv;
	    List<RowItem> rowItems;
	    rowItems = new ArrayList<RowItem>();
	    for (int i=0; i<row11.length; i++) {
	    	RowItem item = new RowItem(row11[i], row21[i], row12[i]);
	    	rowItems.add(item);
	    }
	    lv = (ListView) findViewById(R.id.show_tz);
	    CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
	    lv.setAdapter(adapter);
	    //tv.setText("Current time in "+itemValue+": "+df.format(date)+","+" "+TimeZone.getTimeZone(itemValue).getDisplayName());
	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
	    //lv.setAdapter(adapter);
	}
	
    /* when the user clicks the Time zone button */
    public void selectTimeZone(View view) {
    	Intent intent = new Intent(this, DisplayTimezoneActivity.class);
    	startActivity(intent);
    }
    
}
