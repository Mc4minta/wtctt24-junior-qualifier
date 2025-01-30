package com.coinbase.walletlink.repositories;

import android.content.Context;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.walletlink.WalletLinkDatabase;
import com.coinbase.walletlink.daos.DappDAO;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: LinkRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/walletlink/daos/DappDAO;", "<anonymous>", "()Lcom/coinbase/walletlink/daos/DappDAO;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class LinkRepository$dappDAO$1 extends o implements kotlin.e0.c.a<DappDAO> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkRepository$dappDAO$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final DappDAO invoke() {
        return new DappDAO(new Database(new DiskOptions(this.$context, WalletLinkDatabase.class, "WalletLink", null, false, 24, null)));
    }
}