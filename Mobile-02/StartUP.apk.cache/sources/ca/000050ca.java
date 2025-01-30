package io.branch.referral;

import android.content.Context;
import io.branch.referral.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BranchUrlBuilder.java */
/* loaded from: classes2.dex */
public abstract class h<T extends h> {
    protected JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    protected String f16969b;

    /* renamed from: c  reason: collision with root package name */
    protected String f16970c;

    /* renamed from: d  reason: collision with root package name */
    protected String f16971d;

    /* renamed from: e  reason: collision with root package name */
    protected String f16972e;

    /* renamed from: f  reason: collision with root package name */
    protected String f16973f;

    /* renamed from: i  reason: collision with root package name */
    protected ArrayList<String> f16976i;

    /* renamed from: l  reason: collision with root package name */
    private final Context f16979l;

    /* renamed from: g  reason: collision with root package name */
    protected int f16974g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f16975h = 0;

    /* renamed from: j  reason: collision with root package name */
    protected b f16977j = b.V();

    /* renamed from: k  reason: collision with root package name */
    private boolean f16978k = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context) {
        this.f16979l = context.getApplicationContext();
    }

    public T a(String str, Object obj) {
        try {
            if (this.a == null) {
                this.a = new JSONObject();
            }
            this.a.put(str, obj);
        } catch (JSONException unused) {
        }
        return this;
    }

    public T b(List<String> list) {
        if (this.f16976i == null) {
            this.f16976i = new ArrayList<>();
        }
        this.f16976i.addAll(list);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        if (this.f16977j != null) {
            return this.f16977j.P(new t(this.f16979l, this.f16973f, this.f16974g, this.f16975h, this.f16976i, this.f16969b, this.f16970c, this.f16971d, this.f16972e, i.c(this.a), null, false, this.f16978k));
        }
        return null;
    }
}