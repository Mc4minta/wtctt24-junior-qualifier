package com.coinbase.wallet.features.signer.models;

import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.walletlink.models.HostRequestId;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SignatureRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u000e\u000f\u0010\u0011\u0012B\u001b\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0005\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;)V", "RequestCanceled", "RequestEthereumAccounts", "SignAndSubmitTx", "SignMessage", "SwitchEthereumChain", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest$SignMessage;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest$SignAndSubmitTx;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest$RequestEthereumAccounts;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest$SwitchEthereumChain;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest$RequestCanceled;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SignatureRequest {
    private final HostRequestId hostRequestId;
    private final String uuid;

    /* compiled from: SignatureRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest$RequestCanceled;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RequestCanceled extends SignatureRequest {
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestCanceled(String uuid, HostRequestId hostRequestId) {
            super(uuid, hostRequestId, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public String getUuid() {
            return this.uuid;
        }
    }

    /* compiled from: SignatureRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest$RequestEthereumAccounts;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "isParent", "Z", "()Z", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RequestEthereumAccounts extends SignatureRequest {
        private final HostRequestId hostRequestId;
        private final boolean isParent;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestEthereumAccounts(String uuid, HostRequestId hostRequestId, boolean z) {
            super(uuid, hostRequestId, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.isParent = z;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public String getUuid() {
            return this.uuid;
        }

        public final boolean isParent() {
            return this.isParent;
        }
    }

    /* compiled from: SignatureRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b5\u00106R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\u001f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001b\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000bR\u0019\u0010#\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u001b\u0010%\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b&\u0010\u000bR\u0019\u0010(\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest$SignAndSubmitTx;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "Landroid/net/Uri;", "requesterUrl", "Landroid/net/Uri;", "getRequesterUrl", "()Landroid/net/Uri;", "Ljava/math/BigInteger;", "gasPriceInWei", "Ljava/math/BigInteger;", "getGasPriceInWei", "()Ljava/math/BigInteger;", "maxFeePerGas", "getMaxFeePerGas", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "I", "getChainId", "()I", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "toAddress", "Ljava/lang/String;", "getToAddress", "()Ljava/lang/String;", "uuid", "getUuid", "weiValue", "getWeiValue", "maxPriorityFeePerGas", "getMaxPriorityFeePerGas", "fromAddress", "getFromAddress", "gasLimit", "getGasLimit", "", "shouldSubmit", "Z", "getShouldSubmit", "()Z", "", "data", "[B", "getData", "()[B", AdjustableMinerFeeArgs.NONCE, "Ljava/lang/Integer;", "getNonce", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;IZLandroid/net/Uri;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignAndSubmitTx extends SignatureRequest {
        private final int chainId;
        private final byte[] data;
        private final String fromAddress;
        private final BigInteger gasLimit;
        private final BigInteger gasPriceInWei;
        private final HostRequestId hostRequestId;
        private final BigInteger maxFeePerGas;
        private final BigInteger maxPriorityFeePerGas;
        private final Integer nonce;
        private final Uri requesterUrl;
        private final boolean shouldSubmit;
        private final String toAddress;
        private final String uuid;
        private final BigInteger weiValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignAndSubmitTx(String uuid, HostRequestId hostRequestId, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i2, boolean z, Uri uri) {
            super(uuid, hostRequestId, null);
            m.g(uuid, "uuid");
            m.g(fromAddress, "fromAddress");
            m.g(weiValue, "weiValue");
            m.g(data, "data");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.fromAddress = fromAddress;
            this.toAddress = str;
            this.weiValue = weiValue;
            this.data = data;
            this.nonce = num;
            this.gasPriceInWei = bigInteger;
            this.maxFeePerGas = bigInteger2;
            this.maxPriorityFeePerGas = bigInteger3;
            this.gasLimit = bigInteger4;
            this.chainId = i2;
            this.shouldSubmit = z;
            this.requesterUrl = uri;
        }

        public final int getChainId() {
            return this.chainId;
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

        public final BigInteger getGasPriceInWei() {
            return this.gasPriceInWei;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final BigInteger getMaxFeePerGas() {
            return this.maxFeePerGas;
        }

        public final BigInteger getMaxPriorityFeePerGas() {
            return this.maxPriorityFeePerGas;
        }

        public final Integer getNonce() {
            return this.nonce;
        }

        public final Uri getRequesterUrl() {
            return this.requesterUrl;
        }

        public final boolean getShouldSubmit() {
            return this.shouldSubmit;
        }

        public final String getToAddress() {
            return this.toAddress;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public String getUuid() {
            return this.uuid;
        }

        public final BigInteger getWeiValue() {
            return this.weiValue;
        }
    }

    /* compiled from: SignatureRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest$SignMessage;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "address", "getAddress", ApiConstants.MESSAGE, "getMessage", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", "isPrefixed", "Z", "()Z", "typedDataJson", "getTypedDataJson", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SignMessage extends SignatureRequest {
        private final String address;
        private final HostRequestId hostRequestId;
        private final boolean isPrefixed;
        private final String message;
        private final String typedDataJson;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignMessage(String uuid, HostRequestId hostRequestId, String address, String message, boolean z, String str) {
            super(uuid, hostRequestId, null);
            m.g(uuid, "uuid");
            m.g(address, "address");
            m.g(message, "message");
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

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTypedDataJson() {
            return this.typedDataJson;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public String getUuid() {
            return this.uuid;
        }

        public final boolean isPrefixed() {
            return this.isPrefixed;
        }
    }

    /* compiled from: SignatureRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest$SwitchEthereumChain;", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/HostRequestId;", "hostRequestId", "Lcom/coinbase/walletlink/models/HostRequestId;", "getHostRequestId", "()Lcom/coinbase/walletlink/models/HostRequestId;", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "I", "getChainId", "()I", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/HostRequestId;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SwitchEthereumChain extends SignatureRequest {
        private final int chainId;
        private final HostRequestId hostRequestId;
        private final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchEthereumChain(String uuid, HostRequestId hostRequestId, int i2) {
            super(uuid, hostRequestId, null);
            m.g(uuid, "uuid");
            this.uuid = uuid;
            this.hostRequestId = hostRequestId;
            this.chainId = i2;
        }

        public final int getChainId() {
            return this.chainId;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public HostRequestId getHostRequestId() {
            return this.hostRequestId;
        }

        @Override // com.coinbase.wallet.features.signer.models.SignatureRequest
        public String getUuid() {
            return this.uuid;
        }
    }

    private SignatureRequest(String str, HostRequestId hostRequestId) {
        this.uuid = str;
        this.hostRequestId = hostRequestId;
    }

    public /* synthetic */ SignatureRequest(String str, HostRequestId hostRequestId, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, hostRequestId);
    }

    public HostRequestId getHostRequestId() {
        return this.hostRequestId;
    }

    public String getUuid() {
        return this.uuid;
    }
}