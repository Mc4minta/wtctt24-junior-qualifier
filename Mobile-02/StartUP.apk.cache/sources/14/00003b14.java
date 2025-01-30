package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.firebase.iid.u0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class w {
    private static int a;

    /* renamed from: b  reason: collision with root package name */
    private static PendingIntent f9188b;

    /* renamed from: d  reason: collision with root package name */
    private final Context f9190d;

    /* renamed from: e  reason: collision with root package name */
    private final q f9191e;

    /* renamed from: g  reason: collision with root package name */
    private Messenger f9193g;

    /* renamed from: h  reason: collision with root package name */
    private u0 f9194h;

    /* renamed from: c  reason: collision with root package name */
    private final c.e.g<String, com.google.android.gms.tasks.h<Bundle>> f9189c = new c.e.g<>();

    /* renamed from: f  reason: collision with root package name */
    private Messenger f9192f = new Messenger(new z(this, Looper.getMainLooper()));

    public w(Context context, q qVar) {
        this.f9190d = context;
        this.f9191e = qVar;
    }

    private static synchronized String b() {
        String num;
        synchronized (w.class) {
            int i2 = a;
            a = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    private static synchronized void c(Context context, Intent intent) {
        synchronized (w.class) {
            if (f9188b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f9188b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f9188b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new u0.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof u0) {
                        this.f9194h = (u0) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f9193g = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(valueOf2.length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        Log.w("FirebaseInstanceId", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                    }
                    if (stringExtra2.startsWith("|")) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length > 2 && "ID".equals(split[1])) {
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            f(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        Log.w("FirebaseInstanceId", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                        return;
                    }
                    synchronized (this.f9189c) {
                        for (int i2 = 0; i2 < this.f9189c.size(); i2++) {
                            f(this.f9189c.keyAt(i2), intent2.getExtras());
                        }
                    }
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                        return;
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                f(group, extras);
                return;
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    private final void f(String str, Bundle bundle) {
        synchronized (this.f9189c) {
            com.google.android.gms.tasks.h<Bundle> remove = this.f9189c.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.c(bundle);
        }
    }

    private final Bundle g(Bundle bundle) throws IOException {
        Bundle h2 = h(bundle);
        if (h2 == null || !h2.containsKey("google.messenger")) {
            return h2;
        }
        Bundle h3 = h(bundle);
        if (h3 == null || !h3.containsKey("google.messenger")) {
            return h3;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x009f, code lost:
        if (r8.f9194h != null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.tasks.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.concurrent.TimeUnit] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cc -> B:61:0x00d7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d2 -> B:61:0x00d7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Bundle h(android.os.Bundle r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.w.h(android.os.Bundle):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle a(Bundle bundle) throws IOException {
        if (this.f9191e.g() >= 12000000) {
            try {
                return (Bundle) com.google.android.gms.tasks.j.a(e.e(this.f9190d).f(1, bundle));
            } catch (InterruptedException | ExecutionException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ((e2.getCause() instanceof zzam) && ((zzam) e2.getCause()).a() == 4) {
                    return g(bundle);
                }
                return null;
            }
        }
        return g(bundle);
    }
}