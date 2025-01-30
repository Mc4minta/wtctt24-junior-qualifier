package e.h.a.c;

import android.view.View;
import h.c.z;

/* compiled from: ViewFocusChangeObservable.java */
/* loaded from: classes2.dex */
final class b extends e.h.a.a<Boolean> {
    private final View a;

    /* compiled from: ViewFocusChangeObservable.java */
    /* loaded from: classes2.dex */
    static final class a extends h.c.j0.a implements View.OnFocusChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f13468b;

        /* renamed from: c  reason: collision with root package name */
        private final z<? super Boolean> f13469c;

        a(View view, z<? super Boolean> zVar) {
            this.f13468b = view;
            this.f13469c = zVar;
        }

        @Override // h.c.j0.a
        protected void a() {
            this.f13468b.setOnFocusChangeListener(null);
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (isDisposed()) {
                return;
            }
            this.f13469c.onNext(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(View view) {
        this.a = view;
    }

    @Override // e.h.a.a
    protected void d(z<? super Boolean> zVar) {
        a aVar = new a(this.a, zVar);
        zVar.onSubscribe(aVar);
        this.a.setOnFocusChangeListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.a
    /* renamed from: e */
    public Boolean b() {
        return Boolean.valueOf(this.a.hasFocus());
    }
}