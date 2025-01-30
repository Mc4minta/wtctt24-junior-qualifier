package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.wallet.blockchains.models.TransferValue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TransferMoneyRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010!\u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\u0006\u0010#\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020\u0015\u0012\u0006\u0010%\u001a\u00020\u0019\u0012\b\b\u0002\u0010&\u001a\u00020\u0015¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0017Jz\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\b2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b)\u0010\u0014J\u0010\u0010*\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b*\u0010\u0007J\u001a\u0010-\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b/\u0010\u0007J \u00104\u001a\u0002032\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b4\u00105R\u0019\u0010\"\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u0010\u0014R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b9\u0010\u0007R\u0019\u0010&\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\b;\u0010\u0017R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\u000eR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010>\u001a\u0004\b?\u0010\u0004R\u0019\u0010%\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bA\u0010\u001bR\u0019\u0010$\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\bB\u0010\u0017R\u0019\u0010!\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010C\u001a\u0004\bD\u0010\u0011R\u0019\u0010\u001f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010E\u001a\u0004\bF\u0010\nR\u0019\u0010#\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b#\u0010\u0017¨\u0006I"}, d2 = {"Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component1", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "", "component2", "()I", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "component3", "()Lcom/coinbase/wallet/blockchains/models/TransferValue;", "", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "component4", "()Ljava/util/List;", "Ljava/math/BigDecimal;", "component5", "()Ljava/math/BigDecimal;", "", "component6", "()Ljava/lang/String;", "", "component7", "()Z", "component8", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "component9", "()Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "component10", "account", "maxAtomicDecimals", "originalRequestAmount", "availableTransfers", "fiatExchangeRate", "fiatCurrency", "isFiatPrimary", "supportsDestinationTag", "wallet", "onrampEnabled", "copy", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;ILcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/util/List;Ljava/math/BigDecimal;Ljava/lang/String;ZZLcom/coinbase/wallet/consumer/models/ReceivableWallet;Z)Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFiatCurrency", "I", "getMaxAtomicDecimals", "Z", "getOnrampEnabled", "Ljava/util/List;", "getAvailableTransfers", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "getAccount", "Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "getWallet", "getSupportsDestinationTag", "Ljava/math/BigDecimal;", "getFiatExchangeRate", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "getOriginalRequestAmount", "<init>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;ILcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/util/List;Ljava/math/BigDecimal;Ljava/lang/String;ZZLcom/coinbase/wallet/consumer/models/ReceivableWallet;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TransferMoneyRequest implements Parcelable {
    public static final Parcelable.Creator<TransferMoneyRequest> CREATOR = new Creator();
    private final ConsumerAccount account;
    private final List<AvailableTransfer> availableTransfers;
    private final String fiatCurrency;
    private final BigDecimal fiatExchangeRate;
    private final boolean isFiatPrimary;
    private final int maxAtomicDecimals;
    private final boolean onrampEnabled;
    private final TransferValue originalRequestAmount;
    private final boolean supportsDestinationTag;
    private final ReceivableWallet wallet;

    /* compiled from: TransferMoneyRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<TransferMoneyRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferMoneyRequest createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            ConsumerAccount createFromParcel = ConsumerAccount.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            TransferValue transferValue = (TransferValue) parcel.readParcelable(TransferMoneyRequest.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList.add(parcel.readParcelable(TransferMoneyRequest.class.getClassLoader()));
            }
            return new TransferMoneyRequest(createFromParcel, readInt, transferValue, arrayList, (BigDecimal) parcel.readSerializable(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, ReceivableWallet.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransferMoneyRequest[] newArray(int i2) {
            return new TransferMoneyRequest[i2];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransferMoneyRequest(ConsumerAccount account, int i2, TransferValue originalRequestAmount, List<? extends AvailableTransfer> availableTransfers, BigDecimal fiatExchangeRate, String fiatCurrency, boolean z, boolean z2, ReceivableWallet wallet, boolean z3) {
        m.g(account, "account");
        m.g(originalRequestAmount, "originalRequestAmount");
        m.g(availableTransfers, "availableTransfers");
        m.g(fiatExchangeRate, "fiatExchangeRate");
        m.g(fiatCurrency, "fiatCurrency");
        m.g(wallet, "wallet");
        this.account = account;
        this.maxAtomicDecimals = i2;
        this.originalRequestAmount = originalRequestAmount;
        this.availableTransfers = availableTransfers;
        this.fiatExchangeRate = fiatExchangeRate;
        this.fiatCurrency = fiatCurrency;
        this.isFiatPrimary = z;
        this.supportsDestinationTag = z2;
        this.wallet = wallet;
        this.onrampEnabled = z3;
    }

    public final ConsumerAccount component1() {
        return this.account;
    }

    public final boolean component10() {
        return this.onrampEnabled;
    }

    public final int component2() {
        return this.maxAtomicDecimals;
    }

    public final TransferValue component3() {
        return this.originalRequestAmount;
    }

    public final List<AvailableTransfer> component4() {
        return this.availableTransfers;
    }

    public final BigDecimal component5() {
        return this.fiatExchangeRate;
    }

    public final String component6() {
        return this.fiatCurrency;
    }

    public final boolean component7() {
        return this.isFiatPrimary;
    }

    public final boolean component8() {
        return this.supportsDestinationTag;
    }

    public final ReceivableWallet component9() {
        return this.wallet;
    }

    public final TransferMoneyRequest copy(ConsumerAccount account, int i2, TransferValue originalRequestAmount, List<? extends AvailableTransfer> availableTransfers, BigDecimal fiatExchangeRate, String fiatCurrency, boolean z, boolean z2, ReceivableWallet wallet, boolean z3) {
        m.g(account, "account");
        m.g(originalRequestAmount, "originalRequestAmount");
        m.g(availableTransfers, "availableTransfers");
        m.g(fiatExchangeRate, "fiatExchangeRate");
        m.g(fiatCurrency, "fiatCurrency");
        m.g(wallet, "wallet");
        return new TransferMoneyRequest(account, i2, originalRequestAmount, availableTransfers, fiatExchangeRate, fiatCurrency, z, z2, wallet, z3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransferMoneyRequest) {
            TransferMoneyRequest transferMoneyRequest = (TransferMoneyRequest) obj;
            return m.c(this.account, transferMoneyRequest.account) && this.maxAtomicDecimals == transferMoneyRequest.maxAtomicDecimals && m.c(this.originalRequestAmount, transferMoneyRequest.originalRequestAmount) && m.c(this.availableTransfers, transferMoneyRequest.availableTransfers) && m.c(this.fiatExchangeRate, transferMoneyRequest.fiatExchangeRate) && m.c(this.fiatCurrency, transferMoneyRequest.fiatCurrency) && this.isFiatPrimary == transferMoneyRequest.isFiatPrimary && this.supportsDestinationTag == transferMoneyRequest.supportsDestinationTag && m.c(this.wallet, transferMoneyRequest.wallet) && this.onrampEnabled == transferMoneyRequest.onrampEnabled;
        }
        return false;
    }

    public final ConsumerAccount getAccount() {
        return this.account;
    }

    public final List<AvailableTransfer> getAvailableTransfers() {
        return this.availableTransfers;
    }

    public final String getFiatCurrency() {
        return this.fiatCurrency;
    }

    public final BigDecimal getFiatExchangeRate() {
        return this.fiatExchangeRate;
    }

    public final int getMaxAtomicDecimals() {
        return this.maxAtomicDecimals;
    }

    public final boolean getOnrampEnabled() {
        return this.onrampEnabled;
    }

    public final TransferValue getOriginalRequestAmount() {
        return this.originalRequestAmount;
    }

    public final boolean getSupportsDestinationTag() {
        return this.supportsDestinationTag;
    }

    public final ReceivableWallet getWallet() {
        return this.wallet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.account.hashCode() * 31) + this.maxAtomicDecimals) * 31) + this.originalRequestAmount.hashCode()) * 31) + this.availableTransfers.hashCode()) * 31) + this.fiatExchangeRate.hashCode()) * 31) + this.fiatCurrency.hashCode()) * 31;
        boolean z = this.isFiatPrimary;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.supportsDestinationTag;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int hashCode2 = (((i3 + i4) * 31) + this.wallet.hashCode()) * 31;
        boolean z3 = this.onrampEnabled;
        return hashCode2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isFiatPrimary() {
        return this.isFiatPrimary;
    }

    public String toString() {
        return "TransferMoneyRequest(account=" + this.account + ", maxAtomicDecimals=" + this.maxAtomicDecimals + ", originalRequestAmount=" + this.originalRequestAmount + ", availableTransfers=" + this.availableTransfers + ", fiatExchangeRate=" + this.fiatExchangeRate + ", fiatCurrency=" + this.fiatCurrency + ", isFiatPrimary=" + this.isFiatPrimary + ", supportsDestinationTag=" + this.supportsDestinationTag + ", wallet=" + this.wallet + ", onrampEnabled=" + this.onrampEnabled + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        this.account.writeToParcel(out, i2);
        out.writeInt(this.maxAtomicDecimals);
        out.writeParcelable(this.originalRequestAmount, i2);
        List<AvailableTransfer> list = this.availableTransfers;
        out.writeInt(list.size());
        for (AvailableTransfer availableTransfer : list) {
            out.writeParcelable(availableTransfer, i2);
        }
        out.writeSerializable(this.fiatExchangeRate);
        out.writeString(this.fiatCurrency);
        out.writeInt(this.isFiatPrimary ? 1 : 0);
        out.writeInt(this.supportsDestinationTag ? 1 : 0);
        this.wallet.writeToParcel(out, i2);
        out.writeInt(this.onrampEnabled ? 1 : 0);
    }

    public /* synthetic */ TransferMoneyRequest(ConsumerAccount consumerAccount, int i2, TransferValue transferValue, List list, BigDecimal bigDecimal, String str, boolean z, boolean z2, ReceivableWallet receivableWallet, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(consumerAccount, i2, transferValue, list, bigDecimal, str, z, z2, receivableWallet, (i3 & 512) != 0 ? true : z3);
    }
}