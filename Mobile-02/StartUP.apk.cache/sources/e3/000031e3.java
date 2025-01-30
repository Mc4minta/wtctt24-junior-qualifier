package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.s;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class e0 implements e.a {
    private final /* synthetic */ com.google.android.gms.common.api.e a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.tasks.h f6226b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ s.a f6227c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ s.b f6228d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(com.google.android.gms.common.api.e eVar, com.google.android.gms.tasks.h hVar, s.a aVar, s.b bVar) {
        this.a = eVar;
        this.f6226b = hVar;
        this.f6227c = aVar;
        this.f6228d = bVar;
    }

    @Override // com.google.android.gms.common.api.e.a
    public final void a(Status status) {
        if (status.l1()) {
            this.f6226b.c(this.f6227c.a(this.a.b(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f6226b.b(this.f6228d.a(status));
    }
}