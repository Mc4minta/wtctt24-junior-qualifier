package com.coinbase.wallet.commonui.utilities.navigator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.u;
import androidx.navigation.fragment.b;
import androidx.navigation.k;
import androidx.navigation.p;
import androidx.navigation.s;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: CustomNavigator.kt */
@s.b("persistedFragment")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/navigator/CustomNavigator;", "Landroidx/navigation/fragment/b;", "", "popBackStack", "()Z", "Landroidx/navigation/fragment/b$a;", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/p;", "navOptions", "Landroidx/navigation/s$a;", "navigatorExtras", "Landroidx/navigation/k;", "navigate", "(Landroidx/navigation/fragment/b$a;Landroid/os/Bundle;Landroidx/navigation/p;Landroidx/navigation/s$a;)Landroidx/navigation/k;", "Landroidx/fragment/app/m;", "manager", "Landroidx/fragment/app/m;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "", "containerId", "I", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/m;I)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CustomNavigator extends b {
    private final int containerId;
    private final Context context;
    private final m manager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomNavigator(Context context, m manager, int i2) {
        super(context, manager, i2);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(manager, "manager");
        this.context = context;
        this.manager = manager;
        this.containerId = i2;
    }

    @Override // androidx.navigation.fragment.b, androidx.navigation.s
    public boolean popBackStack() {
        if (!this.manager.v0() && this.manager.d0() > 0) {
            return this.manager.I0();
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.fragment.b, androidx.navigation.s
    public k navigate(b.a destination, Bundle bundle, p pVar, s.a aVar) {
        kotlin.jvm.internal.m.g(destination, "destination");
        String valueOf = String.valueOf(destination.r());
        u j2 = this.manager.j();
        kotlin.jvm.internal.m.f(j2, "manager.beginTransaction()");
        j2.v(pVar == null ? 0 : pVar.a(), pVar == null ? 0 : pVar.b(), pVar == null ? 0 : pVar.c(), pVar != null ? pVar.d() : 0);
        if (aVar instanceof b.C0036b) {
            Map<View, String> a = ((b.C0036b) aVar).a();
            kotlin.jvm.internal.m.f(a, "navigatorExtras.sharedElements");
            for (Map.Entry<View, String> entry : a.entrySet()) {
                j2.g(entry.getKey(), entry.getValue());
            }
        }
        Fragment l0 = this.manager.l0();
        if (l0 != null) {
            j2.q(l0);
        }
        Fragment Z = this.manager.Z(valueOf);
        if (Z == null) {
            Z = instantiateFragment(this.context, this.manager, destination.E(), bundle);
            Z.setArguments(bundle);
            j2.c(this.containerId, Z, valueOf);
            j2.h(null);
        } else {
            Z.setArguments(bundle);
            j2.i(Z);
        }
        j2.x(Z);
        j2.y(true);
        j2.j();
        return destination;
    }
}