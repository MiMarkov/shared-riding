package start.project1;

import java.util.Calendar;

public class TimeData {
	private long unixTime;
	private float timeZone;
	private String humanFriendlyTime;
	
	public long getUnixTime() {
		return unixTime;
	}
	
	public float getTimeZone() {
		return timeZone;
	}
	
	public String getHumanFriendlyTime() {
		return humanFriendlyTime;
	}
	
	public TimeData() {
		unixTime = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		timeZone = cal.get(Calendar.ZONE_OFFSET) / 3600000.0f;
		humanFriendlyTime = cal.getTime().toString();
	}
}
