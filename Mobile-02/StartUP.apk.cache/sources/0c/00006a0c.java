package retrofit2.y.c;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.g;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.h;

/* compiled from: WireResponseBodyConverter.java */
/* loaded from: classes3.dex */
final class c<T extends g<T, ?>> implements h<ResponseBody, T> {
    private final ProtoAdapter<T> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ProtoAdapter<T> protoAdapter) {
        this.a = protoAdapter;
    }

    @Override // retrofit2.h
    /* renamed from: a */
    public T convert(ResponseBody responseBody) throws IOException {
        try {
            return this.a.decode(responseBody.source());
        } finally {
            responseBody.close();
        }
    }
}