package kotlinx.coroutines;

import java.util.Objects;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class y0 extends kotlinx.coroutines.internal.g implements m0 {
    @Override // kotlinx.coroutines.m0
    public boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.m0
    public y0 b() {
        return this;
    }

    public final String q(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object h2 = h();
        Objects.requireNonNull(h2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        boolean z = true;
        for (kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) h2; !kotlin.jvm.internal.m.c(iVar, this); iVar = iVar.i()) {
            if (iVar instanceof v0) {
                v0 v0Var = (v0) iVar;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(v0Var);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return x.b() ? q("Active") : super.toString();
    }
}