package com.google.firebase.crashlytics.c.j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class d {
    private static final Pattern a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(String str) {
        Matcher matcher = a.matcher(str);
        if (matcher.matches()) {
            try {
                long longValue = Long.valueOf(matcher.group(1), 16).longValue();
                return new c(longValue, Long.valueOf(matcher.group(2), 16).longValue() - longValue, matcher.group(3), matcher.group(4));
            } catch (Exception unused) {
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.b("Could not parse map entry: " + str);
                return null;
            }
        }
        return null;
    }
}