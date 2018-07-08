package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class cb {
    private final ArrayList f412a = new ArrayList();
    private cd f413b = null;
    private Animation f414c = null;
    private WeakReference f415d;
    private AnimationListener f416e = new cc(this);

    cb() {
    }

    private void m675a(cd cdVar) {
        this.f414c = cdVar.f419b;
        View a = m678a();
        if (a != null) {
            a.startAnimation(this.f414c);
        }
    }

    private void m676c() {
        View a = m678a();
        int size = this.f412a.size();
        for (int i = 0; i < size; i++) {
            if (a.getAnimation() == ((cd) this.f412a.get(i)).f419b) {
                a.clearAnimation();
            }
        }
        this.f415d = null;
        this.f413b = null;
        this.f414c = null;
    }

    private void m677d() {
        if (this.f414c != null) {
            View a = m678a();
            if (a != null && a.getAnimation() == this.f414c) {
                a.clearAnimation();
            }
            this.f414c = null;
        }
    }

    View m678a() {
        return this.f415d == null ? null : (View) this.f415d.get();
    }

    void m679a(View view) {
        View a = m678a();
        if (a != view) {
            if (a != null) {
                m676c();
            }
            if (view != null) {
                this.f415d = new WeakReference(view);
            }
        }
    }

    void m680a(int[] iArr) {
        cd cdVar = null;
        int size = this.f412a.size();
        for (int i = 0; i < size; i++) {
            cd cdVar2 = (cd) this.f412a.get(i);
            if (StateSet.stateSetMatches(cdVar2.f418a, iArr)) {
                cdVar = cdVar2;
                break;
            }
        }
        if (cdVar != this.f413b) {
            if (this.f413b != null) {
                m677d();
            }
            this.f413b = cdVar;
            View view = (View) this.f415d.get();
            if (cdVar != null && view != null && view.getVisibility() == 0) {
                m675a(cdVar);
            }
        }
    }

    public void m681a(int[] iArr, Animation animation) {
        cd cdVar = new cd(iArr, animation);
        animation.setAnimationListener(this.f416e);
        this.f412a.add(cdVar);
    }

    public void m682b() {
        if (this.f414c != null) {
            View a = m678a();
            if (a != null && a.getAnimation() == this.f414c) {
                a.clearAnimation();
            }
        }
    }
}
