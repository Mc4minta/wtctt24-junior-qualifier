package kotlin.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* loaded from: classes3.dex */
public class b {
    public static int a(int i2) {
        if (2 > i2 || 36 < i2) {
            throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new kotlin.i0.c(2, 36));
        }
        return i2;
    }

    public static final int b(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    public static boolean c(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}