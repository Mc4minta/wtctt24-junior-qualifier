package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import e.f.m.i;

/* compiled from: LogBoxDialog.java */
/* loaded from: classes2.dex */
public class c extends Dialog {
    public c(Activity activity, View view) {
        super(activity, i.a);
        requestWindowFeature(1);
        setContentView(view);
    }
}