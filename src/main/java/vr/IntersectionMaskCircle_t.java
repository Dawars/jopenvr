package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class IntersectionMaskCircle_t extends Structure {

    float m_flCenterX;
    float m_flCenterY;
    float m_flRadius;

    public IntersectionMaskCircle_t() {
        super();
    }

    @Override
    protected List<?> getFieldOrder() {
        return Arrays.asList("m_flCenterX", "m_flCenterY", "m_flRadius");
    }

    public IntersectionMaskCircle_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends IntersectionMaskCircle_t implements Structure.ByReference {
    }

    ;

    public static class ByValue extends IntersectionMaskCircle_t implements Structure.ByValue {
    }

    ;
}
