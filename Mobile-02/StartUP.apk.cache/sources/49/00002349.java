package com.coinbase.wallet.features.walletlink.views;

import android.view.View;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsAdapter;
import com.coinbase.walletlink.models.Session;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkSettingsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1 extends o implements l<View, x> {
    final /* synthetic */ String $dappName;
    final /* synthetic */ List<Session> $sessions;
    final /* synthetic */ WalletLinkSettingsAdapter.DAppViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1(String str, WalletLinkSettingsAdapter.DAppViewHolder dAppViewHolder, List<Session> list) {
        super(1);
        this.$dappName = str;
        this.this$0 = dAppViewHolder;
        this.$sessions = list;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        List j2;
        l lVar;
        m.g(it, "it");
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        j2 = r.j(new PromptDialogHelper.Action(localizedStrings.get(R.string.disconnect_walletlink), ActionStyle.NEGATIVE, new WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1$actions$1(this.this$0, this.$sessions)), new PromptDialogHelper.Action(localizedStrings.get(R.string.cancel), ActionStyle.NEUTRAL, WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1$actions$2.INSTANCE));
        PromptDialogHelper.Properties properties = new PromptDialogHelper.Properties(null, Strings_CoreKt.getEmpty(Strings.INSTANCE), localizedStrings.get(R.string.disconnect_dapp_title, this.$dappName), null, null, j2, null, true, null, null, null, null, null, false, 16217, null);
        lVar = this.this$0.showDisconnectPrompt;
        lVar.invoke(properties);
    }
}