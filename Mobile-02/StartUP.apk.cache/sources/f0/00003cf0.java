package com.google.zxing.p.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* compiled from: AmbientLightManager.java */
/* loaded from: classes2.dex */
public final class a implements SensorEventListener {
    private com.journeyapps.barcodescanner.q.c a;

    /* renamed from: b  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.d f9878b;

    /* renamed from: c  reason: collision with root package name */
    private Sensor f9879c;

    /* renamed from: d  reason: collision with root package name */
    private Context f9880d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f9881e = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmbientLightManager.java */
    /* renamed from: com.google.zxing.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0208a implements Runnable {
        final /* synthetic */ boolean a;

        RunnableC0208a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a.s(this.a);
        }
    }

    public a(Context context, com.journeyapps.barcodescanner.q.c cVar, com.journeyapps.barcodescanner.q.d dVar) {
        this.f9880d = context;
        this.a = cVar;
        this.f9878b = dVar;
    }

    private void b(boolean z) {
        this.f9881e.post(new RunnableC0208a(z));
    }

    public void c() {
        if (this.f9878b.d()) {
            SensorManager sensorManager = (SensorManager) this.f9880d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f9879c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void d() {
        if (this.f9879c != null) {
            ((SensorManager) this.f9880d.getSystemService("sensor")).unregisterListener(this);
            this.f9879c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        if (this.a != null) {
            if (f2 <= 45.0f) {
                b(true);
            } else if (f2 >= 450.0f) {
                b(false);
            }
        }
    }
}