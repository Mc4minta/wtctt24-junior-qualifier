package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class r implements SensorEventListener {

    /* renamed from: ı  reason: contains not printable characters */
    private final String f280;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private long f281;

    /* renamed from: ǃ  reason: contains not printable characters */
    private final int f282;

    /* renamed from: ɩ  reason: contains not printable characters */
    private final float[][] f283 = new float[2];

    /* renamed from: Ι  reason: contains not printable characters */
    private final long[] f284 = new long[2];

    /* renamed from: ι  reason: contains not printable characters */
    private final String f285;

    /* renamed from: І  reason: contains not printable characters */
    private final int f286;

    /* renamed from: і  reason: contains not printable characters */
    private double f287;

    public r(int i2, String str, String str2) {
        this.f282 = i2;
        str = str == null ? "" : str;
        this.f280 = str;
        str2 = str2 == null ? "" : str2;
        this.f285 = str2;
        this.f286 = ((((i2 + 31) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static double m185(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d2 = 0.0d;
        for (int i2 = 0; i2 < min; i2++) {
            d2 += StrictMath.pow(fArr[i2] - fArr2[i2], 2.0d);
        }
        return Math.sqrt(d2);
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private boolean m186() {
        return this.f283[0] != null;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static List<Float> m187(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static boolean m189(Sensor sensor) {
        return (sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true;
    }

    /* renamed from: ι  reason: contains not printable characters */
    private Map<String, Object> m190() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.f282));
        concurrentHashMap.put("sN", this.f280);
        concurrentHashMap.put("sV", this.f285);
        float[] fArr = this.f283[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", m187(fArr));
        }
        float[] fArr2 = this.f283[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", m187(fArr2));
        }
        return concurrentHashMap;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return m188(rVar.f282, rVar.f280, rVar.f285);
        }
        return false;
    }

    public final int hashCode() {
        return this.f286;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null || sensorEvent.values == null || !m189(sensorEvent.sensor)) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        String name = sensorEvent.sensor.getName();
        String vendor = sensorEvent.sensor.getVendor();
        long j2 = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        if (m188(type, name, vendor)) {
            long currentTimeMillis = System.currentTimeMillis();
            float[][] fArr2 = this.f283;
            float[] fArr3 = fArr2[0];
            if (fArr3 == null) {
                fArr2[0] = Arrays.copyOf(fArr, fArr.length);
                this.f284[0] = currentTimeMillis;
                return;
            }
            float[] fArr4 = fArr2[1];
            if (fArr4 == null) {
                float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                this.f283[1] = copyOf;
                this.f284[1] = currentTimeMillis;
                this.f287 = m185(fArr3, copyOf);
            } else if (50000000 <= j2 - this.f281) {
                this.f281 = j2;
                if (Arrays.equals(fArr4, fArr)) {
                    this.f284[1] = currentTimeMillis;
                    return;
                }
                double m185 = m185(fArr3, fArr);
                if (m185 > this.f287) {
                    this.f283[1] = Arrays.copyOf(fArr, fArr.length);
                    this.f284[1] = currentTimeMillis;
                    this.f287 = m185;
                }
            }
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m188(int i2, String str, String str2) {
        return this.f282 == i2 && this.f280.equals(str) && this.f285.equals(str2);
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final void m191(Map<r, Map<String, Object>> map, boolean z) {
        if (m186()) {
            map.put(this, m190());
            if (z) {
                int length = this.f283.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.f283[i2] = null;
                }
                int length2 = this.f284.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f284[i3] = 0;
                }
                this.f287 = 0.0d;
                this.f281 = 0L;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, m190());
        }
    }
}