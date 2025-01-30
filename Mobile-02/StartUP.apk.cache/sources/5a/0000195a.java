package com.coinbase.wallet.di;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApiHttp;
import com.coinbase.wallet.features.networking.annotation.WalletService;
import com.coinbase.wallet.features.ofac.apis.OFACApiHttp;
import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApiInterface;
import com.coinbase.wallet.features.send.apis.RecipientAPIHttp;
import com.coinbase.wallet.user.apis.UserApiHttp;
import com.toshi.network.VersioningInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import retrofit2.t;

/* compiled from: ApiModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/di/ApiModule;", "", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ApiModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ApiModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/di/ApiModule$Companion;", "", "Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/user/apis/UserApiHttp;", "userApiInterface", "(Lretrofit2/t;)Lcom/coinbase/wallet/user/apis/UserApiHttp;", "Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApiHttp;", "collectiblesApiHttp", "(Lretrofit2/t;)Lcom/coinbase/wallet/features/ethereum/apis/CollectiblesApiHttp;", "Lcom/coinbase/wallet/features/ofac/apis/OFACApiHttp;", "ofacApiHttp", "(Lretrofit2/t;)Lcom/coinbase/wallet/features/ofac/apis/OFACApiHttp;", "Lcom/toshi/network/VersioningInterface;", "providesVersioningInterface", "(Lretrofit2/t;)Lcom/toshi/network/VersioningInterface;", "Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApiInterface;", "providesPushNotificationApiInterface", "(Lretrofit2/t;)Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApiInterface;", "Lcom/coinbase/wallet/features/send/apis/RecipientAPIHttp;", "recipientApiInterface", "(Lretrofit2/t;)Lcom/coinbase/wallet/features/send/apis/RecipientAPIHttp;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final CollectiblesApiHttp collectiblesApiHttp(@WalletService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(CollectiblesApiHttp.class);
            m.f(c2, "retrofit.create(CollectiblesApiHttp::class.java)");
            return (CollectiblesApiHttp) c2;
        }

        @ApplicationScoped
        public final OFACApiHttp ofacApiHttp(@WalletService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(OFACApiHttp.class);
            m.f(c2, "retrofit.create(OFACApiHttp::class.java)");
            return (OFACApiHttp) c2;
        }

        @ApplicationScoped
        public final PushNotificationApiInterface providesPushNotificationApiInterface(@WalletService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(PushNotificationApiInterface.class);
            m.f(c2, "retrofit.create(PushNotificationApiInterface::class.java)");
            return (PushNotificationApiInterface) c2;
        }

        @ApplicationScoped
        public final VersioningInterface providesVersioningInterface(@WalletService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(VersioningInterface.class);
            m.f(c2, "retrofit.create(VersioningInterface::class.java)");
            return (VersioningInterface) c2;
        }

        @ApplicationScoped
        public final RecipientAPIHttp recipientApiInterface(@WalletService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(RecipientAPIHttp.class);
            m.f(c2, "retrofit.create(RecipientAPIHttp::class.java)");
            return (RecipientAPIHttp) c2;
        }

        @ApplicationScoped
        public final UserApiHttp userApiInterface(@WalletService t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(UserApiHttp.class);
            m.f(c2, "retrofit.create(UserApiHttp::class.java)");
            return (UserApiHttp) c2;
        }
    }

    @ApplicationScoped
    public static final CollectiblesApiHttp collectiblesApiHttp(@WalletService t tVar) {
        return Companion.collectiblesApiHttp(tVar);
    }

    @ApplicationScoped
    public static final OFACApiHttp ofacApiHttp(@WalletService t tVar) {
        return Companion.ofacApiHttp(tVar);
    }

    @ApplicationScoped
    public static final PushNotificationApiInterface providesPushNotificationApiInterface(@WalletService t tVar) {
        return Companion.providesPushNotificationApiInterface(tVar);
    }

    @ApplicationScoped
    public static final VersioningInterface providesVersioningInterface(@WalletService t tVar) {
        return Companion.providesVersioningInterface(tVar);
    }

    @ApplicationScoped
    public static final RecipientAPIHttp recipientApiInterface(@WalletService t tVar) {
        return Companion.recipientApiInterface(tVar);
    }

    @ApplicationScoped
    public static final UserApiHttp userApiInterface(@WalletService t tVar) {
        return Companion.userApiInterface(tVar);
    }
}