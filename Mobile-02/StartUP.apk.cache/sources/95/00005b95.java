package okhttp3.internal.ws;

import j.f;
import j.i;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WebSocketProtocol.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010!\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010#\u001a\u00020\"8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\"8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\"8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010(\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0016\u0010)\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0016\u0010+\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010\u0013¨\u0006."}, d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "Lj/f$a;", "cursor", "", "key", "Lkotlin/x;", "toggleMask", "(Lj/f$a;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "B0_FLAG_RSV1", "I", "CLOSE_NO_STATUS_CODE", "B1_MASK_LENGTH", "OPCODE_TEXT", "ACCEPT_MAGIC", "Ljava/lang/String;", "OPCODE_CONTROL_PING", "B0_FLAG_RSV2", "OPCODE_BINARY", "B0_MASK_OPCODE", "PAYLOAD_SHORT", "CLOSE_CLIENT_GOING_AWAY", "OPCODE_CONTINUATION", "B0_FLAG_FIN", "B0_FLAG_RSV3", "", "PAYLOAD_SHORT_MAX", "J", "PAYLOAD_BYTE_MAX", "CLOSE_MESSAGE_MAX", "OPCODE_CONTROL_PONG", "B1_FLAG_MASK", "OPCODE_FLAG_CONTROL", "PAYLOAD_LONG", "OPCODE_CONTROL_CLOSE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        m.h(key, "key");
        i.a aVar = i.f17151b;
        return aVar.d(key + ACCEPT_MAGIC).O().h();
    }

    public final String closeCodeExceptionMessage(int i2) {
        if (i2 < 1000 || i2 >= 5000) {
            return "Code must be in range [1000,5000): " + i2;
        } else if ((1004 > i2 || 1006 < i2) && (1015 > i2 || 2999 < i2)) {
            return null;
        } else {
            return "Code " + i2 + " is reserved and may not be used.";
        }
    }

    public final void toggleMask(f.a cursor, byte[] key) {
        m.h(cursor, "cursor");
        m.h(key, "key");
        int length = key.length;
        int i2 = 0;
        do {
            byte[] bArr = cursor.f17148e;
            int i3 = cursor.f17149f;
            int i4 = cursor.f17150g;
            if (bArr != null) {
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr[i3] = (byte) (bArr[i3] ^ key[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            }
        } while (cursor.b() != -1);
    }

    public final void validateCloseCode(int i2) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i2);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        if (closeCodeExceptionMessage == null) {
            m.q();
        }
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}