package okhttp3.internal.huc;

import j.f;
import j.g;
import j.q;
import j.w;
import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;

/* loaded from: classes3.dex */
final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final w pipe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamedRequestBody(long j2) {
        w wVar = new w(8192L);
        this.pipe = wVar;
        initOutputStream(q.c(wVar.i()), j2);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(g gVar) throws IOException {
        f fVar = new f();
        while (this.pipe.j().read(fVar, 8192L) != -1) {
            gVar.write(fVar, fVar.O0());
        }
    }
}