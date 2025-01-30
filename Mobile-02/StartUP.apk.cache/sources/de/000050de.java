package io.branch.referral;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: DeferredAppLinkDataHandler.java */
/* loaded from: classes2.dex */
class k {

    /* compiled from: DeferredAppLinkDataHandler.java */
    /* loaded from: classes2.dex */
    static class a implements InvocationHandler {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f17061b;

        a(Class cls, b bVar) {
            this.a = cls;
            this.f17061b = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("onDeferredAppLinkDataFetched") && objArr[0] != null) {
                Bundle bundle = (Bundle) Bundle.class.cast(this.a.getMethod("getArgumentBundle", new Class[0]).invoke(this.a.cast(objArr[0]), new Object[0]));
                String string = bundle != null ? bundle.getString("com.facebook.platform.APPLINK_NATIVE_URL") : null;
                b bVar = this.f17061b;
                if (bVar != null) {
                    bVar.a(string);
                }
            } else {
                b bVar2 = this.f17061b;
                if (bVar2 != null) {
                    bVar2.a(null);
                }
            }
            return null;
        }
    }

    /* compiled from: DeferredAppLinkDataHandler.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(String str);
    }

    public static Boolean a(Context context, b bVar) {
        boolean z = false;
        try {
            Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", Context.class).invoke(null, context);
            Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Method method = cls.getMethod("fetchDeferredAppLinkData", Context.class, String.class, cls2);
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new a(cls, bVar));
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
            if (!TextUtils.isEmpty(string)) {
                method.invoke(null, context, string, newProxyInstance);
                z = true;
            }
        } catch (Throwable unused) {
        }
        return Boolean.valueOf(z);
    }
}