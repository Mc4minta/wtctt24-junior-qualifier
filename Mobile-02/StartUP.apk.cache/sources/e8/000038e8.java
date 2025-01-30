package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapEntry.java */
/* loaded from: classes2.dex */
public class n<K, V> extends k<K, V> {

    /* compiled from: ImmutableMapEntry.java */
    /* loaded from: classes2.dex */
    static class a<K, V> extends n<K, V> {

        /* renamed from: c  reason: collision with root package name */
        private final transient n<K, V> f8495c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(K k2, V v, n<K, V> nVar) {
            super(k2, v);
            this.f8495c = nVar;
        }

        @Override // com.google.common.collect.n
        final n<K, V> b() {
            return this.f8495c;
        }

        @Override // com.google.common.collect.n
        final boolean d() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(K k2, V v) {
        super(k2, v);
        d.a(k2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> n<K, V>[] a(int i2) {
        return new n[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<K, V> b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n<K, V> c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return true;
    }
}