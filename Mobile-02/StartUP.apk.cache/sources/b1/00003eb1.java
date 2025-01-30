package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import java.util.ArrayList;

/* compiled from: MinuteIntervalSnappableTimePickerDialog.java */
/* loaded from: classes2.dex */
class a extends TimePickerDialog {
    private TimePicker a;

    /* renamed from: b  reason: collision with root package name */
    private int f10693b;

    /* renamed from: c  reason: collision with root package name */
    private i f10694c;

    /* renamed from: d  reason: collision with root package name */
    private final TimePickerDialog.OnTimeSetListener f10695d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f10696e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f10697f;

    /* renamed from: g  reason: collision with root package name */
    private Context f10698g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MinuteIntervalSnappableTimePickerDialog.java */
    /* renamed from: com.reactcommunity.rndatetimepicker.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0226a implements Runnable {
        final /* synthetic */ TimePicker a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10699b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10700c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f10701d;

        RunnableC0226a(TimePicker timePicker, int i2, int i3, EditText editText) {
            this.a = timePicker;
            this.f10699b = i2;
            this.f10700c = i3;
            this.f10701d = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i()) {
                this.a.setCurrentHour(Integer.valueOf(this.f10699b));
                this.a.setCurrentMinute(Integer.valueOf(this.f10700c));
                EditText editText = this.f10701d;
                editText.setSelection(editText.getText().length());
                return;
            }
            this.a.setCurrentHour(Integer.valueOf(this.f10699b));
            this.a.setCurrentMinute(0);
            this.a.setCurrentMinute(Integer.valueOf(this.f10700c));
        }
    }

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, i iVar) {
        super(context, onTimeSetListener, i2, i3, z);
        this.f10696e = new Handler();
        this.f10693b = i4;
        this.f10695d = onTimeSetListener;
        this.f10694c = iVar;
        this.f10698g = context;
    }

    private void b(String str) {
        if (f()) {
            throw new RuntimeException(str);
        }
    }

    private void c(TimePicker timePicker, int i2, int i3) {
        b("spinner never needs to be corrected because wrong values are not offered to user (both in scrolling and textInput mode)!");
        RunnableC0226a runnableC0226a = new RunnableC0226a(timePicker, i2, i3, (EditText) timePicker.findFocus());
        this.f10697f = runnableC0226a;
        this.f10696e.postDelayed(runnableC0226a, 500L);
    }

    private int d() {
        return e(this.a.getCurrentMinute().intValue());
    }

    private int e(int i2) {
        return this.f10694c == i.SPINNER ? i2 * this.f10693b : i2;
    }

    private boolean f() {
        return this.f10694c == i.SPINNER;
    }

    public static boolean g(int i2) {
        return i2 >= 1 && i2 <= 30 && 60 % i2 == 0;
    }

    private boolean h(int i2) {
        b("minutesNeedCorrection is not intended to be used with spinner, spinner won't allow picking invalid values");
        return m() && i2 != l(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        View findViewById = findViewById(this.f10698g.getResources().getIdentifier("input_mode", "id", "android"));
        return findViewById != null && findViewById.hasFocus();
    }

    @SuppressLint({"DefaultLocale"})
    private void j() {
        NumberPicker numberPicker = (NumberPicker) findViewById(this.f10698g.getResources().getIdentifier("minute", "id", "android"));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue((60 / this.f10693b) - 1);
        ArrayList arrayList = new ArrayList(60 / this.f10693b);
        int i2 = 0;
        while (i2 < 60) {
            arrayList.add(String.format("%02d", Integer.valueOf(i2)));
            i2 += this.f10693b;
        }
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
    }

    private void k() {
        TimePicker timePicker = (TimePicker) findViewById(this.f10698g.getResources().getIdentifier("timePicker", "id", "android"));
        this.a = timePicker;
        int intValue = timePicker.getCurrentMinute().intValue();
        if (f()) {
            j();
            this.a.setCurrentMinute(Integer.valueOf(l(intValue) / this.f10693b));
            return;
        }
        this.a.setCurrentMinute(Integer.valueOf(l(intValue)));
    }

    private int l(int i2) {
        int round = Math.round(i2 / this.f10693b);
        int i3 = this.f10693b;
        int i4 = round * i3;
        return i4 == 60 ? i4 - i3 : i4;
    }

    private boolean m() {
        return this.f10693b != 1;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m()) {
            k();
        }
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        if (this.a != null && i2 == -1 && m()) {
            int intValue = this.a.getCurrentHour().intValue();
            int d2 = d();
            if (!f()) {
                d2 = l(d2);
            }
            TimePickerDialog.OnTimeSetListener onTimeSetListener = this.f10695d;
            if (onTimeSetListener != null) {
                onTimeSetListener.onTimeSet(this.a, intValue, d2);
                return;
            }
            return;
        }
        super.onClick(dialogInterface, i2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f10696e.removeCallbacks(this.f10697f);
        super.onDetachedFromWindow();
    }

    @Override // android.app.TimePickerDialog, android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
        int e2 = e(i3);
        this.f10696e.removeCallbacks(this.f10697f);
        if (!f() && h(e2)) {
            c(timePicker, i2, l(e2));
        } else {
            super.onTimeChanged(timePicker, i2, i3);
        }
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i2, int i3) {
        if (m()) {
            if (f()) {
                super.updateTime(i2, l(d()) / this.f10693b);
                return;
            } else {
                super.updateTime(i2, l(i3));
                return;
            }
        }
        super.updateTime(i2, i3);
    }

    public a(Context context, int i2, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i3, int i4, int i5, boolean z, i iVar) {
        super(context, i2, onTimeSetListener, i3, i4, z);
        this.f10696e = new Handler();
        this.f10693b = i5;
        this.f10695d = onTimeSetListener;
        this.f10694c = iVar;
        this.f10698g = context;
    }
}