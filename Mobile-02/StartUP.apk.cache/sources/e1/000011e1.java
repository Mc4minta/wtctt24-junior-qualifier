package com.coinbase.wallet.application.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import e.j.f.s;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.apache.http.cookie.ClientCookie;

/* compiled from: MigrationsDao.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR%\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/application/migrations/MigrationsDao;", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "", ClientCookie.VERSION_ATTR, "", "getIsMigrated", "(I)Z", "Lkotlin/x;", "setMigrated", "(I)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "prefs$delegate", "Lkotlin/h;", "getPrefs$app_productionRelease", "()Landroid/content/SharedPreferences;", "prefs", "<init>", "(Landroid/content/Context;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MigrationsDao implements MigrationsDaoInterface {
    public static final Companion Companion = new Companion(null);
    public static final String IS_MIGRATED = "is_migrated";
    private final Context context;
    private final h prefs$delegate;

    /* compiled from: MigrationsDao.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/migrations/MigrationsDao$Companion;", "", "", "IS_MIGRATED", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MigrationsDao(Context context) {
        h b2;
        m.g(context, "context");
        this.context = context;
        b2 = k.b(new MigrationsDao$prefs$2(this));
        this.prefs$delegate = b2;
    }

    @Override // com.coinbase.wallet.application.migrations.MigrationsDaoInterface
    public boolean getIsMigrated(int i2) {
        return getPrefs$app_productionRelease().getBoolean(m.o("is_migrated_", Integer.valueOf(i2)), false);
    }

    public final SharedPreferences getPrefs$app_productionRelease() {
        return (SharedPreferences) this.prefs$delegate.getValue();
    }

    @Override // com.coinbase.wallet.application.migrations.MigrationsDaoInterface
    public void setMigrated(int i2) {
        SharedPreferences prefs = getPrefs$app_productionRelease();
        m.f(prefs, "prefs");
        s.a(prefs, m.o("is_migrated_", Integer.valueOf(i2)), true);
    }
}