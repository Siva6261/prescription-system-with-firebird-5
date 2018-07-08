package android.support.v4.p006b;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.bn;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class ay extends bn {
    private final ak f677a;
    private az f678b = null;
    private ArrayList f679c = new ArrayList();
    private ArrayList f680d = new ArrayList();
    private C0051y f681e = null;

    public ay(ak akVar) {
        this.f677a = akVar;
    }

    public Parcelable mo187a() {
        Bundle bundle = null;
        if (this.f679c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new ab[this.f679c.size()];
            this.f679c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f680d.size(); i++) {
            C0051y c0051y = (C0051y) this.f680d.get(i);
            if (c0051y != null && c0051y.m878o()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f677a.mo182a(parcelable, "f" + i, c0051y);
            }
        }
        return parcelable;
    }

    public abstract C0051y mo838a(int i);

    public Object mo188a(ViewGroup viewGroup, int i) {
        if (this.f680d.size() > i) {
            C0051y c0051y = (C0051y) this.f680d.get(i);
            if (c0051y != null) {
                return c0051y;
            }
        }
        if (this.f678b == null) {
            this.f678b = this.f677a.mo178a();
        }
        C0051y a = mo838a(i);
        if (this.f679c.size() > i) {
            ab abVar = (ab) this.f679c.get(i);
            if (abVar != null) {
                a.m839a(abVar);
            }
        }
        while (this.f680d.size() <= i) {
            this.f680d.add(null);
        }
        a.m853c(false);
        a.m859d(false);
        this.f680d.set(i, a);
        this.f678b.mo203a(viewGroup.getId(), a);
        return a;
    }

    public void mo189a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f679c.clear();
            this.f680d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f679c.add((ab) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    C0051y a = this.f677a.mo179a(bundle, str);
                    if (a != null) {
                        while (this.f680d.size() <= parseInt) {
                            this.f680d.add(null);
                        }
                        a.m853c(false);
                        this.f680d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public void mo190a(ViewGroup viewGroup) {
    }

    public void mo191a(ViewGroup viewGroup, int i, Object obj) {
        C0051y c0051y = (C0051y) obj;
        if (this.f678b == null) {
            this.f678b = this.f677a.mo178a();
        }
        while (this.f679c.size() <= i) {
            this.f679c.add(null);
        }
        this.f679c.set(i, c0051y.m878o() ? this.f677a.mo177a(c0051y) : null);
        this.f680d.set(i, null);
        this.f678b.mo204a(c0051y);
    }

    public boolean mo192a(View view, Object obj) {
        return ((C0051y) obj).m880q() == view;
    }

    public void mo193b(ViewGroup viewGroup) {
        if (this.f678b != null) {
            this.f678b.mo206b();
            this.f678b = null;
            this.f677a.mo184b();
        }
    }

    public void mo194b(ViewGroup viewGroup, int i, Object obj) {
        C0051y c0051y = (C0051y) obj;
        if (c0051y != this.f681e) {
            if (this.f681e != null) {
                this.f681e.m853c(false);
                this.f681e.m859d(false);
            }
            if (c0051y != null) {
                c0051y.m853c(true);
                c0051y.m859d(true);
            }
            this.f681e = c0051y;
        }
    }
}
