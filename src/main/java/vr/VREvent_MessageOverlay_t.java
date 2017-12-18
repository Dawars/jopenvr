package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class VREvent_MessageOverlay_t extends Structure {
    public int unVRMessageOverlayResponse; // vr::VRMessageOverlayResponse enum

    public VREvent_MessageOverlay_t() {
        super();
    }

    @Override
    protected List<?> getFieldOrder() {
        return Arrays.asList("unVRMessageOverlayResponse");
    }

    public VREvent_MessageOverlay_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VREvent_MessageOverlay_t implements Structure.ByReference {
    }

    public static class ByValue extends VREvent_MessageOverlay_t implements Structure.ByValue {
    }
}
