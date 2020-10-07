// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: proto.fbe
// Version: 1.4.0.0

package com.chronoxor.proto;

public enum OrderTypeEnum
{
    market((byte)0 + 0)
    , limit((byte)0 + 1)
    , stop((byte)0 + 2)
    ;

    private byte value;

    OrderTypeEnum(byte value) { this.value = value; }
    OrderTypeEnum(int value) { this.value = (byte)value; }
    OrderTypeEnum(OrderTypeEnum value) { this.value = value.value; }

    public byte getRaw() { return value; }

    public static OrderTypeEnum mapValue(byte value) { return mapping.get(value); }

    @Override
    public String toString()
    {
        if (this == market) return "market";
        if (this == limit) return "limit";
        if (this == stop) return "stop";
        return "<unknown>";
    }

    private static final java.util.Map<Byte, OrderTypeEnum> mapping = new java.util.HashMap<>();
    static
    {
        for (var value : OrderTypeEnum.values())
            mapping.put(value.value, value);
    }
}