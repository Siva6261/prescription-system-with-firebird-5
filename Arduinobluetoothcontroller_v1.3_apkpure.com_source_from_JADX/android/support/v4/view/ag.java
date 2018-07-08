package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

class ag {
    static al m1854a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof ah ? ((ah) factory).f964a : null;
    }

    static void m1855a(LayoutInflater layoutInflater, al alVar) {
        layoutInflater.setFactory(alVar != null ? new ah(alVar) : null);
    }
}
