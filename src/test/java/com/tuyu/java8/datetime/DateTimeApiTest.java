package com.tuyu.java8.datetime;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.util.stream.Stream;

/**
 * java8新特性，日期，时间api
 * @author tuyu
 * @date 9/27/18
 * Talk is cheap, show me the code.
 */
public class DateTimeApiTest {


    @Test
    public void testClock() {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testLocakDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        Clock clock = Clock.systemUTC();
        LocalDate fromClock = LocalDate.now(clock);
        System.out.println(fromClock);
    }

    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        Clock clock = Clock.systemUTC();
        LocalTime fromClock = LocalTime.now(clock);
        System.out.println(fromClock);

    }

    /**
     * 2018-09-28T00:56:17.741Z 等同于 2018-09-28T00:56:17.741 UTC
     * <p>“Z”是协调世界时中0时区的标志</p>
     * 参考链接：https://zh.wikipedia.org/wiki/%E6%97%B6%E5%8C%BA
     */
    @Test
    public void testZonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        Clock clock = Clock.systemUTC();
        ZonedDateTime fromClock = ZonedDateTime.now(clock);
        System.out.println(fromClock);

        ZonedDateTime america = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(america);
    }

    @Test
    public void testZoneId() {
        Clock utc = Clock.system(ZoneId.of("UTC+8"));
        Clock gmt = Clock.system(ZoneId.of("GMT+8"));
        LocalDateTime utcNow = LocalDateTime.now(utc);
        LocalDateTime gmtNow = LocalDateTime.now(gmt);
        System.out.println(utcNow);
        System.out.println(gmtNow);
    }

    @Test
    public void testDuration() {
        LocalDateTime from = LocalDateTime.of(2018, Month.SEPTEMBER, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2018, Month.SEPTEMBER, 30, 23, 59, 59);

        Duration duration = Duration.between(from, to);

        System.out.println("duration in days: " + duration.toDays());
        System.out.println("duration in hours: " + duration.toHours());
        System.out.println("duration in seconds: " + duration.getSeconds());
        System.out.println(719*60*60);
        System.out.println(duration.getSeconds() - 719*60*60);
        System.out.println(3599/60);
    }
}
