package e.j.m.a.t;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TextChangedListener.kt */
/* loaded from: classes2.dex */
public abstract class a implements TextWatcher {
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public abstract void onTextChanged(CharSequence charSequence, int i2, int i3, int i4);
}