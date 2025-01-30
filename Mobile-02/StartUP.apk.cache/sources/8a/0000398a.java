package com.google.firebase.crashlytics.c.g;

import com.google.firebase.crashlytics.c.i.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class f implements z {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8679b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8680c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, String str2, byte[] bArr) {
        this.f8679b = str;
        this.f8680c = str2;
        this.a = bArr;
    }

    private static /* synthetic */ void d(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable unused) {
        }
    }

    private byte[] e() {
        if (f()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(this.a);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                d(null, gZIPOutputStream);
                d(null, byteArrayOutputStream);
                return byteArray;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean f() {
        byte[] bArr = this.a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.c.g.z
    public String a() {
        return this.f8680c;
    }

    @Override // com.google.firebase.crashlytics.c.g.z
    public InputStream b() {
        if (f()) {
            return null;
        }
        return new ByteArrayInputStream(this.a);
    }

    @Override // com.google.firebase.crashlytics.c.g.z
    public v.c.b c() {
        byte[] e2 = e();
        if (e2 == null) {
            return null;
        }
        return v.c.b.a().b(e2).c(this.f8679b).a();
    }
}