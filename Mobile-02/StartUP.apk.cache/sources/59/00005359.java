package kotlin.reflect.jvm.internal.calls;

import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "", "", "entry", "", "invoke", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 extends o implements l<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 INSTANCE = new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1();

    AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
        String arrays;
        m.g(entry, "entry");
        String key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            arrays = Arrays.toString((boolean[]) value);
        } else if (value instanceof char[]) {
            arrays = Arrays.toString((char[]) value);
        } else if (value instanceof byte[]) {
            arrays = Arrays.toString((byte[]) value);
        } else if (value instanceof short[]) {
            arrays = Arrays.toString((short[]) value);
        } else if (value instanceof int[]) {
            arrays = Arrays.toString((int[]) value);
        } else if (value instanceof float[]) {
            arrays = Arrays.toString((float[]) value);
        } else if (value instanceof long[]) {
            arrays = Arrays.toString((long[]) value);
        } else if (value instanceof double[]) {
            arrays = Arrays.toString((double[]) value);
        } else {
            arrays = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
        }
        return key + '=' + arrays;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
        return invoke2((Map.Entry<String, ? extends Object>) entry);
    }
}