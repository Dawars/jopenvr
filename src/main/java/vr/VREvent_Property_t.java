package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

public class VREvent_Property_t extends Structure {

    public long container; // PropertyContainerHandle_t
    public int prop; // enum ETrackedDeviceProperty

    public VREvent_Property_t() {
        super();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("container", "prop");
    }


    public VREvent_Property_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VREvent_Property_t implements Structure.ByReference {
    }

    public static class ByValue extends VREvent_Property_t implements Structure.ByValue {
    }
}
