package com.coinbase.wallet.txhistory.views;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.txhistory.models.TxHistoryCellViewState;
import h.c.s;
import h.c.t0.g;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.t;
import kotlin.x;

/* compiled from: TxHistoryItemViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b*\u0010+J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001b\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001d\u0010\u001e\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001d\u0010)\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Item;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Item;)V", "onRecycled", "()V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState;", "onTxRowClicked", "Lkotlin/e0/c/l;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Landroid/widget/TextView;", "cryptoAmount$delegate", "Lkotlin/h;", "getCryptoAmount", "()Landroid/widget/TextView;", "cryptoAmount", "Landroid/view/View;", "view", "Landroid/view/View;", "name$delegate", "getName", ApiConstants.NAME, "fiatAmount$delegate", "getFiatAmount", "fiatAmount", "Lcom/coinbase/wallet/txhistory/views/RecipientImageView;", "iconView$delegate", "getIconView", "()Lcom/coinbase/wallet/txhistory/views/RecipientImageView;", "iconView", "time$delegate", "getTime", ApiConstants.TIME, "failedLabel$delegate", "getFailedLabel", "failedLabel", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryItemViewHolder extends RecyclerView.e0 {
    private final h cryptoAmount$delegate;
    private final h.c.k0.a disposeBag;
    private final h failedLabel$delegate;
    private final h fiatAmount$delegate;
    private final h iconView$delegate;
    private final h name$delegate;
    private final l<TxHistoryCellViewState, x> onTxRowClicked;
    private final h time$delegate;
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TxHistoryItemViewHolder(View view, l<? super TxHistoryCellViewState, x> onTxRowClicked) {
        super(view);
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        h b7;
        m.g(view, "view");
        m.g(onTxRowClicked, "onTxRowClicked");
        this.view = view;
        this.onTxRowClicked = onTxRowClicked;
        b2 = k.b(new TxHistoryItemViewHolder$iconView$2(this));
        this.iconView$delegate = b2;
        b3 = k.b(new TxHistoryItemViewHolder$name$2(this));
        this.name$delegate = b3;
        b4 = k.b(new TxHistoryItemViewHolder$time$2(this));
        this.time$delegate = b4;
        b5 = k.b(new TxHistoryItemViewHolder$fiatAmount$2(this));
        this.fiatAmount$delegate = b5;
        b6 = k.b(new TxHistoryItemViewHolder$cryptoAmount$2(this));
        this.cryptoAmount$delegate = b6;
        b7 = k.b(new TxHistoryItemViewHolder$failedLabel$2(this));
        this.failedLabel$delegate = b7;
        this.disposeBag = new h.c.k0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m1790bind$lambda0(TxHistoryItemViewHolder this$0, TxHistoryCellViewState.Item item, View view) {
        m.g(this$0, "this$0");
        m.g(item, "$item");
        this$0.onTxRowClicked.invoke(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getCryptoAmount() {
        Object value = this.cryptoAmount$delegate.getValue();
        m.f(value, "<get-cryptoAmount>(...)");
        return (TextView) value;
    }

    private final TextView getFailedLabel() {
        Object value = this.failedLabel$delegate.getValue();
        m.f(value, "<get-failedLabel>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getFiatAmount() {
        Object value = this.fiatAmount$delegate.getValue();
        m.f(value, "<get-fiatAmount>(...)");
        return (TextView) value;
    }

    private final RecipientImageView getIconView() {
        Object value = this.iconView$delegate.getValue();
        m.f(value, "<get-iconView>(...)");
        return (RecipientImageView) value;
    }

    private final TextView getName() {
        Object value = this.name$delegate.getValue();
        m.f(value, "<get-name>(...)");
        return (TextView) value;
    }

    private final TextView getTime() {
        Object value = this.time$delegate.getValue();
        m.f(value, "<get-time>(...)");
        return (TextView) value;
    }

    public final void bind(final TxHistoryCellViewState.Item item) {
        m.g(item, "item");
        this.disposeBag.d();
        getName().setText(item.getEntity());
        getTime().setText(item.getDate());
        getIconView().update(item.getRecipientType(), item.getEntity());
        getFailedLabel().setVisibility(item.isFailure() ? 0 : 8);
        getFiatAmount().setVisibility(item.isFailure() ^ true ? 0 : 8);
        getCryptoAmount().setVisibility(item.isFailure() ^ true ? 0 : 8);
        TextView fiatAmount = getFiatAmount();
        Strings strings = Strings.INSTANCE;
        fiatAmount.setText(Strings_CoreKt.getEmpty(strings));
        getCryptoAmount().setText(Strings_CoreKt.getEmpty(strings));
        this.view.setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.txhistory.views.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TxHistoryItemViewHolder.m1790bind$lambda0(TxHistoryItemViewHolder.this, item, view);
            }
        });
        if (item.isFailure()) {
            return;
        }
        s<t<String, Optional<String>, Integer>> observeOn = item.getAmountsObservable().observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "item.amountsObservable\n                .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(g.h(observeOn, null, null, new TxHistoryItemViewHolder$bind$2(this), 3, null), this.disposeBag);
    }

    public final void onRecycled() {
        this.disposeBag.d();
    }
}