package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.h;
import com.google.android.datatransport.runtime.backends.m;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
@Keep
/* loaded from: classes2.dex */
public class CctBackendFactory implements com.google.android.datatransport.runtime.backends.d {
    @Override // com.google.android.datatransport.runtime.backends.d
    public m create(h hVar) {
        return new e(hVar.b(), hVar.e(), hVar.d());
    }
}