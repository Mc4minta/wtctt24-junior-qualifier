package okhttp3.internal.huc;

import j.f0;
import j.g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class OutputStreamRequestBody extends RequestBody {
    boolean closed;
    private long expectedContentLength;
    private OutputStream outputStream;
    private f0 timeout;

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.expectedContentLength;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initOutputStream(final g gVar, final long j2) {
        this.timeout = gVar.timeout();
        this.expectedContentLength = j2;
        this.outputStream = new OutputStream() { // from class: okhttp3.internal.huc.OutputStreamRequestBody.1
            private long bytesReceived;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                OutputStreamRequestBody.this.closed = true;
                long j3 = j2;
                if (j3 != -1 && this.bytesReceived < j3) {
                    throw new ProtocolException("expected " + j2 + " bytes but received " + this.bytesReceived);
                }
                gVar.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                if (OutputStreamRequestBody.this.closed) {
                    return;
                }
                gVar.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i2) throws IOException {
                write(new byte[]{(byte) i2}, 0, 1);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    long j3 = j2;
                    if (j3 != -1 && this.bytesReceived + i3 > j3) {
                        throw new ProtocolException("expected " + j2 + " bytes but received " + this.bytesReceived + i3);
                    }
                    this.bytesReceived += i3;
                    try {
                        gVar.write(bArr, i2, i3);
                        return;
                    } catch (InterruptedIOException e2) {
                        throw new SocketTimeoutException(e2.getMessage());
                    }
                }
                throw new IOException("closed");
            }
        };
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        return request;
    }

    public final f0 timeout() {
        return this.timeout;
    }
}