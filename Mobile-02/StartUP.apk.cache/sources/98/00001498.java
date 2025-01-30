package com.coinbase.wallet.commonui.extensions;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.b;
import androidx.navigation.p;
import com.coinbase.wallet.commonui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: NavController+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aG\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\r\"\u0013\u0010\u0011\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0013\u0010\u0013\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavController;", "", "resId", "Landroid/content/res/Resources;", "resources", "Landroid/os/Bundle;", "args", "Landroidx/navigation/p;", "navOptions", "Landroidx/navigation/fragment/b$b;", "navExtras", "Lkotlin/x;", "navigateSafely", "(Landroidx/navigation/NavController;ILandroid/content/res/Resources;Landroid/os/Bundle;Landroidx/navigation/p;Landroidx/navigation/fragment/b$b;)V", "Landroidx/navigation/p$a;", "getDefaultNavOptionsBuilder", "()Landroidx/navigation/p$a;", "defaultNavOptionsBuilder", "getVerticalNavOptionsBuilder", "verticalNavOptionsBuilder", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NavController_CommonKt {
    public static final p.a getDefaultNavOptionsBuilder() {
        p.a f2 = new p.a().b(R.anim.fragment_enter).c(R.anim.fragment_exit).e(R.anim.fragment_pop_enter).f(R.anim.fragment_pop_exit);
        m.f(f2, "Builder()\n            .setEnterAnim(R.anim.fragment_enter)\n            .setExitAnim(R.anim.fragment_exit)\n            .setPopEnterAnim(R.anim.fragment_pop_enter)\n            .setPopExitAnim(R.anim.fragment_pop_exit)");
        return f2;
    }

    public static final p.a getVerticalNavOptionsBuilder() {
        p.a f2 = new p.a().b(R.anim.fragment_enter_vertical).c(R.anim.fragment_exit_vertical).e(R.anim.fragment_pop_enter_vertical).f(R.anim.fragment_pop_exit_vertical);
        m.f(f2, "Builder()\n            .setEnterAnim(R.anim.fragment_enter_vertical)\n            .setExitAnim(R.anim.fragment_exit_vertical)\n            .setPopEnterAnim(R.anim.fragment_pop_enter_vertical)\n            .setPopExitAnim(R.anim.fragment_pop_exit_vertical)");
        return f2;
    }

    public static final void navigateSafely(NavController navController, int i2, Resources resources, Bundle bundle, p pVar, b.C0036b c0036b) {
        m.g(navController, "<this>");
        m.g(resources, "resources");
        if (pVar == null) {
            pVar = getDefaultNavOptionsBuilder().a();
        }
        m.f(pVar, "when (navOptions) {\n        null -> defaultNavOptionsBuilder.build()\n        else -> navOptions\n    }");
        try {
            l.a.a.g(m.o("navigateSafely: resourceName=", resources.getResourceName(i2)), new Object[0]);
            navController.p(i2, bundle, pVar, c0036b);
        } catch (IllegalArgumentException e2) {
            l.a.a.f(e2, "NavController navigation error caught..", new Object[0]);
        }
    }
}