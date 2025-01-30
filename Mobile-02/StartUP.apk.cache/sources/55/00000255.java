package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class o {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1482b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f1483c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1484d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1485e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f1486f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f1487g;

    static RemoteInput a(o oVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(oVar.i()).setLabel(oVar.h()).setChoices(oVar.e()).setAllowFreeFormInput(oVar.c()).addExtras(oVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(oVar.f());
        }
        return addExtras.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(o[] oVarArr) {
        if (oVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[oVarArr.length];
        for (int i2 = 0; i2 < oVarArr.length; i2++) {
            remoteInputArr[i2] = a(oVarArr[i2]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f1484d;
    }

    public Set<String> d() {
        return this.f1487g;
    }

    public CharSequence[] e() {
        return this.f1483c;
    }

    public int f() {
        return this.f1485e;
    }

    public Bundle g() {
        return this.f1486f;
    }

    public CharSequence h() {
        return this.f1482b;
    }

    public String i() {
        return this.a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}