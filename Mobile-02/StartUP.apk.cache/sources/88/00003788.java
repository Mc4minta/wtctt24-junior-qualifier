package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.i;

/* compiled from: BottomSheetDialogFragment.java */
/* loaded from: classes2.dex */
public class b extends i {
    @Override // androidx.appcompat.app.i, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(getContext(), getTheme());
    }
}