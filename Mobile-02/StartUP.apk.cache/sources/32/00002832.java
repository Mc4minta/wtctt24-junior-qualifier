package com.coinbase.wallet.user.repositories;

import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.apis.UserApi;
import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserRepository_Factory implements f.c.d<UserRepository> {
    private final Provider<AccessTokenRepository> accessTokenRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<UserApi> userApiProvider;
    private final Provider<UserDaoInterface> userDaoProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public UserRepository_Factory(Provider<UserApi> provider, Provider<UserDaoInterface> provider2, Provider<AccessTokenRepository> provider3, Provider<StoreInterface> provider4, Provider<IWalletRepository> provider5, Provider<Tracing> provider6) {
        this.userApiProvider = provider;
        this.userDaoProvider = provider2;
        this.accessTokenRepositoryProvider = provider3;
        this.storeProvider = provider4;
        this.walletRepositoryProvider = provider5;
        this.tracerProvider = provider6;
    }

    public static UserRepository_Factory create(Provider<UserApi> provider, Provider<UserDaoInterface> provider2, Provider<AccessTokenRepository> provider3, Provider<StoreInterface> provider4, Provider<IWalletRepository> provider5, Provider<Tracing> provider6) {
        return new UserRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static UserRepository newInstance(UserApi userApi, UserDaoInterface userDaoInterface, AccessTokenRepository accessTokenRepository, StoreInterface storeInterface, IWalletRepository iWalletRepository, Tracing tracing) {
        return new UserRepository(userApi, userDaoInterface, accessTokenRepository, storeInterface, iWalletRepository, tracing);
    }

    @Override // javax.inject.Provider
    public UserRepository get() {
        return newInstance(this.userApiProvider.get(), this.userDaoProvider.get(), this.accessTokenRepositoryProvider.get(), this.storeProvider.get(), this.walletRepositoryProvider.get(), this.tracerProvider.get());
    }
}