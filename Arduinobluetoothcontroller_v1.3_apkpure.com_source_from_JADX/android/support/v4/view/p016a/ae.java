package android.support.v4.view.p016a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class ae extends AccessibilityNodeProvider {
    final /* synthetic */ af f948a;

    ae(af afVar) {
        this.f948a = afVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f948a.mo291a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f948a.mo292a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f948a.mo293a(i, i2, bundle);
    }
}
