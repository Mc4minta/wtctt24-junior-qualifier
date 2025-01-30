package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: LazyField.java */
/* loaded from: classes2.dex */
public class l extends m {

    /* renamed from: f  reason: collision with root package name */
    private final n f9732f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyField.java */
    /* loaded from: classes2.dex */
    public static class b<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, l> a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            l value = this.a.getValue();
            if (value == null) {
                return null;
            }
            return value.d();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof n) {
                return this.a.getValue().c((n) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, l> entry) {
            this.a = entry;
        }
    }

    /* compiled from: LazyField.java */
    /* loaded from: classes2.dex */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.a.next();
            return next.getValue() instanceof l ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    public n d() {
        return b(this.f9732f);
    }

    public boolean equals(Object obj) {
        return d().equals(obj);
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d().toString();
    }
}