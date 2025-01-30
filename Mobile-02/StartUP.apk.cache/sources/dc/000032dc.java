package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.q;
import com.google.android.gms.internal.clearcut.r;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class q<MessageType extends q<MessageType, BuilderType>, BuilderType extends r<MessageType, BuilderType>> implements i2 {
    private static boolean zzey;
    protected int zzex = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.clearcut.i2
    public final a0 f() {
        try {
            f0 t = a0.t(l());
            i(t.b());
            return t.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }
}