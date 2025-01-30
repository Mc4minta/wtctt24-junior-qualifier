package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class LifecycleCallback {
    protected final i a;

    /* JADX INFO: Access modifiers changed from: protected */
    public LifecycleCallback(i iVar) {
        this.a = iVar;
    }

    public static i c(Activity activity) {
        return d(new h(activity));
    }

    protected static i d(h hVar) {
        if (hVar.c()) {
            return b1.e(hVar.b());
        }
        if (hVar.d()) {
            return y0.e(hVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static i getChimeraLifecycleFragmentImpl(h hVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        return this.a.c();
    }

    public void e(int i2, int i3, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}