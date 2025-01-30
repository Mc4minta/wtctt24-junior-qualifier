package com.coinbase.wallet.lending.db;

import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.u;

/* compiled from: LendDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/lending/db/LendDatabase;", "Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "", "Ljava/lang/Class;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseDaoInterface;", "modelMappings", "()Ljava/util/Map;", "Lcom/coinbase/wallet/lending/db/LendTokenRoomDAO;", "getLendTokenRoomDao", "()Lcom/coinbase/wallet/lending/db/LendTokenRoomDAO;", "lendTokenRoomDao", "<init>", "()V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class LendDatabase extends RoomDatabaseProvider {
    public abstract LendTokenRoomDAO getLendTokenRoomDao();

    @Override // com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider
    public Map<Class<?>, DatabaseDaoInterface<?>> modelMappings() {
        Map<Class<?>, DatabaseDaoInterface<?>> e2;
        e2 = l0.e(u.a(LendToken.class, getLendTokenRoomDao()));
        return e2;
    }
}