package kotlin.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* loaded from: classes3.dex */
public class p {
    public static <T> void a(Appendable appendElement, T t, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(appendElement, "$this$appendElement");
        if (lVar != null) {
            appendElement.append(lVar.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendElement.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendElement.append(((Character) t).charValue());
        } else {
            appendElement.append(String.valueOf(t));
        }
    }
}