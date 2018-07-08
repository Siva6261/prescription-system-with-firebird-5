package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.az;
import android.support.v4.view.bq;
import android.support.v4.view.bv;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class bk {
    private static final Interpolator f1107v = new bl();
    private int f1108a;
    private int f1109b;
    private int f1110c = -1;
    private float[] f1111d;
    private float[] f1112e;
    private float[] f1113f;
    private float[] f1114g;
    private int[] f1115h;
    private int[] f1116i;
    private int[] f1117j;
    private int f1118k;
    private VelocityTracker f1119l;
    private float f1120m;
    private float f1121n;
    private int f1122o;
    private int f1123p;
    private at f1124q;
    private final bn f1125r;
    private View f1126s;
    private boolean f1127t;
    private final ViewGroup f1128u;
    private final Runnable f1129w = new bm(this);

    private bk(Context context, ViewGroup viewGroup, bn bnVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (bnVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1128u = viewGroup;
            this.f1125r = bnVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1122o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1109b = viewConfiguration.getScaledTouchSlop();
            this.f1120m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1121n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1124q = at.m2639a(context, f1107v);
        }
    }

    private float m2717a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m2718a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m2719a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1128u.getWidth();
        int i4 = width / 2;
        float a = (m2717a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m2720a(View view, int i, int i2, int i3, int i4) {
        int b = m2728b(i3, (int) this.f1121n, (int) this.f1120m);
        int b2 = m2728b(i4, (int) this.f1121n, (int) this.f1120m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2719a(i2, b2, this.f1125r.mo138a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2719a(i, b, this.f1125r.mo121b(view)))));
    }

    public static bk m2721a(ViewGroup viewGroup, float f, bn bnVar) {
        bk a = m2722a(viewGroup, bnVar);
        a.f1109b = (int) (((float) a.f1109b) * (1.0f / f));
        return a;
    }

    public static bk m2722a(ViewGroup viewGroup, bn bnVar) {
        return new bk(viewGroup.getContext(), viewGroup, bnVar);
    }

    private void m2723a(float f, float f2) {
        this.f1127t = true;
        this.f1125r.mo118a(this.f1126s, f, f2);
        this.f1127t = false;
        if (this.f1108a == 1) {
            m2746b(0);
        }
    }

    private void m2724a(float f, float f2, int i) {
        m2736d(i);
        float[] fArr = this.f1111d;
        this.f1113f[i] = f;
        fArr[i] = f;
        fArr = this.f1112e;
        this.f1114g[i] = f2;
        fArr[i] = f2;
        this.f1115h[i] = m2734d((int) f, (int) f2);
        this.f1118k |= 1 << i;
    }

    private boolean m2725a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1115h[i] & i2) != i2 || (this.f1123p & i2) == 0 || (this.f1117j[i] & i2) == i2 || (this.f1116i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1109b) && abs2 <= ((float) this.f1109b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1125r.m694b(i2)) {
            return (this.f1116i[i] & i2) == 0 && abs > ((float) this.f1109b);
        } else {
            int[] iArr = this.f1117j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m2726a(int i, int i2, int i3, int i4) {
        int left = this.f1126s.getLeft();
        int top = this.f1126s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1124q.m2652h();
            m2746b(0);
            return false;
        }
        this.f1124q.m2641a(left, top, i5, i6, m2720a(this.f1126s, i5, i6, i3, i4));
        m2746b(2);
        return true;
    }

    private boolean m2727a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1125r.mo121b(view) > 0;
        boolean z2 = this.f1125r.mo138a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1109b * this.f1109b)) : z ? Math.abs(f) > ((float) this.f1109b) : z2 ? Math.abs(f2) > ((float) this.f1109b) : false;
    }

    private int m2728b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m2729b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2725a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2725a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2725a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2725a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1116i;
            iArr[i] = iArr[i] | i2;
            this.f1125r.m692b(i2, i);
        }
    }

    private void m2730b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f1126s.getLeft();
        int top = this.f1126s.getTop();
        if (i3 != 0) {
            b = this.f1125r.mo122b(this.f1126s, i, i3);
            bv.m2029f(this.f1126s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f1125r.mo116a(this.f1126s, i2, i4);
            bv.m2027e(this.f1126s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1125r.mo119a(this.f1126s, b, a, b - left, a - top);
        }
    }

    private void m2731c() {
        if (this.f1111d != null) {
            Arrays.fill(this.f1111d, 0.0f);
            Arrays.fill(this.f1112e, 0.0f);
            Arrays.fill(this.f1113f, 0.0f);
            Arrays.fill(this.f1114g, 0.0f);
            Arrays.fill(this.f1115h, 0);
            Arrays.fill(this.f1116i, 0);
            Arrays.fill(this.f1117j, 0);
            this.f1118k = 0;
        }
    }

    private void m2732c(int i) {
        if (this.f1111d != null) {
            this.f1111d[i] = 0.0f;
            this.f1112e[i] = 0.0f;
            this.f1113f[i] = 0.0f;
            this.f1114g[i] = 0.0f;
            this.f1115h[i] = 0;
            this.f1116i[i] = 0;
            this.f1117j[i] = 0;
            this.f1118k &= (1 << i) ^ -1;
        }
    }

    private void m2733c(MotionEvent motionEvent) {
        int c = az.m1909c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = az.m1907b(motionEvent, i);
            float c2 = az.m1908c(motionEvent, i);
            float d = az.m1910d(motionEvent, i);
            this.f1113f[b] = c2;
            this.f1114g[b] = d;
        }
    }

    private int m2734d(int i, int i2) {
        int i3 = 0;
        if (i < this.f1128u.getLeft() + this.f1122o) {
            i3 = 1;
        }
        if (i2 < this.f1128u.getTop() + this.f1122o) {
            i3 |= 4;
        }
        if (i > this.f1128u.getRight() - this.f1122o) {
            i3 |= 2;
        }
        return i2 > this.f1128u.getBottom() - this.f1122o ? i3 | 8 : i3;
    }

    private void m2735d() {
        this.f1119l.computeCurrentVelocity(1000, this.f1120m);
        m2723a(m2718a(bq.m1984a(this.f1119l, this.f1110c), this.f1121n, this.f1120m), m2718a(bq.m1985b(this.f1119l, this.f1110c), this.f1121n, this.f1120m));
    }

    private void m2736d(int i) {
        if (this.f1111d == null || this.f1111d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1111d != null) {
                System.arraycopy(this.f1111d, 0, obj, 0, this.f1111d.length);
                System.arraycopy(this.f1112e, 0, obj2, 0, this.f1112e.length);
                System.arraycopy(this.f1113f, 0, obj3, 0, this.f1113f.length);
                System.arraycopy(this.f1114g, 0, obj4, 0, this.f1114g.length);
                System.arraycopy(this.f1115h, 0, obj5, 0, this.f1115h.length);
                System.arraycopy(this.f1116i, 0, obj6, 0, this.f1116i.length);
                System.arraycopy(this.f1117j, 0, obj7, 0, this.f1117j.length);
            }
            this.f1111d = obj;
            this.f1112e = obj2;
            this.f1113f = obj3;
            this.f1114g = obj4;
            this.f1115h = obj5;
            this.f1116i = obj6;
            this.f1117j = obj7;
        }
    }

    private boolean m2737e(int i) {
        if (m2740a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public int m2738a() {
        return this.f1109b;
    }

    public void m2739a(View view, int i) {
        if (view.getParent() != this.f1128u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1128u + ")");
        }
        this.f1126s = view;
        this.f1110c = i;
        this.f1125r.mo123b(view, i);
        m2746b(1);
    }

    public boolean m2740a(int i) {
        return (this.f1118k & (1 << i)) != 0;
    }

    public boolean m2741a(int i, int i2) {
        if (this.f1127t) {
            return m2726a(i, i2, (int) bq.m1984a(this.f1119l, this.f1110c), (int) bq.m1985b(this.f1119l, this.f1110c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2742a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.az.m1904a(r14);
        r1 = android.support.v4.view.az.m1906b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2745b();
    L_0x000d:
        r2 = r13.f1119l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1119l = r2;
    L_0x0017:
        r2 = r13.f1119l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1108a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.az.m1907b(r14, r2);
        r13.m2724a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2751c(r0, r1);
        r1 = r13.f1126s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1108a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2749b(r0, r2);
    L_0x0048:
        r0 = r13.f1115h;
        r0 = r0[r2];
        r1 = r13.f1123p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1125r;
        r3 = r13.f1123p;
        r0 = r0 & r3;
        r1.m686a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.az.m1907b(r14, r1);
        r2 = android.support.v4.view.az.m1908c(r14, r1);
        r1 = android.support.v4.view.az.m1910d(r14, r1);
        r13.m2724a(r2, r1, r0);
        r3 = r13.f1108a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1115h;
        r1 = r1[r0];
        r2 = r13.f1123p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1125r;
        r3 = r13.f1123p;
        r1 = r1 & r3;
        r2.m686a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1108a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2751c(r2, r1);
        r2 = r13.f1126s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2749b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1111d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1112e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.az.m1909c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = android.support.v4.view.az.m1907b(r14, r1);
        r0 = r13.m2737e(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = android.support.v4.view.az.m1908c(r14, r1);
        r4 = android.support.v4.view.az.m1910d(r14, r1);
        r5 = r13.f1111d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1112e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2751c(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m2727a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1125r;
        r10 = (int) r5;
        r8 = r9.mo122b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1125r;
        r12 = (int) r6;
        r10 = r11.mo116a(r4, r10, r12);
        r11 = r13.f1125r;
        r11 = r11.mo121b(r4);
        r12 = r13.f1125r;
        r12 = r12.mo138a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m2733c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m2729b(r5, r6, r3);
        r5 = r13.f1108a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m2749b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = android.support.v4.view.az.m1907b(r14, r1);
        r13.m2732c(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m2745b();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.bk.a(android.view.MotionEvent):boolean");
    }

    public boolean m2743a(View view, int i, int i2) {
        this.f1126s = view;
        this.f1110c = -1;
        boolean a = m2726a(i, i2, 0, 0);
        if (!(a || this.f1108a != 0 || this.f1126s == null)) {
            this.f1126s = null;
        }
        return a;
    }

    public boolean m2744a(boolean z) {
        if (this.f1108a == 2) {
            int i;
            boolean g = this.f1124q.m2651g();
            int b = this.f1124q.m2646b();
            int c = this.f1124q.m2647c();
            int left = b - this.f1126s.getLeft();
            int top = c - this.f1126s.getTop();
            if (left != 0) {
                bv.m2029f(this.f1126s, left);
            }
            if (top != 0) {
                bv.m2027e(this.f1126s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1125r.mo119a(this.f1126s, b, c, left, top);
            }
            if (g && b == this.f1124q.m2648d() && c == this.f1124q.m2649e()) {
                this.f1124q.m2652h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1128u.post(this.f1129w);
                } else {
                    m2746b(0);
                }
            }
        }
        return this.f1108a == 2;
    }

    public void m2745b() {
        this.f1110c = -1;
        m2731c();
        if (this.f1119l != null) {
            this.f1119l.recycle();
            this.f1119l = null;
        }
    }

    void m2746b(int i) {
        this.f1128u.removeCallbacks(this.f1129w);
        if (this.f1108a != i) {
            this.f1108a = i;
            this.f1125r.mo117a(i);
            if (this.f1108a == 0) {
                this.f1126s = null;
            }
        }
    }

    public void m2747b(MotionEvent motionEvent) {
        int i = 0;
        int a = az.m1904a(motionEvent);
        int b = az.m1906b(motionEvent);
        if (a == 0) {
            m2745b();
        }
        if (this.f1119l == null) {
            this.f1119l = VelocityTracker.obtain();
        }
        this.f1119l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = az.m1907b(motionEvent, 0);
                c = m2751c((int) x, (int) y);
                m2724a(x, y, i);
                m2749b(c, i);
                i2 = this.f1115h[i];
                if ((this.f1123p & i2) != 0) {
                    this.f1125r.m686a(i2 & this.f1123p, i);
                    return;
                }
                return;
            case 1:
                if (this.f1108a == 1) {
                    m2735d();
                }
                m2745b();
                return;
            case 2:
                if (this.f1108a != 1) {
                    i2 = az.m1909c(motionEvent);
                    while (i < i2) {
                        a = az.m1907b(motionEvent, i);
                        if (m2737e(a)) {
                            float c2 = az.m1908c(motionEvent, i);
                            float d = az.m1910d(motionEvent, i);
                            float f = c2 - this.f1111d[a];
                            float f2 = d - this.f1112e[a];
                            m2729b(f, f2, a);
                            if (this.f1108a != 1) {
                                c = m2751c((int) c2, (int) d);
                                if (m2727a(c, f, f2) && m2749b(c, a)) {
                                }
                            }
                            m2733c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m2733c(motionEvent);
                    return;
                } else if (m2737e(this.f1110c)) {
                    i = az.m1905a(motionEvent, this.f1110c);
                    x = az.m1908c(motionEvent, i);
                    i2 = (int) (x - this.f1113f[this.f1110c]);
                    i = (int) (az.m1910d(motionEvent, i) - this.f1114g[this.f1110c]);
                    m2730b(this.f1126s.getLeft() + i2, this.f1126s.getTop() + i, i2, i);
                    m2733c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f1108a == 1) {
                    m2723a(0.0f, 0.0f);
                }
                m2745b();
                return;
            case 5:
                i = az.m1907b(motionEvent, b);
                x = az.m1908c(motionEvent, b);
                y = az.m1910d(motionEvent, b);
                m2724a(x, y, i);
                if (this.f1108a == 0) {
                    m2749b(m2751c((int) x, (int) y), i);
                    i2 = this.f1115h[i];
                    if ((this.f1123p & i2) != 0) {
                        this.f1125r.m686a(i2 & this.f1123p, i);
                        return;
                    }
                    return;
                } else if (m2748b((int) x, (int) y)) {
                    m2749b(this.f1126s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = az.m1907b(motionEvent, b);
                if (this.f1108a == 1 && a == this.f1110c) {
                    b = az.m1909c(motionEvent);
                    while (i < b) {
                        int b2 = az.m1907b(motionEvent, i);
                        if (b2 != this.f1110c) {
                            if (m2751c((int) az.m1908c(motionEvent, i), (int) az.m1910d(motionEvent, i)) == this.f1126s && m2749b(this.f1126s, b2)) {
                                i = this.f1110c;
                                if (i == -1) {
                                    m2735d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2735d();
                    }
                }
                m2732c(a);
                return;
            default:
                return;
        }
    }

    public boolean m2748b(int i, int i2) {
        return m2750b(this.f1126s, i, i2);
    }

    boolean m2749b(View view, int i) {
        if (view == this.f1126s && this.f1110c == i) {
            return true;
        }
        if (view == null || !this.f1125r.mo120a(view, i)) {
            return false;
        }
        this.f1110c = i;
        m2739a(view, i);
        return true;
    }

    public boolean m2750b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m2751c(int i, int i2) {
        for (int childCount = this.f1128u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1128u.getChildAt(this.f1125r.m695c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
