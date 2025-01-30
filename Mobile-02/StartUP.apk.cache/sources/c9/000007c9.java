package com.bugsnag.android;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateUtils.java */
/* loaded from: classes.dex */
class x {
    private static final ThreadLocal<DateFormat> a = new a();

    /* compiled from: DateUtils.java */
    /* loaded from: classes.dex */
    static class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public DateFormat initialValue() {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Date a(String str) throws ParseException {
        return a.get().parse(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Date date) {
        return a.get().format(date);
    }
}