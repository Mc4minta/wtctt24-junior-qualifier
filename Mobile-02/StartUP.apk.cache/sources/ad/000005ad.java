package c.h.k;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class t {
    private Object a;

    private t(Object obj) {
        this.a = obj;
    }

    public static t b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new t(PointerIcon.getSystemIcon(context, i2));
        }
        return new t(null);
    }

    public Object a() {
        return this.a;
    }
}