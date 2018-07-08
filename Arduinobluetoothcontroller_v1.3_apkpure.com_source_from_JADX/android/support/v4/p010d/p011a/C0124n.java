package android.support.v4.p010d.p011a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class C0124n {
    private static Method f819a;
    private static boolean f820b;
    private static Method f821c;
    private static boolean f822d;

    public static int m1432a(Drawable drawable) {
        if (!f822d) {
            try {
                f821c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f821c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f822d = true;
        }
        if (f821c != null) {
            try {
                return ((Integer) f821c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f821c = null;
            }
        }
        return -1;
    }

    public static void m1433a(Drawable drawable, int i) {
        if (!f820b) {
            try {
                f819a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f819a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f820b = true;
        }
        if (f819a != null) {
            try {
                f819a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f819a = null;
            }
        }
    }
}
