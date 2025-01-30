package com.coinbase.wallet.features.send.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.features.send.dtos.GetUserAddressDTO;
import com.coinbase.wallet.features.send.dtos.SearchUsernamesDTO;
import com.coinbase.wallet.user.annotations.AuthenticatedRequest;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.t;

/* compiled from: RecipientAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/send/apis/RecipientAPIHttp;", "", "", "term", "Lh/c/b0;", "Lcom/coinbase/wallet/common/models/RPCResponse;", "Lcom/coinbase/wallet/features/send/dtos/SearchUsernamesDTO;", "search", "(Ljava/lang/String;)Lh/c/b0;", "username", "chain", "Lcom/coinbase/wallet/features/send/dtos/GetUserAddressDTO;", "getUserAddress", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface RecipientAPIHttp {
    @retrofit2.z.f("/rpc/v2/getUserAddress")
    @AuthenticatedRequest
    b0<RPCResponse<GetUserAddressDTO>> getUserAddress(@t("username") String str, @t("chain") String str2);

    @retrofit2.z.f("/rpc/v2/searchUsernames")
    @AuthenticatedRequest
    b0<RPCResponse<SearchUsernamesDTO>> search(@t("term") String str);
}