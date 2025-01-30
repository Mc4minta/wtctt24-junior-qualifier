package c.s;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class y0 implements a1 {
    private final IBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof y0) && ((y0) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}