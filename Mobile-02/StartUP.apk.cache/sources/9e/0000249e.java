package com.coinbase.wallet.libraries.databases.db;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: Database.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "T", "", "it", "", "<anonymous>", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class Database$buildSQLQuery$newQuery$1$placeholders$1 extends o implements l<Object, CharSequence> {
    public static final Database$buildSQLQuery$newQuery$1$placeholders$1 INSTANCE = new Database$buildSQLQuery$newQuery$1$placeholders$1();

    Database$buildSQLQuery$newQuery$1$placeholders$1() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.l
    public final CharSequence invoke(Object it) {
        m.g(it, "it");
        return "?";
    }
}