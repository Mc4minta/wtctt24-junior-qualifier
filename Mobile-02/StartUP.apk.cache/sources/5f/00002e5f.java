package com.facebook.react.modules.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.DatePicker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: DismissableDatePickerDialog.java */
/* loaded from: classes2.dex */
public class c extends DatePickerDialog {
    public c(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, onDateSetListener, i2, i3, i4);
        b(context, i2, i3, i4);
    }

    private static Field a(Class cls, Class cls2, String str) {
        Field[] declaredFields;
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            return null;
        }
    }

    private void b(Context context, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT == 24) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$styleable");
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, (int[]) cls.getField("DatePicker").get(null), 16843612, 0);
                int i5 = obtainStyledAttributes.getInt(cls.getField("DatePicker_datePickerMode").getInt(null), 2);
                obtainStyledAttributes.recycle();
                if (i5 == 2) {
                    DatePicker datePicker = (DatePicker) a(DatePickerDialog.class, DatePicker.class, "mDatePicker").get(this);
                    Field a = a(DatePicker.class, Class.forName("android.widget.DatePickerSpinnerDelegate"), "mDelegate");
                    if (a.get(datePicker).getClass() != Class.forName("android.widget.DatePickerSpinnerDelegate")) {
                        a.set(datePicker, null);
                        datePicker.removeAllViews();
                        Class cls2 = Integer.TYPE;
                        Method declaredMethod = DatePicker.class.getDeclaredMethod("createSpinnerUIDelegate", Context.class, AttributeSet.class, cls2, cls2);
                        declaredMethod.setAccessible(true);
                        a.set(datePicker, declaredMethod.invoke(datePicker, context, null, 16843612, 0));
                        datePicker.setCalendarViewShown(false);
                        datePicker.init(i2, i3, i4, this);
                    }
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

    public c(Context context, int i2, DatePickerDialog.OnDateSetListener onDateSetListener, int i3, int i4, int i5) {
        super(context, i2, onDateSetListener, i3, i4, i5);
        b(context, i3, i4, i5);
    }
}