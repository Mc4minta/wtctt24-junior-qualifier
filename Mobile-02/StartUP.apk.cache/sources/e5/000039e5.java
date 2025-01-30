package com.google.firebase.crashlytics.c.h;

import com.google.firebase.crashlytics.c.g.h;
import com.google.firebase.crashlytics.c.h.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class d implements com.google.firebase.crashlytics.c.h.a {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private final File f8824b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8825c;

    /* renamed from: d  reason: collision with root package name */
    private c f8826d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class a implements c.d {
        final /* synthetic */ byte[] a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f8827b;

        a(byte[] bArr, int[] iArr) {
            this.a = bArr;
            this.f8827b = iArr;
        }

        @Override // com.google.firebase.crashlytics.c.h.c.d
        public void read(InputStream inputStream, int i2) throws IOException {
            try {
                inputStream.read(this.a, this.f8827b[0], i2);
                int[] iArr = this.f8827b;
                iArr[0] = iArr[0] + i2;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class b {
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8829b;

        b(byte[] bArr, int i2) {
            this.a = bArr;
            this.f8829b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(File file, int i2) {
        this.f8824b = file;
        this.f8825c = i2;
    }

    private void f(long j2, String str) {
        int i2;
        if (this.f8826d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > this.f8825c / 4) {
                str = "..." + str.substring(str.length() - i2);
            }
            this.f8826d.e(String.format(Locale.US, "%d %s%n", Long.valueOf(j2), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(a));
            while (!this.f8826d.v() && this.f8826d.g0() > this.f8825c) {
                this.f8826d.V();
            }
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b.f().e("There was a problem writing to the Crashlytics log.", e2);
        }
    }

    private b g() {
        if (this.f8824b.exists()) {
            h();
            c cVar = this.f8826d;
            if (cVar == null) {
                return null;
            }
            int[] iArr = {0};
            byte[] bArr = new byte[cVar.g0()];
            try {
                this.f8826d.m(new a(bArr, iArr));
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b.f().e("A problem occurred while reading the Crashlytics log file.", e2);
            }
            return new b(bArr, iArr[0]);
        }
        return null;
    }

    private void h() {
        if (this.f8826d == null) {
            try {
                this.f8826d = new c(this.f8824b);
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.e("Could not open log file: " + this.f8824b, e2);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.c.h.a
    public void a() {
        h.e(this.f8826d, "There was a problem closing the Crashlytics log file.");
        this.f8826d = null;
    }

    @Override // com.google.firebase.crashlytics.c.h.a
    public String b() {
        byte[] c2 = c();
        if (c2 != null) {
            return new String(c2, a);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.c.h.a
    public byte[] c() {
        b g2 = g();
        if (g2 == null) {
            return null;
        }
        int i2 = g2.f8829b;
        byte[] bArr = new byte[i2];
        System.arraycopy(g2.a, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.c.h.a
    public void d() {
        a();
        this.f8824b.delete();
    }

    @Override // com.google.firebase.crashlytics.c.h.a
    public void e(long j2, String str) {
        h();
        f(j2, str);
    }
}