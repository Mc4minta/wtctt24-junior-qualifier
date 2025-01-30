package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.m;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class k extends androidx.fragment.app.c {
    private Dialog a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f6284b = null;

    public static k d(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        k kVar = new k();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.t.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        kVar.a = dialog2;
        if (onCancelListener != null) {
            kVar.f6284b = onCancelListener;
        }
        return kVar;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f6284b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    @Override // androidx.fragment.app.c
    public void show(m mVar, String str) {
        super.show(mVar, str);
    }
}