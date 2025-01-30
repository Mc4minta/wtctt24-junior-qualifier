package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.C0146a a(Context context, String str, DynamiteModule.a.b bVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.C0146a c0146a = new DynamiteModule.a.C0146a();
        c0146a.a = bVar.a(context, str);
        int b2 = bVar.b(context, str, true);
        c0146a.f6360b = b2;
        int i2 = c0146a.a;
        if (i2 == 0 && b2 == 0) {
            c0146a.f6361c = 0;
        } else if (i2 >= b2) {
            c0146a.f6361c = -1;
        } else {
            c0146a.f6361c = 1;
        }
        return c0146a;
    }
}