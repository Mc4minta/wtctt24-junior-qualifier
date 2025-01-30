package kotlin.l0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public enum m implements f {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    

    /* renamed from: j  reason: collision with root package name */
    private final int f17376j;

    /* renamed from: k  reason: collision with root package name */
    private final int f17377k;

    m(int i2, int i3) {
        this.f17376j = i2;
        this.f17377k = i3;
    }

    @Override // kotlin.l0.f
    public int getValue() {
        return this.f17376j;
    }

    /* synthetic */ m(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i4 & 2) != 0 ? i2 : i3);
    }
}