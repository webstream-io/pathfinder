package io.webstream.pathfinder;

public class RowItem {
	private String place1;
	private String place2;
	private String place3;
	private String place4;
	
	public RowItem(String place1, String place2, String place3, String place4) {
		this.place1 = place1;
		this.place2 = place2;
		this.place3 = place3;
		this.place4 = place4;
	}
	public String getPlace1() {
		return place1;
	}
	public void setPlace1(String place1) {
		this.place1 = place1;
	}
	public String getPlace2() {
		return place2;
	}
	public void setPlace2(String place2) {
		this.place2 = place2;
	}	
	public String getPlace3() {
		return place3;
	}
	public void setPlace3(String place3) {
		this.place3 = place3;
	}
	public String getPlace4() {
		return place4;
	}
	public void setPlace4(String place4) {
		this.place4 = place4;
	}
}
