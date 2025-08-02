package datasCalculos;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		
		LocalDate d01 = LocalDate.parse("2022-07-20");
		LocalDateTime d02 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d03 = Instant.parse("2022-07-20T01:30:26Z");
		
		LocalDate pastWeekLocalDate = d01.minusDays(7);
		LocalDate nextWeekLocalDate = d01.plusDays(7);
			
		System.out.println("pastweeklocaldate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
		//mostra a data
		LocalDateTime pastWeekLocalDateTime = d02.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d02.plusDays(7);
		
		System.out.println("pastweeklocaldate = " + pastWeekLocalDateTime);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDateTime);
		//mostra a data junto com o horário
		Instant pastWeekInstant = d03.minus(7,ChronoUnit.DAYS);
		Instant nextWeekInstant = d03.plus(7,ChronoUnit.DAYS);
		
		System.out.println("pastWeekInstant = " + pastWeekInstant);
		System.out.println("pastWeekInstant = " + nextWeekInstant);
		// instant mostra a posição do fuso horário
		Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d01.atStartOfDay());
		Duration t2 = Duration.between(pastWeekLocalDateTime, d02);
		Duration t3 = Duration.between(pastWeekInstant, d03);
		Duration t4 = Duration.between(d03, pastWeekInstant);
		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t2 dias = " + t2.toDays());
		System.out.println("t3 dias = " + t3.toDays());
		System.out.println("t4 dias = " + t4.toDays());
	}

}
