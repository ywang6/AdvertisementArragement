package file_test;

public class Ad {
	private String name = null;
	private int startTime = -1;
	private int endTime = -1;
	private String place = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	@Override
	public String toString() {
		return name + " " + startTime + " " + endTime + " " + place;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
}
