package com.coinbase.wallet.qr.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.apache.http.cookie.ClientCookie;
import org.spongycastle.i18n.TextBundle;

/* compiled from: QRCodeScanResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#B-\b\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u000b$%&'()*+,-.¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "Landroid/os/Parcelable;", "", "address", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMemoType", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "memoType", "getWalletAccountId", "walletAccountId", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;Ljava/math/BigInteger;)V", "ERC20", "Ethereum", "EthereumClassic", "HDWallet", "HexString", "Raw", "Stellar", "UnsignedInteger", "Utf8String", "WalletLink", "XRP", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$ERC20;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Ethereum;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$EthereumClassic;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$HDWallet;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$XRP;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Stellar;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Raw;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$UnsignedInteger;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Utf8String;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$HexString;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$WalletLink;", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class QRCodeScanResult implements Parcelable {
    private final String address;
    private final BigInteger amount;
    private final Blockchain blockchain;

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$ERC20;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Ljava/lang/String;", "getContractAddress", "()Ljava/lang/String;", "address", "getAddress", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ERC20 extends QRCodeScanResult {
        public static final Parcelable.Creator<ERC20> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;
        private final String contractAddress;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<ERC20> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ERC20 createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new ERC20(parcel.readString(), (BigInteger) parcel.readSerializable(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ERC20[] newArray(int i2) {
                return new ERC20[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ERC20(String address, BigInteger bigInteger, String str) {
            super(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), address, null, 4, null);
            m.g(address, "address");
            this.address = address;
            this.amount = bigInteger;
            this.contractAddress = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        public final String getContractAddress() {
            return this.contractAddress;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.address);
            out.writeSerializable(this.amount);
            out.writeString(this.contractAddress);
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$HexString;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", TextBundle.TEXT_ENTRY, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "fixedLength", "I", "getFixedLength", "<init>", "(ILjava/lang/String;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class HexString extends QRCodeScanResult {
        public static final Parcelable.Creator<HexString> CREATOR = new Creator();
        private final int fixedLength;
        private final String text;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<HexString> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HexString createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new HexString(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HexString[] newArray(int i2) {
                return new HexString[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HexString(int i2, String text) {
            super(null, null, null, 7, null);
            m.g(text, "text");
            this.fixedLength = i2;
            this.text = text;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int getFixedLength() {
            return this.fixedLength;
        }

        public final String getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeInt(this.fixedLength);
            out.writeString(this.text);
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Raw;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "", "address", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Raw extends QRCodeScanResult {
        public static final Parcelable.Creator<Raw> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Raw> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Raw createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Raw(parcel.readString(), (BigInteger) parcel.readSerializable());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Raw[] newArray(int i2) {
                return new Raw[i2];
            }
        }

        public Raw() {
            this(null, null, 3, null);
        }

        public /* synthetic */ Raw(String str, BigInteger bigInteger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : bigInteger);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.address);
            out.writeSerializable(this.amount);
        }

        public Raw(String str, BigInteger bigInteger) {
            super(null, str, bigInteger, null);
            this.address = str;
            this.amount = bigInteger;
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Stellar;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "memoHash", "Ljava/lang/String;", "getMemoHash", "()Ljava/lang/String;", "address", "getAddress", "memoText", "getMemoText", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "memoReturn", "getMemoReturn", "memoId", "getMemoId", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Stellar extends QRCodeScanResult {
        public static final Parcelable.Creator<Stellar> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;
        private final String memoHash;
        private final BigInteger memoId;
        private final String memoReturn;
        private final String memoText;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Stellar> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Stellar createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Stellar(parcel.readString(), (BigInteger) parcel.readSerializable(), parcel.readString(), (BigInteger) parcel.readSerializable(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Stellar[] newArray(int i2) {
                return new Stellar[i2];
            }
        }

        public /* synthetic */ Stellar(String str, BigInteger bigInteger, String str2, BigInteger bigInteger2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? null : bigInteger, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : bigInteger2, (i2 & 16) != 0 ? null : str3, (i2 & 32) == 0 ? str4 : null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        public final String getMemoHash() {
            return this.memoHash;
        }

        public final BigInteger getMemoId() {
            return this.memoId;
        }

        public final String getMemoReturn() {
            return this.memoReturn;
        }

        public final String getMemoText() {
            return this.memoText;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.address);
            out.writeSerializable(this.amount);
            out.writeString(this.memoText);
            out.writeSerializable(this.memoId);
            out.writeString(this.memoHash);
            out.writeString(this.memoReturn);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Stellar(String address, BigInteger bigInteger, String str, BigInteger bigInteger2, String str2, String str3) {
            super(Blockchain_StellarKt.getSTELLAR(Blockchain.Companion), address, bigInteger, null);
            m.g(address, "address");
            this.address = address;
            this.amount = bigInteger;
            this.memoText = str;
            this.memoId = bigInteger2;
            this.memoHash = str2;
            this.memoReturn = str3;
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\f\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$UnsignedInteger;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lkotlin/UInt;", "uInt", "I", "getUInt-pVg5ArA", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnsignedInteger extends QRCodeScanResult {
        public static final Parcelable.Creator<UnsignedInteger> CREATOR = new Creator();
        private final int uInt;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<UnsignedInteger> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UnsignedInteger createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new UnsignedInteger(((UInt) parcel.readValue(UnsignedInteger.class.getClassLoader())).B(), null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UnsignedInteger[] newArray(int i2) {
                return new UnsignedInteger[i2];
            }
        }

        private UnsignedInteger(int i2) {
            super(null, null, null, 7, null);
            this.uInt = i2;
        }

        public /* synthetic */ UnsignedInteger(int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: getUInt-pVg5ArA  reason: not valid java name */
        public final int m1622getUIntpVg5ArA() {
            return this.uInt;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeValue(UInt.h(this.uInt));
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Utf8String;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "string", "Ljava/lang/String;", "getString", "()Ljava/lang/String;", "fixedSize", "I", "getFixedSize", "<init>", "(ILjava/lang/String;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Utf8String extends QRCodeScanResult {
        public static final Parcelable.Creator<Utf8String> CREATOR = new Creator();
        private final int fixedSize;
        private final String string;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Utf8String> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Utf8String createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Utf8String(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Utf8String[] newArray(int i2) {
                return new Utf8String[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Utf8String(int i2, String string) {
            super(null, null, null, 7, null);
            m.g(string, "string");
            this.fixedSize = i2;
            this.string = string;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int getFixedSize() {
            return this.fixedSize;
        }

        public final String getString() {
            return this.string;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeInt(this.fixedSize);
            out.writeString(this.string);
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$WalletLink;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isParent", "Z", "()Z", "", ClientCookie.VERSION_ATTR, "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "secret", "getSecret", "Ljava/net/URL;", WalletLinkPushNotification.serverUrlKey, "Ljava/net/URL;", "getServerUrl", "()Ljava/net/URL;", WalletLinkPushNotification.sessionIdKey, "getSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Z)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class WalletLink extends QRCodeScanResult {
        public static final Parcelable.Creator<WalletLink> CREATOR = new Creator();
        private final boolean isParent;
        private final String secret;
        private final URL serverUrl;
        private final String sessionId;
        private final String version;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<WalletLink> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WalletLink createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new WalletLink(parcel.readString(), parcel.readString(), (URL) parcel.readSerializable(), parcel.readString(), parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WalletLink[] newArray(int i2) {
                return new WalletLink[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WalletLink(String sessionId, String secret, URL serverUrl, String str, boolean z) {
            super(null, null, null, 7, null);
            m.g(sessionId, "sessionId");
            m.g(secret, "secret");
            m.g(serverUrl, "serverUrl");
            this.sessionId = sessionId;
            this.secret = secret;
            this.serverUrl = serverUrl;
            this.version = str;
            this.isParent = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getSecret() {
            return this.secret;
        }

        public final URL getServerUrl() {
            return this.serverUrl;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getVersion() {
            return this.version;
        }

        public final boolean isParent() {
            return this.isParent;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.sessionId);
            out.writeString(this.secret);
            out.writeSerializable(this.serverUrl);
            out.writeString(this.version);
            out.writeInt(this.isParent ? 1 : 0);
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$XRP;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "address", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", "Lkotlin/UInt;", "destinationTag", "Lkotlin/UInt;", "getDestinationTag-0hXNFcg", "()Lkotlin/UInt;", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;Lkotlin/UInt;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class XRP extends QRCodeScanResult {
        public static final Parcelable.Creator<XRP> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;
        private final UInt destinationTag;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<XRP> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final XRP createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new XRP(parcel.readString(), (BigInteger) parcel.readSerializable(), (UInt) parcel.readValue(XRP.class.getClassLoader()), null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final XRP[] newArray(int i2) {
                return new XRP[i2];
            }
        }

        public /* synthetic */ XRP(String str, BigInteger bigInteger, UInt uInt, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? null : bigInteger, (i2 & 4) != 0 ? null : uInt, null);
        }

        public /* synthetic */ XRP(String str, BigInteger bigInteger, UInt uInt, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, bigInteger, uInt);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        /* renamed from: getDestinationTag-0hXNFcg  reason: not valid java name */
        public final UInt m1623getDestinationTag0hXNFcg() {
            return this.destinationTag;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.address);
            out.writeSerializable(this.amount);
            out.writeValue(this.destinationTag);
        }

        private XRP(String str, BigInteger bigInteger, UInt uInt) {
            super(Blockchain_RippleKt.getXRP(Blockchain.Companion), str, bigInteger, null);
            this.address = str;
            this.amount = bigInteger;
            this.destinationTag = uInt;
        }
    }

    private QRCodeScanResult(Blockchain blockchain, String str, BigInteger bigInteger) {
        this.blockchain = blockchain;
        this.address = str;
        this.amount = bigInteger;
    }

    public /* synthetic */ QRCodeScanResult(Blockchain blockchain, String str, BigInteger bigInteger, DefaultConstructorMarker defaultConstructorMarker) {
        this(blockchain, str, bigInteger);
    }

    public String getAddress() {
        return this.address;
    }

    public BigInteger getAmount() {
        return this.amount;
    }

    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final TxMetadataKey getMemoType() {
        if (this instanceof Stellar) {
            Stellar stellar = (Stellar) this;
            if (stellar.getMemoText() != null) {
                return TxMetadataKey_StellarKt.getMemoText(TxMetadataKey.Companion);
            }
            if (stellar.getMemoId() != null) {
                return TxMetadataKey_StellarKt.getMemoId(TxMetadataKey.Companion);
            }
            if (stellar.getMemoHash() != null) {
                return TxMetadataKey_StellarKt.getMemoHash(TxMetadataKey.Companion);
            }
            if (stellar.getMemoReturn() != null) {
                return TxMetadataKey_StellarKt.getMemoReturn(TxMetadataKey.Companion);
            }
            return null;
        }
        return null;
    }

    public final String getWalletAccountId() {
        List l2;
        if (this instanceof XRP) {
            UInt m1623getDestinationTag0hXNFcg = ((XRP) this).m1623getDestinationTag0hXNFcg();
            if (m1623getDestinationTag0hXNFcg == null) {
                return null;
            }
            return UInt.A(m1623getDestinationTag0hXNFcg.B());
        } else if (this instanceof Stellar) {
            String[] strArr = new String[4];
            Stellar stellar = (Stellar) this;
            strArr[0] = stellar.getMemoText();
            BigInteger memoId = stellar.getMemoId();
            strArr[1] = memoId != null ? memoId.toString() : null;
            strArr[2] = stellar.getMemoHash();
            strArr[3] = stellar.getMemoReturn();
            l2 = r.l(strArr);
            return (String) p.a0(l2);
        } else {
            return null;
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$Ethereum;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigDecimal;", "gasLimit", "Ljava/math/BigDecimal;", "getGasLimit", "()Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "", "address", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", RouteActionKey.RouteActionKeys.CHAIN_ID, "Ljava/lang/Integer;", "getChainId", "()Ljava/lang/Integer;", "gasPrice", "getGasPrice", "", "data", "[B", "getData", "()[B", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/Integer;[B)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Ethereum extends QRCodeScanResult {
        public static final Parcelable.Creator<Ethereum> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;
        private final Integer chainId;
        private final byte[] data;
        private final BigDecimal gasLimit;
        private final BigDecimal gasPrice;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Ethereum> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Ethereum createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Ethereum(parcel.readString(), (BigInteger) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.createByteArray());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Ethereum[] newArray(int i2) {
                return new Ethereum[i2];
            }
        }

        public /* synthetic */ Ethereum(String str, BigInteger bigInteger, BigDecimal bigDecimal, BigDecimal bigDecimal2, Integer num, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, bigInteger, (i2 & 4) != 0 ? BigDecimal.ZERO : bigDecimal, (i2 & 8) != 0 ? BigDecimal.ZERO : bigDecimal2, (i2 & 16) != 0 ? null : num, bArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        public final Integer getChainId() {
            return this.chainId;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final BigDecimal getGasLimit() {
            return this.gasLimit;
        }

        public final BigDecimal getGasPrice() {
            return this.gasPrice;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            int intValue;
            m.g(out, "out");
            out.writeString(this.address);
            out.writeSerializable(this.amount);
            out.writeSerializable(this.gasLimit);
            out.writeSerializable(this.gasPrice);
            Integer num = this.chainId;
            if (num == null) {
                intValue = 0;
            } else {
                out.writeInt(1);
                intValue = num.intValue();
            }
            out.writeInt(intValue);
            out.writeByteArray(this.data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ethereum(String address, BigInteger bigInteger, BigDecimal bigDecimal, BigDecimal bigDecimal2, Integer num, byte[] bArr) {
            super(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), address, bigInteger, null);
            m.g(address, "address");
            this.address = address;
            this.amount = bigInteger;
            this.gasLimit = bigDecimal;
            this.gasPrice = bigDecimal2;
            this.chainId = num;
            this.data = bArr;
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$EthereumClassic;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigDecimal;", "gasLimit", "Ljava/math/BigDecimal;", "getGasLimit", "()Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "", "address", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", "gasPrice", "getGasPrice", "", "data", "[B", "getData", "()[B", "<init>", "(Ljava/lang/String;Ljava/math/BigInteger;[BLjava/math/BigDecimal;Ljava/math/BigDecimal;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class EthereumClassic extends QRCodeScanResult {
        public static final Parcelable.Creator<EthereumClassic> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;
        private final byte[] data;
        private final BigDecimal gasLimit;
        private final BigDecimal gasPrice;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<EthereumClassic> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EthereumClassic createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new EthereumClassic(parcel.readString(), (BigInteger) parcel.readSerializable(), parcel.createByteArray(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EthereumClassic[] newArray(int i2) {
                return new EthereumClassic[i2];
            }
        }

        public /* synthetic */ EthereumClassic(String str, BigInteger bigInteger, byte[] bArr, BigDecimal bigDecimal, BigDecimal bigDecimal2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, bigInteger, bArr, (i2 & 8) != 0 ? BigDecimal.ZERO : bigDecimal, (i2 & 16) != 0 ? BigDecimal.ZERO : bigDecimal2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final BigDecimal getGasLimit() {
            return this.gasLimit;
        }

        public final BigDecimal getGasPrice() {
            return this.gasPrice;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.address);
            out.writeSerializable(this.amount);
            out.writeByteArray(this.data);
            out.writeSerializable(this.gasLimit);
            out.writeSerializable(this.gasPrice);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EthereumClassic(String address, BigInteger bigInteger, byte[] bArr, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            super(Blockchain_EthereumKt.getETHEREUM_CLASSIC(Blockchain.Companion), address, bigInteger, null);
            m.g(address, "address");
            this.address = address;
            this.amount = bigInteger;
            this.data = bArr;
            this.gasLimit = bigDecimal;
            this.gasPrice = bigDecimal2;
        }
    }

    /* compiled from: QRCodeScanResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u001f\u001a\u00020\u001e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/qr/models/QRCodeScanResult$HDWallet;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", ApiConstants.MESSAGE, "getMessage", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Ljava/math/BigInteger;", "amount", "Ljava/math/BigInteger;", "getAmount", "()Ljava/math/BigInteger;", "address", "getAddress", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class HDWallet extends QRCodeScanResult {
        public static final Parcelable.Creator<HDWallet> CREATOR = new Creator();
        private final String address;
        private final BigInteger amount;
        private final Blockchain blockchain;
        private final CurrencyCode currencyCode;
        private final String label;
        private final String message;

        /* compiled from: QRCodeScanResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<HDWallet> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HDWallet createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new HDWallet(parcel.readString(), (CurrencyCode) parcel.readParcelable(HDWallet.class.getClassLoader()), (Blockchain) parcel.readParcelable(HDWallet.class.getClassLoader()), (BigInteger) parcel.readSerializable(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HDWallet[] newArray(int i2) {
                return new HDWallet[i2];
            }
        }

        public /* synthetic */ HDWallet(String str, CurrencyCode currencyCode, Blockchain blockchain, BigInteger bigInteger, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, currencyCode, blockchain, (i2 & 8) != 0 ? null : bigInteger, (i2 & 16) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2, (i2 & 32) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public String getAddress() {
            return this.address;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public BigInteger getAmount() {
            return this.amount;
        }

        @Override // com.coinbase.wallet.qr.models.QRCodeScanResult
        public Blockchain getBlockchain() {
            return this.blockchain;
        }

        public final CurrencyCode getCurrencyCode() {
            return this.currencyCode;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getMessage() {
            return this.message;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.address);
            out.writeParcelable(this.currencyCode, i2);
            out.writeParcelable(this.blockchain, i2);
            out.writeSerializable(this.amount);
            out.writeString(this.label);
            out.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HDWallet(String address, CurrencyCode currencyCode, Blockchain blockchain, BigInteger bigInteger, String str, String str2) {
            super(blockchain, address, bigInteger, null);
            m.g(address, "address");
            m.g(currencyCode, "currencyCode");
            m.g(blockchain, "blockchain");
            this.address = address;
            this.currencyCode = currencyCode;
            this.blockchain = blockchain;
            this.amount = bigInteger;
            this.label = str;
            this.message = str2;
        }
    }

    public /* synthetic */ QRCodeScanResult(Blockchain blockchain, String str, BigInteger bigInteger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : blockchain, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : bigInteger, null);
    }
}