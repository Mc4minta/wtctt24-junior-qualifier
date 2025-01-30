package kotlin.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Char.kt */
/* loaded from: classes3.dex */
public class c extends b {
    public static boolean d(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c2);
            char upperCase2 = Character.toUpperCase(c3);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }
}