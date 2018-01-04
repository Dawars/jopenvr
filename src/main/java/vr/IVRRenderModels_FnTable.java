package vr;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

/**
 * This file was autogenerated by
 * <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that
 * <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a
 * few opensource projects.</a>.<br>
 * For help, please visit
 * <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> ,
 * <a href="http://rococoa.dev.java.net/">Rococoa</a>, or
 * <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class IVRRenderModels_FnTable extends Structure {

    /**
     * C type : LoadRenderModel_Async_callback*
     */
    public LoadRenderModel_Async_callback LoadRenderModel_Async;
    /**
     * C type : FreeRenderModel_callback*
     */
    public FreeRenderModel_callback FreeRenderModel;
    /**
     * C type : LoadTexture_Async_callback*
     */
    public LoadTexture_Async_callback LoadTexture_Async;
    /**
     * C type : FreeTexture_callback*
     */
    public FreeTexture_callback FreeTexture;
    /**
     * C type : LoadTextureD3D11_Async_callback*
     */
    public LoadTextureD3D11_Async_callback LoadTextureD3D11_Async;

    /*
        EVRRenderModelError (OPENVR_FNTABLE_CALLTYPE *LoadIntoTextureD3D11_Async)(TextureID_t textureId, void * pDstTexture);

     */
    public LoadIntoTextureD3D11_Async_callback LoadIntoTextureD3D11_Async;

    /**
     * C type : FreeTextureD3D11_callback*
     */
    public FreeTextureD3D11_callback FreeTextureD3D11;
    /**
     * C type : GetRenderModelName_callback*
     */
    public GetRenderModelName_callback GetRenderModelName;
    /**
     * C type : GetRenderModelCount_callback*
     */
    public GetRenderModelCount_callback GetRenderModelCount;
    /**
     * C type : GetComponentCount_callback*
     */
    public GetComponentCount_callback GetComponentCount;
    /**
     * C type : GetComponentName_callback*
     */
    public GetComponentName_callback GetComponentName;
    /**
     * C type : GetComponentButtonMask_callback*
     */
    public GetComponentButtonMask_callback GetComponentButtonMask;
    /**
     * C type : GetComponentRenderModelName_callback*
     */
    public GetComponentRenderModelName_callback GetComponentRenderModelName;
    /**
     * C type : GetComponentState_callback*
     */
    public GetComponentState_callback GetComponentState;
    /**
     * C type : RenderModelHasComponent_callback*
     */
    public RenderModelHasComponent_callback RenderModelHasComponent;
    /*
        uint32_t (OPENVR_FNTABLE_CALLTYPE *GetRenderModelThumbnailURL)(char * pchRenderModelName, char * pchThumbnailURL, uint32_t unThumbnailURLLen, EVRRenderModelError * peError);

     */
    public GetRenderModelThumbnailURL_callback GetRenderModelThumbnailURL;
    /*
    	uint32_t (OPENVR_FNTABLE_CALLTYPE *GetRenderModelOriginalPath)(char * pchRenderModelName, char * pchOriginalPath, uint32_t unOriginalPathLen, EVRRenderModelError * peError);

     */
    public GetRenderModelOriginalPath_callback GetRenderModelOriginalPath;
    /*
    	char * (OPENVR_FNTABLE_CALLTYPE *GetRenderModelErrorNameFromEnum)(EVRRenderModelError error);

     */
    public GetRenderModelErrorNameFromEnum_callback GetRenderModelErrorNameFromEnum;
    /** Loads and returns a render model for use in the application. pchRenderModelName should be a render model name
     * from the Prop_RenderModelName_String property or an absolute path name to a render model on disk.
     *
     * The resulting render model is valid until VR_Shutdown() is called or until FreeRenderModel() is called. When the
     * application is finished with the render model it should call FreeRenderModel() to free the memory associated
     * with the model.
     *
     * The method returns VRRenderModelError_Loading while the render model is still being loaded.
     * The method returns VRRenderModelError_None once loaded successfully, otherwise will return an error. */
    public interface LoadRenderModel_Async_callback extends Callback {

        int apply(String pchRenderModelName, PointerByReference ppRenderModel);
    };

    public interface FreeRenderModel_callback extends Callback {

        void apply(RenderModel_t.ByReference pRenderModel);
    };

    public interface LoadTexture_Async_callback extends Callback {

        int apply(int textureId, PointerByReference ppTexture);
    }

    public interface FreeTexture_callback extends Callback {

        void apply(RenderModel_TextureMap_t pTexture);
    }

    public interface LoadTextureD3D11_Async_callback extends Callback {

        int apply(int textureId, Pointer pD3D11Device, PointerByReference ppD3D11Texture2D);
    }

    public interface LoadIntoTextureD3D11_Async_callback extends Callback {

        int apply(int textureId, Pointer pDstTexture);
    }

    public interface FreeTextureD3D11_callback extends Callback {

        void apply(Pointer pD3D11Texture2D);
    }

    public interface GetRenderModelName_callback extends Callback {

        int apply(int unRenderModelIndex, Pointer pchRenderModelName, int unRenderModelNameLen);
    }

    public interface GetRenderModelCount_callback extends Callback {

        int apply();
    }

    public interface GetComponentCount_callback extends Callback {

        int apply(String pchRenderModelName);
    }

    public interface GetComponentName_callback extends Callback {

        int apply(Pointer pchRenderModelName, int unComponentIndex, Pointer pchComponentName, int unComponentNameLen);
    }

    public interface GetComponentButtonMask_callback extends Callback {

        long apply(Pointer pchRenderModelName, Pointer pchComponentName);
    }

    public interface GetComponentRenderModelName_callback extends Callback {

        int apply(Pointer pchRenderModelName, Pointer pchComponentName, Pointer pchComponentRenderModelName, int unComponentRenderModelNameLen);
    }

    public interface GetComponentState_callback extends Callback {

        boolean apply(Pointer pchRenderModelName, Pointer pchComponentName, VRControllerState_t pControllerState, RenderModel_ControllerMode_State_t pState, RenderModel_ComponentState_t pComponentState);
    }

    public interface RenderModelHasComponent_callback extends Callback {

        boolean apply(Pointer pchRenderModelName, Pointer pchComponentName);
    }

    public interface GetRenderModelThumbnailURL_callback extends Callback {

        int apply(Pointer pchRenderModelName, Pointer pchThumbnailURL, int unThumbnailURLLen, IntByReference peError);
    }

    public interface GetRenderModelOriginalPath_callback extends Callback {

        int apply(Pointer pchRenderModelName, Pointer pchOriginalPath, int unOriginalPathLen, IntByReference peError);
    }

    public interface GetRenderModelErrorNameFromEnum_callback extends Callback {

        Pointer apply(int error);
    }

    public IVRRenderModels_FnTable() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("LoadRenderModel_Async", "FreeRenderModel",
                "LoadTexture_Async", "FreeTexture", "LoadTextureD3D11_Async", "LoadIntoTextureD3D11_Async",
                "FreeTextureD3D11", "GetRenderModelName", "GetRenderModelCount",
                "GetComponentCount", "GetComponentName", "GetComponentButtonMask",
                "GetComponentRenderModelName", "GetComponentState", "RenderModelHasComponent",
                "GetRenderModelThumbnailURL", "GetRenderModelOriginalPath", "GetRenderModelErrorNameFromEnum");
    }

    public IVRRenderModels_FnTable(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends IVRRenderModels_FnTable implements Structure.ByReference {

    }

    public static class ByValue extends IVRRenderModels_FnTable implements Structure.ByValue {

    }
}
