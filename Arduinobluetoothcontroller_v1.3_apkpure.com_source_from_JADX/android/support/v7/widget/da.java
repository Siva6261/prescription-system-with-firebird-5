package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class da implements OnItemSelectedListener {
    final /* synthetic */ cx f2165a;

    da(cx cxVar) {
        this.f2165a = cxVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i != -1) {
            db a = this.f2165a.f2021g;
            if (a != null) {
                a.f2175g = false;
            }
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
