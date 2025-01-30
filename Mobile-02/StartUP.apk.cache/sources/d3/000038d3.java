package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: ComparatorOrdering.java */
/* loaded from: classes2.dex */
final class f<T> extends z<T> implements Serializable {
    final Comparator<T> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Comparator<T> comparator) {
        this.a = (Comparator) com.google.common.base.l.i(comparator);
    }

    @Override // com.google.common.collect.z, java.util.Comparator
    public int compare(T t, T t2) {
        return this.a.compare(t, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.a.equals(((f) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}