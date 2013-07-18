package io.webstream.pathfinder;

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

	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(itemValue);

	    // Set the text view as the activity layout
	    setContentView(textView);

			
	}

}
