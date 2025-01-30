package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.e0;
import org.apache.http.message.TokenParser;

/* compiled from: ClassicTypeCheckerContext.kt */
/* loaded from: classes3.dex */
public final class ClassicTypeCheckerContextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String errorMessage(Object obj) {
        return "ClassicTypeCheckerContext couldn't handle " + e0.b(obj.getClass()) + TokenParser.SP + obj;
    }
}