package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class b0 implements Runnable {
    private final /* synthetic */ com.google.android.gms.common.b a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f.b f6073b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(f.b bVar, com.google.android.gms.common.b bVar2) {
        this.f6073b = bVar;
        this.a = bVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        Map map = f.this.m;
        bVar = this.f6073b.f6106b;
        f.a aVar = (f.a) map.get(bVar);
        if (aVar == null) {
            return;
        }
        if (this.a.m1()) {
            f.b.e(this.f6073b, true);
            fVar = this.f6073b.a;
            if (fVar.p()) {
                this.f6073b.g();
                return;
            }
            try {
                fVar2 = this.f6073b.a;
                fVar3 = this.f6073b.a;
                fVar2.b(null, fVar3.a());
                return;
            } catch (SecurityException e2) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                aVar.p(new com.google.android.gms.common.b(10));
                return;
            }
        }
        aVar.p(this.a);
    }
}