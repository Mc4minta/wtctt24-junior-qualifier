package com.coinbase.wallet.wallets.di;

import android.app.Application;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.wallets.di.CryptoComponent;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: CryptoContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/wallets/di/CryptoComponent;", "<anonymous>", "()Lcom/coinbase/wallet/wallets/di/CryptoComponent;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class CryptoContainer$component$2 extends o implements a<CryptoComponent> {
    final /* synthetic */ Application $application;
    final /* synthetic */ Tracing $tracer;
    final /* synthetic */ String $walletApiUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CryptoContainer$component$2(Application application, Tracing tracing, String str) {
        super(0);
        this.$application = application;
        this.$tracer = tracing;
        this.$walletApiUrl = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final CryptoComponent invoke() {
        CryptoComponent.Factory factory = DaggerCryptoComponent.factory();
        Application application = this.$application;
        return factory.create(application, application, this.$tracer, this.$walletApiUrl);
    }
}