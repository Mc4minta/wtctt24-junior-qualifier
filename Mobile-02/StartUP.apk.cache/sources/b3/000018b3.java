package com.coinbase.wallet.consumer.views.adapter;

import android.content.res.ColorStateList;
import com.coinbase.wallet.consumer.R;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: ConsumerAccountsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/res/ColorStateList;", "<anonymous>", "()Landroid/content/res/ColorStateList;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerSupportedCryptoAccountViewHolder$blue$2 extends o implements a<ColorStateList> {
    final /* synthetic */ ConsumerSupportedCryptoAccountViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerSupportedCryptoAccountViewHolder$blue$2(ConsumerSupportedCryptoAccountViewHolder consumerSupportedCryptoAccountViewHolder) {
        super(0);
        this.this$0 = consumerSupportedCryptoAccountViewHolder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ColorStateList invoke() {
        return ColorStateList.valueOf(androidx.core.content.a.d(this.this$0.itemView.getContext(), R.color.primary_blue));
    }
}