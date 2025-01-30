package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.DatePicker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: RNDismissableDatePickerDialog.java */
/* loaded from: classes2.dex */
public class f extends DatePickerDialog {
    public f(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, d dVar) {
        super(context, onDateSetListener, i2, i3, i4);
        a(context, i2, i3, i4, dVar);
    }

    private void a(Context context, int i2, int i3, int i4, d dVar) {
        if (Build.VERSION.SDK_INT == 24 && dVar == d.SPINNER) {
            try {
                context.obtainStyledAttributes(null, (int[]) Class.forName("com.android.internal.R$styleable").getField("DatePicker").get(null), 16843612, 0).recycle();
                DatePicker datePicker = (DatePicker) j.a(DatePickerDialog.class, DatePicker.class, "mDatePicker").get(this);
                Field a = j.a(DatePicker.class, Class.forName("android.widget.DatePickerSpinnerDelegate"), "mDelegate");
                if (a.get(datePicker).getClass() != Class.forName("android.widget.DatePickerSpinnerDelegate")) {
                    a.set(datePicker, null);
                    datePicker.removeAllViews();
                    Class cls = Integer.TYPE;
                    Method declaredMethod = DatePicker.class.getDeclaredMethod("createSpinnerUIDelegate", Context.class, AttributeSet.class, cls, cls);
                    declaredMethod.setAccessible(true);
                    a.set(datePicker, declaredMethod.invoke(datePicker, context, null, 16843612, 0));
                    datePicker.setCalendarViewShown(false);
                    datePicker.init(i2, i3, i4, this);
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (Build.VERSION.SDK_INT > 19) {
            super.onStop();
        }
    }

    public f(Context context, int i2, DatePickerDialog.OnDateSetListener onDateSetListener, int i3, int i4, int i5, d dVar) {
        super(context, i2, onDateSetListener, i3, i4, i5);
        a(context, i3, i4, i5, dVar);
    }
}