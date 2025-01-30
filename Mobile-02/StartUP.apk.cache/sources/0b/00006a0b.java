package retrofit2.y.c;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import j.f;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.h;

/* compiled from: WireRequestBodyConverter.java */
/* loaded from: classes3.dex */
final class b<T extends g<T, ?>> implements h<T, RequestBody> {
    private static final MediaType a = MediaType.get("application/x-protobuf");

    /* renamed from: b  reason: collision with root package name */
    private final ProtoAdapter<T> f18021b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ProtoAdapter<T> protoAdapter) {
        this.f18021b = protoAdapter;
    }

    @Override // retrofit2.h
    /* renamed from: a */
    public RequestBody convert(T t) throws IOException {
        f fVar = new f();
        this.f18021b.encode((j.g) fVar, (f) t);
        return RequestBody.create(a, fVar.Q0());
    }
}