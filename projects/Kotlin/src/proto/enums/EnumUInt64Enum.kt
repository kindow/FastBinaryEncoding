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

enum class EnumUInt64Enum
{
    ENUM_VALUE_0(0u + 0u)
    , ENUM_VALUE_1(0u + 0u)
    , ENUM_VALUE_2(0u + 1u)
    , ENUM_VALUE_3(0xFFFFFFFFFFFFFFFEu + 0u)
    , ENUM_VALUE_4(0xFFFFFFFFFFFFFFFEu + 1u)
    , ENUM_VALUE_5(ENUM_VALUE_3.raw)
    ;

    var raw: ULong = 0u
        private set

    constructor(value: UByte) { this.raw = value.toULong() }
    constructor(value: UShort) { this.raw = value.toULong() }
    constructor(value: UInt) { this.raw = value.toULong() }
    constructor(value: ULong) { this.raw = value.toULong() }
    constructor(value: EnumUInt64Enum) { this.raw = value.raw }

    override fun toString(): String {
        if (this == ENUM_VALUE_0) return "ENUM_VALUE_0"
        if (this == ENUM_VALUE_1) return "ENUM_VALUE_1"
        if (this == ENUM_VALUE_2) return "ENUM_VALUE_2"
        if (this == ENUM_VALUE_3) return "ENUM_VALUE_3"
        if (this == ENUM_VALUE_4) return "ENUM_VALUE_4"
        if (this == ENUM_VALUE_5) return "ENUM_VALUE_5"
        return "<unknown>"
    }

    companion object {
        private val mapping = HashMap<ULong, EnumUInt64Enum>()

        init {
            for (value in EnumUInt64Enum.values())
                mapping[value.raw] = value
        }

        fun mapValue(value: ULong): EnumUInt64Enum? { return mapping[value] }
    }
}
