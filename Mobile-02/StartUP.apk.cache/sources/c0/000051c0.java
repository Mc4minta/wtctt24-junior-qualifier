package kotlin.c0.i.a;

import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class j extends i implements kotlin.jvm.internal.i<Object> {

    /* renamed from: b  reason: collision with root package name */
    private final int f17270b;

    public j(int i2, kotlin.c0.d<Object> dVar) {
        super(dVar);
        this.f17270b = i2;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.f17270b;
    }

    @Override // kotlin.c0.i.a.a
    public String toString() {
        if (g() == null) {
            String i2 = e0.i(this);
            m.f(i2, "Reflection.renderLambdaToString(this)");
            return i2;
        }
        return super.toString();
    }
}