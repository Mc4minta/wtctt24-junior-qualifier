package retrofit2.y.b;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import j.i;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.h;

/* compiled from: MoshiResponseBodyConverter.java */
/* loaded from: classes3.dex */
final class c<T> implements h<ResponseBody, T> {
    private static final i a = i.s("EFBBBF");

    /* renamed from: b  reason: collision with root package name */
    private final JsonAdapter<T> f18020b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(JsonAdapter<T> jsonAdapter) {
        this.f18020b = jsonAdapter;
    }

    @Override // retrofit2.h
    /* renamed from: a */
    public T convert(ResponseBody responseBody) throws IOException {
        j.h source = responseBody.source();
        try {
            i iVar = a;
            if (source.j0(0L, iVar)) {
                source.skip(iVar.Q());
            }
            JsonReader of = JsonReader.of(source);
            T fromJson = this.f18020b.fromJson(of);
            if (of.peek() == JsonReader.Token.END_DOCUMENT) {
                return fromJson;
            }
            throw new JsonDataException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}