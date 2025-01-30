package com.coinbase.wallet.features.signer.viewmodel;

import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.walletlink.models.HostRequestId;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SignatureRequestViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "RequestEthereumAccountsViewState", "SignAndSubmitTxViewState", "SignMessageViewState", "SwitchEthereumChainViewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SignatureRequestViewState {
    private final String uuid;

    /* compiled from: SignatureRequestViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$RequestEthereumAccountsViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "isParent", "Z", "()Z", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RequestEthereumAccountsViewState extends SignatureRequestViewState {
        private final HostRequestId hostRequestId;
        private final boolean isParent;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestEthereumAccountsViewState(String uuid, HostRequestId hostRequestId, boolean z) {
            super(uuid, null);
            kotlin.jvm.internal.m.g(uuid, "uuid");
            kotlin.jvm.internal.m.g(hostRequestId, "hostRequestId");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.isParent = z;
        }

        public final HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        @Override // com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState
        public String getUuid() {
            return this.uuid;
        }

        public final boolean isParent() {
            return this.isParent;
        }
    }

    /* compiled from: SignatureRequestViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u00109\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u00102\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u00105\u001a\u000204\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b;\u0010<R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001c\u0010!\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000bR\u0019\u0010$\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\u0010R\u0019\u00105\u001a\u0002048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u00109\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b:\u0010\u000b¨\u0006="}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "", AdjustableMinerFeeArgs.NONCE, "Ljava/lang/Integer;", "getNonce", "()Ljava/lang/Integer;", "", "toAddress", "Ljava/lang/String;", "getToAddress", "()Ljava/lang/String;", "Ljava/math/BigInteger;", "weiValue", "Ljava/math/BigInteger;", "getWeiValue", "()Ljava/math/BigInteger;", "maxPriorityFeePerGas", "getMaxPriorityFeePerGas", "gasLimit", "getGasLimit", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "Landroid/net/Uri;", "requesterURL", "Landroid/net/Uri;", "getRequesterURL", "()Landroid/net/Uri;", "maxFeePerGas", "getMaxFeePerGas", "uuid", "getUuid", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "()Lcom/coinbase/wallet/blockchains/models/Network;", "", "data", "[B", "getData", "()[B", "gasPrice", "getGasPrice", "", "shouldSubmit", "Z", "getShouldSubmit", "()Z", "fromAddress", "getFromAddress", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;ZLandroid/net/Uri;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignAndSubmitTxViewState extends SignatureRequestViewState {
        private final byte[] data;
        private final String fromAddress;
        private final BigInteger gasLimit;
        private final BigInteger gasPrice;
        private final HostRequestId hostRequestId;
        private final BigInteger maxFeePerGas;
        private final BigInteger maxPriorityFeePerGas;
        private final Network network;
        private final Integer nonce;
        private final Uri requesterURL;
        private final boolean shouldSubmit;
        private final String toAddress;
        private final String uuid;
        private final Wallet wallet;
        private final BigInteger weiValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignAndSubmitTxViewState(String uuid, HostRequestId hostRequestId, Wallet wallet, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Network network, boolean z, Uri uri) {
            super(uuid, null);
            kotlin.jvm.internal.m.g(uuid, "uuid");
            kotlin.jvm.internal.m.g(wallet, "wallet");
            kotlin.jvm.internal.m.g(fromAddress, "fromAddress");
            kotlin.jvm.internal.m.g(weiValue, "weiValue");
            kotlin.jvm.internal.m.g(data, "data");
            kotlin.jvm.internal.m.g(network, "network");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.wallet = wallet;
            this.fromAddress = fromAddress;
            this.toAddress = str;
            this.weiValue = weiValue;
            this.data = data;
            this.nonce = num;
            this.gasPrice = bigInteger;
            this.maxFeePerGas = bigInteger2;
            this.maxPriorityFeePerGas = bigInteger3;
            this.gasLimit = bigInteger4;
            this.network = network;
            this.shouldSubmit = z;
            this.requesterURL = uri;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final String getFromAddress() {
            return this.fromAddress;
        }

        public final BigInteger getGasLimit() {
            return this.gasLimit;
        }

        public final BigInteger getGasPrice() {
            return this.gasPrice;
        }

        public final HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final BigInteger getMaxFeePerGas() {
            return this.maxFeePerGas;
        }

        public final BigInteger getMaxPriorityFeePerGas() {
            return this.maxPriorityFeePerGas;
        }

        public final Network getNetwork() {
            return this.network;
        }

        public final Integer getNonce() {
            return this.nonce;
        }

        public final Uri getRequesterURL() {
            return this.requesterURL;
        }

        public final boolean getShouldSubmit() {
            return this.shouldSubmit;
        }

        public final String getToAddress() {
            return this.toAddress;
        }

        @Override // com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState
        public String getUuid() {
            return this.uuid;
        }

        public final Wallet getWallet() {
            return this.wallet;
        }

        public final BigInteger getWeiValue() {
            return this.weiValue;
        }
    }

    /* compiled from: SignatureRequestViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "", "isPrefixed", "Z", "()Z", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "typedDataJson", "getTypedDataJson", ApiConstants.MESSAGE, "getMessage", "address", "getAddress", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignMessageViewState extends SignatureRequestViewState {
        private final String address;
        private final HostRequestId hostRequestId;
        private final boolean isPrefixed;
        private final String message;
        private final String typedDataJson;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignMessageViewState(String uuid, HostRequestId hostRequestId, String address, String message, boolean z, String str) {
            super(uuid, null);
            kotlin.jvm.internal.m.g(uuid, "uuid");
            kotlin.jvm.internal.m.g(address, "address");
            kotlin.jvm.internal.m.g(message, "message");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.address = address;
            this.message = message;
            this.isPrefixed = z;
            this.typedDataJson = str;
        }

        public final String getAddress() {
            return this.address;
        }

        public final HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTypedDataJson() {
            return this.typedDataJson;
        }

        @Override // com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState
        public String getUuid() {
            return this.uuid;
        }

        public final boolean isPrefixed() {
            return this.isPrefixed;
        }
    }

    /* compiled from: SignatureRequestViewState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SwitchEthereumChainViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "I", "getChainId", "()I", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SwitchEthereumChainViewState extends SignatureRequestViewState {
        private final int chainId;
        private final HostRequestId hostRequestId;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchEthereumChainViewState(String uuid, HostRequestId hostRequestId, int i2) {
            super(uuid, null);
            kotlin.jvm.internal.m.g(uuid, "uuid");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.chainId = i2;
        }

        public final int getChainId() {
            return this.chainId;
        }

        public final HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        @Override // com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState
        public String getUuid() {
            return this.uuid;
        }
    }

    private SignatureRequestViewState(String str) {
        this.uuid = str;
    }

    public /* synthetic */ SignatureRequestViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String getUuid() {
        return this.uuid;
    }
}