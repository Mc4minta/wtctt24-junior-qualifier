package com.coinbase.wallet.di;

import com.coinbase.wallet.application.repository.NotificationRepository;
import com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface;
import e.j.i.a2;
import e.j.i.u1;
import e.j.i.w1;
import e.j.i.y1;
import kotlin.Metadata;

/* compiled from: RepositoriesModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/di/RepositoriesModule;", "", "Le/j/i/u1;", "bookmarkRepository", "Le/j/i/i2/a;", "providesBookmarkRepository", "(Le/j/i/u1;)Le/j/i/i2/a;", "Le/j/i/w1;", "collectibleTypesRepository", "Le/j/i/i2/b;", "providesCollectibleTypeRepository", "(Le/j/i/w1;)Le/j/i/i2/b;", "Le/j/i/y1;", "erc721Repository", "Le/j/i/i2/c;", "providesErc721Repository", "(Le/j/i/y1;)Le/j/i/i2/c;", "Lcom/coinbase/wallet/application/repository/NotificationRepository;", "notificationRepository", "Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;", "providesNotificationRepository", "(Lcom/coinbase/wallet/application/repository/NotificationRepository;)Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;", "Le/j/i/a2;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "providesMnemonicBackupRepository", "(Le/j/i/a2;)Le/j/i/i2/d;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class RepositoriesModule {
    public abstract e.j.i.i2.a providesBookmarkRepository(u1 u1Var);

    public abstract e.j.i.i2.b providesCollectibleTypeRepository(w1 w1Var);

    public abstract e.j.i.i2.c providesErc721Repository(y1 y1Var);

    public abstract e.j.i.i2.d providesMnemonicBackupRepository(a2 a2Var);

    public abstract NotificationRepositoryInterface providesNotificationRepository(NotificationRepository notificationRepository);
}