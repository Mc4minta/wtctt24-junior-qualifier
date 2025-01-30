package retrofit2.y.c;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.h;
import retrofit2.t;

/* compiled from: WireConverterFactory.java */
/* loaded from: classes3.dex */
public final class a extends h.a {
    private a() {
    }

    public static a a() {
        return new a();
    }

    @Override // retrofit2.h.a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, t tVar) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (g.class.isAssignableFrom(cls)) {
                return new b(ProtoAdapter.get(cls));
            }
            return null;
        }
        return null;
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, t tVar) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (g.class.isAssignableFrom(cls)) {
                return new c(ProtoAdapter.get(cls));
            }
            return null;
        }
        return null;
    }
}