package j;

/* compiled from: -Platform.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final byte[] a(String asUtf8ToByteArray) {
        kotlin.jvm.internal.m.g(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(kotlin.l0.d.a);
        kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] toUtf8String) {
        kotlin.jvm.internal.m.g(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, kotlin.l0.d.a);
    }
}