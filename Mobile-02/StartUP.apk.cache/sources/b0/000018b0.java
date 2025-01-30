package com.coinbase.wallet.consumer.views.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.Context_ConsumerKt;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerCoinCellViewState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;

/* compiled from: ConsumerAccountsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001b\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\r¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerSupportedCryptoAccountViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;)V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "supportedAccountClickListener", "Lkotlin/e0/c/l;", "Landroid/widget/TextView;", "cryptoBalance", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "black$delegate", "Lkotlin/h;", "getBlack", "()Landroid/content/res/ColorStateList;", "black", ApiConstants.NAME, "fiatBalance", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "blue$delegate", "getBlue", "blue", "symbol", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSupportedCryptoAccountViewHolder extends RecyclerView.e0 {
    private final h black$delegate;
    private final h blue$delegate;
    private final TextView cryptoBalance;
    private final TextView fiatBalance;
    private final ImageView icon;
    private final TextView name;
    private final l<ConsumerAccount, x> supportedAccountClickListener;
    private final TextView symbol;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConsumerSupportedCryptoAccountViewHolder(View view, l<? super ConsumerAccount, x> supportedAccountClickListener) {
        super(view);
        h b2;
        h b3;
        m.g(view, "view");
        m.g(supportedAccountClickListener, "supportedAccountClickListener");
        this.supportedAccountClickListener = supportedAccountClickListener;
        View findViewById = view.findViewById(R.id.icon);
        m.f(findViewById, "view.findViewById(R.id.icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        m.f(findViewById2, "view.findViewById(R.id.name)");
        this.name = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.symbol);
        m.f(findViewById3, "view.findViewById(R.id.symbol)");
        this.symbol = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.fiatBalance);
        m.f(findViewById4, "view.findViewById(R.id.fiatBalance)");
        this.fiatBalance = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.cryptoBalance);
        m.f(findViewById5, "view.findViewById(R.id.cryptoBalance)");
        this.cryptoBalance = (TextView) findViewById5;
        b2 = k.b(new ConsumerSupportedCryptoAccountViewHolder$blue$2(this));
        this.blue$delegate = b2;
        b3 = k.b(new ConsumerSupportedCryptoAccountViewHolder$black$2(this));
        this.black$delegate = b3;
    }

    private final ColorStateList getBlack() {
        return (ColorStateList) this.black$delegate.getValue();
    }

    private final ColorStateList getBlue() {
        return (ColorStateList) this.blue$delegate.getValue();
    }

    public final void bind(ConsumerCoinCellViewState item) {
        Drawable drawable;
        m.g(item, "item");
        this.itemView.setClickable(item.isTappable());
        View view = this.itemView;
        if (item.isTappable()) {
            Context context = this.itemView.getContext();
            m.f(context, "itemView.context");
            drawable = Context_ConsumerKt.getAttrDrawable(context, R.attr.selectableItemBackground);
        } else {
            drawable = null;
        }
        view.setBackground(drawable);
        if (item.isTappable()) {
            View itemView = this.itemView;
            m.f(itemView, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new ConsumerSupportedCryptoAccountViewHolder$bind$1(this, item), 1, null);
        }
        Glide.with(this.itemView).load(item.getImageURL()).into(this.icon);
        this.name.setText(item.getName());
        this.symbol.setText(item.getCode().getCode());
        if (item.getPlaceholderText() == null) {
            this.fiatBalance.setText(item.getFiatBalanceText());
            this.cryptoBalance.setText(item.getCryptoBalanceText());
            this.cryptoBalance.setVisibility(0);
            this.fiatBalance.setTextColor(getBlack());
            return;
        }
        this.fiatBalance.setText(item.getPlaceholderText());
        this.cryptoBalance.setVisibility(8);
        this.fiatBalance.setTextColor(getBlue());
    }
}