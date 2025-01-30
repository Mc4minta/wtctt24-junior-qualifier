package com.coinbase.cipherwebview.httpclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.d;

/* compiled from: JavaScriptInjectedInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/coinbase/cipherwebview/httpclient/JavaScriptInjectedInputStream;", "Ljava/io/InputStream;", "", "read", "()I", "Lkotlin/x;", "close", "()V", "Ljava/io/ByteArrayInputStream;", "jsStream", "Ljava/io/ByteArrayInputStream;", "Ljava/lang/StringBuffer;", "buffer", "Ljava/lang/StringBuffer;", "", "injected", "Z", "injectionPointFound", "inputStream", "Ljava/io/InputStream;", "", "javaScript", "scriptSrcNonce", "<init>", "(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class JavaScriptInjectedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 10;
    public static final Companion Companion = new Companion(null);
    private final StringBuffer buffer;
    private boolean injected;
    private boolean injectionPointFound;
    private final InputStream inputStream;
    private final ByteArrayInputStream jsStream;

    /* compiled from: JavaScriptInjectedInputStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/cipherwebview/httpclient/JavaScriptInjectedInputStream$Companion;", "", "", "BUFFER_SIZE", "I", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ JavaScriptInjectedInputStream(InputStream inputStream, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, str, (i2 & 4) != 0 ? null : str2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.inputStream.close();
        if (this.injected) {
            return;
        }
        this.jsStream.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
        if (r2 != false) goto L18;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.injectionPointFound
            r1 = 1
            if (r0 != 0) goto L62
            java.io.InputStream r0 = r7.inputStream
            int r0 = r0.read()
            java.lang.StringBuffer r2 = r7.buffer
            int r2 = r2.length()
            r3 = 10
            r4 = 0
            if (r2 != r3) goto L1b
            java.lang.StringBuffer r2 = r7.buffer
            r2.deleteCharAt(r4)
        L1b:
            java.lang.StringBuffer r2 = r7.buffer
            char r3 = (char) r0
            r2.append(r3)
            java.lang.StringBuffer r2 = r7.buffer
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "buffer.toString()"
            kotlin.jvm.internal.m.f(r2, r3)
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.m.f(r2, r3)
            java.lang.String r3 = "<head>"
            r5 = 2
            r6 = 0
            boolean r3 = kotlin.l0.o.z(r2, r3, r4, r5, r6)
            if (r3 != 0) goto L5f
            java.lang.String r3 = "<body>"
            boolean r3 = kotlin.l0.o.z(r2, r3, r4, r5, r6)
            if (r3 != 0) goto L5f
            java.lang.String r3 = "</title>"
            boolean r3 = kotlin.l0.o.z(r2, r3, r4, r5, r6)
            if (r3 != 0) goto L5f
            java.lang.String r3 = "</style>"
            boolean r3 = kotlin.l0.o.z(r2, r3, r4, r5, r6)
            if (r3 != 0) goto L5f
            java.lang.String r3 = "</script>"
            boolean r2 = kotlin.l0.o.z(r2, r3, r4, r5, r6)
            if (r2 == 0) goto L61
        L5f:
            r7.injectionPointFound = r1
        L61:
            return r0
        L62:
            boolean r0 = r7.injected
            if (r0 != 0) goto L7d
            java.io.ByteArrayInputStream r0 = r7.jsStream
            int r0 = r0.read()
            r2 = -1
            if (r0 != r2) goto L7c
            java.io.ByteArrayInputStream r0 = r7.jsStream
            r0.close()
            r7.injected = r1
            java.io.InputStream r0 = r7.inputStream
            int r0 = r0.read()
        L7c:
            return r0
        L7d:
            java.io.InputStream r0 = r7.inputStream
            int r0 = r0.read()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.cipherwebview.httpclient.JavaScriptInjectedInputStream.read():int");
    }

    public JavaScriptInjectedInputStream(InputStream inputStream, String javaScript, String str) {
        String str2;
        m.g(inputStream, "inputStream");
        m.g(javaScript, "javaScript");
        this.inputStream = inputStream;
        this.buffer = new StringBuffer(10);
        if (str == null) {
            str2 = "<script>";
        } else {
            str2 = "<script nonce=\"" + ((Object) str) + "\">";
        }
        String str3 = str2 + "\n//<![CDATA[\n" + javaScript + "\n//]]>\n</script>";
        Charset charset = d.a;
        Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str3.getBytes(charset);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        this.jsStream = new ByteArrayInputStream(bytes);
    }
}