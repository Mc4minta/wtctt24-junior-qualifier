package com.coinbase.ciphercore;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CipherCoreConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreConfig;", "", "Lcom/coinbase/ciphercore/EthereumConfig;", "component1", "()Lcom/coinbase/ciphercore/EthereumConfig;", WalletConstants.URIPrefixes.ETH, "copy", "(Lcom/coinbase/ciphercore/EthereumConfig;)Lcom/coinbase/ciphercore/CipherCoreConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/ciphercore/EthereumConfig;", "getEthereum", "setEthereum", "(Lcom/coinbase/ciphercore/EthereumConfig;)V", "<init>", "Companion", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CipherCoreConfig {
    public static final Companion Companion = new Companion(null);
    @Json(name = WalletConstants.URIPrefixes.ETH)
    private EthereumConfig ethereum;

    /* compiled from: CipherCoreConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreConfig$Companion;", "", "", "walletApiServiceUrl", "Lcom/coinbase/ciphercore/CipherCoreConfig;", "create", "(Ljava/lang/String;)Lcom/coinbase/ciphercore/CipherCoreConfig;", "<init>", "()V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CipherCoreConfig create(String walletApiServiceUrl) {
            int r;
            List I0;
            kotlin.jvm.internal.m.g(walletApiServiceUrl, "walletApiServiceUrl");
            EthereumChain[] values = EthereumChain.values();
            ArrayList<EthereumChain> arrayList = new ArrayList();
            int length = values.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                EthereumChain ethereumChain = values[i3];
                if (ethereumChain != EthereumChain.ETHEREUM_CLASSIC_MAINNET) {
                    arrayList.add(ethereumChain);
                }
            }
            r = kotlin.a0.s.r(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (EthereumChain ethereumChain2 : arrayList) {
                arrayList2.add(new EthereumNetworkConfig(ethereumChain2.getDisplayName(), ethereumChain2.getRpcUrl(), ethereumChain2 == EthereumChain.ETHEREUM_MAINNET ? kotlin.jvm.internal.m.o(walletApiServiceUrl, "/rpc/v2/getMainnetGasPrices") : ""));
            }
            I0 = kotlin.a0.z.I0(arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : I0) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    r.q();
                }
                linkedHashMap.put(Integer.valueOf(((EthereumChain) arrayList.get(i2)).getChainId()), (EthereumNetworkConfig) obj);
                i2 = i4;
            }
            return new CipherCoreConfig(new EthereumConfig(linkedHashMap));
        }
    }

    public CipherCoreConfig(EthereumConfig ethereum) {
        kotlin.jvm.internal.m.g(ethereum, "ethereum");
        this.ethereum = ethereum;
    }

    public static /* synthetic */ CipherCoreConfig copy$default(CipherCoreConfig cipherCoreConfig, EthereumConfig ethereumConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ethereumConfig = cipherCoreConfig.ethereum;
        }
        return cipherCoreConfig.copy(ethereumConfig);
    }

    public final EthereumConfig component1() {
        return this.ethereum;
    }

    public final CipherCoreConfig copy(EthereumConfig ethereum) {
        kotlin.jvm.internal.m.g(ethereum, "ethereum");
        return new CipherCoreConfig(ethereum);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CipherCoreConfig) && kotlin.jvm.internal.m.c(this.ethereum, ((CipherCoreConfig) obj).ethereum);
    }

    public final EthereumConfig getEthereum() {
        return this.ethereum;
    }

    public int hashCode() {
        return this.ethereum.hashCode();
    }

    public final void setEthereum(EthereumConfig ethereumConfig) {
        kotlin.jvm.internal.m.g(ethereumConfig, "<set-?>");
        this.ethereum = ethereumConfig;
    }

    public String toString() {
        return "CipherCoreConfig(ethereum=" + this.ethereum + ')';
    }
}