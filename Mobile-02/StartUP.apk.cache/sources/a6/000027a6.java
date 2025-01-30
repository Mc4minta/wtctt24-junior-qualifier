package com.coinbase.wallet.txhistory.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.models.TxHistoryCellViewState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.e0;
import kotlin.x;

/* compiled from: TxHistoryAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B\u001b\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryAdapter;", "Landroidx/recyclerview/widget/m;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "holder", "position", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "getItemViewType", "(I)I", "Lkotlin/Function1;", "onTxRowClicked", "Lkotlin/e0/c/l;", "<init>", "(Lkotlin/e0/c/l;)V", "RowType", "TxHistoryItemCallback", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryAdapter extends m<TxHistoryCellViewState, RecyclerView.e0> {
    private final l<TxHistoryCellViewState, x> onTxRowClicked;

    /* compiled from: TxHistoryAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryAdapter$RowType;", "", "", "viewType", "I", "getViewType", "()I", "<init>", "(Ljava/lang/String;II)V", "HEADER", "ITEM", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    private enum RowType {
        HEADER(0),
        ITEM(1);
        
        private final int viewType;

        RowType(int i2) {
            this.viewType = i2;
        }

        public final int getViewType() {
            return this.viewType;
        }
    }

    /* compiled from: TxHistoryAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryAdapter$TxHistoryItemCallback;", "Landroidx/recyclerview/widget/h$d;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;)Z", "", "getChangePayload", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;)Ljava/lang/Object;", "areContentsTheSame", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    private static final class TxHistoryItemCallback extends h.d<TxHistoryCellViewState> {
        @Override // androidx.recyclerview.widget.h.d
        public Object getChangePayload(TxHistoryCellViewState oldItem, TxHistoryCellViewState newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            return newItem;
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areContentsTheSame(TxHistoryCellViewState oldItem, TxHistoryCellViewState newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (kotlin.jvm.internal.m.c(e0.b(oldItem.getClass()), e0.b(newItem.getClass()))) {
                if (!(newItem instanceof TxHistoryCellViewState.Header)) {
                    if (newItem instanceof TxHistoryCellViewState.Item) {
                        TxHistoryCellViewState.Item item = (TxHistoryCellViewState.Item) oldItem;
                        TxHistoryCellViewState.Item item2 = (TxHistoryCellViewState.Item) newItem;
                        if (item.getTx().getState() != item2.getTx().getState() || !kotlin.jvm.internal.m.c(item.getTx().getAmount(), item2.getTx().getAmount()) || !kotlin.jvm.internal.m.c(item.getTx().getFee(), item2.getTx().getFee())) {
                            return false;
                        }
                    } else {
                        throw new IllegalStateException("Unrecognized TxHistoryCellViewState");
                    }
                }
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areItemsTheSame(TxHistoryCellViewState oldItem, TxHistoryCellViewState newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (kotlin.jvm.internal.m.c(e0.b(oldItem.getClass()), e0.b(newItem.getClass()))) {
                if (newItem instanceof TxHistoryCellViewState.Header) {
                    return ((TxHistoryCellViewState.Header) oldItem).getTitle() == ((TxHistoryCellViewState.Header) newItem).getTitle();
                } else if (newItem instanceof TxHistoryCellViewState.Item) {
                    return kotlin.jvm.internal.m.c(((TxHistoryCellViewState.Item) oldItem).getTx().getTxHash(), ((TxHistoryCellViewState.Item) newItem).getTx().getTxHash());
                } else {
                    throw new IllegalStateException("Unrecognized TxHistoryCellViewState");
                }
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TxHistoryAdapter(l<? super TxHistoryCellViewState, x> onTxRowClicked) {
        super(new TxHistoryItemCallback());
        kotlin.jvm.internal.m.g(onTxRowClicked, "onTxRowClicked");
        this.onTxRowClicked = onTxRowClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        RowType rowType;
        TxHistoryCellViewState item = getItem(i2);
        if (item instanceof TxHistoryCellViewState.Header) {
            rowType = RowType.HEADER;
        } else if (item instanceof TxHistoryCellViewState.Item) {
            rowType = RowType.ITEM;
        } else {
            throw new IllegalStateException("Unrecognized TxHistoryCellViewState");
        }
        return rowType.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        TxHistoryCellViewState item = getItem(i2);
        if (item instanceof TxHistoryCellViewState.Header) {
            ((TxHistoryHeaderViewHolder) holder).bind((TxHistoryCellViewState.Header) item, i2);
        } else if (item instanceof TxHistoryCellViewState.Item) {
            ((TxHistoryItemViewHolder) holder).bind((TxHistoryCellViewState.Item) item);
        } else {
            throw new IllegalStateException("Unrecognized TxHistoryCellViewState");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i2 == RowType.HEADER.getViewType()) {
            View view = from.inflate(R.layout.list_item__tx_history_header, parent, false);
            kotlin.jvm.internal.m.f(view, "view");
            return new TxHistoryHeaderViewHolder(view);
        } else if (i2 == RowType.ITEM.getViewType()) {
            View view2 = from.inflate(R.layout.list_item__tx_history_item, parent, false);
            kotlin.jvm.internal.m.f(view2, "view");
            return new TxHistoryItemViewHolder(view2, this.onTxRowClicked);
        } else {
            throw new IllegalStateException("Unrecognized RowType");
        }
    }
}