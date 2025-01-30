package e.g.b.a.d;

import java.io.Serializable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: DateTime.java */
/* loaded from: classes2.dex */
public final class l implements Serializable {
    private static final TimeZone a = TimeZone.getTimeZone("GMT");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f13444b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");

    /* renamed from: c  reason: collision with root package name */
    private final long f13445c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f13446d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13447e;

    public l(long j2) {
        this(false, j2, null);
    }

    private static void a(StringBuilder sb, int i2, int i3) {
        if (i2 < 0) {
            sb.append('-');
            i2 = -i2;
        }
        int i4 = i2;
        while (i4 > 0) {
            i4 /= 10;
            i3--;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            sb.append('0');
        }
        if (i2 != 0) {
            sb.append(i2);
        }
    }

    public static l b(String str) throws NumberFormatException {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Matcher matcher = f13444b.matcher(str);
        if (matcher.matches()) {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2)) - 1;
            int parseInt3 = Integer.parseInt(matcher.group(3));
            boolean z2 = matcher.group(4) != null;
            String group = matcher.group(9);
            boolean z3 = group != null;
            Integer num = null;
            if (z3 && !z2) {
                throw new NumberFormatException("Invalid date/time format, cannot specify time zone shift without specifying time: " + str);
            }
            if (z2) {
                int parseInt4 = Integer.parseInt(matcher.group(5));
                int parseInt5 = Integer.parseInt(matcher.group(6));
                int parseInt6 = Integer.parseInt(matcher.group(7));
                if (matcher.group(8) != null) {
                    z = z2;
                    i2 = (int) (Integer.parseInt(matcher.group(8).substring(1)) / Math.pow(10.0d, matcher.group(8).substring(1).length() - 3));
                    i4 = parseInt5;
                    i5 = parseInt6;
                } else {
                    z = z2;
                    i4 = parseInt5;
                    i5 = parseInt6;
                    i2 = 0;
                }
                i3 = parseInt4;
            } else {
                z = z2;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(a);
            gregorianCalendar.set(parseInt, parseInt2, parseInt3, i3, i4, i5);
            gregorianCalendar.set(14, i2);
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (z && z3) {
                if (Character.toUpperCase(group.charAt(0)) == 'Z') {
                    i6 = 0;
                } else {
                    int parseInt7 = (Integer.parseInt(matcher.group(11)) * 60) + Integer.parseInt(matcher.group(12));
                    if (matcher.group(10).charAt(0) == '-') {
                        parseInt7 = -parseInt7;
                    }
                    i6 = parseInt7;
                    timeInMillis -= i6 * 60000;
                }
                num = Integer.valueOf(i6);
            }
            return new l(!z, timeInMillis, num);
        }
        throw new NumberFormatException("Invalid date/time format: " + str);
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(a);
        gregorianCalendar.setTimeInMillis(this.f13445c + (this.f13447e * 60000));
        a(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        a(sb, gregorianCalendar.get(5), 2);
        if (!this.f13446d) {
            sb.append('T');
            a(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                a(sb, gregorianCalendar.get(14), 3);
            }
            int i2 = this.f13447e;
            if (i2 == 0) {
                sb.append(Matrix.MATRIX_TYPE_ZERO);
            } else {
                if (i2 > 0) {
                    sb.append('+');
                } else {
                    sb.append('-');
                    i2 = -i2;
                }
                a(sb, i2 / 60, 2);
                sb.append(':');
                a(sb, i2 % 60, 2);
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.f13446d == lVar.f13446d && this.f13445c == lVar.f13445c && this.f13447e == lVar.f13447e;
        }
        return false;
    }

    public int hashCode() {
        long[] jArr = new long[3];
        jArr[0] = this.f13445c;
        jArr[1] = this.f13446d ? 1L : 0L;
        jArr[2] = this.f13447e;
        return Arrays.hashCode(jArr);
    }

    public String toString() {
        return c();
    }

    public l(boolean z, long j2, Integer num) {
        int offset;
        this.f13446d = z;
        this.f13445c = j2;
        if (z) {
            offset = 0;
        } else {
            offset = num == null ? TimeZone.getDefault().getOffset(j2) / 60000 : num.intValue();
        }
        this.f13447e = offset;
    }
}