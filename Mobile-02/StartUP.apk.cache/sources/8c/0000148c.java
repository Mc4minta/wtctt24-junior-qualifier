package com.coinbase.wallet.commonui.extensions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import c.c.b.c;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: Activity+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u000b\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/app/Activity;", "", "url", "", "flags", "Lkotlin/Function1;", "Lc/c/b/c$a;", "builder", "Landroid/content/ActivityNotFoundException;", "Lkotlin/x;", "onError", "launchCustomTab", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Activity_ApplicationKt {
    public static final void launchCustomTab(Activity activity, String url, Integer num, l<? super c.a, c.a> lVar, l<? super ActivityNotFoundException, x> lVar2) {
        m.g(activity, "<this>");
        m.g(url, "url");
        c.a aVar = new c.a();
        if (lVar != null) {
            lVar.invoke(aVar);
        }
        aVar.f(true);
        c.c.b.c b2 = aVar.b();
        if (num != null) {
            b2.a.setFlags(num.intValue());
        }
        try {
            b2.a(activity, Uri.parse(url));
        } catch (ActivityNotFoundException e2) {
            l.a.a.f(e2, "Exception thrown when trying to launch custom tab.", new Object[0]);
            if (lVar2 == null) {
                return;
            }
            lVar2.invoke(e2);
        }
    }

    public static /* synthetic */ void launchCustomTab$default(Activity activity, String str, Integer num, l lVar, l lVar2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        if ((i2 & 8) != 0) {
            lVar2 = null;
        }
        launchCustomTab(activity, str, num, lVar, lVar2);
    }
}