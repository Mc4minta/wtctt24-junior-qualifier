package com.facebook.react.views.text;

import java.text.BreakIterator;

/* compiled from: TextTransform.java */
/* loaded from: classes2.dex */
public enum c0 {
    NONE,
    UPPERCASE,
    LOWERCASE,
    CAPITALIZE,
    UNSET;

    /* compiled from: TextTransform.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c0.values().length];
            a = iArr;
            try {
                iArr[c0.UPPERCASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c0.LOWERCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c0.CAPITALIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String h(String str, c0 c0Var) {
        if (str == null) {
            return null;
        }
        int i2 = a.a[c0Var.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return i2 != 3 ? str : n(str);
            }
            return str.toLowerCase();
        }
        return str.toUpperCase();
    }

    private static String n(String str) {
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(str);
        StringBuilder sb = new StringBuilder(str.length());
        int first = wordInstance.first();
        while (true) {
            int i2 = first;
            first = wordInstance.next();
            if (first != -1) {
                String substring = str.substring(i2, first);
                if (Character.isLetterOrDigit(substring.charAt(0))) {
                    sb.append(Character.toUpperCase(substring.charAt(0)));
                    sb.append(substring.substring(1).toLowerCase());
                } else {
                    sb.append(substring);
                }
            } else {
                return sb.toString();
            }
        }
    }
}