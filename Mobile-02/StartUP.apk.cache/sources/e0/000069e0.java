package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParameterHandler.java */
/* loaded from: classes3.dex */
public abstract class o<T> {

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    class a extends o<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            for (T t : iterable) {
                o.this.a(qVar, t);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    class b extends o<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.o
        void a(retrofit2.q qVar, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                o.this.a(qVar, Array.get(obj, i2));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends o<T> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17929b;

        /* renamed from: c  reason: collision with root package name */
        private final retrofit2.h<T, RequestBody> f17930c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Method method, int i2, retrofit2.h<T, RequestBody> hVar) {
            this.a = method;
            this.f17929b = i2;
            this.f17930c = hVar;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) {
            if (t != null) {
                try {
                    qVar.l(this.f17930c.convert(t));
                    return;
                } catch (IOException e2) {
                    Method method = this.a;
                    int i2 = this.f17929b;
                    throw x.p(method, e2, i2, "Unable to convert " + t + " to RequestBody", new Object[0]);
                }
            }
            throw x.o(this.a, this.f17929b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class d<T> extends o<T> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final retrofit2.h<T, String> f17931b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17932c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(String str, retrofit2.h<T, String> hVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f17931b = hVar;
            this.f17932c = z;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.f17931b.convert(t)) == null) {
                return;
            }
            qVar.a(this.a, convert, this.f17932c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class e<T> extends o<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17933b;

        /* renamed from: c  reason: collision with root package name */
        private final retrofit2.h<T, String> f17934c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17935d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Method method, int i2, retrofit2.h<T, String> hVar, boolean z) {
            this.a = method;
            this.f17933b = i2;
            this.f17934c = hVar;
            this.f17935d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f17934c.convert(value);
                            if (convert != null) {
                                qVar.a(key, convert, this.f17935d);
                            } else {
                                Method method = this.a;
                                int i2 = this.f17933b;
                                throw x.o(method, i2, "Field map value '" + value + "' converted to null by " + this.f17934c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.a;
                            int i3 = this.f17933b;
                            throw x.o(method2, i3, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw x.o(this.a, this.f17933b, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw x.o(this.a, this.f17933b, "Field map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class f<T> extends o<T> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final retrofit2.h<T, String> f17936b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(String str, retrofit2.h<T, String> hVar) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f17936b = hVar;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.f17936b.convert(t)) == null) {
                return;
            }
            qVar.b(this.a, convert);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class g<T> extends o<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17937b;

        /* renamed from: c  reason: collision with root package name */
        private final retrofit2.h<T, String> f17938c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Method method, int i2, retrofit2.h<T, String> hVar) {
            this.a = method;
            this.f17937b = i2;
            this.f17938c = hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            qVar.b(key, this.f17938c.convert(value));
                        } else {
                            Method method = this.a;
                            int i2 = this.f17937b;
                            throw x.o(method, i2, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw x.o(this.a, this.f17937b, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw x.o(this.a, this.f17937b, "Header map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class h extends o<Headers> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17939b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Method method, int i2) {
            this.a = method;
            this.f17939b = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, Headers headers) {
            if (headers != null) {
                qVar.c(headers);
                return;
            }
            throw x.o(this.a, this.f17939b, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class i<T> extends o<T> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17940b;

        /* renamed from: c  reason: collision with root package name */
        private final Headers f17941c;

        /* renamed from: d  reason: collision with root package name */
        private final retrofit2.h<T, RequestBody> f17942d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Method method, int i2, Headers headers, retrofit2.h<T, RequestBody> hVar) {
            this.a = method;
            this.f17940b = i2;
            this.f17941c = headers;
            this.f17942d = hVar;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) {
            if (t == null) {
                return;
            }
            try {
                qVar.d(this.f17941c, this.f17942d.convert(t));
            } catch (IOException e2) {
                Method method = this.a;
                int i2 = this.f17940b;
                throw x.o(method, i2, "Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class j<T> extends o<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17943b;

        /* renamed from: c  reason: collision with root package name */
        private final retrofit2.h<T, RequestBody> f17944c;

        /* renamed from: d  reason: collision with root package name */
        private final String f17945d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Method method, int i2, retrofit2.h<T, RequestBody> hVar, String str) {
            this.a = method;
            this.f17943b = i2;
            this.f17944c = hVar;
            this.f17945d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            qVar.d(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f17945d), this.f17944c.convert(value));
                        } else {
                            Method method = this.a;
                            int i2 = this.f17943b;
                            throw x.o(method, i2, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw x.o(this.a, this.f17943b, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw x.o(this.a, this.f17943b, "Part map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class k<T> extends o<T> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17946b;

        /* renamed from: c  reason: collision with root package name */
        private final String f17947c;

        /* renamed from: d  reason: collision with root package name */
        private final retrofit2.h<T, String> f17948d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f17949e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(Method method, int i2, String str, retrofit2.h<T, String> hVar, boolean z) {
            this.a = method;
            this.f17946b = i2;
            Objects.requireNonNull(str, "name == null");
            this.f17947c = str;
            this.f17948d = hVar;
            this.f17949e = z;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) throws IOException {
            if (t != null) {
                qVar.f(this.f17947c, this.f17948d.convert(t), this.f17949e);
                return;
            }
            Method method = this.a;
            int i2 = this.f17946b;
            throw x.o(method, i2, "Path parameter \"" + this.f17947c + "\" value must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class l<T> extends o<T> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final retrofit2.h<T, String> f17950b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17951c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public l(String str, retrofit2.h<T, String> hVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f17950b = hVar;
            this.f17951c = z;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.f17950b.convert(t)) == null) {
                return;
            }
            qVar.g(this.a, convert, this.f17951c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class m<T> extends o<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17952b;

        /* renamed from: c  reason: collision with root package name */
        private final retrofit2.h<T, String> f17953c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17954d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(Method method, int i2, retrofit2.h<T, String> hVar, boolean z) {
            this.a = method;
            this.f17952b = i2;
            this.f17953c = hVar;
            this.f17954d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f17953c.convert(value);
                            if (convert != null) {
                                qVar.g(key, convert, this.f17954d);
                            } else {
                                Method method = this.a;
                                int i2 = this.f17952b;
                                throw x.o(method, i2, "Query map value '" + value + "' converted to null by " + this.f17953c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.a;
                            int i3 = this.f17952b;
                            throw x.o(method2, i3, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw x.o(this.a, this.f17952b, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw x.o(this.a, this.f17952b, "Query map was null", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class n<T> extends o<T> {
        private final retrofit2.h<T, String> a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17955b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public n(retrofit2.h<T, String> hVar, boolean z) {
            this.a = hVar;
            this.f17955b = z;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            qVar.g(this.a.convert(t), null, this.f17955b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.o$o  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0434o extends o<MultipartBody.Part> {
        static final C0434o a = new C0434o();

        private C0434o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.o
        /* renamed from: d */
        public void a(retrofit2.q qVar, MultipartBody.Part part) {
            if (part != null) {
                qVar.e(part);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class p extends o<Object> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17956b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public p(Method method, int i2) {
            this.a = method;
            this.f17956b = i2;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, Object obj) {
            if (obj != null) {
                qVar.m(obj);
                return;
            }
            throw x.o(this.a, this.f17956b, "@Url parameter is null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class q<T> extends o<T> {
        final Class<T> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public q(Class<T> cls) {
            this.a = cls;
        }

        @Override // retrofit2.o
        void a(retrofit2.q qVar, T t) {
            qVar.h(this.a, t);
        }
    }

    o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(retrofit2.q qVar, T t) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o<Object> b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o<Iterable<T>> c() {
        return new a();
    }
}