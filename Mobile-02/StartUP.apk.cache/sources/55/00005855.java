package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.internal.m;

/* compiled from: BuiltInsResourceLoader.kt */
/* loaded from: classes3.dex */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String path) {
        m.g(path, "path");
        ClassLoader classLoader = BuiltInsResourceLoader.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(path);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(path) : resourceAsStream;
    }
}