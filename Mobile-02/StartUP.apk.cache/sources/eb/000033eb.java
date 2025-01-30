package com.google.android.gms.internal.p000firebaseperf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.q6  reason: invalid package */
/* loaded from: classes2.dex */
public final class q6<FieldDescriptorType> extends n6<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q6(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.n6
    public final void m() {
        if (!a()) {
            for (int i2 = 0; i2 < n(); i2++) {
                Map.Entry<FieldDescriptorType, Object> g2 = g(i2);
                if (((g4) g2.getKey()).w()) {
                    g2.setValue(Collections.unmodifiableList((List) g2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : o()) {
                if (((g4) entry.getKey()).w()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.m();
    }
}