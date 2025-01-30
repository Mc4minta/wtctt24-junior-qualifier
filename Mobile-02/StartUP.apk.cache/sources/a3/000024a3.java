package com.coinbase.wallet.libraries.databases.db;

import androidx.room.j;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: RoomDatabaseProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "Landroidx/room/j;", "", "Ljava/lang/Class;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseDaoInterface;", "modelMappings", "()Ljava/util/Map;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class RoomDatabaseProvider extends j {
    public abstract Map<Class<?>, DatabaseDaoInterface<?>> modelMappings();
}