package androidx.room;

import h.c.b0;
import h.c.d0;
import h.c.f0;
import java.util.concurrent.Callable;

/* compiled from: RxRoom.java */
/* loaded from: classes.dex */
public class n {
    public static final Object a = new Object();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RxRoom.java */
    /* loaded from: classes.dex */
    static class a<T> implements f0<T> {
        final /* synthetic */ Callable a;

        a(Callable callable) {
            this.a = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.f0
        public void subscribe(d0<T> d0Var) throws Exception {
            try {
                d0Var.onSuccess(this.a.call());
            } catch (EmptyResultSetException e2) {
                d0Var.a(e2);
            }
        }
    }

    public static <T> b0<T> a(Callable<T> callable) {
        return b0.create(new a(callable));
    }
}