package com.google.firebase.encoders;

import java.io.IOException;
import java.io.Writer;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes2.dex */
public interface a {
    void a(Object obj, Writer writer) throws IOException;

    String b(Object obj);
}