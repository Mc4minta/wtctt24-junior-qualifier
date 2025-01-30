package com.google.gson.u;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.u.n.n;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: Streams.java */
/* loaded from: classes2.dex */
public final class l {
    public static com.google.gson.l a(com.google.gson.stream.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.k0();
                z = false;
                try {
                    return n.X.read(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return com.google.gson.m.a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e3) {
                throw new JsonSyntaxException(e3);
            } catch (IOException e4) {
                throw new JsonIOException(e4);
            } catch (NumberFormatException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    public static void b(com.google.gson.l lVar, com.google.gson.stream.c cVar) throws IOException {
        n.X.write(cVar, lVar);
    }
}