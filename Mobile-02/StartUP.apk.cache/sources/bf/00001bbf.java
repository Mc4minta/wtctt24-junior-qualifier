package com.coinbase.wallet.ethereum.apis;

import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559DTO;
import com.coinbase.wallet.ethereum.dtos.AdjustableMinerFee1559Result;
import com.coinbase.wallet.ethereum.models.AdjustableMinerFeeResponse;
import com.coinbase.wallet.features.send.dtos.AdjustableMinerFeeDTO;
import com.coinbase.wallet.features.send.dtos.AdjustableMinerFeeDTOKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: MinerFeeAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/AdjustableMinerFeeResponse;", "getMinerFeeEstimates", "(I)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "get1559MinerFeeEstimates", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeHTTP;", "api", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeHTTP;", "<init>", "(Lcom/coinbase/wallet/ethereum/apis/MinerFeeHTTP;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MinerFeeAPI {
    private final MinerFeeHTTP api;

    public MinerFeeAPI(MinerFeeHTTP api) {
        m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ AdjustableMinerFee1559Result a(AdjustableMinerFee1559DTO adjustableMinerFee1559DTO) {
        return m1094get1559MinerFeeEstimates$lambda1(adjustableMinerFee1559DTO);
    }

    public static /* synthetic */ AdjustableMinerFeeResponse b(AdjustableMinerFeeDTO adjustableMinerFeeDTO) {
        return m1095getMinerFeeEstimates$lambda0(adjustableMinerFeeDTO);
    }

    /* renamed from: get1559MinerFeeEstimates$lambda-1 */
    public static final AdjustableMinerFee1559Result m1094get1559MinerFeeEstimates$lambda1(AdjustableMinerFee1559DTO it) {
        m.g(it, "it");
        return it.getResult();
    }

    /* renamed from: getMinerFeeEstimates$lambda-0 */
    public static final AdjustableMinerFeeResponse m1095getMinerFeeEstimates$lambda0(AdjustableMinerFeeDTO result) {
        m.g(result, "result");
        return AdjustableMinerFeeDTOKt.toAdjustableMinerFeeResponse(result);
    }

    public final b0<AdjustableMinerFee1559Result> get1559MinerFeeEstimates(int i2) {
        b0 map = this.api.get1559MinerFeeEstimates(1).map(new n() { // from class: com.coinbase.wallet.ethereum.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MinerFeeAPI.a((AdjustableMinerFee1559DTO) obj);
            }
        });
        m.f(map, "api.get1559MinerFeeEstimates(1).map { it.result }");
        return map;
    }

    public final b0<AdjustableMinerFeeResponse> getMinerFeeEstimates(int i2) {
        b0 map = this.api.getMinerFeeEstimates(1).map(new n() { // from class: com.coinbase.wallet.ethereum.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MinerFeeAPI.b((AdjustableMinerFeeDTO) obj);
            }
        });
        m.f(map, "api.getMinerFeeEstimates(1) // when we support chainId, pass it in here\n            .map { result -> result.toAdjustableMinerFeeResponse() }");
        return map;
    }
}