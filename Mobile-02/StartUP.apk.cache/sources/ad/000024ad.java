package com.coinbase.wallet.libraries.databases.interfaces;

import c.r.a.e;
import java.util.List;
import kotlin.Metadata;

/* compiled from: DatabaseDaoInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseDaoInterface;", "T", "", "", "model", "Lkotlin/x;", "add", "(Ljava/util/List;)V", "addOrUpdate", "update", "Lc/r/a/e;", "query", "fetch", "(Lc/r/a/e;)Ljava/util/List;", "delete", "(Ljava/lang/Object;)V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface DatabaseDaoInterface<T> {
    void add(List<? extends T> list);

    void addOrUpdate(List<? extends T> list);

    void delete(T t);

    List<T> fetch(e eVar);

    void update(List<? extends T> list);
}