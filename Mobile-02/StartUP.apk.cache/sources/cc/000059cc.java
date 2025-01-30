package kotlinx.coroutines;

import kotlin.c0.f;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends f.b {
    public static final a r = a.a;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* loaded from: classes3.dex */
    public static final class a implements f.c<CoroutineExceptionHandler> {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    void handleException(kotlin.c0.f fVar, Throwable th);
}