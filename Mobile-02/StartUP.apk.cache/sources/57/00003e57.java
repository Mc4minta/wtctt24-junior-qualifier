package com.lwansbrough.RCTCamera;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.react.bridge.ReactApplicationContext;

/* compiled from: RCTSensorOrientationChecker.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    private SensorManager f10511c;
    int a = 0;

    /* renamed from: d  reason: collision with root package name */
    private f f10512d = null;

    /* renamed from: b  reason: collision with root package name */
    private SensorEventListener f10510b = new b();

    /* compiled from: RCTSensorOrientationChecker.java */
    /* loaded from: classes2.dex */
    private class b implements SensorEventListener {
        private b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            int i2 = (f2 > 5.0f ? 1 : (f2 == 5.0f ? 0 : -1));
            if (i2 < 0 && f2 > -5.0f && f3 > 5.0f) {
                e.this.a = 0;
            } else if (f2 < -5.0f && f3 < 5.0f && f3 > -5.0f) {
                e.this.a = 3;
            } else if (i2 < 0 && f2 > -5.0f && f3 < -5.0f) {
                e.this.a = 2;
            } else if (f2 > 5.0f && f3 < 5.0f && f3 > -5.0f) {
                e.this.a = 1;
            }
            if (e.this.f10512d != null) {
                e.this.f10512d.a();
            }
        }
    }

    public e(ReactApplicationContext reactApplicationContext) {
        this.f10511c = (SensorManager) reactApplicationContext.getSystemService("sensor");
    }

    public int b() {
        return this.a;
    }

    public void c() {
        this.f10511c.unregisterListener(this.f10510b);
    }

    public void d() {
        SensorManager sensorManager = this.f10511c;
        sensorManager.registerListener(this.f10510b, sensorManager.getDefaultSensor(1), 3);
    }

    public void e(f fVar) {
        this.f10512d = fVar;
    }

    public void f() {
        this.f10512d = null;
    }
}