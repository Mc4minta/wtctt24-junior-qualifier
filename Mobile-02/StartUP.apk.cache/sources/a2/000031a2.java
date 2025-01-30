package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class q implements e.a {
    private final /* synthetic */ BasePendingResult a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ x0 f6129b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(x0 x0Var, BasePendingResult basePendingResult) {
        this.f6129b = x0Var;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.e.a
    public final void a(Status status) {
        Map map;
        map = this.f6129b.a;
        map.remove(this.a);
    }
}