package com.coinbase.wallet.consumer.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerCoinCellSectionViewState;
import com.coinbase.wallet.consumer.models.ConsumerCoinCellViewState;
import com.coinbase.wallet.consumer.models.SectionHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: ConsumerAccountsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u001b\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00110 ¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00110 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAccountsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/ViewGroup;", "parent", "Lcom/coinbase/wallet/consumer/views/adapter/SectionHeaderViewHolder;", "createSectionHeaderViewHolder", "(Landroid/view/ViewGroup;)Lcom/coinbase/wallet/consumer/views/adapter/SectionHeaderViewHolder;", "Lcom/coinbase/wallet/consumer/views/adapter/ConsumerSupportedCryptoAccountViewHolder;", "createConsumerSupportedCryptoAccountViewHolder", "(Landroid/view/ViewGroup;)Lcom/coinbase/wallet/consumer/views/adapter/ConsumerSupportedCryptoAccountViewHolder;", "Lcom/coinbase/wallet/consumer/views/adapter/ConsumerUnsupportedCryptoAccountViewHolder;", "createConsumerUnsupportedCryptoAccountViewHolder", "(Landroid/view/ViewGroup;)Lcom/coinbase/wallet/consumer/views/adapter/ConsumerUnsupportedCryptoAccountViewHolder;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellSectionViewState;", "newList", "Lkotlin/x;", "setItemsAndNotifyDataSetChanged", "(Ljava/util/List;)V", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "supportedAccountClickListener", "Lkotlin/e0/c/l;", "", "itemList", "Ljava/util/List;", "<init>", "(Lkotlin/e0/c/l;)V", "AccountsSectionType", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsAdapter extends RecyclerView.g<RecyclerView.e0> {
    private final List<ConsumerCoinCellSectionViewState> itemList;
    private final l<ConsumerAccount, x> supportedAccountClickListener;

    /* compiled from: ConsumerAccountsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAccountsAdapter$AccountsSectionType;", "", "<init>", "(Ljava/lang/String;I)V", "SECTION_HEADER", "SUPPORTED_ACCOUNT", "UNSUPPORTED_ACCOUNT", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum AccountsSectionType {
        SECTION_HEADER,
        SUPPORTED_ACCOUNT,
        UNSUPPORTED_ACCOUNT
    }

    /* compiled from: ConsumerAccountsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountsSectionType.values().length];
            iArr[AccountsSectionType.SECTION_HEADER.ordinal()] = 1;
            iArr[AccountsSectionType.SUPPORTED_ACCOUNT.ordinal()] = 2;
            iArr[AccountsSectionType.UNSUPPORTED_ACCOUNT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConsumerAccountsAdapter(l<? super ConsumerAccount, x> supportedAccountClickListener) {
        m.g(supportedAccountClickListener, "supportedAccountClickListener");
        this.supportedAccountClickListener = supportedAccountClickListener;
        this.itemList = new ArrayList();
    }

    private final ConsumerSupportedCryptoAccountViewHolder createConsumerSupportedCryptoAccountViewHolder(ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item__supported_consumer_account, viewGroup, false);
        m.f(v, "v");
        return new ConsumerSupportedCryptoAccountViewHolder(v, this.supportedAccountClickListener);
    }

    private final ConsumerUnsupportedCryptoAccountViewHolder createConsumerUnsupportedCryptoAccountViewHolder(ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item__unsupported_consumer_account, viewGroup, false);
        m.f(v, "v");
        return new ConsumerUnsupportedCryptoAccountViewHolder(v);
    }

    private final SectionHeaderViewHolder createSectionHeaderViewHolder(ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.account_section_header, viewGroup, false);
        m.f(v, "v");
        return new SectionHeaderViewHolder(v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        ConsumerCoinCellSectionViewState consumerCoinCellSectionViewState = this.itemList.get(i2);
        if (consumerCoinCellSectionViewState instanceof SectionHeader) {
            return AccountsSectionType.SECTION_HEADER.ordinal();
        }
        if (consumerCoinCellSectionViewState instanceof ConsumerCoinCellViewState) {
            if (((ConsumerCoinCellViewState) consumerCoinCellSectionViewState).isSupported()) {
                return AccountsSectionType.SUPPORTED_ACCOUNT.ordinal();
            }
            return AccountsSectionType.UNSUPPORTED_ACCOUNT.ordinal();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        m.g(holder, "holder");
        ConsumerCoinCellSectionViewState consumerCoinCellSectionViewState = this.itemList.get(i2);
        if (consumerCoinCellSectionViewState instanceof SectionHeader) {
            ((SectionHeaderViewHolder) holder).bind((SectionHeader) consumerCoinCellSectionViewState);
        } else if (consumerCoinCellSectionViewState instanceof ConsumerCoinCellViewState) {
            ConsumerCoinCellViewState consumerCoinCellViewState = (ConsumerCoinCellViewState) consumerCoinCellSectionViewState;
            if (consumerCoinCellViewState.isSupported()) {
                ((ConsumerSupportedCryptoAccountViewHolder) holder).bind(consumerCoinCellViewState);
            } else {
                ((ConsumerUnsupportedCryptoAccountViewHolder) holder).bind(consumerCoinCellViewState);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        int i3 = WhenMappings.$EnumSwitchMapping$0[AccountsSectionType.values()[i2].ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return createConsumerUnsupportedCryptoAccountViewHolder(parent);
                }
                throw new NoWhenBranchMatchedException();
            }
            return createConsumerSupportedCryptoAccountViewHolder(parent);
        }
        return createSectionHeaderViewHolder(parent);
    }

    public final void setItemsAndNotifyDataSetChanged(List<? extends ConsumerCoinCellSectionViewState> newList) {
        m.g(newList, "newList");
        this.itemList.clear();
        this.itemList.addAll(newList);
        notifyDataSetChanged();
    }
}