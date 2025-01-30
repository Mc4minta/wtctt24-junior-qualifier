package com.facebook.react.bridge;

import com.facebook.react.bridge.NativeModule;
import com.facebook.systrace.b;
import e.f.l.a.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@a
/* loaded from: classes2.dex */
public class JavaModuleWrapper {
    private final JSInstance mJSInstance;
    private final ModuleHolder mModuleHolder;
    private final ArrayList<NativeModule.NativeMethod> mMethods = new ArrayList<>();
    private final ArrayList<MethodDescriptor> mDescs = new ArrayList<>();

    @a
    /* loaded from: classes2.dex */
    public class MethodDescriptor {
        @a
        Method method;
        @a
        String name;
        @a
        String signature;
        @a
        String type;

        public MethodDescriptor() {
        }
    }

    public JavaModuleWrapper(JSInstance jSInstance, ModuleHolder moduleHolder) {
        this.mJSInstance = jSInstance;
        this.mModuleHolder = moduleHolder;
    }

    @a
    private void findMethods() {
        Method[] declaredMethods;
        com.facebook.systrace.a.c(0L, "findMethods");
        HashSet hashSet = new HashSet();
        Class<?> cls = this.mModuleHolder.getModule().getClass();
        Class<? super Object> superclass = cls.getSuperclass();
        if (ReactModuleWithSpec.class.isAssignableFrom(superclass)) {
            cls = superclass;
        }
        for (Method method : cls.getDeclaredMethods()) {
            ReactMethod reactMethod = (ReactMethod) method.getAnnotation(ReactMethod.class);
            if (reactMethod != null) {
                String name = method.getName();
                if (!hashSet.contains(name)) {
                    MethodDescriptor methodDescriptor = new MethodDescriptor();
                    JavaMethodWrapper javaMethodWrapper = new JavaMethodWrapper(this, method, reactMethod.isBlockingSynchronousMethod());
                    methodDescriptor.name = name;
                    String type = javaMethodWrapper.getType();
                    methodDescriptor.type = type;
                    if (type == BaseJavaModule.METHOD_TYPE_SYNC) {
                        methodDescriptor.signature = javaMethodWrapper.getSignature();
                        methodDescriptor.method = method;
                    }
                    this.mMethods.add(javaMethodWrapper);
                    this.mDescs.add(methodDescriptor);
                } else {
                    throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + name);
                }
            }
        }
        com.facebook.systrace.a.g(0L);
    }

    @a
    public NativeMap getConstants() {
        if (this.mModuleHolder.getHasConstants()) {
            String name = getName();
            b.a(0L, "JavaModuleWrapper.getConstants").b("moduleName", name).c();
            ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, name);
            BaseJavaModule module = getModule();
            com.facebook.systrace.a.c(0L, "module.getConstants");
            Map<String, Object> constants = module.getConstants();
            com.facebook.systrace.a.g(0L);
            com.facebook.systrace.a.c(0L, "create WritableNativeMap");
            ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, name);
            try {
                return Arguments.makeNativeMap(constants);
            } finally {
                ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END, name);
                com.facebook.systrace.a.g(0L);
                ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END, name);
                b.b(0L).c();
            }
        }
        return null;
    }

    @a
    public List<MethodDescriptor> getMethodDescriptors() {
        if (this.mDescs.isEmpty()) {
            findMethods();
        }
        return this.mDescs;
    }

    @a
    public BaseJavaModule getModule() {
        return (BaseJavaModule) this.mModuleHolder.getModule();
    }

    @a
    public String getName() {
        return this.mModuleHolder.getName();
    }

    @a
    public void invoke(int i2, ReadableNativeArray readableNativeArray) {
        ArrayList<NativeModule.NativeMethod> arrayList = this.mMethods;
        if (arrayList == null || i2 >= arrayList.size()) {
            return;
        }
        this.mMethods.get(i2).invoke(this.mJSInstance, readableNativeArray);
    }
}