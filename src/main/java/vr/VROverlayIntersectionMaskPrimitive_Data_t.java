package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;

import java.util.Arrays;
import java.util.List;

public class VROverlayIntersectionMaskPrimitive_Data_t extends Union {
    public vr.IntersectionMaskRectangle_t.ByValue m_Rectangle;
    public vr.IntersectionMaskCircle_t.ByValue m_Circle;

    public VROverlayIntersectionMaskPrimitive_Data_t() {
        super();
        setType(IntersectionMaskRectangle_t.class);
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("m_Rectangle", "m_Circle");
    }

    public VROverlayIntersectionMaskPrimitive_Data_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VROverlayIntersectionMaskPrimitive_Data_t implements Structure.ByReference {
    }

    public static class ByValue extends VROverlayIntersectionMaskPrimitive_Data_t implements Structure.ByValue {
    }
}
