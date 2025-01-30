package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.navigation.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ActivityNavigator.java */
@s.b("activity")
/* loaded from: classes.dex */
public class a extends s<C0035a> {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f1839b;

    /* compiled from: ActivityNavigator.java */
    /* renamed from: androidx.navigation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0035a extends k {

        /* renamed from: k  reason: collision with root package name */
        private Intent f1840k;

        /* renamed from: l  reason: collision with root package name */
        private String f1841l;

        public C0035a(s<? extends C0035a> sVar) {
            super(sVar);
        }

        @Override // androidx.navigation.k
        boolean D() {
            return false;
        }

        public final String E() {
            Intent intent = this.f1840k;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        public final ComponentName F() {
            Intent intent = this.f1840k;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String H() {
            return this.f1841l;
        }

        public final Intent I() {
            return this.f1840k;
        }

        public final C0035a J(String str) {
            if (this.f1840k == null) {
                this.f1840k = new Intent();
            }
            this.f1840k.setAction(str);
            return this;
        }

        public final C0035a L(ComponentName componentName) {
            if (this.f1840k == null) {
                this.f1840k = new Intent();
            }
            this.f1840k.setComponent(componentName);
            return this;
        }

        public final C0035a M(Uri uri) {
            if (this.f1840k == null) {
                this.f1840k = new Intent();
            }
            this.f1840k.setData(uri);
            return this;
        }

        public final C0035a O(String str) {
            this.f1841l = str;
            return this;
        }

        public final C0035a P(String str) {
            if (this.f1840k == null) {
                this.f1840k = new Intent();
            }
            this.f1840k.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.k
        public String toString() {
            ComponentName F = F();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (F != null) {
                sb.append(" class=");
                sb.append(F.getClassName());
            } else {
                String E = E();
                if (E != null) {
                    sb.append(" action=");
                    sb.append(E);
                }
            }
            return sb.toString();
        }

        @Override // androidx.navigation.k
        public void x(Context context, AttributeSet attributeSet) {
            super.x(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, v.a);
            String string = obtainAttributes.getString(v.f1946f);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            P(string);
            String string2 = obtainAttributes.getString(v.f1942b);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                L(new ComponentName(context, string2));
            }
            J(obtainAttributes.getString(v.f1943c));
            String string3 = obtainAttributes.getString(v.f1944d);
            if (string3 != null) {
                M(Uri.parse(string3));
            }
            O(obtainAttributes.getString(v.f1945e));
            obtainAttributes.recycle();
        }
    }

    /* compiled from: ActivityNavigator.java */
    /* loaded from: classes.dex */
    public static final class b implements s.a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.app.b f1842b;

        public androidx.core.app.b a() {
            return this.f1842b;
        }

        public int b() {
            return this.a;
        }
    }

    public a(Context context) {
        this.a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f1839b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    @Override // androidx.navigation.s
    /* renamed from: a */
    public C0035a createDestination() {
        return new C0035a(this);
    }

    @Override // androidx.navigation.s
    /* renamed from: b */
    public k navigate(C0035a c0035a, Bundle bundle, p pVar, s.a aVar) {
        Intent intent;
        int intExtra;
        if (c0035a.I() != null) {
            Intent intent2 = new Intent(c0035a.I());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String H = c0035a.H();
                if (!TextUtils.isEmpty(H)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(H);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + H);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = aVar instanceof b;
            if (z) {
                intent2.addFlags(((b) aVar).b());
            }
            if (!(this.a instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (pVar != null && pVar.g()) {
                intent2.addFlags(PKIFailureInfo.duplicateCertReq);
            }
            Activity activity = this.f1839b;
            if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", c0035a.r());
            if (pVar != null) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", pVar.c());
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", pVar.d());
            }
            if (z) {
                androidx.core.app.b a = ((b) aVar).a();
                if (a != null) {
                    androidx.core.content.a.l(this.a, intent2, a.b());
                } else {
                    this.a.startActivity(intent2);
                }
            } else {
                this.a.startActivity(intent2);
            }
            if (pVar == null || this.f1839b == null) {
                return null;
            }
            int a2 = pVar.a();
            int b2 = pVar.b();
            if (a2 == -1 && b2 == -1) {
                return null;
            }
            if (a2 == -1) {
                a2 = 0;
            }
            this.f1839b.overridePendingTransition(a2, b2 != -1 ? b2 : 0);
            return null;
        }
        throw new IllegalStateException("Destination " + c0035a.r() + " does not have an Intent set.");
    }

    @Override // androidx.navigation.s
    public boolean popBackStack() {
        Activity activity = this.f1839b;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }
}