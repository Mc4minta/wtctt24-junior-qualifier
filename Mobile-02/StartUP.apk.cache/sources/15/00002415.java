package com.coinbase.wallet.lending.di;

import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import kotlin.Metadata;

/* compiled from: LendContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/lending/di/LendContainer;", "", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "()Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/lending/db/LendDatabase;", "lendDatabase", "()Lcom/coinbase/wallet/libraries/databases/db/Database;", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface LendContainer {
    Database<LendDatabase> lendDatabase();

    ILendRepository lendRepository();
}