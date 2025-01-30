package io.branch.referral;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import io.branch.referral.b;
import io.branch.referral.r;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestQueue.java */
/* loaded from: classes2.dex */
public class z {
    private static z a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f17129b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f17130c;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences.Editor f17131d;

    /* renamed from: e  reason: collision with root package name */
    private final List<r> f17132e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerRequestQueue.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject C;
            JSONArray jSONArray = new JSONArray();
            synchronized (z.f17129b) {
                for (r rVar : z.this.f17132e) {
                    if (rVar.r() && (C = rVar.C()) != null) {
                        jSONArray.put(C);
                    }
                }
            }
            try {
                z.this.f17131d.putString("BNCServerRequestQueue", jSONArray.toString()).commit();
            } catch (Exception e2) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to persit queue");
                if (message == null) {
                    message = "";
                }
                sb.append(message);
                q.a(sb.toString());
            }
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private z(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.f17130c = sharedPreferences;
        this.f17131d = sharedPreferences.edit();
        this.f17132e = q(context);
    }

    public static z i(Context context) {
        if (a == null) {
            synchronized (z.class) {
                if (a == null) {
                    a = new z(context);
                }
            }
        }
        return a;
    }

    private void o() {
        new Thread(new a()).start();
    }

    private List<r> q(Context context) {
        String string = this.f17130c.getString("BNCServerRequestQueue", null);
        List<r> synchronizedList = Collections.synchronizedList(new LinkedList());
        synchronized (f17129b) {
            if (string != null) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    int min = Math.min(jSONArray.length(), 25);
                    for (int i2 = 0; i2 < min; i2++) {
                        r f2 = r.f(jSONArray.getJSONObject(i2), context);
                        if (f2 != null) {
                            synchronizedList.add(f2);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return synchronizedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        synchronized (f17129b) {
            try {
                this.f17132e.clear();
                o();
            } catch (UnsupportedOperationException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        synchronized (f17129b) {
            for (r rVar : this.f17132e) {
                if (rVar != null && rVar.m().equals(n.RegisterClose.h())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        synchronized (f17129b) {
            for (r rVar : this.f17132e) {
                if (rVar != null && ((rVar instanceof c0) || (rVar instanceof d0))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r g() {
        r rVar;
        synchronized (f17129b) {
            r rVar2 = null;
            try {
                rVar = this.f17132e.remove(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
            }
            try {
                o();
            } catch (IndexOutOfBoundsException | NoSuchElementException unused2) {
                rVar2 = rVar;
                rVar = rVar2;
                return rVar;
            }
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(r rVar) {
        synchronized (f17129b) {
            if (rVar != null) {
                this.f17132e.add(rVar);
                if (j() >= 25) {
                    this.f17132e.remove(1);
                }
                o();
            }
        }
    }

    public int j() {
        int size;
        synchronized (f17129b) {
            size = this.f17132e.size();
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(r rVar, int i2) {
        synchronized (f17129b) {
            try {
                if (this.f17132e.size() < i2) {
                    i2 = this.f17132e.size();
                }
                this.f17132e.add(i2, rVar);
                o();
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(r rVar, int i2, b.g gVar) {
        synchronized (f17129b) {
            Iterator<r> it = this.f17132e.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next != null && ((next instanceof c0) || (next instanceof d0))) {
                    it.remove();
                    break;
                }
            }
        }
        k(rVar, i2 == 0 ? 0 : 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r m() {
        r rVar;
        synchronized (f17129b) {
            try {
                rVar = this.f17132e.get(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                rVar = null;
            }
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r n(int i2) {
        r rVar;
        synchronized (f17129b) {
            try {
                rVar = this.f17132e.get(i2);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                rVar = null;
            }
        }
        return rVar;
    }

    public boolean p(r rVar) {
        boolean z;
        synchronized (f17129b) {
            z = false;
            try {
                z = this.f17132e.remove(rVar);
                o();
            } catch (UnsupportedOperationException unused) {
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(b.g gVar) {
        synchronized (f17129b) {
            for (r rVar : this.f17132e) {
                if (rVar != null) {
                    if (rVar instanceof c0) {
                        ((c0) rVar).P(gVar);
                    } else if (rVar instanceof d0) {
                        ((d0) rVar).P(gVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        synchronized (f17129b) {
            for (r rVar : this.f17132e) {
                if (rVar != null && (rVar instanceof x)) {
                    rVar.a(r.b.STRONG_MATCH_PENDING_WAIT_LOCK);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(r.b bVar) {
        synchronized (f17129b) {
            for (r rVar : this.f17132e) {
                if (rVar != null) {
                    rVar.x(bVar);
                }
            }
        }
    }
}