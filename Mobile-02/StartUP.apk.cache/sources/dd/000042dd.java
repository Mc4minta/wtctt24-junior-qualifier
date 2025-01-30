package com.toshi.view.fragment.coin;

import com.coinbase.wallet.blockchains.models.Wallet;

/* compiled from: WalletUpdate.kt */
/* loaded from: classes2.dex */
public final class q {
    private final Wallet a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11337b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11338c;

    public q(Wallet wallet, String str, String cryptoBalance) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(cryptoBalance, "cryptoBalance");
        this.a = wallet;
        this.f11337b = str;
        this.f11338c = cryptoBalance;
    }

    public final String a() {
        return this.f11338c;
    }

    public final String b() {
        return this.f11337b;
    }

    public final Wallet c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return kotlin.jvm.internal.m.c(this.a, qVar.a) && kotlin.jvm.internal.m.c(this.f11337b, qVar.f11337b) && kotlin.jvm.internal.m.c(this.f11338c, qVar.f11338c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.f11337b;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f11338c.hashCode();
    }

    public String toString() {
        return "WalletUpdate(wallet=" + this.a + ", fiatBalance=" + ((Object) this.f11337b) + ", cryptoBalance=" + this.f11338c + ')';
    }
}