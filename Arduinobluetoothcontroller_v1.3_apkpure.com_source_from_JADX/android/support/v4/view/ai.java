package android.support.v4.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

class ai {
    private static Field f965a;
    private static boolean f966b;

    static void m1856a(LayoutInflater layoutInflater, al alVar) {
        Factory2 ajVar = alVar != null ? new aj(alVar) : null;
        layoutInflater.setFactory2(ajVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            m1857a(layoutInflater, (Factory2) factory);
        } else {
            m1857a(layoutInflater, ajVar);
        }
    }

    static void m1857a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f966b) {
            try {
                f965a = LayoutInflater.class.getDeclaredField("mFactory2");
                f965a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f966b = true;
        }
        if (f965a != null) {
            try {
                f965a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
