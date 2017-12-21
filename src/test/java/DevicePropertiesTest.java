import com.jogamp.opengl.util.GLBuffers;
import com.sun.jna.Memory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vr.IVRSystem;
import vr.VR;

import java.nio.IntBuffer;

import static vr.VR.ETrackedDeviceProperty.Prop_SerialNumber_String;
import static vr.VR.ETrackedDeviceProperty.Prop_TrackingSystemName_String;
import static vr.VR.ETrackedPropertyError.TrackedProp_Success;
import static vr.VR.k_unMaxPropertyStringSize;
import static vr.VR.k_unTrackedDeviceIndex_Hmd;

public class DevicePropertiesTest {
    private static IVRSystem hmd;
    private static IntBuffer errorBuffer = GLBuffers.newDirectIntBuffer(1);

    @BeforeClass
    public static void init() {
        hmd = VR.VR_Init(errorBuffer, VR.EVRApplicationType.VRApplication_Scene);

        System.out.println(VR.VR_GetVRInitErrorAsEnglishDescription(errorBuffer.get(0)));
        assert (errorBuffer.get(0) == VR.EVRInitError.VRInitError_None);
    }

    @Test
    public void getDriver() {
        Memory mem = new Memory(k_unMaxPropertyStringSize);
        int len = hmd.GetStringTrackedDeviceProperty.apply(k_unTrackedDeviceIndex_Hmd, Prop_TrackingSystemName_String, mem.getPointer(0), k_unMaxPropertyStringSize, errorBuffer);

        assert (errorBuffer.get() == TrackedProp_Success);

        String name = mem.getString(0);
        System.out.println("Driver : " + name);
    }

    @Test
    public void getDisplay() {
        Memory mem = new Memory(k_unMaxPropertyStringSize);
        int len = hmd.GetStringTrackedDeviceProperty.apply(k_unTrackedDeviceIndex_Hmd, Prop_SerialNumber_String, mem.getPointer(0), k_unMaxPropertyStringSize, errorBuffer);

        assert (errorBuffer.get() == TrackedProp_Success);

        String name = mem.getString(0);
        System.out.println("Display : " + name);
    }

    @Before
    public void reset() {
        errorBuffer.put(0, 0);
    }

    @AfterClass
    public static void shutdown() {
        VR.VR_Shutdown();
    }
}
