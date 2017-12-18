package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class VRVulkanData_t extends Structure {
    long m_nImage;
    /**
     * struct vr::VkDevice_T *<br>
     * C type : VkDevice_T*
     */
    /* // FIXME forward declaration for vulkan
    public vr.VkDevice_T.ByReference m_pDevice; // struct VkDevice_T *
    public vr.VkPhysicalDevice_T.ByReference m_pPhysicalDevice; // struct VkPhysicalDevice_T *
    public vr.VkInstance_T.ByReference m_pInstance; // struct VkInstance_T *
    public vr.VkQueue_T.ByReference m_pQueue; // struct VkQueue_T **/
    int m_nQueueFamilyIndex;
    int m_nWidth;
    int m_nHeight;
    int m_nFormat;
    int m_nSampleCount;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("m_nImage", "m_pDevice", "m_pPhysicalDevice", "m_pInstance",
                "m_pQueue", "m_nQueueFamilyIndex", "m_nWidth", "m_nHeight", "m_nFormat",
                "m_nSampleCount");
    }

    public VRVulkanData_t() {
        super();
    }

    public VRVulkanData_t(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends VREvent_Controller_t implements Structure.ByReference {

    };

    public static class ByValue extends VREvent_Controller_t implements Structure.ByValue {

    };
}
