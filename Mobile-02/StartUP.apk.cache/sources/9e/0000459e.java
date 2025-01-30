package e.f.h.a.a.i;

import org.apache.http.message.TokenParser;

/* compiled from: ImageOriginUtils.java */
/* loaded from: classes2.dex */
public class d {
    public static int a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1917159454:
                if (str.equals("QualifiedResourceFetchProducer")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1914072202:
                if (str.equals("BitmapMemoryCacheGetProducer")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1683996557:
                if (str.equals("LocalResourceFetchProducer")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1579985851:
                if (str.equals("LocalFileFetchProducer")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1307634203:
                if (str.equals("EncodedMemoryCacheProducer")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1224383234:
                if (str.equals("NetworkFetchProducer")) {
                    c2 = 5;
                    break;
                }
                break;
            case 473552259:
                if (str.equals("VideoThumbnailProducer")) {
                    c2 = 6;
                    break;
                }
                break;
            case 656304759:
                if (str.equals("DiskCacheProducer")) {
                    c2 = 7;
                    break;
                }
                break;
            case 957714404:
                if (str.equals("BitmapMemoryCacheProducer")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1019542023:
                if (str.equals("LocalAssetFetchProducer")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1023071510:
                if (str.equals("PostprocessedBitmapMemoryCacheProducer")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1721672898:
                if (str.equals("DataFetchProducer")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1793127518:
                if (str.equals("LocalContentUriThumbnailFetchProducer")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2109593398:
                if (str.equals("PartialDiskCacheProducer")) {
                    c2 = TokenParser.CR;
                    break;
                }
                break;
            case 2113652014:
                if (str.equals("LocalContentUriFetchProducer")) {
                    c2 = 14;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
            case 3:
            case 6:
            case '\t':
            case 11:
            case '\f':
            case 14:
                return 6;
            case 1:
            case '\b':
            case '\n':
                return 5;
            case 4:
                return 4;
            case 5:
                return 2;
            case 7:
            case '\r':
                return 3;
            default:
                return 1;
        }
    }

    public static String b(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? "unknown" : "local" : "memory_bitmap" : "memory_encoded" : "disk" : "network";
    }
}