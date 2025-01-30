package com.coinbase.wallet.features.walletlink.views;

import android.content.DialogInterface;
import com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsAdapter;
import com.coinbase.walletlink.models.Session;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: WalletLinkSettingsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1$actions$1 extends o implements l<DialogInterface, x> {
    final /* synthetic */ List<Session> $sessions;
    final /* synthetic */ WalletLinkSettingsAdapter.DAppViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1$actions$1(WalletLinkSettingsAdapter.DAppViewHolder dAppViewHolder, List<Session> list) {
        super(1);
        this.this$0 = dAppViewHolder;
        this.$sessions = list;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface it) {
        l lVar;
        m.g(it, "it");
        lVar = this.this$0.unlinkListener;
        lVar.invoke(this.$sessions);
        it.dismiss();
    }
}