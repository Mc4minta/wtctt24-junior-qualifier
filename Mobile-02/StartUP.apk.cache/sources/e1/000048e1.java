package e.g.b.a.d;

import e.g.b.a.d.k;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: GenericData.java */
/* loaded from: classes2.dex */
public class n extends AbstractMap<String, Object> implements Cloneable {
    final i classInfo;
    Map<String, Object> unknownFields;

    /* compiled from: GenericData.java */
    /* loaded from: classes2.dex */
    final class a implements Iterator<Map.Entry<String, Object>> {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f13451b;

        /* renamed from: c  reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f13452c;

        a(k.c cVar) {
            this.f13451b = cVar.iterator();
            this.f13452c = n.this.unknownFields.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<String, Object> next() {
            if (!this.a) {
                if (this.f13451b.hasNext()) {
                    return this.f13451b.next();
                }
                this.a = true;
            }
            return this.f13452c.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13451b.hasNext() || this.f13452c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.a) {
                this.f13452c.remove();
            }
            this.f13451b.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GenericData.java */
    /* loaded from: classes2.dex */
    public final class b extends AbstractSet<Map.Entry<String, Object>> {
        private final k.c a;

        b() {
            this.a = new k(n.this, n.this.classInfo.d()).entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            n.this.unknownFields.clear();
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new a(this.a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return n.this.unknownFields.size() + this.a.size();
        }
    }

    /* compiled from: GenericData.java */
    /* loaded from: classes2.dex */
    public enum c {
        IGNORE_CASE
    }

    public n() {
        this(EnumSet.noneOf(c.class));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            m b2 = this.classInfo.b(str);
            if (b2 != null) {
                return b2.g(this);
            }
            if (this.classInfo.d()) {
                str = str.toLowerCase(Locale.US);
            }
            return this.unknownFields.get(str);
        }
        return null;
    }

    public final i getClassInfo() {
        return this.classInfo;
    }

    public final Map<String, Object> getUnknownKeys() {
        return this.unknownFields;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (this.classInfo.b(str) == null) {
                if (this.classInfo.d()) {
                    str = str.toLowerCase(Locale.US);
                }
                return this.unknownFields.remove(str);
            }
            throw new UnsupportedOperationException();
        }
        return null;
    }

    public n set(String str, Object obj) {
        m b2 = this.classInfo.b(str);
        if (b2 != null) {
            b2.m(this, obj);
        } else {
            if (this.classInfo.d()) {
                str = str.toLowerCase(Locale.US);
            }
            this.unknownFields.put(str, obj);
        }
        return this;
    }

    public final void setUnknownKeys(Map<String, Object> map) {
        this.unknownFields = map;
    }

    public n(EnumSet<c> enumSet) {
        this.unknownFields = e.g.b.a.d.a.c();
        this.classInfo = i.g(getClass(), enumSet.contains(c.IGNORE_CASE));
    }

    @Override // java.util.AbstractMap
    public n clone() {
        try {
            n nVar = (n) super.clone();
            j.b(this, nVar);
            nVar.unknownFields = (Map) j.a(this.unknownFields);
            return nVar;
        } catch (CloneNotSupportedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(String str, Object obj) {
        m b2 = this.classInfo.b(str);
        if (b2 != null) {
            Object g2 = b2.g(this);
            b2.m(this, obj);
            return g2;
        }
        if (this.classInfo.d()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.unknownFields.put(str, obj);
    }
}