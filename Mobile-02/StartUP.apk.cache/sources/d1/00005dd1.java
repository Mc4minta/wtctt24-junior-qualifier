package org.apache.http.impl.cookie;

import java.util.BitSet;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
public class LaxExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final BitSet DELIMS;
    private static final Map<String, Integer> MONTHS;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final Pattern YEAR_PATTERN;

    static {
        BitSet bitSet = new BitSet();
        bitSet.set(9);
        for (int i2 = 32; i2 <= 47; i2++) {
            bitSet.set(i2);
        }
        for (int i3 = 59; i3 <= 64; i3++) {
            bitSet.set(i3);
        }
        for (int i4 = 91; i4 <= 96; i4++) {
            bitSet.set(i4);
        }
        for (int i5 = 123; i5 <= 126; i5++) {
            bitSet.set(i5);
        }
        DELIMS = bitSet;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(12);
        concurrentHashMap.put("jan", 0);
        concurrentHashMap.put("feb", 1);
        concurrentHashMap.put("mar", 2);
        concurrentHashMap.put("apr", 3);
        concurrentHashMap.put("may", 4);
        concurrentHashMap.put("jun", 5);
        concurrentHashMap.put("jul", 6);
        concurrentHashMap.put("aug", 7);
        concurrentHashMap.put("sep", 8);
        concurrentHashMap.put("oct", 9);
        concurrentHashMap.put("nov", 10);
        concurrentHashMap.put("dec", 11);
        MONTHS = concurrentHashMap;
        TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
        DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
        MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
        YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
    }

    private void copyContent(CharSequence charSequence, ParserCursor parserCursor, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char charAt = charSequence.charAt(pos2);
            if (DELIMS.get(charAt)) {
                break;
            }
            pos++;
            sb.append(charAt);
        }
        parserCursor.updatePos(pos);
    }

    private void skipDelims(CharSequence charSequence, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            if (!DELIMS.get(charSequence.charAt(pos2))) {
                break;
            }
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    @Override // org.apache.http.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.EXPIRES_ATTR;
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        int i2;
        Args.notNull(setCookie, SM.COOKIE);
        int i3 = 0;
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (!parserCursor.atEnd()) {
            try {
                skipDelims(str, parserCursor);
                sb.setLength(i3);
                copyContent(str, parserCursor, sb);
                if (sb.length() == 0) {
                    break;
                }
                if (!z) {
                    Matcher matcher = TIME_PATTERN.matcher(sb);
                    if (matcher.matches()) {
                        i6 = Integer.parseInt(matcher.group(1));
                        i7 = Integer.parseInt(matcher.group(2));
                        i8 = Integer.parseInt(matcher.group(3));
                        i3 = 0;
                        z = true;
                    }
                }
                if (!z2) {
                    Matcher matcher2 = DAY_OF_MONTH_PATTERN.matcher(sb);
                    if (matcher2.matches()) {
                        i5 = Integer.parseInt(matcher2.group(1));
                        i3 = 0;
                        z2 = true;
                    }
                }
                if (!z3) {
                    Matcher matcher3 = MONTH_PATTERN.matcher(sb);
                    if (matcher3.matches()) {
                        i9 = MONTHS.get(matcher3.group(1).toLowerCase(Locale.ROOT)).intValue();
                        i3 = 0;
                        z3 = true;
                    }
                }
                if (!z4) {
                    Matcher matcher4 = YEAR_PATTERN.matcher(sb);
                    if (matcher4.matches()) {
                        i4 = Integer.parseInt(matcher4.group(1));
                        i3 = 0;
                        z4 = true;
                    }
                }
                i3 = 0;
            } catch (NumberFormatException unused) {
                throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
            }
        }
        if (!z || !z2 || !z3 || !z4) {
            throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i5 >= 1 && i5 <= 31 && i4 >= 1601 && i6 <= 23 && i7 <= 59 && (i2 = i8) <= 59) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(UTC);
            calendar.setTimeInMillis(0L);
            calendar.set(13, i2);
            calendar.set(12, i7);
            calendar.set(11, i6);
            calendar.set(5, i5);
            calendar.set(2, i9);
            calendar.set(1, i4);
            setCookie.setExpiryDate(calendar.getTime());
            return;
        }
        throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
    }
}