package retrofit2.y.a;

import com.google.gson.f;
import com.google.gson.s;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.h;

/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: classes3.dex */
final class b<T> implements h<T, RequestBody> {
    private static final MediaType a = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f18012b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private final f f18013c;

    /* renamed from: d  reason: collision with root package name */
    private final s<T> f18014d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(f fVar, s<T> sVar) {
        this.f18013c = fVar;
        this.f18014d = sVar;
    }

    @Override // retrofit2.h
    /* renamed from: a */
    public RequestBody convert(T t) throws IOException {
        j.f fVar = new j.f();
        com.google.gson.stream.c q = this.f18013c.q(new OutputStreamWriter(fVar.c1(), f18012b));
        this.f18014d.write(q, t);
        q.close();
        return RequestBody.create(a, fVar.v0());
    }
}