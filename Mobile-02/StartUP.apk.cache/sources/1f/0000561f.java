package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* compiled from: KotlinClassFinder.kt */
/* loaded from: classes3.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* compiled from: KotlinClassFinder.kt */
    /* loaded from: classes3.dex */
    public static abstract class Result {

        /* compiled from: KotlinClassFinder.kt */
        /* loaded from: classes3.dex */
        public static final class ClassFileContent extends Result {
            private final byte[] content;

            public final byte[] getContent() {
                return this.content;
            }
        }

        /* compiled from: KotlinClassFinder.kt */
        /* loaded from: classes3.dex */
        public static final class KotlinClass extends Result {
            private final byte[] byteContent;
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                m.g(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass;
                this.byteContent = bArr;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass, (i2 & 2) != 0 ? null : bArr);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass = this instanceof KotlinClass ? (KotlinClass) this : null;
            if (kotlinClass == null) {
                return null;
            }
            return kotlinClass.getKotlinJvmBinaryClass();
        }
    }

    Result findKotlinClassOrContent(JavaClass javaClass);

    Result findKotlinClassOrContent(ClassId classId);
}