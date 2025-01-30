package com.coinbase.wallet.consumer.views.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerCoinCellViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAccountsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerUnsupportedCryptoAccountViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", ApiConstants.NAME, "Landroid/widget/TextView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUnsupportedCryptoAccountViewHolder extends RecyclerView.e0 {
    private final ImageView icon;
    private final TextView name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerUnsupportedCryptoAccountViewHolder(View view) {
        super(view);
        m.g(view, "view");
        View findViewById = view.findViewById(R.id.icon);
        m.f(findViewById, "view.findViewById(R.id.icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        m.f(findViewById2, "view.findViewById(R.id.name)");
        this.name = (TextView) findViewById2;
    }

    public final void bind(ConsumerCoinCellViewState item) {
        m.g(item, "item");
        Glide.with(this.itemView).load(item.getImageURL()).into(this.icon);
        this.name.setText(item.getName());
    }
}