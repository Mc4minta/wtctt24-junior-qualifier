package e.g.a.e.d.h;

import com.google.android.gms.common.api.Status;
import e.g.a.e.f.d;

/* loaded from: classes2.dex */
public class j implements e.g.a.e.f.d {

    /* loaded from: classes2.dex */
    static abstract class a extends e<d.b> {
        protected f s;

        public a(com.google.android.gms.common.api.d dVar) {
            super(dVar);
            this.s = new m(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ com.google.android.gms.common.api.i c(Status status) {
            return new b(status, false);
        }
    }

    /* loaded from: classes2.dex */
    static class b implements d.b {
        private Status a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13159b;

        public b(Status status, boolean z) {
            this.a = status;
            this.f13159b = z;
        }

        @Override // e.g.a.e.f.d.b
        public final boolean S0() {
            Status status = this.a;
            if (status == null || !status.l1()) {
                return false;
            }
            return this.f13159b;
        }

        @Override // com.google.android.gms.common.api.i
        public final Status getStatus() {
            return this.a;
        }
    }

    @Override // e.g.a.e.f.d
    public com.google.android.gms.common.api.e<d.b> a(com.google.android.gms.common.api.d dVar) {
        return dVar.a(new l(this, dVar));
    }

    @Override // e.g.a.e.f.d
    public com.google.android.gms.common.api.e<d.b> b(com.google.android.gms.common.api.d dVar) {
        return dVar.a(new k(this, dVar));
    }
}