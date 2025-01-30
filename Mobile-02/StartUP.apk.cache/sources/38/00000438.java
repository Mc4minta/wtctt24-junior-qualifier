package androidx.room.s;

import c.r.a.b;

/* compiled from: Migration.java */
/* loaded from: classes.dex */
public abstract class a {
    public final int endVersion;
    public final int startVersion;

    public a(int i2, int i3) {
        this.startVersion = i2;
        this.endVersion = i3;
    }

    public abstract void migrate(b bVar);
}