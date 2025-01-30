package com.toshi.model.local.dapp;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: DappCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/toshi/model/local/dapp/DappCategory;", "Lcom/toshi/model/local/dapp/DappListItem;", "", "category", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "", "categoryId", "I", "getCategoryId", "()I", "<init>", "(Ljava/lang/String;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class DappCategory extends DappListItem {
    private final String category;
    private final int categoryId;

    public DappCategory(String category, int i2) {
        m.g(category, "category");
        this.category = category;
        this.categoryId = i2;
    }

    public String getCategory() {
        return this.category;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
}