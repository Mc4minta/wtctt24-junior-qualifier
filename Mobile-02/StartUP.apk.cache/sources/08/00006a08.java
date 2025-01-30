package retrofit2.y.b;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import j.f;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.h;

/* compiled from: MoshiRequestBodyConverter.java */
/* loaded from: classes3.dex */
final class b<T> implements h<T, RequestBody> {
    private static final MediaType a = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private final JsonAdapter<T> f18019b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(JsonAdapter<T> jsonAdapter) {
        this.f18019b = jsonAdapter;
    }

    @Override // retrofit2.h
    /* renamed from: a */
    public RequestBody convert(T t) throws IOException {
        f fVar = new f();
        this.f18019b.toJson(JsonWriter.of(fVar), (JsonWriter) t);
        return RequestBody.create(a, fVar.v0());
    }
}