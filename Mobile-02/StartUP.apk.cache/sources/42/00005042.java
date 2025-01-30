package h.c.n0.j;

import h.c.z;
import java.io.Serializable;

/* compiled from: NotificationLite.java */
/* loaded from: classes3.dex */
public enum m {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* loaded from: classes3.dex */
    static final class a implements Serializable {
        final h.c.k0.b a;

        a(h.c.k0.b bVar) {
            this.a = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.a + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NotificationLite.java */
    /* loaded from: classes3.dex */
    public static final class b implements Serializable {
        final Throwable a;

        b(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return h.c.n0.b.b.c(this.a, ((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes3.dex */
    static final class c implements Serializable {
        final k.a.d a;

        c(k.a.d dVar) {
            this.a = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.a + "]";
        }
    }

    public static Object A(Throwable th) {
        return new b(th);
    }

    public static Throwable B(Object obj) {
        return ((b) obj).a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T C(Object obj) {
        return obj;
    }

    public static boolean D(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean E(Object obj) {
        return obj instanceof b;
    }

    public static <T> Object F(T t) {
        return t;
    }

    public static Object G(k.a.d dVar) {
        return new c(dVar);
    }

    public static <T> boolean h(Object obj, z<? super T> zVar) {
        if (obj == COMPLETE) {
            zVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            zVar.onError(((b) obj).a);
            return true;
        } else {
            zVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean n(Object obj, k.a.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            cVar.onError(((b) obj).a);
            return true;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean q(Object obj, z<? super T> zVar) {
        if (obj == COMPLETE) {
            zVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            zVar.onError(((b) obj).a);
            return true;
        } else if (obj instanceof a) {
            zVar.onSubscribe(((a) obj).a);
            return false;
        } else {
            zVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean s(Object obj, k.a.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            cVar.onError(((b) obj).a);
            return true;
        } else if (obj instanceof c) {
            cVar.onSubscribe(((c) obj).a);
            return false;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static Object y() {
        return COMPLETE;
    }

    public static Object z(h.c.k0.b bVar) {
        return new a(bVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}