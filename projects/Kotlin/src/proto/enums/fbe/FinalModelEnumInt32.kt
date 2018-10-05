// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package enums.fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

import fbe.*;
import enums.*;

// Fast Binary Encoding EnumInt32 final model class
class FinalModelEnumInt32(buffer: Buffer, offset: Long) : FinalModel(buffer, offset)
{
    // Get the allocation size
    @Suppress("UNUSED_PARAMETER")
    fun FBEAllocationSize(value: EnumInt32): Long {
        return FBESize
    }

    // Final size
    override val FBESize: Long = 4

    // Check if the value is valid
    override fun verify(): Long {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return Long.MAX_VALUE

        return FBESize
    }

    // Get the value
    fun get(size: Size): EnumInt32 {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return EnumInt32()

        size.value = FBESize
        return EnumInt32(readInt32(FBEOffset))
    }

    // Set the value
    fun set(value: EnumInt32): Long {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        write(FBEOffset, value.raw)
        return FBESize
    }
}
