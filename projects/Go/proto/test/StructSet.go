// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: test.fbe
// Version: 1.1.0.0

package test

import "strconv"
import "strings"
import "encoding/json"
import "../fbe"
import "../proto"

// Workaround for Go unused imports issue
var _ = fbe.Version
var _ = proto.Version

// StructSet struct
type StructSet struct {
    F1 map[byte]bool
    F2 map[EnumSimpleKey]bool
    F3 map[FlagsSimpleKey]bool
    F4 map[StructSimpleKey]bool
}