package com.coinbase.cipherwebview.util;

import java.security.SecureRandom;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i0.c;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.x;
import kotlin.l0.y;
import kotlin.o;
import org.apache.http.message.TokenParser;

/* compiled from: injectCSPNonce.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\f\"\u0016\u0010\u0010\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"", "headerValue", "Lkotlin/o;", "injectCSPNonce", "(Ljava/lang/String;)Lkotlin/o;", "Lkotlin/l0/i;", "match", "nonceSrc", "injectNonceSrc", "(Ljava/lang/String;Lkotlin/l0/i;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/l0/k;", "DEFAULT_SRC_REGEX", "Lkotlin/l0/k;", "NONE_SRC", "Ljava/lang/String;", "SCRIPT_SRC_REGEX", "UNSAFE_INLINE_SRC", "cipher-webview_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class InjectCSPNonceKt {
    private static final String NONE_SRC = "'none'";
    private static final String UNSAFE_INLINE_SRC = "'unsafe-inline'";
    private static final k DEFAULT_SRC_REGEX = new k("(^|;)\\s*default-src\\s+[^;]*");
    private static final k SCRIPT_SRC_REGEX = new k("(^|;)\\s*script-src\\s+[^;]*");

    public static final o<String, String> injectCSPNonce(String headerValue) {
        m.g(headerValue, "headerValue");
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        String hexEncodedString$default = ByteArray_CipherWebViewKt.toHexEncodedString$default(bArr, false, 1, null);
        i b2 = k.b(SCRIPT_SRC_REGEX, headerValue, 0, 2, null);
        i b3 = k.b(DEFAULT_SRC_REGEX, headerValue, 0, 2, null);
        String str = "'nonce-" + hexEncodedString$default + '\'';
        if (b2 != null) {
            headerValue = injectNonceSrc(headerValue, b2, str);
        } else if (b3 != null) {
            headerValue = injectNonceSrc(headerValue, b3, str);
        }
        return new o<>(headerValue, hexEncodedString$default);
    }

    private static final String injectNonceSrc(String str, i iVar, String str2) {
        boolean V;
        boolean V2;
        String str3;
        CharSequence F0;
        String value = iVar.getValue();
        V = y.V(value, UNSAFE_INLINE_SRC, false, 2, null);
        if (V) {
            return str;
        }
        V2 = y.V(value, NONE_SRC, false, 2, null);
        if (V2) {
            str3 = x.K(value, NONE_SRC, str2, false, 4, null);
        } else {
            str3 = value + TokenParser.SP + str2;
        }
        c d2 = iVar.d();
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        F0 = y.F0(str, d2, str3);
        return F0.toString();
    }
}