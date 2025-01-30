package com.coinbase.wallet.libraries.databases.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: DatabaseException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "DatabaseDestroyed", "MissingDao", "MultipleRowsFetched", "Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException$MissingDao;", "Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException$DatabaseDestroyed;", "Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException$MultipleRowsFetched;", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class DatabaseException extends Exception {

    /* compiled from: DatabaseException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException$DatabaseDestroyed;", "Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DatabaseDestroyed extends DatabaseException {
        public static final DatabaseDestroyed INSTANCE = new DatabaseDestroyed();

        private DatabaseDestroyed() {
            super("Database was destroyed", null);
        }
    }

    /* compiled from: DatabaseException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException$MissingDao;", "Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException;", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/Class;)V", "database_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MissingDao extends DatabaseException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingDao(Class<?> clazz) {
            super(m.o("Unable to find DAO for ", clazz), null);
            m.g(clazz, "clazz");
        }
    }

    /* compiled from: DatabaseException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException$MultipleRowsFetched;", "Lcom/coinbase/wallet/libraries/databases/exceptions/DatabaseException;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MultipleRowsFetched extends DatabaseException {
        public static final MultipleRowsFetched INSTANCE = new MultipleRowsFetched();

        private MultipleRowsFetched() {
            super("Mutliple rows fetched", null);
        }
    }

    private DatabaseException(String str) {
        super(str);
    }

    public /* synthetic */ DatabaseException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}