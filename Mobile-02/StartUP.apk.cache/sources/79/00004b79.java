package h.a.a.a;

import h.c.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RxTasks.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final C0336a a = new C0336a(null);

    /* compiled from: RxTasks.kt */
    /* renamed from: h.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0336a {
        private C0336a() {
        }

        public final <T> b0<T> a(com.google.android.gms.tasks.g<T> task) {
            m.h(task, "task");
            b0<T> create = b0.create(new e(task, null, 2, null));
            m.d(create, "Single.create(SingleTaskOnSubscribe(task))");
            return create;
        }

        public /* synthetic */ C0336a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}