package com.coinbase.wallet.featureflags.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsUserProperty;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.featureflags.apis.FeatureFlagsApi;
import com.coinbase.wallet.featureflags.extensions.StoreKeys_FeatureFlagsKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import h.c.a0;
import h.c.b0;
import h.c.m0.n;
import h.c.t0.g;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: FeatureFlagsRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R<\u0010\u001c\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005 \u001b*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a0\u001a0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/featureflags/models/FeatureFlag;", "featureFlag", "", "valueSync", "(Lcom/coinbase/wallet/featureflags/models/FeatureFlag;)Z", "requireRefresh", "", "timeout", "Lh/c/b0;", "value", "(Lcom/coinbase/wallet/featureflags/models/FeatureFlag;ZJ)Lh/c/b0;", "getOrFetchValue", "(Lcom/coinbase/wallet/featureflags/models/FeatureFlag;J)Lh/c/b0;", "Lkotlin/x;", "start", "()V", "isForced", "refresh", "(Z)Lh/c/b0;", "Lh/c/a0;", "serialScheduler", "Lh/c/a0;", "Lh/c/v0/c;", "", "kotlin.jvm.PlatformType", "featureFlagsSubject", "Lh/c/v0/c;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/featureflags/apis/FeatureFlagsApi;", "featureFlagsApi", "Lcom/coinbase/wallet/featureflags/apis/FeatureFlagsApi;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/featureflags/apis/FeatureFlagsApi;)V", "featureflags_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FeatureFlagsRepository implements Startable, Refreshable {
    private final FeatureFlagsApi featureFlagsApi;
    private final h.c.v0.c<Map<FeatureFlag, Boolean>> featureFlagsSubject;
    private final a0 serialScheduler;
    private final StoreInterface store;

    public FeatureFlagsRepository(StoreInterface store, FeatureFlagsApi featureFlagsApi) {
        m.g(store, "store");
        m.g(featureFlagsApi, "featureFlagsApi");
        this.store = store;
        this.featureFlagsApi = featureFlagsApi;
        h.c.v0.c<Map<FeatureFlag, Boolean>> d2 = h.c.v0.c.d(1);
        m.f(d2, "createWithSize<Map<FeatureFlag, Boolean>>(1)");
        this.featureFlagsSubject = d2;
        this.serialScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
    }

    public static /* synthetic */ Boolean b(FeatureFlag featureFlag, boolean z, Map map) {
        return m1204value$lambda0(featureFlag, z, map);
    }

    public static /* synthetic */ Boolean c(FeatureFlag featureFlag, boolean z, Map map) {
        return m1201getOrFetchValue$lambda3(featureFlag, z, map);
    }

    public static /* synthetic */ Boolean d(boolean z, Throwable th) {
        return m1202getOrFetchValue$lambda4(z, th);
    }

    public static /* synthetic */ x e(FeatureFlagsRepository featureFlagsRepository, Map map) {
        return m1203refresh$lambda7(featureFlagsRepository, map);
    }

    public static /* synthetic */ Boolean f(boolean z, Throwable th) {
        return m1205value$lambda1(z, th);
    }

    public static /* synthetic */ b0 getOrFetchValue$default(FeatureFlagsRepository featureFlagsRepository, FeatureFlag featureFlag, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 15;
        }
        return featureFlagsRepository.getOrFetchValue(featureFlag, j2);
    }

    /* renamed from: getOrFetchValue$lambda-3 */
    public static final Boolean m1201getOrFetchValue$lambda3(FeatureFlag featureFlag, boolean z, Map it) {
        m.g(featureFlag, "$featureFlag");
        m.g(it, "it");
        Boolean bool = (Boolean) it.get(featureFlag);
        if (bool != null) {
            z = bool.booleanValue();
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: getOrFetchValue$lambda-4 */
    public static final Boolean m1202getOrFetchValue$lambda4(boolean z, Throwable it) {
        m.g(it, "it");
        return Boolean.valueOf(z);
    }

    /* renamed from: refresh$lambda-7 */
    public static final x m1203refresh$lambda7(FeatureFlagsRepository this$0, Map flags) {
        m.g(this$0, "this$0");
        m.g(flags, "flags");
        LinkedHashMap linkedHashMap = new LinkedHashMap(flags.size());
        for (Map.Entry entry : flags.entrySet()) {
            FeatureFlag featureFlag = (FeatureFlag) entry.getKey();
            boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
            this$0.store.set(StoreKeys_FeatureFlagsKt.featureFlag(StoreKeys.INSTANCE, featureFlag), Boolean.valueOf(booleanValue));
            linkedHashMap.put(featureFlag, Boolean.valueOf(booleanValue));
        }
        UserProperties userProperties = UserProperties.INSTANCE;
        Object obj = linkedHashMap.get(FeatureFlag.ONRAMP_USA);
        Boolean bool = Boolean.TRUE;
        AnalyticsUserProperty consumerOnrampEnabled = userProperties.consumerOnrampEnabled(m.c(obj, bool));
        AnalyticsUserProperty consumerEUOnrampEnabled = userProperties.consumerEUOnrampEnabled(m.c(linkedHashMap.get(FeatureFlag.ONRAMP_EU), bool));
        Analytics analytics = Analytics.INSTANCE;
        analytics.setUserProperties(consumerOnrampEnabled);
        analytics.setUserProperties(consumerEUOnrampEnabled);
        this$0.featureFlagsSubject.onNext(linkedHashMap);
        return x.a;
    }

    public static /* synthetic */ b0 value$default(FeatureFlagsRepository featureFlagsRepository, FeatureFlag featureFlag, boolean z, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 15;
        }
        return featureFlagsRepository.value(featureFlag, z, j2);
    }

    /* renamed from: value$lambda-0 */
    public static final Boolean m1204value$lambda0(FeatureFlag featureFlag, boolean z, Map it) {
        m.g(featureFlag, "$featureFlag");
        m.g(it, "it");
        Boolean bool = (Boolean) it.get(featureFlag);
        if (bool != null) {
            z = bool.booleanValue();
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: value$lambda-1 */
    public static final Boolean m1205value$lambda1(boolean z, Throwable it) {
        m.g(it, "it");
        return Boolean.valueOf(z);
    }

    public final b0<Boolean> getOrFetchValue(final FeatureFlag featureFlag, long j2) {
        m.g(featureFlag, "featureFlag");
        Boolean bool = (Boolean) this.store.get(StoreKeys_FeatureFlagsKt.featureFlag(StoreKeys.INSTANCE, featureFlag));
        if (bool == null) {
            b0<Boolean> onErrorReturn = Observable_CoreKt.takeSingle(this.featureFlagsSubject).map(new n() { // from class: com.coinbase.wallet.featureflags.repositories.b
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return FeatureFlagsRepository.c(FeatureFlag.this, r2, (Map) obj);
                }
            }).timeout(j2, TimeUnit.SECONDS).onErrorReturn(new n() { // from class: com.coinbase.wallet.featureflags.repositories.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return FeatureFlagsRepository.d(r1, (Throwable) obj);
                }
            });
            m.f(onErrorReturn, "featureFlagsSubject\n            .takeSingle()\n            .map { it[featureFlag] ?: defaultValue }\n            .timeout(timeout, TimeUnit.SECONDS)\n            .onErrorReturn { defaultValue }");
            return onErrorReturn;
        }
        b0<Boolean> just = b0.just(Boolean.valueOf(bool.booleanValue()));
        m.f(just, "just(it)");
        return just;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public b0<x> refresh(boolean z) {
        b0<x> map = Single_AnalyticsKt.logError$default(this.featureFlagsApi.getFeatureFlags(), "Error getting feature flags", null, 2, null).observeOn(this.serialScheduler).map(new n() { // from class: com.coinbase.wallet.featureflags.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FeatureFlagsRepository.e(FeatureFlagsRepository.this, (Map) obj);
            }
        });
        m.f(map, "featureFlagsApi.getFeatureFlags()\n            .logError(\"Error getting feature flags\")\n            .observeOn(serialScheduler)\n            .map { flags ->\n                val mappedFlags = LinkedHashMap<FeatureFlag, Boolean>(flags.size).apply {\n                    flags.forEach { (flag, enabled) ->\n                        when {\n                            !BuildConfig.DEBUG_TOOLS_ENABLED -> {\n                                store.set(StoreKeys.featureFlag(flag), enabled)\n                                put(flag, enabled)\n                            }\n                            BuildConfig.DEBUG_TOOLS_ENABLED &&\n                                store.get(StoreKeys.isFeatureFlagOverridden(flag)) == null -> {\n                                store.set(StoreKeys.featureFlag(flag), enabled)\n                                put(flag, enabled)\n                            }\n                            else -> {\n                                val existingValue = store.get(StoreKeys.featureFlag(flag)) ?: false\n                                put(flag, existingValue)\n                            }\n                        }\n                    }\n                }\n\n                val onrampEnabled = consumerOnrampEnabled(mappedFlags[FeatureFlag.ONRAMP_USA] == true)\n                val onrampEUEnabled = consumerEUOnrampEnabled(mappedFlags[FeatureFlag.ONRAMP_EU] == true)\n                Analytics.setUserProperties(onrampEnabled)\n                Analytics.setUserProperties(onrampEUEnabled)\n                featureFlagsSubject.onNext(mappedFlags)\n            }");
        return map;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        g.i(refresh(true), null, FeatureFlagsRepository$start$1.INSTANCE, 1, null);
    }

    public final b0<Boolean> value(final FeatureFlag featureFlag, boolean z, long j2) {
        m.g(featureFlag, "featureFlag");
        Boolean bool = (Boolean) this.store.get(StoreKeys_FeatureFlagsKt.featureFlag(StoreKeys.INSTANCE, featureFlag));
        final boolean booleanValue = bool == null ? false : bool.booleanValue();
        if (!z) {
            b0<Boolean> just = b0.just(Boolean.valueOf(booleanValue));
            m.f(just, "just(defaultValue)");
            return just;
        }
        b0<Boolean> onErrorReturn = Observable_CoreKt.takeSingle(this.featureFlagsSubject).map(new n() { // from class: com.coinbase.wallet.featureflags.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FeatureFlagsRepository.b(FeatureFlag.this, booleanValue, (Map) obj);
            }
        }).timeout(j2, TimeUnit.SECONDS).onErrorReturn(new n() { // from class: com.coinbase.wallet.featureflags.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FeatureFlagsRepository.f(booleanValue, (Throwable) obj);
            }
        });
        m.f(onErrorReturn, "featureFlagsSubject\n            .takeSingle()\n            .map { it[featureFlag] ?: defaultValue }\n            .timeout(timeout, TimeUnit.SECONDS)\n            .onErrorReturn { defaultValue }");
        return onErrorReturn;
    }

    public final boolean valueSync(FeatureFlag featureFlag) {
        m.g(featureFlag, "featureFlag");
        Boolean bool = (Boolean) this.store.get(StoreKeys_FeatureFlagsKt.featureFlag(StoreKeys.INSTANCE, featureFlag));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}