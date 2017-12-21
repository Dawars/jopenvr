import com.jogamp.opengl.util.GLBuffers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vr.*;

import java.nio.IntBuffer;

import static vr.VR.EVREye.Eye_Left;
import static vr.VR.EVREye.Eye_Right;
import static vr.VR.k_unMaxTrackedDeviceCount;
import static vr.VR.k_unTrackedDeviceIndex_Hmd;

public class TrackingTest {
    private static IVRSystem hmd;
    private static IntBuffer errorBuffer = GLBuffers.newDirectIntBuffer(1);

    @BeforeClass
    public static void init() {
        hmd = VR.VR_Init(errorBuffer, VR.EVRApplicationType.VRApplication_Scene);

        System.out.println(VR.VR_GetVRInitErrorAsEnglishDescription(errorBuffer.get(0)));
        assert (errorBuffer.get(0) == VR.EVRInitError.VRInitError_None);
    }

    @Test
    public void getEyeToHeadTransform() {
        HmdMatrix34_t mat = hmd.GetEyeToHeadTransform.apply(Eye_Left);
        System.out.println(mat);
        mat = hmd.GetEyeToHeadTransform.apply(Eye_Right);
        System.out.println(mat);
    }

    @Test
    public void getProjectionMatrix() {
        HmdMatrix44_t mat = hmd.GetProjectionMatrix.apply(Eye_Left, 0.01f, 100);
        System.out.println(mat);
        mat = hmd.GetProjectionMatrix.apply(Eye_Right, 0.01f, 100);
        System.out.println(mat);
    }

    @Test
    public void waitGetPoses() {
        IVRCompositor_FnTable compositor = new IVRCompositor_FnTable(VR.VR_GetGenericInterface(VR.IVRCompositor_Version, errorBuffer));

        TrackedDevicePose_t[] trackedPoses = new TrackedDevicePose_t[k_unMaxTrackedDeviceCount];

        int len = compositor.WaitGetPoses.apply(trackedPoses, k_unMaxTrackedDeviceCount, null, 0);

        TrackedDevicePose_t hmdPose;
        if ((hmdPose = trackedPoses[k_unTrackedDeviceIndex_Hmd]).bPoseIsValid)
            System.out.println(hmdPose.mDeviceToAbsoluteTracking);
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
