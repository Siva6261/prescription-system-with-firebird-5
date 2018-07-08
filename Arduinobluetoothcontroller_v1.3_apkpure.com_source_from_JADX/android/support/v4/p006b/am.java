package android.support.v4.p006b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p015h.C0170d;
import android.support.v4.p015h.C0171e;
import android.support.v4.view.al;
import android.support.v4.view.bv;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class am extends ak implements al {
    static final Interpolator f619A = new DecelerateInterpolator(2.5f);
    static final Interpolator f620B = new DecelerateInterpolator(1.5f);
    static final Interpolator f621C = new AccelerateInterpolator(2.5f);
    static final Interpolator f622D = new AccelerateInterpolator(1.5f);
    static boolean f623a = false;
    static final boolean f624b;
    static Field f625r = null;
    ArrayList f626c;
    Runnable[] f627d;
    boolean f628e;
    ArrayList f629f;
    ArrayList f630g;
    ArrayList f631h;
    ArrayList f632i;
    ArrayList f633j;
    ArrayList f634k;
    ArrayList f635l;
    ArrayList f636m;
    int f637n = 0;
    aj f638o;
    ah f639p;
    C0051y f640q;
    boolean f641s;
    boolean f642t;
    boolean f643u;
    String f644v;
    boolean f645w;
    Bundle f646x = null;
    SparseArray f647y = null;
    Runnable f648z = new an(this);

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f624b = z;
    }

    am() {
    }

    static Animation m1062a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f620B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m1063a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f619A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f620B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m1064a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0171e("FragmentManager"));
        if (this.f638o != null) {
            try {
                this.f638o.mo170a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo183a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    static boolean m1065a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && bv.m2030g(view) == 0 && bv.m2045v(view) && am.m1066a(animation);
    }

    static boolean m1066a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int m1067b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void m1068b(View view, Animation animation) {
        if (view != null && animation != null && am.m1065a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f625r == null) {
                    f625r = Animation.class.getDeclaredField("mListener");
                    f625r.setAccessible(true);
                }
                animationListener = (AnimationListener) f625r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new aq(view, animation, animationListener));
        }
    }

    public static int m1069c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m1070u() {
        if (this.f642t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f644v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f644v);
        }
    }

    public int m1071a(C0084n c0084n) {
        int size;
        synchronized (this) {
            if (this.f635l == null || this.f635l.size() <= 0) {
                if (this.f634k == null) {
                    this.f634k = new ArrayList();
                }
                size = this.f634k.size();
                if (f623a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0084n);
                }
                this.f634k.add(c0084n);
            } else {
                size = ((Integer) this.f635l.remove(this.f635l.size() - 1)).intValue();
                if (f623a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0084n);
                }
                this.f634k.set(size, c0084n);
            }
        }
        return size;
    }

    public ab mo177a(C0051y c0051y) {
        if (c0051y.f505p < 0) {
            m1064a(new IllegalStateException("Fragment " + c0051y + " is not currently in the FragmentManager"));
        }
        if (c0051y.f500k <= 0) {
            return null;
        }
        Bundle g = m1115g(c0051y);
        return g != null ? new ab(g) : null;
    }

    public az mo178a() {
        return new C0084n(this);
    }

    public C0051y m1074a(int i) {
        int size;
        C0051y c0051y;
        if (this.f630g != null) {
            for (size = this.f630g.size() - 1; size >= 0; size--) {
                c0051y = (C0051y) this.f630g.get(size);
                if (c0051y != null && c0051y.f479F == i) {
                    return c0051y;
                }
            }
        }
        if (this.f629f != null) {
            for (size = this.f629f.size() - 1; size >= 0; size--) {
                c0051y = (C0051y) this.f629f.get(size);
                if (c0051y != null && c0051y.f479F == i) {
                    return c0051y;
                }
            }
        }
        return null;
    }

    public C0051y mo179a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f629f.size()) {
            m1064a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        C0051y c0051y = (C0051y) this.f629f.get(i);
        if (c0051y != null) {
            return c0051y;
        }
        m1064a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return c0051y;
    }

    public C0051y m1076a(String str) {
        int size;
        C0051y c0051y;
        if (!(this.f630g == null || str == null)) {
            for (size = this.f630g.size() - 1; size >= 0; size--) {
                c0051y = (C0051y) this.f630g.get(size);
                if (c0051y != null && str.equals(c0051y.f481H)) {
                    return c0051y;
                }
            }
        }
        if (!(this.f629f == null || str == null)) {
            for (size = this.f629f.size() - 1; size >= 0; size--) {
                c0051y = (C0051y) this.f629f.get(size);
                if (c0051y != null && str.equals(c0051y.f481H)) {
                    return c0051y;
                }
            }
        }
        return null;
    }

    public View mo180a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, at.f660a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C0051y.m811b(this.f638o.m1000g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        C0051y c0051y;
        C0051y a = resourceId != -1 ? m1074a(resourceId) : null;
        if (a == null && string2 != null) {
            a = m1076a(string2);
        }
        if (a == null && id != -1) {
            a = m1074a(id);
        }
        if (f623a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            C0051y a2 = C0051y.m809a(context, string);
            a2.f513x = true;
            a2.f479F = resourceId != 0 ? resourceId : id;
            a2.f480G = id;
            a2.f481H = string2;
            a2.f514y = true;
            a2.f475B = this;
            a2.f476C = this.f638o;
            a2.m835a(this.f638o.m1000g(), attributeSet, a2.f503n);
            m1089a(a2, true);
            c0051y = a2;
        } else if (a.f514y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f514y = true;
            a.f476C = this.f638o;
            if (!a.f485L) {
                a.m835a(this.f638o.m1000g(), attributeSet, a.f503n);
            }
            c0051y = a;
        }
        if (this.f637n >= 1 || !c0051y.f513x) {
            m1104c(c0051y);
        } else {
            m1088a(c0051y, 1, 0, 0, false);
        }
        if (c0051y.f491R == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            c0051y.f491R.setId(resourceId);
        }
        if (c0051y.f491R.getTag() == null) {
            c0051y.f491R.setTag(string2);
        }
        return c0051y.f491R;
    }

    Animation m1078a(C0051y c0051y, int i, boolean z, int i2) {
        Animation a = c0051y.m827a(i, z, c0051y.f489P);
        if (a != null) {
            return a;
        }
        if (c0051y.f489P != 0) {
            a = AnimationUtils.loadAnimation(this.f638o.m1000g(), c0051y.f489P);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = am.m1067b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return am.m1063a(this.f638o.m1000g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return am.m1063a(this.f638o.m1000g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return am.m1063a(this.f638o.m1000g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return am.m1063a(this.f638o.m1000g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return am.m1062a(this.f638o.m1000g(), 0.0f, 1.0f);
            case 6:
                return am.m1062a(this.f638o.m1000g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f638o.mo175d()) {
                    i2 = this.f638o.mo176e();
                }
                return i2 == 0 ? null : null;
        }
    }

    public void mo181a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m1090a(new ao(this, i, i2), false);
    }

    void m1080a(int i, int i2, int i3, boolean z) {
        if (this.f638o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f637n != i) {
            this.f637n = i;
            if (this.f629f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f629f.size()) {
                    int a;
                    C0051y c0051y = (C0051y) this.f629f.get(i4);
                    if (c0051y != null) {
                        m1088a(c0051y, i, i2, i3, false);
                        if (c0051y.f495V != null) {
                            a = i5 | c0051y.f495V.mo195a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m1107d();
                }
                if (this.f641s && this.f638o != null && this.f637n == 5) {
                    this.f638o.mo174c();
                    this.f641s = false;
                }
            }
        }
    }

    public void m1081a(int i, C0084n c0084n) {
        synchronized (this) {
            if (this.f634k == null) {
                this.f634k = new ArrayList();
            }
            int size = this.f634k.size();
            if (i < size) {
                if (f623a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0084n);
                }
                this.f634k.set(i, c0084n);
            } else {
                while (size < i) {
                    this.f634k.add(null);
                    if (this.f635l == null) {
                        this.f635l = new ArrayList();
                    }
                    if (f623a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f635l.add(Integer.valueOf(size));
                    size++;
                }
                if (f623a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0084n);
                }
                this.f634k.add(c0084n);
            }
        }
    }

    void m1082a(int i, boolean z) {
        m1080a(i, 0, 0, z);
    }

    public void m1083a(Configuration configuration) {
        if (this.f630g != null) {
            for (int i = 0; i < this.f630g.size(); i++) {
                C0051y c0051y = (C0051y) this.f630g.get(i);
                if (c0051y != null) {
                    c0051y.m838a(configuration);
                }
            }
        }
    }

    public void mo182a(Bundle bundle, String str, C0051y c0051y) {
        if (c0051y.f505p < 0) {
            m1064a(new IllegalStateException("Fragment " + c0051y + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, c0051y.f505p);
    }

    void m1085a(Parcelable parcelable, List list) {
        if (parcelable != null) {
            au auVar = (au) parcelable;
            if (auVar.f661a != null) {
                int i;
                C0051y c0051y;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        c0051y = (C0051y) list.get(i);
                        if (f623a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0051y);
                        }
                        aw awVar = auVar.f661a[c0051y.f505p];
                        awVar.f674k = c0051y;
                        c0051y.f504o = null;
                        c0051y.f474A = 0;
                        c0051y.f514y = false;
                        c0051y.f511v = false;
                        c0051y.f508s = null;
                        if (awVar.f673j != null) {
                            awVar.f673j.setClassLoader(this.f638o.m1000g().getClassLoader());
                            c0051y.f504o = awVar.f673j.getSparseParcelableArray("android:view_state");
                            c0051y.f503n = awVar.f673j;
                        }
                    }
                }
                this.f629f = new ArrayList(auVar.f661a.length);
                if (this.f631h != null) {
                    this.f631h.clear();
                }
                for (i2 = 0; i2 < auVar.f661a.length; i2++) {
                    aw awVar2 = auVar.f661a[i2];
                    if (awVar2 != null) {
                        C0051y a = awVar2.m1133a(this.f638o, this.f640q);
                        if (f623a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f629f.add(a);
                        awVar2.f674k = null;
                    } else {
                        this.f629f.add(null);
                        if (this.f631h == null) {
                            this.f631h = new ArrayList();
                        }
                        if (f623a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f631h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        c0051y = (C0051y) list.get(i3);
                        if (c0051y.f509t >= 0) {
                            if (c0051y.f509t < this.f629f.size()) {
                                c0051y.f508s = (C0051y) this.f629f.get(c0051y.f509t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0051y + " target no longer exists: " + c0051y.f509t);
                                c0051y.f508s = null;
                            }
                        }
                    }
                }
                if (auVar.f662b != null) {
                    this.f630g = new ArrayList(auVar.f662b.length);
                    for (i = 0; i < auVar.f662b.length; i++) {
                        c0051y = (C0051y) this.f629f.get(auVar.f662b[i]);
                        if (c0051y == null) {
                            m1064a(new IllegalStateException("No instantiated fragment for index #" + auVar.f662b[i]));
                        }
                        c0051y.f511v = true;
                        if (f623a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + c0051y);
                        }
                        if (this.f630g.contains(c0051y)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f630g.add(c0051y);
                    }
                } else {
                    this.f630g = null;
                }
                if (auVar.f663c != null) {
                    this.f632i = new ArrayList(auVar.f663c.length);
                    for (i2 = 0; i2 < auVar.f663c.length; i2++) {
                        C0084n a2 = auVar.f663c[i2].m1303a(this);
                        if (f623a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f750p + "): " + a2);
                            a2.m1299a("  ", new PrintWriter(new C0171e("FragmentManager")), false);
                        }
                        this.f632i.add(a2);
                        if (a2.f750p >= 0) {
                            m1081a(a2.f750p, a2);
                        }
                    }
                    return;
                }
                this.f632i = null;
            }
        }
    }

    public void m1086a(aj ajVar, ah ahVar, C0051y c0051y) {
        if (this.f638o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f638o = ajVar;
        this.f639p = ahVar;
        this.f640q = c0051y;
    }

    public void m1087a(C0051y c0051y, int i, int i2) {
        if (f623a) {
            Log.v("FragmentManager", "remove: " + c0051y + " nesting=" + c0051y.f474A);
        }
        boolean z = !c0051y.m866g();
        if (!c0051y.f483J || z) {
            if (this.f630g != null) {
                this.f630g.remove(c0051y);
            }
            if (c0051y.f486M && c0051y.f487N) {
                this.f641s = true;
            }
            c0051y.f511v = false;
            c0051y.f512w = true;
            m1088a(c0051y, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1088a(android.support.v4.p006b.C0051y r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f511v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f483J;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f512w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f500k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f500k;
    L_0x001a:
        r0 = r11.f493T;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f500k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f500k;
        if (r0 >= r12) goto L_0x02aa;
    L_0x0029:
        r0 = r11.f513x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f514y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f501l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f501l = r7;
        r2 = r11.f502m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m1088a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f500k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x0247;
            case 3: goto L_0x0247;
            case 4: goto L_0x0268;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f500k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f500k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f500k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f623a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.f503n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.f503n;
        r1 = r10.f638o;
        r1 = r1.m1000g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f503n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f504o = r0;
        r0 = r11.f503n;
        r1 = "android:target_state";
        r0 = r10.mo179a(r0, r1);
        r11.f508s = r0;
        r0 = r11.f508s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.f503n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f510u = r0;
    L_0x00d1:
        r0 = r11.f503n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f494U = r0;
        r0 = r11.f494U;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.f493T = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f638o;
        r11.f476C = r0;
        r0 = r10.f640q;
        r11.f478E = r0;
        r0 = r10.f640q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f640q;
        r0 = r0.f477D;
    L_0x00f4:
        r11.f475B = r0;
        r11.f488O = r3;
        r0 = r10.f638o;
        r0 = r0.m1000g();
        r11.m834a(r0);
        r0 = r11.f488O;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.b.bs;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f638o;
        r0 = r0.m1002i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.f478E;
        if (r0 != 0) goto L_0x0134;
    L_0x012f:
        r0 = r10.f638o;
        r0.mo173b(r11);
    L_0x0134:
        r0 = r11.f485L;
        if (r0 != 0) goto L_0x013d;
    L_0x0138:
        r0 = r11.f503n;
        r11.m870i(r0);
    L_0x013d:
        r11.f485L = r3;
        r0 = r11.f513x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.f503n;
        r0 = r11.mo150c(r0);
        r1 = r11.f503n;
        r0 = r11.m845b(r0, r7, r1);
        r11.f491R = r0;
        r0 = r11.f491R;
        if (r0 == 0) goto L_0x0299;
    L_0x0155:
        r0 = r11.f491R;
        r11.f492S = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x028f;
    L_0x015f:
        r0 = r11.f491R;
        android.support.v4.view.bv.m2016b(r0, r3);
    L_0x0164:
        r0 = r11.f482I;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.f491R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.f491R;
        r1 = r11.f503n;
        r11.m842a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x0247;
    L_0x0178:
        r0 = f623a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.f513x;
        if (r0 != 0) goto L_0x0237;
    L_0x0198:
        r0 = r11.f480G;
        if (r0 == 0) goto L_0x0408;
    L_0x019c:
        r0 = r10.f639p;
        r1 = r11.f480G;
        r0 = r0.mo167a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01eb;
    L_0x01a8:
        r1 = r11.f515z;
        if (r1 != 0) goto L_0x01eb;
    L_0x01ac:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f480G;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m875l();
        r8 = r11.f480G;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m1064a(r1);
    L_0x01eb:
        r11.f490Q = r0;
        r1 = r11.f503n;
        r1 = r11.mo150c(r1);
        r2 = r11.f503n;
        r1 = r11.m845b(r1, r0, r2);
        r11.f491R = r1;
        r1 = r11.f491R;
        if (r1 == 0) goto L_0x02a7;
    L_0x01ff:
        r1 = r11.f491R;
        r11.f492S = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x029d;
    L_0x0209:
        r1 = r11.f491R;
        android.support.v4.view.bv.m2016b(r1, r3);
    L_0x020e:
        if (r0 == 0) goto L_0x0225;
    L_0x0210:
        r1 = r10.m1078a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0220;
    L_0x0216:
        r2 = r11.f491R;
        r10.m1068b(r2, r1);
        r2 = r11.f491R;
        r2.startAnimation(r1);
    L_0x0220:
        r1 = r11.f491R;
        r0.addView(r1);
    L_0x0225:
        r0 = r11.f482I;
        if (r0 == 0) goto L_0x0230;
    L_0x0229:
        r0 = r11.f491R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0230:
        r0 = r11.f491R;
        r1 = r11.f503n;
        r11.m842a(r0, r1);
    L_0x0237:
        r0 = r11.f503n;
        r11.m872j(r0);
        r0 = r11.f491R;
        if (r0 == 0) goto L_0x0245;
    L_0x0240:
        r0 = r11.f503n;
        r11.m864f(r0);
    L_0x0245:
        r11.f503n = r7;
    L_0x0247:
        if (r12 <= r6) goto L_0x0268;
    L_0x0249:
        r0 = f623a;
        if (r0 == 0) goto L_0x0265;
    L_0x024d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0265:
        r11.m817F();
    L_0x0268:
        if (r12 <= r9) goto L_0x0045;
    L_0x026a:
        r0 = f623a;
        if (r0 == 0) goto L_0x0286;
    L_0x026e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0286:
        r11.m818G();
        r11.f503n = r7;
        r11.f504o = r7;
        goto L_0x0045;
    L_0x028f:
        r0 = r11.f491R;
        r0 = android.support.v4.p006b.bq.m1237a(r0);
        r11.f491R = r0;
        goto L_0x0164;
    L_0x0299:
        r11.f492S = r7;
        goto L_0x0176;
    L_0x029d:
        r1 = r11.f491R;
        r1 = android.support.v4.p006b.bq.m1237a(r1);
        r11.f491R = r1;
        goto L_0x020e;
    L_0x02a7:
        r11.f492S = r7;
        goto L_0x0237;
    L_0x02aa:
        r0 = r11.f500k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ae:
        r0 = r11.f500k;
        switch(r0) {
            case 1: goto L_0x02b5;
            case 2: goto L_0x0333;
            case 3: goto L_0x0312;
            case 4: goto L_0x02f1;
            case 5: goto L_0x02cf;
            default: goto L_0x02b3;
        };
    L_0x02b3:
        goto L_0x0045;
    L_0x02b5:
        if (r12 >= r5) goto L_0x0045;
    L_0x02b7:
        r0 = r10.f643u;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bb:
        r0 = r11.f501l;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bf:
        r0 = r11.f501l;
        r11.f501l = r7;
        r0.clearAnimation();
    L_0x02c6:
        r0 = r11.f501l;
        if (r0 == 0) goto L_0x03a2;
    L_0x02ca:
        r11.f502m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x02cf:
        r0 = 5;
        if (r12 >= r0) goto L_0x02f1;
    L_0x02d2:
        r0 = f623a;
        if (r0 == 0) goto L_0x02ee;
    L_0x02d6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ee:
        r11.m820I();
    L_0x02f1:
        if (r12 >= r9) goto L_0x0312;
    L_0x02f3:
        r0 = f623a;
        if (r0 == 0) goto L_0x030f;
    L_0x02f7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030f:
        r11.m821J();
    L_0x0312:
        if (r12 >= r6) goto L_0x0333;
    L_0x0314:
        r0 = f623a;
        if (r0 == 0) goto L_0x0330;
    L_0x0318:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0330:
        r11.m822K();
    L_0x0333:
        r0 = 2;
        if (r12 >= r0) goto L_0x02b5;
    L_0x0336:
        r0 = f623a;
        if (r0 == 0) goto L_0x0352;
    L_0x033a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0352:
        r0 = r11.f491R;
        if (r0 == 0) goto L_0x0365;
    L_0x0356:
        r0 = r10.f638o;
        r0 = r0.mo171a(r11);
        if (r0 == 0) goto L_0x0365;
    L_0x035e:
        r0 = r11.f504o;
        if (r0 != 0) goto L_0x0365;
    L_0x0362:
        r10.m1114f(r11);
    L_0x0365:
        r11.m823L();
        r0 = r11.f491R;
        if (r0 == 0) goto L_0x039a;
    L_0x036c:
        r0 = r11.f490Q;
        if (r0 == 0) goto L_0x039a;
    L_0x0370:
        r0 = r10.f637n;
        if (r0 <= 0) goto L_0x0405;
    L_0x0374:
        r0 = r10.f643u;
        if (r0 != 0) goto L_0x0405;
    L_0x0378:
        r0 = r10.m1078a(r11, r13, r3, r14);
    L_0x037c:
        if (r0 == 0) goto L_0x0393;
    L_0x037e:
        r1 = r11.f491R;
        r11.f501l = r1;
        r11.f502m = r12;
        r1 = r11.f491R;
        r2 = new android.support.v4.b.ap;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f491R;
        r1.startAnimation(r0);
    L_0x0393:
        r0 = r11.f490Q;
        r1 = r11.f491R;
        r0.removeView(r1);
    L_0x039a:
        r11.f490Q = r7;
        r11.f491R = r7;
        r11.f492S = r7;
        goto L_0x02b5;
    L_0x03a2:
        r0 = f623a;
        if (r0 == 0) goto L_0x03be;
    L_0x03a6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03be:
        r0 = r11.f485L;
        if (r0 != 0) goto L_0x03ed;
    L_0x03c2:
        r11.m824M();
    L_0x03c5:
        r11.f488O = r3;
        r11.mo151c();
        r0 = r11.f488O;
        if (r0 != 0) goto L_0x03f0;
    L_0x03ce:
        r0 = new android.support.v4.b.bs;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ed:
        r11.f500k = r3;
        goto L_0x03c5;
    L_0x03f0:
        if (r15 != 0) goto L_0x0045;
    L_0x03f2:
        r0 = r11.f485L;
        if (r0 != 0) goto L_0x03fb;
    L_0x03f6:
        r10.m1110e(r11);
        goto L_0x0045;
    L_0x03fb:
        r11.f476C = r7;
        r11.f478E = r7;
        r11.f475B = r7;
        r11.f477D = r7;
        goto L_0x0045;
    L_0x0405:
        r0 = r7;
        goto L_0x037c;
    L_0x0408:
        r0 = r7;
        goto L_0x01eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.am.a(android.support.v4.b.y, int, int, int, boolean):void");
    }

    public void m1089a(C0051y c0051y, boolean z) {
        if (this.f630g == null) {
            this.f630g = new ArrayList();
        }
        if (f623a) {
            Log.v("FragmentManager", "add: " + c0051y);
        }
        m1108d(c0051y);
        if (!c0051y.f483J) {
            if (this.f630g.contains(c0051y)) {
                throw new IllegalStateException("Fragment already added: " + c0051y);
            }
            this.f630g.add(c0051y);
            c0051y.f511v = true;
            c0051y.f512w = false;
            if (c0051y.f486M && c0051y.f487N) {
                this.f641s = true;
            }
            if (z) {
                m1104c(c0051y);
            }
        }
    }

    public void m1090a(Runnable runnable, boolean z) {
        if (!z) {
            m1070u();
        }
        synchronized (this) {
            if (this.f643u || this.f638o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f626c == null) {
                this.f626c = new ArrayList();
            }
            this.f626c.add(runnable);
            if (this.f626c.size() == 1) {
                this.f638o.m1001h().removeCallbacks(this.f648z);
                this.f638o.m1001h().post(this.f648z);
            }
        }
    }

    public void mo183a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        C0051y c0051y;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f629f != null) {
            size = this.f629f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c0051y = (C0051y) this.f629f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0051y);
                    if (c0051y != null) {
                        c0051y.m843a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f630g != null) {
            size = this.f630g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    c0051y = (C0051y) this.f630g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0051y.toString());
                }
            }
        }
        if (this.f633j != null) {
            size = this.f633j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0051y = (C0051y) this.f633j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0051y.toString());
                }
            }
        }
        if (this.f632i != null) {
            size = this.f632i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0084n c0084n = (C0084n) this.f632i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0084n.toString());
                    c0084n.m1298a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f634k != null) {
                int size2 = this.f634k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0084n = (C0084n) this.f634k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0084n);
                    }
                }
            }
            if (this.f635l != null && this.f635l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f635l.toArray()));
            }
        }
        if (this.f626c != null) {
            i = this.f626c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f626c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f638o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f639p);
        if (this.f640q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f640q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f637n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f642t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f643u);
        if (this.f641s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f641s);
        }
        if (this.f644v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f644v);
        }
        if (this.f631h != null && this.f631h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f631h.toArray()));
        }
    }

    boolean m1092a(Handler handler, String str, int i, int i2) {
        if (this.f632i == null) {
            return false;
        }
        int size;
        C0084n c0084n;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f632i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0084n = (C0084n) this.f632i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            c0084n.m1297a(sparseArray, sparseArray2);
            c0084n.m1294a(true, null, sparseArray, sparseArray2);
            m1113f();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f632i.size() - 1;
                while (size2 >= 0) {
                    c0084n = (C0084n) this.f632i.get(size2);
                    if ((str != null && str.equals(c0084n.m1301c())) || (i >= 0 && i == c0084n.f750p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0084n = (C0084n) this.f632i.get(size2);
                        if ((str == null || !str.equals(c0084n.m1301c())) && (i < 0 || i != c0084n.f750p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f632i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f632i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f632i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (size2 = 0; size2 <= size3; size2++) {
                ((C0084n) arrayList.get(size2)).m1297a(sparseArray3, sparseArray4);
            }
            C0089s c0089s = null;
            int i3 = 0;
            while (i3 <= size3) {
                if (f623a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                i3++;
                c0089s = ((C0084n) arrayList.get(i3)).m1294a(i3 == size3, c0089s, sparseArray3, sparseArray4);
            }
            m1113f();
        }
        return true;
    }

    public boolean m1093a(Menu menu) {
        if (this.f630g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f630g.size(); i++) {
            C0051y c0051y = (C0051y) this.f630g.get(i);
            if (c0051y != null && c0051y.m854c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m1094a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        C0051y c0051y;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f630g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f630g.size()) {
                c0051y = (C0051y) this.f630g.get(i2);
                if (c0051y != null && c0051y.m849b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0051y);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f633j != null) {
            while (i < this.f633j.size()) {
                c0051y = (C0051y) this.f633j.get(i);
                if (arrayList == null || !arrayList.contains(c0051y)) {
                    c0051y.m885v();
                }
                i++;
            }
        }
        this.f633j = arrayList;
        return z;
    }

    public boolean m1095a(MenuItem menuItem) {
        if (this.f630g == null) {
            return false;
        }
        for (int i = 0; i < this.f630g.size(); i++) {
            C0051y c0051y = (C0051y) this.f630g.get(i);
            if (c0051y != null && c0051y.m855c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public C0051y m1096b(String str) {
        if (!(this.f629f == null || str == null)) {
            for (int size = this.f629f.size() - 1; size >= 0; size--) {
                C0051y c0051y = (C0051y) this.f629f.get(size);
                if (c0051y != null) {
                    c0051y = c0051y.m825a(str);
                    if (c0051y != null) {
                        return c0051y;
                    }
                }
            }
        }
        return null;
    }

    public void m1097b(int i) {
        synchronized (this) {
            this.f634k.set(i, null);
            if (this.f635l == null) {
                this.f635l = new ArrayList();
            }
            if (f623a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f635l.add(Integer.valueOf(i));
        }
    }

    void m1098b(C0084n c0084n) {
        if (this.f632i == null) {
            this.f632i = new ArrayList();
        }
        this.f632i.add(c0084n);
        m1113f();
    }

    public void m1099b(C0051y c0051y) {
        if (!c0051y.f493T) {
            return;
        }
        if (this.f628e) {
            this.f645w = true;
            return;
        }
        c0051y.f493T = false;
        m1088a(c0051y, this.f637n, 0, 0, false);
    }

    public void m1100b(C0051y c0051y, int i, int i2) {
        if (f623a) {
            Log.v("FragmentManager", "hide: " + c0051y);
        }
        if (!c0051y.f482I) {
            c0051y.f482I = true;
            if (c0051y.f491R != null) {
                Animation a = m1078a(c0051y, i, false, i2);
                if (a != null) {
                    m1068b(c0051y.f491R, a);
                    c0051y.f491R.startAnimation(a);
                }
                c0051y.f491R.setVisibility(8);
            }
            if (c0051y.f511v && c0051y.f486M && c0051y.f487N) {
                this.f641s = true;
            }
            c0051y.m848b(true);
        }
    }

    public void m1101b(Menu menu) {
        if (this.f630g != null) {
            for (int i = 0; i < this.f630g.size(); i++) {
                C0051y c0051y = (C0051y) this.f630g.get(i);
                if (c0051y != null) {
                    c0051y.m858d(menu);
                }
            }
        }
    }

    public boolean mo184b() {
        return m1112e();
    }

    public boolean m1103b(MenuItem menuItem) {
        if (this.f630g == null) {
            return false;
        }
        for (int i = 0; i < this.f630g.size(); i++) {
            C0051y c0051y = (C0051y) this.f630g.get(i);
            if (c0051y != null && c0051y.m860d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m1104c(C0051y c0051y) {
        m1088a(c0051y, this.f637n, 0, 0, false);
    }

    public void m1105c(C0051y c0051y, int i, int i2) {
        if (f623a) {
            Log.v("FragmentManager", "show: " + c0051y);
        }
        if (c0051y.f482I) {
            c0051y.f482I = false;
            if (c0051y.f491R != null) {
                Animation a = m1078a(c0051y, i, true, i2);
                if (a != null) {
                    m1068b(c0051y.f491R, a);
                    c0051y.f491R.startAnimation(a);
                }
                c0051y.f491R.setVisibility(0);
            }
            if (c0051y.f511v && c0051y.f486M && c0051y.f487N) {
                this.f641s = true;
            }
            c0051y.m848b(false);
        }
    }

    public boolean mo185c() {
        m1070u();
        mo184b();
        return m1092a(this.f638o.m1001h(), null, -1, 0);
    }

    void m1107d() {
        if (this.f629f != null) {
            for (int i = 0; i < this.f629f.size(); i++) {
                C0051y c0051y = (C0051y) this.f629f.get(i);
                if (c0051y != null) {
                    m1099b(c0051y);
                }
            }
        }
    }

    void m1108d(C0051y c0051y) {
        if (c0051y.f505p < 0) {
            if (this.f631h == null || this.f631h.size() <= 0) {
                if (this.f629f == null) {
                    this.f629f = new ArrayList();
                }
                c0051y.m830a(this.f629f.size(), this.f640q);
                this.f629f.add(c0051y);
            } else {
                c0051y.m830a(((Integer) this.f631h.remove(this.f631h.size() - 1)).intValue(), this.f640q);
                this.f629f.set(c0051y.f505p, c0051y);
            }
            if (f623a) {
                Log.v("FragmentManager", "Allocated fragment index " + c0051y);
            }
        }
    }

    public void m1109d(C0051y c0051y, int i, int i2) {
        if (f623a) {
            Log.v("FragmentManager", "detach: " + c0051y);
        }
        if (!c0051y.f483J) {
            c0051y.f483J = true;
            if (c0051y.f511v) {
                if (this.f630g != null) {
                    if (f623a) {
                        Log.v("FragmentManager", "remove from detach: " + c0051y);
                    }
                    this.f630g.remove(c0051y);
                }
                if (c0051y.f486M && c0051y.f487N) {
                    this.f641s = true;
                }
                c0051y.f511v = false;
                m1088a(c0051y, 1, i, i2, false);
            }
        }
    }

    void m1110e(C0051y c0051y) {
        if (c0051y.f505p >= 0) {
            if (f623a) {
                Log.v("FragmentManager", "Freeing fragment index " + c0051y);
            }
            this.f629f.set(c0051y.f505p, null);
            if (this.f631h == null) {
                this.f631h = new ArrayList();
            }
            this.f631h.add(Integer.valueOf(c0051y.f505p));
            this.f638o.m988a(c0051y.f506q);
            c0051y.m884u();
        }
    }

    public void m1111e(C0051y c0051y, int i, int i2) {
        if (f623a) {
            Log.v("FragmentManager", "attach: " + c0051y);
        }
        if (c0051y.f483J) {
            c0051y.f483J = false;
            if (!c0051y.f511v) {
                if (this.f630g == null) {
                    this.f630g = new ArrayList();
                }
                if (this.f630g.contains(c0051y)) {
                    throw new IllegalStateException("Fragment already added: " + c0051y);
                }
                if (f623a) {
                    Log.v("FragmentManager", "add from attach: " + c0051y);
                }
                this.f630g.add(c0051y);
                c0051y.f511v = true;
                if (c0051y.f486M && c0051y.f487N) {
                    this.f641s = true;
                }
                m1088a(c0051y, this.f637n, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1112e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f628e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f638o;
        r3 = r3.m1001h();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f626c;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f626c;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.f645w;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f629f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.f629f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.p006b.C0051y) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.f495V;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.f495V;
        r0 = r0.mo195a();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.f626c;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.f627d;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.f627d;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.f627d = r1;	 Catch:{ all -> 0x009b }
    L_0x006f:
        r1 = r6.f626c;	 Catch:{ all -> 0x009b }
        r4 = r6.f627d;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.f626c;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.f638o;	 Catch:{ all -> 0x009b }
        r1 = r1.m1001h();	 Catch:{ all -> 0x009b }
        r4 = r6.f648z;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.f628e = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.f627d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f627d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.f628e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.f645w = r2;
        r6.m1107d();
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.am.e():boolean");
    }

    void m1113f() {
        if (this.f636m != null) {
            for (int i = 0; i < this.f636m.size(); i++) {
                ((al) this.f636m.get(i)).m1060a();
            }
        }
    }

    void m1114f(C0051y c0051y) {
        if (c0051y.f492S != null) {
            if (this.f647y == null) {
                this.f647y = new SparseArray();
            } else {
                this.f647y.clear();
            }
            c0051y.f492S.saveHierarchyState(this.f647y);
            if (this.f647y.size() > 0) {
                c0051y.f504o = this.f647y;
                this.f647y = null;
            }
        }
    }

    Bundle m1115g(C0051y c0051y) {
        Bundle bundle;
        if (this.f646x == null) {
            this.f646x = new Bundle();
        }
        c0051y.m874k(this.f646x);
        if (this.f646x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f646x;
            this.f646x = null;
        }
        if (c0051y.f491R != null) {
            m1114f(c0051y);
        }
        if (c0051y.f504o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c0051y.f504o);
        }
        if (!c0051y.f494U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c0051y.f494U);
        }
        return bundle;
    }

    ArrayList m1116g() {
        ArrayList arrayList = null;
        if (this.f629f != null) {
            for (int i = 0; i < this.f629f.size(); i++) {
                C0051y c0051y = (C0051y) this.f629f.get(i);
                if (c0051y != null && c0051y.f484K) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0051y);
                    c0051y.f485L = true;
                    c0051y.f509t = c0051y.f508s != null ? c0051y.f508s.f505p : -1;
                    if (f623a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + c0051y);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m1117h() {
        C0090t[] c0090tArr = null;
        m1112e();
        if (f624b) {
            this.f642t = true;
        }
        if (this.f629f == null || this.f629f.size() <= 0) {
            return null;
        }
        int size = this.f629f.size();
        aw[] awVarArr = new aw[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0051y c0051y = (C0051y) this.f629f.get(i);
            if (c0051y != null) {
                if (c0051y.f505p < 0) {
                    m1064a(new IllegalStateException("Failure saving state: active " + c0051y + " has cleared index: " + c0051y.f505p));
                }
                aw awVar = new aw(c0051y);
                awVarArr[i] = awVar;
                if (c0051y.f500k <= 0 || awVar.f673j != null) {
                    awVar.f673j = c0051y.f503n;
                } else {
                    awVar.f673j = m1115g(c0051y);
                    if (c0051y.f508s != null) {
                        if (c0051y.f508s.f505p < 0) {
                            m1064a(new IllegalStateException("Failure saving state: " + c0051y + " has target not in fragment manager: " + c0051y.f508s));
                        }
                        if (awVar.f673j == null) {
                            awVar.f673j = new Bundle();
                        }
                        mo182a(awVar.f673j, "android:target_state", c0051y.f508s);
                        if (c0051y.f510u != 0) {
                            awVar.f673j.putInt("android:target_req_state", c0051y.f510u);
                        }
                    }
                }
                if (f623a) {
                    Log.v("FragmentManager", "Saved state of " + c0051y + ": " + awVar.f673j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            au auVar;
            if (this.f630g != null) {
                i = this.f630g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((C0051y) this.f630g.get(i2)).f505p;
                        if (iArr[i2] < 0) {
                            m1064a(new IllegalStateException("Failure saving state: active " + this.f630g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f623a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f630g.get(i2));
                        }
                    }
                    if (this.f632i != null) {
                        i = this.f632i.size();
                        if (i > 0) {
                            c0090tArr = new C0090t[i];
                            for (i2 = 0; i2 < i; i2++) {
                                c0090tArr[i2] = new C0090t((C0084n) this.f632i.get(i2));
                                if (f623a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f632i.get(i2));
                                }
                            }
                        }
                    }
                    auVar = new au();
                    auVar.f661a = awVarArr;
                    auVar.f662b = iArr;
                    auVar.f663c = c0090tArr;
                    return auVar;
                }
            }
            iArr = null;
            if (this.f632i != null) {
                i = this.f632i.size();
                if (i > 0) {
                    c0090tArr = new C0090t[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0090tArr[i2] = new C0090t((C0084n) this.f632i.get(i2));
                        if (f623a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f632i.get(i2));
                        }
                    }
                }
            }
            auVar = new au();
            auVar.f661a = awVarArr;
            auVar.f662b = iArr;
            auVar.f663c = c0090tArr;
            return auVar;
        } else if (!f623a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m1118i() {
        this.f642t = false;
    }

    public void m1119j() {
        this.f642t = false;
        m1082a(1, false);
    }

    public void m1120k() {
        this.f642t = false;
        m1082a(2, false);
    }

    public void m1121l() {
        this.f642t = false;
        m1082a(4, false);
    }

    public void m1122m() {
        this.f642t = false;
        m1082a(5, false);
    }

    public void m1123n() {
        m1082a(4, false);
    }

    public void m1124o() {
        this.f642t = true;
        m1082a(3, false);
    }

    public void m1125p() {
        m1082a(2, false);
    }

    public void m1126q() {
        m1082a(1, false);
    }

    public void m1127r() {
        this.f643u = true;
        m1112e();
        m1082a(0, false);
        this.f638o = null;
        this.f639p = null;
        this.f640q = null;
    }

    public void m1128s() {
        if (this.f630g != null) {
            for (int i = 0; i < this.f630g.size(); i++) {
                C0051y c0051y = (C0051y) this.f630g.get(i);
                if (c0051y != null) {
                    c0051y.m819H();
                }
            }
        }
    }

    al m1129t() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f640q != null) {
            C0170d.m1540a(this.f640q, stringBuilder);
        } else {
            C0170d.m1540a(this.f638o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
