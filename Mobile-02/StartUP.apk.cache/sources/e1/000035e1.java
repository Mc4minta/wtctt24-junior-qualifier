package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public class z3 {
    private static volatile z3 a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile z3 f7449b;

    /* renamed from: c  reason: collision with root package name */
    private static final z3 f7450c = new z3(true);

    /* renamed from: d  reason: collision with root package name */
    private final Map<a, n4.d<?, ?>> f7451d;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    static final class a {
        private final Object a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7452b;

        a(Object obj, int i2) {
            this.a = obj;
            this.f7452b = i2;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.f7452b == aVar.f7452b;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f7452b;
        }
    }

    z3() {
        this.f7451d = new HashMap();
    }

    public static z3 a() {
        z3 z3Var = a;
        if (z3Var == null) {
            synchronized (z3.class) {
                z3Var = a;
                if (z3Var == null) {
                    z3Var = f7450c;
                    a = z3Var;
                }
            }
        }
        return z3Var;
    }

    public static z3 c() {
        z3 z3Var = f7449b;
        if (z3Var != null) {
            return z3Var;
        }
        synchronized (z3.class) {
            z3 z3Var2 = f7449b;
            if (z3Var2 != null) {
                return z3Var2;
            }
            z3 b2 = m4.b(z3.class);
            f7449b = b2;
            return b2;
        }
    }

    public final <ContainingType extends u5> n4.d<ContainingType, ?> b(ContainingType containingtype, int i2) {
        return (n4.d<ContainingType, ?>) this.f7451d.get(new a(containingtype, i2));
    }

    private z3(boolean z) {
        this.f7451d = Collections.emptyMap();
    }
}