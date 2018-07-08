package android.support.v7.widget;

import android.view.View;

class fc {
    static int m4685a(ev evVar, C0352do c0352do, View view, View view2, eh ehVar, boolean z) {
        if (ehVar.m3731s() == 0 || evVar.m4610e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(ehVar.m3694d(view) - ehVar.m3694d(view2)) + 1;
        }
        return Math.min(c0352do.mo739f(), c0352do.mo733b(view2) - c0352do.mo731a(view));
    }

    static int m4686a(ev evVar, C0352do c0352do, View view, View view2, eh ehVar, boolean z, boolean z2) {
        if (ehVar.m3731s() == 0 || evVar.m4610e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (evVar.m4610e() - Math.max(ehVar.m3694d(view), ehVar.m3694d(view2))) - 1) : Math.max(0, Math.min(ehVar.m3694d(view), ehVar.m3694d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(c0352do.mo733b(view2) - c0352do.mo731a(view))) / ((float) (Math.abs(ehVar.m3694d(view) - ehVar.m3694d(view2)) + 1)))) + ((float) (c0352do.mo734c() - c0352do.mo731a(view))));
    }

    static int m4687b(ev evVar, C0352do c0352do, View view, View view2, eh ehVar, boolean z) {
        if (ehVar.m3731s() == 0 || evVar.m4610e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return evVar.m4610e();
        }
        return (int) ((((float) (c0352do.mo733b(view2) - c0352do.mo731a(view))) / ((float) (Math.abs(ehVar.m3694d(view) - ehVar.m3694d(view2)) + 1))) * ((float) evVar.m4610e()));
    }
}
