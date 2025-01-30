package com.coinbase.wallet.commonui.models;

import android.os.Bundle;
import androidx.navigation.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ViewModelNavRoute.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "", "", "component1", "()I", "Landroid/os/Bundle;", "component2", "()Landroid/os/Bundle;", "Landroidx/navigation/p;", "component3", "()Landroidx/navigation/p;", "resourceId", "args", "navOptions", "copy", "(ILandroid/os/Bundle;Landroidx/navigation/p;)Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Bundle;", "getArgs", "I", "getResourceId", "Landroidx/navigation/p;", "getNavOptions", "<init>", "(ILandroid/os/Bundle;Landroidx/navigation/p;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ViewModelNavRoute {
    private final Bundle args;
    private final p navOptions;
    private final int resourceId;

    public ViewModelNavRoute(int i2, Bundle bundle, p pVar) {
        this.resourceId = i2;
        this.args = bundle;
        this.navOptions = pVar;
    }

    public static /* synthetic */ ViewModelNavRoute copy$default(ViewModelNavRoute viewModelNavRoute, int i2, Bundle bundle, p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = viewModelNavRoute.resourceId;
        }
        if ((i3 & 2) != 0) {
            bundle = viewModelNavRoute.args;
        }
        if ((i3 & 4) != 0) {
            pVar = viewModelNavRoute.navOptions;
        }
        return viewModelNavRoute.copy(i2, bundle, pVar);
    }

    public final int component1() {
        return this.resourceId;
    }

    public final Bundle component2() {
        return this.args;
    }

    public final p component3() {
        return this.navOptions;
    }

    public final ViewModelNavRoute copy(int i2, Bundle bundle, p pVar) {
        return new ViewModelNavRoute(i2, bundle, pVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ViewModelNavRoute) {
            ViewModelNavRoute viewModelNavRoute = (ViewModelNavRoute) obj;
            return this.resourceId == viewModelNavRoute.resourceId && m.c(this.args, viewModelNavRoute.args) && m.c(this.navOptions, viewModelNavRoute.navOptions);
        }
        return false;
    }

    public final Bundle getArgs() {
        return this.args;
    }

    public final p getNavOptions() {
        return this.navOptions;
    }

    public final int getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        int i2 = this.resourceId * 31;
        Bundle bundle = this.args;
        int hashCode = (i2 + (bundle == null ? 0 : bundle.hashCode())) * 31;
        p pVar = this.navOptions;
        return hashCode + (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "ViewModelNavRoute(resourceId=" + this.resourceId + ", args=" + this.args + ", navOptions=" + this.navOptions + ')';
    }

    public /* synthetic */ ViewModelNavRoute(int i2, Bundle bundle, p pVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : bundle, (i3 & 4) != 0 ? null : pVar);
    }
}