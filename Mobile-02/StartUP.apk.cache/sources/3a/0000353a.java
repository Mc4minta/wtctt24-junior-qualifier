package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class o2<T> implements m2<T>, Serializable {
    private final m2<T> a;

    /* renamed from: b  reason: collision with root package name */
    private volatile transient boolean f7277b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    private transient T f7278c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o2(m2<T> m2Var) {
        this.a = (m2) j2.a(m2Var);
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final T a() {
        if (!this.f7277b) {
            synchronized (this) {
                if (!this.f7277b) {
                    T a = this.a.a();
                    this.f7278c = a;
                    this.f7277b = true;
                    return a;
                }
            }
        }
        return this.f7278c;
    }

    public final String toString() {
        Object obj;
        if (this.f7277b) {
            String valueOf = String.valueOf(this.f7278c);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.a;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}