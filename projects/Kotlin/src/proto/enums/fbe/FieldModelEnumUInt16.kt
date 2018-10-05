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

// Fast Binary Encoding EnumUInt16 field model class
class FieldModelEnumUInt16(buffer: Buffer, offset: Long) : FieldModel(buffer, offset)
{
    // Field size
    override val FBESize: Long = 2

    // Get the value
    fun get(defaults: EnumUInt16 = EnumUInt16()): EnumUInt16 {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return defaults

        return EnumUInt16(readUInt16(FBEOffset))
    }

    // Set the value
    fun set(value: EnumUInt16) {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return

        write(FBEOffset, value.raw)
    }
}
