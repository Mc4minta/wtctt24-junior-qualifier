package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.j0.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.apache.http.message.TokenParser;

/* compiled from: ReflectionObjectRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J!\u0010\u0007\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "receiver", "Lkotlin/x;", "appendReceiverType", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "callable", "appendReceivers", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)V", "descriptor", "", "renderCallable", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderProperty", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderFunction", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Ljava/lang/String;", "invoke", "renderLambda", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "parameter", "renderParameter", "(Lkotlin/reflect/jvm/internal/KParameterImpl;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", "renderType", "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    private static final DescriptorRenderer renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[l.a.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[l.a.EXTENSION_RECEIVER.ordinal()] = 1;
            iArr[l.a.INSTANCE.ordinal()] = 2;
            iArr[l.a.VALUE.ordinal()] = 3;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            m.f(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    private final void appendReceivers(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        appendReceiverType(sb, instanceReceiverParameter);
        boolean z = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z) {
            sb.append("(");
        }
        appendReceiverType(sb, extensionReceiverParameter);
        if (z) {
            sb.append(")");
        }
    }

    private final String renderCallable(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof PropertyDescriptor) {
            return renderProperty((PropertyDescriptor) callableDescriptor);
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return renderFunction((FunctionDescriptor) callableDescriptor);
        }
        throw new IllegalStateException(("Illegal callable: " + callableDescriptor).toString());
    }

    public final String renderFunction(FunctionDescriptor descriptor) {
        m.g(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, descriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name = descriptor.getName();
        m.f(name, "descriptor.name");
        sb.append(descriptorRenderer.renderName(name, true));
        List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        m.f(valueParameters, "descriptor.valueParameters");
        z.f0(valueParameters, sb, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderFunction$1$1.INSTANCE, 48, null);
        sb.append(": ");
        KotlinType returnType = descriptor.getReturnType();
        m.e(returnType);
        m.f(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderLambda(FunctionDescriptor invoke) {
        m.g(invoke, "invoke");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, invoke);
        List<ValueParameterDescriptor> valueParameters = invoke.getValueParameters();
        m.f(valueParameters, "invoke.valueParameters");
        z.f0(valueParameters, sb, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48, null);
        sb.append(" -> ");
        KotlinType returnType = invoke.getReturnType();
        m.e(returnType);
        m.f(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderParameter(KParameterImpl parameter) {
        m.g(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        int i2 = WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()];
        if (i2 == 1) {
            sb.append("extension receiver parameter");
        } else if (i2 == 2) {
            sb.append("instance parameter");
        } else if (i2 == 3) {
            sb.append("parameter #" + parameter.getIndex() + TokenParser.SP + parameter.getName());
        }
        sb.append(" of ");
        sb.append(INSTANCE.renderCallable(parameter.getCallable().getDescriptor()));
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderProperty(PropertyDescriptor descriptor) {
        m.g(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb, descriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name = descriptor.getName();
        m.f(name, "descriptor.name");
        sb.append(descriptorRenderer.renderName(name, true));
        sb.append(": ");
        KotlinType type = descriptor.getType();
        m.f(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.renderType(type));
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderType(KotlinType type) {
        m.g(type, "type");
        return renderer.renderType(type);
    }
}