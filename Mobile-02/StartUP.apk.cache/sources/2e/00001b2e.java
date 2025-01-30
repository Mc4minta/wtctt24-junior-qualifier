package com.coinbase.wallet.di;

import com.coinbase.wallet.application.migrations.AppVersion210Migration;
import com.coinbase.wallet.application.migrations.AppVersion232Migration;
import com.coinbase.wallet.application.migrations.AppVersion251Migration;
import com.coinbase.wallet.application.migrations.AppVersion304Migration;
import com.coinbase.wallet.application.migrations.Migratable;
import com.coinbase.wallet.application.migrations.MigrationsDao;
import com.coinbase.wallet.application.migrations.MigrationsDaoInterface;
import kotlin.Metadata;

/* compiled from: MigrationsModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/di/MigrationsModule;", "", "Lcom/coinbase/wallet/application/migrations/MigrationsDao;", "migrationsDao", "Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "providesMigrationsDao", "(Lcom/coinbase/wallet/application/migrations/MigrationsDao;)Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "Lcom/coinbase/wallet/application/migrations/AppVersion210Migration;", "migration", "Lcom/coinbase/wallet/application/migrations/Migratable;", "providesApp210Migration", "(Lcom/coinbase/wallet/application/migrations/AppVersion210Migration;)Lcom/coinbase/wallet/application/migrations/Migratable;", "Lcom/coinbase/wallet/application/migrations/AppVersion232Migration;", "providesApp232Migration", "(Lcom/coinbase/wallet/application/migrations/AppVersion232Migration;)Lcom/coinbase/wallet/application/migrations/Migratable;", "Lcom/coinbase/wallet/application/migrations/AppVersion251Migration;", "providesApp251Migration", "(Lcom/coinbase/wallet/application/migrations/AppVersion251Migration;)Lcom/coinbase/wallet/application/migrations/Migratable;", "Lcom/coinbase/wallet/application/migrations/AppVersion304Migration;", "providesApp304Migration", "(Lcom/coinbase/wallet/application/migrations/AppVersion304Migration;)Lcom/coinbase/wallet/application/migrations/Migratable;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class MigrationsModule {
    public abstract Migratable providesApp210Migration(AppVersion210Migration appVersion210Migration);

    public abstract Migratable providesApp232Migration(AppVersion232Migration appVersion232Migration);

    public abstract Migratable providesApp251Migration(AppVersion251Migration appVersion251Migration);

    public abstract Migratable providesApp304Migration(AppVersion304Migration appVersion304Migration);

    public abstract MigrationsDaoInterface providesMigrationsDao(MigrationsDao migrationsDao);
}