package e.g.b.a.d;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* compiled from: ClassInfo.java */
/* loaded from: classes2.dex */
public final class i {
    private static final Map<Class<?>, i> a = new WeakHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, i> f13419b = new WeakHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f13420c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f13421d;

    /* renamed from: e  reason: collision with root package name */
    private final IdentityHashMap<String, m> f13422e = new IdentityHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    final List<String> f13423f;

    /* compiled from: ClassInfo.java */
    /* loaded from: classes2.dex */
    class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (x.a(str, str2)) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    private i(Class<?> cls, boolean z) {
        Field[] declaredFields;
        this.f13420c = cls;
        this.f13421d = z;
        y.b((z && cls.isEnum()) ? false : true, "cannot ignore case on an enum: " + cls);
        TreeSet treeSet = new TreeSet(new a());
        for (Field field : cls.getDeclaredFields()) {
            m k2 = m.k(field);
            if (k2 != null) {
                String e2 = k2.e();
                e2 = z ? e2.toLowerCase(Locale.US).intern() : e2;
                m mVar = this.f13422e.get(e2);
                boolean z2 = mVar == null;
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : "";
                objArr[1] = e2;
                objArr[2] = field;
                objArr[3] = mVar == null ? null : mVar.b();
                y.c(z2, "two fields have the same %sname <%s>: %s and %s", objArr);
                this.f13422e.put(e2, k2);
                treeSet.add(e2);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            i g2 = g(superclass, z);
            treeSet.addAll(g2.f13423f);
            for (Map.Entry<String, m> entry : g2.f13422e.entrySet()) {
                String key = entry.getKey();
                if (!this.f13422e.containsKey(key)) {
                    this.f13422e.put(key, entry.getValue());
                }
            }
        }
        this.f13423f = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public static i f(Class<?> cls) {
        return g(cls, false);
    }

    public static i g(Class<?> cls, boolean z) {
        i iVar;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, i> map = z ? f13419b : a;
        synchronized (map) {
            iVar = map.get(cls);
            if (iVar == null) {
                iVar = new i(cls, z);
                map.put(cls, iVar);
            }
        }
        return iVar;
    }

    public Field a(String str) {
        m b2 = b(str);
        if (b2 == null) {
            return null;
        }
        return b2.b();
    }

    public m b(String str) {
        if (str != null) {
            if (this.f13421d) {
                str = str.toLowerCase(Locale.US);
            }
            str = str.intern();
        }
        return this.f13422e.get(str);
    }

    public Collection<m> c() {
        return Collections.unmodifiableCollection(this.f13422e.values());
    }

    public final boolean d() {
        return this.f13421d;
    }

    public boolean e() {
        return this.f13420c.isEnum();
    }
}