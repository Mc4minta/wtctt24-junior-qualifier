package com.coinbase.walletlink.extensions;

import h.c.b0;
import h.c.m0.f;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import org.apache.http.message.TokenParser;

/* compiled from: Single+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Lh/c/b0;", "", "msg", "logError", "(Lh/c/b0;Ljava/lang/String;)Lh/c/b0;", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Single_WalletLinkKt {
    public static /* synthetic */ void a(String str, Throwable th) {
        m2184logError$lambda0(str, th);
    }

    public static final <T> b0<T> logError(b0<T> b0Var, final String str) {
        m.g(b0Var, "<this>");
        b0<T> doOnError = b0Var.doOnError(new f() { // from class: com.coinbase.walletlink.extensions.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Single_WalletLinkKt.a(str, (Throwable) obj);
            }
        });
        m.f(doOnError, "doOnError {\n    Timber.e(it, \"WalletLink exception $msg ${it.localizedMessage}\".trim())\n}");
        return doOnError;
    }

    public static /* synthetic */ b0 logError$default(b0 b0Var, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return logError(b0Var, str);
    }

    /* renamed from: logError$lambda-0 */
    public static final void m2184logError$lambda0(String str, Throwable th) {
        CharSequence h1;
        String str2 = "WalletLink exception " + ((Object) str) + TokenParser.SP + ((Object) th.getLocalizedMessage());
        Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
        h1 = y.h1(str2);
        l.a.a.f(th, h1.toString(), new Object[0]);
    }
}