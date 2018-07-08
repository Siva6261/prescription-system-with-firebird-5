package android.support.v4.view.p016a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class ah extends AccessibilityNodeProvider {
    final /* synthetic */ ai f949a;

    ah(ai aiVar) {
        this.f949a = aiVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f949a.mo252a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f949a.mo253a(str, i);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f949a.mo255b(i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f949a.mo254a(i, i2, bundle);
    }
}
