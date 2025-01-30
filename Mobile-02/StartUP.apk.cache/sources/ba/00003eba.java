package com.reactcommunity.rndatetimepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import java.util.Locale;

/* compiled from: RNTimePickerDialogFragment.java */
/* loaded from: classes2.dex */
public class h extends androidx.fragment.app.c {
    private static DialogInterface.OnClickListener a;

    /* renamed from: b  reason: collision with root package name */
    private TimePickerDialog f10709b;

    /* renamed from: c  reason: collision with root package name */
    private TimePickerDialog.OnTimeSetListener f10710c;

    /* renamed from: d  reason: collision with root package name */
    private DialogInterface.OnDismissListener f10711d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNTimePickerDialogFragment.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.CLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.SPINNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static TimePickerDialog d(Bundle bundle, Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        TimePickerDialog e2 = e(bundle, context, onTimeSetListener);
        if (bundle != null && bundle.containsKey("neutralButtonLabel")) {
            e2.setButton(-3, bundle.getString("neutralButtonLabel"), a);
        }
        return e2;
    }

    static TimePickerDialog e(Bundle bundle, Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        int i2;
        b bVar = new b(bundle);
        int b2 = bVar.b();
        int c2 = bVar.c();
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        int i3 = (bundle == null || !com.reactcommunity.rndatetimepicker.a.g(bundle.getInt("minuteInterval"))) ? 1 : bundle.getInt("minuteInterval");
        i iVar = i.DEFAULT;
        if (bundle != null && bundle.getString("display", null) != null) {
            iVar = i.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        }
        i iVar2 = iVar;
        boolean z = bundle != null ? bundle.getBoolean("is24Hour", DateFormat.is24HourFormat(context)) : is24HourFormat;
        if (Build.VERSION.SDK_INT >= 21 && ((i2 = a.a[iVar2.ordinal()]) == 1 || i2 == 2)) {
            return new g(context, context.getResources().getIdentifier(iVar2 == i.CLOCK ? "ClockTimePickerDialog" : "SpinnerTimePickerDialog", "style", context.getPackageName()), onTimeSetListener, b2, c2, i3, z, iVar2);
        }
        return new g(context, onTimeSetListener, b2, c2, i3, z, iVar2);
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        this.f10711d = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(DialogInterface.OnClickListener onClickListener) {
        a = onClickListener;
    }

    public void h(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        this.f10710c = onTimeSetListener;
    }

    public void i(Bundle bundle) {
        b bVar = new b(bundle);
        this.f10709b.updateTime(bVar.b(), bVar.c());
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        TimePickerDialog d2 = d(getArguments(), getActivity(), this.f10710c);
        this.f10709b = d2;
        return d2;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f10711d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}