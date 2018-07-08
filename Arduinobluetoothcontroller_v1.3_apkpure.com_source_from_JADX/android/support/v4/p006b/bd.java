package android.support.v4.p006b;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class bd extends EpicenterCallback {
    final /* synthetic */ bf f693a;
    private Rect f694b;

    bd(bf bfVar) {
        this.f693a = bfVar;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.f694b == null && this.f693a.f706a != null) {
            this.f694b = ba.m1189c(this.f693a.f706a);
        }
        return this.f694b;
    }
}
