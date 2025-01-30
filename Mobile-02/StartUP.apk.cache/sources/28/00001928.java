package com.coinbase.wallet.core.util;

import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.a0.p;

/* compiled from: BoundedSet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/core/util/BoundedSet;", "T", "", "", "count", "()I", "item", "", "has", "(Ljava/lang/Object;)Z", "Lkotlin/x;", "add", "(Ljava/lang/Object;)V", "maxSize", "I", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "set", "Ljava/util/LinkedHashSet;", "<init>", "(I)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BoundedSet<T> {
    private final int maxSize;
    private LinkedHashSet<T> set = new LinkedHashSet<>();

    public BoundedSet(int i2) {
        this.maxSize = i2;
    }

    public final void add(T t) {
        if (has(t)) {
            this.set.remove(t);
        }
        this.set.add(t);
        while (this.set.size() > this.maxSize && (!this.set.isEmpty())) {
            LinkedHashSet<T> linkedHashSet = this.set;
            linkedHashSet.remove(p.S(linkedHashSet, 0));
        }
    }

    public final int count() {
        return this.set.size();
    }

    public final boolean has(T t) {
        return this.set.contains(t);
    }
}