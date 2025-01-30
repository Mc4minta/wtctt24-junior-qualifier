package com.squareup.wire;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FieldEncoding.kt */
/* loaded from: classes2.dex */
public enum c {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    

    /* renamed from: f  reason: collision with root package name */
    public static final a f10858f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final int f10859g;

    /* compiled from: FieldEncoding.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    c(int i2) {
        this.f10859g = i2;
    }

    public final int h() {
        return this.f10859g;
    }

    public final ProtoAdapter<?> n() {
        int i2 = d.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return ProtoAdapter.BYTES;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return ProtoAdapter.FIXED64;
            }
            return ProtoAdapter.FIXED32;
        }
        return ProtoAdapter.UINT64;
    }
}