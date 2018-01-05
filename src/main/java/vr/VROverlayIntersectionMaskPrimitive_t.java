package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class VROverlayIntersectionMaskPrimitive_t extends Structure {
    public int m_nPrimitiveType; // type EVROverlayIntersectionMaskPrimitiveType
    public vr.VROverlayIntersectionMaskPrimitive_Data_t.ByValue m_Primitive;

    public VROverlayIntersectionMaskPrimitive_t() {
        super();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("m_nPrimitiveType", "m_Primitive");
    }

    public VROverlayIntersectionMaskPrimitive_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VROverlayIntersectionMaskPrimitive_t implements Structure.ByReference {
    }

    public static class ByValue extends VROverlayIntersectionMaskPrimitive_t implements Structure.ByValue {
    }
}
