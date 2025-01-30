package com.coinbase.wallet.core.models;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Four.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u00012\u00020\u0005B'\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00028\u0002\u0012\u0006\u0010\u0011\u001a\u00028\u0003¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\nJP\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u000e\u001a\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00028\u00012\b\b\u0002\u0010\u0010\u001a\u00028\u00022\b\b\u0002\u0010\u0011\u001a\u00028\u0003HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000e\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u0011\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\u0010\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/core/models/Four;", "A", "B", "C", "D", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "first", "second", "third", "fourth", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/coinbase/wallet/core/models/Four;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getSecond", "getFirst", "getFourth", "getThird", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Four<A, B, C, D> implements Serializable {
    private final A first;
    private final D fourth;
    private final B second;
    private final C third;

    public Four(A a, B b2, C c2, D d2) {
        this.first = a;
        this.second = b2;
        this.third = c2;
        this.fourth = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Four copy$default(Four four, Object obj, Object obj2, Object obj3, Object obj4, int i2, Object obj5) {
        if ((i2 & 1) != 0) {
            obj = four.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = four.second;
        }
        if ((i2 & 4) != 0) {
            obj3 = four.third;
        }
        if ((i2 & 8) != 0) {
            obj4 = four.fourth;
        }
        return four.copy(obj, obj2, obj3, obj4);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final D component4() {
        return this.fourth;
    }

    public final Four<A, B, C, D> copy(A a, B b2, C c2, D d2) {
        return new Four<>(a, b2, c2, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Four) {
            Four four = (Four) obj;
            return m.c(this.first, four.first) && m.c(this.second, four.second) && m.c(this.third, four.third) && m.c(this.fourth, four.fourth);
        }
        return false;
    }

    public final A getFirst() {
        return this.first;
    }

    public final D getFourth() {
        return this.fourth;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int hashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b2 = this.second;
        int hashCode2 = (hashCode + (b2 == null ? 0 : b2.hashCode())) * 31;
        C c2 = this.third;
        int hashCode3 = (hashCode2 + (c2 == null ? 0 : c2.hashCode())) * 31;
        D d2 = this.fourth;
        return hashCode3 + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ')';
    }
}