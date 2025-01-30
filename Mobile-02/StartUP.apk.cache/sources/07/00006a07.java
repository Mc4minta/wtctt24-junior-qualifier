package retrofit2.y.b;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.h;
import retrofit2.t;

/* compiled from: MoshiConverterFactory.java */
/* loaded from: classes3.dex */
public final class a extends h.a {
    private final Moshi a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18016b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18017c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18018d;

    private a(Moshi moshi, boolean z, boolean z2, boolean z3) {
        this.a = moshi;
        this.f18016b = z;
        this.f18017c = z2;
        this.f18018d = z3;
    }

    public static a a(Moshi moshi) {
        Objects.requireNonNull(moshi, "moshi == null");
        return new a(moshi, false, false, false);
    }

    private static Set<? extends Annotation> b(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : Collections.emptySet();
    }

    @Override // retrofit2.h.a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, t tVar) {
        JsonAdapter adapter = this.a.adapter(type, b(annotationArr));
        if (this.f18016b) {
            adapter = adapter.lenient();
        }
        if (this.f18017c) {
            adapter = adapter.failOnUnknown();
        }
        if (this.f18018d) {
            adapter = adapter.serializeNulls();
        }
        return new b(adapter);
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, t tVar) {
        JsonAdapter adapter = this.a.adapter(type, b(annotationArr));
        if (this.f18016b) {
            adapter = adapter.lenient();
        }
        if (this.f18017c) {
            adapter = adapter.failOnUnknown();
        }
        if (this.f18018d) {
            adapter = adapter.serializeNulls();
        }
        return new c(adapter);
    }
}