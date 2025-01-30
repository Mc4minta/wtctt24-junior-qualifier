package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: HttpEncodingStreamingContent.java */
/* loaded from: classes2.dex */
public final class j implements e.g.b.a.d.b0 {
    private final e.g.b.a.d.b0 a;

    /* renamed from: b  reason: collision with root package name */
    private final i f8368b;

    public j(e.g.b.a.d.b0 b0Var, i iVar) {
        this.a = (e.g.b.a.d.b0) e.g.b.a.d.y.d(b0Var);
        this.f8368b = (i) e.g.b.a.d.y.d(iVar);
    }

    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        this.f8368b.a(this.a, outputStream);
    }
}