package h.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.TextView;
import h.b.a.c;
import io.branch.referral.q;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ContentDiscoverer.java */
/* loaded from: classes2.dex */
public class b {
    private static b a;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Activity> f14041c;

    /* renamed from: d  reason: collision with root package name */
    private String f14042d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f14043e;

    /* renamed from: f  reason: collision with root package name */
    private int f14044f;

    /* renamed from: i  reason: collision with root package name */
    private h.b.a.c f14047i;

    /* renamed from: g  reason: collision with root package name */
    private int f14045g = 15;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<String> f14049k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private Runnable f14050l = new a();
    private ViewTreeObserver.OnScrollChangedListener m = new ViewTreeObserver$OnScrollChangedListenerC0338b();
    private Runnable n = new c();

    /* renamed from: b  reason: collision with root package name */
    private Handler f14040b = new Handler();

    /* renamed from: h  reason: collision with root package name */
    private final d f14046h = new d();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, WeakReference<ViewTreeObserver>> f14048j = new HashMap();

    /* compiled from: ContentDiscoverer.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.b(b.this);
                if (!b.this.f14047i.g() || b.this.f14041c == null || b.this.f14041c.get() == null) {
                    return;
                }
                Activity activity = (Activity) b.this.f14041c.get();
                b.this.f14043e = new JSONObject();
                b.this.f14043e.put("ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(b.this.f14042d)) {
                    b.this.f14043e.put("rl", b.this.f14042d);
                }
                String str = "/" + activity.getClass().getSimpleName();
                b.this.f14043e.put("v", str);
                ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                if (viewGroup != null) {
                    c.a a = b.this.f14047i.a(activity);
                    boolean z = true;
                    boolean z2 = a != null && a.d();
                    JSONArray jSONArray = null;
                    if (a != null) {
                        z2 = a.d();
                        JSONObject jSONObject = b.this.f14043e;
                        if (z2) {
                            z = false;
                        }
                        jSONObject.put("h", z);
                        jSONArray = a.b();
                    }
                    JSONArray jSONArray2 = jSONArray;
                    boolean z3 = z2;
                    if (jSONArray2 == null || jSONArray2.length() <= 0) {
                        if (!b.this.f14049k.contains(str)) {
                            JSONArray jSONArray3 = new JSONArray();
                            b.this.f14043e.put("ck", jSONArray3);
                            b.this.s(viewGroup, jSONArray3, activity.getResources());
                        }
                    } else {
                        JSONArray jSONArray4 = new JSONArray();
                        b.this.f14043e.put("ck", jSONArray4);
                        JSONArray jSONArray5 = new JSONArray();
                        b.this.f14043e.put("cd", jSONArray5);
                        b.this.r(jSONArray2, jSONArray5, jSONArray4, activity, z3);
                    }
                    b.this.f14049k.add(str);
                    q.B(activity).V(b.this.f14043e);
                    int a2 = b.this.f14047i.a(activity).a();
                    b bVar = b.this;
                    bVar.f14045g = bVar.f14047i.a(activity).c();
                    if (b.this.f14044f >= b.this.f14045g || a2 < 500 || jSONArray2 == null || jSONArray2.length() <= 0) {
                        return;
                    }
                    b.this.f14040b.postDelayed(b.this.f14050l, a2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: ContentDiscoverer.java */
    /* renamed from: h.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class ViewTreeObserver$OnScrollChangedListenerC0338b implements ViewTreeObserver.OnScrollChangedListener {
        ViewTreeObserver$OnScrollChangedListenerC0338b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            b.this.f14040b.removeCallbacks(b.this.n);
            if (b.this.f14045g > b.this.f14044f) {
                b.this.f14040b.postDelayed(b.this.n, 1500L);
            }
        }
    }

    /* compiled from: ContentDiscoverer.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f14050l.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ContentDiscoverer.java */
    /* loaded from: classes2.dex */
    public class d {
        MessageDigest a;

        d() {
            try {
                this.a = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
        }

        String a(String str) {
            MessageDigest messageDigest = this.a;
            if (messageDigest != null) {
                messageDigest.reset();
                this.a.update(str.getBytes());
                return new String(this.a.digest());
            }
            return "";
        }
    }

    private b() {
    }

    private void B(String str, View view, boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (view instanceof TextView) {
            jSONArray.put(x(view, z));
            jSONArray2.put(str);
        }
    }

    private void C() {
        try {
            JSONObject jSONObject = this.f14043e;
            if (jSONObject != null) {
                jSONObject.put("tc", System.currentTimeMillis());
            }
        } catch (JSONException unused) {
        }
    }

    static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f14044f;
        bVar.f14044f = i2 + 1;
        return i2;
    }

    private void p(Activity activity) {
        this.f14044f = 0;
        if (this.f14049k.size() < this.f14047i.f()) {
            this.f14040b.removeCallbacks(this.f14050l);
            this.f14041c = new WeakReference<>(activity);
            this.f14040b.postDelayed(this.f14050l, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, Activity activity, boolean z) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                String string = jSONArray.getString(i2);
                if (string.startsWith("$")) {
                    t(string, activity, z, jSONArray2, jSONArray3);
                } else {
                    B(string, activity.findViewById(activity.getResources().getIdentifier(jSONArray.getString(i2), "id", activity.getPackageName())), z, jSONArray2, jSONArray3);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ViewGroup viewGroup, JSONArray jSONArray, Resources resources) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                if (!(childAt instanceof AbsListView) && !childAt.getClass().getSimpleName().equals("RecyclerView")) {
                    if (childAt instanceof ViewGroup) {
                        s((ViewGroup) childAt, jSONArray, resources);
                    } else if (childAt instanceof TextView) {
                        jSONArray.put(y(childAt, resources));
                    }
                } else {
                    u((ViewGroup) childAt, resources, jSONArray);
                }
            }
        }
    }

    private void t(String str, Activity activity, boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        int i2;
        JSONObject jSONObject = new JSONObject();
        jSONArray2.put(str);
        jSONArray.put(jSONObject);
        String replace = str.replace("$", "");
        try {
            JSONObject jSONObject2 = new JSONObject(replace);
            if (jSONObject2.length() > 0) {
                String next = jSONObject2.keys().next();
                int identifier = activity.getResources().getIdentifier(next, "id", activity.getPackageName());
                View findViewById = activity.getCurrentFocus() != null ? activity.getCurrentFocus().findViewById(identifier) : null;
                if (findViewById == null) {
                    findViewById = activity.findViewById(identifier);
                }
                if (findViewById == null || !(findViewById instanceof ViewGroup)) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById;
                JSONArray jSONArray3 = jSONObject2.getJSONArray(next);
                int length = jSONArray3.length();
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    iArr[i3] = activity.getResources().getIdentifier(jSONArray3.getString(i3), "id", activity.getPackageName());
                }
                int firstVisiblePosition = viewGroup instanceof AbsListView ? ((AbsListView) viewGroup).getFirstVisiblePosition() : 0;
                int i4 = 0;
                while (i4 < viewGroup.getChildCount()) {
                    if (viewGroup.getChildAt(i4) != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject.put("" + (i4 + firstVisiblePosition), jSONObject3);
                        int i5 = 0;
                        while (i5 < length) {
                            if (viewGroup.getChildAt(i4) != null) {
                                View findViewById2 = viewGroup.getChildAt(i4).findViewById(iArr[i5]);
                                if (findViewById2 instanceof TextView) {
                                    i2 = firstVisiblePosition;
                                    jSONObject3.put(jSONArray3.getString(i5), x(findViewById2, z));
                                    i5++;
                                    firstVisiblePosition = i2;
                                }
                            }
                            i2 = firstVisiblePosition;
                            i5++;
                            firstVisiblePosition = i2;
                        }
                    }
                    i4++;
                    firstVisiblePosition = firstVisiblePosition;
                }
                if (!(jSONObject2.has("bnc_esw") && jSONObject2.getBoolean("bnc_esw")) || this.f14048j.containsKey(replace)) {
                    return;
                }
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.m);
                this.f14048j.put(replace, new WeakReference<>(viewGroup.getViewTreeObserver()));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void u(ViewGroup viewGroup, Resources resources, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (viewGroup == null || viewGroup.getChildCount() <= -1) {
            return;
        }
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() <= 1 ? 0 : 1);
        if (childAt != null) {
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONObject.put(y(viewGroup, resources), jSONArray2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (childAt instanceof ViewGroup) {
                s((ViewGroup) childAt, jSONArray2, resources);
            } else if (childAt instanceof TextView) {
                jSONArray2.put(y(childAt, resources));
            }
            if (jSONObject.length() > 0) {
                jSONArray.put("$" + jSONObject);
            }
        }
    }

    public static b w() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private String x(View view, boolean z) {
        TextView textView = (TextView) view;
        if (textView.getText() != null) {
            String substring = textView.getText().toString().substring(0, Math.min(textView.getText().toString().length(), this.f14047i.e()));
            return z ? substring : this.f14046h.a(substring);
        }
        return null;
    }

    private String y(View view, Resources resources) {
        String valueOf = String.valueOf(view.getId());
        try {
            return resources.getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public void A(Activity activity, String str) {
        this.f14049k = new ArrayList<>();
        q(activity, str);
    }

    public void q(Activity activity, String str) {
        h.b.a.c b2 = h.b.a.c.b(activity);
        this.f14047i = b2;
        this.f14042d = str;
        c.a a2 = b2.a(activity);
        if (a2 != null) {
            if (a2.e()) {
                return;
            }
            p(activity);
        } else if (TextUtils.isEmpty(this.f14042d)) {
        } else {
            p(activity);
        }
    }

    public JSONObject v(Context context) {
        JSONObject jSONObject;
        JSONObject n = q.B(context).n();
        if (n.length() <= 0 || n.toString().length() >= this.f14047i.d()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("mv", h.b.a.c.b(context).c()).put("e", n);
                if (context != null) {
                    jSONObject.put("p", context.getPackageName());
                    jSONObject.put("p", context.getPackageName());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        q.B(context).d();
        return jSONObject;
    }

    public void z(Activity activity) {
        WeakReference<Activity> weakReference = this.f14041c;
        if (weakReference != null && weakReference.get() != null && this.f14041c.get().getClass().getName().equals(activity.getClass().getName())) {
            this.f14040b.removeCallbacks(this.f14050l);
            this.f14041c = null;
        }
        C();
        for (WeakReference<ViewTreeObserver> weakReference2 : this.f14048j.values()) {
            ViewTreeObserver viewTreeObserver = weakReference2.get();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.m);
            }
        }
        this.f14048j.clear();
    }
}