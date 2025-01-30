package com.coinbase.wallet.core.models;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Six.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u0001*\u0006\b\u0005\u0010\u0006 \u00012\u00020\u0007B7\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0006\u0010\u0013\u001a\u00028\u0001\u0012\u0006\u0010\u0014\u001a\u00028\u0002\u0012\u0006\u0010\u0015\u001a\u00028\u0003\u0012\u0006\u0010\u0016\u001a\u00028\u0004\u0012\u0006\u0010\u0017\u001a\u00028\u0005¢\u0006\u0004\b)\u0010*J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0010\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0011\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJp\u0010\u0018\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0012\u001a\u00028\u00002\b\b\u0002\u0010\u0013\u001a\u00028\u00012\b\b\u0002\u0010\u0014\u001a\u00028\u00022\b\b\u0002\u0010\u0015\u001a\u00028\u00032\b\b\u0002\u0010\u0016\u001a\u00028\u00042\b\b\u0002\u0010\u0017\u001a\u00028\u0005HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0012\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\fR\u0019\u0010\u0016\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b$\u0010\fR\u0019\u0010\u0015\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b%\u0010\fR\u0019\u0010\u0013\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b&\u0010\fR\u0019\u0010\u0014\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b'\u0010\fR\u0019\u0010\u0017\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b(\u0010\f¨\u0006+"}, d2 = {"Lcom/coinbase/wallet/core/models/Six;", "A", "B", "C", "D", "E", "F", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", "first", "second", "third", "fourth", "fifth", "sixth", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/coinbase/wallet/core/models/Six;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getFirst", "getFifth", "getFourth", "getSecond", "getThird", "getSixth", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Six<A, B, C, D, E, F> implements Serializable {
    private final E fifth;
    private final A first;
    private final D fourth;
    private final B second;
    private final F sixth;
    private final C third;

    public Six(A a, B b2, C c2, D d2, E e2, F f2) {
        this.first = a;
        this.second = b2;
        this.third = c2;
        this.fourth = d2;
        this.fifth = e2;
        this.sixth = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Six copy$default(Six six, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i2, Object obj7) {
        A a = obj;
        if ((i2 & 1) != 0) {
            a = six.first;
        }
        B b2 = obj2;
        if ((i2 & 2) != 0) {
            b2 = six.second;
        }
        B b3 = b2;
        C c2 = obj3;
        if ((i2 & 4) != 0) {
            c2 = six.third;
        }
        C c3 = c2;
        D d2 = obj4;
        if ((i2 & 8) != 0) {
            d2 = six.fourth;
        }
        D d3 = d2;
        E e2 = obj5;
        if ((i2 & 16) != 0) {
            e2 = six.fifth;
        }
        E e3 = e2;
        F f2 = obj6;
        if ((i2 & 32) != 0) {
            f2 = six.sixth;
        }
        return six.copy(a, b3, c3, d3, e3, f2);
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

    public final E component5() {
        return this.fifth;
    }

    public final F component6() {
        return this.sixth;
    }

    public final Six<A, B, C, D, E, F> copy(A a, B b2, C c2, D d2, E e2, F f2) {
        return new Six<>(a, b2, c2, d2, e2, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Six) {
            Six six = (Six) obj;
            return m.c(this.first, six.first) && m.c(this.second, six.second) && m.c(this.third, six.third) && m.c(this.fourth, six.fourth) && m.c(this.fifth, six.fifth) && m.c(this.sixth, six.sixth);
        }
        return false;
    }

    public final E getFifth() {
        return this.fifth;
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

    public final F getSixth() {
        return this.sixth;
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
        int hashCode4 = (hashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        E e2 = this.fifth;
        int hashCode5 = (hashCode4 + (e2 == null ? 0 : e2.hashCode())) * 31;
        F f2 = this.sixth;
        return hashCode5 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ", " + this.sixth + ')';
    }
}