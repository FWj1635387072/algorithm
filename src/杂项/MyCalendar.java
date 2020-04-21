package 杂项;

import org.junit.Test;

import java.util.Calendar;

public class MyCalendar {

    public static void main(String[] args) {
        //获取一个公历对象，多态，获取字类对象
        Calendar calendar = Calendar.getInstance();
        //获取年
        System.out.println(calendar.get(Calendar.YEAR));
        //获取月
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        //获取日
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //获取时
        System.out.println(calendar.get(Calendar.HOUR));
        //获取分
        System.out.println(calendar.get(Calendar.MINUTE));
        //获取秒
        System.out.println(calendar.get(Calendar.SECOND));
        //一周的第几天，周日为第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }


    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();
        //add 方法
        calendar.add(Calendar.YEAR,1);//给年加一
        System.out.println(calendar.get(Calendar.YEAR));

        //set方法，制定年月日
        calendar.set(Calendar.MONTH,11);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));


        //判断任意一年是否为闰年
        int year = 21230;
        calendar.set(year,2,1);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        
        if(calendar.get(Calendar.DAY_OF_MONTH) == 29){
            System.out.println("是闰年");
        }else {
            System.out.println("不是闰年");
        }
    }
}
