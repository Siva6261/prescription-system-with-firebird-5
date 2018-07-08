package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class cb extends bz {
    static Field f986b;
    static boolean f987c = false;

    cb() {
    }

    public void mo341a(View view, C0209a c0209a) {
        cm.m2274a(view, c0209a == null ? null : c0209a.m1834a());
    }

    public void mo345a(View view, boolean z) {
        cm.m2275a(view, z);
    }

    public boolean mo346a(View view, int i) {
        return cm.m2276a(view, i);
    }

    public boolean mo350b(View view) {
        boolean z = true;
        if (f987c) {
            return false;
        }
        if (f986b == null) {
            try {
                f986b = View.class.getDeclaredField("mAccessibilityDelegate");
                f986b.setAccessible(true);
            } catch (Throwable th) {
                f987c = true;
                return false;
            }
        }
        try {
            if (f986b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            f987c = true;
            return false;
        }
    }

    public boolean mo351b(View view, int i) {
        return cm.m2277b(view, i);
    }

    public dy mo374r(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        dy dyVar = (dy) this.a.get(view);
        if (dyVar != null) {
            return dyVar;
        }
        dyVar = new dy(view);
        this.a.put(view, dyVar);
        return dyVar;
    }
}
