package com.coinbase.wallet.txhistory.views;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.txhistory.models.TxHistoryDetail;
import com.uber.autodispose.d;
import com.uber.autodispose.x;
import h.c.a0;
import h.c.s;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxHistoryDetailFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u000298B\u0007¢\u0006\u0004\b6\u00107J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170&8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u00020-8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001e\u00104\u001a\n 3*\u0004\u0018\u000102028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailAdapter;", "txHistoryDetailAdapter", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailAdapter;", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewModel;", "viewModel", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewModel;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;", "txHistoryDetailArgs$delegate", "Lkotlin/h;", "getTxHistoryDetailArgs", "()Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;", "txHistoryDetailArgs", "getScopeProvider", "scopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$txhistory_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$txhistory_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "<init>", "()V", "Companion", "Args", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDetailFragment extends LockedFragment implements StyledFragment, BackableFragment {
    public static final Companion Companion = new Companion(null);
    private static final String DETAILS_KEY = "txHistoryDetails";
    private final StyledFragment.Attributes attributes;
    private final a0 mainScheduler = h.c.j0.c.a.b();
    private final TxHistoryDetailAdapter txHistoryDetailAdapter;
    private final h txHistoryDetailArgs$delegate;
    private TxHistoryDetailViewModel viewModel;
    public GenericViewModelFactory<TxHistoryDetailViewModel> viewModelFactory;

    /* compiled from: TxHistoryDetailFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016Jn\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\"\u0010\u0012J\u0010\u0010#\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b#\u0010\nJ\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b)\u0010\nJ \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b.\u0010/R\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\nR\u0019\u0010\u001d\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u0010\rR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b6\u0010\rR\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\b8\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010\u0016R\u0019\u0010\u001e\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b;\u0010\u0012R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010<\u001a\u0004\b=\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b>\u0010\n¨\u0006A"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Transaction;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component2", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "", "component3", "()I", "Ljava/net/URL;", "component4", "()Ljava/net/URL;", "component5", "component6", "", "component7", "()Ljava/lang/String;", "component8", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component9", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "tx", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "walletDecimals", "walletImageUrl", "feeDecimals", "feeWalletImageUrl", "displayName", "displayAddress", "recipientType", "copy", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/net/URL;ILjava/net/URL;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;)Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getWalletDecimals", "Ljava/lang/String;", "getDisplayName", "Ljava/net/URL;", "getWalletImageUrl", "getFeeWalletImageUrl", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "getTx", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "getDisplayAddress", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "getFeeDecimals", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/net/URL;ILjava/net/URL;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Args implements Parcelable {
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        private final Blockchain blockchain;
        private final String displayAddress;
        private final String displayName;
        private final int feeDecimals;
        private final URL feeWalletImageUrl;
        private final RecipientType recipientType;
        private final Transaction tx;
        private final int walletDecimals;
        private final URL walletImageUrl;

        /* compiled from: TxHistoryDetailFragment.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Args> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Args createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Args((Transaction) parcel.readParcelable(Args.class.getClassLoader()), (Blockchain) parcel.readParcelable(Args.class.getClassLoader()), parcel.readInt(), (URL) parcel.readSerializable(), parcel.readInt(), (URL) parcel.readSerializable(), parcel.readString(), parcel.readString(), RecipientType.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Args[] newArray(int i2) {
                return new Args[i2];
            }
        }

        public Args(Transaction tx, Blockchain blockchain, int i2, URL url, int i3, URL url2, String displayName, String displayAddress, RecipientType recipientType) {
            m.g(tx, "tx");
            m.g(blockchain, "blockchain");
            m.g(displayName, "displayName");
            m.g(displayAddress, "displayAddress");
            m.g(recipientType, "recipientType");
            this.tx = tx;
            this.blockchain = blockchain;
            this.walletDecimals = i2;
            this.walletImageUrl = url;
            this.feeDecimals = i3;
            this.feeWalletImageUrl = url2;
            this.displayName = displayName;
            this.displayAddress = displayAddress;
            this.recipientType = recipientType;
        }

        public final Transaction component1() {
            return this.tx;
        }

        public final Blockchain component2() {
            return this.blockchain;
        }

        public final int component3() {
            return this.walletDecimals;
        }

        public final URL component4() {
            return this.walletImageUrl;
        }

        public final int component5() {
            return this.feeDecimals;
        }

        public final URL component6() {
            return this.feeWalletImageUrl;
        }

        public final String component7() {
            return this.displayName;
        }

        public final String component8() {
            return this.displayAddress;
        }

        public final RecipientType component9() {
            return this.recipientType;
        }

        public final Args copy(Transaction tx, Blockchain blockchain, int i2, URL url, int i3, URL url2, String displayName, String displayAddress, RecipientType recipientType) {
            m.g(tx, "tx");
            m.g(blockchain, "blockchain");
            m.g(displayName, "displayName");
            m.g(displayAddress, "displayAddress");
            m.g(recipientType, "recipientType");
            return new Args(tx, blockchain, i2, url, i3, url2, displayName, displayAddress, recipientType);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Args) {
                Args args = (Args) obj;
                return m.c(this.tx, args.tx) && m.c(this.blockchain, args.blockchain) && this.walletDecimals == args.walletDecimals && m.c(this.walletImageUrl, args.walletImageUrl) && this.feeDecimals == args.feeDecimals && m.c(this.feeWalletImageUrl, args.feeWalletImageUrl) && m.c(this.displayName, args.displayName) && m.c(this.displayAddress, args.displayAddress) && this.recipientType == args.recipientType;
            }
            return false;
        }

        public final Blockchain getBlockchain() {
            return this.blockchain;
        }

        public final String getDisplayAddress() {
            return this.displayAddress;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final int getFeeDecimals() {
            return this.feeDecimals;
        }

        public final URL getFeeWalletImageUrl() {
            return this.feeWalletImageUrl;
        }

        public final RecipientType getRecipientType() {
            return this.recipientType;
        }

        public final Transaction getTx() {
            return this.tx;
        }

        public final int getWalletDecimals() {
            return this.walletDecimals;
        }

        public final URL getWalletImageUrl() {
            return this.walletImageUrl;
        }

        public int hashCode() {
            int hashCode = ((((this.tx.hashCode() * 31) + this.blockchain.hashCode()) * 31) + this.walletDecimals) * 31;
            URL url = this.walletImageUrl;
            int hashCode2 = (((hashCode + (url == null ? 0 : url.hashCode())) * 31) + this.feeDecimals) * 31;
            URL url2 = this.feeWalletImageUrl;
            return ((((((hashCode2 + (url2 != null ? url2.hashCode() : 0)) * 31) + this.displayName.hashCode()) * 31) + this.displayAddress.hashCode()) * 31) + this.recipientType.hashCode();
        }

        public String toString() {
            return "Args(tx=" + this.tx + ", blockchain=" + this.blockchain + ", walletDecimals=" + this.walletDecimals + ", walletImageUrl=" + this.walletImageUrl + ", feeDecimals=" + this.feeDecimals + ", feeWalletImageUrl=" + this.feeWalletImageUrl + ", displayName=" + this.displayName + ", displayAddress=" + this.displayAddress + ", recipientType=" + this.recipientType + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeParcelable(this.tx, i2);
            out.writeParcelable(this.blockchain, i2);
            out.writeInt(this.walletDecimals);
            out.writeSerializable(this.walletImageUrl);
            out.writeInt(this.feeDecimals);
            out.writeSerializable(this.feeWalletImageUrl);
            out.writeString(this.displayName);
            out.writeString(this.displayAddress);
            this.recipientType.writeToParcel(out, i2);
        }
    }

    /* compiled from: TxHistoryDetailFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Companion;", "", "Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;", "txHistoryDetailArgs", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailFragment$Args;)Landroid/os/Bundle;", "", "DETAILS_KEY", "Ljava/lang/String;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle createArguments(Args txHistoryDetailArgs) {
            m.g(txHistoryDetailArgs, "txHistoryDetailArgs");
            Bundle bundle = new Bundle();
            bundle.putParcelable(TxHistoryDetailFragment.DETAILS_KEY, txHistoryDetailArgs);
            return bundle;
        }
    }

    public TxHistoryDetailFragment() {
        h b2;
        b2 = k.b(new TxHistoryDetailFragment$txHistoryDetailArgs$2(this));
        this.txHistoryDetailArgs$delegate = b2;
        this.txHistoryDetailAdapter = new TxHistoryDetailAdapter();
        this.attributes = StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final Args getTxHistoryDetailArgs() {
        return (Args) this.txHistoryDetailArgs$delegate.getValue();
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return this.attributes;
    }

    public final GenericViewModelFactory<TxHistoryDetailViewModel> getViewModelFactory$txhistory_productionRelease() {
        GenericViewModelFactory<TxHistoryDetailViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_tx_history_details, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$txhistory_productionRelease()).a(TxHistoryDetailViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (TxHistoryDetailViewModel) a;
        Transaction tx = getTxHistoryDetailArgs().getTx();
        Blockchain blockchain = getTxHistoryDetailArgs().getBlockchain();
        int walletDecimals = getTxHistoryDetailArgs().getWalletDecimals();
        int feeDecimals = getTxHistoryDetailArgs().getFeeDecimals();
        URL walletImageUrl = getTxHistoryDetailArgs().getWalletImageUrl();
        URL feeWalletImageUrl = getTxHistoryDetailArgs().getFeeWalletImageUrl();
        String displayName = getTxHistoryDetailArgs().getDisplayName();
        String displayAddress = getTxHistoryDetailArgs().getDisplayAddress();
        RecipientType recipientType = getTxHistoryDetailArgs().getRecipientType();
        TxHistoryDetailViewModel txHistoryDetailViewModel = this.viewModel;
        if (txHistoryDetailViewModel != null) {
            txHistoryDetailViewModel.init(tx, blockchain, walletDecimals, walletImageUrl, feeDecimals, feeWalletImageUrl, displayName, displayAddress, recipientType);
            View view2 = getView();
            View upButton = view2 == null ? null : view2.findViewById(R.id.upButton);
            m.f(upButton, "upButton");
            View_CommonKt.setOnSingleClickListener$default(upButton, 0L, new TxHistoryDetailFragment$onViewCreated$1(this), 1, null);
            View_CommonKt.setOnSingleClickListener$default(view, 0L, new TxHistoryDetailFragment$onViewCreated$2(view), 1, null);
            View view3 = getView();
            View actionButton = view3 == null ? null : view3.findViewById(R.id.actionButton);
            m.f(actionButton, "actionButton");
            View_CommonKt.setOnSingleClickListener$default(actionButton, 0L, new TxHistoryDetailFragment$onViewCreated$3(this), 1, null);
            View view4 = getView();
            ((RecyclerView) (view4 == null ? null : view4.findViewById(R.id.txDetails))).setLayoutManager(new LinearLayoutManager(requireContext()));
            View view5 = getView();
            ((RecyclerView) (view5 == null ? null : view5.findViewById(R.id.txDetails))).setAdapter(this.txHistoryDetailAdapter);
            TxHistoryDetailViewModel txHistoryDetailViewModel2 = this.viewModel;
            if (txHistoryDetailViewModel2 != null) {
                s<TxHistoryDetail> observeOn = txHistoryDetailViewModel2.getStateObservable().observeOn(this.mainScheduler);
                m.f(observeOn, "viewModel.stateObservable\n            .observeOn(mainScheduler)");
                Object as = Observable_AnalyticsKt.logError$default(observeOn, "Failed to parse history details items.", null, 2, null).as(d.a(getScopeProvider()));
                m.f(as, "viewModel.stateObservable\n            .observeOn(mainScheduler)\n            .logError(\"Failed to parse history details items.\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new TxHistoryDetailFragment$onViewCreated$4(this, view), 3, null);
                TxHistoryDetailViewModel txHistoryDetailViewModel3 = this.viewModel;
                if (txHistoryDetailViewModel3 != null) {
                    s<URL> observeOn2 = txHistoryDetailViewModel3.getPresentViewObservable().observeOn(this.mainScheduler);
                    m.f(observeOn2, "viewModel.presentViewObservable\n            .observeOn(mainScheduler)");
                    Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, "Failed to launch web url for transaction.", null, 2, null).as(d.a(getOnDestroyScopeProvider()));
                    m.f(as2, "viewModel.presentViewObservable\n            .observeOn(mainScheduler)\n            .logError(\"Failed to launch web url for transaction.\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new TxHistoryDetailFragment$onViewCreated$5(this), 3, null);
                    return;
                }
                m.w("viewModel");
                throw null;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    public final void setViewModelFactory$txhistory_productionRelease(GenericViewModelFactory<TxHistoryDetailViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}