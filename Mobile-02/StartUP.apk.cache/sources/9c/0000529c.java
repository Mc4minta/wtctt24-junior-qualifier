package kotlin.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes3.dex */
public final class n {
    public static final k a;

    /* renamed from: b  reason: collision with root package name */
    public static final n f17378b = new n();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        a = new k("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private n() {
    }
}