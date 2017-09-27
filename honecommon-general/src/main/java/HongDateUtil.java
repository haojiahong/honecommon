import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by haojiahong on 2017/9/26.
 */
public class HongDateUtil {

    /**
     * 获取当前时间的字符串(格式为yyyy-MM-dd HH:mm:ss)
     *
     * @return
     */
    public static String nowDateTimeStr() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(dateTimeFormatter);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date nowDateTime() {
        return new Date();
    }

    /**
     * 将时间字符串(格式为yyyy-MM-dd HH:mm:ss)转换为Date
     *
     * @param dateStr 格式为yyyy-MM-dd HH:mm:ss的时间字符串
     * @return
     */
    public static Date str2Date(String dateStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, dateTimeFormatter);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    /**
     * 时间转时间字符串(格式为yyyy-MM-dd HH:mm:ss)
     *
     * @param date 时间
     * @return
     */
    public static String date2Str(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(dateTimeFormatter);

    }
}
