package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* loaded from: classes3.dex */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f17591b;
    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.f17591b = bArr;
        this.off = 0;
        this.len = bArr.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.f17591b, this.off, this.len);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.len;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.f17591b, this.off, this.len);
        outputStream.flush();
    }

    public ByteArrayEntity(byte[] bArr, int i2, int i3, ContentType contentType) {
        int i4;
        Args.notNull(bArr, "Source byte array");
        if (i2 >= 0 && i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) >= 0 && i4 <= bArr.length) {
            this.content = bArr;
            this.f17591b = bArr;
            this.off = i2;
            this.len = i3;
            if (contentType != null) {
                setContentType(contentType.toString());
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException("off: " + i2 + " len: " + i3 + " b.length: " + bArr.length);
    }

    public ByteArrayEntity(byte[] bArr) {
        this(bArr, null);
    }

    public ByteArrayEntity(byte[] bArr, int i2, int i3) {
        this(bArr, i2, i3, null);
    }
}