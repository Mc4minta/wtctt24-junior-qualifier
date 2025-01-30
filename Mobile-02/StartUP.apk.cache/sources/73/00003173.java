package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.internal.t;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class f {

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    private static final class a<R extends i> extends BasePendingResult<R> {
        private final R q;

        public a(d dVar, R r) {
            super(dVar);
            this.q = r;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R c(Status status) {
            return this.q;
        }
    }

    public static <R extends i> e<R> a(R r, d dVar) {
        t.l(r, "Result must not be null");
        t.b(!r.getStatus().l1(), "Status code must not be SUCCESS");
        a aVar = new a(dVar, r);
        aVar.f(r);
        return aVar;
    }

    public static e<Status> b(Status status, d dVar) {
        t.l(status, "Result must not be null");
        o oVar = new o(dVar);
        oVar.f(status);
        return oVar;
    }
}