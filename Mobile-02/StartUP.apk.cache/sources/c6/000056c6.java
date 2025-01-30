package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.n;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BinaryVersion.kt */
/* loaded from: classes3.dex */
public abstract class BinaryVersion {
    public static final Companion Companion = new Companion(null);
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    /* compiled from: BinaryVersion.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BinaryVersion(int... numbers) {
        Integer C;
        Integer C2;
        Integer C3;
        List<Integer> g2;
        List<Integer> b2;
        m.g(numbers, "numbers");
        this.numbers = numbers;
        C = n.C(numbers, 0);
        this.major = C == null ? -1 : C.intValue();
        C2 = n.C(numbers, 1);
        this.minor = C2 == null ? -1 : C2.intValue();
        C3 = n.C(numbers, 2);
        this.patch = C3 != null ? C3.intValue() : -1;
        if (numbers.length > 3) {
            b2 = kotlin.a0.m.b(numbers);
            g2 = z.I0(b2.subList(3, numbers.length));
        } else {
            g2 = r.g();
        }
        this.rest = g2;
    }

    public boolean equals(Object obj) {
        if (obj != null && m.c(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && m.c(this.rest, binaryVersion.rest)) {
                return true;
            }
        }
        return false;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i2 = this.major;
        int i3 = i2 + (i2 * 31) + this.minor;
        int i4 = i3 + (i3 * 31) + this.patch;
        return i4 + (i4 * 31) + this.rest.hashCode();
    }

    public final boolean isAtLeast(BinaryVersion version) {
        m.g(version, "version");
        return isAtLeast(version.major, version.minor, version.patch);
    }

    public final boolean isAtMost(int i2, int i3, int i4) {
        int i5 = this.major;
        if (i5 < i2) {
            return true;
        }
        if (i5 > i2) {
            return false;
        }
        int i6 = this.minor;
        if (i6 < i3) {
            return true;
        }
        return i6 <= i3 && this.patch <= i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isCompatibleTo(BinaryVersion ourVersion) {
        m.g(ourVersion, "ourVersion");
        int i2 = this.major;
        if (i2 == 0) {
            if (ourVersion.major == 0 && this.minor == ourVersion.minor) {
                return true;
            }
        } else if (i2 == ourVersion.major && this.minor <= ourVersion.minor) {
            return true;
        }
        return false;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public String toString() {
        String h0;
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        int length = array.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = array[i2];
            if (!(i3 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        h0 = z.h0(arrayList, ".", null, null, 0, null, null, 62, null);
        return h0;
    }

    public final boolean isAtLeast(int i2, int i3, int i4) {
        int i5 = this.major;
        if (i5 > i2) {
            return true;
        }
        if (i5 < i2) {
            return false;
        }
        int i6 = this.minor;
        if (i6 > i3) {
            return true;
        }
        return i6 >= i3 && this.patch >= i4;
    }
}