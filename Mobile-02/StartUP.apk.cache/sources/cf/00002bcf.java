package com.coinbase.walletlink.extensions;

import h.c.m0.f;
import h.c.s;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import org.apache.http.message.TokenParser;

/* compiled from: Observable+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Lh/c/s;", "", "msg", "logError", "(Lh/c/s;Ljava/lang/String;)Lh/c/s;", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Observable_WalletLinkKt {
    public static /* synthetic */ void a(String str, Throwable th) {
        m2183logError$lambda0(str, th);
    }

    public static final <T> s<T> logError(s<T> sVar, final String str) {
        m.g(sVar, "<this>");
        s<T> doOnError = sVar.doOnError(new f() { // from class: com.coinbase.walletlink.extensions.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Observable_WalletLinkKt.a(str, (Throwable) obj);
            }
        });
        m.f(doOnError, "doOnError {\n    Timber.e(it, \"WalletLink exception $msg ${it.localizedMessage}\".trim())\n}");
        return doOnError;
    }

    public static /* synthetic */ s logError$default(s sVar, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return logError(sVar, str);
    }

    /* renamed from: logError$lambda-0 */
    public static final void m2183logError$lambda0(String str, Throwable th) {
        CharSequence h1;
        String str2 = "WalletLink exception " + ((Object) str) + TokenParser.SP + ((Object) th.getLocalizedMessage());
        Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
        h1 = y.h1(str2);
        l.a.a.f(th, h1.toString(), new Object[0]);
    }
}