package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.MessageConstraintException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* loaded from: classes3.dex */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferlen;
    private int bufferpos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream instream;
    private final ByteArrayBuffer linebuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i2, int i3, MessageConstraints messageConstraints, CharsetDecoder charsetDecoder) {
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        Args.positive(i2, "Buffer size");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new byte[i2];
        this.bufferpos = 0;
        this.bufferlen = 0;
        this.minChunkLimit = i3 < 0 ? 512 : i3;
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.linebuffer = new ByteArrayBuffer(i2);
        this.decoder = charsetDecoder;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int i2 = 0;
        if (byteBuffer.hasRemaining()) {
            if (this.cbuf == null) {
                this.cbuf = CharBuffer.allocate(1024);
            }
            this.decoder.reset();
            while (byteBuffer.hasRemaining()) {
                i2 += handleDecodingResult(this.decoder.decode(byteBuffer, this.cbuf, true), charArrayBuffer, byteBuffer);
            }
            int handleDecodingResult = i2 + handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer, byteBuffer);
            this.cbuf.clear();
            return handleDecodingResult;
        }
        return 0;
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int remaining = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return remaining;
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.linebuffer.length();
        if (length > 0) {
            if (this.linebuffer.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.linebuffer.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.decoder == null) {
            charArrayBuffer.append(this.linebuffer, 0, length);
        } else {
            length = appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.linebuffer.buffer(), 0, length));
        }
        this.linebuffer.clear();
        return length;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i2) throws IOException {
        int i3 = this.bufferpos;
        this.bufferpos = i2 + 1;
        if (i2 > i3 && this.buffer[i2 - 1] == 13) {
            i2--;
        }
        int i4 = i2 - i3;
        if (this.decoder == null) {
            charArrayBuffer.append(this.buffer, i3, i4);
            return i4;
        }
        return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i3, i4));
    }

    private int streamRead(byte[] bArr, int i2, int i3) throws IOException {
        Asserts.notNull(this.instream, "Input stream");
        return this.instream.read(bArr, i2, i3);
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(InputStream inputStream) {
        this.instream = inputStream;
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.bufferpos = 0;
        this.bufferlen = 0;
    }

    public int fillBuffer() throws IOException {
        int i2 = this.bufferpos;
        if (i2 > 0) {
            int i3 = this.bufferlen - i2;
            if (i3 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i2, bArr, 0, i3);
            }
            this.bufferpos = 0;
            this.bufferlen = i3;
        }
        int i4 = this.bufferlen;
        byte[] bArr2 = this.buffer;
        int streamRead = streamRead(bArr2, i4, bArr2.length - i4);
        if (streamRead == -1) {
            return -1;
        }
        this.bufferlen = i4 + streamRead;
        this.metrics.incrementBytesTransferred(streamRead);
        return streamRead;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    public boolean isBound() {
        return this.instream != null;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i2) throws IOException {
        return hasBufferedData();
    }

    @Override // org.apache.http.io.BufferInfo
    public int length() {
        return this.bufferlen - this.bufferpos;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i2 = this.bufferpos;
        this.bufferpos = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int maxLineLength = this.constraints.getMaxLineLength();
        boolean z = true;
        int i2 = 0;
        while (z) {
            int i3 = this.bufferpos;
            while (true) {
                if (i3 >= this.bufferlen) {
                    i3 = -1;
                    break;
                } else if (this.buffer[i3] == 10) {
                    break;
                } else {
                    i3++;
                }
            }
            if (maxLineLength > 0) {
                if ((this.linebuffer.length() + (i3 >= 0 ? i3 : this.bufferlen)) - this.bufferpos >= maxLineLength) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
            }
            if (i3 != -1) {
                if (this.linebuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, i3);
                }
                int i4 = i3 + 1;
                int i5 = this.bufferpos;
                this.linebuffer.append(this.buffer, i5, i4 - i5);
                this.bufferpos = i4;
            } else {
                if (hasBufferedData()) {
                    int i6 = this.bufferlen;
                    int i7 = this.bufferpos;
                    this.linebuffer.append(this.buffer, i7, i6 - i7);
                    this.bufferpos = this.bufferlen;
                }
                i2 = fillBuffer();
                if (i2 == -1) {
                }
            }
            z = false;
        }
        if (i2 == -1 && this.linebuffer.isEmpty()) {
            return -1;
        }
        return lineFromLineBuffer(charArrayBuffer);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr == null) {
            return 0;
        }
        if (hasBufferedData()) {
            int min = Math.min(i3, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, bArr, i2, min);
            this.bufferpos += min;
            return min;
        } else if (i3 > this.minChunkLimit) {
            int streamRead = streamRead(bArr, i2, i3);
            if (streamRead > 0) {
                this.metrics.incrementBytesTransferred(streamRead);
            }
            return streamRead;
        } else {
            while (!hasBufferedData()) {
                if (fillBuffer() == -1) {
                    return -1;
                }
            }
            int min2 = Math.min(i3, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, bArr, i2, min2);
            this.bufferpos += min2;
            return min2;
        }
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i2) {
        this(httpTransportMetricsImpl, i2, i2, null, null);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }
}