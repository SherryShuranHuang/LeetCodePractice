package EPIC;

public class ClockAngle {
	public static void main(String[] args) {
		String time = "6:00";
		
		System.out.println("Angle when time is " + time + " : " + calculateAngle(time));
	}
	
	public static double calculateAngle(String time){
		String[] splitTime = time.split(":");
		int hh = Integer.parseInt(splitTime[0]);
		int mm = Integer.parseInt(splitTime[1]);
		return calculateAngle(hh,mm);
	}
	public static double calculateAngle(int hh, int mm) {
		// one hour is 30 degree
		// one min is 6 degree
		// when a min passes, the handle of hour also moves 0.5 degree
		double angle = Math.abs(mm * 6 - (hh * 30 + mm * 0.5));
		return angle>180?angle-180:angle;

	}
}
