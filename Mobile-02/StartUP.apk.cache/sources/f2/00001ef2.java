package com.coinbase.wallet.features.lend.views;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: LendUserAgreementFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendUserAgreementFragment$setupViewPager$1 extends o implements l<Boolean, x> {
    final /* synthetic */ LendUserAgreementFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendUserAgreementFragment$setupViewPager$1(LendUserAgreementFragment lendUserAgreementFragment) {
        super(1);
        this.this$0 = lendUserAgreementFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return x.a;
    }

    public final void invoke(boolean z) {
        this.this$0.getViewModel().onAgreementChanged(z);
    }
}