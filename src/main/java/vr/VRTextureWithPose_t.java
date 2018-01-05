package vr;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * Allows specifying pose used to render provided scene texture (if different from value returned by WaitGetPoses).
 */
public class VRTextureWithPose_t extends Texture_t {
    public HmdMatrix34_t mDeviceToAbsoluteTracking; // Actual pose used to render scene textures.

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("handle", "eType", "eColorSpace", "mDeviceToAbsoluteTracking"/*This may be elsewhere*/);
    }

    public static class ByReference extends Texture_t implements Structure.ByReference {
    }

    public static class ByValue extends Texture_t implements Structure.ByValue {
    }

}
