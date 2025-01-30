package com.coinbase.wallet.features.wallets.views;

import android.os.Bundle;
import android.os.Parcelable;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.send.models.SendCoinPickerArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.o;

/* compiled from: SendCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "<anonymous>", "()Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendCoinPickerFragment$walletFilter$2 extends o implements kotlin.e0.c.a<List<? extends Wallet>> {
    final /* synthetic */ SendCoinPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendCoinPickerFragment$walletFilter$2(SendCoinPickerFragment sendCoinPickerFragment) {
        super(0);
        this.this$0 = sendCoinPickerFragment;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends Wallet> invoke() {
        List<? extends Wallet> g2;
        Parcelable[] parcelableArray;
        Bundle arguments = this.this$0.getArguments();
        ArrayList arrayList = null;
        if (arguments != null && (parcelableArray = arguments.getParcelableArray(SendCoinPickerArgs.INSTANCE.getEXTRA_FILTERED_WALLETS())) != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                if (parcelable instanceof Wallet) {
                    arrayList.add(parcelable);
                }
            }
        }
        if (arrayList == null) {
            g2 = r.g();
            return g2;
        }
        return arrayList;
    }
}