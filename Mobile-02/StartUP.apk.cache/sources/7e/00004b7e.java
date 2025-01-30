package h.a.a.a;

import h.c.d0;
import h.c.f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SingleTaskOnSubscribe.kt */
/* loaded from: classes2.dex */
public final class e<Result> extends g<Result, d0<Result>> implements f0<Result> {
    public /* synthetic */ e(com.google.android.gms.tasks.g gVar, f fVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, (i2 & 2) != 0 ? new d() : fVar);
    }

    @Override // h.c.f0
    public /* bridge */ /* synthetic */ void subscribe(d0 d0Var) {
        a(d0Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.google.android.gms.tasks.g<Result> task, f<Result, ? super d0<Result>> factory) {
        super(task, factory);
        m.h(task, "task");
        m.h(factory, "factory");
    }
}