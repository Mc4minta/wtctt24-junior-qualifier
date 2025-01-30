package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* loaded from: classes3.dex */
public class SessionOutputBufferImpl implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = {13, 10};
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outstream;

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i2, int i3, CharsetEncoder charsetEncoder) {
        Args.positive(i2, "Buffer size");
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new ByteArrayBuffer(i2);
        this.fragementSizeHint = i3 < 0 ? 0 : i3;
        this.encoder = charsetEncoder;
    }

    private void flushBuffer() throws IOException {
        int length = this.buffer.length();
        if (length > 0) {
            streamWrite(this.buffer.buffer(), 0, length);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(length);
        }
    }

    private void flushStream() throws IOException {
        OutputStream outputStream = this.outstream;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    private void handleEncodingResult(CoderResult coderResult) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.bbuf.flip();
        while (this.bbuf.hasRemaining()) {
            write(this.bbuf.get());
        }
        this.bbuf.compact();
    }

    private void streamWrite(byte[] bArr, int i2, int i3) throws IOException {
        Asserts.notNull(this.outstream, "Output stream");
        this.outstream.write(bArr, i2, i3);
    }

    private void writeEncoded(CharBuffer charBuffer) throws IOException {
        if (charBuffer.hasRemaining()) {
            if (this.bbuf == null) {
                this.bbuf = ByteBuffer.allocate(1024);
            }
            this.encoder.reset();
            while (charBuffer.hasRemaining()) {
                handleEncodingResult(this.encoder.encode(charBuffer, this.bbuf, true));
            }
            handleEncodingResult(this.encoder.flush(this.bbuf));
            this.bbuf.clear();
        }
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(OutputStream outputStream) {
        this.outstream = outputStream;
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        flushStream();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean isBound() {
        return this.outstream != null;
    }

    @Override // org.apache.http.io.BufferInfo
    public int length() {
        return this.buffer.length();
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr == null) {
            return;
        }
        if (i3 <= this.fragementSizeHint && i3 <= this.buffer.capacity()) {
            if (i3 > this.buffer.capacity() - this.buffer.length()) {
                flushBuffer();
            }
            this.buffer.append(bArr, i2, i3);
            return;
        }
        flushBuffer();
        streamWrite(bArr, i2, i3);
        this.metrics.incrementBytesTransferred(i3);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String str) throws IOException {
        if (str == null) {
            return;
        }
        if (str.length() > 0) {
            if (this.encoder == null) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    write(str.charAt(i2));
                }
            } else {
                writeEncoded(CharBuffer.wrap(str));
            }
        }
        write(CRLF);
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i2) {
        this(httpTransportMetricsImpl, i2, i2, null);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] bArr) throws IOException {
        if (bArr == null) {
            return;
        }
        write(bArr, 0, bArr.length);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        if (charArrayBuffer == null) {
            return;
        }
        int i2 = 0;
        if (this.encoder == null) {
            int length = charArrayBuffer.length();
            while (length > 0) {
                int min = Math.min(this.buffer.capacity() - this.buffer.length(), length);
                if (min > 0) {
                    this.buffer.append(charArrayBuffer, i2, min);
                }
                if (this.buffer.isFull()) {
                    flushBuffer();
                }
                i2 += min;
                length -= min;
            }
        } else {
            writeEncoded(CharBuffer.wrap(charArrayBuffer.buffer(), 0, charArrayBuffer.length()));
        }
        write(CRLF);
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(int i2) throws IOException {
        if (this.fragementSizeHint > 0) {
            if (this.buffer.isFull()) {
                flushBuffer();
            }
            this.buffer.append(i2);
            return;
        }
        flushBuffer();
        this.outstream.write(i2);
    }
}