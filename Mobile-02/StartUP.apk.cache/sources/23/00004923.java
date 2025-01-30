package e.j.d;

import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;

/* compiled from: Permit.kt */
/* loaded from: classes2.dex */
public final class e extends c {
    static final /* synthetic */ m<Object>[] a = {e0.h(new x(e0.b(e.class), "recoveryPhrase", "getRecoveryPhrase()Ljava/lang/String;"))};

    /* renamed from: b  reason: collision with root package name */
    private final b f13526b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String recoveryPhrase) {
        super(null);
        kotlin.jvm.internal.m.g(recoveryPhrase, "recoveryPhrase");
        this.f13526b = new b(recoveryPhrase);
    }

    public final String a() {
        return (String) this.f13526b.a(this, a[0]);
    }
}