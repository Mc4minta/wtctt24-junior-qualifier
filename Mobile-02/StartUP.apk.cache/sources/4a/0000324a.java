package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.dynamic.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0144a extends e.g.a.e.d.e.a implements a {

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* renamed from: com.google.android.gms.dynamic.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0145a extends e.g.a.e.d.e.b implements a {
            C0145a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0144a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a p(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0145a(iBinder);
        }
    }
}