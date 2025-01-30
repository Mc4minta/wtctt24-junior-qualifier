package org.apache.commons.logging;

import java.net.URL;
import java.security.PrivilegedAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogFactory.java */
/* loaded from: classes3.dex */
public final class f implements PrivilegedAction {
    private final /* synthetic */ URL a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(URL url) {
        this.a = url;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.security.PrivilegedAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object run() {
        /*
            r6 = this;
            java.lang.String r0 = "Unable to close stream for URL "
            r1 = 0
            java.net.URL r2 = r6.a     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4b
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4b
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4b
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4b
            r3 = 0
            r2.setUseCaches(r3)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4b
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L4b
            if (r2 == 0) goto L25
            java.util.Properties r3 = new java.util.Properties     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L7b
            r3.<init>()     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L7b
            r3.load(r2)     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L7b
            r2.close()     // Catch: java.io.IOException -> L4c java.lang.Throwable -> L7b
            return r3
        L25:
            if (r2 == 0) goto L7a
            r2.close()     // Catch: java.io.IOException -> L2b
            goto L7a
        L2b:
            boolean r2 = org.apache.commons.logging.h.w()
            if (r2 == 0) goto L7a
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
        L36:
            r2.append(r0)
            java.net.URL r0 = r6.a
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            org.apache.commons.logging.h.a(r0)
            goto L7a
        L46:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L7c
        L4b:
            r2 = r1
        L4c:
            boolean r3 = org.apache.commons.logging.h.w()     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L68
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L7b
            r3.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = "Unable to read URL "
            r3.append(r4)     // Catch: java.lang.Throwable -> L7b
            java.net.URL r4 = r6.a     // Catch: java.lang.Throwable -> L7b
            r3.append(r4)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L7b
            org.apache.commons.logging.h.a(r3)     // Catch: java.lang.Throwable -> L7b
        L68:
            if (r2 == 0) goto L7a
            r2.close()     // Catch: java.io.IOException -> L6e
            goto L7a
        L6e:
            boolean r2 = org.apache.commons.logging.h.w()
            if (r2 == 0) goto L7a
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            goto L36
        L7a:
            return r1
        L7b:
            r1 = move-exception
        L7c:
            if (r2 == 0) goto L9c
            r2.close()     // Catch: java.io.IOException -> L82
            goto L9c
        L82:
            boolean r2 = org.apache.commons.logging.h.w()
            if (r2 == 0) goto L9c
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r0)
            java.net.URL r0 = r6.a
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            org.apache.commons.logging.h.a(r0)
        L9c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.f.run():java.lang.Object");
    }
}