package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes3.dex */
public abstract class o<R> implements i<R>, Serializable {
    private final int arity;

    public o(int i2) {
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String j2 = e0.j(this);
        m.f(j2, "Reflection.renderLambdaToString(this)");
        return j2;
    }
}