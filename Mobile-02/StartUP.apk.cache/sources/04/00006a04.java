package retrofit2.y.a;

import com.google.gson.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.h;
import retrofit2.t;

/* compiled from: GsonConverterFactory.java */
/* loaded from: classes3.dex */
public final class a extends h.a {
    private final f a;

    private a(f fVar) {
        this.a = fVar;
    }

    public static a a(f fVar) {
        Objects.requireNonNull(fVar, "gson == null");
        return new a(fVar);
    }

    @Override // retrofit2.h.a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, t tVar) {
        return new b(this.a, this.a.l(com.google.gson.v.a.get(type)));
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, t tVar) {
        return new c(this.a, this.a.l(com.google.gson.v.a.get(type)));
    }
}