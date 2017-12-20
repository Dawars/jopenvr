import com.jogamp.opengl.util.GLBuffers;
import org.junit.*;
import vr.IVRCompositor_FnTable;
import vr.IVRSystem;
import vr.VR;

import java.nio.IntBuffer;

public class InitTest {

    private static IVRSystem hmd;
    private static IntBuffer errorBuffer = GLBuffers.newDirectIntBuffer(1);
    private static IVRCompositor_FnTable compositor;

    @Test
    public void isAvailable() {
        System.out.println("VR_IsRuntimeInstalled(): " + VR.VR_IsRuntimeInstalled());
        System.out.println("VR_IsHmdPresent(): " + VR.VR_IsHmdPresent());
    }

    @Test
    public void initCompositor() {
        compositor = new IVRCompositor_FnTable(VR.VR_GetGenericInterface(VR.IVRCompositor_Version, errorBuffer));

        assert(errorBuffer.get(0) == VR.EVRInitError.VRInitError_None);
    }

    @Test
    public void getTargetSize(){
        IntBuffer width = GLBuffers.newDirectIntBuffer(1), height = GLBuffers.newDirectIntBuffer(1);

        hmd.GetRecommendedRenderTargetSize.apply(width, height);

        int w = width.get(0);
        int h = height.get(0);

        System.out.println("Width: " + w + " Height: " + h);

        assert(w > 0);
        assert(h > 0);
    }

    @Before
    public void reset() {
        errorBuffer.put(0, 0);
    }

    @BeforeClass
    public static void init() {
        hmd = VR.VR_Init(errorBuffer, VR.EVRApplicationType.VRApplication_Scene);

        if (errorBuffer.get(0) != VR.EVRInitError.VRInitError_None) {
            hmd = null;
            String s = "Unable to init VR runtime: " + VR.VR_GetVRInitErrorAsEnglishDescription(errorBuffer.get(0));
            throw new Error("VR_Init Failed, " + s);
        }
    }

    @AfterClass
    public static void shutdown() {
        VR.VR_Shutdown();
    }
}