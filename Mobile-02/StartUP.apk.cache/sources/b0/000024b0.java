package com.coinbase.wallet.libraries.databases.model;

import kotlin.Metadata;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: DatabaseOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/model/DatabaseOperation;", "", "<init>", "(Ljava/lang/String;I)V", DiskLruCache.READ, "WRITE", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum DatabaseOperation {
    READ,
    WRITE
}