package e.e.a.b;

import android.content.ComponentName;
import android.content.Context;
import me.leolin.shortcutbadger.ShortcutBadger;

/* compiled from: ApplicationBadgeHelper.java */
/* loaded from: classes2.dex */
public class a {
    public static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    private Boolean f11982b;

    /* renamed from: c  reason: collision with root package name */
    private ComponentName f11983c;

    private a() {
    }

    private void b(Context context, int i2) {
        Boolean bool = this.f11982b;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(ShortcutBadger.applyCount(context, i2));
            this.f11982b = valueOf;
            if (valueOf.booleanValue()) {
                e.f.d.d.a.n("ApplicationBadgeHelper", "First attempt to use automatic badger succeeded; permanently enabling method.");
            } else {
                e.f.d.d.a.n("ApplicationBadgeHelper", "First attempt to use automatic badger failed; permanently disabling method.");
            }
        } else if (bool.booleanValue()) {
            ShortcutBadger.applyCount(context, i2);
        }
    }

    public void a(Context context, int i2) {
        if (this.f11983c == null) {
            this.f11983c = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
        }
        b(context, i2);
    }
}