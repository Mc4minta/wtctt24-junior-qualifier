package com.coinbase.wallet.core.util;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: Assertion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"#\u0010\u000f\u001a\u00020\b8@@\u0001X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"", "assertion", "Lkotlin/Function0;", "", "lazyMessage", "Lkotlin/x;", "assertOrLog", "(ZLkotlin/e0/c/a;)V", "Landroid/os/Handler;", "assertionHandler$delegate", "Lkotlin/h;", "getAssertionHandler", "()Landroid/os/Handler;", "getAssertionHandler$annotations", "()V", "assertionHandler", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AssertionKt {
    private static final h assertionHandler$delegate;

    static {
        h b2;
        b2 = k.b(AssertionKt$assertionHandler$2.INSTANCE);
        assertionHandler$delegate = b2;
    }

    public static final void assertOrLog(boolean z, a<String> lazyMessage) {
        m.g(lazyMessage, "lazyMessage");
        if (z) {
            return;
        }
        l.a.a.e(new AssertionException(lazyMessage.invoke()));
    }

    public static final Handler getAssertionHandler() {
        return (Handler) assertionHandler$delegate.getValue();
    }

    public static /* synthetic */ void getAssertionHandler$annotations() {
    }
}