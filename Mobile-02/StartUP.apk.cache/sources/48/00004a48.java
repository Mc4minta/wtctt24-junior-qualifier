package e.j.l.q;

import android.content.Context;
import com.google.android.gms.common.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: GcmUtil.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final C0328a a = new C0328a(null);

    /* compiled from: GcmUtil.kt */
    /* renamed from: e.j.l.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0328a {
        private C0328a() {
        }

        public /* synthetic */ C0328a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context) {
            m.g(context, "context");
            return e.o().g(context) == 0;
        }
    }
}