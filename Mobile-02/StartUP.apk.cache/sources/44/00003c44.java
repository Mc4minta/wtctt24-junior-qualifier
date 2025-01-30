package com.google.gson.u.n;

import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes2.dex */
public final class h extends s<Object> {
    public static final t a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.f f9631b;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes2.dex */
    static class a implements t {
        a() {
        }

        @Override // com.google.gson.t
        public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[com.google.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.stream.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.stream.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.stream.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.stream.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.stream.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    h(com.google.gson.f fVar) {
        this.f9631b = fVar;
    }

    @Override // com.google.gson.s
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        switch (b.a[aVar.k0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.m()) {
                    arrayList.add(read(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                com.google.gson.u.h hVar = new com.google.gson.u.h();
                aVar.b();
                while (aVar.m()) {
                    hVar.put(aVar.O(), read(aVar));
                }
                aVar.g();
                return hVar;
            case 3:
                return aVar.e0();
            case 4:
                return Double.valueOf(aVar.G());
            case 5:
                return Boolean.valueOf(aVar.A());
            case 6:
                aVar.a0();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.s
    public void write(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.A();
            return;
        }
        s m = this.f9631b.m(obj.getClass());
        if (m instanceof h) {
            cVar.d();
            cVar.g();
            return;
        }
        m.write(cVar, obj);
    }
}