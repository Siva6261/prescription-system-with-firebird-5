package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class aa {
    public static void m2594a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            ac.m2596a(listView, i);
        } else {
            ab.m2595a(listView, i);
        }
    }
}
