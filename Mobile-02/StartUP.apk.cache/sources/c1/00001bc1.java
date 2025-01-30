package com.coinbase.wallet.ethereum.apis;

import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559DTO;
import com.coinbase.wallet.features.send.dtos.AdjustableMinerFeeDTO;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.t;

/* compiled from: MinerFeeAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/ethereum/apis/MinerFeeHTTP;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeDTO;", "getMinerFeeEstimates", "(I)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559DTO;", "get1559MinerFeeEstimates", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface MinerFeeHTTP {
    @retrofit2.z.f("/rpc/v2/get1559GasPrices")
    b0<AdjustableMinerFee1559DTO> get1559MinerFeeEstimates(@t("chainId") int i2);

    @retrofit2.z.f("rpc/v2/getGasPrices")
    b0<AdjustableMinerFeeDTO> getMinerFeeEstimates(@t("chainId") int i2);
}