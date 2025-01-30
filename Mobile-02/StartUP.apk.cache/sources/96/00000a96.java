package com.coinbase;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class CoinbaseSSL {
    private static SSLContext sslContext;

    private CoinbaseSSL() {
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized javax.net.ssl.SSLContext getSSLContext() {
        /*
            java.lang.Class<com.coinbase.CoinbaseSSL> r0 = com.coinbase.CoinbaseSSL.class
            monitor-enter(r0)
            javax.net.ssl.SSLContext r1 = com.coinbase.CoinbaseSSL.sslContext     // Catch: java.lang.Throwable -> L85
            if (r1 == 0) goto L9
            monitor-exit(r0)
            return r1
        L9:
            r1 = 0
            java.lang.String r2 = "java.vm.name"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r3 = "Dalvik"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            if (r2 == 0) goto L25
            java.lang.String r2 = "/com/coinbase/api/ca-coinbase.bks"
            java.io.InputStream r2 = r0.getResourceAsStream(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r3 = "BKS"
            java.security.KeyStore r3 = java.security.KeyStore.getInstance(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            goto L31
        L25:
            java.lang.String r2 = "/com/coinbase/api/ca-coinbase.jks"
            java.io.InputStream r2 = r0.getResourceAsStream(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r3 = "JKS"
            java.security.KeyStore r3 = java.security.KeyStore.getInstance(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
        L31:
            java.lang.String r4 = "changeit"
            char[] r4 = r4.toCharArray()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            r3.load(r2, r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            java.lang.String r4 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            javax.net.ssl.TrustManagerFactory r4 = javax.net.ssl.TrustManagerFactory.getInstance(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            r4.init(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            java.lang.String r3 = "TLS"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            javax.net.ssl.TrustManager[] r4 = r4.getTrustManagers()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            r3.init(r1, r4, r1)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            com.coinbase.CoinbaseSSL.sslContext = r3     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L76
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L85
            goto L61
        L5a:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L85
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L85
            throw r2     // Catch: java.lang.Throwable -> L85
        L61:
            javax.net.ssl.SSLContext r1 = com.coinbase.CoinbaseSSL.sslContext     // Catch: java.lang.Throwable -> L85
            monitor-exit(r0)
            return r1
        L65:
            r1 = move-exception
            goto L70
        L67:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L77
        L6c:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L70:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L76
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L76
            throw r3     // Catch: java.lang.Throwable -> L76
        L76:
            r1 = move-exception
        L77:
            if (r2 == 0) goto L84
            r2.close()     // Catch: java.io.IOException -> L7d java.lang.Throwable -> L85
            goto L84
        L7d:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L85
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L85
            throw r2     // Catch: java.lang.Throwable -> L85
        L84:
            throw r1     // Catch: java.lang.Throwable -> L85
        L85:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.CoinbaseSSL.getSSLContext():javax.net.ssl.SSLContext");
    }

    public static X509TrustManager getTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers: " + Arrays.toString(trustManagers));
        } catch (KeyStoreException | NoSuchAlgorithmException e2) {
            throw new IllegalStateException("Couldn't initialize x509 trust manager", e2);
        }
    }
}