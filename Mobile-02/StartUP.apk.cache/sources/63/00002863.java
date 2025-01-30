package com.coinbase.wallet.wallets.apis;

import com.coinbase.wallet.wallets.dtos.WatchAddressDTO;
import com.coinbase.wallet.wallets.dtos.WatchAddressParamsDTO;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.o;

/* compiled from: WatchAddressAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/wallets/apis/BlockchainAddressHTTP;", "", "Lcom/coinbase/wallet/wallets/dtos/WatchAddressParamsDTO;", "params", "Lh/c/b0;", "Lcom/coinbase/wallet/wallets/dtos/WatchAddressDTO;", "watchAddresses", "(Lcom/coinbase/wallet/wallets/dtos/WatchAddressParamsDTO;)Lh/c/b0;", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface BlockchainAddressHTTP {
    @o("/rpc/v2/watchAddress2")
    b0<WatchAddressDTO> watchAddresses(@retrofit2.z.a WatchAddressParamsDTO watchAddressParamsDTO);
}