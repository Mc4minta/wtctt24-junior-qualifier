package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;

/* compiled from: AppCompatDialogFragment.java */
/* loaded from: classes.dex */
public class i extends androidx.fragment.app.c {
    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new h(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.c
    public void setupDialog(Dialog dialog, int i2) {
        if (dialog instanceof h) {
            h hVar = (h) dialog;
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            hVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i2);
    }
}