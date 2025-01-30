package com.google.android.gms.common.api;

import com.google.android.gms.common.api.i;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class e<R extends i> {

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Status status);
    }

    public abstract void a(a aVar);

    public abstract R b(long j2, TimeUnit timeUnit);
}