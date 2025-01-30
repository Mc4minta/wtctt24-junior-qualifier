package com.coinbase.wallet.consumer.views.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.consumer.models.SectionHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAccountsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/SectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/consumer/models/SectionHeader;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/consumer/models/SectionHeader;)V", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SectionHeaderViewHolder extends RecyclerView.e0 {
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionHeaderViewHolder(View view) {
        super(view);
        m.g(view, "view");
        this.textView = (TextView) view;
    }

    public final void bind(SectionHeader item) {
        m.g(item, "item");
        this.textView.setText(item.getName());
    }
}