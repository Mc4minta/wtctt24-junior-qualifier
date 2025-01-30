package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.ethereum.apis.ERC20ContractAPI;
import f.c.d;
import f.c.h;

/* loaded from: classes2.dex */
public final class APIModule_Erc20ContractAPIFactory implements d<ERC20ContractAPI> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final APIModule_Erc20ContractAPIFactory INSTANCE = new APIModule_Erc20ContractAPIFactory();

        private InstanceHolder() {
        }
    }

    public static APIModule_Erc20ContractAPIFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ERC20ContractAPI erc20ContractAPI() {
        return (ERC20ContractAPI) h.f(APIModule.erc20ContractAPI());
    }

    @Override // javax.inject.Provider
    public ERC20ContractAPI get() {
        return erc20ContractAPI();
    }
}