package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@Deprecated
/* loaded from: classes2.dex */
public abstract class d {
    private static final Set<d> a = Collections.newSetFromMap(new WeakHashMap());

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface a extends com.google.android.gms.common.api.internal.e {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface b extends com.google.android.gms.common.api.internal.k {
    }

    public static Set<d> c() {
        Set<d> set = a;
        synchronized (set) {
        }
        return set;
    }

    public <A extends a.b, R extends i, T extends com.google.android.gms.common.api.internal.d<R, A>> T a(T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends i, A>> T b(T t) {
        throw new UnsupportedOperationException();
    }

    public Looper d() {
        throw new UnsupportedOperationException();
    }

    public boolean e(com.google.android.gms.common.api.internal.m mVar) {
        throw new UnsupportedOperationException();
    }

    public void f() {
        throw new UnsupportedOperationException();
    }
}