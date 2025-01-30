package com.coinbase.wallet.user.apis;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.extensions.Throwable_CommonKt;
import com.coinbase.wallet.common.models.RPCResponse;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.user.dtos.AddAddressesRequestDTO;
import com.coinbase.wallet.user.dtos.AddAddressesResponseDTO;
import com.coinbase.wallet.user.dtos.AddressWithIndexDTO;
import com.coinbase.wallet.user.dtos.CheckUsernameAvailabilityResponseDTO;
import com.coinbase.wallet.user.dtos.UpdateUserProfileRequestDTO;
import com.coinbase.wallet.user.dtos.UpdateUserProfileResponseDTO;
import com.coinbase.wallet.user.models.User;
import h.c.b0;
import h.c.h0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.s;

/* compiled from: UserApi.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/user/apis/UserApi;", "", "", "username", "Lh/c/b0;", "", "checkUsernameAvailability", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/user/models/User;", "getUserProfile", "()Lh/c/b0;", "isPublic", "updateUserProfile", "(Z)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", ApiConstants.ADDRESSES, "addAddresses", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/util/List;)Lh/c/b0;", "Lcom/coinbase/wallet/user/apis/UserApiHttp;", "api", "Lcom/coinbase/wallet/user/apis/UserApiHttp;", "<init>", "(Lcom/coinbase/wallet/user/apis/UserApiHttp;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UserApi {
    private final UserApiHttp api;

    public UserApi(UserApiHttp api) {
        kotlin.jvm.internal.m.g(api, "api");
        this.api = api;
    }

    public static /* synthetic */ Boolean a(CheckUsernameAvailabilityResponseDTO checkUsernameAvailabilityResponseDTO) {
        return m1802checkUsernameAvailability$lambda2(checkUsernameAvailabilityResponseDTO);
    }

    /* renamed from: addAddresses$lambda-10 */
    public static final AddAddressesResponseDTO m1797addAddresses$lambda10(Blockchain blockchain, RPCResponse it) {
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(it, "it");
        AddAddressesResponseDTO addAddressesResponseDTO = (AddAddressesResponseDTO) it.getResult();
        if (addAddressesResponseDTO != null) {
            return addAddressesResponseDTO;
        }
        throw new IllegalStateException(kotlin.jvm.internal.m.o("Unable to add address for ", blockchain));
    }

    /* renamed from: addAddresses$lambda-11 */
    public static final Boolean m1798addAddresses$lambda11(AddAddressesResponseDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getAdded());
    }

    /* renamed from: addAddresses$lambda-9 */
    public static final h0 m1799addAddresses$lambda9(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    public static /* synthetic */ h0 b(Throwable th) {
        return m1799addAddresses$lambda9(th);
    }

    public static /* synthetic */ h0 c(Throwable th) {
        return m1800checkUsernameAvailability$lambda0(th);
    }

    /* renamed from: checkUsernameAvailability$lambda-0 */
    public static final h0 m1800checkUsernameAvailability$lambda0(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: checkUsernameAvailability$lambda-1 */
    public static final CheckUsernameAvailabilityResponseDTO m1801checkUsernameAvailability$lambda1(RPCResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        CheckUsernameAvailabilityResponseDTO checkUsernameAvailabilityResponseDTO = (CheckUsernameAvailabilityResponseDTO) it.getResult();
        if (checkUsernameAvailabilityResponseDTO != null) {
            return checkUsernameAvailabilityResponseDTO;
        }
        throw new IllegalStateException("Unable to check availability");
    }

    /* renamed from: checkUsernameAvailability$lambda-2 */
    public static final Boolean m1802checkUsernameAvailability$lambda2(CheckUsernameAvailabilityResponseDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getAvailable());
    }

    public static /* synthetic */ User d(RPCResponse rPCResponse) {
        return m1804getUserProfile$lambda4(rPCResponse);
    }

    public static /* synthetic */ Boolean e(UpdateUserProfileResponseDTO updateUserProfileResponseDTO) {
        return m1807updateUserProfile$lambda7(updateUserProfileResponseDTO);
    }

    public static /* synthetic */ h0 f(Throwable th) {
        return m1805updateUserProfile$lambda5(th);
    }

    public static /* synthetic */ AddAddressesResponseDTO g(Blockchain blockchain, RPCResponse rPCResponse) {
        return m1797addAddresses$lambda10(blockchain, rPCResponse);
    }

    /* renamed from: getUserProfile$lambda-3 */
    public static final h0 m1803getUserProfile$lambda3(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: getUserProfile$lambda-4 */
    public static final User m1804getUserProfile$lambda4(RPCResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        User user = (User) it.getResult();
        if (user != null) {
            return user;
        }
        throw new IllegalStateException("Unable to fetch user profile");
    }

    public static /* synthetic */ UpdateUserProfileResponseDTO h(boolean z, RPCResponse rPCResponse) {
        return m1806updateUserProfile$lambda6(z, rPCResponse);
    }

    public static /* synthetic */ h0 i(Throwable th) {
        return m1803getUserProfile$lambda3(th);
    }

    public static /* synthetic */ Boolean j(AddAddressesResponseDTO addAddressesResponseDTO) {
        return m1798addAddresses$lambda11(addAddressesResponseDTO);
    }

    public static /* synthetic */ CheckUsernameAvailabilityResponseDTO k(RPCResponse rPCResponse) {
        return m1801checkUsernameAvailability$lambda1(rPCResponse);
    }

    /* renamed from: updateUserProfile$lambda-5 */
    public static final h0 m1805updateUserProfile$lambda5(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        RPCException asRPCException = Throwable_CommonKt.asRPCException(it);
        if (asRPCException != null) {
            it = asRPCException;
        }
        return b0.error(it);
    }

    /* renamed from: updateUserProfile$lambda-6 */
    public static final UpdateUserProfileResponseDTO m1806updateUserProfile$lambda6(boolean z, RPCResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        UpdateUserProfileResponseDTO updateUserProfileResponseDTO = (UpdateUserProfileResponseDTO) it.getResult();
        if (updateUserProfileResponseDTO != null) {
            return updateUserProfileResponseDTO;
        }
        throw new IllegalStateException(kotlin.jvm.internal.m.o("Unable to update user isPublic ", Boolean.valueOf(z)));
    }

    /* renamed from: updateUserProfile$lambda-7 */
    public static final Boolean m1807updateUserProfile$lambda7(UpdateUserProfileResponseDTO it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getUpdated());
    }

    public final b0<Boolean> addAddresses(final Blockchain blockchain, List<WalletAddress> addresses) {
        int r;
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(addresses, "addresses");
        String rawValue = blockchain.getRawValue();
        Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = rawValue.toLowerCase();
        kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        r = s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        for (WalletAddress walletAddress : addresses) {
            arrayList.add(new AddressWithIndexDTO(walletAddress.getAddress(), walletAddress.getIndex()));
        }
        b0<Boolean> map = this.api.addAddresses(new AddAddressesRequestDTO(lowerCase, arrayList)).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.b((Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.g(Blockchain.this, (RPCResponse) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.j((AddAddressesResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "api\n            .addAddresses(addAddressesRequest)\n            .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n            .map { it.result ?: throw IllegalStateException(\"Unable to add address for $blockchain\") }\n            .map { it.added }");
        return map;
    }

    public final b0<Boolean> checkUsernameAvailability(String username) {
        kotlin.jvm.internal.m.g(username, "username");
        b0<Boolean> map = this.api.checkUsernameAvailability(username).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.c((Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.k((RPCResponse) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.a((CheckUsernameAvailabilityResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "api.checkUsernameAvailability(username)\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n        .map { it.result ?: throw IllegalStateException(\"Unable to check availability\") }\n        .map { it.available }");
        return map;
    }

    public final b0<User> getUserProfile() {
        b0 map = this.api.getUserProfile().onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.i((Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.d((RPCResponse) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "api.getUserProfile()\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n        .map { it.result ?: throw IllegalStateException(\"Unable to fetch user profile\") }");
        return map;
    }

    public final b0<Boolean> updateUserProfile(final boolean z) {
        b0<Boolean> map = this.api.updateUserProfile(new UpdateUserProfileRequestDTO(z)).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.f((Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.h(z, (RPCResponse) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.user.apis.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return UserApi.e((UpdateUserProfileResponseDTO) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "api\n        .updateUserProfile(UpdateUserProfileRequestDTO(isPublic))\n        .onErrorResumeNext { Single.error(it.asRPCException() ?: it) }\n        .map { it.result ?: throw IllegalStateException(\"Unable to update user isPublic $isPublic\") }\n        .map { it.updated }");
        return map;
    }
}