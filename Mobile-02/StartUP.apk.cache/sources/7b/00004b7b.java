package h.a.a.a;

import h.c.d0;
import kotlin.jvm.internal.m;

/* compiled from: SingleEmitterFailureListener.kt */
/* loaded from: classes2.dex */
public final class b<T> implements com.google.android.gms.tasks.d {
    private final d0<T> a;

    public b(d0<T> emitter) {
        m.h(emitter, "emitter");
        this.a = emitter;
    }

    @Override // com.google.android.gms.tasks.d
    public void c(Exception exception) {
        m.h(exception, "exception");
        this.a.onError(exception);
    }
}