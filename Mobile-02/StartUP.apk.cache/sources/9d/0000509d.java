package io.branch.referral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class InstallListener extends BroadcastReceiver {
    private static String a = "bnc_no_value";

    /* renamed from: b  reason: collision with root package name */
    private static b f16890b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16891c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f16892d;

    /* renamed from: e  reason: collision with root package name */
    static boolean f16893e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InstallListener.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private Object a;

        /* renamed from: b  reason: collision with root package name */
        private Context f16894b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements e.c.a.a.c {
            a() {
            }

            @Override // e.c.a.a.c
            public void onInstallReferrerServiceDisconnected() {
                InstallListener.f();
            }

            @Override // e.c.a.a.c
            public void onInstallReferrerSetupFinished(int i2) {
                long j2;
                String str;
                long j3;
                if (i2 != 0) {
                    if (i2 == 1) {
                        InstallListener.f();
                        return;
                    } else if (i2 == 2) {
                        InstallListener.f();
                        return;
                    } else if (i2 != 3) {
                        return;
                    } else {
                        InstallListener.f();
                        return;
                    }
                }
                try {
                    if (c.this.a != null) {
                        e.c.a.a.d b2 = ((e.c.a.a.a) c.this.a).b();
                        if (b2 != null) {
                            String c2 = b2.c();
                            long d2 = b2.d();
                            j2 = b2.b();
                            j3 = d2;
                            str = c2;
                        } else {
                            j2 = 0;
                            str = null;
                            j3 = 0;
                        }
                        InstallListener.g(c.this.f16894b, str, j3, j2);
                    }
                } catch (RemoteException e2) {
                    q.a("onInstallReferrerSetupFinished() Exception: " + e2.getMessage());
                    InstallListener.f();
                }
            }
        }

        /* synthetic */ c(Context context, a aVar) {
            this(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            try {
                e.c.a.a.a a2 = e.c.a.a.a.d(this.f16894b).a();
                this.a = a2;
                a2.e(new a());
                return true;
            } catch (Throwable th) {
                q.a("ReferrerClientWrapper Exception: " + th.getMessage());
                return false;
            }
        }

        private c(Context context) {
            this.f16894b = context;
        }
    }

    public static void d(Context context, long j2, b bVar) {
        f16890b = bVar;
        if (f16893e) {
            i();
            return;
        }
        f16891c = true;
        f16892d = new c(context, null).d();
        new Timer().schedule(new a(), j2);
    }

    public static String e() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        f16892d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, String str, long j2, long j3) {
        h(context, str, j2, j3);
        if (f16891c) {
            i();
        }
    }

    private static void h(Context context, String str, long j2, long j3) {
        String[] split;
        q B = q.B(context);
        if (j2 > 0) {
            B.w0("bnc_referrer_click_ts", j2);
        }
        if (j3 > 0) {
            B.w0("bnc_install_begin_ts", j3);
        }
        if (str != null) {
            try {
                String decode = URLDecoder.decode(str, "UTF-8");
                HashMap hashMap = new HashMap();
                for (String str2 : decode.split("&")) {
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = "-";
                        if (str2.contains("=") || !str2.contains("-")) {
                            str3 = "=";
                        }
                        String[] split2 = str2.split(str3);
                        if (split2.length > 1) {
                            hashMap.put(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                        }
                    }
                }
                l lVar = l.LinkClickID;
                if (hashMap.containsKey(lVar.h())) {
                    String str4 = (String) hashMap.get(lVar.h());
                    a = str4;
                    B.v0(str4);
                }
                l lVar2 = l.IsFullAppConv;
                if (hashMap.containsKey(lVar2.h())) {
                    l lVar3 = l.ReferringLink;
                    if (hashMap.containsKey(lVar3.h())) {
                        B.s0(Boolean.parseBoolean((String) hashMap.get(lVar2.h())));
                        B.b0((String) hashMap.get(lVar3.h()));
                    }
                }
                l lVar4 = l.GoogleSearchInstallReferrer;
                if (hashMap.containsKey(lVar4.h())) {
                    B.l0((String) hashMap.get(lVar4.h()));
                    B.k0(decode);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                q.a("Illegal characters in url encoded string");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        f16893e = true;
        b bVar = f16890b;
        if (bVar != null) {
            bVar.a();
            f16890b = null;
            f16893e = false;
            f16891c = false;
            f16892d = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        h(context, intent.getStringExtra(Payload.REFERRER), 0L, 0L);
        if (!f16891c || f16892d) {
            return;
        }
        i();
    }
}