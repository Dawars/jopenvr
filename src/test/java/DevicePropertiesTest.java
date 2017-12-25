import com.jogamp.opengl.util.GLBuffers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vr.HmdMatrix34_t;
import vr.IVRSystem;
import vr.VR;

import java.nio.IntBuffer;

import static org.junit.Assert.fail;
import static vr.VR.ETrackedDeviceProperty.*;
import static vr.VR.ETrackedPropertyError.*;
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
        String name = hmd.GetTrackedDevicePropertyString(k_unTrackedDeviceIndex_Hmd, Prop_TrackingSystemName_String, errorBuffer);

        checkTrackedPropError(errorBuffer.get());

        System.out.println("Driver : " + name);
    }

    @Test
    public void getDisplay() {
        String name = hmd.GetTrackedDevicePropertyString(k_unTrackedDeviceIndex_Hmd, Prop_SerialNumber_String, errorBuffer);

        checkTrackedPropError(errorBuffer.get());

        System.out.println("Display : " + name);
    }


    @Test
    public void getGeneralProperties() {
        int[] props = {
                Prop_TrackingSystemName_String,
                Prop_ModelNumber_String,
                Prop_SerialNumber_String,
                Prop_RenderModelName_String,
                Prop_WillDriftInYaw_Bool,
                Prop_ManufacturerName_String,
                Prop_TrackingFirmwareVersion_String,
                Prop_HardwareRevision_String,
                Prop_AllWirelessDongleDescriptions_String,
                Prop_ConnectedWirelessDongle_String,
                Prop_DeviceIsWireless_Bool,
                Prop_DeviceIsCharging_Bool,
                Prop_DeviceBatteryPercentage_Float,  // 0 is empty, 1 is full
                Prop_StatusDisplayTransform_Matrix34,
                Prop_Firmware_UpdateAvailable_Bool,
                Prop_Firmware_ManualUpdate_Bool,
                Prop_Firmware_ManualUpdateURL_String,
                Prop_HardwareRevision_Uint64,
                Prop_FirmwareVersion_Uint64,
                Prop_FPGAVersion_Uint64,
                Prop_VRCVersion_Uint64,
                Prop_RadioVersion_Uint64,
                Prop_DongleVersion_Uint64,
                Prop_BlockServerShutdown_Bool,
                Prop_CanUnifyCoordinateSystemWithHmd_Bool,
                Prop_ContainsProximitySensor_Bool,
                Prop_DeviceProvidesBatteryStatus_Bool,
                Prop_DeviceCanPowerOff_Bool,
                Prop_Firmware_ProgrammingTarget_String,
                Prop_DeviceClass_Int32,
                Prop_HasCamera_Bool,
                Prop_DriverVersion_String,
                Prop_Firmware_ForceUpdateRequired_Bool,
                Prop_ViveSystemButtonFixRequired_Bool
        };

        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_TrackingSystemName_String, String.class);
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
            System.out.println(hmd.GetMatrix34TrackedDeviceProperty.apply(deviceId, prop, errorBuffer));
        }

        System.out.println(hmd.GetPropErrorNameFromEnum.apply(errorBuffer.get()));
    }

    @Test
    public void getHmdProperties() {
        // FIXME separate string and other proprs

        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ParentDriver_Uint64, Long.class);
        getProperty(k_unTrackedDeviceIndex_Hmd, Prop_ResourceRoot_String, String.class);
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
    }

    @Test
    public void getControllerProperties() {
        int[] props = {
                Prop_AttachedDeviceId_String,
                Prop_SupportedButtons_Uint64,
                Prop_Axis0Type_Int32,    // Return value is of type EVRControllerAxisType
                Prop_Axis1Type_Int32,    // Return value is of type EVRControllerAxisType
                Prop_Axis2Type_Int32,    // Return value is of type EVRControllerAxisType
                Prop_Axis3Type_Int32,    // Return value is of type EVRControllerAxisType
                Prop_Axis4Type_Int32,    // Return value is of type EVRControllerAxisType
                Prop_ControllerRoleHint_Int32// Return value is of type ETrackedControllerRole
        };

        for (int prop : props) {
            String name = hmd.GetTrackedDevicePropertyString(k_unTrackedDeviceIndex_Hmd, prop, errorBuffer);
            checkTrackedPropError(errorBuffer.get());
            System.out.println(name);
        }
    }

    @Test
    public void getTrackingReferenceProperties() {
        int[] props = {
                Prop_FieldOfViewLeftDegrees_Float,
                Prop_FieldOfViewRightDegrees_Float,
                Prop_FieldOfViewTopDegrees_Float,
                Prop_FieldOfViewBottomDegrees_Float,
                Prop_TrackingRangeMinimumMeters_Float,
                Prop_TrackingRangeMaximumMeters_Float,
                Prop_ModeLabel_String,

                Prop_IconPathName_String,
                Prop_NamedIconPathDeviceOff_String,
                Prop_NamedIconPathDeviceSearching_String,
                Prop_NamedIconPathDeviceSearchingAlert_String,
                Prop_NamedIconPathDeviceReady_String,
                Prop_NamedIconPathDeviceReadyAlert_String,
                Prop_NamedIconPathDeviceNotReady_String,
                Prop_NamedIconPathDeviceStandby_String,
                Prop_NamedIconPathDeviceAlertLow_String,

                Prop_DisplayHiddenArea_Binary_Start,
                Prop_DisplayHiddenArea_Binary_End,
                Prop_UserConfigPath_String,
                Prop_InstallPath_String,
                Prop_HasDisplayComponent_Bool,

                Prop_HasControllerComponent_Bool,
                Prop_HasCameraComponent_Bool,
                Prop_HasDriverDirectModeComponent_Bool,
                Prop_HasVirtualDisplayComponent_Bool,
        };

        for (int prop : props) {
            String name = hmd.GetTrackedDevicePropertyString(k_unTrackedDeviceIndex_Hmd, prop, errorBuffer);
            checkTrackedPropError(errorBuffer.get());
            System.out.println(name);
        }
    }

    @Test
    public void getVendorDebugProperties() {
        int[] props = {
                Prop_VendorSpecific_Reserved_Start,
                Prop_VendorSpecific_Reserved_End
        };

        for (int prop : props) {
            String name = hmd.GetTrackedDevicePropertyString(k_unTrackedDeviceIndex_Hmd, prop, errorBuffer);
            checkTrackedPropError(errorBuffer.get());
            System.out.println(name);
        }
    }

    public void checkTrackedPropError(int errorCode) {

        switch (errorCode) {
            case TrackedProp_Success:
                break;

            case TrackedProp_WrongDataType:
                System.out.println(" TrackedProp_WrongDataType");
                break;
            case TrackedProp_WrongDeviceClass:
                System.out.println(" TrackedProp_WrongDeviceClass");
                break;
            case TrackedProp_BufferTooSmall:
                System.out.println(" TrackedProp_BufferTooSmall");
                break;
            case TrackedProp_UnknownProperty:
                System.out.println(" TrackedProp_UnknownProperty");
                break;
            case TrackedProp_InvalidDevice:
                System.out.println(" TrackedProp_InvalidDevice");
                break;
            case TrackedProp_CouldNotContactServer:
                System.out.println(" TrackedProp_CouldNotContactServer");
                break;
            case TrackedProp_ValueNotProvidedByDevice:
                System.out.println(" TrackedProp_ValueNotProvidedByDevice");
                break;
            case TrackedProp_StringExceedsMaximumLength:
                System.out.println(" TrackedProp_StringExceedsMaximumLength");
                break;
            // The property value isn't known yet, but is expected soon. Call again later.
            case TrackedProp_NotYetAvailable:
                System.out.println(" TrackedProp_NotYetAvailable");
                break;
            case TrackedProp_PermissionDenied:
                System.out.println(" TrackedProp_PermissionDenied");
                break;
            case TrackedProp_InvalidOperation:
                System.out.println(" TrackedProp_InvalidOperation");
                break;

            default:
                fail("Unknown error");
        }

        assert (errorCode == TrackedProp_Success);
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
