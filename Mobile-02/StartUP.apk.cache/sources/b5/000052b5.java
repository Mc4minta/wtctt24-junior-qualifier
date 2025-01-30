package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class p<T> implements Serializable {
    public static final a a = new a(null);

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Serializable {
        public final Throwable a;

        public b(Throwable exception) {
            kotlin.jvm.internal.m.g(exception, "exception");
            this.a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.m.c(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.a + ')';
        }
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }
}