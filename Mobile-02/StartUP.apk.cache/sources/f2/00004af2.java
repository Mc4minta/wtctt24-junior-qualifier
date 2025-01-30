package e.j.n;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import java.util.List;

/* compiled from: ReceiveCoinPickerViewModel.kt */
/* loaded from: classes2.dex */
public final class m3 implements e.j.m.a.p {
    private final CryptoCurrency a;

    /* renamed from: b  reason: collision with root package name */
    private final List<WalletAddress> f13909b;

    /* renamed from: c  reason: collision with root package name */
    private final Wallet f13910c;

    public m3(CryptoCurrency currency, List<WalletAddress> addresses, Wallet wallet) {
        kotlin.jvm.internal.m.g(currency, "currency");
        kotlin.jvm.internal.m.g(addresses, "addresses");
        this.a = currency;
        this.f13909b = addresses;
        this.f13910c = wallet;
    }

    public final List<WalletAddress> a() {
        return this.f13909b;
    }

    public final CryptoCurrency b() {
        return this.a;
    }

    public final String c() {
        Wallet wallet = this.f13910c;
        String displayName = wallet == null ? null : wallet.getDisplayName();
        return displayName == null ? this.a.getName() : displayName;
    }

    public final Wallet d() {
        return this.f13910c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m3) {
            m3 m3Var = (m3) obj;
            return kotlin.jvm.internal.m.c(this.a, m3Var.a) && kotlin.jvm.internal.m.c(this.f13909b, m3Var.f13909b) && kotlin.jvm.internal.m.c(this.f13910c, m3Var.f13910c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.f13909b.hashCode()) * 31;
        Wallet wallet = this.f13910c;
        return hashCode + (wallet == null ? 0 : wallet.hashCode());
    }

    public String toString() {
        return "WalletCompactCell(currency=" + this.a + ", addresses=" + this.f13909b + ", wallet=" + this.f13910c + ')';
    }
}