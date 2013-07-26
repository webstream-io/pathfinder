package io.webstream.pathfinder;

import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class DisplayTimezoneActivity extends Activity {
	public final static String SELECTED_TIME_ZONE = "io.webstream.pathfinder.selectedTimeZone";
	ListView lv;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_display_timezone);
		lv = (ListView) findViewById(R.id.list_available_tz);
		EditText inputSearch = (EditText) findViewById(R.id.input_Search);
		String[] availableID = TimeZone.getAvailableIDs();
		
		// Define a new Adapter
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, availableID);
		
		// Assign adapter to ListView
		lv.setAdapter(adapter);
		
		inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// When user changed the text
				DisplayTimezoneActivity.this.adapter.getFilter().filter(s);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
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
