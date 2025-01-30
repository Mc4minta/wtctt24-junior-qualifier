package com.coinbase.wallet.application.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.application.migrations.Migratable;
import com.coinbase.wallet.appreview.extensions.StoreKeys_AppReviewKt;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;
import org.apache.http.HttpStatus;

/* compiled from: AppVersion304Migration.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/application/migrations/AppVersion304Migration;", "Lcom/coinbase/wallet/application/migrations/Migratable;", "Lh/c/c;", "migrate", "()Lh/c/c;", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "legacyStore", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "getLegacyStore", "()Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/h;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs", "", "migrationVersion", "I", "getMigrationVersion", "()I", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Landroid/content/Context;", "context", "<init>", "(Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;Landroid/content/Context;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppVersion304Migration implements Migratable {
    private final MigrationsDaoInterface legacyStore;
    private final int migrationVersion;
    private final h prefs$delegate;
    private final StoreInterface store;

    public AppVersion304Migration(MigrationsDaoInterface legacyStore, Context context, StoreInterface store) {
        h b2;
        m.g(legacyStore, "legacyStore");
        m.g(context, "context");
        m.g(store, "store");
        this.legacyStore = legacyStore;
        this.store = store;
        b2 = k.b(new AppVersion304Migration$prefs$2(context));
        this.prefs$delegate = b2;
        this.migrationVersion = HttpStatus.SC_NOT_MODIFIED;
    }

    public static /* synthetic */ x a(AppVersion304Migration appVersion304Migration) {
        return m650migrate$lambda0(appVersion304Migration);
    }

    private final SharedPreferences getPrefs() {
        Object value = this.prefs$delegate.getValue();
        m.f(value, "<get-prefs>(...)");
        return (SharedPreferences) value;
    }

    /* renamed from: migrate$lambda-0 */
    public static final x m650migrate$lambda0(AppVersion304Migration this$0) {
        m.g(this$0, "this$0");
        int i2 = this$0.getPrefs().getInt("appReviewSuccessActionCount", -1);
        if (i2 >= 0) {
            this$0.store.set(StoreKeys_AppReviewKt.getAppReviewSuccessActionCount(StoreKeys.INSTANCE), Integer.valueOf(i2));
            this$0.getPrefs().edit().remove("appReviewSuccessActionCount").apply();
        }
        return x.a;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public MigrationsDaoInterface getLegacyStore() {
        return this.legacyStore;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public int getMigrationVersion() {
        return this.migrationVersion;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public boolean isMigrated() {
        return Migratable.DefaultImpls.isMigrated(this);
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public h.c.c migrate() {
        if (isMigrated()) {
            h.c.c g2 = h.c.c.g();
            m.f(g2, "complete()");
            return g2;
        }
        h.c.c r = h.c.c.r(new Callable() { // from class: com.coinbase.wallet.application.migrations.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AppVersion304Migration.a(AppVersion304Migration.this);
            }
        });
        m.f(r, "fromCallable {\n            val count = prefs.getInt(APP_REVIEW_SUCCESS_ACTION_COUNT, -1)\n            if (count >= 0) {\n                store.set(StoreKeys.appReviewSuccessActionCount, count)\n                prefs.edit().remove(APP_REVIEW_SUCCESS_ACTION_COUNT).apply()\n            }\n        }");
        return r;
    }

    @Override // com.coinbase.wallet.application.migrations.Migratable
    public void migrationComplete() {
        Migratable.DefaultImpls.migrationComplete(this);
    }
}