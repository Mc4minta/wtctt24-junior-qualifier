package com.google.firebase.crashlytics.c.g;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class a0 {
    private static void a(InputStream inputStream, File file) throws IOException {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[PKIFailureInfo.certRevoked];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        gZIPOutputStream2.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream2.finish();
                        h.f(gZIPOutputStream2);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    h.f(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(File file, List<z> list) {
        for (z zVar : list) {
            InputStream inputStream = null;
            try {
                inputStream = zVar.b();
                if (inputStream != null) {
                    a(inputStream, new File(file, zVar.a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                h.f(null);
                throw th;
            }
            h.f(inputStream);
        }
    }
}