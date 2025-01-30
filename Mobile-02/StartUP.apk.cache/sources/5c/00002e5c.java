package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.room.j;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: DatePickerDialogFragment.java */
@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class a extends androidx.fragment.app.c {
    private DatePickerDialog.OnDateSetListener a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnDismissListener f4912b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DatePickerDialogFragment.java */
    /* renamed from: com.facebook.react.modules.datepicker.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0118a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CALENDAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.SPINNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static Dialog d(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        c cVar;
        Calendar calendar = Calendar.getInstance();
        if (bundle != null && bundle.containsKey("date")) {
            calendar.setTimeInMillis(bundle.getLong("date"));
        }
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        int i4 = calendar.get(5);
        b bVar = b.DEFAULT;
        c cVar2 = null;
        if (bundle != null && bundle.getString("mode", null) != null) {
            bVar = b.valueOf(bundle.getString("mode").toUpperCase(Locale.US));
        }
        b bVar2 = bVar;
        if (Build.VERSION.SDK_INT >= 21) {
            int i5 = C0118a.a[bVar2.ordinal()];
            if (i5 == 1) {
                cVar = new c(context, context.getResources().getIdentifier("CalendarDatePickerDialog", "style", context.getPackageName()), onDateSetListener, i2, i3, i4);
            } else if (i5 == 2) {
                cVar = new c(context, 16973939, onDateSetListener, i2, i3, i4);
                cVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            } else if (i5 == 3) {
                cVar = new c(context, onDateSetListener, i2, i3, i4);
            }
            cVar2 = cVar;
        } else {
            c cVar3 = new c(context, onDateSetListener, i2, i3, i4);
            int i6 = C0118a.a[bVar2.ordinal()];
            if (i6 == 1) {
                cVar3.getDatePicker().setCalendarViewShown(true);
                cVar3.getDatePicker().setSpinnersShown(false);
            } else if (i6 == 2) {
                cVar3.getDatePicker().setCalendarViewShown(false);
            }
            cVar2 = cVar3;
        }
        DatePicker datePicker = cVar2.getDatePicker();
        if (bundle != null && bundle.containsKey("minDate")) {
            calendar.setTimeInMillis(bundle.getLong("minDate"));
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            datePicker.setMinDate(calendar.getTimeInMillis());
        } else {
            datePicker.setMinDate(-2208988800001L);
        }
        if (bundle != null && bundle.containsKey("maxDate")) {
            calendar.setTimeInMillis(bundle.getLong("maxDate"));
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, j.MAX_BIND_PARAMETER_CNT);
            datePicker.setMaxDate(calendar.getTimeInMillis());
        }
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.a = onDateSetListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(DialogInterface.OnDismissListener onDismissListener) {
        this.f4912b = onDismissListener;
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return d(getArguments(), getActivity(), this.a);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f4912b;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}