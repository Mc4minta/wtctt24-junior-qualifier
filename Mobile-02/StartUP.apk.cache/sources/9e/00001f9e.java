package com.coinbase.wallet.features.send.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: AdjustableMinerFeeArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJE\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeArgs;", "", "", "flowName", "Ljava/math/BigInteger;", "minerFeeLimit", "fromAddress", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ethereumChain", "recommendedGasPrice", "", AdjustableMinerFeeArgs.NONCE, "Landroid/os/Bundle;", "createArgs", "(Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Lcom/coinbase/ciphercore/ethereum/EthereumChain;Ljava/math/BigInteger;Ljava/lang/Integer;)Landroid/os/Bundle;", "FLOW_NAME", "Ljava/lang/String;", "MINER_FEE_LIMIT", "FROM_ADDRESS", "RECOMMENDED_GAS_PRICE", "NONCE", EthereumChain_EthereumKt.ETHEREUM_PREFIX, "resultKey", "getResultKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeArgs {
    public static final String ETHEREUM_CHAIN = "ethereum_chain";
    public static final String FLOW_NAME = "flow_name";
    public static final String FROM_ADDRESS = "from_address";
    public static final String MINER_FEE_LIMIT = "miner_fee_limit";
    public static final String NONCE = "nonce";
    public static final String RECOMMENDED_GAS_PRICE = "recommended_gas_price";
    public static final AdjustableMinerFeeArgs INSTANCE = new AdjustableMinerFeeArgs();
    private static final String resultKey = "adjustable_fee_result_key";

    private AdjustableMinerFeeArgs() {
    }

    public final Bundle createArgs(String flowName, BigInteger minerFeeLimit, String fromAddress, EthereumChain ethereumChain, BigInteger bigInteger, Integer num) {
        m.g(flowName, "flowName");
        m.g(minerFeeLimit, "minerFeeLimit");
        m.g(fromAddress, "fromAddress");
        m.g(ethereumChain, "ethereumChain");
        return b.a(u.a(FLOW_NAME, flowName), u.a(MINER_FEE_LIMIT, minerFeeLimit), u.a(FROM_ADDRESS, fromAddress), u.a(ETHEREUM_CHAIN, ethereumChain), u.a(RECOMMENDED_GAS_PRICE, bigInteger), u.a(NONCE, num));
    }

    public final String getResultKey() {
        return resultKey;
    }
}