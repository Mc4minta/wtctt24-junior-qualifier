package okhttp3.internal.http2;

import com.coinbase.ApiConstants;
import j.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Header.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0019B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/http2/Header;", "", "", "toString", "()Ljava/lang/String;", "Lj/i;", "component1", "()Lj/i;", "component2", ApiConstants.NAME, "value", "copy", "(Lj/i;Lj/i;)Lokhttp3/internal/http2/Header;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "hpackSize", "I", "Lj/i;", "<init>", "(Lj/i;Lj/i;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Lj/i;Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final i PSEUDO_PREFIX;
    public static final i RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final i TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final i TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final i TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final i TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final i name;
    public final i value;

    /* compiled from: Header.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http2/Header$Companion;", "", "Lj/i;", "PSEUDO_PREFIX", "Lj/i;", "RESPONSE_STATUS", "", "RESPONSE_STATUS_UTF8", "Ljava/lang/String;", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        i.a aVar = i.f17151b;
        PSEUDO_PREFIX = aVar.d(":");
        RESPONSE_STATUS = aVar.d(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = aVar.d(TARGET_METHOD_UTF8);
        TARGET_PATH = aVar.d(TARGET_PATH_UTF8);
        TARGET_SCHEME = aVar.d(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = aVar.d(TARGET_AUTHORITY_UTF8);
    }

    public Header(i name, i value) {
        m.h(name, "name");
        m.h(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.Q() + 32 + value.Q();
    }

    public static /* synthetic */ Header copy$default(Header header, i iVar, i iVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iVar = header.name;
        }
        if ((i2 & 2) != 0) {
            iVar2 = header.value;
        }
        return header.copy(iVar, iVar2);
    }

    public final i component1() {
        return this.name;
    }

    public final i component2() {
        return this.value;
    }

    public final Header copy(i name, i value) {
        m.h(name, "name");
        m.h(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Header) {
                Header header = (Header) obj;
                return m.c(this.name, header.name) && m.c(this.value, header.value);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        i iVar = this.name;
        int hashCode = (iVar != null ? iVar.hashCode() : 0) * 31;
        i iVar2 = this.value;
        return hashCode + (iVar2 != null ? iVar2.hashCode() : 0);
    }

    public String toString() {
        return this.name.U() + ": " + this.value.U();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Header(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.m.h(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.m.h(r3, r0)
            j.i$a r0 = j.i.f17151b
            j.i r2 = r0.d(r2)
            j.i r3 = r0.d(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Header.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(i name, String value) {
        this(name, i.f17151b.d(value));
        m.h(name, "name");
        m.h(value, "value");
    }
}