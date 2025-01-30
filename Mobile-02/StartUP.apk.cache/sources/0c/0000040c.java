package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.e;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    int a = 0;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<Integer, String> f2218b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final RemoteCallbackList<d> f2219c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final e.a f2220d = new b();

    /* loaded from: classes.dex */
    class a extends RemoteCallbackList<d> {
        a() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(d dVar, Object obj) {
            MultiInstanceInvalidationService.this.f2218b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    /* loaded from: classes.dex */
    class b extends e.a {
        b() {
        }

        @Override // androidx.room.e
        public void K0(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f2219c) {
                String str = MultiInstanceInvalidationService.this.f2218b.get(Integer.valueOf(i2));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f2219c.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    int intValue = ((Integer) MultiInstanceInvalidationService.this.f2219c.getBroadcastCookie(i3)).intValue();
                    String str2 = MultiInstanceInvalidationService.this.f2218b.get(Integer.valueOf(intValue));
                    if (i2 != intValue && str.equals(str2)) {
                        try {
                            MultiInstanceInvalidationService.this.f2219c.getBroadcastItem(i3).F(strArr);
                        } catch (RemoteException e2) {
                            Log.w("ROOM", "Error invoking a remote callback", e2);
                        }
                    }
                }
                MultiInstanceInvalidationService.this.f2219c.finishBroadcast();
            }
        }

        @Override // androidx.room.e
        public int L(d dVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f2219c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.a + 1;
                multiInstanceInvalidationService.a = i2;
                if (multiInstanceInvalidationService.f2219c.register(dVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.f2218b.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.a--;
                return 0;
            }
        }

        @Override // androidx.room.e
        public void S0(d dVar, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f2219c) {
                MultiInstanceInvalidationService.this.f2219c.unregister(dVar);
                MultiInstanceInvalidationService.this.f2218b.remove(Integer.valueOf(i2));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2220d;
    }
}