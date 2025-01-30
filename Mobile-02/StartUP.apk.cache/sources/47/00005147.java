package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Metadata.kt */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\f\b\u0087\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u000b\u001a\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0013\u001a\u00020\u00108\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0019\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001c"}, d2 = {"Lkotlin/Metadata;", "", "", "pn", "()Ljava/lang/String;", "packageName", "", "xi", "()I", "extraInt", "k", "kind", "", "d2", "()[Ljava/lang/String;", "data2", "", "mv", "()[I", "metadataVersion", "bv", "bytecodeVersion", "d1", "data1", "xs", "extraString", "<init>", "(I[I[ILkotlin/Array;Lkotlin/Array;Ljava/lang/String;Ljava/lang/String;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public @interface Metadata {
    int[] bv() default {1, 0, 3};

    String[] d1() default {};

    String[] d2() default {};

    int k() default 1;

    int[] mv() default {};

    String pn() default "";

    int xi() default 0;

    String xs() default "";
}