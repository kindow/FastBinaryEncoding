// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: enums.fbe
// Version: 1.1.0.0

package enums

import "encoding/json"
import "../fbe"

// Workaround for Go unused imports issue
var _ = fbe.Version

// EnumWChar enum key
type EnumWCharKey uint32

// Convert EnumWChar enum key to string
func (k EnumWCharKey) String() string {
    return EnumWChar(k).String()
}

// EnumWChar enum
type EnumWChar uint32

// EnumWChar enum values
//noinspection GoSnakeCaseUsage
const (
    EnumWChar_ENUM_VALUE_0 = EnumWChar(0 + 0)
    EnumWChar_ENUM_VALUE_1 = EnumWChar(0x0444 + 0)
    EnumWChar_ENUM_VALUE_2 = EnumWChar(0x0444 + 1)
    EnumWChar_ENUM_VALUE_3 = EnumWChar(0x0555 + 0)
    EnumWChar_ENUM_VALUE_4 = EnumWChar(0x0555 + 1)
    EnumWChar_ENUM_VALUE_5 = EnumWChar(EnumWChar_ENUM_VALUE_3)
)

// Create a new EnumWChar enum
func NewEnumWChar() *EnumWChar {
    return new(EnumWChar)
}

// Get the enum key
func (e EnumWChar) Key() EnumWCharKey {
    return EnumWCharKey(e)
}

// Convert enum to string
func (e EnumWChar) String() string {
    if e == EnumWChar_ENUM_VALUE_0 {
        return "ENUM_VALUE_0"
    }
    if e == EnumWChar_ENUM_VALUE_1 {
        return "ENUM_VALUE_1"
    }
    if e == EnumWChar_ENUM_VALUE_2 {
        return "ENUM_VALUE_2"
    }
    if e == EnumWChar_ENUM_VALUE_3 {
        return "ENUM_VALUE_3"
    }
    if e == EnumWChar_ENUM_VALUE_4 {
        return "ENUM_VALUE_4"
    }
    if e == EnumWChar_ENUM_VALUE_5 {
        return "ENUM_VALUE_5"
    }
    return "<unknown>"
}

// Convert enum to JSON
func (e EnumWChar) MarshalJSON() ([]byte, error) {
    return json.Marshal(uint32(e))
}

// Convert JSON to enum
func (e *EnumWChar) UnmarshalJSON(b []byte) error {
    var result uint32
    err := json.Unmarshal(b, &result)
    if err != nil {
        return err
    }
    *e = EnumWChar(result)
    return nil
}