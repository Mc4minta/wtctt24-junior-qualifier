package com.toshi.model.local.dapp;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: DappGoogleSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/toshi/model/local/dapp/DappGoogleSearch;", "Lcom/toshi/model/local/dapp/DappListItem;", "", "searchValue", "Ljava/lang/String;", "getSearchValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DappGoogleSearch extends DappListItem {
    private final String searchValue;

    public DappGoogleSearch(String searchValue) {
        m.g(searchValue, "searchValue");
        this.searchValue = searchValue;
    }

    public final String getSearchValue() {
        return this.searchValue;
    }
}