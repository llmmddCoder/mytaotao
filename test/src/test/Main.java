package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


    
    /**
     * 查询日期间有几天一周中的某一天
     * 日期格式 yyyy-MM-dd yyyy-MM-dd 1-7(表示周一到周日) 
     * @param startDay 准备查询的起始日期
     * @param endDay 准备查询的结束日期
     * @param dayOfWeek 准备查的一周中的某一天(准备查周几？)
     * @return 包含所查周几的天数
     * @throws ParseException 不支持跨年查询、不支持结束日期早于起始日期、周几输入错误等
     */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t1 = in.nextLine();
        String t2 = in.nextLine();
        SimpleDateFormat smdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        try {
            Date start = smdf.parse(t1);
            Date end = smdf.parse(t2);
            long t = (end.getTime() - start.getTime()) /1000;
            if(t1.charAt(12)=='0' || t2.charAt(12)=='0'){
                System.out.println(t/(3600*24)-1+","+getMondayNumber(t1,t2,4));
            }else if(t>=(3600*24)){
                System.out.println(t/(3600*24)+","+getMondayNumber(t1,t2,4));
            }else{
                System.out.println(0+","+0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
   }
    public static int getMondayNumber(String startDay,String endDay,int dayOfWeek) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int differenceDay = 0;
        //转换起始日期
        Date startDate = sdf.parse(startDay);
        //转换结束日期
        Date endDate = sdf.parse(endDay); 
        //实例化起始和结束Calendar对象
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        //分别设置Calendar对象的时间
        startCalendar.setTime(startDate);
        endCalendar.setTime(endDate);

        //定义起始日期和结束日期分别属于第几周
        int startWeek = startCalendar.get(Calendar.WEEK_OF_YEAR);
        int endWeek = endCalendar.get(Calendar.WEEK_OF_YEAR);
//        int startTime = startCalendar.get(Calendar.HOUR_OF_DAY);
//        int endTime = endCalendar.get(Calendar.HOUR_OF_DAY);
        //拿到起始日期是星期几
        int startDayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
        if(startDayOfWeek == 1)    {
            startDayOfWeek = 7;
            startWeek--;
        }else startDayOfWeek--;
        
        //拿到结束日期是星期几
        int endDayOfWeek = endCalendar.get(Calendar.DAY_OF_WEEK);
        if(endDayOfWeek == 1) {
            endDayOfWeek = 7;
            endWeek--;
        }else endDayOfWeek--;
        
        //计算相差的周数
        int differenceWeek = endWeek - startWeek;
        
        //开始计算
        if(startDayOfWeek <= dayOfWeek) {
            if(endDayOfWeek >= dayOfWeek)
                differenceDay = differenceWeek + 1;
        }else if(startDayOfWeek > dayOfWeek) {
            if(endDayOfWeek < dayOfWeek)
                differenceDay = differenceWeek-1;
        }else {
            differenceDay = differenceWeek;
        }
        if(startDayOfWeek == 4){
            return differenceDay-2;
        }
        return differenceDay;
    }
}
