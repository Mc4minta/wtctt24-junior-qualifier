package com.coinbase.wallet.user.apis;

import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.user.annotations.AuthenticatedRequest;
import com.coinbase.wallet.user.dtos.AddAddressesRequestDTO;
import com.coinbase.wallet.user.dtos.AddAddressesResponseDTO;
import com.coinbase.wallet.user.dtos.CheckUsernameAvailabilityResponseDTO;
import com.coinbase.wallet.user.dtos.UpdateUserProfileRequestDTO;
import com.coinbase.wallet.user.dtos.UpdateUserProfileResponseDTO;
import com.coinbase.wallet.user.models.User;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.t;

/* compiled from: UserApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004H'¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00042\b\b\u0001\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/user/apis/UserApiHttp;", "", "", "username", "Lh/c/b0;", "Lcom/coinbase/wallet/common/models/RPCResponse;", "Lcom/coinbase/wallet/user/dtos/CheckUsernameAvailabilityResponseDTO;", "checkUsernameAvailability", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/user/models/User;", "getUserProfile", "()Lh/c/b0;", "Lcom/coinbase/wallet/user/dtos/UpdateUserProfileRequestDTO;", "rpcParams", "Lcom/coinbase/wallet/user/dtos/UpdateUserProfileResponseDTO;", "updateUserProfile", "(Lcom/coinbase/wallet/user/dtos/UpdateUserProfileRequestDTO;)Lh/c/b0;", "Lcom/coinbase/wallet/user/dtos/AddAddressesRequestDTO;", "Lcom/coinbase/wallet/user/dtos/AddAddressesResponseDTO;", "addAddresses", "(Lcom/coinbase/wallet/user/dtos/AddAddressesRequestDTO;)Lh/c/b0;", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface UserApiHttp {
    @AuthenticatedRequest
    @retrofit2.z.o("/rpc/v2/addAddress")
    b0<RPCResponse<AddAddressesResponseDTO>> addAddresses(@retrofit2.z.a AddAddressesRequestDTO addAddressesRequestDTO);

    @retrofit2.z.f("rpc/v2/checkUsernameAvailability")
    b0<RPCResponse<CheckUsernameAvailabilityResponseDTO>> checkUsernameAvailability(@t("username") String str);

    @retrofit2.z.f("rpc/v2/getUserProfile")
    @AuthenticatedRequest
    b0<RPCResponse<User>> getUserProfile();

    @AuthenticatedRequest
    @retrofit2.z.o("rpc/v2/updateUserProfile")
    b0<RPCResponse<UpdateUserProfileResponseDTO>> updateUserProfile(@retrofit2.z.a UpdateUserProfileRequestDTO updateUserProfileRequestDTO);
}