package okhttp3.internal.huc;

import j.f;
import j.g;
import java.io.IOException;
import okhttp3.Request;

/* loaded from: classes3.dex */
final class BufferedRequestBody extends OutputStreamRequestBody {
    final f buffer;
    long contentLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BufferedRequestBody(long j2) {
        f fVar = new f();
        this.buffer = fVar;
        this.contentLength = -1L;
        initOutputStream(fVar, j2);
    }

    @Override // okhttp3.internal.huc.OutputStreamRequestBody, okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.contentLength;
    }

    @Override // okhttp3.internal.huc.OutputStreamRequestBody
    public Request prepareToSendRequest(Request request) throws IOException {
        if (request.header("Content-Length") != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.O0();
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.O0())).build();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(g gVar) throws IOException {
        this.buffer.f(gVar.i(), 0L, this.buffer.O0());
    }
}