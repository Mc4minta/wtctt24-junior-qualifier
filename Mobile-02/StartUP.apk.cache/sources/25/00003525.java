package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class n2<T> implements m2<T> {
    private volatile m2<T> a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f7250b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    private T f7251c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2(m2<T> m2Var) {
        this.a = (m2) j2.a(m2Var);
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final T a() {
        if (!this.f7250b) {
            synchronized (this) {
                if (!this.f7250b) {
                    T a = this.a.a();
                    this.f7251c = a;
                    this.f7250b = true;
                    this.a = null;
                    return a;
                }
            }
        }
        return this.f7251c;
    }

    public final String toString() {
        Object obj = this.a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f7251c);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}