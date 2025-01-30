package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a0.h0;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.i0.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* compiled from: BuiltInsBinaryVersion.kt */
/* loaded from: classes3.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = new Companion(null);
    public static final BuiltInsBinaryVersion INSTANCE = new BuiltInsBinaryVersion(1, 0, 7);
    public static final BuiltInsBinaryVersion INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);

    /* compiled from: BuiltInsBinaryVersion.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BuiltInsBinaryVersion readFrom(InputStream stream) {
            int r;
            int[] H0;
            m.g(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            c cVar = new c(1, dataInputStream.readInt());
            r = s.r(cVar, 10);
            ArrayList arrayList = new ArrayList(r);
            Iterator<Integer> it = cVar.iterator();
            while (it.hasNext()) {
                ((h0) it).c();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            H0 = z.H0(arrayList);
            int[] iArr = new int[H0.length];
            System.arraycopy(H0, 0, iArr, 0, H0.length);
            return new BuiltInsBinaryVersion(iArr);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BuiltInsBinaryVersion(int... r4) {
        /*
            r3 = this;
            java.lang.String r0 = "numbers"
            kotlin.jvm.internal.m.g(r4, r0)
            int r0 = r4.length
            int[] r0 = new int[r0]
            int r1 = r4.length
            r2 = 0
            java.lang.System.arraycopy(r4, r2, r0, r2, r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.<init>(int[]):void");
    }

    public boolean isCompatible() {
        return isCompatibleTo(INSTANCE);
    }
}