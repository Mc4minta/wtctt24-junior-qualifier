package com.facebook.hermes.unicode;

import e.f.l.a.a;
import java.text.Collator;
import java.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;

@a
/* loaded from: classes2.dex */
public class AndroidUnicodeUtils {
    @a
    public static String convertToCase(String str, int i2, boolean z) {
        Locale locale = z ? Locale.getDefault() : Locale.ENGLISH;
        if (i2 != 0) {
            if (i2 == 1) {
                return str.toLowerCase(locale);
            }
            throw new RuntimeException("Invalid target case");
        }
        return str.toUpperCase(locale);
    }

    @a
    public static String dateFormat(double d2, boolean z, boolean z2) {
        DateFormat timeInstance;
        if (z && z2) {
            timeInstance = DateFormat.getDateTimeInstance(2, 2);
        } else if (z) {
            timeInstance = DateFormat.getDateInstance(2);
        } else if (z2) {
            timeInstance = DateFormat.getTimeInstance(2);
        } else {
            throw new RuntimeException("Bad dateFormat configuration");
        }
        return timeInstance.format(Long.valueOf((long) d2)).toString();
    }

    @a
    public static int localeCompare(String str, String str2) {
        return Collator.getInstance().compare(str, str2);
    }

    @a
    public static String normalize(String str, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return Normalizer.normalize(str, Normalizer.Form.NFKD);
                    }
                    throw new RuntimeException("Invalid form");
                }
                return Normalizer.normalize(str, Normalizer.Form.NFKC);
            }
            return Normalizer.normalize(str, Normalizer.Form.NFD);
        }
        return Normalizer.normalize(str, Normalizer.Form.NFC);
    }
}