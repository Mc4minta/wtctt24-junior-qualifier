package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class b implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.C0146a a(Context context, String str, DynamiteModule.a.b bVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.C0146a c0146a = new DynamiteModule.a.C0146a();
        int a = bVar.a(context, str);
        c0146a.a = a;
        if (a != 0) {
            c0146a.f6361c = -1;
        } else {
            int b2 = bVar.b(context, str, true);
            c0146a.f6360b = b2;
            if (b2 != 0) {
                c0146a.f6361c = 1;
            }
        }
        return c0146a;
    }
}