package e.j.j;

import android.content.SharedPreferences;
import e.j.f.s;

/* compiled from: PrefsMigration.kt */
/* loaded from: classes2.dex */
public final class p {
    private final SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f13692b;

    public p(SharedPreferences appPrefs, SharedPreferences lockPrefs) {
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(lockPrefs, "lockPrefs");
        this.a = appPrefs;
        this.f13692b = lockPrefs;
    }

    public final void a() {
        if (this.a.contains("authentication_type")) {
            s.e(this.f13692b, "authentication_type", this.a.getInt("authentication_type", 0));
            this.a.edit().remove("authentication_type").apply();
        }
    }
}