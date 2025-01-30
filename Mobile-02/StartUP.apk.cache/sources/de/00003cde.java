package com.google.zxing;

import java.util.List;

/* compiled from: DecodeHintType.java */
/* loaded from: classes2.dex */
public enum d {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(n.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    private final Class<?> n;

    d(Class cls) {
        this.n = cls;
    }

    public Class<?> h() {
        return this.n;
    }
}