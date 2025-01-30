package com.facebook.react.views.switchview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.SwitchCompat;

/* compiled from: ReactSwitch.java */
/* loaded from: classes2.dex */
class a extends SwitchCompat {
    private boolean T;
    private Integer U;
    private Integer V;

    public a(Context context) {
        super(context);
        this.T = true;
        this.U = null;
        this.V = null;
    }

    private void q(boolean z) {
        Integer num = this.V;
        if (num == null && this.U == null) {
            return;
        }
        if (!z) {
            num = this.U;
        }
        p(num);
    }

    void m(Drawable drawable, Integer num) {
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
            q(z);
        }
        this.T = true;
    }

    public void o(Integer num) {
        m(super.getThumbDrawable(), num);
    }

    public void p(Integer num) {
        m(super.getTrackDrawable(), num);
    }

    public void r(Integer num) {
        if (num == this.U) {
            return;
        }
        this.U = num;
        if (isChecked()) {
            return;
        }
        p(this.U);
    }

    public void s(Integer num) {
        if (num == this.V) {
            return;
        }
        this.V = num;
        if (isChecked()) {
            p(this.V);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.T && isChecked() != z) {
            this.T = false;
            super.setChecked(z);
            q(z);
            return;
        }
        super.setChecked(isChecked());
    }
}