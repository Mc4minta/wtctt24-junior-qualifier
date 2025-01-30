package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class j<E> extends f {
    private final Activity a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1623b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f1624c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1625d;

    /* renamed from: e  reason: collision with root package name */
    final m f1626e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    public View b(int i2) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context e() {
        return this.f1623b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler f() {
        return this.f1624c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment) {
    }

    public abstract E h();

    public LayoutInflater i() {
        return LayoutInflater.from(this.f1623b);
    }

    public void j(Fragment fragment, String[] strArr, int i2) {
    }

    public boolean k(Fragment fragment) {
        return true;
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            this.f1623b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void n(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            androidx.core.app.a.x(this.a, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void o() {
    }

    j(Activity activity, Context context, Handler handler, int i2) {
        this.f1626e = new n();
        this.a = activity;
        this.f1623b = (Context) androidx.core.util.h.c(context, "context == null");
        this.f1624c = (Handler) androidx.core.util.h.c(handler, "handler == null");
        this.f1625d = i2;
    }
}