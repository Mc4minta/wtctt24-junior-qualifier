package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.h;

/* compiled from: BuiltInConverters.java */
/* loaded from: classes3.dex */
final class c extends h.a {
    private boolean a = true;

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes3.dex */
    static final class a implements h<ResponseBody, ResponseBody> {
        static final a a = new a();

        a() {
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return x.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes3.dex */
    static final class b implements h<RequestBody, RequestBody> {
        static final b a = new b();

        b() {
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0432c implements h<ResponseBody, ResponseBody> {
        static final C0432c a = new C0432c();

        C0432c() {
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes3.dex */
    static final class d implements h<Object, String> {
        static final d a = new d();

        d() {
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes3.dex */
    static final class e implements h<ResponseBody, kotlin.x> {
        static final e a = new e();

        e() {
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public kotlin.x convert(ResponseBody responseBody) {
            responseBody.close();
            return kotlin.x.a;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes3.dex */
    static final class f implements h<ResponseBody, Void> {
        static final f a = new f();

        f() {
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.h.a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, t tVar) {
        if (RequestBody.class.isAssignableFrom(x.h(type))) {
            return b.a;
        }
        return null;
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, t tVar) {
        if (type == ResponseBody.class) {
            if (x.l(annotationArr, retrofit2.z.w.class)) {
                return C0432c.a;
            }
            return a.a;
        } else if (type == Void.class) {
            return f.a;
        } else {
            if (this.a && type == kotlin.x.class) {
                try {
                    return e.a;
                } catch (NoClassDefFoundError unused) {
                    this.a = false;
                    return null;
                }
            }
            return null;
        }
    }
}