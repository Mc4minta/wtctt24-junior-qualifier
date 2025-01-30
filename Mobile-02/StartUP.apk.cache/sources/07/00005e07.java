package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
/* loaded from: classes3.dex */
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer, BufferInfo {
    private boolean ascii;
    private byte[] buffer;
    private int bufferlen;
    private int bufferpos;
    private CharBuffer cbuf;
    private Charset charset;
    private CharsetDecoder decoder;
    private InputStream instream;
    private ByteArrayBuffer linebuffer;
    private int maxLineLen;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int i2 = 0;
        if (byteBuffer.hasRemaining()) {
            if (this.decoder == null) {
                CharsetDecoder newDecoder = this.charset.newDecoder();
                this.decoder = newDecoder;
                newDecoder.onMalformedInput(this.onMalformedCharAction);
                this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
            }
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
        if (this.ascii) {
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
        if (this.ascii) {
            charArrayBuffer.append(this.buffer, i3, i4);
            return i4;
        }
        return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i3, i4));
    }

    private int locateLF() {
        for (int i2 = this.bufferpos; i2 < this.bufferlen; i2++) {
            if (this.buffer[i2] == 10) {
                return i2;
            }
        }
        return -1;
    }

    @Override // org.apache.http.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    @Override // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    protected HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        int read = this.instream.read(bArr2, i4, bArr2.length - i4);
        if (read == -1) {
            return -1;
        }
        this.bufferlen = i4 + read;
        this.metrics.incrementBytesTransferred(read);
        return read;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(InputStream inputStream, int i2, HttpParams httpParams) {
        Args.notNull(inputStream, "Input stream");
        Args.notNegative(i2, "Buffer size");
        Args.notNull(httpParams, "HTTP parameters");
        this.instream = inputStream;
        this.buffer = new byte[i2];
        this.bufferpos = 0;
        this.bufferlen = 0;
        this.linebuffer = new ByteArrayBuffer(i2);
        String str = (String) httpParams.getParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        Charset forName = str != null ? Charset.forName(str) : Consts.ASCII;
        this.charset = forName;
        this.ascii = forName.equals(Consts.ASCII);
        this.decoder = null;
        this.maxLineLen = httpParams.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.minChunkLimit = httpParams.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
        this.metrics = createTransportMetrics();
        CodingErrorAction codingErrorAction = (CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.onMalformedCharAction = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.onUnmappableCharAction = codingErrorAction2;
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r2 == (-1)) goto L9;
     */
    @Override // org.apache.http.io.SessionInputBuffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readLine(org.apache.http.util.CharArrayBuffer r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "Char array buffer"
            org.apache.http.util.Args.notNull(r8, r0)
            r0 = 1
            r1 = 0
            r2 = r1
        L8:
            r3 = -1
            if (r0 == 0) goto L63
            int r4 = r7.locateLF()
            if (r4 == r3) goto L2f
            org.apache.http.util.ByteArrayBuffer r0 = r7.linebuffer
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1e
            int r8 = r7.lineFromReadBuffer(r8, r4)
            return r8
        L1e:
            int r4 = r4 + 1
            int r0 = r7.bufferpos
            int r3 = r4 - r0
            org.apache.http.util.ByteArrayBuffer r5 = r7.linebuffer
            byte[] r6 = r7.buffer
            r5.append(r6, r0, r3)
            r7.bufferpos = r4
        L2d:
            r0 = r1
            goto L4c
        L2f:
            boolean r2 = r7.hasBufferedData()
            if (r2 == 0) goto L45
            int r2 = r7.bufferlen
            int r4 = r7.bufferpos
            int r2 = r2 - r4
            org.apache.http.util.ByteArrayBuffer r5 = r7.linebuffer
            byte[] r6 = r7.buffer
            r5.append(r6, r4, r2)
            int r2 = r7.bufferlen
            r7.bufferpos = r2
        L45:
            int r2 = r7.fillBuffer()
            if (r2 != r3) goto L4c
            goto L2d
        L4c:
            int r3 = r7.maxLineLen
            if (r3 <= 0) goto L8
            org.apache.http.util.ByteArrayBuffer r3 = r7.linebuffer
            int r3 = r3.length()
            int r4 = r7.maxLineLen
            if (r3 >= r4) goto L5b
            goto L8
        L5b:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "Maximum line length limit exceeded"
            r8.<init>(r0)
            throw r8
        L63:
            if (r2 != r3) goto L6e
            org.apache.http.util.ByteArrayBuffer r0 = r7.linebuffer
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L6e
            return r3
        L6e:
            int r8 = r7.lineFromLineBuffer(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.io.AbstractSessionInputBuffer.readLine(org.apache.http.util.CharArrayBuffer):int");
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
            int read = this.instream.read(bArr, i2, i3);
            if (read > 0) {
                this.metrics.incrementBytesTransferred(read);
            }
            return read;
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