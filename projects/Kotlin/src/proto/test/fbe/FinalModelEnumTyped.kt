// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package test.fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

import fbe.*;
import test.*;

// Fast Binary Encoding EnumTyped final model class
class FinalModelEnumTyped(buffer: Buffer, offset: Long) : FinalModel(buffer, offset)
{
    // Get the allocation size
    @Suppress("UNUSED_PARAMETER")
    fun FBEAllocationSize(value: EnumTyped): Long {
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
    fun get(size: Size): EnumTyped {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return EnumTyped()

        size.value = FBESize
        return EnumTyped(readInt8(FBEOffset))
    }

    // Set the value
    fun set(value: EnumTyped): Long {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        write(FBEOffset, value.raw)
        return FBESize
    }
}
