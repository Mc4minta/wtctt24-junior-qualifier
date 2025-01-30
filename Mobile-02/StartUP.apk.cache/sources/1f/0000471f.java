package e.f.m.w;

import com.facebook.react.bridge.WritableMap;

/* compiled from: HeadlessJsTaskConfig.java */
/* loaded from: classes2.dex */
public class a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final WritableMap f12895b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12896c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12897d;

    /* renamed from: e  reason: collision with root package name */
    private final d f12898e;

    public a(String str, WritableMap writableMap, long j2, boolean z, d dVar) {
        this.a = str;
        this.f12895b = writableMap;
        this.f12896c = j2;
        this.f12897d = z;
        this.f12898e = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WritableMap a() {
        return this.f12895b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d b() {
        return this.f12898e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f12896c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f12897d;
    }

    public a(a aVar) {
        this.a = aVar.a;
        this.f12895b = aVar.f12895b.copy();
        this.f12896c = aVar.f12896c;
        this.f12897d = aVar.f12897d;
        d dVar = aVar.f12898e;
        if (dVar != null) {
            this.f12898e = dVar.copy();
        } else {
            this.f12898e = null;
        }
    }
}