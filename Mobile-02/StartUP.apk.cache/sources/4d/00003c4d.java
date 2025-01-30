package com.google.gson.u.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes2.dex */
public final class k extends s<Time> {
    public static final t a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f9647b = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* loaded from: classes2.dex */
    static class a implements t {
        a() {
        }

        @Override // com.google.gson.t
        public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // com.google.gson.s
    /* renamed from: a */
    public synchronized Time read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == com.google.gson.stream.b.NULL) {
            aVar.a0();
            return null;
        }
        try {
            return new Time(this.f9647b.parse(aVar.e0()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.s
    /* renamed from: b */
    public synchronized void write(com.google.gson.stream.c cVar, Time time) throws IOException {
        cVar.s0(time == null ? null : this.f9647b.format((Date) time));
    }
}