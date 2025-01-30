package com.coinbase.wallet.txhistory.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.models.ReceiptCellViewState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TxHistoryDetailAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewHolder;", "", "Lcom/coinbase/wallet/txhistory/models/ReceiptCellViewState;", "items", "Lkotlin/x;", "setItems", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewHolder;", "getItemCount", "()I", "holder", "position", "onBindViewHolder", "(Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewHolder;I)V", "", "Ljava/util/List;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDetailAdapter extends RecyclerView.g<TxHistoryDetailViewHolder> {
    private final List<ReceiptCellViewState> items = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.items.size();
    }

    public final void setItems(List<ReceiptCellViewState> items) {
        m.g(items, "items");
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(TxHistoryDetailViewHolder holder, int i2) {
        m.g(holder, "holder");
        holder.bind(this.items.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public TxHistoryDetailViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__tx_history_detail_item, parent, false);
        m.f(view, "view");
        return new TxHistoryDetailViewHolder(view);
    }
}