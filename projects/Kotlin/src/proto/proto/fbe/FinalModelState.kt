// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package proto.fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

import fbe.*;
import proto.*;

// Fast Binary Encoding State final model class
class FinalModelState(buffer: Buffer, offset: Long) : FinalModel(buffer, offset)
{
    // Get the allocation size
    @Suppress("UNUSED_PARAMETER")
    fun FBEAllocationSize(value: State): Long {
        return FBESize
    }

    // Final size
    override val FBESize: Long = 1

    // Check if the value is valid
    override fun verify(): Long {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return Long.MAX_VALUE

        return FBESize
    }

    // Get the value
    fun get(size: Size): State {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return State()

        size.value = FBESize
        return State(readByte(FBEOffset))
    }

    // Set the value
    fun set(value: State): Long {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        write(FBEOffset, value.raw)
        return FBESize
    }
}
