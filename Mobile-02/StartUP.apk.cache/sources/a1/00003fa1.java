package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: WireField.kt */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface p {

    /* compiled from: WireField.kt */
    /* loaded from: classes2.dex */
    public enum a {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        public final boolean h() {
            return this == ONE_OF;
        }

        public final boolean isPacked() {
            return this == PACKED;
        }

        public final boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }
    }

    String adapter();

    String declaredName() default "";

    String jsonName() default "";

    String keyAdapter() default "";

    a label() default a.OPTIONAL;

    boolean redacted() default false;

    int tag();
}