package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AvailableTransfer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010%\u001a\u0004\u0018\u00010\f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010)\u001a\u00020\u001b¢\u0006\u0004\bN\u0010OJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0096\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010)\u001a\u00020\u001bHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b,\u0010\u000eJ\u0010\u0010-\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00101\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b3\u0010.J \u00108\u001a\u0002072\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b8\u00109R\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010\u0004R\u001b\u0010(\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\b=\u0010\u001aR\u001c\u0010!\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010>\u001a\u0004\b?\u0010\u000bR\u001c\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010:\u001a\u0004\b@\u0010\u0004R\u001b\u0010\"\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010A\u001a\u0004\bB\u0010\u000eR\u001b\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010C\u001a\u0004\bD\u0010\u0012R\u0019\u0010)\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010E\u001a\u0004\bF\u0010\u001dR\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bG\u0010\u000eR\u001b\u0010&\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bI\u0010\u0016R\u001c\u0010\u001f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010\u0007R\u001b\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010A\u001a\u0004\bL\u0010\u000eR\u001b\u0010'\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bM\u0010\u0012¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component2", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component3", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "component4", "()Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "", "component5", "()Ljava/lang/String;", "component6", "Ljava/math/BigDecimal;", "component7", "()Ljava/math/BigDecimal;", "component8", "", "component9", "()Ljava/lang/Integer;", "component10", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "component11", "()Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "", "component12", "()Z", "sendFee", "account", "transferAmount", "paymentMethod", "paymentMethodSubtitle", "supplementalPaymentInfo", "buyLimit", "paymentMethodImageUrl", "localPaymentMethodImage", "coinbaseFee", "buyOrder", "supportedPaymentMethod", "copy", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigDecimal;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Z)Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigInteger;", "getSendFee", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "getBuyOrder", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "getPaymentMethod", "getTransferAmount", "Ljava/lang/String;", "getPaymentMethodSubtitle", "Ljava/math/BigDecimal;", "getBuyLimit", "Z", "getSupportedPaymentMethod", "getPaymentMethodImageUrl", "Ljava/lang/Integer;", "getLocalPaymentMethodImage", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "getAccount", "getSupplementalPaymentInfo", "getCoinbaseFee", "<init>", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigDecimal;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AvailableBuyAndSendTransfer extends AvailableTransfer {
    public static final Parcelable.Creator<AvailableBuyAndSendTransfer> CREATOR = new Creator();
    private final ConsumerAccount account;
    private final BigDecimal buyLimit;
    private final ConsumerBuyOrder buyOrder;
    private final BigDecimal coinbaseFee;
    private final Integer localPaymentMethodImage;
    private final ConsumerPaymentMethod paymentMethod;
    private final String paymentMethodImageUrl;
    private final String paymentMethodSubtitle;
    private final BigInteger sendFee;
    private final String supplementalPaymentInfo;
    private final boolean supportedPaymentMethod;
    private final BigInteger transferAmount;

    /* compiled from: AvailableTransfer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<AvailableBuyAndSendTransfer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableBuyAndSendTransfer createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new AvailableBuyAndSendTransfer((BigInteger) parcel.readSerializable(), ConsumerAccount.CREATOR.createFromParcel(parcel), (BigInteger) parcel.readSerializable(), ConsumerPaymentMethod.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (BigDecimal) parcel.readSerializable(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), (BigDecimal) parcel.readSerializable(), parcel.readInt() != 0 ? ConsumerBuyOrder.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableBuyAndSendTransfer[] newArray(int i2) {
            return new AvailableBuyAndSendTransfer[i2];
        }
    }

    public /* synthetic */ AvailableBuyAndSendTransfer(BigInteger bigInteger, ConsumerAccount consumerAccount, BigInteger bigInteger2, ConsumerPaymentMethod consumerPaymentMethod, String str, String str2, BigDecimal bigDecimal, String str3, Integer num, BigDecimal bigDecimal2, ConsumerBuyOrder consumerBuyOrder, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, consumerAccount, bigInteger2, consumerPaymentMethod, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, bigDecimal, str3, num, bigDecimal2, consumerBuyOrder, z);
    }

    public final BigInteger component1() {
        return getSendFee();
    }

    public final BigDecimal component10() {
        return this.coinbaseFee;
    }

    public final ConsumerBuyOrder component11() {
        return this.buyOrder;
    }

    public final boolean component12() {
        return this.supportedPaymentMethod;
    }

    public final ConsumerAccount component2() {
        return getAccount();
    }

    public final BigInteger component3() {
        return getTransferAmount();
    }

    public final ConsumerPaymentMethod component4() {
        return getPaymentMethod();
    }

    public final String component5() {
        return this.paymentMethodSubtitle;
    }

    public final String component6() {
        return this.supplementalPaymentInfo;
    }

    public final BigDecimal component7() {
        return this.buyLimit;
    }

    public final String component8() {
        return this.paymentMethodImageUrl;
    }

    public final Integer component9() {
        return this.localPaymentMethodImage;
    }

    public final AvailableBuyAndSendTransfer copy(BigInteger sendFee, ConsumerAccount account, BigInteger transferAmount, ConsumerPaymentMethod paymentMethod, String str, String str2, BigDecimal bigDecimal, String str3, Integer num, BigDecimal bigDecimal2, ConsumerBuyOrder consumerBuyOrder, boolean z) {
        m.g(sendFee, "sendFee");
        m.g(account, "account");
        m.g(transferAmount, "transferAmount");
        m.g(paymentMethod, "paymentMethod");
        return new AvailableBuyAndSendTransfer(sendFee, account, transferAmount, paymentMethod, str, str2, bigDecimal, str3, num, bigDecimal2, consumerBuyOrder, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvailableBuyAndSendTransfer) {
            AvailableBuyAndSendTransfer availableBuyAndSendTransfer = (AvailableBuyAndSendTransfer) obj;
            return m.c(getSendFee(), availableBuyAndSendTransfer.getSendFee()) && m.c(getAccount(), availableBuyAndSendTransfer.getAccount()) && m.c(getTransferAmount(), availableBuyAndSendTransfer.getTransferAmount()) && m.c(getPaymentMethod(), availableBuyAndSendTransfer.getPaymentMethod()) && m.c(this.paymentMethodSubtitle, availableBuyAndSendTransfer.paymentMethodSubtitle) && m.c(this.supplementalPaymentInfo, availableBuyAndSendTransfer.supplementalPaymentInfo) && m.c(this.buyLimit, availableBuyAndSendTransfer.buyLimit) && m.c(this.paymentMethodImageUrl, availableBuyAndSendTransfer.paymentMethodImageUrl) && m.c(this.localPaymentMethodImage, availableBuyAndSendTransfer.localPaymentMethodImage) && m.c(this.coinbaseFee, availableBuyAndSendTransfer.coinbaseFee) && m.c(this.buyOrder, availableBuyAndSendTransfer.buyOrder) && this.supportedPaymentMethod == availableBuyAndSendTransfer.supportedPaymentMethod;
        }
        return false;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public ConsumerAccount getAccount() {
        return this.account;
    }

    public final BigDecimal getBuyLimit() {
        return this.buyLimit;
    }

    public final ConsumerBuyOrder getBuyOrder() {
        return this.buyOrder;
    }

    public final BigDecimal getCoinbaseFee() {
        return this.coinbaseFee;
    }

    public final Integer getLocalPaymentMethodImage() {
        return this.localPaymentMethodImage;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public ConsumerPaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public final String getPaymentMethodImageUrl() {
        return this.paymentMethodImageUrl;
    }

    public final String getPaymentMethodSubtitle() {
        return this.paymentMethodSubtitle;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public BigInteger getSendFee() {
        return this.sendFee;
    }

    public final String getSupplementalPaymentInfo() {
        return this.supplementalPaymentInfo;
    }

    public final boolean getSupportedPaymentMethod() {
        return this.supportedPaymentMethod;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public BigInteger getTransferAmount() {
        return this.transferAmount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((getSendFee().hashCode() * 31) + getAccount().hashCode()) * 31) + getTransferAmount().hashCode()) * 31) + getPaymentMethod().hashCode()) * 31;
        String str = this.paymentMethodSubtitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.supplementalPaymentInfo;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        BigDecimal bigDecimal = this.buyLimit;
        int hashCode4 = (hashCode3 + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31;
        String str3 = this.paymentMethodImageUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.localPaymentMethodImage;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        BigDecimal bigDecimal2 = this.coinbaseFee;
        int hashCode7 = (hashCode6 + (bigDecimal2 == null ? 0 : bigDecimal2.hashCode())) * 31;
        ConsumerBuyOrder consumerBuyOrder = this.buyOrder;
        int hashCode8 = (hashCode7 + (consumerBuyOrder != null ? consumerBuyOrder.hashCode() : 0)) * 31;
        boolean z = this.supportedPaymentMethod;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode8 + i2;
    }

    public String toString() {
        return "AvailableBuyAndSendTransfer(sendFee=" + getSendFee() + ", account=" + getAccount() + ", transferAmount=" + getTransferAmount() + ", paymentMethod=" + getPaymentMethod() + ", paymentMethodSubtitle=" + ((Object) this.paymentMethodSubtitle) + ", supplementalPaymentInfo=" + ((Object) this.supplementalPaymentInfo) + ", buyLimit=" + this.buyLimit + ", paymentMethodImageUrl=" + ((Object) this.paymentMethodImageUrl) + ", localPaymentMethodImage=" + this.localPaymentMethodImage + ", coinbaseFee=" + this.coinbaseFee + ", buyOrder=" + this.buyOrder + ", supportedPaymentMethod=" + this.supportedPaymentMethod + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeSerializable(this.sendFee);
        this.account.writeToParcel(out, i2);
        out.writeSerializable(this.transferAmount);
        this.paymentMethod.writeToParcel(out, i2);
        out.writeString(this.paymentMethodSubtitle);
        out.writeString(this.supplementalPaymentInfo);
        out.writeSerializable(this.buyLimit);
        out.writeString(this.paymentMethodImageUrl);
        Integer num = this.localPaymentMethodImage;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeSerializable(this.coinbaseFee);
        ConsumerBuyOrder consumerBuyOrder = this.buyOrder;
        if (consumerBuyOrder == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            consumerBuyOrder.writeToParcel(out, i2);
        }
        out.writeInt(this.supportedPaymentMethod ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvailableBuyAndSendTransfer(BigInteger sendFee, ConsumerAccount account, BigInteger transferAmount, ConsumerPaymentMethod paymentMethod, String str, String str2, BigDecimal bigDecimal, String str3, Integer num, BigDecimal bigDecimal2, ConsumerBuyOrder consumerBuyOrder, boolean z) {
        super(sendFee, account, transferAmount, null, 8, null);
        m.g(sendFee, "sendFee");
        m.g(account, "account");
        m.g(transferAmount, "transferAmount");
        m.g(paymentMethod, "paymentMethod");
        this.sendFee = sendFee;
        this.account = account;
        this.transferAmount = transferAmount;
        this.paymentMethod = paymentMethod;
        this.paymentMethodSubtitle = str;
        this.supplementalPaymentInfo = str2;
        this.buyLimit = bigDecimal;
        this.paymentMethodImageUrl = str3;
        this.localPaymentMethodImage = num;
        this.coinbaseFee = bigDecimal2;
        this.buyOrder = consumerBuyOrder;
        this.supportedPaymentMethod = z;
    }
}