// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package enums;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;
import fbe.*;

class EnumInt8 : Comparable<EnumInt8>
{
    companion object {
        val ENUM_VALUE_0 = EnumInt8(EnumInt8Enum.ENUM_VALUE_0)
        val ENUM_VALUE_1 = EnumInt8(EnumInt8Enum.ENUM_VALUE_1)
        val ENUM_VALUE_2 = EnumInt8(EnumInt8Enum.ENUM_VALUE_2)
        val ENUM_VALUE_3 = EnumInt8(EnumInt8Enum.ENUM_VALUE_3)
        val ENUM_VALUE_4 = EnumInt8(EnumInt8Enum.ENUM_VALUE_4)
        val ENUM_VALUE_5 = EnumInt8(EnumInt8Enum.ENUM_VALUE_5)
    }

    var value: EnumInt8Enum? = EnumInt8Enum.values()[0]
        private set

    val raw: Byte
        get() = value!!.raw

    constructor()
    constructor(value: Byte) { setEnum(value) }
    constructor(value: EnumInt8Enum) { setEnum(value) }
    constructor(value: EnumInt8) { setEnum(value) }

    fun setDefault() { setEnum(0.toByte()) }

    fun setEnum(value: Byte) { this.value = EnumInt8Enum.mapValue(value) }
    fun setEnum(value: EnumInt8Enum) { this.value = value }
    fun setEnum(value: EnumInt8) { this.value = value.value }

    override fun compareTo(other: EnumInt8): Int {
        if (value == null)
            return -1
        if (other.value == null)
            return 1
        return (value!!.raw - other.value!!.raw).toInt()
    }

    override fun equals(other: Any?): Boolean {
        if (other == null)
            return false

        if (!EnumInt8::class.java.isAssignableFrom(other.javaClass))
            return false

        val enm = other as EnumInt8?

        if (value == null || enm!!.value == null)
            return false
        if (value!!.raw != enm.value!!.raw)
            return false
        return true
    }

    override fun hashCode(): Int {
        var hash = 17
        hash = hash * 31 + if (value != null) value!!.hashCode() else 0
        return hash
    }

    override fun toString(): String {
        return if (value != null) value!!.toString() else "<unknown>"
    }
}
