package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: EmptyContent.java */
/* loaded from: classes2.dex */
public class e implements h {
    @Override // com.google.api.client.http.h
    public boolean a() {
        return true;
    }

    @Override // com.google.api.client.http.h
    public long getLength() throws IOException {
        return 0L;
    }

    @Override // com.google.api.client.http.h
    public String getType() {
        return null;
    }

    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }
}