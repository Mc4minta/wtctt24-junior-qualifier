package e.j.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.common.annotations.ApplicationScoped;

/* compiled from: NotificationPrefs.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class j implements k {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f13687b;

    /* compiled from: NotificationPrefs.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<SharedPreferences> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final SharedPreferences invoke() {
            return j.this.a.getSharedPreferences("notifications", 0);
        }
    }

    public j(Context context) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(context, "context");
        this.a = context;
        b2 = kotlin.k.b(new a());
        this.f13687b = b2;
    }

    private final SharedPreferences b() {
        return (SharedPreferences) this.f13687b.getValue();
    }

    public boolean c(String id) {
        kotlin.jvm.internal.m.g(id, "id");
        return b().getBoolean(kotlin.jvm.internal.m.o(id, "_disabled"), false);
    }
}