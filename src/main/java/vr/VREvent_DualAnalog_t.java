package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class VREvent_DualAnalog_t extends Structure {

    public float x, y; // coordinates are -1..1 analog values
    public float transformedX, transformedY; // transformed by the center and radius numbers provided by the overlay
    public int which; // EDualAnalogWhich

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("x", "y", "transformedX", "transformedY", "which");
    }

    public VREvent_DualAnalog_t() {
        super();
    }

    public VREvent_DualAnalog_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VREvent_DualAnalog_t implements Structure.ByReference {
    }

    public static class ByValue extends VREvent_DualAnalog_t implements Structure.ByValue {
    }
}
