package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LookupLocation.kt */
/* loaded from: classes3.dex */
public final class Position implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final Position NO_POSITION = new Position(-1, -1);
    private final int column;
    private final int line;

    /* compiled from: LookupLocation.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Position getNO_POSITION() {
            return Position.NO_POSITION;
        }
    }

    public Position(int i2, int i3) {
        this.line = i2;
        this.column = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return this.line == position.line && this.column == position.column;
        }
        return false;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }
}