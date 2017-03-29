package com.tacme.student.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public class UniqueIdGenerator {
private static AtomicReference<Long> time = new AtomicReference<Long>(System.currentTimeMillis());
	
	public static String getUniqueId(String prependString) {
		SimpleDateFormat format=new SimpleDateFormat("ddMMyy");
		Calendar now = new GregorianCalendar(TimeZone.getTimeZone("IST"));
		String date=format.format(now.getTime());
		Long prev;
		Long next = System.currentTimeMillis();
		do {
			prev = time.get();
			next = next > prev ? next : prev + 1;
		} while (!time.compareAndSet(prev, next));
		return prependString+date+next;
	}	
}
