package e.j.n;

import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;

/* compiled from: NetworkSwitcherViewModel.kt */
/* loaded from: classes2.dex */
public final class q2 implements r2 {
    private final NetworkSetting a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkSettingItem f13959b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13960c;

    public q2(NetworkSetting networkSetting, NetworkSettingItem network, boolean z) {
        kotlin.jvm.internal.m.g(networkSetting, "networkSetting");
        kotlin.jvm.internal.m.g(network, "network");
        this.a = networkSetting;
        this.f13959b = network;
        this.f13960c = z;
    }

    public final NetworkSettingItem a() {
        return this.f13959b;
    }

    public final NetworkSetting b() {
        return this.a;
    }

    public final boolean c() {
        return this.f13960c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q2) {
            q2 q2Var = (q2) obj;
            return kotlin.jvm.internal.m.c(this.a, q2Var.a) && kotlin.jvm.internal.m.c(this.f13959b, q2Var.f13959b) && this.f13960c == q2Var.f13960c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.f13959b.hashCode()) * 31;
        boolean z = this.f13960c;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "NetworkItem(networkSetting=" + this.a + ", network=" + this.f13959b + ", isSelected=" + this.f13960c + ')';
    }
}