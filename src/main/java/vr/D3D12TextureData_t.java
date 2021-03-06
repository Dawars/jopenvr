package vr;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class D3D12TextureData_t extends Structure {

    // FIXME forward declaration
//    public ID3D12Resource m_pResource; // struct ID3D12Resource *
//    public ID3D12CommandQueue m_pCommandQueue; // struct ID3D12CommandQueue *
    int m_nNodeMask;

    public D3D12TextureData_t() {
        super();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("m_nPreviousUniverse", "m_nCurrentUniverse");
    }


    public D3D12TextureData_t(Pointer peer) {
        super(peer);
        read();
        throw new NotImplementedException();
    }

    public static class ByReference extends D3D12TextureData_t implements Structure.ByReference {
    };

    public static class ByValue extends D3D12TextureData_t implements Structure.ByValue {
    };
}
