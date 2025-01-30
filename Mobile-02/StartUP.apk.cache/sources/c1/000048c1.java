package e.g.b.a.d;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ArrayValueMap.java */
/* loaded from: classes2.dex */
public final class b {
    private final Map<String, a> a = e.g.b.a.d.a.c();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Field, a> f13405b = e.g.b.a.d.a.c();

    /* renamed from: c  reason: collision with root package name */
    private final Object f13406c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayValueMap.java */
    /* loaded from: classes2.dex */
    public static class a {
        final Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<Object> f13407b = new ArrayList<>();

        a(Class<?> cls) {
            this.a = cls;
        }

        void a(Class<?> cls, Object obj) {
            y.a(cls == this.a);
            this.f13407b.add(obj);
        }

        Object b() {
            return f0.o(this.f13407b, this.a);
        }
    }

    public b(Object obj) {
        this.f13406c = obj;
    }

    public void a(Field field, Class<?> cls, Object obj) {
        a aVar = this.f13405b.get(field);
        if (aVar == null) {
            aVar = new a(cls);
            this.f13405b.put(field, aVar);
        }
        aVar.a(cls, obj);
    }

    public void b() {
        for (Map.Entry<String, a> entry : this.a.entrySet()) {
            ((Map) this.f13406c).put(entry.getKey(), entry.getValue().b());
        }
        for (Map.Entry<Field, a> entry2 : this.f13405b.entrySet()) {
            m.l(entry2.getKey(), this.f13406c, entry2.getValue().b());
        }
    }
}