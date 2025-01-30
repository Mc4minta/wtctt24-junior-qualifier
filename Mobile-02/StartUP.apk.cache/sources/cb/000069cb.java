package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.client.methods.HttpHead;
import retrofit2.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpServiceMethod.java */
/* loaded from: classes3.dex */
public abstract class j<ResponseT, ReturnT> extends u<ReturnT> {
    private final r a;

    /* renamed from: b  reason: collision with root package name */
    private final Call.Factory f17907b;

    /* renamed from: c  reason: collision with root package name */
    private final h<ResponseBody, ResponseT> f17908c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpServiceMethod.java */
    /* loaded from: classes3.dex */
    public static final class a<ResponseT, ReturnT> extends j<ResponseT, ReturnT> {

        /* renamed from: d  reason: collision with root package name */
        private final e<ResponseT, ReturnT> f17909d;

        a(r rVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, ReturnT> eVar) {
            super(rVar, factory, hVar);
            this.f17909d = eVar;
        }

        @Override // retrofit2.j
        protected ReturnT c(d<ResponseT> dVar, Object[] objArr) {
            return this.f17909d.adapt(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpServiceMethod.java */
    /* loaded from: classes3.dex */
    public static final class b<ResponseT> extends j<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final e<ResponseT, d<ResponseT>> f17910d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f17911e;

        b(r rVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar, boolean z) {
            super(rVar, factory, hVar);
            this.f17910d = eVar;
            this.f17911e = z;
        }

        @Override // retrofit2.j
        protected Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> adapt = this.f17910d.adapt(dVar);
            kotlin.c0.d dVar2 = (kotlin.c0.d) objArr[objArr.length - 1];
            try {
                if (this.f17911e) {
                    return l.b(adapt, dVar2);
                }
                return l.a(adapt, dVar2);
            } catch (Exception e2) {
                return l.d(e2, dVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpServiceMethod.java */
    /* loaded from: classes3.dex */
    public static final class c<ResponseT> extends j<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final e<ResponseT, d<ResponseT>> f17912d;

        c(r rVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar) {
            super(rVar, factory, hVar);
            this.f17912d = eVar;
        }

        @Override // retrofit2.j
        protected Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> adapt = this.f17912d.adapt(dVar);
            kotlin.c0.d dVar2 = (kotlin.c0.d) objArr[objArr.length - 1];
            try {
                return l.c(adapt, dVar2);
            } catch (Exception e2) {
                return l.d(e2, dVar2);
            }
        }
    }

    j(r rVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar) {
        this.a = rVar;
        this.f17907b = factory;
        this.f17908c = hVar;
    }

    private static <ResponseT, ReturnT> e<ResponseT, ReturnT> d(t tVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (e<ResponseT, ReturnT>) tVar.a(type, annotationArr);
        } catch (RuntimeException e2) {
            throw x.n(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> h<ResponseBody, ResponseT> e(t tVar, Method method, Type type) {
        try {
            return tVar.j(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw x.n(method, e2, "Unable to create converter for %s", type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> j<ResponseT, ReturnT> f(t tVar, Method method, r rVar) {
        Type genericReturnType;
        boolean z;
        boolean z2 = rVar.f17980k;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f2 = x.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (x.h(f2) == s.class && (f2 instanceof ParameterizedType)) {
                f2 = x.g(0, (ParameterizedType) f2);
                z = true;
            } else {
                z = false;
            }
            genericReturnType = new x.b(null, d.class, f2);
            annotations = w.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        e d2 = d(tVar, method, genericReturnType, annotations);
        Type responseType = d2.responseType();
        if (responseType != Response.class) {
            if (responseType != s.class) {
                if (rVar.f17972c.equals(HttpHead.METHOD_NAME) && !Void.class.equals(responseType)) {
                    throw x.m(method, "HEAD method must use Void as response type.", new Object[0]);
                }
                h e2 = e(tVar, method, responseType);
                Call.Factory factory = tVar.f17994b;
                if (z2) {
                    if (z) {
                        return new c(rVar, factory, e2, d2);
                    }
                    return new b(rVar, factory, e2, d2, false);
                }
                return new a(rVar, factory, e2, d2);
            }
            throw x.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        throw x.m(method, "'" + x.h(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.u
    public final ReturnT a(Object[] objArr) {
        return c(new m(this.a, objArr, this.f17907b, this.f17908c), objArr);
    }

    protected abstract ReturnT c(d<ResponseT> dVar, Object[] objArr);
}