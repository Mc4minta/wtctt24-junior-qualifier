package com.coinbase.wallet.features.lend.views.adapters;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.application.view.custom.RoundedCornerImageView;
import com.coinbase.wallet.commonui.extensions.ImageView_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.lend.models.LendDashboardItem;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.jvm.internal.e0;
import kotlin.l0.y;
import kotlin.o;
import kotlin.u;
import kotlin.x;
import org.toshi.R;

/* compiled from: DashboardListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006\u001e\u001f !\"#B\u001b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter;", "Landroidx/recyclerview/widget/m;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "position", "getItemViewType", "(I)I", "holder", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "", "", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$e0;ILjava/util/List;)V", "", "getItemId", "(I)J", "Lkotlin/Function1;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "onItemClickListener", "Lkotlin/e0/c/l;", "<init>", "(Lkotlin/e0/c/l;)V", "BalanceViewHolder", "BlankItemViewHolder", "LendingDashboardItemCallback", "ProviderViewHolder", "SectionType", "TokenViewHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DashboardListAdapter extends m<LendDashboardItem, RecyclerView.e0> {
    private final l<LendDashboardItem.Provider, x> onItemClickListener;

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$BalanceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "balanceStr", "symbol", AppsFlyerProperties.CURRENCY_CODE, "Landroid/text/SpannableString;", "applySuperScriptIfNeeded", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Balance;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Balance;)V", "Landroid/view/View;", "lendBlob", "Landroid/view/View;", "Landroid/widget/TextView;", "lendAPR", "Landroid/widget/TextView;", "zeroBalanceBlob", "balance", "itemView", "<init>", "(Landroid/view/View;)V", "TopAlignSuperscriptSpan", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BalanceViewHolder extends RecyclerView.e0 {
        private final TextView balance;
        private final TextView lendAPR;
        private final View lendBlob;
        private final View zeroBalanceBlob;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DashboardListAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$BalanceViewHolder$TopAlignSuperscriptSpan;", "Landroid/text/style/SuperscriptSpan;", "Landroid/text/TextPaint;", "tp", "Lkotlin/x;", "updateDrawState", "(Landroid/text/TextPaint;)V", "updateMeasureState", "", "sizeRatio", "F", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class TopAlignSuperscriptSpan extends SuperscriptSpan {
            private final float sizeRatio = 0.33333334f;

            @Override // android.text.style.SuperscriptSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint tp) {
                kotlin.jvm.internal.m.g(tp, "tp");
                float ascent = tp.ascent();
                tp.setTextSize(tp.getTextSize() * this.sizeRatio);
                tp.baselineShift += (int) ((ascent - tp.ascent()) + ((tp.getFontMetrics().bottom - tp.getFontMetrics().top) * this.sizeRatio));
            }

            @Override // android.text.style.SuperscriptSpan, android.text.style.MetricAffectingSpan
            public void updateMeasureState(TextPaint tp) {
                kotlin.jvm.internal.m.g(tp, "tp");
                updateDrawState(tp);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BalanceViewHolder(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(e.j.a.dashboardBalance);
            kotlin.jvm.internal.m.f(textView, "itemView.dashboardBalance");
            this.balance = textView;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.lendAPR);
            kotlin.jvm.internal.m.f(textView2, "itemView.lendAPR");
            this.lendAPR = textView2;
            View findViewById = itemView.findViewById(e.j.a.interestBlob);
            kotlin.jvm.internal.m.f(findViewById, "itemView.interestBlob");
            this.lendBlob = findViewById;
            ImageView imageView = (ImageView) itemView.findViewById(e.j.a.zeroBalanceBackground);
            kotlin.jvm.internal.m.f(imageView, "itemView.zeroBalanceBackground");
            this.zeroBalanceBlob = imageView;
        }

        private final SpannableString applySuperScriptIfNeeded(String str, String str2, String str3) {
            boolean V;
            int i0;
            if (kotlin.jvm.internal.m.c(str3, str2)) {
                return new SpannableString(str);
            }
            V = y.V(str, str2, false, 2, null);
            if (V) {
                i0 = y.i0(str, str2, 0, false, 6, null);
                o a = u.a(Integer.valueOf(i0), Integer.valueOf(i0 + str2.length()));
                int intValue = ((Number) a.a()).intValue();
                int intValue2 = ((Number) a.b()).intValue();
                TopAlignSuperscriptSpan topAlignSuperscriptSpan = new TopAlignSuperscriptSpan();
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(androidx.core.content.a.d(this.itemView.getContext(), R.color.white_alpha_50));
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(topAlignSuperscriptSpan, intValue, intValue2, 33);
                spannableString.setSpan(foregroundColorSpan, intValue, intValue2, 33);
                return spannableString;
            }
            return new SpannableString(str);
        }

        public final void bind(LendDashboardItem.Balance item) {
            kotlin.jvm.internal.m.g(item, "item");
            this.balance.setText(applySuperScriptIfNeeded(item.getBalance(), item.getFiatSymbol(), item.getFiatCurrencyCode().getRawValue()));
            this.lendAPR.setText(item.getLendAPR());
            this.lendBlob.setVisibility(item.getZeroBalance() ? 4 : 0);
            this.zeroBalanceBlob.setVisibility(item.getZeroBalance() ? 0 : 8);
        }
    }

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$BlankItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BlankItemViewHolder extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BlankItemViewHolder(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
        }
    }

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$LendingDashboardItemCallback;", "Landroidx/recyclerview/widget/h$d;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;)Z", "", "getChangePayload", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;)Ljava/lang/Object;", "areContentsTheSame", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class LendingDashboardItemCallback extends h.d<LendDashboardItem> {
        @Override // androidx.recyclerview.widget.h.d
        public Object getChangePayload(LendDashboardItem oldItem, LendDashboardItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            return newItem;
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areContentsTheSame(LendDashboardItem oldItem, LendDashboardItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (oldItem instanceof LendDashboardItem.Balance) {
                return kotlin.jvm.internal.m.c((LendDashboardItem.Balance) newItem, oldItem);
            }
            if (oldItem instanceof LendDashboardItem.Provider) {
                return kotlin.jvm.internal.m.c((LendDashboardItem.Provider) newItem, oldItem);
            }
            if (oldItem instanceof LendDashboardItem.Token) {
                return kotlin.jvm.internal.m.c((LendDashboardItem.Token) newItem, oldItem);
            }
            if (oldItem instanceof LendDashboardItem.BlankItem) {
                return kotlin.jvm.internal.m.c((LendDashboardItem.BlankItem) newItem, oldItem);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areItemsTheSame(LendDashboardItem oldItem, LendDashboardItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (kotlin.jvm.internal.m.c(e0.b(oldItem.getClass()), e0.b(newItem.getClass()))) {
                return kotlin.jvm.internal.m.c(oldItem.getId(), newItem.getId());
            }
            return false;
        }
    }

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$ProviderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;)V", "Landroid/widget/ProgressBar;", "progress", "Landroid/widget/ProgressBar;", "Landroid/widget/TextView;", "providerAPR", "Landroid/widget/TextView;", "cryptoAmount", "", "Landroid/view/View;", "alphaViews", "Ljava/util/List;", "providerName", "Lkotlin/Function1;", "onItemClickListener", "Lkotlin/e0/c/l;", "providerAmount", "providerContainer", "Landroid/view/View;", "Landroid/widget/ImageView;", "providerIcon", "Landroid/widget/ImageView;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ProviderViewHolder extends RecyclerView.e0 {
        private final List<View> alphaViews;
        private final TextView cryptoAmount;
        private final l<LendDashboardItem.Provider, x> onItemClickListener;
        private final ProgressBar progress;
        private final TextView providerAPR;
        private final TextView providerAmount;
        private final View providerContainer;
        private final ImageView providerIcon;
        private final TextView providerName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ProviderViewHolder(View itemView, l<? super LendDashboardItem.Provider, x> onItemClickListener) {
            super(itemView);
            List<View> j2;
            kotlin.jvm.internal.m.g(itemView, "itemView");
            kotlin.jvm.internal.m.g(onItemClickListener, "onItemClickListener");
            this.onItemClickListener = onItemClickListener;
            CardView cardView = (CardView) itemView.findViewById(e.j.a.providerContainer);
            kotlin.jvm.internal.m.f(cardView, "itemView.providerContainer");
            this.providerContainer = cardView;
            RoundedCornerImageView roundedCornerImageView = (RoundedCornerImageView) itemView.findViewById(e.j.a.providerIcon);
            kotlin.jvm.internal.m.f(roundedCornerImageView, "itemView.providerIcon");
            this.providerIcon = roundedCornerImageView;
            TextView textView = (TextView) itemView.findViewById(e.j.a.providerName);
            kotlin.jvm.internal.m.f(textView, "itemView.providerName");
            this.providerName = textView;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.providerAmount);
            kotlin.jvm.internal.m.f(textView2, "itemView.providerAmount");
            this.providerAmount = textView2;
            TextView textView3 = (TextView) itemView.findViewById(e.j.a.providerApr);
            kotlin.jvm.internal.m.f(textView3, "itemView.providerApr");
            this.providerAPR = textView3;
            TextView textView4 = (TextView) itemView.findViewById(e.j.a.cryptoValue);
            kotlin.jvm.internal.m.f(textView4, "itemView.cryptoValue");
            this.cryptoAmount = textView4;
            ProgressBar progressBar = (ProgressBar) itemView.findViewById(e.j.a.c5);
            kotlin.jvm.internal.m.f(progressBar, "itemView.progress");
            this.progress = progressBar;
            j2 = r.j(roundedCornerImageView, textView, textView2, textView3, textView4);
            this.alphaViews = j2;
            View_CommonKt.setRippleForeground$default(cardView, View_CommonKt.getPxSize(itemView, R.dimen.view_size_16), null, 2, null);
        }

        public final void bind(LendDashboardItem.Provider item) {
            kotlin.jvm.internal.m.g(item, "item");
            View_CommonKt.setOnSingleClickListener$default(this.providerContainer, 0L, new DashboardListAdapter$ProviderViewHolder$bind$1(item, this), 1, null);
            ImageView imageView = this.providerIcon;
            URL imageURL = item.getImageURL();
            ImageView_CommonKt.load$default(imageView, imageURL == null ? null : imageURL.toString(), 0, null, 6, null);
            this.providerName.setText(item.getProviderName());
            this.providerAmount.setText(item.getFiatValue());
            this.providerAPR.setText(item.getSupplyRateText());
            this.cryptoAmount.setText(item.getCryptoValue());
            for (View view : this.alphaViews) {
                view.setAlpha(item.isPending() ? 0.5f : 1.0f);
            }
            this.progress.setVisibility(item.isPending() ? 0 : 8);
        }
    }

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "BALANCE", "TOKEN", "PROVIDER", "BLANK_ITEM", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private enum SectionType {
        BALANCE,
        TOKEN,
        PROVIDER,
        BLANK_ITEM
    }

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter$TokenViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Token;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Token;)V", "Landroid/widget/TextView;", "walletAmount", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "walletIcon", "Landroid/widget/ImageView;", "walletName", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class TokenViewHolder extends RecyclerView.e0 {
        private final TextView walletAmount;
        private final ImageView walletIcon;
        private final TextView walletName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TokenViewHolder(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
            ImageView imageView = (ImageView) itemView.findViewById(e.j.a.C7);
            kotlin.jvm.internal.m.f(imageView, "itemView.walletIcon");
            this.walletIcon = imageView;
            TextView textView = (TextView) itemView.findViewById(e.j.a.walletName);
            kotlin.jvm.internal.m.f(textView, "itemView.walletName");
            this.walletName = textView;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.walletAmount);
            kotlin.jvm.internal.m.f(textView2, "itemView.walletAmount");
            this.walletAmount = textView2;
        }

        public final void bind(LendDashboardItem.Token item) {
            kotlin.jvm.internal.m.g(item, "item");
            ImageView imageView = this.walletIcon;
            URL imageURL = item.getImageURL();
            ImageView_CommonKt.load$default(imageView, imageURL == null ? null : imageURL.toString(), 0, null, 6, null);
            this.walletName.setText(item.getCurrencyName());
            this.walletAmount.setText(item.getTotalFiatText());
        }
    }

    /* compiled from: DashboardListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionType.values().length];
            iArr[SectionType.BALANCE.ordinal()] = 1;
            iArr[SectionType.TOKEN.ordinal()] = 2;
            iArr[SectionType.PROVIDER.ordinal()] = 3;
            iArr[SectionType.BLANK_ITEM.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DashboardListAdapter(l<? super LendDashboardItem.Provider, x> onItemClickListener) {
        super(new LendingDashboardItemCallback());
        kotlin.jvm.internal.m.g(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return getItem(i2).getId().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        SectionType sectionType;
        LendDashboardItem item = getItem(i2);
        if (item instanceof LendDashboardItem.Balance) {
            sectionType = SectionType.BALANCE;
        } else if (item instanceof LendDashboardItem.Token) {
            sectionType = SectionType.TOKEN;
        } else if (item instanceof LendDashboardItem.Provider) {
            sectionType = SectionType.PROVIDER;
        } else if (!(item instanceof LendDashboardItem.BlankItem)) {
            throw new NoWhenBranchMatchedException();
        } else {
            sectionType = SectionType.BLANK_ITEM;
        }
        return sectionType.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        LendDashboardItem item = getItem(i2);
        if (item instanceof LendDashboardItem.Balance) {
            ((BalanceViewHolder) holder).bind((LendDashboardItem.Balance) item);
        } else if (item instanceof LendDashboardItem.Token) {
            ((TokenViewHolder) holder).bind((LendDashboardItem.Token) item);
        } else if (item instanceof LendDashboardItem.Provider) {
            ((ProviderViewHolder) holder).bind((LendDashboardItem.Provider) item);
        } else if (!(item instanceof LendDashboardItem.BlankItem)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[SectionType.values()[i2].ordinal()];
        if (i3 == 1) {
            View v = from.inflate(R.layout.list_item__lend_dashboard_balance, parent, false);
            kotlin.jvm.internal.m.f(v, "v");
            return new BalanceViewHolder(v);
        } else if (i3 == 2) {
            View v2 = from.inflate(R.layout.list_item__lend_dashboard_token, parent, false);
            kotlin.jvm.internal.m.f(v2, "v");
            return new TokenViewHolder(v2);
        } else if (i3 == 3) {
            View v3 = from.inflate(R.layout.list_item__lend_dashboard_provider, parent, false);
            kotlin.jvm.internal.m.f(v3, "v");
            return new ProviderViewHolder(v3, this.onItemClickListener);
        } else if (i3 == 4) {
            View v4 = from.inflate(R.layout.list_item__lend_dashboard_blank, parent, false);
            kotlin.jvm.internal.m.f(v4, "v");
            return new BlankItemViewHolder(v4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2, List<Object> payloads) {
        kotlin.jvm.internal.m.g(holder, "holder");
        kotlin.jvm.internal.m.g(payloads, "payloads");
        onBindViewHolder(holder, i2);
    }
}