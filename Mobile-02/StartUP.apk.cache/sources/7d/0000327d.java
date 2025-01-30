package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes2.dex */
public final class d3<FieldDescriptorType> extends c3<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d3(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.clearcut.c3
    public final void r() {
        if (!a()) {
            for (int i2 = 0; i2 < m(); i2++) {
                Map.Entry<FieldDescriptorType, Object> g2 = g(i2);
                if (((y0) g2.getKey()).r()) {
                    g2.setValue(Collections.unmodifiableList((List) g2.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                if (((y0) entry.getKey()).r()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.r();
    }
}