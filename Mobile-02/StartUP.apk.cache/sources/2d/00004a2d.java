package e.j.l;

import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: OnSingleClickListener.kt */
/* loaded from: classes2.dex */
public abstract class j implements View.OnClickListener {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static long f13707b;

    /* renamed from: c  reason: collision with root package name */
    private final long f13708c;

    /* compiled from: OnSingleClickListener.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(long j2) {
        this.f13708c = j2;
    }

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        m.g(v, "v");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= f13707b) {
            f13707b = currentTimeMillis + this.f13708c;
            a(v);
        }
    }

    public /* synthetic */ j(long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 500L : j2);
    }
}