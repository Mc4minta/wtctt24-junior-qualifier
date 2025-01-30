package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
public enum y4 implements h1 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4);
    

    /* renamed from: f  reason: collision with root package name */
    private static final i1<y4> f6659f = new i1<y4>() { // from class: com.google.android.gms.internal.clearcut.c5
        @Override // com.google.android.gms.internal.clearcut.i1
        public final /* synthetic */ y4 c(int i2) {
            return y4.h(i2);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final int f6661h;

    y4(int i2) {
        this.f6661h = i2;
    }

    public static y4 h(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return NEVER;
                    }
                    return FAST_IF_RADIO_AWAKE;
                }
                return UNMETERED_OR_DAILY;
            }
            return UNMETERED_ONLY;
        }
        return DEFAULT;
    }

    @Override // com.google.android.gms.internal.clearcut.h1
    public final int c() {
        return this.f6661h;
    }
}