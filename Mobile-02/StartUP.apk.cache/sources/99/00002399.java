package com.coinbase.wallet.features.wallets.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.commonui.views.TokenAvatarView;
import com.coinbase.wallet.features.wallets.models.ListItem;
import e.j.f.u;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006 !\"#$%BU\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter;", "Landroidx/recyclerview/widget/m;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "position", "", "getItemId", "(I)J", "getItemViewType", "(I)I", "holder", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "Lkotlin/Function1;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "onWalletItemClickListener", "Lkotlin/e0/c/l;", "Lkotlin/Function0;", "onLendItemClickListener", "Lkotlin/e0/c/a;", "onFundItemClickListener", "", "items", "<init>", "(Ljava/util/List;Lkotlin/e0/c/a;Lkotlin/e0/c/a;Lkotlin/e0/c/l;)V", "FundItemViewHolder", "LendItemViewHolder", "ListItemDiffCallback", "SectionHeaderItemViewHolder", "SectionType", "WalletItemViewHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletAdapter extends m<ListItem, RecyclerView.e0> {
    private final a<x> onFundItemClickListener;
    private final a<x> onLendItemClickListener;
    private final l<ListItem.WalletListItem, x> onWalletItemClickListener;

    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter$FundItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$FundListItem;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/wallets/models/ListItem$FundListItem;)V", "Landroid/view/View;", "view", "Lkotlin/Function0;", "onClickListener", "<init>", "(Landroid/view/View;Lkotlin/e0/c/a;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class FundItemViewHolder extends RecyclerView.e0 {

        /* compiled from: WalletAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.wallets.views.adapters.WalletAdapter$FundItemViewHolder$1  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass1 extends o implements l<View, x> {
            final /* synthetic */ a<x> $onClickListener;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(a<x> aVar) {
                super(1);
                this.$onClickListener = aVar;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                this.$onClickListener.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FundItemViewHolder(View view, a<x> onClickListener) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
            kotlin.jvm.internal.m.g(onClickListener, "onClickListener");
            View itemView = this.itemView;
            kotlin.jvm.internal.m.f(itemView, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new AnonymousClass1(onClickListener), 1, null);
        }

        public final void bind(ListItem.FundListItem item) {
            kotlin.jvm.internal.m.g(item, "item");
            ((TextView) this.itemView.findViewById(e.j.a.fundTitle)).setText(item.getTitle());
            ((TextView) this.itemView.findViewById(e.j.a.fundDescription)).setText(item.getDescription());
        }
    }

    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter$LendItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$LendListItem;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/wallets/models/ListItem$LendListItem;)V", "Landroid/view/View;", "view", "Lkotlin/Function0;", "onClickListener", "<init>", "(Landroid/view/View;Lkotlin/e0/c/a;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class LendItemViewHolder extends RecyclerView.e0 {

        /* compiled from: WalletAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.wallets.views.adapters.WalletAdapter$LendItemViewHolder$1  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass1 extends o implements l<View, x> {
            final /* synthetic */ a<x> $onClickListener;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(a<x> aVar) {
                super(1);
                this.$onClickListener = aVar;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                this.$onClickListener.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LendItemViewHolder(View view, a<x> onClickListener) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
            kotlin.jvm.internal.m.g(onClickListener, "onClickListener");
            View itemView = this.itemView;
            kotlin.jvm.internal.m.f(itemView, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new AnonymousClass1(onClickListener), 1, null);
        }

        public final void bind(ListItem.LendListItem item) {
            kotlin.jvm.internal.m.g(item, "item");
            View view = this.itemView;
            ((TextView) view.findViewById(e.j.a.lendItemTitle)).setText(item.getTitle());
            ((TextView) view.findViewById(e.j.a.lendItemDescription)).setText(item.getDescription());
            int i2 = e.j.a.lendFiatValue;
            ((TextView) view.findViewById(i2)).setText(item.getFiatBalance());
            TextView lendFiatValue = (TextView) view.findViewById(i2);
            kotlin.jvm.internal.m.f(lendFiatValue, "lendFiatValue");
            lendFiatValue.setVisibility(item.getFiatBalance().length() > 0 ? 0 : 8);
        }
    }

    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter$ListItemDiffCallback;", "Landroidx/recyclerview/widget/h$d;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/coinbase/wallet/features/wallets/models/ListItem;Lcom/coinbase/wallet/features/wallets/models/ListItem;)Z", "areContentsTheSame", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class ListItemDiffCallback extends h.d<ListItem> {
        @Override // androidx.recyclerview.widget.h.d
        public boolean areContentsTheSame(ListItem oldItem, ListItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if ((oldItem instanceof ListItem.SectionHeader) && (newItem instanceof ListItem.SectionHeader)) {
                return kotlin.jvm.internal.m.c(((ListItem.SectionHeader) oldItem).getTitle(), ((ListItem.SectionHeader) newItem).getTitle());
            }
            if ((oldItem instanceof ListItem.FundListItem) && (newItem instanceof ListItem.FundListItem)) {
                ListItem.FundListItem fundListItem = (ListItem.FundListItem) oldItem;
                ListItem.FundListItem fundListItem2 = (ListItem.FundListItem) newItem;
                if (kotlin.jvm.internal.m.c(fundListItem.getTitle(), fundListItem2.getTitle()) && kotlin.jvm.internal.m.c(fundListItem.getDescription(), fundListItem2.getDescription())) {
                    return true;
                }
            } else if ((oldItem instanceof ListItem.LendListItem) && (newItem instanceof ListItem.LendListItem)) {
                ListItem.LendListItem lendListItem = (ListItem.LendListItem) oldItem;
                ListItem.LendListItem lendListItem2 = (ListItem.LendListItem) newItem;
                if (kotlin.jvm.internal.m.c(lendListItem.getTitle(), lendListItem2.getTitle()) && kotlin.jvm.internal.m.c(lendListItem.getDescription(), lendListItem2.getDescription()) && kotlin.jvm.internal.m.c(lendListItem.getFiatBalance(), lendListItem2.getFiatBalance())) {
                    return true;
                }
            } else if ((oldItem instanceof ListItem.WalletListItem) && (newItem instanceof ListItem.WalletListItem)) {
                ListItem.WalletListItem walletListItem = (ListItem.WalletListItem) oldItem;
                ListItem.WalletListItem walletListItem2 = (ListItem.WalletListItem) newItem;
                if (kotlin.jvm.internal.m.c(walletListItem.getWallet().getCurrencyCode().getRawValue(), walletListItem2.getWallet().getCurrencyCode().getRawValue()) && kotlin.jvm.internal.m.c(walletListItem.getWallet().getDisplayName(), walletListItem2.getWallet().getDisplayName()) && kotlin.jvm.internal.m.c(walletListItem.getWallet().getImageURL(), walletListItem2.getWallet().getImageURL()) && kotlin.jvm.internal.m.c(walletListItem.getFiatBalance(), walletListItem2.getFiatBalance()) && kotlin.jvm.internal.m.c(walletListItem.getCryptoBalance(), walletListItem2.getCryptoBalance())) {
                    return true;
                }
            } else {
                throw new IllegalStateException("Old item and new item must be of the same type".toString());
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areItemsTheSame(ListItem oldItem, ListItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            return kotlin.jvm.internal.m.c(oldItem.getId(), newItem.getId());
        }
    }

    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter$SectionHeaderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$SectionHeader;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/wallets/models/ListItem$SectionHeader;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class SectionHeaderItemViewHolder extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeaderItemViewHolder(View view) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
        }

        public final void bind(ListItem.SectionHeader item) {
            kotlin.jvm.internal.m.g(item, "item");
            ((AppCompatTextView) this.itemView.findViewById(e.j.a.K6)).setText(item.getTitle());
        }
    }

    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter$SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "HEADER", "FUND", "LEND", "WALLET", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum SectionType {
        HEADER,
        FUND,
        LEND,
        WALLET
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/wallets/views/adapters/WalletAdapter$WalletItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;)V", "Landroid/view/View;", "view", "Lkotlin/Function1;", "", "onClickListener", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class WalletItemViewHolder extends RecyclerView.e0 {

        /* compiled from: WalletAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.wallets.views.adapters.WalletAdapter$WalletItemViewHolder$1  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass1 extends o implements l<View, x> {
            final /* synthetic */ l<Integer, x> $onClickListener;
            final /* synthetic */ WalletItemViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(l<? super Integer, x> lVar, WalletItemViewHolder walletItemViewHolder) {
                super(1);
                this.$onClickListener = lVar;
                this.this$0 = walletItemViewHolder;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                this.$onClickListener.invoke(Integer.valueOf(this.this$0.getAdapterPosition()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WalletItemViewHolder(View view, l<? super Integer, x> onClickListener) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
            kotlin.jvm.internal.m.g(onClickListener, "onClickListener");
            View itemView = this.itemView;
            kotlin.jvm.internal.m.f(itemView, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new AnonymousClass1(onClickListener, this), 1, null);
        }

        public final void bind(ListItem.WalletListItem item) {
            kotlin.jvm.internal.m.g(item, "item");
            Wallet wallet = item.getWallet();
            View view = this.itemView;
            ((TextView) view.findViewById(e.j.a.tokenName)).setText(wallet.getDisplayName());
            ((TextView) view.findViewById(e.j.a.tokenTicker)).setText(wallet.getCurrencyCode().getCode());
            ((TextView) view.findViewById(e.j.a.tokenAmount)).setText(u.g(item.getCryptoBalance(), 30, null, 2, null));
            ((TextView) view.findViewById(e.j.a.tokenFiatValue)).setText(item.getFiatBalance());
            TokenAvatarView tokenAvatarView = (TokenAvatarView) view.findViewById(e.j.a.avatar);
            String code = wallet.getCurrencyCode().getCode();
            URL imageURL = wallet.getImageURL();
            tokenAvatarView.load(code, imageURL != null ? imageURL.toString() : null);
        }
    }

    /* compiled from: WalletAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionType.values().length];
            iArr[SectionType.HEADER.ordinal()] = 1;
            iArr[SectionType.FUND.ordinal()] = 2;
            iArr[SectionType.LEND.ordinal()] = 3;
            iArr[SectionType.WALLET.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public WalletAdapter() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ WalletAdapter(List list, a aVar, a aVar2, l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : aVar, (i2 & 4) != 0 ? null : aVar2, (i2 & 8) != 0 ? null : lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return getItem(i2).getId().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        SectionType sectionType;
        ListItem item = getItem(i2);
        if (item instanceof ListItem.SectionHeader) {
            sectionType = SectionType.HEADER;
        } else if (item instanceof ListItem.FundListItem) {
            sectionType = SectionType.FUND;
        } else if (item instanceof ListItem.LendListItem) {
            sectionType = SectionType.LEND;
        } else if (!(item instanceof ListItem.WalletListItem)) {
            throw new NoWhenBranchMatchedException();
        } else {
            sectionType = SectionType.WALLET;
        }
        return sectionType.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        ListItem item = getItem(i2);
        if (item instanceof ListItem.SectionHeader) {
            ((SectionHeaderItemViewHolder) holder).bind((ListItem.SectionHeader) item);
        } else if (item instanceof ListItem.FundListItem) {
            ((FundItemViewHolder) holder).bind((ListItem.FundListItem) item);
        } else if (item instanceof ListItem.LendListItem) {
            ((LendItemViewHolder) holder).bind((ListItem.LendListItem) item);
        } else if (item instanceof ListItem.WalletListItem) {
            ((WalletItemViewHolder) holder).bind((ListItem.WalletListItem) item);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[SectionType.values()[i2].ordinal()];
        if (i3 == 1) {
            View itemView = from.inflate(R.layout.list_item__wallets_section_title, parent, false);
            kotlin.jvm.internal.m.f(itemView, "itemView");
            return new SectionHeaderItemViewHolder(itemView);
        } else if (i3 == 2) {
            View itemView2 = from.inflate(R.layout.list_item__fund, parent, false);
            kotlin.jvm.internal.m.f(itemView2, "itemView");
            return new FundItemViewHolder(itemView2, new WalletAdapter$onCreateViewHolder$1(this));
        } else if (i3 == 3) {
            View itemView3 = from.inflate(R.layout.list_item__lend, parent, false);
            kotlin.jvm.internal.m.f(itemView3, "itemView");
            return new LendItemViewHolder(itemView3, new WalletAdapter$onCreateViewHolder$2(this));
        } else if (i3 == 4) {
            View itemView4 = from.inflate(R.layout.list_item__coin, parent, false);
            kotlin.jvm.internal.m.f(itemView4, "itemView");
            return new WalletItemViewHolder(itemView4, new WalletAdapter$onCreateViewHolder$3(this));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WalletAdapter(List<? extends ListItem> list, a<x> aVar, a<x> aVar2, l<? super ListItem.WalletListItem, x> lVar) {
        super(new ListItemDiffCallback());
        this.onLendItemClickListener = aVar;
        this.onFundItemClickListener = aVar2;
        this.onWalletItemClickListener = lVar;
        setHasStableIds(true);
        if (list != null) {
            submitList(list);
        }
    }
}