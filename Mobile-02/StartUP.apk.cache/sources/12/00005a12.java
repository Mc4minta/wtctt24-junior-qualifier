package kotlinx.coroutines.internal;

import java.util.Objects;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public final class h {
    private static final Object a = new o("CONDITION_FALSE");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f17496b = new o("LIST_EMPTY");

    public static final Object a() {
        return a;
    }

    public static final i b(Object obj) {
        i iVar;
        m mVar = (m) (!(obj instanceof m) ? null : obj);
        if (mVar == null || (iVar = mVar.a) == null) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            return (i) obj;
        }
        return iVar;
    }
}