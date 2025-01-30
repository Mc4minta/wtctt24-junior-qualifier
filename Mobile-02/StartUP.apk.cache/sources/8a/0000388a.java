package com.google.common.base;

import org.apache.http.message.TokenParser;

/* compiled from: Ascii.java */
/* loaded from: classes2.dex */
public final class b {
    public static boolean a(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static String b(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (a(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (a(c2)) {
                        charArray[i2] = (char) (c2 ^ TokenParser.SP);
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }
}