package e.h.a.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import h.c.z;

/* compiled from: TextViewTextObservable.java */
/* loaded from: classes2.dex */
final class d extends e.h.a.a<CharSequence> {
    private final TextView a;

    /* compiled from: TextViewTextObservable.java */
    /* loaded from: classes2.dex */
    static final class a extends h.c.j0.a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f13472b;

        /* renamed from: c  reason: collision with root package name */
        private final z<? super CharSequence> f13473c;

        a(TextView textView, z<? super CharSequence> zVar) {
            this.f13472b = textView;
            this.f13473c = zVar;
        }

        @Override // h.c.j0.a
        protected void a() {
            this.f13472b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (isDisposed()) {
                return;
            }
            this.f13473c.onNext(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextView textView) {
        this.a = textView;
    }

    @Override // e.h.a.a
    protected void d(z<? super CharSequence> zVar) {
        a aVar = new a(this.a, zVar);
        zVar.onSubscribe(aVar);
        this.a.addTextChangedListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.a
    /* renamed from: e */
    public CharSequence b() {
        return this.a.getText();
    }
}