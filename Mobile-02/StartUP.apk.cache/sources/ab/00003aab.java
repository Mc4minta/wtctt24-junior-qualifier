package com.google.firebase.crashlytics.c.q;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class a implements d {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f9072b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9073c;

    public a(int i2, d... dVarArr) {
        this.a = i2;
        this.f9072b = dVarArr;
        this.f9073c = new b(i2);
    }

    @Override // com.google.firebase.crashlytics.c.q.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        d[] dVarArr;
        if (stackTraceElementArr.length <= this.a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.f9072b) {
            if (stackTraceElementArr2.length <= this.a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.a ? this.f9073c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}