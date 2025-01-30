package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.c;
import retrofit2.e;
import retrofit2.h;

/* compiled from: Retrofit.java */
/* loaded from: classes3.dex */
public final class t {
    private final Map<Method, u<?>> a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    final Call.Factory f17994b;

    /* renamed from: c  reason: collision with root package name */
    final HttpUrl f17995c;

    /* renamed from: d  reason: collision with root package name */
    final List<h.a> f17996d;

    /* renamed from: e  reason: collision with root package name */
    final List<e.a> f17997e;

    /* renamed from: f  reason: collision with root package name */
    final Executor f17998f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f17999g;

    /* compiled from: Retrofit.java */
    /* loaded from: classes3.dex */
    class a implements InvocationHandler {
        private final p a = p.g();

        /* renamed from: b  reason: collision with root package name */
        private final Object[] f18000b = new Object[0];

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f18001c;

        a(Class cls) {
            this.f18001c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.a.i(method)) {
                return this.a.h(method, this.f18001c, obj, objArr);
            }
            u<?> d2 = t.this.d(method);
            if (objArr == null) {
                objArr = this.f18000b;
            }
            return d2.a(objArr);
        }
    }

    t(Call.Factory factory, HttpUrl httpUrl, List<h.a> list, List<e.a> list2, Executor executor, boolean z) {
        this.f17994b = factory;
        this.f17995c = httpUrl;
        this.f17996d = list;
        this.f17997e = list2;
        this.f17998f = executor;
        this.f17999g = z;
    }

    private void l(Class<?> cls) {
        Method[] declaredMethods;
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<?> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                    sb.append(cls2.getName());
                    if (cls2 != cls) {
                        sb.append(" which is an interface of ");
                        sb.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.f17999g) {
                p g2 = p.g();
                for (Method method : cls.getDeclaredMethods()) {
                    if (!g2.i(method) && !Modifier.isStatic(method.getModifiers())) {
                        d(method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public e<?, ?> a(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public Executor b() {
        return this.f17998f;
    }

    public <T> T c(Class<T> cls) {
        l(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    u<?> d(Method method) {
        u<?> uVar;
        u<?> uVar2 = this.a.get(method);
        if (uVar2 != null) {
            return uVar2;
        }
        synchronized (this.a) {
            uVar = this.a.get(method);
            if (uVar == null) {
                uVar = u.b(this, method);
                this.a.put(method, uVar);
            }
        }
        return uVar;
    }

    public b e() {
        return new b(this);
    }

    public e<?, ?> f(e.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f17997e.indexOf(aVar) + 1;
        int size = this.f17997e.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            e<?, ?> eVar = this.f17997e.get(i2).get(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17997e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17997e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17997e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, RequestBody> g(h.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f17996d.indexOf(aVar) + 1;
        int size = this.f17996d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            h<T, RequestBody> hVar = (h<T, RequestBody>) this.f17996d.get(i2).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17996d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17996d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17996d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<ResponseBody, T> h(h.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f17996d.indexOf(aVar) + 1;
        int size = this.f17996d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            h<ResponseBody, T> hVar = (h<ResponseBody, T>) this.f17996d.get(i2).responseBodyConverter(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17996d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17996d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17996d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, RequestBody> i(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return g(null, type, annotationArr, annotationArr2);
    }

    public <T> h<ResponseBody, T> j(Type type, Annotation[] annotationArr) {
        return h(null, type, annotationArr);
    }

    public <T> h<T, String> k(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f17996d.size();
        for (int i2 = 0; i2 < size; i2++) {
            h<T, String> hVar = (h<T, String>) this.f17996d.get(i2).stringConverter(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        return c.d.a;
    }

    /* compiled from: Retrofit.java */
    /* loaded from: classes3.dex */
    public static final class b {
        private final p a;

        /* renamed from: b  reason: collision with root package name */
        private Call.Factory f18003b;

        /* renamed from: c  reason: collision with root package name */
        private HttpUrl f18004c;

        /* renamed from: d  reason: collision with root package name */
        private final List<h.a> f18005d;

        /* renamed from: e  reason: collision with root package name */
        private final List<e.a> f18006e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f18007f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f18008g;

        b(p pVar) {
            this.f18005d = new ArrayList();
            this.f18006e = new ArrayList();
            this.a = pVar;
        }

        public b a(e.a aVar) {
            List<e.a> list = this.f18006e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(h.a aVar) {
            List<h.a> list = this.f18005d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(HttpUrl.get(str));
        }

        public b d(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            List<String> pathSegments = httpUrl.pathSegments();
            if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                this.f18004c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public t e() {
            if (this.f18004c != null) {
                Call.Factory factory = this.f18003b;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor executor = this.f18007f;
                if (executor == null) {
                    executor = this.a.c();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f18006e);
                arrayList.addAll(this.a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f18005d.size() + 1 + this.a.e());
                arrayList2.add(new c());
                arrayList2.addAll(this.f18005d);
                arrayList2.addAll(this.a.d());
                return new t(factory2, this.f18004c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f18008g);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public b f(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.f18003b = factory;
            return this;
        }

        public b g(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return f(okHttpClient);
        }

        public List<h.a> h() {
            return this.f18005d;
        }

        public b() {
            this(p.g());
        }

        b(t tVar) {
            this.f18005d = new ArrayList();
            this.f18006e = new ArrayList();
            p g2 = p.g();
            this.a = g2;
            this.f18003b = tVar.f17994b;
            this.f18004c = tVar.f17995c;
            int size = tVar.f17996d.size() - g2.e();
            for (int i2 = 1; i2 < size; i2++) {
                this.f18005d.add(tVar.f17996d.get(i2));
            }
            int size2 = tVar.f17997e.size() - this.a.b();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f18006e.add(tVar.f17997e.get(i3));
            }
            this.f18007f = tVar.f17998f;
            this.f18008g = tVar.f17999g;
        }
    }
}