package com.lwansbrough.RCTCamera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.facebook.react.bridge.ReadableMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class MutableImage {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f10458b;

    /* renamed from: c  reason: collision with root package name */
    private Metadata f10459c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10460d = false;

    /* loaded from: classes2.dex */
    public static class ImageMutationFailedException extends Exception {
        public ImageMutationFailedException(String str, Throwable th) {
            super(str, th);
        }

        public ImageMutationFailedException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static String a(double d2) {
            return d2 < 0.0d ? "S" : "N";
        }

        private static String b(double d2) {
            return d2 < 0.0d ? "W" : "E";
        }

        private static String c(double d2) {
            double abs = Math.abs(d2);
            int i2 = (int) abs;
            double d3 = (abs * 60.0d) - (i2 * 60.0d);
            int i3 = (int) d3;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i2);
            stringBuffer.append("/1,");
            stringBuffer.append(i3);
            stringBuffer.append("/1,");
            stringBuffer.append((int) (((d3 * 60.0d) - (i3 * 60.0d)) * 1000.0d));
            stringBuffer.append("/1000,");
            return stringBuffer.toString();
        }

        public static void d(double d2, double d3, ExifInterface exifInterface) throws IOException {
            exifInterface.setAttribute("GPSLatitude", c(d2));
            exifInterface.setAttribute("GPSLatitudeRef", a(d2));
            exifInterface.setAttribute("GPSLongitude", c(d3));
            exifInterface.setAttribute("GPSLongitudeRef", b(d3));
        }
    }

    public MutableImage(byte[] bArr) {
        this.a = bArr;
        this.f10458b = k(bArr);
    }

    private String a(String str) {
        return !str.contains("/") ? "" : Double.toString(1.0d / Double.parseDouble(str.split("/")[1]));
    }

    private Metadata g() throws ImageProcessingException, IOException {
        if (this.f10459c == null) {
            this.f10459c = ImageMetadataReader.readMetadata(new BufferedInputStream(new ByteArrayInputStream(this.a)), this.a.length);
        }
        return this.f10459c;
    }

    private void h(ExifInterface exifInterface) {
        exifInterface.setAttribute("Orientation", String.valueOf(1));
    }

    private void i(int i2) throws ImageMutationFailedException {
        Matrix matrix = new Matrix();
        switch (i2) {
            case 1:
                return;
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.f10458b, 0, 0, e(), d(), matrix, false);
        if (createBitmap != null) {
            this.f10458b = createBitmap;
            this.f10460d = true;
            return;
        }
        throw new ImageMutationFailedException("failed to rotate");
    }

    private static Bitmap k(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
            byteArrayInputStream.close();
            return decodeStream;
        } catch (IOException e2) {
            throw new IllegalStateException("Will not happen", e2);
        }
    }

    private static byte[] l(Bitmap bitmap, int i2) throws OutOfMemoryError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        try {
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                Log.e("RNCamera", "problem compressing jpeg", e2);
            }
        }
    }

    private void n(ReadableMap readableMap, ExifInterface exifInterface) {
        if (readableMap.hasKey(SendConfirmationArgs.metadataKey)) {
            ReadableMap map = readableMap.getMap(SendConfirmationArgs.metadataKey);
            if (map.hasKey("location")) {
                ReadableMap map2 = map.getMap("location");
                if (map2.hasKey("coords")) {
                    try {
                        ReadableMap map3 = map2.getMap("coords");
                        a.d(map3.getDouble("latitude"), map3.getDouble("longitude"), exifInterface);
                    } catch (IOException e2) {
                        Log.e("RNCamera", "Couldn't write location data", e2);
                    }
                }
            }
        }
    }

    public void b(double d2) throws IllegalArgumentException {
        int i2;
        int i3;
        int e2 = e();
        int d3 = d();
        double d4 = d3 * d2;
        double d5 = e2;
        if (d4 > d5) {
            i3 = (int) (d5 / d2);
            i2 = e2;
        } else {
            i2 = (int) d4;
            i3 = d3;
        }
        this.f10458b = Bitmap.createBitmap(this.f10458b, (e2 - i2) / 2, (d3 - i3) / 2, i2, i3);
    }

    public void c() throws ImageMutationFailedException {
        int i2;
        try {
            ExifIFD0Directory firstDirectoryOfType = g().getFirstDirectoryOfType(ExifIFD0Directory.class);
            if (firstDirectoryOfType == null || !firstDirectoryOfType.containsTag(274) || (i2 = firstDirectoryOfType.getInt(274)) == 1) {
                return;
            }
            i(i2);
            firstDirectoryOfType.setInt(274, 1);
        } catch (MetadataException | IOException | ImageProcessingException e2) {
            throw new ImageMutationFailedException("failed to fix orientation", e2);
        }
    }

    public int d() {
        return this.f10458b.getHeight();
    }

    public int e() {
        return this.f10458b.getWidth();
    }

    public void f() throws ImageMutationFailedException {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(this.f10458b, 0, 0, e(), d(), matrix, false);
        if (createBitmap != null) {
            this.f10458b = createBitmap;
            return;
        }
        throw new ImageMutationFailedException("failed to mirror");
    }

    public String j(int i2) {
        return Base64.encodeToString(l(this.f10458b, i2), 2);
    }

    public void m(File file, ReadableMap readableMap, int i2) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(l(this.f10458b, i2));
        fileOutputStream.close();
        try {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            for (Directory directory : g().getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    exifInterface.setAttribute(tag.getTagName(), directory.getObject(tag.getTagType()).toString());
                }
            }
            ExifSubIFDDirectory firstDirectoryOfType = g().getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            for (Tag tag2 : firstDirectoryOfType.getTags()) {
                int tagType = tag2.getTagType();
                String replaceAll = tag2.getTagName().replaceAll(" ", "");
                Object object = firstDirectoryOfType.getObject(tagType);
                if (replaceAll.equals("ExposureTime")) {
                    exifInterface.setAttribute(replaceAll, a(object.toString()));
                } else {
                    exifInterface.setAttribute(replaceAll, object.toString());
                }
            }
            n(readableMap, exifInterface);
            if (this.f10460d) {
                h(exifInterface);
            }
            exifInterface.saveAttributes();
        } catch (ImageProcessingException | IOException e2) {
            Log.e("RNCamera", "failed to save exif data", e2);
        }
    }
}