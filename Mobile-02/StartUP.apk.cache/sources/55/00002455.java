package com.coinbase.wallet.lending.models;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProvider$websiteHost$2 extends o implements a<String> {
    final /* synthetic */ LendProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendProvider$websiteHost$2(LendProvider lendProvider) {
        super(0);
        this.this$0 = lendProvider;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        return this.this$0.getWebsiteURL().getHost();
    }
}