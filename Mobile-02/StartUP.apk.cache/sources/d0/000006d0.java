package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AFEvent {

    /* renamed from: ı  reason: contains not printable characters */
    WeakReference<Context> f7;

    /* renamed from: Ɩ  reason: contains not printable characters */
    public String f8;

    /* renamed from: ǃ  reason: contains not printable characters */
    public Intent f9;

    /* renamed from: ȷ  reason: contains not printable characters */
    boolean f10;

    /* renamed from: ɨ  reason: contains not printable characters */
    public int f11;

    /* renamed from: ɩ  reason: contains not printable characters */
    AppsFlyerTrackingRequestListener f12;

    /* renamed from: ɪ  reason: contains not printable characters */
    private Map<String, Object> f13;

    /* renamed from: ɹ  reason: contains not printable characters */
    String f14;

    /* renamed from: ɾ  reason: contains not printable characters */
    private final boolean f15;

    /* renamed from: ɿ  reason: contains not printable characters */
    private byte[] f16;

    /* renamed from: Ι  reason: contains not printable characters */
    Map<String, Object> f17;

    /* renamed from: ι  reason: contains not printable characters */
    Context f18;

    /* renamed from: І  reason: contains not printable characters */
    String f19;

    /* renamed from: і  reason: contains not printable characters */
    String f20;

    /* renamed from: Ӏ  reason: contains not printable characters */
    String f21;

    /* renamed from: ӏ  reason: contains not printable characters */
    private String f22;

    public AFEvent() {
        this(null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String addChannel(String str) {
        String configuredChannel = AppsFlyerLibCore.getInstance().getConfiguredChannel(context());
        return configuredChannel != null ? Uri.parse(str).buildUpon().appendQueryParameter(AppsFlyerProperties.CHANNEL, configuredChannel).build().toString() : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AFEvent context(Context context) {
        this.f18 = context;
        return this;
    }

    public Intent intent() {
        return this.f9;
    }

    public boolean isEncrypt() {
        return this.f15;
    }

    public AFEvent key(String str) {
        this.f22 = str;
        return this;
    }

    public AFEvent params(Map<String, ?> map) {
        this.f13 = map;
        return this;
    }

    public AFEvent post(byte[] bArr) {
        this.f16 = bArr;
        return this;
    }

    public AFEvent urlString(String str) {
        this.f20 = str;
        return this;
    }

    public AFEvent weakContext() {
        this.f7 = new WeakReference<>(this.f18);
        this.f18 = null;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ǃ  reason: contains not printable characters */
    public final AFEvent m4() {
        if (context() != null) {
            this.f18 = context().getApplicationContext();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Ι  reason: contains not printable characters */
    public final boolean m5() {
        return this.f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ι  reason: contains not printable characters */
    public final byte[] m6() {
        return this.f16;
    }

    public AFEvent(String str, Boolean bool, Context context) {
        this.f21 = str;
        this.f15 = bool != null ? bool.booleanValue() : true;
        this.f18 = context;
    }

    public Context context() {
        Context context = this.f18;
        if (context != null) {
            return context;
        }
        WeakReference<Context> weakReference = this.f7;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String key() {
        return this.f22;
    }

    public Map<String, Object> params() {
        return this.f13;
    }

    public String urlString() {
        return this.f20;
    }
}