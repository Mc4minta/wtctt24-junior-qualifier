package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class a implements DynamiteModule.a.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
    public final int a(Context context, String str) {
        return DynamiteModule.a(context, str);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
    public final int b(Context context, String str, boolean z) throws DynamiteModule.LoadingException {
        return DynamiteModule.f(context, str, z);
    }
}