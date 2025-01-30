package com.coinbase.wallet.features.lend.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.extensions.List_CommonKt;
import com.coinbase.wallet.commonui.extensions.ImageView_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.commonui.views.ExpandingCardView;
import com.coinbase.wallet.features.commonui.views.RoundedCornerImageView;
import com.coinbase.wallet.features.lend.models.LendProviderItem;
import e.j.f.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.spongycastle.i18n.MessageBundle;
import org.toshi.R;

/* compiled from: LendProviderPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001-BY\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\b+\u0010,J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00062\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR%\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R%\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$¨\u0006."}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter$ProviderItemViewHolder;", "", "Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "providers", "Lkotlin/x;", "setItems", "(Ljava/util/List;)V", "", "position", "", "getItemId", "(I)J", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter$ProviderItemViewHolder;", "holder", "onBindViewHolder", "(Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter$ProviderItemViewHolder;I)V", "getItemCount", "()I", "Lkotlin/Function0;", "onAssetsClickListener", "Lkotlin/e0/c/a;", "getOnAssetsClickListener", "()Lkotlin/e0/c/a;", "onUtilizationClickListener", "getOnUtilizationClickListener", "Lkotlin/Function1;", "", "onProviderURLClickListener", "Lkotlin/e0/c/l;", "getOnProviderURLClickListener", "()Lkotlin/e0/c/l;", "onCollateralClickListener", "getOnCollateralClickListener", "", "Ljava/util/List;", "onProviderCardClickListener", "getOnProviderCardClickListener", "<init>", "(Lkotlin/e0/c/l;Lkotlin/e0/c/a;Lkotlin/e0/c/a;Lkotlin/e0/c/a;Lkotlin/e0/c/l;)V", "ProviderItemViewHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerAdapter extends RecyclerView.g<ProviderItemViewHolder> {
    private final kotlin.e0.c.a<x> onAssetsClickListener;
    private final kotlin.e0.c.a<x> onCollateralClickListener;
    private final l<LendProviderItem, x> onProviderCardClickListener;
    private final l<String, x> onProviderURLClickListener;
    private final kotlin.e0.c.a<x> onUtilizationClickListener;
    private final List<LendProviderItem> providers;

    /* compiled from: LendProviderPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter$ProviderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/View;", "view", "Lkotlin/Function0;", "Lkotlin/x;", "clickListener", "", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "", "cornerRadius", "setupInfoItem", "(Landroid/view/View;Lkotlin/e0/c/a;Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "provider", "bind", "(Lcom/coinbase/wallet/features/lend/models/LendProviderItem;)V", "Lcom/coinbase/wallet/features/commonui/views/ExpandingCardView;", "item", "Lcom/coinbase/wallet/features/commonui/views/ExpandingCardView;", "<init>", "(Lcom/coinbase/wallet/features/lend/views/adapters/LendProviderPickerAdapter;Lcom/coinbase/wallet/features/commonui/views/ExpandingCardView;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public final class ProviderItemViewHolder extends RecyclerView.e0 {
        private final ExpandingCardView item;
        final /* synthetic */ LendProviderPickerAdapter this$0;

        /* compiled from: LendProviderPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.lend.views.adapters.LendProviderPickerAdapter$ProviderItemViewHolder$1  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass1 extends o implements l<View, x> {
            final /* synthetic */ LendProviderPickerAdapter this$0;
            final /* synthetic */ ProviderItemViewHolder this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LendProviderPickerAdapter lendProviderPickerAdapter, ProviderItemViewHolder providerItemViewHolder) {
                super(1);
                this.this$0 = lendProviderPickerAdapter;
                this.this$1 = providerItemViewHolder;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                m.g(it, "it");
                this.this$0.getOnProviderCardClickListener().invoke(List_CommonKt.require(this.this$0.providers, this.this$1.getAdapterPosition()));
            }
        }

        /* compiled from: LendProviderPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.lend.views.adapters.LendProviderPickerAdapter$ProviderItemViewHolder$2  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass2 extends o implements l<View, x> {
            final /* synthetic */ LendProviderPickerAdapter this$0;
            final /* synthetic */ ProviderItemViewHolder this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LendProviderPickerAdapter lendProviderPickerAdapter, ProviderItemViewHolder providerItemViewHolder) {
                super(1);
                this.this$0 = lendProviderPickerAdapter;
                this.this$1 = providerItemViewHolder;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                m.g(it, "it");
                String url = ((LendProviderItem) List_CommonKt.require(this.this$0.providers, this.this$1.getAdapterPosition())).getWebsiteURL().toString();
                m.f(url, "providers.require(adapterPosition).websiteURL.toString()");
                this.this$0.getOnProviderURLClickListener().invoke(url);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProviderItemViewHolder(LendProviderPickerAdapter this$0, ExpandingCardView item) {
            super(item);
            m.g(this$0, "this$0");
            m.g(item, "item");
            this.this$0 = this$0;
            this.item = item;
            int pxSize = View_CommonKt.getPxSize(item, R.dimen.view_size_16);
            int i2 = e.j.a.staticItem;
            ConstraintLayout constraintLayout = (ConstraintLayout) item.findViewById(i2);
            m.f(constraintLayout, "item.staticItem");
            View_CommonKt.setRippleBackground$default(constraintLayout, pxSize, null, 2, null);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) item.findViewById(i2);
            m.f(constraintLayout2, "item.staticItem");
            View_CommonKt.setOnSingleClickListener$default(constraintLayout2, 0L, new AnonymousClass1(this$0, this), 1, null);
            TextView textView = (TextView) item.findViewById(e.j.a.providerURL);
            m.f(textView, "item.providerURL");
            View_CommonKt.setOnSingleClickListener$default(textView, 0L, new AnonymousClass2(this$0, this), 1, null);
            View findViewById = item.findViewById(e.j.a.providerAssets);
            m.f(findViewById, "item.providerAssets");
            setupInfoItem(findViewById, this$0.getOnAssetsClickListener(), y.d(item, R.string.provider_info_assets_title), y.d(item, R.string.provider_info_assets_description), pxSize);
            View findViewById2 = item.findViewById(e.j.a.providerCollateral);
            m.f(findViewById2, "item.providerCollateral");
            setupInfoItem(findViewById2, this$0.getOnCollateralClickListener(), y.d(item, R.string.provider_info_collateral_title), y.d(item, R.string.provider_info_collateral_description), pxSize);
            View findViewById3 = item.findViewById(e.j.a.providerUtilization);
            m.f(findViewById3, "item.providerUtilization");
            setupInfoItem(findViewById3, this$0.getOnUtilizationClickListener(), y.d(item, R.string.provider_info_utilization_title), y.d(item, R.string.provider_info_utilization_description), pxSize);
        }

        private final void setupInfoItem(View view, kotlin.e0.c.a<x> aVar, String str, String str2, int i2) {
            View_CommonKt.setRippleBackground$default(view, i2, null, 2, null);
            View_CommonKt.setOnSingleClickListener$default(view, 0L, new LendProviderPickerAdapter$ProviderItemViewHolder$setupInfoItem$1(aVar), 1, null);
            ((TextView) view.findViewById(e.j.a.infoTitle)).setText(str);
            ((TextView) view.findViewById(e.j.a.infoDescription)).setText(str2);
        }

        public final void bind(LendProviderItem provider) {
            m.g(provider, "provider");
            RoundedCornerImageView roundedCornerImageView = (RoundedCornerImageView) this.item.findViewById(e.j.a.avatar);
            m.f(roundedCornerImageView, "item.avatar");
            ImageView_CommonKt.load$default(roundedCornerImageView, provider.getToken().getProviderImageURL().toString(), 0, null, 6, null);
            ((TextView) this.item.findViewById(e.j.a.providerURL)).setText(provider.getWebsiteHostname());
            ((TextView) this.item.findViewById(e.j.a.providerName)).setText(provider.getTitle());
            ((TextView) this.item.findViewById(e.j.a.providerAPR)).setText(provider.getSupplyRateText());
            View findViewById = this.item.findViewById(e.j.a.providerAssets);
            int i2 = e.j.a.infoValue;
            ((TextView) findViewById.findViewById(i2)).setText(provider.getTotalSupply());
            ((TextView) this.item.findViewById(e.j.a.providerUtilization).findViewById(i2)).setText(provider.getUtilization());
            if (provider.isCollateralApplicable()) {
                ((TextView) this.item.findViewById(e.j.a.providerCollateral).findViewById(i2)).setText(provider.getCollateralRate());
            } else {
                ((TextView) this.item.findViewById(e.j.a.providerCollateral).findViewById(i2)).setText(this.item.getContext().getString(R.string.provider_prompt_not_applicable));
            }
            if (provider.getExpanded()) {
                this.item.expand();
            } else {
                this.item.collapse();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LendProviderPickerAdapter(l<? super LendProviderItem, x> onProviderCardClickListener, kotlin.e0.c.a<x> onAssetsClickListener, kotlin.e0.c.a<x> onUtilizationClickListener, kotlin.e0.c.a<x> onCollateralClickListener, l<? super String, x> onProviderURLClickListener) {
        m.g(onProviderCardClickListener, "onProviderCardClickListener");
        m.g(onAssetsClickListener, "onAssetsClickListener");
        m.g(onUtilizationClickListener, "onUtilizationClickListener");
        m.g(onCollateralClickListener, "onCollateralClickListener");
        m.g(onProviderURLClickListener, "onProviderURLClickListener");
        this.onProviderCardClickListener = onProviderCardClickListener;
        this.onAssetsClickListener = onAssetsClickListener;
        this.onUtilizationClickListener = onUtilizationClickListener;
        this.onCollateralClickListener = onCollateralClickListener;
        this.onProviderURLClickListener = onProviderURLClickListener;
        this.providers = new ArrayList();
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.providers.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return ((LendProviderItem) List_CommonKt.require(this.providers, i2)).getToken().getId().hashCode();
    }

    public final kotlin.e0.c.a<x> getOnAssetsClickListener() {
        return this.onAssetsClickListener;
    }

    public final kotlin.e0.c.a<x> getOnCollateralClickListener() {
        return this.onCollateralClickListener;
    }

    public final l<LendProviderItem, x> getOnProviderCardClickListener() {
        return this.onProviderCardClickListener;
    }

    public final l<String, x> getOnProviderURLClickListener() {
        return this.onProviderURLClickListener;
    }

    public final kotlin.e0.c.a<x> getOnUtilizationClickListener() {
        return this.onUtilizationClickListener;
    }

    public final void setItems(List<LendProviderItem> providers) {
        m.g(providers, "providers");
        this.providers.clear();
        this.providers.addAll(providers);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(ProviderItemViewHolder holder, int i2) {
        m.g(holder, "holder");
        holder.bind(this.providers.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public ProviderItemViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__lend_provider, parent, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.coinbase.wallet.features.commonui.views.ExpandingCardView");
        return new ProviderItemViewHolder(this, (ExpandingCardView) inflate);
    }
}