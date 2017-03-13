import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;

public class Kalender{
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date d = new Date();
		String date = sdf.format(d);
		System.out.println("I dag er det den: " + date);

		MonthDay m = MonthDay.now();
		if(m.getMonthValue() == 12){
			Juleramme jul = new Juleramme(m.getDayOfMonth());
		}
	}
}