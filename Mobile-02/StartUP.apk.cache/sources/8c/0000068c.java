package c.s;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class z0 implements a1 {
    private final WindowId a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof z0) && ((z0) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}