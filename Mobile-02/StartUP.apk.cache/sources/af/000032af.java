package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
public final class j3<K, V> implements Comparable<j3>, Map.Entry<K, V> {
    private final Comparable a;

    /* renamed from: b  reason: collision with root package name */
    private V f6470b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c3 f6471c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public j3(c3 c3Var, K k2, V v) {
        this.f6471c = c3Var;
        this.a = k2;
        this.f6470b = v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j3(c3 c3Var, Map.Entry<K, V> entry) {
        this(c3Var, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean h(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(j3 j3Var) {
        return ((Comparable) getKey()).compareTo((Comparable) j3Var.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return h(this.a, entry.getKey()) && h(this.f6470b, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f6470b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f6470b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f6471c.p();
        V v2 = this.f6470b;
        this.f6470b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.f6470b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}