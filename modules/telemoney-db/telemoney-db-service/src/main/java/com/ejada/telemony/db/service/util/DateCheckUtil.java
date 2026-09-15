package com.ejada.telemony.db.service.util;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateCheckUtil {

    private DateCheckUtil() {
        // Utility class – prevent instantiation
    }

    public static boolean isSameLocalDate(Date d1, Date d2) {
        if (d1 == null && d2 == null) return true;
        if (d1 == null || d2 == null) return false;

        LocalDate ld1 = d1.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate ld2 = d2.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return ld1.equals(ld2);
    }
}
