package e.j.d;

import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;

/* compiled from: Permit.kt */
/* loaded from: classes2.dex */
public final class d extends c {
    static final /* synthetic */ m<Object>[] a = {e0.h(new x(e0.b(d.class), "pin", "getPin()Ljava/lang/String;"))};

    /* renamed from: b  reason: collision with root package name */
    private final b f13525b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String pin) {
        super(null);
        kotlin.jvm.internal.m.g(pin, "pin");
        this.f13525b = new b(pin);
    }

    public final String a() {
        return (String) this.f13525b.a(this, a[0]);
    }
}