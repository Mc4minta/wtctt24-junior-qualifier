package com.coinbase.wallet.features.send.dtos;

import com.coinbase.wallet.ethereum.models.AdjustableMinerFeeResponse;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeWaitTime;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeDTO;", "Lcom/coinbase/wallet/ethereum/models/AdjustableMinerFeeResponse;", "toAdjustableMinerFeeResponse", "(Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeDTO;)Lcom/coinbase/wallet/ethereum/models/AdjustableMinerFeeResponse;", "Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeWaitTime;", "toAdjustableMinerFeeWaitTime", "(Lcom/coinbase/wallet/features/send/dtos/AdjustableMinerFeeWaitTimeDTO;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeWaitTime;", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeDTOKt {
    public static final AdjustableMinerFeeResponse toAdjustableMinerFeeResponse(AdjustableMinerFeeDTO adjustableMinerFeeDTO) {
        int r;
        m.g(adjustableMinerFeeDTO, "<this>");
        BigInteger slow = adjustableMinerFeeDTO.getResult().getSlow();
        BigInteger normal = adjustableMinerFeeDTO.getResult().getNormal();
        BigInteger fast = adjustableMinerFeeDTO.getResult().getFast();
        List<AdjustableMinerFeeWaitTimeDTO> waitTimes = adjustableMinerFeeDTO.getResult().getWaitTimes();
        r = s.r(waitTimes, 10);
        ArrayList arrayList = new ArrayList(r);
        for (AdjustableMinerFeeWaitTimeDTO adjustableMinerFeeWaitTimeDTO : waitTimes) {
            arrayList.add(toAdjustableMinerFeeWaitTime(adjustableMinerFeeWaitTimeDTO));
        }
        return new AdjustableMinerFeeResponse(slow, normal, fast, arrayList);
    }

    public static final AdjustableMinerFeeWaitTime toAdjustableMinerFeeWaitTime(AdjustableMinerFeeWaitTimeDTO adjustableMinerFeeWaitTimeDTO) {
        m.g(adjustableMinerFeeWaitTimeDTO, "<this>");
        return new AdjustableMinerFeeWaitTime(adjustableMinerFeeWaitTimeDTO.getPrice(), adjustableMinerFeeWaitTimeDTO.getWaitTime());
    }
}