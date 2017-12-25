package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DriverDirectMode_FrameTiming extends Structure {

    public int m_nSize; // Set to sizeof( DriverDirectMode_FrameTiming )
    public int m_nNumFramePresents; // number of times frame was presented
    public int m_nNumMisPresented; // number of times frame was presented on a vsync other than it was originally predicted to
    public int m_nNumDroppedFrames; // number of additional times previous frame was scanned out (i.e. compositor missed vsync)
    public int m_nReprojectionFlags;

    public DriverDirectMode_FrameTiming() {
        super();
    }

    public DriverDirectMode_FrameTiming(Pointer p) {
        super(p);
        read();
    }

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("m_nSize", "m_nNumFramePresents", "m_nNumMisPresented",
                "m_nNumDroppedFrames", "m_nReprojectionFlags");
    }

    public static class ByReference extends DriverDirectMode_FrameTiming implements Structure.ByReference {
    }

    public static class ByValue extends DriverDirectMode_FrameTiming implements Structure.ByValue {
    }
}
