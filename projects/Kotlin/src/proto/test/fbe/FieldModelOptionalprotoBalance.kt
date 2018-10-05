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

// Fast Binary Encoding optional protoBalance field model class
class FieldModelOptionalprotoBalance(buffer: Buffer, offset: Long) : FieldModel(buffer, offset)
{
    // Field size
    override val FBESize: Long = (1 + 4).toLong()

    // Field extra size
    override val FBEExtra: Long get() {
        if (!hasValue())
            return 0

        val fbeOptionalOffset = readInt32(FBEOffset + 1)
        if (fbeOptionalOffset == 0 || _buffer.offset + fbeOptionalOffset.toLong() + 4 > _buffer.size)
            return 0

        _buffer.shift(fbeOptionalOffset.toLong())
        val fbeResult = value.FBESize + value.FBEExtra
        _buffer.unshift(fbeOptionalOffset.toLong())
        return fbeResult
    }

    // Checks whether the object contains a value
    fun hasValue(): Boolean {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return false

        val fbeHasValue = readInt8(FBEOffset)
        return fbeHasValue.toInt() != 0
    }

    // Base field model value
    val value = proto.fbe.FieldModelBalance(buffer, 0)

    // Check if the optional value is valid
    override fun verify(): Boolean {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return true

        val fbeHasValue = readInt8(FBEOffset)
        if (fbeHasValue.toInt() == 0)
            return true

        val fbeOptionalOffset = readInt32(FBEOffset)
        if (fbeOptionalOffset == 0)
            return false

        _buffer.shift(fbeOptionalOffset.toLong())
        val fbeResult = value.verify()
        _buffer.unshift(fbeOptionalOffset.toLong())
        return fbeResult
    }

    // Get the optional value (being phase)
    fun getBegin(): Long {
        if (!hasValue())
            return 0

        val fbeOptionalOffset = readInt32(FBEOffset + 1)
        assert(fbeOptionalOffset > 0) { "Model is broken!" }
        if (fbeOptionalOffset <= 0)
            return 0

        _buffer.shift(fbeOptionalOffset.toLong())
        return fbeOptionalOffset.toLong()
    }

    // Get the optional value (end phase)
    fun getEnd(fbeBegin: Long) {
        _buffer.unshift(fbeBegin)
    }

    // Get the optional value
    fun get(defaults: proto.Balance? = null): proto.Balance? {
        val fbeBegin = getBegin()
        if (fbeBegin == 0L)
            return defaults

        val optional = value.get()

        getEnd(fbeBegin)

        return optional
    }

    // Set the optional value (begin phase)
    fun setBegin(hasValue: Boolean): Long {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        val fbeHasValue = (if (hasValue) 1 else 0).toByte()
        write(FBEOffset, fbeHasValue)
        if (fbeHasValue.toInt() == 0)
            return 0

        val fbeOptionalSize = value.FBESize.toInt()
        val fbeOptionalOffset = (_buffer.allocate(fbeOptionalSize.toLong()) - _buffer.offset).toInt()
        assert(fbeOptionalOffset > 0 && _buffer.offset + fbeOptionalOffset.toLong() + fbeOptionalSize.toLong() <= _buffer.size) { "Model is broken!" }
        if (fbeOptionalOffset <= 0 || _buffer.offset + fbeOptionalOffset.toLong() + fbeOptionalSize.toLong() > _buffer.size)
            return 0

        write(FBEOffset + 1, fbeOptionalOffset)

        _buffer.shift(fbeOptionalOffset.toLong())
        return fbeOptionalOffset.toLong()
    }

    // Set the optional value (end phase)
    fun setEnd(fbeBegin: Long) {
        _buffer.unshift(fbeBegin)
    }

    // Set the optional value
    fun set(optional: proto.Balance?) {
        val fbeBegin = setBegin(optional != null)
        if (fbeBegin == 0L)
            return

        value.set(optional!!)

        setEnd(fbeBegin)
    }
}
