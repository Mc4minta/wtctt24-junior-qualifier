package com.google.gson.u.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter.java */
/* loaded from: classes2.dex */
public final class c extends s<Date> {
    public static final t a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f9626b;

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes2.dex */
    static class a implements t {
        a() {
        }

        @Override // com.google.gson.t
        public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f9626b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.u.e.e()) {
            arrayList.add(com.google.gson.u.j.c(2, 2));
        }
    }

    private synchronized Date a(String str) {
        for (DateFormat dateFormat : this.f9626b) {
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

    @Override // com.google.gson.s
    /* renamed from: b */
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == com.google.gson.stream.b.NULL) {
            aVar.a0();
            return null;
        }
        return a(aVar.e0());
    }

    @Override // com.google.gson.s
    /* renamed from: c */
    public synchronized void write(com.google.gson.stream.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.A();
        } else {
            cVar.s0(this.f9626b.get(0).format(date));
        }
    }
}