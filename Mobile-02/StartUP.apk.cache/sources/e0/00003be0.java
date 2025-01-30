package com.google.gson;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes2.dex */
final class a extends s<Date> {
    private final Class<? extends Date> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f9515b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f9515b = arrayList;
        this.a = c(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private Date a(String str) {
        synchronized (this.f9515b) {
            for (DateFormat dateFormat : this.f9515b) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.google.gson.u.n.o.a.c(str, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException(str, e2);
            }
        }
    }

    private static Class<? extends Date> c(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.s
    /* renamed from: b */
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == com.google.gson.stream.b.NULL) {
            aVar.a0();
            return null;
        }
        Date a = a(aVar.e0());
        Class<? extends Date> cls = this.a;
        if (cls == Date.class) {
            return a;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a.getTime());
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.s
    /* renamed from: d */
    public void write(com.google.gson.stream.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.A();
            return;
        }
        synchronized (this.f9515b) {
            cVar.s0(this.f9515b.get(0).format(date));
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f9515b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.f9515b = arrayList;
        this.a = c(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (com.google.gson.u.e.e()) {
            arrayList.add(com.google.gson.u.j.c(i2, i3));
        }
    }
}