package com.facebook.react.modules.timepicker;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import com.facebook.fbreact.specs.NativeTimePickerAndroidSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;

@e.f.m.x.a.a(name = TimePickerDialogModule.FRAGMENT_TAG)
/* loaded from: classes2.dex */
public class TimePickerDialogModule extends NativeTimePickerAndroidSpec {
    static final String ACTION_DISMISSED = "dismissedAction";
    static final String ACTION_TIME_SET = "timeSetAction";
    static final String ARG_HOUR = "hour";
    static final String ARG_IS24HOUR = "is24Hour";
    static final String ARG_MINUTE = "minute";
    static final String ARG_MODE = "mode";
    private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";
    public static final String FRAGMENT_TAG = "TimePickerAndroid";

    /* loaded from: classes2.dex */
    private class a implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener {
        private final Promise a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5019b = false;

        public a(Promise promise) {
            this.a = promise;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f5019b || !TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", TimePickerDialogModule.ACTION_DISMISSED);
            this.a.resolve(writableNativeMap);
            this.f5019b = true;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            if (this.f5019b || !TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", TimePickerDialogModule.ACTION_TIME_SET);
            writableNativeMap.putInt(TimePickerDialogModule.ARG_HOUR, i2);
            writableNativeMap.putInt(TimePickerDialogModule.ARG_MINUTE, i3);
            this.a.resolve(writableNativeMap);
            this.f5019b = true;
        }
    }

    public TimePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey(ARG_HOUR) && !readableMap.isNull(ARG_HOUR)) {
            bundle.putInt(ARG_HOUR, readableMap.getInt(ARG_HOUR));
        }
        if (readableMap.hasKey(ARG_MINUTE) && !readableMap.isNull(ARG_MINUTE)) {
            bundle.putInt(ARG_MINUTE, readableMap.getInt(ARG_MINUTE));
        }
        if (readableMap.hasKey(ARG_IS24HOUR) && !readableMap.isNull(ARG_IS24HOUR)) {
            bundle.putBoolean(ARG_IS24HOUR, readableMap.getBoolean(ARG_IS24HOUR));
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

    @Override // com.facebook.fbreact.specs.NativeTimePickerAndroidSpec
    public void open(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && (currentActivity instanceof d)) {
            m supportFragmentManager = ((d) currentActivity).getSupportFragmentManager();
            androidx.fragment.app.c cVar = (androidx.fragment.app.c) supportFragmentManager.Z(FRAGMENT_TAG);
            if (cVar != null) {
                cVar.dismiss();
            }
            b bVar = new b();
            if (readableMap != null) {
                bVar.setArguments(createFragmentArguments(readableMap));
            }
            a aVar = new a(promise);
            bVar.e(aVar);
            bVar.f(aVar);
            bVar.show(supportFragmentManager, FRAGMENT_TAG);
            return;
        }
        promise.reject(ERROR_NO_ACTIVITY, "Tried to open a DatePicker dialog while not attached to a FragmentActivity");
    }
}