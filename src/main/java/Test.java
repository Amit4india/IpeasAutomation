
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) throws ParseException  {
        String data = "Jan 1, 2017 8:44:00 AM";

        		SimpleDateFormat dt = new SimpleDateFormat();
        Date date1 = dt.parse(data);

        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("MMM d, yyyy");
        System.out.println(dt1.format(data));
    


}
}
