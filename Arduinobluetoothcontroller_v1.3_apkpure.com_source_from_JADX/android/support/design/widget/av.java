package android.support.design.widget;

import android.support.v4.view.bv;

class av extends ap {
    private boolean f356m;

    av(dh dhVar, bh bhVar) {
        super(dhVar, bhVar);
    }

    private void m590e(float f) {
        if (this.a != null) {
            this.a.m619a(-f);
        }
        if (this.d != null) {
            this.d.m912b(-f);
        }
    }

    void mo87a(ba baVar, boolean z) {
        if (this.f356m || this.k.getVisibility() != 0) {
            if (baVar != null) {
                baVar.mo74b();
            }
        } else if (!bv.m1994A(this.k) || this.k.isInEditMode()) {
            this.k.m436a(8, z);
            if (baVar != null) {
                baVar.mo74b();
            }
        } else {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0031a.f304c).setListener(new aw(this, z, baVar));
        }
    }

    void mo91b(ba baVar, boolean z) {
        if (!this.f356m && this.k.getVisibility() == 0) {
            return;
        }
        if (!bv.m1994A(this.k) || this.k.isInEditMode()) {
            this.k.m436a(0, z);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (baVar != null) {
                baVar.mo73a();
                return;
            }
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0031a.f305d).setListener(new ax(this, z, baVar));
    }

    boolean mo96d() {
        return true;
    }

    void mo97e() {
        m590e(this.k.getRotation());
    }
}
