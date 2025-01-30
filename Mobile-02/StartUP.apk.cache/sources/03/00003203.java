package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class s {
    private static final b a = new c0();

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface a<R extends com.google.android.gms.common.api.i, T> {
        T a(R r);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface b {
        ApiException a(Status status);
    }

    public static <R extends com.google.android.gms.common.api.i, T extends com.google.android.gms.common.api.h<R>> com.google.android.gms.tasks.g<T> a(com.google.android.gms.common.api.e<R> eVar, T t) {
        return b(eVar, new d0(t));
    }

    public static <R extends com.google.android.gms.common.api.i, T> com.google.android.gms.tasks.g<T> b(com.google.android.gms.common.api.e<R> eVar, a<R, T> aVar) {
        b bVar = a;
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        eVar.a(new e0(eVar, hVar, aVar, bVar));
        return hVar.a();
    }

    public static <R extends com.google.android.gms.common.api.i> com.google.android.gms.tasks.g<Void> c(com.google.android.gms.common.api.e<R> eVar) {
        return b(eVar, new f0());
    }
}