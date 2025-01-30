package k.b.b;

import android.graphics.Bitmap;
import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;

/* compiled from: RNFrameFactory.java */
/* loaded from: classes3.dex */
public class b {
    public static a a(Bitmap bitmap) {
        Frame.Builder builder = new Frame.Builder();
        builder.setBitmap(bitmap);
        return new a(builder.build(), new org.reactnative.camera.h.a(bitmap.getWidth(), bitmap.getHeight()));
    }

    public static a b(byte[] bArr, int i2, int i3, int i4) {
        Frame.Builder builder = new Frame.Builder();
        builder.setImageData(ByteBuffer.wrap(bArr), i2, i3, 17);
        if (i4 == 90) {
            builder.setRotation(1);
        } else if (i4 == 180) {
            builder.setRotation(2);
        } else if (i4 != 270) {
            builder.setRotation(0);
        } else {
            builder.setRotation(3);
        }
        return new a(builder.build(), new org.reactnative.camera.h.a(i2, i3, i4));
    }
}