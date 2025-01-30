package h.a.a.a;

import h.c.d0;
import kotlin.jvm.internal.m;

/* compiled from: SingleEmitterSuccessListener.kt */
/* loaded from: classes2.dex */
public final class c<T> implements com.google.android.gms.tasks.e<T> {
    private final d0<T> a;

    public c(d0<T> emitter) {
        m.h(emitter, "emitter");
        this.a = emitter;
    }

    @Override // com.google.android.gms.tasks.e
    public void onSuccess(T t) {
        if (t == null) {
            this.a.onError(new NullPointerException());
        } else {
            this.a.onSuccess(t);
        }
    }
}