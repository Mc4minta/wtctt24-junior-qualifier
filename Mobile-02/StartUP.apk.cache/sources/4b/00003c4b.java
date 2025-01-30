package com.google.gson.u.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes2.dex */
public final class j extends s<Date> {
    public static final t a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f9646b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes2.dex */
    static class a implements t {
        a() {
        }

        @Override // com.google.gson.t
        public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // com.google.gson.s
    /* renamed from: a */
    public synchronized Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == com.google.gson.stream.b.NULL) {
            aVar.a0();
            return null;
        }
        try {
            return new Date(this.f9646b.parse(aVar.e0()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.s
    /* renamed from: b */
    public synchronized void write(com.google.gson.stream.c cVar, Date date) throws IOException {
        cVar.s0(date == null ? null : this.f9646b.format((java.util.Date) date));
    }
}