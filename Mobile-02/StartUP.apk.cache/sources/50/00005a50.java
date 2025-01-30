package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class x0 {
    private static final kotlinx.coroutines.internal.o a = new kotlinx.coroutines.internal.o("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final kotlinx.coroutines.internal.o f17541b = new kotlinx.coroutines.internal.o("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.o f17542c = new kotlinx.coroutines.internal.o("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.o f17543d = new kotlinx.coroutines.internal.o("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.o f17544e = new kotlinx.coroutines.internal.o("SEALED");

    /* renamed from: f  reason: collision with root package name */
    private static final e0 f17545f = new e0(false);

    /* renamed from: g  reason: collision with root package name */
    private static final e0 f17546g = new e0(true);

    public static final Object f(Object obj) {
        return obj instanceof m0 ? new n0((m0) obj) : obj;
    }
}