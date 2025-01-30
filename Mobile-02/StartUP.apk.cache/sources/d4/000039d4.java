package com.google.firebase.crashlytics.c.g;

import com.google.firebase.crashlytics.c.i.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class u implements z {
    private final File a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8800b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8801c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str, String str2, File file) {
        this.f8800b = str;
        this.f8801c = str2;
        this.a = file;
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
        byte[] bArr = new byte[PKIFailureInfo.certRevoked];
        try {
            InputStream b2 = b();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                if (b2 == null) {
                    d(null, gZIPOutputStream);
                    d(null, byteArrayOutputStream);
                    if (b2 != null) {
                        d(null, b2);
                    }
                    return null;
                }
                while (true) {
                    int read = b2.read(bArr);
                    if (read > 0) {
                        gZIPOutputStream.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        d(null, gZIPOutputStream);
                        d(null, byteArrayOutputStream);
                        d(null, b2);
                        return byteArray;
                    }
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.c.g.z
    public String a() {
        return this.f8801c;
    }

    @Override // com.google.firebase.crashlytics.c.g.z
    public InputStream b() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.c.g.z
    public v.c.b c() {
        byte[] e2 = e();
        if (e2 != null) {
            return v.c.b.a().b(e2).c(this.f8800b).a();
        }
        return null;
    }
}