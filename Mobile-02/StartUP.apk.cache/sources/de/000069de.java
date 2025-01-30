package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionalConverterFactory.java */
@IgnoreJRERequirement
/* loaded from: classes3.dex */
public final class n extends h.a {
    static final h.a a = new n();

    /* compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    /* loaded from: classes3.dex */
    static final class a<T> implements h<ResponseBody, Optional<T>> {
        final h<ResponseBody, T> a;

        a(h<ResponseBody, T> hVar) {
            this.a = hVar;
        }

        @Override // retrofit2.h
        /* renamed from: a */
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.a.convert(responseBody));
        }
    }

    n() {
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, t tVar) {
        if (h.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(tVar.j(h.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}