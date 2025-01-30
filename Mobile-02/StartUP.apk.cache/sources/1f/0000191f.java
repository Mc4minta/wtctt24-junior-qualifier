package com.coinbase.wallet.core.models;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Seven.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u0001*\u0006\b\u0005\u0010\u0006 \u0001*\u0006\b\u0006\u0010\u0007 \u00012\u00020\bB?\u0012\u0006\u0010\u0014\u001a\u00028\u0000\u0012\u0006\u0010\u0015\u001a\u00028\u0001\u0012\u0006\u0010\u0016\u001a\u00028\u0002\u0012\u0006\u0010\u0017\u001a\u00028\u0003\u0012\u0006\u0010\u0018\u001a\u00028\u0004\u0012\u0006\u0010\u0019\u001a\u00028\u0005\u0012\u0006\u0010\u001a\u001a\u00028\u0006¢\u0006\u0004\b-\u0010.J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0010\u0010\u0011\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00028\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0080\u0001\u0010\u001b\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u00002\b\b\u0002\u0010\u0014\u001a\u00028\u00002\b\b\u0002\u0010\u0015\u001a\u00028\u00012\b\b\u0002\u0010\u0016\u001a\u00028\u00022\b\b\u0002\u0010\u0017\u001a\u00028\u00032\b\b\u0002\u0010\u0018\u001a\u00028\u00042\b\b\u0002\u0010\u0019\u001a\u00028\u00052\b\b\u0002\u0010\u001a\u001a\u00028\u0006HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0016\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\rR\u0019\u0010\u0017\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b'\u0010\rR\u0019\u0010\u0019\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b(\u0010\rR\u0019\u0010\u0015\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b)\u0010\rR\u0019\u0010\u0018\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b*\u0010\rR\u0019\u0010\u0014\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b+\u0010\rR\u0019\u0010\u001a\u001a\u00028\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b,\u0010\r¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/core/models/Seven;", "A", "B", "C", "D", "E", "F", "G", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", "component7", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/coinbase/wallet/core/models/Seven;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getThird", "getFourth", "getSixth", "getSecond", "getFifth", "getFirst", "getSeventh", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Seven<A, B, C, D, E, F, G> implements Serializable {
    private final E fifth;
    private final A first;
    private final D fourth;
    private final B second;
    private final G seventh;
    private final F sixth;
    private final C third;

    public Seven(A a, B b2, C c2, D d2, E e2, F f2, G g2) {
        this.first = a;
        this.second = b2;
        this.third = c2;
        this.fourth = d2;
        this.fifth = e2;
        this.sixth = f2;
        this.seventh = g2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Seven copy$default(Seven seven, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, int i2, Object obj8) {
        A a = obj;
        if ((i2 & 1) != 0) {
            a = seven.first;
        }
        B b2 = obj2;
        if ((i2 & 2) != 0) {
            b2 = seven.second;
        }
        B b3 = b2;
        C c2 = obj3;
        if ((i2 & 4) != 0) {
            c2 = seven.third;
        }
        C c3 = c2;
        D d2 = obj4;
        if ((i2 & 8) != 0) {
            d2 = seven.fourth;
        }
        D d3 = d2;
        E e2 = obj5;
        if ((i2 & 16) != 0) {
            e2 = seven.fifth;
        }
        E e3 = e2;
        F f2 = obj6;
        if ((i2 & 32) != 0) {
            f2 = seven.sixth;
        }
        F f3 = f2;
        G g2 = obj7;
        if ((i2 & 64) != 0) {
            g2 = seven.seventh;
        }
        return seven.copy(a, b3, c3, d3, e3, f3, g2);
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

    public final G component7() {
        return this.seventh;
    }

    public final Seven<A, B, C, D, E, F, G> copy(A a, B b2, C c2, D d2, E e2, F f2, G g2) {
        return new Seven<>(a, b2, c2, d2, e2, f2, g2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Seven) {
            Seven seven = (Seven) obj;
            return m.c(this.first, seven.first) && m.c(this.second, seven.second) && m.c(this.third, seven.third) && m.c(this.fourth, seven.fourth) && m.c(this.fifth, seven.fifth) && m.c(this.sixth, seven.sixth) && m.c(this.seventh, seven.seventh);
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

    public final G getSeventh() {
        return this.seventh;
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
        int hashCode6 = (hashCode5 + (f2 == null ? 0 : f2.hashCode())) * 31;
        G g2 = this.seventh;
        return hashCode6 + (g2 != null ? g2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ", " + this.sixth + ", " + this.seventh + ')';
    }
}