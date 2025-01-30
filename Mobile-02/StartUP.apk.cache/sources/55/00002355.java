package com.coinbase.wallet.features.walletlink.views;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: WalletLinkSettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "hasSessions", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletLinkSettingsFragment$onViewCreated$1 extends o implements l<Boolean, x> {
    final /* synthetic */ WalletLinkSettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkSettingsFragment$onViewCreated$1(WalletLinkSettingsFragment walletLinkSettingsFragment) {
        super(1);
        this.this$0 = walletLinkSettingsFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean hasSessions) {
        WalletLinkSettingsAdapter adapter;
        WalletLinkSettingsViewModel walletLinkSettingsViewModel;
        m.f(hasSessions, "hasSessions");
        if (hasSessions.booleanValue()) {
            adapter = this.this$0.getAdapter();
            walletLinkSettingsViewModel = this.this$0.viewModel;
            if (walletLinkSettingsViewModel != null) {
                adapter.setItems(walletLinkSettingsViewModel.getSections());
                return;
            } else {
                m.w("viewModel");
                throw null;
            }
        }
        Fragment_CommonKt.navigateUp(this.this$0);
    }
}