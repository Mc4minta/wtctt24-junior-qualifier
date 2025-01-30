package io.branch.referral.k0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import io.branch.referral.l;
import io.branch.referral.q;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DeepLinkRoutingValidator.java */
/* loaded from: classes2.dex */
public class a {
    private static WeakReference<Activity> a;

    /* compiled from: DeepLinkRoutingValidator.java */
    /* renamed from: io.branch.referral.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class RunnableC0409a implements Runnable {
        final /* synthetic */ JSONObject a;

        RunnableC0409a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(a.e(this.a, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeepLinkRoutingValidator.java */
    /* loaded from: classes2.dex */
    public static class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeepLinkRoutingValidator.java */
    /* loaded from: classes2.dex */
    public static class c implements DialogInterface.OnClickListener {
        final /* synthetic */ JSONObject a;

        c(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.f(a.e(this.a, "r"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeepLinkRoutingValidator.java */
    /* loaded from: classes2.dex */
    public static class d implements DialogInterface.OnClickListener {
        final /* synthetic */ JSONObject a;

        d(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.f(a.e(this.a, "g"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeepLinkRoutingValidator.java */
    /* loaded from: classes2.dex */
    public static class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private static void c() {
        AlertDialog.Builder builder;
        if (a.get() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                builder = new AlertDialog.Builder(a.get(), 16974374);
            } else {
                builder = new AlertDialog.Builder(a.get());
            }
            builder.setTitle("Branch Deeplink Routing Support").setMessage("Bummer. It seems like +clicked_branch_link is false - we didn't deep link.  Double check that the link you're clicking has the same branch_key that is being used in your Manifest file. Return to Chrome when you're ready to test again.").setNeutralButton("Got it", new e()).setCancelable(false).setIcon(17301651).show();
        }
    }

    private static String d() {
        if (io.branch.referral.b.V() == null || io.branch.referral.b.V().W() == null) {
            return "";
        }
        JSONObject W = io.branch.referral.b.V().W();
        return W.optString("~" + l.ReferringLink.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(JSONObject jSONObject, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        try {
            str7 = jSONObject.getString("~" + l.ReferringLink.h()).split("\\?")[0];
        } catch (Exception unused) {
            q.a("Failed to get referring link");
        }
        String str8 = str7 + "?validate=true";
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str8);
                if (jSONObject.getString("ct").equals("t1")) {
                    str2 = "&t1=" + str;
                } else {
                    str2 = "&t1=" + jSONObject.getString("t1");
                }
                sb.append(str2);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                if (jSONObject.getString("ct").equals("t2")) {
                    str3 = "&t2=" + str;
                } else {
                    str3 = "&t2=" + jSONObject.getString("t2");
                }
                sb3.append(str3);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                if (jSONObject.getString("ct").equals("t3")) {
                    str4 = "&t3=" + str;
                } else {
                    str4 = "&t3=" + jSONObject.getString("t3");
                }
                sb5.append(str4);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (jSONObject.getString("ct").equals("t4")) {
                    str5 = "&t4=" + str;
                } else {
                    str5 = "&t4=" + jSONObject.getString("t4");
                }
                sb7.append(str5);
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(sb8);
                if (jSONObject.getString("ct").equals("t5")) {
                    str6 = "&t5=" + str;
                } else {
                    str6 = "&t5=" + jSONObject.getString("t5");
                }
                sb9.append(str6);
                str8 = sb9.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str8 + "&os=android";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(String str) {
        if (a.get() != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).buildUpon().appendQueryParameter("$uri_redirect_mode", "2").build());
            intent.addFlags(268435456);
            intent.setPackage("com.android.chrome");
            a.get().getPackageManager().queryIntentActivities(intent, 0);
            try {
                a.get().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage(null);
                a.get().startActivity(intent);
            }
        }
    }

    public static void g(WeakReference<Activity> weakReference) {
        a = weakReference;
        if (TextUtils.isEmpty(d()) || weakReference == null) {
            return;
        }
        JSONObject W = io.branch.referral.b.V().W();
        if (W.optInt("_branch_validate") == 60514) {
            if (W.optBoolean(l.Clicked_Branch_Link.h())) {
                h(W);
            } else {
                c();
            }
        } else if (W.optBoolean("bnc_validate")) {
            new Handler().postDelayed(new RunnableC0409a(W), 500L);
        }
    }

    private static void h(JSONObject jSONObject) {
        AlertDialog.Builder builder;
        if (a.get() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                builder = new AlertDialog.Builder(a.get(), 16974374);
            } else {
                builder = new AlertDialog.Builder(a.get());
            }
            builder.setTitle("Branch Deeplinking Routing").setMessage("Good news - we got link data. Now a question for you, astute developer: did the app deep link to the specific piece of content you expected to see?").setPositiveButton("Yes", new d(jSONObject)).setNegativeButton("No", new c(jSONObject)).setNeutralButton(17039360, new b()).setCancelable(false).setIcon(17301651).show();
        }
    }
}