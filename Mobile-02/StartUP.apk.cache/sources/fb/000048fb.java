package e.h.a.d;

import android.widget.CompoundButton;
import h.c.z;

/* compiled from: CompoundButtonCheckedChangeObservable.java */
/* loaded from: classes2.dex */
final class a extends e.h.a.a<Boolean> {
    private final CompoundButton a;

    /* compiled from: CompoundButtonCheckedChangeObservable.java */
    /* renamed from: e.h.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0314a extends h.c.j0.a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final CompoundButton f13470b;

        /* renamed from: c  reason: collision with root package name */
        private final z<? super Boolean> f13471c;

        C0314a(CompoundButton compoundButton, z<? super Boolean> zVar) {
            this.f13470b = compoundButton;
            this.f13471c = zVar;
        }

        @Override // h.c.j0.a
        protected void a() {
            this.f13470b.setOnCheckedChangeListener(null);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (isDisposed()) {
                return;
            }
            this.f13471c.onNext(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    @Override // e.h.a.a
    protected void d(z<? super Boolean> zVar) {
        if (e.h.a.b.a.a(zVar)) {
            C0314a c0314a = new C0314a(this.a, zVar);
            zVar.onSubscribe(c0314a);
            this.a.setOnCheckedChangeListener(c0314a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.a
    /* renamed from: e */
    public Boolean b() {
        return Boolean.valueOf(this.a.isChecked());
    }
}