package com.coinbase.wallet.features.applock.legacy;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: AuthenticationHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AuthenticationHelper$decryptRecoveryPhrase$2 extends o implements kotlin.e0.c.l<String, x> {
    final /* synthetic */ AuthenticationCallback $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthenticationHelper$decryptRecoveryPhrase$2(AuthenticationCallback authenticationCallback) {
        super(1);
        this.$callback = authenticationCallback;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(String str) {
        invoke2(str);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        m.g(it, "it");
        this.$callback.onAuthenticationSucceeded(new e.j.d.e(it));
    }
}