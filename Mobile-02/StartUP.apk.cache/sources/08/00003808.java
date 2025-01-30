package com.google.api.client.http.d0;

import e.g.b.a.d.b0;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* compiled from: ContentEntity.java */
/* loaded from: classes2.dex */
final class d extends AbstractHttpEntity {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final b0 f8348b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(long j2, b0 b0Var) {
        this.a = j2;
        this.f8348b = (b0) y.d(b0Var);
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.a;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.a != 0) {
            this.f8348b.writeTo(outputStream);
        }
    }
}