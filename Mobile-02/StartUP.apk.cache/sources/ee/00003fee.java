package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: ConcatNode.java */
/* loaded from: classes2.dex */
public class g extends m {
    private static final NumberFormat a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f10974b;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        a = numberFormat;
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setGroupingUsed(false);
    }

    public g(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.f10974b = com.swmansion.reanimated.e.a(readableMap.getArray("input"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    /* renamed from: c */
    public String evaluate() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int[] iArr = this.f10974b;
            if (i2 < iArr.length) {
                Object value = this.mNodesManager.o(iArr[i2], m.class).value();
                if (value instanceof Double) {
                    value = a.format((Double) value);
                }
                sb.append(value);
                i2++;
            } else {
                return sb.toString();
            }
        }
    }
}