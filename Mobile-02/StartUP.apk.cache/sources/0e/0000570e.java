package kotlin.reflect.jvm.internal.impl.platform;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n0.a;

/* compiled from: TargetPlatform.kt */
/* loaded from: classes3.dex */
public class TargetPlatform implements Collection<SimplePlatform>, a {
    private final Set<SimplePlatform> componentPlatforms;

    @Override // java.util.Collection
    public boolean add(SimplePlatform element) {
        m.g(element, "element");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends SimplePlatform> elements) {
        m.g(elements, "elements");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof SimplePlatform) {
            return contains((SimplePlatform) obj);
        }
        return false;
    }

    public boolean contains(SimplePlatform element) {
        m.g(element, "element");
        return this.componentPlatforms.contains(element);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        return this.componentPlatforms.containsAll(elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TargetPlatform) && m.c(this.componentPlatforms, ((TargetPlatform) obj).componentPlatforms);
    }

    public final Set<SimplePlatform> getComponentPlatforms() {
        return this.componentPlatforms;
    }

    public int getSize() {
        return this.componentPlatforms.size();
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.componentPlatforms.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.componentPlatforms.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<SimplePlatform> iterator() {
        return this.componentPlatforms.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return f.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        m.g(array, "array");
        return (T[]) f.b(this, array);
    }

    public String toString() {
        return PlatformUtilKt.getPresentableDescription(this);
    }
}