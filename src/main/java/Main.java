import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Main {
	public static void main(String[] args) {
		//ChronoUnit
		LocalDateTime localDateTime = LocalDateTime.now().minus(20, ChronoUnit.HOURS);
		System.out.println(localDateTime);

		//Period
		Period period = Period.ofMonths(1);
		System.out.println(period);

		Temporal temporal = period.addTo(localDateTime);
		System.out.println(LocalDateTime.from(temporal));

		//Duration
		Duration duration = Duration.ofSeconds(30);
		Temporal temporal1 = duration.addTo(localDateTime);
		System.out.println(temporal1);

		//Instant - time in machine readable form
		Instant instant = Instant.now();
		System.out.println(instant);

		Instant instant1 = Instant.ofEpochSecond(0);
		System.out.println(instant1);

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);

		ZoneId.getAvailableZoneIds().forEach(System.out::println);

		System.out.println("--------------");
		ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("UTC = " + utc);

		System.out.println("UTC clock: = " + ZonedDateTime.now(Clock.systemUTC()));

		//Local to Zoned
		ZoneId defaultZone = Clock.systemDefaultZone().getZone();
		ZonedDateTime zonedDateTime1 = LocalDateTime.now().atZone(defaultZone);
		System.out.println("Zoned now: " + zonedDateTime1);

		//To Zone
		ZonedDateTime toUTC = ZonedDateTime.ofInstant(zonedDateTime1.toInstant(), ZoneOffset.UTC);
		System.out.println("To UTC: " + toUTC);

	}
}
