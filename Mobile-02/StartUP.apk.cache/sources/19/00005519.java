package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.coinbase.ApiConstants;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.e0.c.l;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.x;

/* loaded from: classes3.dex */
public final class DescriptorResolverUtils {
    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        String str = i2 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 18 ? 3 : 2];
        switch (i2) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = ApiConstants.NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i2 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 == 18) {
            throw new IllegalStateException(format);
        }
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name name, ClassDescriptor classDescriptor) {
        if (name == null) {
            $$$reportNull$$$0(19);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(20);
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (ValueParameterDescriptor valueParameterDescriptor : constructors.iterator().next().getValueParameters()) {
            if (valueParameterDescriptor.getName().equals(name)) {
                return valueParameterDescriptor;
            }
        }
        return null;
    }

    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, final ErrorReporter errorReporter, OverridingUtil overridingUtil, final boolean z) {
        if (name == null) {
            $$$reportNull$$$0(12);
        }
        if (collection == null) {
            $$$reportNull$$$0(13);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(14);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        if (errorReporter == null) {
            $$$reportNull$$$0(16);
        }
        if (overridingUtil == null) {
            $$$reportNull$$$0(17);
        }
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        overridingUtil.generateOverridesInFunctionGroup(name, collection, collection2, classDescriptor, new NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.1
            private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                Object[] objArr = new Object[3];
                if (i2 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i2 == 2) {
                    objArr[0] = "fromCurrent";
                } else if (i2 == 3) {
                    objArr[0] = "member";
                } else if (i2 != 4) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "overridden";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
                if (i2 == 1 || i2 == 2) {
                    objArr[2] = "conflict";
                } else if (i2 == 3 || i2 == 4) {
                    objArr[2] = "setOverriddenDescriptors";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
            public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    $$$reportNull$$$0(0);
                }
                OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, new l<CallableMemberDescriptor, x>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.1.1
                    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                    }

                    @Override // kotlin.e0.c.l
                    public x invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                        if (callableMemberDescriptor2 == null) {
                            $$$reportNull$$$0(0);
                        }
                        ErrorReporter.this.reportCannotInferVisibility(callableMemberDescriptor2);
                        return x.a;
                    }
                });
                linkedHashSet.add(callableMemberDescriptor);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
            public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                if (callableMemberDescriptor2 == null) {
                    $$$reportNull$$$0(2);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
            public void setOverriddenDescriptors(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection3) {
                if (callableMemberDescriptor == null) {
                    $$$reportNull$$$0(3);
                }
                if (collection3 == null) {
                    $$$reportNull$$$0(4);
                }
                if (!z || callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    super.setOverriddenDescriptors(callableMemberDescriptor, collection3);
                }
            }
        });
        return linkedHashSet;
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            $$$reportNull$$$0(0);
        }
        if (collection == null) {
            $$$reportNull$$$0(1);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(2);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (errorReporter == null) {
            $$$reportNull$$$0(4);
        }
        if (overridingUtil == null) {
            $$$reportNull$$$0(5);
        }
        return resolveOverrides(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            $$$reportNull$$$0(6);
        }
        if (collection == null) {
            $$$reportNull$$$0(7);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(8);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        if (errorReporter == null) {
            $$$reportNull$$$0(10);
        }
        if (overridingUtil == null) {
            $$$reportNull$$$0(11);
        }
        return resolveOverrides(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, true);
    }
}