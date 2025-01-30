package com.coinbase.wallet.features.wallets.views.adapters;

import com.coinbase.wallet.features.wallets.models.ListItem;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: WalletAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "position", "Lkotlin/x;", "<anonymous>", "(I)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletAdapter$onCreateViewHolder$3 extends o implements l<Integer, x> {
    final /* synthetic */ WalletAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletAdapter$onCreateViewHolder$3(WalletAdapter walletAdapter) {
        super(1);
        this.this$0 = walletAdapter;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Integer num) {
        invoke(num.intValue());
        return x.a;
    }

    public final void invoke(int i2) {
        ListItem item;
        l lVar;
        item = this.this$0.getItem(i2);
        Objects.requireNonNull(item, "null cannot be cast to non-null type com.coinbase.wallet.features.wallets.models.ListItem.WalletListItem");
        ListItem.WalletListItem walletListItem = (ListItem.WalletListItem) item;
        lVar = this.this$0.onWalletItemClickListener;
        if (lVar == null) {
            return;
        }
        lVar.invoke(walletListItem);
    }
}