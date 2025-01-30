package androidx.core.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

/* compiled from: ActivityOptionsCompat.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: ActivityOptionsCompat.java */
    /* loaded from: classes.dex */
    private static class a extends b {
        private final ActivityOptions a;

        a(ActivityOptions activityOptions) {
            this.a = activityOptions;
        }

        @Override // androidx.core.app.b
        public Bundle b() {
            return this.a.toBundle();
        }
    }

    protected b() {
    }

    public static b a(Context context, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new a(ActivityOptions.makeCustomAnimation(context, i2, i3));
        }
        return new b();
    }

    public Bundle b() {
        return null;
    }
}