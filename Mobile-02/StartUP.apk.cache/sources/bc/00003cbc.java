package com.google.protobuf;

import org.apache.http.message.TokenParser;

/* compiled from: TextFormatEscaper.java */
/* loaded from: classes2.dex */
final class t {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFormatEscaper.java */
    /* loaded from: classes2.dex */
    public static class a implements b {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // com.google.protobuf.t.b
        public byte a(int i2) {
            return this.a.h(i2);
        }

        @Override // com.google.protobuf.t.b
        public int size() {
            return this.a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextFormatEscaper.java */
    /* loaded from: classes2.dex */
    public interface b {
        byte a(int i2);

        int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(e eVar) {
        return b(new a(eVar));
    }

    static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            byte a2 = bVar.a(i2);
            if (a2 == 34) {
                sb.append("\\\"");
            } else if (a2 == 39) {
                sb.append("\\'");
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (a2 >= 32 && a2 <= 126) {
                            sb.append((char) a2);
                            continue;
                        } else {
                            sb.append(TokenParser.ESCAPE);
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            sb.append((char) ((a2 & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        return a(e.m(str));
    }
}