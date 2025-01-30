package com.coinbase.wallet.di;

import android.app.Application;
import android.content.pm.PackageManager;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.utilities.Locales;
import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.performance.Tracer;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.s;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AppModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/di/AppModule;", "", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AppModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: AppModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/di/AppModule$Companion;", "", "Lh/c/s;", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "providesConnectivitySubject", "()Lh/c/s;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "providesActiveCurrencyObservable", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;)Lh/c/s;", "currencyRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/commonui/utilities/AmountPickerFormatter;", "providesAmountPickerFormatter", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)Lcom/coinbase/wallet/commonui/utilities/AmountPickerFormatter;", "Ljava/util/Calendar;", "providesCalendarFunction", "()Ljava/util/Calendar;", "Ljava/text/SimpleDateFormat;", "providesRfc3399SimpleDateFormat", "()Ljava/text/SimpleDateFormat;", "Landroid/app/Application;", "app", "Lio/branch/referral/b;", "providesBranchClient", "(Landroid/app/Application;)Lio/branch/referral/b;", "Lcom/coinbase/wallet/application/BaseApplication;", "Landroid/content/pm/PackageManager;", "providesPackageManager", "(Lcom/coinbase/wallet/application/BaseApplication;)Landroid/content/pm/PackageManager;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "providesTraceLogger", "()Lcom/coinbase/wallet/core/interfaces/Tracing;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final s<FiatCurrency> providesActiveCurrencyObservable(IFiatCurrencyRepository fiatCurrencyRepository) {
            m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
            return fiatCurrencyRepository.getActiveCurrencyObservable();
        }

        @ApplicationScoped
        public final AmountPickerFormatter providesAmountPickerFormatter(IFiatCurrencyRepository currencyRepository, IExchangeRateRepository exchangeRateRepository) {
            m.g(currencyRepository, "currencyRepository");
            m.g(exchangeRateRepository, "exchangeRateRepository");
            return new AmountPickerFormatter(currencyRepository, exchangeRateRepository);
        }

        @ApplicationScoped
        public final io.branch.referral.b providesBranchClient(Application app) {
            m.g(app, "app");
            io.branch.referral.b.R(app);
            io.branch.referral.b V = io.branch.referral.b.V();
            m.f(V, "getInstance()");
            return V;
        }

        @ApplicationScoped
        public final Calendar providesCalendarFunction() {
            Calendar calendar = Calendar.getInstance(Locales.INSTANCE.getCurrent());
            m.f(calendar, "getInstance(Locales.current)");
            return calendar;
        }

        @ApplicationScoped
        public final s<ConnectionStatus> providesConnectivitySubject() {
            s<ConnectionStatus> statusChanges = Internet.INSTANCE.getStatusChanges();
            m.f(statusChanges, "Internet.statusChanges");
            return statusChanges;
        }

        @ApplicationScoped
        public final PackageManager providesPackageManager(BaseApplication app) {
            m.g(app, "app");
            PackageManager packageManager = app.getPackageManager();
            m.f(packageManager, "app.packageManager");
            return packageManager;
        }

        @ApplicationScoped
        public final SimpleDateFormat providesRfc3399SimpleDateFormat() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locales.INSTANCE.getCurrent());
        }

        @ApplicationScoped
        public final Tracing providesTraceLogger() {
            return Tracer.INSTANCE;
        }
    }

    @ApplicationScoped
    public static final s<FiatCurrency> providesActiveCurrencyObservable(IFiatCurrencyRepository iFiatCurrencyRepository) {
        return Companion.providesActiveCurrencyObservable(iFiatCurrencyRepository);
    }

    @ApplicationScoped
    public static final AmountPickerFormatter providesAmountPickerFormatter(IFiatCurrencyRepository iFiatCurrencyRepository, IExchangeRateRepository iExchangeRateRepository) {
        return Companion.providesAmountPickerFormatter(iFiatCurrencyRepository, iExchangeRateRepository);
    }

    @ApplicationScoped
    public static final io.branch.referral.b providesBranchClient(Application application) {
        return Companion.providesBranchClient(application);
    }

    @ApplicationScoped
    public static final Calendar providesCalendarFunction() {
        return Companion.providesCalendarFunction();
    }

    @ApplicationScoped
    public static final s<ConnectionStatus> providesConnectivitySubject() {
        return Companion.providesConnectivitySubject();
    }

    @ApplicationScoped
    public static final PackageManager providesPackageManager(BaseApplication baseApplication) {
        return Companion.providesPackageManager(baseApplication);
    }

    @ApplicationScoped
    public static final SimpleDateFormat providesRfc3399SimpleDateFormat() {
        return Companion.providesRfc3399SimpleDateFormat();
    }

    @ApplicationScoped
    public static final Tracing providesTraceLogger() {
        return Companion.providesTraceLogger();
    }
}