package tutorials_baptista.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Tutorial2 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate birthday = LocalDate.of(1987, 11, 8);
        System.out.println(birthday);
        LocalDate nextWeek = today.plusDays(7);
        System.out.println(nextWeek);

        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime noon = LocalTime.of(12, 0);
        System.out.println(noon);
        System.out.println(noon.plusHours(2));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime meeting = LocalDateTime.of(2024, 11, 5 , 10, 30);
        System.out.println(meeting);

        ZonedDateTime zonedNow = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedNow);
        ZonedDateTime meetingTime = ZonedDateTime.of(meeting, ZoneId.of("America/New_York"));
        System.out.println(meetingTime);

        Duration duration = Duration.ofDays(30);
        System.out.println(duration);
        Period period = Period.ofDays(5);
        System.out.println(period);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //  03/11/2024
        String formattedDate = today.format(formatter);
        System.out.println(formattedDate);
        LocalDate parsedDate = LocalDate.parse("20/11/2024", formatter);
        System.out.println(parsedDate);
    }


    /*
    * Key classes in the java.time API
    * 1. LocalDate - represents a year, month, dayOfMonth without the time-zone. It is immutable and thread-safe
    *    - now() - gets you the current date
    *    - of(int year, int month,  int dayOfMonth) - creates a date instance
    *    - plusDays(long days) - Adds days to the date
    *    - minusMonths(long months) - subtracts months from the date
    *
    * 2. LocalTime - represents a time (hours, minute, second, nanoseconds) - without the time-zone
    *   - now()
    *   - of(int hours, minutes, seconds)
    *   - plusHours(long hours)
    *
    * 3. LocalDateTime - combines the LocalDate and the LocalTime into a single object and represents a date-time without the time-zones
    * 4. ZonedDateTime - represents a date and time with a time-zone
    * 5. Duration and Period - Represents a time-based amount of (seconds, nano_seconds)
    * 6. Formatting and Parsing - DateTimeFormatter
    * 7. Working with Calendars - 
    * */
}
