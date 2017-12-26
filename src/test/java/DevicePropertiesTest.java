import com.jogamp.opengl.util.GLBuffers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vr.HmdMatrix34_t;
import vr.IVRSystem;
import vr.VR;

import java.nio.IntBuffer;
import java.util.Arrays;

import static vr.VR.ETrackedDeviceClass.TrackedDeviceClass_Controller;
import static vr.VR.ETrackedDeviceClass.TrackedDeviceClass_TrackingReference;
import static vr.VR.ETrackedDeviceProperty.*;
import static vr.VR.k_unMaxTrackedDeviceCount;
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
    public void getGeneralProperties() {
        for (int trackedDevice = k_unTrackedDeviceIndex_Hmd + 1;
             trackedDevice < k_unMaxTrackedDeviceCount;
             trackedDevice++) {
            //If the device is not connected, pass.
            if (!hmd.IsTrackedDeviceConnected.apply(trackedDevice))
                continue;

            System.out.println("---------------------" + trackedDevice + "------------------");

            //headset
            getProperty(trackedDevice, Prop_TrackingSystemName_String, String.class);
            getProperty(trackedDevice, Prop_ModelNumber_String, String.class);
            getProperty(trackedDevice, Prop_SerialNumber_String, String.class);
            getProperty(trackedDevice, Prop_RenderModelName_String, String.class);
            getProperty(trackedDevice, Prop_WillDriftInYaw_Bool, boolean.class);
            getProperty(trackedDevice, Prop_ManufacturerName_String, String.class);
            getProperty(trackedDevice, Prop_TrackingFirmwareVersion_String, String.class);
            getProperty(trackedDevice, Prop_HardwareRevision_String, String.class);
            getProperty(trackedDevice, Prop_AllWirelessDongleDescriptions_String, String.class);
            getProperty(trackedDevice, Prop_ConnectedWirelessDongle_String, String.class);
            getProperty(trackedDevice, Prop_DeviceIsWireless_Bool, boolean.class);
            getProperty(trackedDevice, Prop_DeviceIsCharging_Bool, boolean.class);
            getProperty(trackedDevice, Prop_DeviceBatteryPercentage_Float, float.class);// 0 is empty, 1 is full
            getProperty(trackedDevice, Prop_StatusDisplayTransform_Matrix34, HmdMatrix34_t.class);
            getProperty(trackedDevice, Prop_Firmware_UpdateAvailable_Bool, boolean.class);
            getProperty(trackedDevice, Prop_Firmware_ManualUpdate_Bool, boolean.class);
            getProperty(trackedDevice, Prop_Firmware_ManualUpdateURL_String, String.class);
            getProperty(trackedDevice, Prop_HardwareRevision_Uint64, Long.class);
            getProperty(trackedDevice, Prop_FirmwareVersion_Uint64, Long.class);
            getProperty(trackedDevice, Prop_FPGAVersion_Uint64, Long.class);
            getProperty(trackedDevice, Prop_VRCVersion_Uint64, Long.class);
            getProperty(trackedDevice, Prop_RadioVersion_Uint64, Long.class);
            getProperty(trackedDevice, Prop_DongleVersion_Uint64, Long.class);
            getProperty(trackedDevice, Prop_BlockServerShutdown_Bool, boolean.class);
            getProperty(trackedDevice, Prop_CanUnifyCoordinateSystemWithHmd_Bool, boolean.class);
            getProperty(trackedDevice, Prop_ContainsProximitySensor_Bool, boolean.class);
            getProperty(trackedDevice, Prop_DeviceProvidesBatteryStatus_Bool, boolean.class);
            getProperty(trackedDevice, Prop_DeviceCanPowerOff_Bool, boolean.class);
            getProperty(trackedDevice, Prop_Firmware_ProgrammingTarget_String, String.class);
            getProperty(trackedDevice, Prop_DeviceClass_Int32, int.class);
            getProperty(trackedDevice, Prop_HasCamera_Bool, boolean.class);
            getProperty(trackedDevice, Prop_DriverVersion_String, String.class);
            getProperty(trackedDevice, Prop_Firmware_ForceUpdateRequired_Bool, boolean.class);
            getProperty(trackedDevice, Prop_ViveSystemButtonFixRequired_Bool, boolean.class);
        }
    }

    private void getProperty(int deviceId, int prop, Class type) {

        if (type == null) {
//            System.out.println(hmd.GetStringTrackedDeviceProperty(deviceId, prop, errorBuffer));
        } else if (type == String.class) {
            System.out.println(hmd.GetTrackedDevicePropertyString(deviceId, prop, errorBuffer));
        } else if (type == int.class || type == Integer.class) {
            System.out.println(hmd.GetInt32TrackedDeviceProperty.apply(deviceId, prop, errorBuffer));
        } else if (type == boolean.class || type == Boolean.class) {
            System.out.println(hmd.GetBoolTrackedDeviceProperty.apply(deviceId, prop, errorBuffer));
        } else if (type == long.class || type == Long.class) {
            System.out.println(hmd.GetUint64TrackedDeviceProperty.apply(deviceId, prop, errorBuffer));
        } else if (type == HmdMatrix34_t.class) {
            System.out.println(Arrays.toString(hmd.GetMatrix34TrackedDeviceProperty.apply(deviceId, prop, errorBuffer).m));
        }

        int error = errorBuffer.get(0);
        if (error != 0) {
            System.out.println(hmd.GetPropErrorNameFromEnum.apply(error));
        }
    }

    @Test
    public void getHmdProperties() {
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ParentDriver_Uint64, Long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ResourceRoot_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_RegisteredDeviceType_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_InputProfileName_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ReportsTimeSinceVSync_Bool, Boolean.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_SecondsFromVsyncToPhotons_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayFrequency_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_UserIpdMeters_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_CurrentUniverseId_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_PreviousUniverseId_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayFirmwareVersion_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_IsOnDesktop_Bool, boolean.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCType_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCOffset_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCScale_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_EdidVendorID_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCImageLeft_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCImageRight_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayGCBlackClamp_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_EdidProductID_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_CameraToHeadTransform_Matrix34, HmdMatrix34_t.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayGCType_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayGCOffset_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayGCScale_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayGCPrescale_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayGCImage_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_LensCenterLeftU_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_LensCenterLeftV_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_LensCenterRightU_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_LensCenterRightV_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_UserHeadToEyeDepthMeters_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_CameraFirmwareVersion_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_CameraFirmwareDescription_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayFPGAVersion_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayBootloaderVersion_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayHardwareVersion_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_AudioFirmwareVersion_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_CameraCompatibilityMode_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ScreenshotHorizontalFieldOfViewDegrees_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ScreenshotVerticalFieldOfViewDegrees_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplaySuppressed_Bool, boolean.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayAllowNightMode_Bool, boolean.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCImageWidth_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCImageHeight_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCImageNumChannels_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayMCImageData_Binary, null);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_SecondsFromPhotonsToVblank_Float, float.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DriverDirectModeSendsVsyncEvents_Bool, boolean.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DisplayDebugMode_Bool, boolean.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_GraphicsAdapterLuid_Uint64, long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DriverProvidedChaperonePath_String, String.class);

        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ExpectedTrackingReferenceCount_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ExpectedControllerCount_Int32, int.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_NamedIconPathControllerLeftDeviceOff_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_NamedIconPathControllerRightDeviceOff_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_NamedIconPathTrackingReferenceDeviceOff_String, String.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_DoNotApplyPrediction_Bool, boolean.class);
    }

    @Test
    public void getControllerProperties() {
        // for devices if controllers

        for (int trackedDevice = k_unTrackedDeviceIndex_Hmd + 1;
             trackedDevice < k_unMaxTrackedDeviceCount;
             trackedDevice++) {
            //If the device is not connected, pass.
            if (!hmd.IsTrackedDeviceConnected.apply(trackedDevice))
                continue;
            //If the device is not recognized as a controller, pass
            if (hmd.GetTrackedDeviceClass.apply(trackedDevice) != TrackedDeviceClass_Controller)
                continue;

            System.out.println("--------------------- Controller " + trackedDevice + "------------------");            getProperty(trackedDevice, Prop_AttachedDeviceId_String, String.class);
            getProperty(trackedDevice, Prop_SupportedButtons_Uint64, long.class);
            getProperty(trackedDevice, Prop_Axis0Type_Int32, int.class);// Return value is of type EVRControllerAxisType
            getProperty(trackedDevice, Prop_Axis1Type_Int32, int.class);// Return value is of type EVRControllerAxisType
            getProperty(trackedDevice, Prop_Axis2Type_Int32, int.class);// Return value is of type EVRControllerAxisType
            getProperty(trackedDevice, Prop_Axis3Type_Int32, int.class);// Return value is of type EVRControllerAxisType
            getProperty(trackedDevice, Prop_Axis4Type_Int32, int.class);// Return value is of type EVRControllerAxisType
            getProperty(trackedDevice, Prop_ControllerRoleHint_Int32, int.class);// Return value is of type ETrackedControllerRole
        }
    }

    @Test
    public void getTrackingReferenceProperties() {
        //Iterate through the possible trackedDeviceIndexes
        for (int trackedDevice = k_unTrackedDeviceIndex_Hmd + 1;
             trackedDevice < k_unMaxTrackedDeviceCount;
             trackedDevice++) {
            //If the device is not connected, pass.
            if (!hmd.IsTrackedDeviceConnected.apply(trackedDevice))
                continue;
            if (hmd.GetTrackedDeviceClass.apply(trackedDevice) != TrackedDeviceClass_TrackingReference) continue;
            System.out.println("--------------------- Tracker " + trackedDevice + "------------------");
            getProperty(trackedDevice, Prop_FieldOfViewLeftDegrees_Float, float.class);
            getProperty(trackedDevice, Prop_FieldOfViewRightDegrees_Float, float.class);
            getProperty(trackedDevice, Prop_FieldOfViewTopDegrees_Float, float.class);
            getProperty(trackedDevice, Prop_FieldOfViewBottomDegrees_Float, float.class);
            getProperty(trackedDevice, Prop_TrackingRangeMinimumMeters_Float, float.class);
            getProperty(trackedDevice, Prop_TrackingRangeMaximumMeters_Float, float.class);
            getProperty(trackedDevice, Prop_ModeLabel_String, String.class);
            getProperty(trackedDevice, Prop_IconPathName_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceOff_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceSearching_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceSearchingAlert_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceReady_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceReadyAlert_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceNotReady_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceStandby_String, String.class);
            getProperty(trackedDevice, Prop_NamedIconPathDeviceAlertLow_String, String.class);
            getProperty(trackedDevice, Prop_DisplayHiddenArea_Binary_Start, int.class);
            getProperty(trackedDevice, Prop_DisplayHiddenArea_Binary_End, int.class);
            getProperty(trackedDevice, Prop_ParentContainer, int.class);
            getProperty(trackedDevice, Prop_UserConfigPath_String, String.class);
            getProperty(trackedDevice, Prop_InstallPath_String, String.class);
            getProperty(trackedDevice, Prop_HasDisplayComponent_Bool, boolean.class);
            getProperty(trackedDevice, Prop_HasControllerComponent_Bool, boolean.class);
            getProperty(trackedDevice, Prop_HasCameraComponent_Bool, boolean.class);
            getProperty(trackedDevice, Prop_HasDriverDirectModeComponent_Bool, boolean.class);
            getProperty(trackedDevice, Prop_HasVirtualDisplayComponent_Bool, boolean.class);
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
