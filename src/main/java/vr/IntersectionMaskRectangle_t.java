package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class IntersectionMaskRectangle_t extends Structure {

    float m_flTopLeftX;
    float m_flTopLeftY;
    float m_flWidth;
    float m_flHeight;

    public IntersectionMaskRectangle_t() {
        super();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("m_flTopLeftX", "m_flTopLeftY",
                "m_flWidth", "m_flHeight");
    }


    public IntersectionMaskRectangle_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends IntersectionMaskRectangle_t implements Structure.ByReference {
    }

    public static class ByValue extends IntersectionMaskRectangle_t implements Structure.ByValue {
    }
}
