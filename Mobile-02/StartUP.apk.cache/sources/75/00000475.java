package b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: ICustomTabsCallback.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: ICustomTabsCallback.java */
    /* renamed from: b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0046a extends Binder implements a {

        /* compiled from: ICustomTabsCallback.java */
        /* renamed from: b.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0047a implements a {
            private IBinder a;

            C0047a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0047a(iBinder);
        }
    }
}