package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.a;
import android.util.Log;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b  reason: collision with root package name */
    private static String f1459b;

    /* renamed from: e  reason: collision with root package name */
    private static c f1462e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f1463f;

    /* renamed from: g  reason: collision with root package name */
    private final NotificationManager f1464g;
    private static final Object a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Set<String> f1460c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f1461d = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class a implements d {
        final String a;

        /* renamed from: b  reason: collision with root package name */
        final int f1465b;

        /* renamed from: c  reason: collision with root package name */
        final String f1466c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f1467d;

        a(String str, int i2, String str2, Notification notification) {
            this.a = str;
            this.f1465b = i2;
            this.f1466c = str2;
            this.f1467d = notification;
        }

        @Override // androidx.core.app.m.d
        public void a(android.support.v4.app.a aVar) throws RemoteException {
            aVar.O0(this.a, this.f1465b, this.f1466c, this.f1467d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.a + ", id:" + this.f1465b + ", tag:" + this.f1466c + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    private static class b {
        final ComponentName a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f1468b;

        b(ComponentName componentName, IBinder iBinder) {
            this.a = componentName;
            this.f1468b = iBinder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class c implements Handler.Callback, ServiceConnection {
        private final Context a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f1469b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f1470c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<ComponentName, a> f1471d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f1472e = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: NotificationManagerCompat.java */
        /* loaded from: classes.dex */
        public static class a {
            final ComponentName a;

            /* renamed from: c  reason: collision with root package name */
            android.support.v4.app.a f1474c;

            /* renamed from: b  reason: collision with root package name */
            boolean f1473b = false;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<d> f1475d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f1476e = 0;

            a(ComponentName componentName) {
                this.a = componentName;
            }
        }

        c(Context context) {
            this.a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1469b = handlerThread;
            handlerThread.start();
            this.f1470c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f1473b) {
                return true;
            }
            boolean bindService = this.a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.a), this, 33);
            aVar.f1473b = bindService;
            if (bindService) {
                aVar.f1476e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.a);
                this.a.unbindService(this);
            }
            return aVar.f1473b;
        }

        private void b(a aVar) {
            if (aVar.f1473b) {
                this.a.unbindService(this);
                aVar.f1473b = false;
            }
            aVar.f1474c = null;
        }

        private void c(d dVar) {
            j();
            for (a aVar : this.f1471d.values()) {
                aVar.f1475d.add(dVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f1471d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f1471d.get(componentName);
            if (aVar != null) {
                aVar.f1474c = a.AbstractBinderC0000a.n(iBinder);
                aVar.f1476e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f1471d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.a + ", " + aVar.f1475d.size() + " queued tasks");
            }
            if (aVar.f1475d.isEmpty()) {
                return;
            }
            if (a(aVar) && aVar.f1474c != null) {
                while (true) {
                    d peek = aVar.f1475d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f1474c);
                        aVar.f1475d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.a, e2);
                    }
                }
                if (aVar.f1475d.isEmpty()) {
                    return;
                }
                i(aVar);
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f1470c.hasMessages(3, aVar.a)) {
                return;
            }
            int i2 = aVar.f1476e + 1;
            aVar.f1476e = i2;
            if (i2 > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + aVar.f1475d.size() + " tasks to " + aVar.a + " after " + aVar.f1476e + " retries");
                aVar.f1475d.clear();
                return;
            }
            int i3 = (1 << (i2 - 1)) * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
            }
            this.f1470c.sendMessageDelayed(this.f1470c.obtainMessage(3, aVar.a), i3);
        }

        private void j() {
            Set<String> c2 = m.c(this.a);
            if (c2.equals(this.f1472e)) {
                return;
            }
            this.f1472e = c2;
            List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (c2.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f1471d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f1471d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f1471d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public void h(d dVar) {
            this.f1470c.obtainMessage(0, dVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c((d) message.obj);
                return true;
            } else if (i2 == 1) {
                b bVar = (b) message.obj;
                e(bVar.a, bVar.f1468b);
                return true;
            } else if (i2 == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1470c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1470c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(android.support.v4.app.a aVar) throws RemoteException;
    }

    private m(Context context) {
        this.f1463f = context;
        this.f1464g = (NotificationManager) context.getSystemService("notification");
    }

    public static m b(Context context) {
        return new m(context);
    }

    public static Set<String> c(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (a) {
            if (string != null) {
                if (!string.equals(f1459b)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f1460c = hashSet;
                    f1459b = string;
                }
            }
            set = f1460c;
        }
        return set;
    }

    private void f(d dVar) {
        synchronized (f1461d) {
            if (f1462e == null) {
                f1462e = new c(this.f1463f.getApplicationContext());
            }
            f1462e.h(dVar);
        }
    }

    private static boolean g(Notification notification) {
        Bundle a2 = j.a(notification);
        return a2 != null && a2.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return this.f1464g.areNotificationsEnabled();
        }
        if (i2 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f1463f.getSystemService("appops");
            ApplicationInfo applicationInfo = this.f1463f.getApplicationInfo();
            String packageName = this.f1463f.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                return true;
            }
        }
        return true;
    }

    public void d(int i2, Notification notification) {
        e(null, i2, notification);
    }

    public void e(String str, int i2, Notification notification) {
        if (g(notification)) {
            f(new a(this.f1463f.getPackageName(), i2, str, notification));
            this.f1464g.cancel(str, i2);
            return;
        }
        this.f1464g.notify(str, i2, notification);
    }
}