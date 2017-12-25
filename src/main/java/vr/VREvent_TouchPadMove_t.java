package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * when in mouse input mode you can receive data from the touchpad, these events are only sent if the users finger
 * is on the touchpad (or just released from it). These events are sent to overlays with the VROverlayFlags_SendVRTouchpadEvents
 * flag set.
 **/
public class VREvent_TouchPadMove_t extends Structure {

    // true if the users finger is detected on the touch pad
    public byte bFingerDown;
    
    // How long the finger has been down in seconds
    public float flSecondsFingerDown;
    
    // These values indicate the starting finger position (so you can do some basic swipe stuff)
    public float fValueXFirst;
    public float fValueYFirst;
    
    // This is the raw sampled coordinate without deadzoning
    public float fValueXRaw;
    public float fValueYRaw;

    public VREvent_TouchPadMove_t() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("bFingerDown", "flSecondsFingerDown", "fValueXFirst", "fValueYFirst", "fValueXRaw", "fValueYRaw");
    }

    public VREvent_TouchPadMove_t(byte bFingerDown, float flSecondsFingerDown, float fValueXFirst, float fValueYFirst, float fValueXRaw, float fValueYRaw) {
        super();
        this.bFingerDown = bFingerDown;
        this.flSecondsFingerDown = flSecondsFingerDown;
        this.fValueXFirst = fValueXFirst;
        this.fValueYFirst = fValueYFirst;
        this.fValueXRaw = fValueXRaw;
        this.fValueYRaw = fValueYRaw;
    }

    public VREvent_TouchPadMove_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VREvent_TouchPadMove_t implements Structure.ByReference {
    };

    public static class ByValue extends VREvent_TouchPadMove_t implements Structure.ByValue {
    };
}
