package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import retrofit2.o;
import retrofit2.z.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestFactory.java */
/* loaded from: classes3.dex */
public final class r {
    private final Method a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpUrl f17971b;

    /* renamed from: c  reason: collision with root package name */
    final String f17972c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17973d;

    /* renamed from: e  reason: collision with root package name */
    private final Headers f17974e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaType f17975f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f17976g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17977h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f17978i;

    /* renamed from: j  reason: collision with root package name */
    private final o<?>[] f17979j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f17980k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFactory.java */
    /* loaded from: classes3.dex */
    public static final class a {
        private static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: b  reason: collision with root package name */
        private static final Pattern f17981b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: c  reason: collision with root package name */
        final t f17982c;

        /* renamed from: d  reason: collision with root package name */
        final Method f17983d;

        /* renamed from: e  reason: collision with root package name */
        final Annotation[] f17984e;

        /* renamed from: f  reason: collision with root package name */
        final Annotation[][] f17985f;

        /* renamed from: g  reason: collision with root package name */
        final Type[] f17986g;

        /* renamed from: h  reason: collision with root package name */
        boolean f17987h;

        /* renamed from: i  reason: collision with root package name */
        boolean f17988i;

        /* renamed from: j  reason: collision with root package name */
        boolean f17989j;

        /* renamed from: k  reason: collision with root package name */
        boolean f17990k;

        /* renamed from: l  reason: collision with root package name */
        boolean f17991l;
        boolean m;
        boolean n;
        boolean o;
        String p;
        boolean q;
        boolean r;
        boolean s;
        String t;
        Headers u;
        MediaType v;
        Set<String> w;
        o<?>[] x;
        boolean y;

        a(t tVar, Method method) {
            this.f17982c = tVar;
            this.f17983d = method;
            this.f17984e = method.getAnnotations();
            this.f17986g = method.getGenericParameterTypes();
            this.f17985f = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw x.m(this.f17983d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.v = MediaType.get(trim);
                    } catch (IllegalArgumentException e2) {
                        throw x.n(this.f17983d, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z) {
            String str3 = this.p;
            if (str3 != null) {
                throw x.m(this.f17983d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.p = str;
            this.q = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (a.matcher(substring).find()) {
                    throw x.m(this.f17983d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.t = str2;
            this.w = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof retrofit2.z.b) {
                d(HttpDelete.METHOD_NAME, ((retrofit2.z.b) annotation).value(), false);
            } else if (annotation instanceof retrofit2.z.f) {
                d(HttpGet.METHOD_NAME, ((retrofit2.z.f) annotation).value(), false);
            } else if (annotation instanceof retrofit2.z.g) {
                d(HttpHead.METHOD_NAME, ((retrofit2.z.g) annotation).value(), false);
            } else if (annotation instanceof retrofit2.z.n) {
                d(HttpPatch.METHOD_NAME, ((retrofit2.z.n) annotation).value(), true);
            } else if (annotation instanceof retrofit2.z.o) {
                d(HttpPost.METHOD_NAME, ((retrofit2.z.o) annotation).value(), true);
            } else if (annotation instanceof retrofit2.z.p) {
                d(HttpPut.METHOD_NAME, ((retrofit2.z.p) annotation).value(), true);
            } else if (annotation instanceof retrofit2.z.m) {
                d(HttpOptions.METHOD_NAME, ((retrofit2.z.m) annotation).value(), false);
            } else if (annotation instanceof retrofit2.z.h) {
                retrofit2.z.h hVar = (retrofit2.z.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation instanceof retrofit2.z.k) {
                String[] value = ((retrofit2.z.k) annotation).value();
                if (value.length != 0) {
                    this.u = c(value);
                    return;
                }
                throw x.m(this.f17983d, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.l) {
                if (!this.r) {
                    this.s = true;
                    return;
                }
                throw x.m(this.f17983d, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.e) {
                if (!this.s) {
                    this.r = true;
                    return;
                }
                throw x.m(this.f17983d, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private o<?> f(int i2, Type type, Annotation[] annotationArr, boolean z) {
            o<?> oVar;
            if (annotationArr != null) {
                oVar = null;
                for (Annotation annotation : annotationArr) {
                    o<?> g2 = g(i2, type, annotationArr, annotation);
                    if (g2 != null) {
                        if (oVar != null) {
                            throw x.o(this.f17983d, i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        oVar = g2;
                    }
                }
            } else {
                oVar = null;
            }
            if (oVar == null) {
                if (z) {
                    try {
                        if (x.h(type) == kotlin.c0.d.class) {
                            this.y = true;
                            return null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw x.o(this.f17983d, i2, "No Retrofit annotation found.", new Object[0]);
            }
            return oVar;
        }

        private o<?> g(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                j(i2, type);
                if (!this.o) {
                    if (!this.f17990k) {
                        if (!this.f17991l) {
                            if (!this.m) {
                                if (!this.n) {
                                    if (this.t == null) {
                                        this.o = true;
                                        if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                            throw x.o(this.f17983d, i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                        }
                                        return new o.p(this.f17983d, i2);
                                    }
                                    throw x.o(this.f17983d, i2, "@Url cannot be used with @%s URL", this.p);
                                }
                                throw x.o(this.f17983d, i2, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            throw x.o(this.f17983d, i2, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        throw x.o(this.f17983d, i2, "A @Url parameter must not come after a @Query.", new Object[0]);
                    }
                    throw x.o(this.f17983d, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "Multiple @Url method annotations found.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.s) {
                j(i2, type);
                if (!this.f17991l) {
                    if (!this.m) {
                        if (!this.n) {
                            if (!this.o) {
                                if (this.t != null) {
                                    this.f17990k = true;
                                    retrofit2.z.s sVar = (retrofit2.z.s) annotation;
                                    String value = sVar.value();
                                    i(i2, value);
                                    return new o.k(this.f17983d, i2, value, this.f17982c.k(type, annotationArr), sVar.encoded());
                                }
                                throw x.o(this.f17983d, i2, "@Path can only be used with relative url on @%s", this.p);
                            }
                            throw x.o(this.f17983d, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        throw x.o(this.f17983d, i2, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                    }
                    throw x.o(this.f17983d, i2, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.t) {
                j(i2, type);
                retrofit2.z.t tVar = (retrofit2.z.t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> h2 = x.h(type);
                this.f17991l = true;
                if (Iterable.class.isAssignableFrom(h2)) {
                    if (type instanceof ParameterizedType) {
                        return new o.l(value2, this.f17982c.k(x.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                    }
                    throw x.o(this.f17983d, i2, h2.getSimpleName() + " must include generic type (e.g., " + h2.getSimpleName() + "<String>)", new Object[0]);
                } else if (h2.isArray()) {
                    return new o.l(value2, this.f17982c.k(a(h2.getComponentType()), annotationArr), encoded).b();
                } else {
                    return new o.l(value2, this.f17982c.k(type, annotationArr), encoded);
                }
            } else if (annotation instanceof retrofit2.z.v) {
                j(i2, type);
                boolean encoded2 = ((retrofit2.z.v) annotation).encoded();
                Class<?> h3 = x.h(type);
                this.m = true;
                if (Iterable.class.isAssignableFrom(h3)) {
                    if (type instanceof ParameterizedType) {
                        return new o.n(this.f17982c.k(x.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                    }
                    throw x.o(this.f17983d, i2, h3.getSimpleName() + " must include generic type (e.g., " + h3.getSimpleName() + "<String>)", new Object[0]);
                } else if (h3.isArray()) {
                    return new o.n(this.f17982c.k(a(h3.getComponentType()), annotationArr), encoded2).b();
                } else {
                    return new o.n(this.f17982c.k(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof retrofit2.z.u) {
                j(i2, type);
                Class<?> h4 = x.h(type);
                this.n = true;
                if (Map.class.isAssignableFrom(h4)) {
                    Type i3 = x.i(type, h4, Map.class);
                    if (i3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) i3;
                        Type g2 = x.g(0, parameterizedType);
                        if (String.class == g2) {
                            return new o.m(this.f17983d, i2, this.f17982c.k(x.g(1, parameterizedType), annotationArr), ((retrofit2.z.u) annotation).encoded());
                        }
                        throw x.o(this.f17983d, i2, "@QueryMap keys must be of type String: " + g2, new Object[0]);
                    }
                    throw x.o(this.f17983d, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.i) {
                j(i2, type);
                String value3 = ((retrofit2.z.i) annotation).value();
                Class<?> h5 = x.h(type);
                if (Iterable.class.isAssignableFrom(h5)) {
                    if (type instanceof ParameterizedType) {
                        return new o.f(value3, this.f17982c.k(x.g(0, (ParameterizedType) type), annotationArr)).c();
                    }
                    throw x.o(this.f17983d, i2, h5.getSimpleName() + " must include generic type (e.g., " + h5.getSimpleName() + "<String>)", new Object[0]);
                } else if (h5.isArray()) {
                    return new o.f(value3, this.f17982c.k(a(h5.getComponentType()), annotationArr)).b();
                } else {
                    return new o.f(value3, this.f17982c.k(type, annotationArr));
                }
            } else if (annotation instanceof retrofit2.z.j) {
                if (type == Headers.class) {
                    return new o.h(this.f17983d, i2);
                }
                j(i2, type);
                Class<?> h6 = x.h(type);
                if (Map.class.isAssignableFrom(h6)) {
                    Type i4 = x.i(type, h6, Map.class);
                    if (i4 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) i4;
                        Type g3 = x.g(0, parameterizedType2);
                        if (String.class == g3) {
                            return new o.g(this.f17983d, i2, this.f17982c.k(x.g(1, parameterizedType2), annotationArr));
                        }
                        throw x.o(this.f17983d, i2, "@HeaderMap keys must be of type String: " + g3, new Object[0]);
                    }
                    throw x.o(this.f17983d, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.c) {
                j(i2, type);
                if (this.r) {
                    retrofit2.z.c cVar = (retrofit2.z.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.f17987h = true;
                    Class<?> h7 = x.h(type);
                    if (Iterable.class.isAssignableFrom(h7)) {
                        if (type instanceof ParameterizedType) {
                            return new o.d(value4, this.f17982c.k(x.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                        }
                        throw x.o(this.f17983d, i2, h7.getSimpleName() + " must include generic type (e.g., " + h7.getSimpleName() + "<String>)", new Object[0]);
                    } else if (h7.isArray()) {
                        return new o.d(value4, this.f17982c.k(a(h7.getComponentType()), annotationArr), encoded3).b();
                    } else {
                        return new o.d(value4, this.f17982c.k(type, annotationArr), encoded3);
                    }
                }
                throw x.o(this.f17983d, i2, "@Field parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.d) {
                j(i2, type);
                if (this.r) {
                    Class<?> h8 = x.h(type);
                    if (Map.class.isAssignableFrom(h8)) {
                        Type i5 = x.i(type, h8, Map.class);
                        if (i5 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) i5;
                            Type g4 = x.g(0, parameterizedType3);
                            if (String.class == g4) {
                                h k2 = this.f17982c.k(x.g(1, parameterizedType3), annotationArr);
                                this.f17987h = true;
                                return new o.e(this.f17983d, i2, k2, ((retrofit2.z.d) annotation).encoded());
                            }
                            throw x.o(this.f17983d, i2, "@FieldMap keys must be of type String: " + g4, new Object[0]);
                        }
                        throw x.o(this.f17983d, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw x.o(this.f17983d, i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.q) {
                j(i2, type);
                if (this.s) {
                    retrofit2.z.q qVar = (retrofit2.z.q) annotation;
                    this.f17988i = true;
                    String value5 = qVar.value();
                    Class<?> h9 = x.h(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(h9)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(x.h(x.g(0, (ParameterizedType) type)))) {
                                    return o.C0434o.a.c();
                                }
                                throw x.o(this.f17983d, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw x.o(this.f17983d, i2, h9.getSimpleName() + " must include generic type (e.g., " + h9.getSimpleName() + "<String>)", new Object[0]);
                        } else if (h9.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(h9.getComponentType())) {
                                return o.C0434o.a.b();
                            }
                            throw x.o(this.f17983d, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else if (MultipartBody.Part.class.isAssignableFrom(h9)) {
                            return o.C0434o.a;
                        } else {
                            throw x.o(this.f17983d, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    }
                    Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                    if (Iterable.class.isAssignableFrom(h9)) {
                        if (type instanceof ParameterizedType) {
                            Type g5 = x.g(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(x.h(g5))) {
                                return new o.i(this.f17983d, i2, of, this.f17982c.i(g5, annotationArr, this.f17984e)).c();
                            }
                            throw x.o(this.f17983d, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw x.o(this.f17983d, i2, h9.getSimpleName() + " must include generic type (e.g., " + h9.getSimpleName() + "<String>)", new Object[0]);
                    } else if (h9.isArray()) {
                        Class<?> a2 = a(h9.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(a2)) {
                            return new o.i(this.f17983d, i2, of, this.f17982c.i(a2, annotationArr, this.f17984e)).b();
                        }
                        throw x.o(this.f17983d, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    } else if (!MultipartBody.Part.class.isAssignableFrom(h9)) {
                        return new o.i(this.f17983d, i2, of, this.f17982c.i(type, annotationArr, this.f17984e));
                    } else {
                        throw x.o(this.f17983d, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                }
                throw x.o(this.f17983d, i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.r) {
                j(i2, type);
                if (this.s) {
                    this.f17988i = true;
                    Class<?> h10 = x.h(type);
                    if (Map.class.isAssignableFrom(h10)) {
                        Type i6 = x.i(type, h10, Map.class);
                        if (i6 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) i6;
                            Type g6 = x.g(0, parameterizedType4);
                            if (String.class == g6) {
                                Type g7 = x.g(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(x.h(g7))) {
                                    return new o.j(this.f17983d, i2, this.f17982c.i(g7, annotationArr, this.f17984e), ((retrofit2.z.r) annotation).encoding());
                                }
                                throw x.o(this.f17983d, i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw x.o(this.f17983d, i2, "@PartMap keys must be of type String: " + g6, new Object[0]);
                        }
                        throw x.o(this.f17983d, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw x.o(this.f17983d, i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.a) {
                j(i2, type);
                if (!this.r && !this.s) {
                    if (!this.f17989j) {
                        try {
                            h i7 = this.f17982c.i(type, annotationArr, this.f17984e);
                            this.f17989j = true;
                            return new o.c(this.f17983d, i2, i7);
                        } catch (RuntimeException e2) {
                            throw x.p(this.f17983d, e2, i2, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw x.o(this.f17983d, i2, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw x.o(this.f17983d, i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            } else if (annotation instanceof retrofit2.z.x) {
                j(i2, type);
                Class<?> h11 = x.h(type);
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    o<?> oVar = this.x[i8];
                    if ((oVar instanceof o.q) && ((o.q) oVar).a.equals(h11)) {
                        throw x.o(this.f17983d, i2, "@Tag type " + h11.getName() + " is duplicate of parameter #" + (i8 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new o.q(h11);
            } else {
                return null;
            }
        }

        static Set<String> h(String str) {
            Matcher matcher = a.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i2, String str) {
            if (f17981b.matcher(str).matches()) {
                if (!this.w.contains(str)) {
                    throw x.o(this.f17983d, i2, "URL \"%s\" does not contain \"{%s}\".", this.t, str);
                }
                return;
            }
            throw x.o(this.f17983d, i2, "@Path parameter name must match %s. Found: %s", a.pattern(), str);
        }

        private void j(int i2, Type type) {
            if (x.j(type)) {
                throw x.o(this.f17983d, i2, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        r b() {
            for (Annotation annotation : this.f17984e) {
                e(annotation);
            }
            if (this.p != null) {
                if (!this.q) {
                    if (!this.s) {
                        if (this.r) {
                            throw x.m(this.f17983d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    } else {
                        throw x.m(this.f17983d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f17985f.length;
                this.x = new o[length];
                int i2 = length - 1;
                int i3 = 0;
                while (true) {
                    boolean z = true;
                    if (i3 >= length) {
                        break;
                    }
                    o<?>[] oVarArr = this.x;
                    Type type = this.f17986g[i3];
                    Annotation[] annotationArr = this.f17985f[i3];
                    if (i3 != i2) {
                        z = false;
                    }
                    oVarArr[i3] = f(i3, type, annotationArr, z);
                    i3++;
                }
                if (this.t != null || this.o) {
                    boolean z2 = this.r;
                    if (!z2 && !this.s && !this.q && this.f17989j) {
                        throw x.m(this.f17983d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                    }
                    if (z2 && !this.f17987h) {
                        throw x.m(this.f17983d, "Form-encoded method must contain at least one @Field.", new Object[0]);
                    }
                    if (this.s && !this.f17988i) {
                        throw x.m(this.f17983d, "Multipart method must contain at least one @Part.", new Object[0]);
                    }
                    return new r(this);
                }
                throw x.m(this.f17983d, "Missing either @%s URL or @Url parameter.", this.p);
            }
            throw x.m(this.f17983d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    r(a aVar) {
        this.a = aVar.f17983d;
        this.f17971b = aVar.f17982c.f17995c;
        this.f17972c = aVar.p;
        this.f17973d = aVar.t;
        this.f17974e = aVar.u;
        this.f17975f = aVar.v;
        this.f17976g = aVar.q;
        this.f17977h = aVar.r;
        this.f17978i = aVar.s;
        this.f17979j = aVar.x;
        this.f17980k = aVar.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r b(t tVar, Method method) {
        return new a(tVar, method).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request a(Object[] objArr) throws IOException {
        o<?>[] oVarArr = this.f17979j;
        int length = objArr.length;
        if (length == oVarArr.length) {
            q qVar = new q(this.f17972c, this.f17971b, this.f17973d, this.f17974e, this.f17975f, this.f17976g, this.f17977h, this.f17978i);
            if (this.f17980k) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(objArr[i2]);
                oVarArr[i2].a(qVar, objArr[i2]);
            }
            return qVar.k().tag(k.class, new k(this.a, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + oVarArr.length + ")");
    }
}