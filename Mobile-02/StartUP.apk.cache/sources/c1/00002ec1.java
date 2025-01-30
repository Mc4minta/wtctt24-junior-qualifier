package com.facebook.react.modules.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: TimePickerDialogFragment.java */
/* loaded from: classes2.dex */
public class b extends androidx.fragment.app.c {
    private TimePickerDialog.OnTimeSetListener a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnDismissListener f5021b;

    static Dialog d(Bundle bundle, Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(11);
        int i3 = calendar.get(12);
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        c cVar = c.DEFAULT;
        if (bundle != null && bundle.getString("mode", null) != null) {
            cVar = c.valueOf(bundle.getString("mode").toUpperCase(Locale.US));
        }
        if (bundle != null) {
            i2 = bundle.getInt("hour", calendar.get(11));
            i3 = bundle.getInt("minute", calendar.get(12));
            is24HourFormat = bundle.getBoolean("is24Hour", DateFormat.is24HourFormat(context));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (cVar == c.CLOCK) {
                return new a(context, context.getResources().getIdentifier("ClockTimePickerDialog", "style", context.getPackageName()), onTimeSetListener, i2, i3, is24HourFormat);
            }
            if (cVar == c.SPINNER) {
                return new a(context, context.getResources().getIdentifier("SpinnerTimePickerDialog", "style", context.getPackageName()), onTimeSetListener, i2, i3, is24HourFormat);
            }
        }
        return new a(context, onTimeSetListener, i2, i3, is24HourFormat);
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        this.f5021b = onDismissListener;
    }

    public void f(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        this.a = onTimeSetListener;
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return d(getArguments(), getActivity(), this.a);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f5021b;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}