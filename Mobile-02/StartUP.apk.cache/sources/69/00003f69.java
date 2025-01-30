package com.squareup.moshi.adapters;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes2.dex */
final class Iso8601Utils {
    static final String GMT_ID = "GMT";
    static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone(GMT_ID);

    Iso8601Utils() {
    }

    private static boolean checkOffset(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append(Matrix.MATRIX_TYPE_ZERO);
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i2, int i3) {
        String num = Integer.toString(i2);
        for (int length = i3 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01a1, IndexOutOfBoundsException -> 0x01a3, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01a1, blocks: (B:3:0x0004, B:6:0x0011, B:8:0x001d, B:9:0x001f, B:11:0x002e, B:13:0x0034, B:17:0x0045, B:19:0x0055, B:20:0x0057, B:22:0x0063, B:23:0x0065, B:25:0x006b, B:29:0x0075, B:34:0x0084, B:36:0x008c, B:41:0x00ca, B:43:0x00d0, B:45:0x00d6, B:66:0x0167, B:50:0x00e1, B:51:0x00fc, B:52:0x00fd, B:54:0x0109, B:57:0x0112, B:59:0x0131, B:62:0x0140, B:63:0x0162, B:65:0x0165, B:68:0x0199, B:69:0x01a0), top: B:75:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0199 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01a1, IndexOutOfBoundsException -> 0x01a3, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01a1, blocks: (B:3:0x0004, B:6:0x0011, B:8:0x001d, B:9:0x001f, B:11:0x002e, B:13:0x0034, B:17:0x0045, B:19:0x0055, B:20:0x0057, B:22:0x0063, B:23:0x0065, B:25:0x006b, B:29:0x0075, B:34:0x0084, B:36:0x008c, B:41:0x00ca, B:43:0x00d0, B:45:0x00d6, B:66:0x0167, B:50:0x00e1, B:51:0x00fc, B:52:0x00fd, B:54:0x0109, B:57:0x0112, B:59:0x0131, B:62:0x0140, B:63:0x0162, B:65:0x0165, B:68:0x0199, B:69:0x01a0), top: B:75:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date parse(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.adapters.Iso8601Utils.parse(java.lang.String):java.util.Date");
    }

    private static int parseInt(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i5 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = -digit;
        } else {
            i4 = 0;
            i5 = i2;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int digit2 = Character.digit(str.charAt(i5), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = (i4 * 10) - digit2;
            i5 = i6;
        }
        return -i4;
    }
}