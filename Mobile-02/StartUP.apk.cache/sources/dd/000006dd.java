package com.appsflyer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.appsflyer.internal.r;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class AFSensorManager {
    public static volatile AFSensorManager sInstance;

    /* renamed from: ȷ  reason: contains not printable characters */
    private static final BitSet f39;

    /* renamed from: ɪ  reason: contains not printable characters */
    private static final Handler f40;

    /* renamed from: ı  reason: contains not printable characters */
    final Handler f41;

    /* renamed from: Ɩ  reason: contains not printable characters */
    int f42;

    /* renamed from: ǃ  reason: contains not printable characters */
    final Map<r, r> f43;

    /* renamed from: ɨ  reason: contains not printable characters */
    private final Runnable f44;

    /* renamed from: ɩ  reason: contains not printable characters */
    final SensorManager f45;

    /* renamed from: ɹ  reason: contains not printable characters */
    final Runnable f46;

    /* renamed from: ɾ  reason: contains not printable characters */
    long f47;

    /* renamed from: Ι  reason: contains not printable characters */
    boolean f48;

    /* renamed from: ι  reason: contains not printable characters */
    final Object f49 = new Object();

    /* renamed from: І  reason: contains not printable characters */
    final Runnable f50;

    /* renamed from: і  reason: contains not printable characters */
    final Runnable f51;

    /* renamed from: Ӏ  reason: contains not printable characters */
    boolean f52;

    /* renamed from: ӏ  reason: contains not printable characters */
    private final Map<r, Map<String, Object>> f53;

    static {
        BitSet bitSet = new BitSet(6);
        f39 = bitSet;
        f40 = new Handler(Looper.getMainLooper());
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFSensorManager(SensorManager sensorManager, Handler handler) {
        BitSet bitSet = f39;
        this.f43 = new HashMap(bitSet.size());
        this.f53 = new ConcurrentHashMap(bitSet.size());
        this.f46 = new Runnable() { // from class: com.appsflyer.AFSensorManager.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFSensorManager.this.f49) {
                    AFSensorManager aFSensorManager = AFSensorManager.this;
                    try {
                        for (Sensor sensor : aFSensorManager.f45.getSensorList(-1)) {
                            if (AFSensorManager.m28(sensor.getType())) {
                                r rVar = new r(sensor.getType(), sensor.getName(), sensor.getVendor());
                                if (!aFSensorManager.f43.containsKey(rVar)) {
                                    aFSensorManager.f43.put(rVar, rVar);
                                }
                                aFSensorManager.f45.registerListener(aFSensorManager.f43.get(rVar), sensor, 0);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    aFSensorManager.f52 = true;
                    AFSensorManager aFSensorManager2 = AFSensorManager.this;
                    aFSensorManager2.f41.postDelayed(aFSensorManager2.f44, 100L);
                    AFSensorManager.this.f48 = true;
                }
            }
        };
        this.f51 = new Runnable() { // from class: com.appsflyer.AFSensorManager.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFSensorManager.this.f49) {
                    AFSensorManager.this.m31();
                }
            }
        };
        this.f50 = new Runnable() { // from class: com.appsflyer.AFSensorManager.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFSensorManager.this.f49) {
                    AFSensorManager aFSensorManager = AFSensorManager.this;
                    if (aFSensorManager.f48) {
                        aFSensorManager.f41.removeCallbacks(aFSensorManager.f46);
                        AFSensorManager aFSensorManager2 = AFSensorManager.this;
                        aFSensorManager2.f41.removeCallbacks(aFSensorManager2.f51);
                        AFSensorManager.this.m31();
                        AFSensorManager.this.f48 = false;
                    }
                }
            }
        };
        this.f42 = 1;
        this.f47 = 0L;
        this.f44 = new Runnable() { // from class: com.appsflyer.AFSensorManager.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFSensorManager.this.f49) {
                    if (AFSensorManager.this.f42 == 0) {
                        AFSensorManager.m29(AFSensorManager.this);
                    }
                    AFSensorManager aFSensorManager = AFSensorManager.this;
                    aFSensorManager.f41.postDelayed(aFSensorManager.f51, aFSensorManager.f42 * 500);
                }
            }
        };
        this.f45 = sensorManager;
        this.f41 = handler;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    static /* synthetic */ int m29(AFSensorManager aFSensorManager) {
        aFSensorManager.f42 = 1;
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ι  reason: contains not printable characters */
    public final List<Map<String, Object>> m32() {
        synchronized (this.f49) {
            if (!this.f43.isEmpty() && this.f52) {
                for (r rVar : this.f43.values()) {
                    rVar.m191(this.f53, false);
                }
            }
            if (this.f53.isEmpty()) {
                return new CopyOnWriteArrayList(Collections.emptyList());
            }
            return new CopyOnWriteArrayList(this.f53.values());
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static AFSensorManager m24(SensorManager sensorManager, Handler handler) {
        if (sInstance == null) {
            synchronized (AFSensorManager.class) {
                if (sInstance == null) {
                    sInstance = new AFSensorManager(sensorManager, handler);
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static AFSensorManager m27(Context context) {
        if (sInstance != null) {
            return sInstance;
        }
        return m24((SensorManager) context.getApplicationContext().getSystemService("sensor"), f40);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    final void m31() {
        try {
            if (!this.f43.isEmpty()) {
                for (r rVar : this.f43.values()) {
                    this.f45.unregisterListener(rVar);
                    rVar.m191(this.f53, true);
                }
            }
        } catch (Throwable unused) {
        }
        this.f42 = 0;
        this.f52 = false;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    static boolean m28(int i2) {
        return i2 >= 0 && f39.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final List<Map<String, Object>> m30() {
        for (r rVar : this.f43.values()) {
            rVar.m191(this.f53, true);
        }
        Map<r, Map<String, Object>> map = this.f53;
        if (map != null && !map.isEmpty()) {
            return new CopyOnWriteArrayList(this.f53.values());
        }
        return new CopyOnWriteArrayList(Collections.emptyList());
    }
}