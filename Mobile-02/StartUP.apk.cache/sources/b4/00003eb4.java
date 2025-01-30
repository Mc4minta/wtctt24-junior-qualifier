package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: RNDatePickerDialogFragment.java */
@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class c extends androidx.fragment.app.c {
    private static DialogInterface.OnClickListener a;

    /* renamed from: b  reason: collision with root package name */
    private DatePickerDialog f10703b;

    /* renamed from: c  reason: collision with root package name */
    private DatePickerDialog.OnDateSetListener f10704c;

    /* renamed from: d  reason: collision with root package name */
    private DialogInterface.OnDismissListener f10705d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNDatePickerDialogFragment.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.CALENDAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.SPINNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static DatePickerDialog d(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog e2 = e(bundle, context, onDateSetListener);
        if (bundle != null && bundle.containsKey("neutralButtonLabel")) {
            e2.setButton(-3, bundle.getString("neutralButtonLabel"), a);
        }
        DatePicker datePicker = e2.getDatePicker();
        if (bundle != null && bundle.containsKey("minimumDate")) {
            calendar.setTimeInMillis(bundle.getLong("minimumDate"));
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            datePicker.setMinDate(calendar.getTimeInMillis());
        } else {
            datePicker.setMinDate(-2208988800001L);
        }
        if (bundle != null && bundle.containsKey("maximumDate")) {
            calendar.setTimeInMillis(bundle.getLong("maximumDate"));
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, androidx.room.j.MAX_BIND_PARAMETER_CNT);
            datePicker.setMaxDate(calendar.getTimeInMillis());
        }
        return e2;
    }

    static DatePickerDialog e(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        b bVar = new b(bundle);
        int f2 = bVar.f();
        int d2 = bVar.d();
        int a2 = bVar.a();
        d valueOf = (bundle == null || bundle.getString("display", null) == null) ? d.DEFAULT : d.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        if (Build.VERSION.SDK_INT >= 21) {
            int i2 = a.a[valueOf.ordinal()];
            if (i2 != 1 && i2 != 2) {
                return new f(context, onDateSetListener, f2, d2, a2, valueOf);
            }
            return new f(context, context.getResources().getIdentifier(valueOf == d.CALENDAR ? "CalendarDatePickerDialog" : "SpinnerDatePickerDialog", "style", context.getPackageName()), onDateSetListener, f2, d2, a2, valueOf);
        }
        f fVar = new f(context, onDateSetListener, f2, d2, a2, valueOf);
        int i3 = a.a[valueOf.ordinal()];
        if (i3 == 1) {
            fVar.getDatePicker().setCalendarViewShown(true);
            fVar.getDatePicker().setSpinnersShown(false);
        } else if (i3 == 2) {
            fVar.getDatePicker().setCalendarViewShown(false);
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.f10704c = onDateSetListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(DialogInterface.OnDismissListener onDismissListener) {
        this.f10705d = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(DialogInterface.OnClickListener onClickListener) {
        a = onClickListener;
    }

    public void i(Bundle bundle) {
        b bVar = new b(bundle);
        this.f10703b.updateDate(bVar.f(), bVar.d(), bVar.a());
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog d2 = d(getArguments(), getActivity(), this.f10704c);
        this.f10703b = d2;
        return d2;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f10705d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}