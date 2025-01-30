package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.j;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.d0;
import com.google.android.gms.common.util.l;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class e extends f {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f6175c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final e f6176d = new e();

    /* renamed from: e  reason: collision with root package name */
    public static final int f6177e = f.a;

    /* renamed from: f  reason: collision with root package name */
    private String f6178f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class a extends e.g.a.e.d.d.d {
        private final Context a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int g2 = e.this.g(this.a);
            if (e.this.j(g2)) {
                e.this.q(this.a, g2);
            }
        }
    }

    public static e o() {
        return f6176d;
    }

    public static Dialog r(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.e.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        u(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    static Dialog s(Context context, int i2, com.google.android.gms.common.internal.f fVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.e.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c2 = com.google.android.gms.common.internal.e.c(context, i2);
        if (c2 != null) {
            builder.setPositiveButton(c2, fVar);
        }
        String g2 = com.google.android.gms.common.internal.e.g(context, i2);
        if (g2 != null) {
            builder.setTitle(g2);
        }
        return builder.create();
    }

    static void u(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof androidx.fragment.app.d) {
            k.d(dialog, onCancelListener).show(((androidx.fragment.app.d) activity).getSupportFragmentManager(), str);
            return;
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void w(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            v(context);
        } else if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String f2 = com.google.android.gms.common.internal.e.f(context, i2);
            String e2 = com.google.android.gms.common.internal.e.e(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            j.e D = new j.e(context).u(true).g(true).m(f2).D(new j.c().h(e2));
            if (com.google.android.gms.common.util.i.b(context)) {
                com.google.android.gms.common.internal.t.n(l.g());
                D.B(context.getApplicationInfo().icon).y(2);
                if (com.google.android.gms.common.util.i.c(context)) {
                    D.a(e.g.a.e.b.a.a, resources.getString(e.g.a.e.b.b.o), pendingIntent);
                } else {
                    D.k(pendingIntent);
                }
            } else {
                D.B(17301642).F(resources.getString(e.g.a.e.b.b.f13091h)).K(System.currentTimeMillis()).k(pendingIntent).l(e2);
            }
            if (l.j()) {
                com.google.android.gms.common.internal.t.n(l.j());
                String z = z();
                if (z == null) {
                    z = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String b2 = com.google.android.gms.common.internal.e.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", b2, 4));
                    } else if (!b2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                D.i(z);
            }
            Notification c2 = D.c();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                h.f6184d.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, c2);
        }
    }

    private final String z() {
        String str;
        synchronized (f6175c) {
            str = this.f6178f;
        }
        return str;
    }

    @Override // com.google.android.gms.common.f
    public Intent b(Context context, int i2, String str) {
        return super.b(context, i2, str);
    }

    @Override // com.google.android.gms.common.f
    public PendingIntent c(Context context, int i2, int i3) {
        return super.c(context, i2, i3);
    }

    @Override // com.google.android.gms.common.f
    public final String e(int i2) {
        return super.e(i2);
    }

    @Override // com.google.android.gms.common.f
    public int g(Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.f
    public int h(Context context, int i2) {
        return super.h(context, i2);
    }

    @Override // com.google.android.gms.common.f
    public final boolean j(int i2) {
        return super.j(i2);
    }

    public Dialog m(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return s(activity, i2, com.google.android.gms.common.internal.f.a(activity, b(activity, i2, "d"), i3), onCancelListener);
    }

    public PendingIntent n(Context context, b bVar) {
        if (bVar.l1()) {
            return bVar.k1();
        }
        return c(context, bVar.i1(), 0);
    }

    public boolean p(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog m = m(activity, i2, i3, onCancelListener);
        if (m == null) {
            return false;
        }
        u(activity, m, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void q(Context context, int i2) {
        w(context, i2, null, d(context, i2, 0, "n"));
    }

    public final d0 t(Context context, com.google.android.gms.common.api.internal.c0 c0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        d0 d0Var = new d0(c0Var);
        context.registerReceiver(d0Var, intentFilter);
        d0Var.b(context);
        if (i(context, "com.google.android.gms")) {
            return d0Var;
        }
        c0Var.a();
        d0Var.a();
        return null;
    }

    final void v(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean x(Activity activity, com.google.android.gms.common.api.internal.i iVar, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog s = s(activity, i2, com.google.android.gms.common.internal.f.b(iVar, b(activity, i2, "d"), 2), onCancelListener);
        if (s == null) {
            return false;
        }
        u(activity, s, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean y(Context context, b bVar, int i2) {
        PendingIntent n = n(context, bVar);
        if (n != null) {
            w(context, bVar.i1(), null, GoogleApiActivity.a(context, n, i2));
            return true;
        }
        return false;
    }
}