package android.support.design.widget;

import android.support.v4.view.bv;
import android.view.View;

class C0060y implements C0041i {
    final /* synthetic */ CollapsingToolbarLayout f586a;

    private C0060y(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f586a = collapsingToolbarLayout;
    }

    public void mo159a(AppBarLayout appBarLayout, int i) {
        boolean z = false;
        this.f586a.f235t = i;
        int b = this.f586a.f236u != null ? this.f586a.f236u.mo416b() : 0;
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        int childCount = this.f586a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f586a.getChildAt(i2);
            C0059x c0059x = (C0059x) childAt.getLayoutParams();
            da a = CollapsingToolbarLayout.m382d(childAt);
            switch (c0059x.f584a) {
                case 1:
                    if ((this.f586a.getHeight() - b) + i < childAt.getHeight()) {
                        break;
                    }
                    a.m766a(-i);
                    break;
                case 2:
                    a.m766a(Math.round(c0059x.f585b * ((float) (-i))));
                    break;
                default:
                    break;
            }
        }
        if (!(this.f586a.f229n == null && this.f586a.f230o == null)) {
            CollapsingToolbarLayout collapsingToolbarLayout = this.f586a;
            if (this.f586a.getHeight() + i < this.f586a.getScrimTriggerOffset() + b) {
                z = true;
            }
            collapsingToolbarLayout.setScrimsShown(z);
        }
        if (this.f586a.f230o != null && b > 0) {
            bv.m2023d(this.f586a);
        }
        this.f586a.f226k.m928a(((float) Math.abs(i)) / ((float) ((this.f586a.getHeight() - bv.m2039p(this.f586a)) - b)));
        if (Math.abs(i) == totalScrollRange) {
            bv.m2024d((View) appBarLayout, appBarLayout.getTargetElevation());
        } else {
            bv.m2024d((View) appBarLayout, 0.0f);
        }
    }
}
