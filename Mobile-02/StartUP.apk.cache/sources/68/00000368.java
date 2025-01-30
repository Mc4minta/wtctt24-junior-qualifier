package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.Iterator;

/* compiled from: NavDeepLinkBuilder.java */
/* loaded from: classes.dex */
public final class i {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f1894b;

    /* renamed from: c  reason: collision with root package name */
    private l f1895c;

    /* renamed from: d  reason: collision with root package name */
    private int f1896d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f1897e;

    public i(Context context) {
        this.a = context;
        if (context instanceof Activity) {
            this.f1894b = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.f1894b = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.f1894b.addFlags(268468224);
    }

    private void b() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.f1895c);
        k kVar = null;
        while (!arrayDeque.isEmpty() && kVar == null) {
            k kVar2 = (k) arrayDeque.poll();
            if (kVar2.r() == this.f1896d) {
                kVar = kVar2;
            } else if (kVar2 instanceof l) {
                Iterator<k> it = ((l) kVar2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        if (kVar != null) {
            this.f1894b.putExtra("android-support-nav:controller:deepLinkIds", kVar.l());
            return;
        }
        String q = k.q(this.a, this.f1896d);
        throw new IllegalArgumentException("Navigation destination " + q + " cannot be found in the navigation graph " + this.f1895c);
    }

    public androidx.core.app.q a() {
        if (this.f1894b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") == null) {
            if (this.f1895c == null) {
                throw new IllegalStateException("You must call setGraph() before constructing the deep link");
            }
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
        androidx.core.app.q i2 = androidx.core.app.q.m(this.a).i(new Intent(this.f1894b));
        for (int i3 = 0; i3 < i2.p(); i3++) {
            i2.o(i3).putExtra("android-support-nav:controller:deepLinkIntent", this.f1894b);
        }
        return i2;
    }

    public i c(Bundle bundle) {
        this.f1897e = bundle;
        this.f1894b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public i d(int i2) {
        this.f1896d = i2;
        if (this.f1895c != null) {
            b();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NavController navController) {
        this(navController.g());
        this.f1895c = navController.k();
    }
}