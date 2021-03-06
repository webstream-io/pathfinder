package io.webstream.pathfinder;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<RowItem>{
	Context context;
	public CustomListViewAdapter(Context context, int resourceId, List<RowItem> items) {
		super(context, resourceId, items);
		this.context = context;
	}
	
	private class ViewHolder {
		TextView txtp1;
		TextView txtp2;
		TextView txtp3;
		TextView txtp4;
	}
	
	public View getView(int position, View v, ViewGroup parent) {
		ViewHolder holder = null;
		RowItem rowItem = getItem(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if(v == null) {
			v = inflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.txtp1 = (TextView) v.findViewById(R.id.current_time);
			holder.txtp2 = (TextView) v.findViewById(R.id.city);
			holder.txtp3 = (TextView) v.findViewById(R.id.time_zone);
			holder.txtp4 = (TextView) v.findViewById(R.id.short_time_zone);
			v.setTag(holder);
		} 
		else
			holder = (ViewHolder) v.getTag();
			holder.txtp1.setText(rowItem.getPlace1());
			holder.txtp2.setText(rowItem.getPlace2());
			holder.txtp3.setText(rowItem.getPlace3());
			holder.txtp4.setText(rowItem.getPlace4());
			
			return v;
	}
}
