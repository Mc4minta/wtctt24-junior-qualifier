package com.facebook.imagepipeline.decoder;

import e.f.d.c.i;
import e.f.d.c.n;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProgressiveJpegParser.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: g  reason: collision with root package name */
    private boolean f4545g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.common.memory.a f4546h;

    /* renamed from: c  reason: collision with root package name */
    private int f4541c = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4540b = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f4542d = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f4544f = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f4543e = 0;
    private int a = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.f4546h = (com.facebook.common.memory.a) i.g(aVar);
    }

    private boolean a(InputStream inputStream) {
        int read;
        int i2 = this.f4543e;
        while (this.a != 6 && (read = inputStream.read()) != -1) {
            try {
                int i3 = this.f4541c + 1;
                this.f4541c = i3;
                if (this.f4545g) {
                    this.a = 6;
                    this.f4545g = false;
                    return false;
                }
                int i4 = this.a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.a = 5;
                                } else if (i4 != 5) {
                                    i.i(false);
                                } else {
                                    int i5 = ((this.f4540b << 8) + read) - 2;
                                    com.facebook.common.util.c.a(inputStream, i5);
                                    this.f4541c += i5;
                                    this.a = 2;
                                }
                            } else if (read == 255) {
                                this.a = 3;
                            } else if (read == 0) {
                                this.a = 2;
                            } else if (read == 217) {
                                this.f4545g = true;
                                f(i3 - 2);
                                this.a = 2;
                            } else {
                                if (read == 218) {
                                    f(i3 - 2);
                                }
                                if (b(read)) {
                                    this.a = 4;
                                } else {
                                    this.a = 2;
                                }
                            }
                        } else if (read == 255) {
                            this.a = 3;
                        }
                    } else if (read == 216) {
                        this.a = 2;
                    } else {
                        this.a = 6;
                    }
                } else if (read == 255) {
                    this.a = 1;
                } else {
                    this.a = 6;
                }
                this.f4540b = read;
            } catch (IOException e2) {
                n.a(e2);
            }
        }
        return (this.a == 6 || this.f4543e == i2) ? false : true;
    }

    private static boolean b(int i2) {
        if (i2 == 1) {
            return false;
        }
        if (i2 < 208 || i2 > 215) {
            return (i2 == 217 || i2 == 216) ? false : true;
        }
        return false;
    }

    private void f(int i2) {
        int i3 = this.f4542d;
        if (i3 > 0) {
            this.f4544f = i2;
        }
        this.f4542d = i3 + 1;
        this.f4543e = i3;
    }

    public int c() {
        return this.f4544f;
    }

    public int d() {
        return this.f4543e;
    }

    public boolean e() {
        return this.f4545g;
    }

    public boolean g(e.f.j.i.d dVar) {
        if (this.a != 6 && dVar.K() > this.f4541c) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.z(), this.f4546h.get(16384), this.f4546h);
            try {
                com.facebook.common.util.c.a(fVar, this.f4541c);
                return a(fVar);
            } catch (IOException e2) {
                n.a(e2);
                return false;
            } finally {
                e.f.d.c.b.b(fVar);
            }
        }
        return false;
    }
}