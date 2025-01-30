package com.facebook.yoga;

@e.f.l.a.a
/* loaded from: classes2.dex */
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);
    

    /* renamed from: h  reason: collision with root package name */
    private final int f5658h;

    YogaLogLevel(int i2) {
        this.f5658h = i2;
    }

    @e.f.l.a.a
    public static YogaLogLevel fromInt(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                return FATAL;
                            }
                            throw new IllegalArgumentException("Unknown enum value: " + i2);
                        }
                        return VERBOSE;
                    }
                    return DEBUG;
                }
                return INFO;
            }
            return WARN;
        }
        return ERROR;
    }
}