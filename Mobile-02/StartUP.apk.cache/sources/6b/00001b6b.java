package com.coinbase.wallet.di;

import android.content.Context;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.store.Store;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StoreModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/di/StoreModule;", "", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class StoreModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: StoreModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/di/StoreModule$Companion;", "", "Landroid/content/Context;", "context", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "providesStore", "(Landroid/content/Context;)Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @AppCoreScoped
        public final StoreInterface providesStore(Context context) {
            m.g(context, "context");
            return new Store(context);
        }
    }

    @AppCoreScoped
    public static final StoreInterface providesStore(Context context) {
        return Companion.providesStore(context);
    }
}