package e.f.m;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: MemoryPressureRouter.java */
/* loaded from: classes2.dex */
public class d implements ComponentCallbacks2 {
    private final Set<MemoryPressureListener> a = Collections.synchronizedSet(new LinkedHashSet());

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        context.getApplicationContext().registerComponentCallbacks(this);
    }

    private void b(int i2) {
        Set<MemoryPressureListener> set = this.a;
        for (MemoryPressureListener memoryPressureListener : (MemoryPressureListener[]) set.toArray(new MemoryPressureListener[set.size()])) {
            memoryPressureListener.handleMemoryPressure(i2);
        }
    }

    public void a(MemoryPressureListener memoryPressureListener) {
        this.a.add(memoryPressureListener);
    }

    public void c(MemoryPressureListener memoryPressureListener) {
        this.a.remove(memoryPressureListener);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        b(i2);
    }
}