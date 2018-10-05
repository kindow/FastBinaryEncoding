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

// Fast Binary Encoding String->EnumSimple map field model class
class FieldModelMapStringEnumSimple(buffer: Buffer, offset: Long) : FieldModel(buffer, offset)
{
    private val _modelKey = FieldModelString(buffer, offset)
    private val _modelValue = FieldModelEnumSimple(buffer, offset)

    // Field size
    override val FBESize: Long = 4

    // Field extra size
    override val FBEExtra: Long get() {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        val fbeMapOffset = readInt32(FBEOffset).toLong()
        if (fbeMapOffset == 0L || _buffer.offset + fbeMapOffset + 4 > _buffer.size)
            return 0

        val fbeMapSize = readInt32(fbeMapOffset).toLong()

        var fbeResult: Long = 4
        _modelKey.FBEOffset = fbeMapOffset + 4
        _modelValue.FBEOffset = fbeMapOffset + 4 + _modelKey.FBESize
        var i = fbeMapSize
        while (i-- > 0) {
            fbeResult += _modelKey.FBESize + _modelKey.FBEExtra
            _modelKey.FBEShift(_modelKey.FBESize + _modelValue.FBESize)

            fbeResult += _modelValue.FBESize + _modelValue.FBEExtra
            _modelValue.FBEShift(_modelKey.FBESize + _modelValue.FBESize)
        }
        return fbeResult
    }

    // Get the map offset
    val offset: Long get() {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        val fbeMapOffset = readInt32(FBEOffset).toLong()
        return fbeMapOffset
    }

    // Get the map size
    val size: Long get() {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return 0

        val fbeMapOffset = readInt32(FBEOffset).toLong()
        if (fbeMapOffset == 0L || _buffer.offset + fbeMapOffset + 4 > _buffer.size)
            return 0

        val fbeMapSize = readInt32(fbeMapOffset).toLong()
        return fbeMapSize
    }

    // Map index operator
    fun getItem(index: Long): Pair<FieldModelString, FieldModelEnumSimple> {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }

        val fbeMapOffset = readInt32(FBEOffset).toLong()
        assert(fbeMapOffset > 0 && _buffer.offset + fbeMapOffset + 4 <= _buffer.size) { "Model is broken!" }

        val fbeMapSize = readInt32(fbeMapOffset).toLong()
        assert(index < fbeMapSize) { "Index is out of bounds!" }

        _modelKey.FBEOffset = fbeMapOffset + 4
        _modelValue.FBEOffset = fbeMapOffset + 4 + _modelKey.FBESize
        _modelKey.FBEShift(index * (_modelKey.FBESize + _modelValue.FBESize))
        _modelValue.FBEShift(index * (_modelKey.FBESize + _modelValue.FBESize))
        return Pair(_modelKey, _modelValue)
    }

    // Resize the map and get its first model
    fun resize(size: Long): Pair<FieldModelString, FieldModelEnumSimple> {
        _modelKey.FBEOffset = FBEOffset
        _modelValue.FBEOffset = FBEOffset + _modelKey.FBESize

        val fbeMapSize = size * (_modelKey.FBESize + _modelValue.FBESize)
        val fbeMapOffset = _buffer.allocate(4 + fbeMapSize) - _buffer.offset
        assert(fbeMapOffset > 0 && _buffer.offset + fbeMapOffset + 4 <= _buffer.size) { "Model is broken!" }

        write(FBEOffset, fbeMapOffset)
        write(fbeMapOffset, size.toInt())
        write(fbeMapOffset + 4, 0.toByte(), fbeMapSize)

        _modelKey.FBEOffset = fbeMapOffset + 4
        _modelValue.FBEOffset = fbeMapOffset + 4 + _modelKey.FBESize
        return Pair(_modelKey, _modelValue)
    }

    // Check if the map is valid
    override fun verify(): Boolean {
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return true

        val fbeMapOffset = readInt32(FBEOffset).toLong()
        if (fbeMapOffset == 0L)
            return true

        if (_buffer.offset + fbeMapOffset + 4 > _buffer.size)
            return false

        val fbeMapSize = readInt32(fbeMapOffset).toLong()

        _modelKey.FBEOffset = fbeMapOffset + 4
        _modelValue.FBEOffset = fbeMapOffset + 4 + _modelKey.FBESize
        var i = fbeMapSize
        while (i-- > 0) {
            if (!_modelKey.verify())
                return false
            _modelKey.FBEShift(_modelKey.FBESize + _modelValue.FBESize)
            if (!_modelValue.verify())
                return false
            _modelValue.FBEShift(_modelKey.FBESize + _modelValue.FBESize)
        }

        return true
    }

    // Get the map as TreeMap
    fun get(values: TreeMap<String, EnumSimple>) {
        values.clear()

        val fbeMapSize = size
        if (fbeMapSize == 0L)
            return

        val fbeModel = getItem(0)
        var i = fbeMapSize
        while (i-- > 0) {
            val key = fbeModel.first.get()
            val value = fbeModel.second.get()
            values[key] = value
            fbeModel.first.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
            fbeModel.second.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
        }
    }

    // Get the map as HashMap
    fun get(values: HashMap<String, EnumSimple>) {
        values.clear()

        val fbeMapSize = size
        if (fbeMapSize == 0L)
            return

        val fbeModel = getItem(0)
        var i = fbeMapSize
        while (i-- > 0) {
            val key = fbeModel.first.get()
            val value = fbeModel.second.get()
            values[key] = value
            fbeModel.first.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
            fbeModel.second.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
        }
    }

    // Set the map as TreeMap
    fun set(values: TreeMap<String, EnumSimple>) {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return

        val fbeModel = resize(values.size.toLong())
        for ((key, value1) in values) {
            fbeModel.first.set(key)
            fbeModel.first.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
            fbeModel.second.set(value1)
            fbeModel.second.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
        }
    }

    // Set the vector as HashMap
    fun set(values: HashMap<String, EnumSimple>) {
        assert(_buffer.offset + FBEOffset + FBESize <= _buffer.size) { "Model is broken!" }
        if (_buffer.offset + FBEOffset + FBESize > _buffer.size)
            return

        val fbeModel = resize(values.size.toLong())
        for ((key, value1) in values) {
            fbeModel.first.set(key)
            fbeModel.first.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
            fbeModel.second.set(value1)
            fbeModel.second.FBEShift(fbeModel.first.FBESize + fbeModel.second.FBESize)
        }
    }
}
