package com.coinbase.wallet.stellar.api;

import com.coinbase.wallet.stellar.dtos.GetTimeResultDTO;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.k;

/* compiled from: TimeAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/stellar/api/TimeHTTP;", "", "Lh/c/b0;", "Lcom/coinbase/wallet/stellar/dtos/GetTimeResultDTO;", "getCurrentTime", "()Lh/c/b0;", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface TimeHTTP {
    @f("/rpc/v2/getCurrentTime")
    @k({"Cache-Control: no-cache"})
    b0<GetTimeResultDTO> getCurrentTime();
}