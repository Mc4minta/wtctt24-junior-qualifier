package com.facebook.react.modules.network;

import j.e0;
import j.q;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: ProgressResponseBody.java */
/* loaded from: classes2.dex */
public class j extends ResponseBody {
    private final ResponseBody a;

    /* renamed from: b  reason: collision with root package name */
    private final h f4982b;

    /* renamed from: c  reason: collision with root package name */
    private j.h f4983c;

    /* renamed from: d  reason: collision with root package name */
    private long f4984d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressResponseBody.java */
    /* loaded from: classes2.dex */
    public class a extends j.l {
        a(e0 e0Var) {
            super(e0Var);
        }

        @Override // j.l, j.e0
        public long read(j.f fVar, long j2) throws IOException {
            long read = super.read(fVar, j2);
            int i2 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            j.this.f4984d += i2 != 0 ? read : 0L;
            j.this.f4982b.a(j.this.f4984d, j.this.a.contentLength(), i2 == 0);
            return read;
        }
    }

    public j(ResponseBody responseBody, h hVar) {
        this.a = responseBody;
        this.f4982b = hVar;
    }

    private e0 e(e0 e0Var) {
        return new a(e0Var);
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.a.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.a.contentType();
    }

    public long f() {
        return this.f4984d;
    }

    @Override // okhttp3.ResponseBody
    public j.h source() {
        if (this.f4983c == null) {
            this.f4983c = q.d(e(this.a.source()));
        }
        return this.f4983c;
    }
}