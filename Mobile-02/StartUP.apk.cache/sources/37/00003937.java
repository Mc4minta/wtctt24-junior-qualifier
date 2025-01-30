package com.google.firebase.analytics.a;

import android.os.Bundle;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: com.google.firebase.analytics.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0162a {
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c(int i2, Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f8570b;

        /* renamed from: c  reason: collision with root package name */
        public Object f8571c;

        /* renamed from: d  reason: collision with root package name */
        public String f8572d;

        /* renamed from: e  reason: collision with root package name */
        public long f8573e;

        /* renamed from: f  reason: collision with root package name */
        public String f8574f;

        /* renamed from: g  reason: collision with root package name */
        public Bundle f8575g;

        /* renamed from: h  reason: collision with root package name */
        public String f8576h;

        /* renamed from: i  reason: collision with root package name */
        public Bundle f8577i;

        /* renamed from: j  reason: collision with root package name */
        public long f8578j;

        /* renamed from: k  reason: collision with root package name */
        public String f8579k;

        /* renamed from: l  reason: collision with root package name */
        public Bundle f8580l;
        public long m;
        public boolean n;
        public long o;
    }

    Map<String, Object> a(boolean z);

    void b(c cVar);

    void c(String str, String str2, Bundle bundle);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    int d(String str);

    List<c> e(String str, String str2);

    void f(String str, String str2, Object obj);

    InterfaceC0162a g(String str, b bVar);
}