package main.com.imooc.utils.jdk18;

import java.time.*;

public class DateTime {
    /**
     * 让我们用例子来看一下新版API主要类的使用方法。
     * 第一个是Clock类，它通过指定一个时区，
     * 然后就可以获取到当前的时刻，日期与时间。
     * Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
     *
     *
     * @param args
     */
    public static void main(String[] args){
        // Get the system clock as UTC offset
      final Clock clock = Clock.systemUTC();
      System.out.println( clock.instant() );
      System.out.println( clock.millis() );


        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now( clock );

        System.out.println( date );
        System.out.println( dateFromClock );

// Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now( clock );

        System.out.println( time );
        System.out.println( timeFromClock );

       // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );


    }
}
