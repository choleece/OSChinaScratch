package cn.choleece.oschina.util;

import cn.choleece.oschina.constant.DateType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by choleece on 2017/3/25.
 */
public class DateKit {

    public static Long getDate(DateType dateType, String beforeTime) {
        LocalDateTime localDateTime = LocalDateTime.now();

        switch (dateType) {
            case MINUTE:
                localDateTime = localDateTime.plus(Integer.parseInt(beforeTime), ChronoUnit.MINUTES);break;
            case HOUR:
                localDateTime = localDateTime.plus(Integer.parseInt(beforeTime), ChronoUnit.HOURS);break;
            case DAY:
                localDateTime = localDateTime.plus(Integer.parseInt(beforeTime), ChronoUnit.DAYS);break;
            case WEEK:
                localDateTime = localDateTime.plus(Integer.parseInt(beforeTime), ChronoUnit.WEEKS);break;
            case MONTH:
                localDateTime = localDateTime.plus(Integer.parseInt(beforeTime), ChronoUnit.MONTHS);break;
            case YEAR:
                localDateTime = localDateTime.plus(Integer.parseInt(beforeTime), ChronoUnit.YEARS);break;
            default:
                break;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

        return instant.toEpochMilli();
    }

}
