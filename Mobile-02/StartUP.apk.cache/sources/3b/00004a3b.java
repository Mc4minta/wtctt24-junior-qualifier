package e.j.l.o;

/* compiled from: Base64Interface.kt */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: Base64Interface.kt */
    /* renamed from: e.j.l.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0327a {
        DEFAULT,
        NO_WRAP
    }

    byte[] a(String str, EnumC0327a enumC0327a);

    String b(byte[] bArr, EnumC0327a enumC0327a);
}