package com.coinbase.wallet.features.signer.views;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.u;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: ParentRequestEthereumAccountsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "Landroidx/fragment/app/Fragment;", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ParentRequestEthereumAccountsFragment$setup$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Fragment, ? extends String>, x> {
    final /* synthetic */ ParentRequestEthereumAccountsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentRequestEthereumAccountsFragment$setup$1(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
        super(1);
        this.this$0 = parentRequestEthereumAccountsFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends Fragment, ? extends String> oVar) {
        invoke2((kotlin.o<? extends Fragment, String>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends Fragment, String> oVar) {
        String b2 = oVar.b();
        u j2 = this.this$0.getParentFragmentManager().j();
        j2.h(b2);
        j2.c(16908290, oVar.a(), b2);
        j2.j();
    }
}