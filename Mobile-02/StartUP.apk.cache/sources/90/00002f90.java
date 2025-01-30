package com.facebook.react.views.checkbox;

import android.content.Context;
import androidx.appcompat.widget.AppCompatCheckBox;

/* compiled from: ReactCheckBox.java */
/* loaded from: classes2.dex */
class a extends AppCompatCheckBox {

    /* renamed from: d  reason: collision with root package name */
    private boolean f5295d;

    public a(Context context) {
        super(context);
        this.f5295d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
        }
        this.f5295d = true;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f5295d) {
            this.f5295d = false;
            super.setChecked(z);
        }
    }
}