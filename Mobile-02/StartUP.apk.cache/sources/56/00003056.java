package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: ExoSoSource.java */
/* loaded from: classes2.dex */
public final class e extends n {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoSoSource.java */
    /* loaded from: classes2.dex */
    public final class b extends n.f {
        private final c[] a;

        /* compiled from: ExoSoSource.java */
        /* loaded from: classes2.dex */
        private final class a extends n.e {
            private int a;

            private a() {
            }

            @Override // com.facebook.soloader.n.e
            public boolean a() {
                return this.a < b.this.a.length;
            }

            @Override // com.facebook.soloader.n.e
            public n.d b() throws IOException {
                c[] cVarArr = b.this.a;
                int i2 = this.a;
                this.a = i2 + 1;
                c cVar = cVarArr[i2];
                FileInputStream fileInputStream = new FileInputStream(cVar.f5620c);
                try {
                    return new n.d(cVar, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00e4, code lost:
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r11 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        b(com.facebook.soloader.n r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.e.b.<init>(com.facebook.soloader.e, com.facebook.soloader.n):void");
        }

        @Override // com.facebook.soloader.n.f
        protected n.c a() throws IOException {
            return new n.c(this.a);
        }

        @Override // com.facebook.soloader.n.f
        protected n.e b() throws IOException {
            return new a();
        }
    }

    /* compiled from: ExoSoSource.java */
    /* loaded from: classes2.dex */
    private static final class c extends n.b {

        /* renamed from: c  reason: collision with root package name */
        final File f5620c;

        c(String str, String str2, File file) {
            super(str, str2);
            this.f5620c = file;
        }
    }

    public e(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.n
    protected n.f m() throws IOException {
        return new b(this);
    }
}