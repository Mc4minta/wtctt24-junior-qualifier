package e.c.a.a;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: InstallReferrerClient.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: InstallReferrerClient.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final Context a;

        private b(Context context) {
            this.a = context;
        }

        public a a() {
            Context context = this.a;
            if (context != null) {
                return new e.c.a.a.b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static b d(Context context) {
        return new b(context);
    }

    public abstract void a();

    public abstract d b() throws RemoteException;

    public abstract boolean c();

    public abstract void e(c cVar);
}