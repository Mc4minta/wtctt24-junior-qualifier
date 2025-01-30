package e.g.a.e.d.g;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public class a implements IInterface {
    private final IBinder a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13157b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f13157b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}