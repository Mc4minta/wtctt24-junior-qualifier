package com.bugsnag.android;

import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CachedThread.java */
/* loaded from: classes.dex */
public class o implements o0.a {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3669b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3670c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3671d;

    /* renamed from: e  reason: collision with root package name */
    private final StackTraceElement[] f3672e;

    /* renamed from: f  reason: collision with root package name */
    private final s f3673f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(s sVar, long j2, String str, String str2, boolean z, StackTraceElement[] stackTraceElementArr) {
        this.a = j2;
        this.f3673f = sVar;
        this.f3669b = str;
        this.f3670c = str2;
        this.f3671d = z;
        this.f3672e = stackTraceElementArr;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d();
        o0Var.j("id").O(this.a);
        o0Var.j(ApiConstants.NAME).d0(this.f3669b);
        o0Var.j("type").d0(this.f3670c);
        o0Var.j("stacktrace").n0(new a1(this.f3672e, this.f3673f.x()));
        if (this.f3671d) {
            o0Var.j("errorReportingThread").e0(true);
        }
        o0Var.g();
    }
}