package com.coinbase.wallet.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Optional.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "", "T", "toNullable", "()Ljava/lang/Object;", "component1", "value", "copy", "(Ljava/lang/Object;)Lcom/coinbase/wallet/core/util/Optional;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Optional<T> {
    private final T value;

    public Optional(T t) {
        this.value = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Optional copy$default(Optional optional, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = optional.value;
        }
        return optional.copy(obj);
    }

    public final T component1() {
        return this.value;
    }

    public final Optional<T> copy(T t) {
        return new Optional<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Optional) && m.c(this.value, ((Optional) obj).value);
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public final T toNullable() {
        return this.value;
    }

    public String toString() {
        return "Optional(value=" + this.value + ')';
    }
}