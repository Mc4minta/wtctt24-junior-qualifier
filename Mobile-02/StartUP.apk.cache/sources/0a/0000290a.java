package com.coinbase.wallet.wallets.di;

import android.app.Application;
import android.content.Context;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.wallets.di.CryptoComponent;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerCryptoComponent implements CryptoComponent {
    private final Application application;
    private Provider<Application> applicationProvider;
    private final Context context;
    private final DaggerCryptoComponent cryptoComponent;
    private Provider<CipherCoreInterface> providesCipherCoreInterfaceProvider;
    private Provider<Tracing> tracerProvider;
    private Provider<String> walletApiUrlProvider;

    /* loaded from: classes2.dex */
    private static final class Factory implements CryptoComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.wallets.di.CryptoComponent.Factory
        public CryptoComponent create(Application application, Context context, Tracing tracing, String str) {
            h.b(application);
            h.b(context);
            h.b(tracing);
            h.b(str);
            return new DaggerCryptoComponent(application, context, tracing, str);
        }
    }

    public static CryptoComponent.Factory factory() {
        return new Factory();
    }

    private void initialize(Application application, Context context, Tracing tracing, String str) {
        this.applicationProvider = e.a(application);
        this.tracerProvider = e.a(tracing);
        d a = e.a(str);
        this.walletApiUrlProvider = a;
        this.providesCipherCoreInterfaceProvider = c.b(CryptoModule_ProvidesCipherCoreInterfaceFactory.create(this.applicationProvider, this.tracerProvider, a));
    }

    @Override // com.coinbase.wallet.wallets.di.CryptoComponent
    public Application application() {
        return this.application;
    }

    @Override // com.coinbase.wallet.wallets.di.CryptoComponent
    public CipherCoreInterface cipherCore() {
        return this.providesCipherCoreInterfaceProvider.get();
    }

    @Override // com.coinbase.wallet.wallets.di.CryptoComponent
    public Context context() {
        return this.context;
    }

    private DaggerCryptoComponent(Application application, Context context, Tracing tracing, String str) {
        this.cryptoComponent = this;
        this.application = application;
        this.context = context;
        initialize(application, context, tracing, str);
    }
}