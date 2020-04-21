package 杂项;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        long time = date.getTime();
        System.out.println(time);
        
       //1
        Date date1 = new Date(time);
        System.out.println(date1);
        //2
        date1.setTime(time);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);

    }

    @Test
    public void test1() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date oldDate = sdf.parse("2000-01-01");
        Date newDate = new Date();
        long l = newDate.getTime() - oldDate.getTime();
        long day = l / 1000/60/60/24;
        System.out.println(day);
    }
}
