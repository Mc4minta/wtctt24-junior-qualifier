package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.c;
import com.coinbase.ApiConstants;
import com.facebook.react.modules.dialog.DialogModule;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: AlertFragment.java */
/* loaded from: classes2.dex */
public class a extends c implements DialogInterface.OnClickListener {
    private final DialogModule.b a;

    public a() {
        this.a = null;
    }

    public static Dialog d(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(bundle.getString(MessageBundle.TITLE_ENTRY));
        if (bundle.containsKey("button_positive")) {
            title.setPositiveButton(bundle.getString("button_positive"), onClickListener);
        }
        if (bundle.containsKey("button_negative")) {
            title.setNegativeButton(bundle.getString("button_negative"), onClickListener);
        }
        if (bundle.containsKey("button_neutral")) {
            title.setNeutralButton(bundle.getString("button_neutral"), onClickListener);
        }
        if (bundle.containsKey(ApiConstants.MESSAGE)) {
            title.setMessage(bundle.getString(ApiConstants.MESSAGE));
        }
        if (bundle.containsKey("items")) {
            title.setItems(bundle.getCharSequenceArray("items"), onClickListener);
        }
        return title.create();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        DialogModule.b bVar = this.a;
        if (bVar != null) {
            bVar.onClick(dialogInterface, i2);
        }
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return d(getActivity(), getArguments(), this);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogModule.b bVar = this.a;
        if (bVar != null) {
            bVar.onDismiss(dialogInterface);
        }
    }

    @SuppressLint({"ValidFragment"})
    public a(DialogModule.b bVar, Bundle bundle) {
        this.a = bVar;
        setArguments(bundle);
    }
}