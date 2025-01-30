package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TimePicker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* compiled from: RNDismissableTimePickerDialog.java */
/* loaded from: classes2.dex */
public class g extends a {
    public g(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, i iVar) {
        super(context, onTimeSetListener, i2, i3, i4, z, iVar);
        n(context, i2, i3, z, iVar);
    }

    private void n(Context context, int i2, int i3, boolean z, i iVar) {
        if (Build.VERSION.SDK_INT == 24 && iVar == i.SPINNER) {
            try {
                context.obtainStyledAttributes(null, (int[]) Class.forName("com.android.internal.R$styleable").getField("TimePicker").get(null), 16843933, 0).recycle();
                TimePicker timePicker = (TimePicker) j.a(TimePickerDialog.class, TimePicker.class, "mTimePicker").get(this);
                Field a = j.a(TimePicker.class, Class.forName("android.widget.TimePicker$TimePickerDelegate"), "mDelegate");
                Object obj = a.get(timePicker);
                Class<?> cls = Class.forName("android.widget.TimePickerSpinnerDelegate");
                if (obj.getClass() != cls) {
                    a.set(timePicker, null);
                    timePicker.removeAllViews();
                    Class<?> cls2 = Integer.TYPE;
                    Constructor<?> constructor = cls.getConstructor(TimePicker.class, Context.class, AttributeSet.class, cls2, cls2);
                    constructor.setAccessible(true);
                    a.set(timePicker, constructor.newInstance(timePicker, context, null, 16843933, 0));
                    timePicker.setIs24HourView(Boolean.valueOf(z));
                    timePicker.setCurrentHour(Integer.valueOf(i2));
                    timePicker.setCurrentMinute(Integer.valueOf(i3));
                    timePicker.setOnTimeChangedListener(this);
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // com.reactcommunity.rndatetimepicker.a, android.app.Dialog, android.view.Window.Callback
    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.reactcommunity.rndatetimepicker.a, android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(DialogInterface dialogInterface, int i2) {
        super.onClick(dialogInterface, i2);
    }

    @Override // com.reactcommunity.rndatetimepicker.a, android.app.Dialog, android.view.Window.Callback
    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (Build.VERSION.SDK_INT > 19) {
            super.onStop();
        }
    }

    @Override // com.reactcommunity.rndatetimepicker.a, android.app.TimePickerDialog, android.widget.TimePicker.OnTimeChangedListener
    public /* bridge */ /* synthetic */ void onTimeChanged(TimePicker timePicker, int i2, int i3) {
        super.onTimeChanged(timePicker, i2, i3);
    }

    @Override // com.reactcommunity.rndatetimepicker.a, android.app.TimePickerDialog
    public /* bridge */ /* synthetic */ void updateTime(int i2, int i3) {
        super.updateTime(i2, i3);
    }

    public g(Context context, int i2, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i3, int i4, int i5, boolean z, i iVar) {
        super(context, i2, onTimeSetListener, i3, i4, i5, z, iVar);
        n(context, i3, i4, z, iVar);
    }
}