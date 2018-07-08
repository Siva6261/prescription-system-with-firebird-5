package android.support.v4.view;

import android.view.View;

class el {
    public static void m2448a(View view, ep epVar) {
        if (epVar != null) {
            view.animate().setListener(new em(epVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
