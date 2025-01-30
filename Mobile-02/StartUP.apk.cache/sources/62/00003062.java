package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: MinElf.java */
/* loaded from: classes2.dex */
public final class i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MinElf.java */
    /* loaded from: classes2.dex */
    public static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }

    /* compiled from: MinElf.java */
    /* loaded from: classes2.dex */
    public enum b {
        NOT_SO("not_so"),
        X86("x86"),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");
        

        /* renamed from: h  reason: collision with root package name */
        private final String f5636h;

        b(String str) {
            this.f5636h = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f5636h;
        }
    }

    public static String[] a(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return b(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    public static String[] b(FileChannel fileChannel) throws IOException {
        long j2;
        long j3;
        long c2;
        String str;
        long j4;
        String str2;
        long f2;
        long c3;
        long c4;
        long c5;
        long f3;
        long f4;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (f(fileChannel, allocate, 0L) == 1179403647) {
            boolean z = g(fileChannel, allocate, 4L) == 1;
            if (g(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long f5 = z ? f(fileChannel, allocate, 28L) : c(fileChannel, allocate, 32L);
            long e2 = z ? e(fileChannel, allocate, 44L) : e(fileChannel, allocate, 56L);
            int e3 = e(fileChannel, allocate, z ? 42L : 54L);
            if (e2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                long f6 = z ? f(fileChannel, allocate, 32L) : c(fileChannel, allocate, 40L);
                if (z) {
                    f4 = f(fileChannel, allocate, f6 + 28);
                } else {
                    f4 = f(fileChannel, allocate, f6 + 44);
                }
                e2 = f4;
            }
            long j5 = f5;
            long j6 = 0;
            while (true) {
                if (j6 >= e2) {
                    j2 = 0;
                    break;
                }
                if (z) {
                    f3 = f(fileChannel, allocate, j5 + 0);
                } else {
                    f3 = f(fileChannel, allocate, j5 + 0);
                }
                if (f3 != 2) {
                    j5 += e3;
                    j6++;
                } else if (z) {
                    j2 = f(fileChannel, allocate, j5 + 4);
                } else {
                    j2 = c(fileChannel, allocate, j5 + 8);
                }
            }
            long j7 = 0;
            if (j2 == 0) {
                throw new a("ELF file does not contain dynamic linking information");
            }
            long j8 = j2;
            long j9 = 0;
            int i2 = 0;
            while (true) {
                boolean z2 = z;
                long f7 = z ? f(fileChannel, allocate, j8 + j7) : c(fileChannel, allocate, j8 + j7);
                long j10 = j2;
                String str3 = "malformed DT_NEEDED section";
                if (f7 == 1) {
                    if (i2 == Integer.MAX_VALUE) {
                        throw new a("malformed DT_NEEDED section");
                    }
                    i2++;
                    j3 = f7;
                } else if (f7 == 5) {
                    if (z2) {
                        j3 = f7;
                        c2 = f(fileChannel, allocate, j8 + 4);
                    } else {
                        j3 = f7;
                        c2 = c(fileChannel, allocate, j8 + 8);
                    }
                    j9 = c2;
                } else {
                    j3 = f7;
                }
                long j11 = 16;
                j8 += z2 ? 8L : 16L;
                j7 = 0;
                if (j3 != 0) {
                    z = z2;
                    j2 = j10;
                } else if (j9 == 0) {
                    throw new a("Dynamic section string-table not found");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= e2) {
                            str = str3;
                            j4 = 0;
                            break;
                        }
                        if (z2) {
                            f2 = f(fileChannel, allocate, f5 + j7);
                        } else {
                            f2 = f(fileChannel, allocate, f5 + j7);
                        }
                        if (f2 == 1) {
                            if (z2) {
                                c3 = f(fileChannel, allocate, f5 + 8);
                            } else {
                                c3 = c(fileChannel, allocate, f5 + j11);
                            }
                            if (z2) {
                                str = str3;
                                c4 = f(fileChannel, allocate, f5 + 20);
                            } else {
                                str = str3;
                                c4 = c(fileChannel, allocate, f5 + 40);
                            }
                            if (c3 <= j9 && j9 < c4 + c3) {
                                if (z2) {
                                    c5 = f(fileChannel, allocate, f5 + 4);
                                } else {
                                    c5 = c(fileChannel, allocate, f5 + 8);
                                }
                                j4 = c5 + (j9 - c3);
                            }
                        } else {
                            str = str3;
                        }
                        f5 += e3;
                        i3++;
                        str3 = str;
                        j11 = 16;
                        j7 = 0;
                    }
                    long j12 = 0;
                    if (j4 != 0) {
                        String[] strArr = new String[i2];
                        long j13 = j10;
                        int i4 = 0;
                        while (true) {
                            long j14 = j13 + j12;
                            long f8 = z2 ? f(fileChannel, allocate, j14) : c(fileChannel, allocate, j14);
                            if (f8 == 1) {
                                strArr[i4] = d(fileChannel, allocate, (z2 ? f(fileChannel, allocate, j13 + 4) : c(fileChannel, allocate, j13 + 8)) + j4);
                                if (i4 == Integer.MAX_VALUE) {
                                    throw new a(str);
                                }
                                i4++;
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            j13 += z2 ? 8L : 16L;
                            if (f8 == 0) {
                                if (i4 == i2) {
                                    return strArr;
                                }
                                throw new a(str2);
                            }
                            str = str2;
                            j12 = 0;
                        }
                    } else {
                        throw new a("did not find file offset of DT_STRTAB table");
                    }
                }
            }
        } else {
            throw new a("file is not ELF");
        }
    }

    private static long c(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 8, j2);
        return byteBuffer.getLong();
    }

    private static String d(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short g2 = g(fileChannel, byteBuffer, j2);
            if (g2 != 0) {
                sb.append((char) g2);
                j2 = j3;
            } else {
                return sb.toString();
            }
        }
    }

    private static int e(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 2, j2);
        return byteBuffer.getShort() & 65535;
    }

    private static long f(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 4, j2);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static short g(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        h(fileChannel, byteBuffer, 1, j2);
        return (short) (byteBuffer.get() & 255);
    }

    private static void h(FileChannel fileChannel, ByteBuffer byteBuffer, int i2, long j2) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j2)) != -1) {
            j2 += read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new a("ELF file truncated");
    }
}