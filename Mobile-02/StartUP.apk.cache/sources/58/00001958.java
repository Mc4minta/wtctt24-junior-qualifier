package com.coinbase.wallet.di;

import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.user.apis.AccessTokenApiInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import retrofit2.t;

/* compiled from: ApiCoreModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/di/ApiCoreModule;", "", "Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "accessTokenApiInterface", "(Lretrofit2/t;)Lcom/coinbase/wallet/user/apis/AccessTokenApiInterface;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ApiCoreModule {
    @AppCoreScoped
    public final AccessTokenApiInterface accessTokenApiInterface(t retrofit) {
        m.g(retrofit, "retrofit");
        Object c2 = retrofit.c(AccessTokenApiInterface.class);
        m.f(c2, "retrofit.create(AccessTokenApiInterface::class.java)");
        return (AccessTokenApiInterface) c2;
    }
}