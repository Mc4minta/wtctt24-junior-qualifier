package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Key.java */
/* loaded from: classes.dex */
public abstract class c {
    public static int a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f1082b;

    /* renamed from: c  reason: collision with root package name */
    int f1083c;

    /* renamed from: d  reason: collision with root package name */
    String f1084d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1085e;

    /* renamed from: f  reason: collision with root package name */
    HashMap<String, androidx.constraintlayout.widget.a> f1086f;

    public c() {
        int i2 = a;
        this.f1082b = i2;
        this.f1083c = i2;
        this.f1084d = null;
    }

    public abstract void a(HashMap<String, s> hashMap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(HashSet<String> hashSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(String str) {
        String str2 = this.f1084d;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void e(HashMap<String, Integer> hashMap) {
    }
}