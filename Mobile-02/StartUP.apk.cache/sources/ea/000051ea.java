package kotlin.g0;

import kotlin.j0.m;

/* compiled from: ObservableProperty.kt */
/* loaded from: classes3.dex */
public abstract class b<V> implements c<Object, V> {
    private V value;

    public b(V v) {
        this.value = v;
    }

    protected void afterChange(m<?> property, V v, V v2) {
        kotlin.jvm.internal.m.g(property, "property");
    }

    protected boolean beforeChange(m<?> property, V v, V v2) {
        kotlin.jvm.internal.m.g(property, "property");
        return true;
    }

    @Override // kotlin.g0.c
    public V getValue(Object obj, m<?> property) {
        kotlin.jvm.internal.m.g(property, "property");
        return this.value;
    }

    @Override // kotlin.g0.c
    public void setValue(Object obj, m<?> property, V v) {
        kotlin.jvm.internal.m.g(property, "property");
        V v2 = this.value;
        if (beforeChange(property, v2, v)) {
            this.value = v;
            afterChange(property, v2, v);
        }
    }
}