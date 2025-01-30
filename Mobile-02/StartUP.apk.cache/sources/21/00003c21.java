package com.google.gson.u;

import com.google.gson.s;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: Excluder.java */
/* loaded from: classes2.dex */
public final class d implements t, Cloneable {
    public static final d a = new d();

    /* renamed from: e  reason: collision with root package name */
    private boolean f9593e;

    /* renamed from: b  reason: collision with root package name */
    private double f9590b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private int f9591c = CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9592d = true;

    /* renamed from: f  reason: collision with root package name */
    private List<com.google.gson.b> f9594f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<com.google.gson.b> f9595g = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* loaded from: classes2.dex */
    class a<T> extends s<T> {
        private s<T> a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f9596b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f9597c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f9598d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.google.gson.v.a f9599e;

        a(boolean z, boolean z2, com.google.gson.f fVar, com.google.gson.v.a aVar) {
            this.f9596b = z;
            this.f9597c = z2;
            this.f9598d = fVar;
            this.f9599e = aVar;
        }

        private s<T> a() {
            s<T> sVar = this.a;
            if (sVar != null) {
                return sVar;
            }
            s<T> n = this.f9598d.n(d.this, this.f9599e);
            this.a = n;
            return n;
        }

        @Override // com.google.gson.s
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (this.f9596b) {
                aVar.J0();
                return null;
            }
            return a().read(aVar);
        }

        @Override // com.google.gson.s
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            if (this.f9597c) {
                cVar.A();
            } else {
                a().write(cVar, t);
            }
        }
    }

    private boolean d(Class<?> cls) {
        if (this.f9590b == -1.0d || o((com.google.gson.annotations.c) cls.getAnnotation(com.google.gson.annotations.c.class), (com.google.gson.annotations.d) cls.getAnnotation(com.google.gson.annotations.d.class))) {
            return (!this.f9592d && i(cls)) || h(cls);
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z) {
        for (com.google.gson.b bVar : z ? this.f9594f : this.f9595g) {
            if (bVar.b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean h(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean i(Class<?> cls) {
        return cls.isMemberClass() && !k(cls);
    }

    private boolean k(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean l(com.google.gson.annotations.c cVar) {
        return cVar == null || cVar.value() <= this.f9590b;
    }

    private boolean n(com.google.gson.annotations.d dVar) {
        return dVar == null || dVar.value() > this.f9590b;
    }

    private boolean o(com.google.gson.annotations.c cVar, com.google.gson.annotations.d dVar) {
        return l(cVar) && n(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean c(Class<?> cls, boolean z) {
        return d(cls) || e(cls, z);
    }

    @Override // com.google.gson.t
    public <T> s<T> create(com.google.gson.f fVar, com.google.gson.v.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean d2 = d(rawType);
        boolean z = d2 || e(rawType, true);
        boolean z2 = d2 || e(rawType, false);
        if (z || z2) {
            return new a(z2, z, fVar, aVar);
        }
        return null;
    }

    public boolean f(Field field, boolean z) {
        com.google.gson.annotations.a aVar;
        if ((this.f9591c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f9590b == -1.0d || o((com.google.gson.annotations.c) field.getAnnotation(com.google.gson.annotations.c.class), (com.google.gson.annotations.d) field.getAnnotation(com.google.gson.annotations.d.class))) && !field.isSynthetic()) {
            if (!this.f9593e || ((aVar = (com.google.gson.annotations.a) field.getAnnotation(com.google.gson.annotations.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.f9592d || !i(field.getType())) && !h(field.getType())) {
                    List<com.google.gson.b> list = z ? this.f9594f : this.f9595g;
                    if (list.isEmpty()) {
                        return false;
                    }
                    com.google.gson.c cVar = new com.google.gson.c(field);
                    for (com.google.gson.b bVar : list) {
                        if (bVar.a(cVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}