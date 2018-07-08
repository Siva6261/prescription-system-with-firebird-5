package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

class fg implements OnClickListener {
    final /* synthetic */ fd f2297a;

    private fg(fd fdVar) {
        this.f2297a = fdVar;
    }

    public void onClick(View view) {
        ((fh) view).m4698b().m3159d();
        int childCount = this.f2297a.f2289e.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f2297a.f2289e.getChildAt(i);
            childAt.setSelected(childAt == view);
        }
    }
}
