package e.f.j.l;

import e.f.j.l.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes2.dex */
public interface f0<FETCH_STATE extends s> {

    /* compiled from: NetworkFetcher.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b(InputStream inputStream, int i2) throws IOException;

        void onFailure(Throwable th);
    }

    void a(FETCH_STATE fetch_state, int i2);

    boolean b(FETCH_STATE fetch_state);

    Map<String, String> c(FETCH_STATE fetch_state, int i2);

    void d(FETCH_STATE fetch_state, a aVar);

    FETCH_STATE e(k<e.f.j.i.d> kVar, k0 k0Var);
}