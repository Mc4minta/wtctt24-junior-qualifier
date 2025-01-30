package com.coinbase.wallet.features.networking.jwt;

import com.coinbase.ApiConstants;
import kotlin.Metadata;

/* compiled from: AccessTokenProviderInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "", "", ApiConstants.TOKEN, "()Ljava/lang/String;", "refreshToken", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface AccessTokenProviderInterface {
    String refreshToken();

    String token();
}