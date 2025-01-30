package com.facebook.react.modules.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import com.facebook.fbreact.specs.NativeDatePickerAndroidSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;

@e.f.m.x.a.a(name = DatePickerDialogModule.FRAGMENT_TAG)
/* loaded from: classes2.dex */
public class DatePickerDialogModule extends NativeDatePickerAndroidSpec {
    static final String ACTION_DATE_SET = "dateSetAction";
    static final String ACTION_DISMISSED = "dismissedAction";
    static final String ARG_DATE = "date";
    static final String ARG_MAXDATE = "maxDate";
    static final String ARG_MINDATE = "minDate";
    static final String ARG_MODE = "mode";
    private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";
    public static final String FRAGMENT_TAG = "DatePickerAndroid";

    /* loaded from: classes2.dex */
    private class a implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener {
        private final Promise a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4910b = false;

        public a(Promise promise) {
            this.a = promise;
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            if (this.f4910b || !DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", DatePickerDialogModule.ACTION_DATE_SET);
            writableNativeMap.putInt("year", i2);
            writableNativeMap.putInt("month", i3);
            writableNativeMap.putInt("day", i4);
            this.a.resolve(writableNativeMap);
            this.f4910b = true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f4910b || !DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", DatePickerDialogModule.ACTION_DISMISSED);
            this.a.resolve(writableNativeMap);
            this.f4910b = true;
        }
    }

    public DatePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey(ARG_DATE) && !readableMap.isNull(ARG_DATE)) {
            bundle.putLong(ARG_DATE, (long) readableMap.getDouble(ARG_DATE));
        }
        if (readableMap.hasKey(ARG_MINDATE) && !readableMap.isNull(ARG_MINDATE)) {
            bundle.putLong(ARG_MINDATE, (long) readableMap.getDouble(ARG_MINDATE));
        }
        if (readableMap.hasKey(ARG_MAXDATE) && !readableMap.isNull(ARG_MAXDATE)) {
            bundle.putLong(ARG_MAXDATE, (long) readableMap.getDouble(ARG_MAXDATE));
        }
        if (readableMap.hasKey(ARG_MODE) && !readableMap.isNull(ARG_MODE)) {
            bundle.putString(ARG_MODE, readableMap.getString(ARG_MODE));
        }
        return bundle;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return FRAGMENT_TAG;
    }

    @Override // com.facebook.fbreact.specs.NativeDatePickerAndroidSpec
    public void open(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && (currentActivity instanceof d)) {
            m supportFragmentManager = ((d) currentActivity).getSupportFragmentManager();
            androidx.fragment.app.c cVar = (androidx.fragment.app.c) supportFragmentManager.Z(FRAGMENT_TAG);
            if (cVar != null) {
                cVar.dismiss();
            }
            com.facebook.react.modules.datepicker.a aVar = new com.facebook.react.modules.datepicker.a();
            if (readableMap != null) {
                aVar.setArguments(createFragmentArguments(readableMap));
            }
            a aVar2 = new a(promise);
            aVar.f(aVar2);
            aVar.e(aVar2);
            aVar.show(supportFragmentManager, FRAGMENT_TAG);
            return;
        }
        promise.reject(ERROR_NO_ACTIVITY, "Tried to open a DatePicker dialog while not attached to a FragmentActivity");
    }
}