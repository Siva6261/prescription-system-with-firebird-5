package com.giumig.apps.bluetoothcontroller;

import android.support.v4.view.dm;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class bc implements dm {
    private List f2690a = new ArrayList();

    private void m5203a(View view, float f, int i, bd bdVar, boolean z) {
        if (bdVar.m5206a() && view.findViewById(bdVar.f2691a) != null) {
            if (z && !bdVar.m5207b()) {
                view.findViewById(bdVar.f2691a).setTranslationX((-f) * (((float) i) / bdVar.f2692b));
            } else if (!z && !bdVar.m5208c()) {
                view.findViewById(bdVar.f2691a).setTranslationX((-f) * (((float) i) / bdVar.f2693c));
            }
        }
    }

    public bc m5204a(bd bdVar) {
        if (this.f2690a != null) {
            this.f2690a.add(bdVar);
        }
        return this;
    }

    public void mo834a(View view, float f) {
        int width = view.getWidth();
        if (f < -1.0f) {
            view.setAlpha(1.0f);
        } else if (f > 1.0f || this.f2690a == null) {
            view.setAlpha(1.0f);
        } else {
            for (bd a : this.f2690a) {
                m5203a(view, f, width, a, f > 0.0f);
            }
        }
    }
}
