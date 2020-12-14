// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: test.fbe
// Version: 1.5.0.0

@file:Suppress("UnusedImport", "unused")

package com.chronoxor.test.fbe

// Fast Binary Encoding FlagsTyped field model
class FieldModelFlagsTyped(buffer: com.chronoxor.fbe.Buffer, offset: Long) : com.chronoxor.fbe.FieldModel(buffer, offset)
{
    // Field size
    override val fbeSize: Long = 8

    // Get the value
    fun get(defaults: com.chronoxor.test.FlagsTyped = com.chronoxor.test.FlagsTyped()): com.chronoxor.test.FlagsTyped
    {
        if ((_buffer.offset + fbeOffset + fbeSize) > _buffer.size)
            return defaults

        return com.chronoxor.test.FlagsTyped(readUInt64(fbeOffset))
    }

    // Set the value
    fun set(value: com.chronoxor.test.FlagsTyped)
    {
        assert((_buffer.offset + fbeOffset + fbeSize) <= _buffer.size) { "Model is broken!" }
        if ((_buffer.offset + fbeOffset + fbeSize) > _buffer.size)
            return

        write(fbeOffset, value.raw)
    }
}