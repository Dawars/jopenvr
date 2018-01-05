package vr;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class IVRDriverManager_FnTable extends Structure {

    public IVRDriverManager_FnTable.GetDriverCount_callback GetDriverCount;
    public IVRDriverManager_FnTable.GetDriverName_callback GetDriverName;

    public interface GetDriverCount_callback extends Callback {
        int apply();
    }

    public interface GetDriverName_callback extends Callback {
        /**
         * Returns the length of the number of bytes necessary to hold this string including the trailing null.
         */
        int apply(int nDriver, Pointer pchValue, int unBufferSize);
    }


    public IVRDriverManager_FnTable() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("GetDriverCount", "GetDriverName");
    }

    /**
     * @param GetDriverCount C type : GetDriverCount_callback*<br>
     * @param GetDriverName  C type : GetDriverName_callback*<br>
     */
    public IVRDriverManager_FnTable(GetDriverCount_callback GetDriverCount, GetDriverName_callback GetDriverName) {
        super();
        this.GetDriverCount = GetDriverCount;
        this.GetDriverName = GetDriverName;
    }

    public IVRDriverManager_FnTable(Pointer peer) {
        super(peer);
        read();
    }

    public static class ByReference extends IVRDriverManager_FnTable implements Structure.ByReference {

    }

    public static class ByValue extends IVRDriverManager_FnTable implements Structure.ByValue {

    }
}
