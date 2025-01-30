package com.coinbase.wallet.application.migrations;

import kotlin.Metadata;
import org.apache.http.cookie.ClientCookie;

/* compiled from: MigrationsDaoInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/application/migrations/MigrationsDaoInterface;", "", "", ClientCookie.VERSION_ATTR, "", "getIsMigrated", "(I)Z", "Lkotlin/x;", "setMigrated", "(I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface MigrationsDaoInterface {
    boolean getIsMigrated(int i2);

    void setMigrated(int i2);
}