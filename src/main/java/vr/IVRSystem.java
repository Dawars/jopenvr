package vr;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.List;

/**
 * OpenVR Function Pointer Tables<br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class IVRSystem extends Structure {

    /**
     * C type : GetRecommendedRenderTargetSize_callback*
     */
    public IVRSystem.GetRecommendedRenderTargetSize_callback GetRecommendedRenderTargetSize;
    /**
     * C type : GetProjectionMatrix_callback*
     */
    public IVRSystem.GetProjectionMatrix_callback GetProjectionMatrix;
    /**
     * C type : GetProjectionRaw_callback*
     */
    public IVRSystem.GetProjectionRaw_callback GetProjectionRaw;
    /**
     * C type : ComputeDistortion_callback*
     */
    public IVRSystem.ComputeDistortion_callback ComputeDistortion;
    /**
     * C type : GetEyeToHeadTransform_callback*
     */
    public IVRSystem.GetEyeToHeadTransform_callback GetEyeToHeadTransform;
    /**
     * C type : GetTimeSinceLastVsync_callback*
     */
    public IVRSystem.GetTimeSinceLastVsync_callback GetTimeSinceLastVsync;
    /**
     * C type : GetD3D9AdapterIndex_callback*
     */
    public IVRSystem.GetD3D9AdapterIndex_callback GetD3D9AdapterIndex;
    /**
     * C type : GetDXGIOutputInfo_callback*
     */
    public vr.IVRExtendedDisplay_FnTable.GetDXGIOutputInfo_callback GetDXGIOutputInfo;
    /**
     * C type : IsDisplayOnDesktop_callback*
     */
    public IVRSystem.IsDisplayOnDesktop_callback IsDisplayOnDesktop;
    /**
     * C type : SetDisplayVisibility_callback*
     */
    public IVRSystem.SetDisplayVisibility_callback SetDisplayVisibility;
    /**
     * C type : GetDeviceToAbsoluteTrackingPose_callback*
     */
    public IVRSystem.GetDeviceToAbsoluteTrackingPose_callback GetDeviceToAbsoluteTrackingPose;
    /**
     * C type : ResetSeatedZeroPose_callback*
     */
    public IVRSystem.ResetSeatedZeroPose_callback ResetSeatedZeroPose;
    /**
     * C type : GetSeatedZeroPoseToStandingAbsoluteTrackingPose_callback*
     */
    public IVRSystem.GetSeatedZeroPoseToStandingAbsoluteTrackingPose_callback GetSeatedZeroPoseToStandingAbsoluteTrackingPose;
    /**
     * C type : GetRawZeroPoseToStandingAbsoluteTrackingPose_callback*
     */
    public IVRSystem.GetRawZeroPoseToStandingAbsoluteTrackingPose_callback GetRawZeroPoseToStandingAbsoluteTrackingPose;
    /**
     * C type : GetSortedTrackedDeviceIndicesOfClass_callback*
     */
    public IVRSystem.GetSortedTrackedDeviceIndicesOfClass_callback GetSortedTrackedDeviceIndicesOfClass;
    /**
     * C type : GetTrackedDeviceActivityLevel_callback*
     */
    public IVRSystem.GetTrackedDeviceActivityLevel_callback GetTrackedDeviceActivityLevel;
    /**
     * C type : ApplyTransform_callback*
     */
    public IVRSystem.ApplyTransform_callback ApplyTransform;
    /**
     * C type : GetTrackedDeviceIndexForControllerRole_callback*
     */
    public IVRSystem.GetTrackedDeviceIndexForControllerRole_callback GetTrackedDeviceIndexForControllerRole;
    /**
     * C type : GetControllerRoleForTrackedDeviceIndex_callback*
     */
    public IVRSystem.GetControllerRoleForTrackedDeviceIndex_callback GetControllerRoleForTrackedDeviceIndex;
    /**
     * C type : GetTrackedDeviceClass_callback*
     */
    public IVRSystem.GetTrackedDeviceClass_callback GetTrackedDeviceClass;
    /**
     * C type : IsTrackedDeviceConnected_callback*
     */
    public IVRSystem.IsTrackedDeviceConnected_callback IsTrackedDeviceConnected;
    /**
     * C type : GetBoolTrackedDeviceProperty_callback*
     */
    public IVRSystem.GetBoolTrackedDeviceProperty_callback GetBoolTrackedDeviceProperty;
    /**
     * C type : GetFloatTrackedDeviceProperty_callback*
     */
    public IVRSystem.GetFloatTrackedDeviceProperty_callback GetFloatTrackedDeviceProperty;
    /**
     * C type : GetInt32TrackedDeviceProperty_callback*
     */
    public IVRSystem.GetInt32TrackedDeviceProperty_callback GetInt32TrackedDeviceProperty;
    /**
     * C type : GetUint64TrackedDeviceProperty_callback*
     */
    public IVRSystem.GetUint64TrackedDeviceProperty_callback GetUint64TrackedDeviceProperty;
    /**
     * C type : GetMatrix34TrackedDeviceProperty_callback*
     */
    public IVRSystem.GetMatrix34TrackedDeviceProperty_callback GetMatrix34TrackedDeviceProperty;
    /**
     * C type : GetStringTrackedDeviceProperty_callback*
     */
    public IVRSystem.GetStringTrackedDeviceProperty_callback GetStringTrackedDeviceProperty;
    /**
     * C type : GetPropErrorNameFromEnum_callback*
     */
    public IVRSystem.GetPropErrorNameFromEnum_callback GetPropErrorNameFromEnum;
    /**
     * C type : PollNextEvent_callback*
     */
    public IVRSystem.PollNextEvent_callback PollNextEvent;
    /**
     * C type : PollNextEventWithPose_callback*
     */
    public IVRSystem.PollNextEventWithPose_callback PollNextEventWithPose;
    /**
     * C type : GetEventTypeNameFromEnum_callback*
     */
    public IVRSystem.GetEventTypeNameFromEnum_callback GetEventTypeNameFromEnum;
    /**
     * C type : GetHiddenAreaMesh_callback*
     */
    public IVRSystem.GetHiddenAreaMesh_callback GetHiddenAreaMesh;
    /**
     * C type : GetControllerState_callback*
     */
    public IVRSystem.GetControllerState_callback GetControllerState;
    /**
     * C type : GetControllerStateWithPose_callback*
     */
    public IVRSystem.GetControllerStateWithPose_callback GetControllerStateWithPose;
    /**
     * C type : TriggerHapticPulse_callback*
     */
    public IVRSystem.TriggerHapticPulse_callback TriggerHapticPulse;
    /**
     * C type : GetButtonIdNameFromEnum_callback*
     */
    public IVRSystem.GetButtonIdNameFromEnum_callback GetButtonIdNameFromEnum;
    /**
     * C type : GetControllerAxisTypeNameFromEnum_callback*
     */
    public IVRSystem.GetControllerAxisTypeNameFromEnum_callback GetControllerAxisTypeNameFromEnum;
    /**
     * C type : CaptureInputFocus_callback*
     */
    public IVRSystem.CaptureInputFocus_callback CaptureInputFocus;
    /**
     * C type : ReleaseInputFocus_callback*
     */
    public IVRSystem.ReleaseInputFocus_callback ReleaseInputFocus;
    /**
     * C type : IsInputFocusCapturedByAnotherProcess_callback*
     */
    public IVRSystem.IsInputFocusCapturedByAnotherProcess_callback IsInputFocusCapturedByAnotherProcess;
    /**
     * C type : DriverDebugRequest_callback*
     */
    public IVRSystem.DriverDebugRequest_callback DriverDebugRequest;
    /**
     * C type : PerformFirmwareUpdate_callback*
     */
    public IVRSystem.PerformFirmwareUpdate_callback PerformFirmwareUpdate;
    /**
     * C type : AcknowledgeQuit_Exiting_callback*
     */
    public IVRSystem.AcknowledgeQuit_Exiting_callback AcknowledgeQuit_Exiting;
    /**
     * C type : AcknowledgeQuit_UserPrompt_callback*
     */
    public IVRSystem.AcknowledgeQuit_UserPrompt_callback AcknowledgeQuit_UserPrompt;
    /**
     * C type : PerformanceTestEnableCapture_callback*
     */
    public IVRSystem.PerformanceTestEnableCapture_callback PerformanceTestEnableCapture;
    /**
     * C type : PerformanceTestReportFidelityLevelChange_callback*
     */
    public IVRSystem.PerformanceTestReportFidelityLevelChange_callback PerformanceTestReportFidelityLevelChange;

    public interface GetRecommendedRenderTargetSize_callback extends Callback {

        void apply(IntBuffer pnWidth, IntBuffer pnHeight);
    };

    public interface GetProjectionMatrix_callback extends Callback {

        vr.HmdMatrix44_t.ByValue apply(int eEye, float fNearZ, float fFarZ, int eProjType);
    };

    public interface GetProjectionRaw_callback extends Callback {

        void apply(int eEye, FloatByReference pfLeft, FloatByReference pfRight, FloatByReference pfTop, FloatByReference pfBottom);
    };

    public interface ComputeDistortion_callback extends Callback {

        boolean apply(int eEye, float fU, float fV, DistortionCoordinates_t pDistortionCoordinates);
    };

    public interface GetEyeToHeadTransform_callback extends Callback {

        HmdMatrix34_t.ByValue apply(int eEye);
    };

    public interface GetTimeSinceLastVsync_callback extends Callback {

        byte apply(FloatBuffer pfSecondsSinceLastVsync, LongBuffer pulFrameCounter);
    };

    public interface GetD3D9AdapterIndex_callback extends Callback {

        int apply();
    };

    public interface GetDXGIOutputInfo_callback extends Callback {

        void apply(IntByReference pnAdapterIndex);
    };

    public interface IsDisplayOnDesktop_callback extends Callback {

        byte apply();
    };

    public interface SetDisplayVisibility_callback extends Callback {

        byte apply(byte bIsVisibleOnDesktop);
    };

    public interface GetDeviceToAbsoluteTrackingPose_callback extends Callback {

        void apply(int eOrigin, float fPredictedSecondsToPhotonsFromNow, TrackedDevicePose_t pTrackedDevicePoseArray, int unTrackedDevicePoseArrayCount);
    };

    public interface ResetSeatedZeroPose_callback extends Callback {

        void apply();
    };

    public interface GetSeatedZeroPoseToStandingAbsoluteTrackingPose_callback extends Callback {

        HmdMatrix34_t.ByValue apply();
    };

    public interface GetRawZeroPoseToStandingAbsoluteTrackingPose_callback extends Callback {

        HmdMatrix34_t.ByValue apply();
    };

    public interface GetSortedTrackedDeviceIndicesOfClass_callback extends Callback {

        int apply(int eTrackedDeviceClass, IntByReference punTrackedDeviceIndexArray, int unTrackedDeviceIndexArrayCount, int unRelativeToTrackedDeviceIndex);
    };

    public interface GetTrackedDeviceActivityLevel_callback extends Callback {

        int apply(int unDeviceId);
    };

    public interface ApplyTransform_callback extends Callback {

        void apply(TrackedDevicePose_t pOutputPose, TrackedDevicePose_t pTrackedDevicePose, HmdMatrix34_t pTransform);
    };

    public interface GetTrackedDeviceIndexForControllerRole_callback extends Callback {

        int apply(int unDeviceType);
    };

    public interface GetControllerRoleForTrackedDeviceIndex_callback extends Callback {

        int apply(int unDeviceIndex);
    };

    public interface GetTrackedDeviceClass_callback extends Callback {

        int apply(int unDeviceIndex);
    };

    public interface IsTrackedDeviceConnected_callback extends Callback {

        byte apply(int unDeviceIndex);
    };

    public interface GetBoolTrackedDeviceProperty_callback extends Callback {

        byte apply(int unDeviceIndex, int prop, IntBuffer pError);
    };

    public interface GetFloatTrackedDeviceProperty_callback extends Callback {

        float apply(int unDeviceIndex, int prop, IntBuffer pError);
    };

    public interface GetInt32TrackedDeviceProperty_callback extends Callback {

        int apply(int unDeviceIndex, int prop, IntBuffer pError);
    };

    public interface GetUint64TrackedDeviceProperty_callback extends Callback {

        long apply(int unDeviceIndex, int prop, IntBuffer pError);
    };

    public interface GetMatrix34TrackedDeviceProperty_callback extends Callback {

        HmdMatrix34_t.ByValue apply(int unDeviceIndex, int prop, IntByReference pError);
    };

    public interface GetStringTrackedDeviceProperty_callback extends Callback {

        int apply(int unDeviceIndex, int prop, Pointer pchValue, int unBufferSize, IntBuffer pError);
    };

    public interface GetPropErrorNameFromEnum_callback extends Callback {

        Pointer apply(int error);
    };

    public interface PollNextEvent_callback extends Callback {

        byte apply(VREvent_t pEvent, int uncbVREvent);
    };

    public interface PollNextEventWithPose_callback extends Callback {

        byte apply(int eOrigin, VREvent_t pEvent, int uncbVREvent, TrackedDevicePose_t pTrackedDevicePose);
    };

    public interface GetEventTypeNameFromEnum_callback extends Callback {

        Pointer apply(int eType);
    };

    public interface GetHiddenAreaMesh_callback extends Callback {

        vr.HiddenAreaMesh_t.ByValue apply(int eEye, VR.EHiddenAreaMeshType type);
    };

    public interface GetControllerState_callback extends Callback {

        byte apply(int unControllerDeviceIndex, VRControllerState_t pControllerState, int unControllerStateSize);
    };

    public interface GetControllerStateWithPose_callback extends Callback {

        byte apply(int eOrigin, int unControllerDeviceIndex, VRControllerState_t pControllerState, int unControllerStateSize, TrackedDevicePose_t pTrackedDevicePose);
    };

    public interface TriggerHapticPulse_callback extends Callback {

        void apply(int unControllerDeviceIndex, int unAxisId, short usDurationMicroSec);
    };

    public interface GetButtonIdNameFromEnum_callback extends Callback {

        Pointer apply(int eButtonId);
    };

    public interface GetControllerAxisTypeNameFromEnum_callback extends Callback {

        Pointer apply(int eAxisType);
    };

    public interface CaptureInputFocus_callback extends Callback {

        byte apply();
    };

    public interface ReleaseInputFocus_callback extends Callback {

        void apply();
    };

    public interface IsInputFocusCapturedByAnotherProcess_callback extends Callback {

        byte apply();
    };

    public interface DriverDebugRequest_callback extends Callback {

        int apply(int unDeviceIndex, Pointer pchRequest, Pointer pchResponseBuffer, int unResponseBufferSize);
    };

    public interface PerformFirmwareUpdate_callback extends Callback {

        int apply(int unDeviceIndex);
    };

    public interface AcknowledgeQuit_Exiting_callback extends Callback {

        void apply();
    };

    public interface AcknowledgeQuit_UserPrompt_callback extends Callback {

        void apply();
    };

    public interface PerformanceTestEnableCapture_callback extends Callback {

        void apply(byte bEnable);
    };

    public interface PerformanceTestReportFidelityLevelChange_callback extends Callback {

        void apply(int nFidelityLevel);
    };

    /**
     * Private since it shouldn't be used externally
     */
    private IVRSystem() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("GetRecommendedRenderTargetSize", "GetProjectionMatrix", "GetProjectionRaw", 
                "ComputeDistortion", "GetEyeToHeadTransform", "GetTimeSinceLastVsync", "GetD3D9AdapterIndex", 
                "GetDXGIOutputInfo", "IsDisplayOnDesktop", "SetDisplayVisibility", "GetDeviceToAbsoluteTrackingPose", 
                "ResetSeatedZeroPose", "GetSeatedZeroPoseToStandingAbsoluteTrackingPose", 
                "GetRawZeroPoseToStandingAbsoluteTrackingPose", "GetSortedTrackedDeviceIndicesOfClass", 
                "GetTrackedDeviceActivityLevel", "ApplyTransform", "GetTrackedDeviceIndexForControllerRole", 
                "GetControllerRoleForTrackedDeviceIndex", "GetTrackedDeviceClass", "IsTrackedDeviceConnected", 
                "GetBoolTrackedDeviceProperty", "GetFloatTrackedDeviceProperty", "GetInt32TrackedDeviceProperty", 
                "GetUint64TrackedDeviceProperty", "GetMatrix34TrackedDeviceProperty", "GetStringTrackedDeviceProperty", 
                "GetPropErrorNameFromEnum", "PollNextEvent", "PollNextEventWithPose", "GetEventTypeNameFromEnum", 
                "GetHiddenAreaMesh", "GetControllerState", "GetControllerStateWithPose", "TriggerHapticPulse", 
                "GetButtonIdNameFromEnum", "GetControllerAxisTypeNameFromEnum", "CaptureInputFocus", 
                "ReleaseInputFocus", "IsInputFocusCapturedByAnotherProcess", "DriverDebugRequest", 
                "PerformFirmwareUpdate", "AcknowledgeQuit_Exiting", "AcknowledgeQuit_UserPrompt", 
                "PerformanceTestEnableCapture", "PerformanceTestReportFidelityLevelChange");
    }

    public IVRSystem(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends IVRSystem implements Structure.ByReference {

    };

    public static class ByValue extends IVRSystem implements Structure.ByValue {

    };
}