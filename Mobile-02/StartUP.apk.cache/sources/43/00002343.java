package com.coinbase.wallet.features.walletlink.views;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.j;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.features.settings.models.WalletLinkSettingRow;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.walletlink.models.Session;
import de.hdodenhof.circleimageview.CircleImageView;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletLinkSettingsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B7\u0012\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0004\u0012\u00020\r0\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r0\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0016¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "getItemCount", "()I", "holder", "position", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "getItemViewType", "(I)I", "Lkotlin/Function1;", "", "Lcom/coinbase/walletlink/models/Session;", "unlinkListener", "Lkotlin/e0/c/l;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "showDisconnectPrompt", "<init>", "(Lkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "AllSessionsViewHolder", "DAppViewHolder", "RowType", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkSettingsAdapter extends RecyclerView.g<RecyclerView.e0> {
    private List<? extends WalletLinkSettingRow> items;
    private final l<PromptDialogHelper.Properties, x> showDisconnectPrompt;
    private final l<List<Session>, x> unlinkListener;

    /* compiled from: WalletLinkSettingsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00040\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00040\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter$AllSessionsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$AllSessions;", "allSessions", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$AllSessions;)V", "Landroid/widget/TextView;", "sessionCount", "Landroid/widget/TextView;", "Lkotlin/Function1;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "showDisconnectPrompt", "Lkotlin/e0/c/l;", "Landroid/widget/Button;", "disconnectAllButton", "Landroid/widget/Button;", "", "Lcom/coinbase/walletlink/models/Session;", "unlinkListener", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AllSessionsViewHolder extends RecyclerView.e0 {
        private final Button disconnectAllButton;
        private final TextView sessionCount;
        private final l<PromptDialogHelper.Properties, x> showDisconnectPrompt;
        private final l<List<Session>, x> unlinkListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AllSessionsViewHolder(View itemView, l<? super List<Session>, x> unlinkListener, l<? super PromptDialogHelper.Properties, x> showDisconnectPrompt) {
            super(itemView);
            m.g(itemView, "itemView");
            m.g(unlinkListener, "unlinkListener");
            m.g(showDisconnectPrompt, "showDisconnectPrompt");
            this.unlinkListener = unlinkListener;
            this.showDisconnectPrompt = showDisconnectPrompt;
            View findViewById = itemView.findViewById(R.id.connectionCount);
            m.f(findViewById, "itemView.findViewById(R.id.connectionCount)");
            this.sessionCount = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.disconnectAllButton);
            m.f(findViewById2, "itemView.findViewById(R.id.disconnectAllButton)");
            this.disconnectAllButton = (Button) findViewById2;
        }

        public final void bind(WalletLinkSettingRow.AllSessions allSessions) {
            m.g(allSessions, "allSessions");
            this.sessionCount.setText(LocalizedStrings.INSTANCE.get(R.string.wallet_link_browsers, Integer.valueOf(allSessions.getSessionCount())));
            View_CommonKt.setOnSingleClickListener$default(this.disconnectAllButton, 0L, new WalletLinkSettingsAdapter$AllSessionsViewHolder$bind$1(this), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WalletLinkSettingsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter$RowType;", "", "", "type", "I", "getType", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "ALL_SESSIONS", "DAPP", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum RowType {
        ALL_SESSIONS(0),
        DAPP(1);
        
        public static final Companion Companion = new Companion(null);
        private final int type;

        /* compiled from: WalletLinkSettingsAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter$RowType$Companion;", "", "", "type", "Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter$RowType;", "fromInt", "(I)Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter$RowType;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final RowType fromInt(int i2) {
                RowType[] values;
                for (RowType rowType : RowType.values()) {
                    if (rowType.getType() == i2) {
                        return rowType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }

        RowType(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: WalletLinkSettingsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RowType.values().length];
            iArr[RowType.ALL_SESSIONS.ordinal()] = 1;
            iArr[RowType.DAPP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WalletLinkSettingsAdapter(l<? super List<Session>, x> unlinkListener, l<? super PromptDialogHelper.Properties, x> showDisconnectPrompt) {
        List<? extends WalletLinkSettingRow> g2;
        m.g(unlinkListener, "unlinkListener");
        m.g(showDisconnectPrompt, "showDisconnectPrompt");
        this.unlinkListener = unlinkListener;
        this.showDisconnectPrompt = showDisconnectPrompt;
        g2 = r.g();
        this.items = g2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        WalletLinkSettingRow walletLinkSettingRow = this.items.get(i2);
        if (walletLinkSettingRow instanceof WalletLinkSettingRow.AllSessions) {
            return RowType.ALL_SESSIONS.getType();
        }
        if (walletLinkSettingRow instanceof WalletLinkSettingRow.DApp ? true : walletLinkSettingRow instanceof WalletLinkSettingRow.WalletLinkV1) {
            return RowType.DAPP.getType();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<WalletLinkSettingRow> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        m.g(holder, "holder");
        WalletLinkSettingRow walletLinkSettingRow = this.items.get(i2);
        if (walletLinkSettingRow instanceof WalletLinkSettingRow.AllSessions) {
            ((AllSessionsViewHolder) holder).bind((WalletLinkSettingRow.AllSessions) walletLinkSettingRow);
        } else if (walletLinkSettingRow instanceof WalletLinkSettingRow.DApp) {
            ((DAppViewHolder) holder).bind((WalletLinkSettingRow.DApp) walletLinkSettingRow);
        } else if (walletLinkSettingRow instanceof WalletLinkSettingRow.WalletLinkV1) {
            ((DAppViewHolder) holder).bind((WalletLinkSettingRow.WalletLinkV1) walletLinkSettingRow);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[RowType.Companion.fromInt(i2).ordinal()];
        if (i3 == 1) {
            View view = from.inflate(R.layout.wallet_link_settings_all_sessions_item, parent, false);
            m.f(view, "view");
            return new AllSessionsViewHolder(view, this.unlinkListener, this.showDisconnectPrompt);
        } else if (i3 == 2) {
            View view2 = from.inflate(R.layout.wallet_link_settings_individual_item, parent, false);
            m.f(view2, "view");
            return new DAppViewHolder(view2, this.unlinkListener, this.showDisconnectPrompt);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setItems(List<? extends WalletLinkSettingRow> value) {
        m.g(value, "value");
        this.items = value;
        notifyDataSetChanged();
    }

    /* compiled from: WalletLinkSettingsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010(\u001a\u00020'\u0012\u001a\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0019\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b)\u0010*J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u0018R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR*\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/views/WalletLinkSettingsAdapter$DAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "Lcom/coinbase/walletlink/models/Session;", "sessions", "", WalletLinkCompleteArgs.DAPP_NAME, "Lkotlin/x;", "bindDisconnectButton", "(Ljava/util/List;Ljava/lang/String;)V", "session", "bindSession", "(Lcom/coinbase/walletlink/models/Session;)V", "Ljava/net/URL;", "imageUrl", "Landroid/widget/ImageView;", "imageView", "loadImageInto", "(Ljava/net/URL;Landroid/widget/ImageView;)V", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$WalletLinkV1;", "item", "bind", "(Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$WalletLinkV1;)V", "Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$DApp;", "(Lcom/coinbase/wallet/features/settings/models/WalletLinkSettingRow$DApp;)V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "showDisconnectPrompt", "Lkotlin/e0/c/l;", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "dappURL", "unlinkListener", "Lde/hdodenhof/circleimageview/CircleImageView;", "dappIcon", "Lde/hdodenhof/circleimageview/CircleImageView;", "Landroidx/appcompat/widget/j;", "disconnectButton", "Landroidx/appcompat/widget/j;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DAppViewHolder extends RecyclerView.e0 {
        private final CircleImageView dappIcon;
        private final TextView dappName;
        private final TextView dappURL;
        private final j disconnectButton;
        private final l<PromptDialogHelper.Properties, x> showDisconnectPrompt;
        private final l<List<Session>, x> unlinkListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DAppViewHolder(View itemView, l<? super List<Session>, x> unlinkListener, l<? super PromptDialogHelper.Properties, x> showDisconnectPrompt) {
            super(itemView);
            m.g(itemView, "itemView");
            m.g(unlinkListener, "unlinkListener");
            m.g(showDisconnectPrompt, "showDisconnectPrompt");
            this.unlinkListener = unlinkListener;
            this.showDisconnectPrompt = showDisconnectPrompt;
            View findViewById = itemView.findViewById(R.id.dappName);
            m.f(findViewById, "itemView.findViewById(R.id.dappName)");
            this.dappName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.dappURL);
            m.f(findViewById2, "itemView.findViewById(R.id.dappURL)");
            this.dappURL = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.disconnectButton);
            m.f(findViewById3, "itemView.findViewById(R.id.disconnectButton)");
            this.disconnectButton = (j) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.dappIcon);
            m.f(findViewById4, "itemView.findViewById(R.id.dappIcon)");
            this.dappIcon = (CircleImageView) findViewById4;
        }

        private final void bindDisconnectButton(List<Session> list, String str) {
            View_CommonKt.setOnSingleClickListener$default(this.disconnectButton, 0L, new WalletLinkSettingsAdapter$DAppViewHolder$bindDisconnectButton$1(str, this, list), 1, null);
        }

        private final void bindSession(Session session) {
            URL dappImageURL;
            Uri dappURL;
            String str = null;
            if (session != null && session.getVersion() == null) {
                this.dappName.setText(LocalizedStrings.INSTANCE.get(R.string.walletlink_v1_dapp_title));
                this.dappIcon.setCircleBackgroundColorResource(R.color.grey_50);
                this.dappIcon.setImageDrawable(null);
            } else {
                this.dappName.setText(session == null ? null : session.getDappName());
                if (session != null && (dappImageURL = session.getDappImageURL()) != null) {
                    this.dappIcon.setCircleBackgroundColorResource(R.color.grey_0);
                    Glide.with(this.dappIcon.getContext()).load(dappImageURL.toString()).into(this.dappIcon);
                }
            }
            if (session != null && (dappURL = session.getDappURL()) != null) {
                str = dappURL.getHost();
            }
            this.dappURL.setText(str);
            this.dappURL.setVisibility(str != null ? 0 : 8);
        }

        private final void loadImageInto(URL url, ImageView imageView) {
        }

        public final void bind(WalletLinkSettingRow.WalletLinkV1 item) {
            m.g(item, "item");
            String dappName = item.getDappName();
            if (dappName == null) {
                dappName = LocalizedStrings.INSTANCE.get(R.string.walletlink_dapp_name);
            }
            bindSession((Session) p.a0(item.getSessions()));
            bindDisconnectButton(item.getSessions(), dappName);
        }

        public final void bind(WalletLinkSettingRow.DApp item) {
            m.g(item, "item");
            String dappName = item.getDappName();
            if (dappName == null) {
                dappName = LocalizedStrings.INSTANCE.get(R.string.walletlink_dapp_name);
            }
            bindSession((Session) p.a0(item.getSessions()));
            bindDisconnectButton(item.getSessions(), dappName);
        }
    }
}