package cn.choleece.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Timer;

/**
 * Created by choleece on 2017/3/25.
 */
public class TestDate {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        localDateTime = localDateTime.plus(1, ChronoUnit.MINUTES);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

        String test = localDateTime.format(formatter);

        System.out.println(test);

        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

        System.out.println(instant.toEpochMilli() + "   " + new Date(instant.toEpochMilli()));
    }
}
