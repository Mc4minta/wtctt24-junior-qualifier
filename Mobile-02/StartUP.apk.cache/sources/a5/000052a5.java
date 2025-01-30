package kotlin.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringBuilder.kt */
/* loaded from: classes3.dex */
public class u extends t {
    public static StringBuilder i(StringBuilder append, String... value) {
        kotlin.jvm.internal.m.g(append, "$this$append");
        kotlin.jvm.internal.m.g(value, "value");
        for (String str : value) {
            append.append(str);
        }
        return append;
    }
}