package e.g.b.a.d;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataMap.java */
/* loaded from: classes2.dex */
public final class k extends AbstractMap<String, Object> {
    final Object a;

    /* renamed from: b  reason: collision with root package name */
    final i f13435b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataMap.java */
    /* loaded from: classes2.dex */
    public final class a implements Map.Entry<String, Object> {
        private Object a;

        /* renamed from: b  reason: collision with root package name */
        private final m f13436b;

        a(m mVar, Object obj) {
            this.f13436b = mVar;
            this.a = y.d(obj);
        }

        @Override // java.util.Map.Entry
        /* renamed from: a */
        public String getKey() {
            String e2 = this.f13436b.e();
            return k.this.f13435b.d() ? e2.toLowerCase(Locale.US) : e2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.a;
            this.a = y.d(obj);
            this.f13436b.m(k.this.a, obj);
            return obj2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataMap.java */
    /* loaded from: classes2.dex */
    public final class b implements Iterator<Map.Entry<String, Object>> {
        private int a = -1;

        /* renamed from: b  reason: collision with root package name */
        private m f13438b;

        /* renamed from: c  reason: collision with root package name */
        private Object f13439c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13440d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f13441e;

        /* renamed from: f  reason: collision with root package name */
        private m f13442f;

        b() {
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<String, Object> next() {
            if (hasNext()) {
                m mVar = this.f13438b;
                this.f13442f = mVar;
                Object obj = this.f13439c;
                this.f13441e = false;
                this.f13440d = false;
                this.f13438b = null;
                this.f13439c = null;
                return new a(mVar, obj);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f13441e) {
                this.f13441e = true;
                this.f13439c = null;
                while (this.f13439c == null) {
                    int i2 = this.a + 1;
                    this.a = i2;
                    if (i2 >= k.this.f13435b.f13423f.size()) {
                        break;
                    }
                    i iVar = k.this.f13435b;
                    m b2 = iVar.b(iVar.f13423f.get(this.a));
                    this.f13438b = b2;
                    this.f13439c = b2.g(k.this.a);
                }
            }
            return this.f13439c != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            y.g((this.f13442f == null || this.f13440d) ? false : true);
            this.f13440d = true;
            this.f13442f.m(k.this.a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataMap.java */
    /* loaded from: classes2.dex */
    public final class c extends AbstractSet<Map.Entry<String, Object>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            for (String str : k.this.f13435b.f13423f) {
                k.this.f13435b.b(str).m(k.this.a, null);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: h */
        public b iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            for (String str : k.this.f13435b.f13423f) {
                if (k.this.f13435b.b(str).g(k.this.a) != null) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i2 = 0;
            for (String str : k.this.f13435b.f13423f) {
                if (k.this.f13435b.b(str).g(k.this.a) != null) {
                    i2++;
                }
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Object obj, boolean z) {
        this.a = obj;
        i g2 = i.g(obj.getClass(), z);
        this.f13435b = g2;
        y.a(!g2.e());
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public c entrySet() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: b */
    public Object put(String str, Object obj) {
        m b2 = this.f13435b.b(str);
        y.e(b2, "no field of key " + str);
        Object g2 = b2.g(this.a);
        b2.m(this.a, y.d(obj));
        return g2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        m b2;
        if ((obj instanceof String) && (b2 = this.f13435b.b((String) obj)) != null) {
            return b2.g(this.a);
        }
        return null;
    }
}