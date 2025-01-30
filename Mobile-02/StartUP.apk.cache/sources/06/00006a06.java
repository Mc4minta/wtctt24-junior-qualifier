package retrofit2.y.a;

import com.google.gson.JsonIOException;
import com.google.gson.f;
import com.google.gson.s;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.h;

/* compiled from: GsonResponseBodyConverter.java */
/* loaded from: classes3.dex */
final class c<T> implements h<ResponseBody, T> {
    private final f a;

    /* renamed from: b  reason: collision with root package name */
    private final s<T> f18015b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar, s<T> sVar) {
        this.a = fVar;
        this.f18015b = sVar;
    }

    @Override // retrofit2.h
    /* renamed from: a */
    public T convert(ResponseBody responseBody) throws IOException {
        com.google.gson.stream.a p = this.a.p(responseBody.charStream());
        try {
            T read = this.f18015b.read(p);
            if (p.k0() == com.google.gson.stream.b.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}