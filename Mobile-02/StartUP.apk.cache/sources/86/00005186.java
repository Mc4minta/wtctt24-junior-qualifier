package kotlin.a0.w0;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.a0.h;
import kotlin.jvm.internal.m;

/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends h<E> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return k((Map.Entry) obj);
        }
        return false;
    }

    public final boolean k(E element) {
        m.g(element, "element");
        return l(element);
    }

    public abstract boolean l(Map.Entry<? extends K, ? extends V> entry);

    public abstract /* bridge */ boolean m(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return m((Map.Entry) obj);
        }
        return false;
    }
}