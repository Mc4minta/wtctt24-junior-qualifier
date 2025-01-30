package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FrameMetricsAggregator.java */
/* loaded from: classes.dex */
public class g {
    private b a;

    /* compiled from: FrameMetricsAggregator.java */
    /* loaded from: classes.dex */
    private static class a extends b {
        private static HandlerThread a;

        /* renamed from: b  reason: collision with root package name */
        private static Handler f1407b;

        /* renamed from: c  reason: collision with root package name */
        int f1408c;

        /* renamed from: d  reason: collision with root package name */
        SparseIntArray[] f1409d = new SparseIntArray[9];

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<WeakReference<Activity>> f1410e = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f1411f = new Window$OnFrameMetricsAvailableListenerC0024a();

        /* compiled from: FrameMetricsAggregator.java */
        /* renamed from: androidx.core.app.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class Window$OnFrameMetricsAvailableListenerC0024a implements Window.OnFrameMetricsAvailableListener {
            Window$OnFrameMetricsAvailableListenerC0024a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                a aVar = a.this;
                if ((aVar.f1408c & 1) != 0) {
                    aVar.c(aVar.f1409d[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f1408c & 2) != 0) {
                    aVar2.c(aVar2.f1409d[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f1408c & 4) != 0) {
                    aVar3.c(aVar3.f1409d[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f1408c & 8) != 0) {
                    aVar4.c(aVar4.f1409d[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f1408c & 16) != 0) {
                    aVar5.c(aVar5.f1409d[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f1408c & 64) != 0) {
                    aVar6.c(aVar6.f1409d[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f1408c & 32) != 0) {
                    aVar7.c(aVar7.f1409d[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f1408c & 128) != 0) {
                    aVar8.c(aVar8.f1409d[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f1408c & 256) != 0) {
                    aVar9.c(aVar9.f1409d[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i2) {
            this.f1408c = i2;
        }

        @Override // androidx.core.app.g.b
        public void a(Activity activity) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                a = handlerThread;
                handlerThread.start();
                f1407b = new Handler(a.getLooper());
            }
            for (int i2 = 0; i2 <= 8; i2++) {
                SparseIntArray[] sparseIntArrayArr = this.f1409d;
                if (sparseIntArrayArr[i2] == null && (this.f1408c & (1 << i2)) != 0) {
                    sparseIntArrayArr[i2] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f1411f, f1407b);
            this.f1410e.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.g.b
        public SparseIntArray[] b(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f1410e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.f1410e.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1411f);
            return this.f1409d;
        }

        void c(SparseIntArray sparseIntArray, long j2) {
            if (sparseIntArray != null) {
                int i2 = (int) ((500000 + j2) / 1000000);
                if (j2 >= 0) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                }
            }
        }
    }

    /* compiled from: FrameMetricsAggregator.java */
    /* loaded from: classes.dex */
    private static class b {
        b() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b(Activity activity) {
            return null;
        }
    }

    public g() {
        this(1);
    }

    public void a(Activity activity) {
        this.a.a(activity);
    }

    public SparseIntArray[] b(Activity activity) {
        return this.a.b(activity);
    }

    public g(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.a = new a(i2);
        } else {
            this.a = new b();
        }
    }
}