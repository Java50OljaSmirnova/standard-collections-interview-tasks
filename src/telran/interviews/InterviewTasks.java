package telran.interviews;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
	
	static public void displayShuffled(int [] ar) {
		new Random().ints(0, ar.length).distinct().limit(ar.length)
		.forEach(i -> System.out.print(ar[i] + " "));
		
	}
	static public List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates){
		TreeMap<LocalDate, String> mapDateRole = new TreeMap<>();
		datesRoles.forEach(dr -> mapDateRole.put(dr.date(), dr.role()));
		return dates.stream().map(d -> {
			Map.Entry<LocalDate, String> entry = mapDateRole.floorEntry(d);
			DateRole dr = new DateRole(d, entry == null ? null: entry.getValue());
			return dr;
		}).toList();
	}
}
