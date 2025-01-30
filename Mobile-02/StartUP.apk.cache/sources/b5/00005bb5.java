package org.apache.commons.lang3.c;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Pair.java */
/* loaded from: classes3.dex */
public abstract class a<L, R> implements Map.Entry<L, R>, Comparable<a<L, R>>, Serializable {
    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return org.apache.commons.lang3.a.a(getKey(), entry.getKey()) && org.apache.commons.lang3.a.a(getValue(), entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return n();
    }

    @Override // java.util.Map.Entry
    public R getValue() {
        return q();
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(a<L, R> aVar) {
        return new org.apache.commons.lang3.b.a().g(n(), aVar.n()).g(q(), aVar.q()).u();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public abstract L n();

    public abstract R q();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(n());
        sb.append(',');
        sb.append(q());
        sb.append(')');
        return sb.toString();
    }
}