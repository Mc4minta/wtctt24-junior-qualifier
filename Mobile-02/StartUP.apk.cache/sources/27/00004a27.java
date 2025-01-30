package e.j.l;

import android.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BuglifeWrapper.kt */
/* loaded from: classes2.dex */
public final class f {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static volatile AtomicBoolean f13703b = new AtomicBoolean(false);

    /* compiled from: BuglifeWrapper.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Application application) {
            m.g(application, "application");
        }

        public final void b(String userIdentifier) {
            m.g(userIdentifier, "userIdentifier");
        }
    }
}