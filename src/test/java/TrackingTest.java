import com.jogamp.opengl.util.GLBuffers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vr.*;

import java.nio.IntBuffer;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static vr.VR.ETrackedDeviceClass.*;
import static vr.VR.ETrackedDeviceProperty.Prop_ModelNumber_String;
import static vr.VR.ETrackingUniverseOrigin.*;
import static vr.VR.EVREye.Eye_Left;
import static vr.VR.EVREye.Eye_Right;
import static vr.VR.k_unMaxTrackedDeviceCount;
import static vr.VR.k_unTrackedDeviceIndex_Hmd;

public class TrackingTest {
    private static IVRSystem hmd;
    private static IntBuffer errorBuffer = GLBuffers.newDirectIntBuffer(1);
    private static IVRCompositor_FnTable compositor;

    @BeforeClass
    public static void init() {
        hmd = VR.VR_Init(errorBuffer, VR.EVRApplicationType.VRApplication_Scene);

        System.out.println(VR.VR_GetVRInitErrorAsEnglishDescription(errorBuffer.get(0)));
        assert (errorBuffer.get(0) == VR.EVRInitError.VRInitError_None);

        compositor = new IVRCompositor_FnTable(VR.VR_GetGenericInterface(VR.IVRCompositor_Version, errorBuffer));

        assert (errorBuffer.get(0) == VR.EVRInitError.VRInitError_None);
    }

    @Test
    public void getTrackedDevices() {
        //Iterate through the possible trackedDeviceIndexes
        for (int trackedDevice = k_unTrackedDeviceIndex_Hmd + 1;
             trackedDevice < k_unMaxTrackedDeviceCount;
             trackedDevice++) {
            //If the device is not connected, pass.
            if (!hmd.IsTrackedDeviceConnected.apply(trackedDevice))
                continue;
            //If the device is not recognized as a controller, pass
            if (hmd.GetTrackedDeviceClass.apply(trackedDevice) == TrackedDeviceClass_Controller)
                System.out.println("Controller: " + trackedDevice);
            if (hmd.GetTrackedDeviceClass.apply(trackedDevice) == TrackedDeviceClass_GenericTracker)
                System.out.println("GenericTracker: " + trackedDevice);
            if (hmd.GetTrackedDeviceClass.apply(trackedDevice) == TrackedDeviceClass_TrackingReference)
                System.out.println("Tracker: " + trackedDevice);
        }
    }

    @Test
    public void getEyeToHeadTransform() {
        HmdMatrix34_t mat = hmd.GetEyeToHeadTransform.apply(Eye_Left);
        System.out.println(Arrays.toString(mat.m));
        mat = hmd.GetEyeToHeadTransform.apply(Eye_Right);
        System.out.println(Arrays.toString(mat.m));
    }

    @Test
    public void getProjectionMatrix() {
        HmdMatrix44_t mat = hmd.GetProjectionMatrix.apply(Eye_Left, 0.01f, 100);
        System.out.println(Arrays.toString(mat.m));
        mat = hmd.GetProjectionMatrix.apply(Eye_Right, 0.01f, 100);
        System.out.println(Arrays.toString(mat.m));
    }

    @Test
    public void waitGetPoses() {
        TrackedDevicePose_t[] trackedPoses = new TrackedDevicePose_t[k_unMaxTrackedDeviceCount];

//        int len = compositor.WaitGetPoses.apply(trackedPoses, k_unMaxTrackedDeviceCount, null, 0);

        for (int i = 0; i < trackedPoses.length; i++) {

            TrackedDevicePose_t hmdPose = trackedPoses[i];


            if (hmdPose.bPoseIsValid) {
                System.out.println("------------------" + hmd.GetTrackedDevicePropertyString(i, Prop_ModelNumber_String, errorBuffer) + "----------------------");
                System.out.println(Arrays.toString(hmdPose.mDeviceToAbsoluteTracking.m));
            }

        }
    }

    @Test
    public void getTrackingSpace() {
        for (int i = 0; i < 3; i++) {
            compositor.SetTrackingSpace.apply(i);
            int origin = compositor.GetTrackingSpace.apply();
            assertEquals(i, origin);

            switch (origin) {
                case TrackingUniverseSeated:
                    System.out.println("Seated");
                    break;
                case TrackingUniverseStanding:
                    System.out.println("Room-scale");
                    break;
                case TrackingUniverseRawAndUncalibrated:
                    System.out.println("Uncalibrated");
                    break;
            }
        }
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
