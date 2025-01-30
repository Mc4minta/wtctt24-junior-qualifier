package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class f implements DialogInterface.OnClickListener {
    public static f a(Activity activity, Intent intent, int i2) {
        return new y(intent, activity, i2);
    }

    public static f b(com.google.android.gms.common.api.internal.i iVar, Intent intent, int i2) {
        return new z(intent, iVar, i2);
    }

    protected abstract void c();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            c();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}