// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: test.fbe
// Version: 1.1.0.0

package test

import "../fbe"
import "../proto"

// Workaround for Go unused imports issue
var _ = fbe.Version
var _ = proto.Version

// Fast Binary Encoding StructMap final model
type FinalModelStructMap struct {
    buffer *fbe.Buffer  // Final model buffer
    offset int          // Final model buffer offset

    F1 *FinalModelMapInt32Byte
    F2 *FinalModelMapInt32OptionalByte
    F3 *FinalModelMapInt32Bytes
    F4 *FinalModelMapInt32OptionalBytes
    F5 *FinalModelMapInt32EnumSimple
    F6 *FinalModelMapInt32OptionalEnumSimple
    F7 *FinalModelMapInt32FlagsSimple
    F8 *FinalModelMapInt32OptionalFlagsSimple
    F9 *FinalModelMapInt32StructSimple
    F10 *FinalModelMapInt32OptionalStructSimple
}

// Create a new StructMap final model
func NewFinalModelStructMap(buffer *fbe.Buffer, offset int) *FinalModelStructMap {
    fbeResult := FinalModelStructMap{buffer: buffer, offset: offset}
    fbeResult.F1 = NewFinalModelMapInt32Byte(buffer, 0)
    fbeResult.F2 = NewFinalModelMapInt32OptionalByte(buffer, 0)
    fbeResult.F3 = NewFinalModelMapInt32Bytes(buffer, 0)
    fbeResult.F4 = NewFinalModelMapInt32OptionalBytes(buffer, 0)
    fbeResult.F5 = NewFinalModelMapInt32EnumSimple(buffer, 0)
    fbeResult.F6 = NewFinalModelMapInt32OptionalEnumSimple(buffer, 0)
    fbeResult.F7 = NewFinalModelMapInt32FlagsSimple(buffer, 0)
    fbeResult.F8 = NewFinalModelMapInt32OptionalFlagsSimple(buffer, 0)
    fbeResult.F9 = NewFinalModelMapInt32StructSimple(buffer, 0)
    fbeResult.F10 = NewFinalModelMapInt32OptionalStructSimple(buffer, 0)
    return &fbeResult
}

// Get the allocation size
func (fm *FinalModelStructMap) FBEAllocationSize(fbeValue *StructMap) int {
    fbeResult := 0 +
        fm.F1.FBEAllocationSize(fbeValue.F1) +
        fm.F2.FBEAllocationSize(fbeValue.F2) +
        fm.F3.FBEAllocationSize(fbeValue.F3) +
        fm.F4.FBEAllocationSize(fbeValue.F4) +
        fm.F5.FBEAllocationSize(fbeValue.F5) +
        fm.F6.FBEAllocationSize(fbeValue.F6) +
        fm.F7.FBEAllocationSize(fbeValue.F7) +
        fm.F8.FBEAllocationSize(fbeValue.F8) +
        fm.F9.FBEAllocationSize(fbeValue.F9) +
        fm.F10.FBEAllocationSize(fbeValue.F10) +
        0
    return fbeResult
}

// Get the final size
func (fm *FinalModelStructMap) FBESize() int { return 0 }

// Get the final extra size
func (fm *FinalModelStructMap) FBEExtra() int { return 0 }

// Get the final type
func (fm *FinalModelStructMap) FBEType() int { return 140 }

// Get the final offset
func (fm *FinalModelStructMap) FBEOffset() int { return fm.offset }
// Set the final offset
func (fm *FinalModelStructMap) SetFBEOffset(value int) { fm.offset = value }

// Shift the current final offset
func (fm *FinalModelStructMap) FBEShift(size int) { fm.offset += size }
// Unshift the current final offset
func (fm *FinalModelStructMap) FBEUnshift(size int) { fm.offset -= size }

// Check if the struct value is valid
func (fm *FinalModelStructMap) Verify() int {
    fm.buffer.Shift(fm.FBEOffset())
    fbeResult := fm.VerifyFields()
    fm.buffer.Unshift(fm.FBEOffset())
    return fbeResult
}

// Check if the struct fields are valid
func (fm *FinalModelStructMap) VerifyFields() int {
    fbeCurrentOffset := 0
    fbeFieldSize := 0


    fm.F1.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F1.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F2.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F2.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F3.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F3.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F4.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F4.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F5.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F5.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F6.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F6.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F7.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F7.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F8.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F8.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F9.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F9.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    fm.F10.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize = fm.F10.Verify(); fbeFieldSize == fbe.MaxInt {
        return fbe.MaxInt
    }
    fbeCurrentOffset += fbeFieldSize

    return fbeCurrentOffset
}

// Get the struct value
func (fm *FinalModelStructMap) Get() (*StructMap, int, error) {
    fbeResult := NewStructMap()
    fbeSize, err := fm.GetValue(fbeResult)
    return fbeResult, fbeSize, err
}

// Get the struct value by the given pointer
func (fm *FinalModelStructMap) GetValue(fbeValue *StructMap) (int, error) {
    fm.buffer.Shift(fm.FBEOffset())
    fbeSize, err := fm.GetFields(fbeValue)
    fm.buffer.Unshift(fm.FBEOffset())
    return fbeSize, err
}

// Get the struct fields values
func (fm *FinalModelStructMap) GetFields(fbeValue *StructMap) (int, error) {
    var err error = nil
    fbeCurrentOffset := 0
    fbeCurrentSize := 0
    fbeFieldSize := 0

    fm.F1.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F1.GetValue(fbeValue.F1); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F2.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F2.GetValue(fbeValue.F2); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F3.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F3.GetValue(fbeValue.F3); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F4.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F4.GetValue(fbeValue.F4); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F5.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F5.GetValue(fbeValue.F5); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F6.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F6.GetValue(fbeValue.F6); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F7.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F7.GetValue(fbeValue.F7); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F8.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F8.GetValue(fbeValue.F8); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F9.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F9.GetValue(fbeValue.F9); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F10.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F10.GetValue(fbeValue.F10); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    return fbeCurrentSize, nil
}

// Set the struct value
func (fm *FinalModelStructMap) Set(fbeValue *StructMap) (int, error) {
    fm.buffer.Shift(fm.FBEOffset())
    fbeResult, err := fm.SetFields(fbeValue)
    fm.buffer.Unshift(fm.FBEOffset())
    return fbeResult, err
}

// Set the struct fields values
func (fm *FinalModelStructMap) SetFields(fbeValue *StructMap) (int, error) {
    var err error = nil
    fbeCurrentOffset := 0
    fbeCurrentSize := 0
    fbeFieldSize := 0

    fm.F1.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F1.Set(fbeValue.F1); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F2.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F2.Set(fbeValue.F2); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F3.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F3.Set(fbeValue.F3); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F4.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F4.Set(fbeValue.F4); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F5.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F5.Set(fbeValue.F5); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F6.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F6.Set(fbeValue.F6); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F7.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F7.Set(fbeValue.F7); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F8.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F8.Set(fbeValue.F8); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F9.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F9.Set(fbeValue.F9); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    fm.F10.SetFBEOffset(fbeCurrentOffset)
    if fbeFieldSize, err = fm.F10.Set(fbeValue.F10); err != nil {
        return fbeCurrentSize, err
    }
    fbeCurrentOffset += fbeFieldSize
    fbeCurrentSize += fbeFieldSize

    return fbeCurrentSize, nil
}