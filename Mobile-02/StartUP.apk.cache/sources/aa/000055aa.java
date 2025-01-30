package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface JavaConstructor extends JavaMember, JavaTypeParameterListOwner {
    List<JavaValueParameter> getValueParameters();
}