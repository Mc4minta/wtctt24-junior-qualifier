package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AFKeystoreWrapper {

    /* renamed from: ǃ  reason: contains not printable characters */
    private Context f32;

    /* renamed from: Ι  reason: contains not printable characters */
    KeyStore f34;

    /* renamed from: ı  reason: contains not printable characters */
    final Object f31 = new Object();

    /* renamed from: ι  reason: contains not printable characters */
    String f35 = "";

    /* renamed from: ɩ  reason: contains not printable characters */
    int f33 = 0;

    public AFKeystoreWrapper(Context context) {
        this.f32 = context;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f34 = keyStore;
            keyStore.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e2);
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static boolean m11(String str) {
        return str.startsWith("com.appsflyer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ı  reason: contains not printable characters */
    public final String m12() {
        String str;
        synchronized (this.f31) {
            str = this.f35;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r1 = r4.split(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r1.length != 3) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r3.length != 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r1.length != 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        r7.f35 = r3[1].trim();
        r7.f33 = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r3 = new java.lang.StringBuilder("Couldn't list KeyStore Aliases: ");
        r3.append(r1.getClass().getName());
        com.appsflyer.AFLogger.afErrorLog(r3.toString(), r1);
     */
    /* renamed from: ǃ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m13() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f31
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.f34     // Catch: java.lang.Throwable -> L89
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L86
            java.util.Enumeration r1 = r1.aliases()     // Catch: java.lang.Throwable -> L6a
        Ld:
            boolean r4 = r1.hasMoreElements()     // Catch: java.lang.Throwable -> L6a
            if (r4 == 0) goto L86
            java.lang.Object r4 = r1.nextElement()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L6a
            if (r4 == 0) goto Ld
            boolean r5 = m11(r4)     // Catch: java.lang.Throwable -> L6a
            if (r5 == 0) goto Ld
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch: java.lang.Throwable -> L6a
            int r5 = r1.length     // Catch: java.lang.Throwable -> L6a
            r6 = 3
            if (r5 != r6) goto L86
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = r5.concat(r4)     // Catch: java.lang.Throwable -> L6a
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch: java.lang.Throwable -> L6a
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Throwable -> L68
            r4 = 2
            r1 = r1[r4]     // Catch: java.lang.Throwable -> L68
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch: java.lang.Throwable -> L68
            int r5 = r3.length     // Catch: java.lang.Throwable -> L68
            if (r5 != r4) goto L87
            int r5 = r1.length     // Catch: java.lang.Throwable -> L68
            if (r5 != r4) goto L87
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L68
            r7.f35 = r3     // Catch: java.lang.Throwable -> L68
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L68
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L68
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L68
            r7.f33 = r1     // Catch: java.lang.Throwable -> L68
            goto L87
        L68:
            r1 = move-exception
            goto L6c
        L6a:
            r1 = move-exception
            r2 = r3
        L6c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L89
            java.lang.Class r4 = r1.getClass()     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L89
            r3.append(r4)     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L89
            com.appsflyer.AFLogger.afErrorLog(r3, r1)     // Catch: java.lang.Throwable -> L89
            goto L87
        L86:
            r2 = r3
        L87:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            return r2
        L89:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.m13():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final void m15(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.f31) {
                if (!this.f34.containsAlias(str)) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 23) {
                        algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
                    } else if (i2 >= 18 && !AndroidUtils.m33()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.f32).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    }
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator.initialize(algorithmParameterSpec);
                    keyPairGenerator.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Ι  reason: contains not printable characters */
    public final int m16() {
        int i2;
        synchronized (this.f31) {
            i2 = this.f33;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final String m14() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.f31) {
            sb.append("KSAppsFlyerId=");
            sb.append(this.f35);
            sb.append(",");
            sb.append("KSAppsFlyerRICounter=");
            sb.append(this.f33);
        }
        return sb.toString();
    }
}