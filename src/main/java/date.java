import java.text.SimpleDateFormat;
import java.util.Calendar;

public class date {
public static void main(String[] args) {
	Calendar c = Calendar.getInstance();
	
	c.setTime(c.getTime());
	c.add(Calendar.DATE, 3);
	
	String dateString = new SimpleDateFormat("MM‘¬dd»’").format(c.getTime());
	System.out.println(dateString);
}
}
