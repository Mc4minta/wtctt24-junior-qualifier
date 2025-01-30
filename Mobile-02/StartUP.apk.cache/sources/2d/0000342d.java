package com.google.android.gms.internal.p000firebaseperf;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.w6  reason: invalid package */
/* loaded from: classes2.dex */
public final class w6<K, V> implements Comparable<w6>, Map.Entry<K, V> {
    private final Comparable a;

    /* renamed from: b  reason: collision with root package name */
    private V f6954b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n6 f6955c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w6(n6 n6Var, Map.Entry<K, V> entry) {
        this(n6Var, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean h(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(w6 w6Var) {
        return ((Comparable) getKey()).compareTo((Comparable) w6Var.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return h(this.a, entry.getKey()) && h(this.f6954b, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f6954b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f6954b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f6955c.q();
        V v2 = this.f6954b;
        this.f6954b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.f6954b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public w6(n6 n6Var, K k2, V v) {
        this.f6955c = n6Var;
        this.a = k2;
        this.f6954b = v;
    }
}