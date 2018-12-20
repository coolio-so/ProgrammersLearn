package so.coolio;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

public class ConfirmDate {
    @Test
    public void 날짜_확인_테스트(){
        int a = 5;
        int b = 24;
        String answer = "";

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("KO"));
        cal.set(2016, (a - 1), b);

        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch (week){
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;
            default:
                answer = "";
                break;
        }
        System.out.println(answer);
    }
}
