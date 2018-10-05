// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

// Fast Binary Encoding UShort field model class
class FieldModelUInt16(buffer: Buffer, offset: Long) : FieldModel(buffer, offset)
{
    // Field size
    override val FBESize: Long = 2

    // Get the value
    fun get(defaults: UShort = 0.toUShort()): UShort {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return defaults

        return readUInt16(FBEOffset)
    }

    // Set the value
    fun set(value: UShort) {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return

        write(FBEOffset, value)
    }
}
