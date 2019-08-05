//
//  FinalModel.swift
//  fbe-example
//
//  Created by Andrey on 8/2/19.
//  Copyright © 2019 Andrey. All rights reserved.
//

import Foundation

protocol FinalModel: class {
    var _buffer: Buffer { get set }
    var _offset: Int { get set }
    
}

extension FinalModel {
    
    // Field offset
    var fbeOffset: Int {
        get {
            return _offset
        }
        set {
            _offset = newValue
        }
    }
    
    // Field size
    var fbeSize: Int {
        return 0
    }
    
    // Field extra size
    var fbeExtra: Int {
        return 0
    }
    
    // Shift the current field offset
    func fbeShift(size: Int) { _offset += size }
    // Unshift the current field offset
    func fbeUnshift(size: Int) { _offset -= size }
    
    // Check if the value is valid
    func verify() -> Bool {
        return true
    }
    
    // Buffer I/O methods
    func readBoolean(offset: Int) -> Bool { return Buffer.readBoolean(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readByte(offset: Int) -> Data.Element { return Buffer.readByte(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readChar(offset: Int) -> CChar { return Buffer.readChar(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readWChar(offset: Int) -> CChar { return Buffer.readWChar(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readInt8(offset: Int) -> Int8 { return Buffer.readInt8(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readUInt8(offset: Int) -> UInt8 { return Buffer.readUInt8(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readInt16(offset: Int) -> Int16 { return Buffer.readInt16(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readUInt16(offset: Int) -> UInt16 { return Buffer.readUInt16(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readInt32(offset: Int) -> Int32 { return Buffer.readInt32(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readUInt32(offset: Int) -> UInt32 { return Buffer.readUInt32(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readInt64(offset: Int) -> Int64 { return Buffer.readInt64(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readUInt64(offset: Int) -> UInt64 { return Buffer.readUInt64(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readFloat(offset: Int) -> Float { return Buffer.readFloat(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readDouble(offset: Int) -> Double { return Buffer.readDouble(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func readBytes(offset: Int, size: Int) -> Data { return Buffer.readBytes(buffer: _buffer.data, offset: _buffer.offset + offset, size: size) }
    func readString(offset: Int, size: Int) -> String { return Buffer.readString(buffer: _buffer.data, offset: _buffer.offset + offset, size: size) }
    func readUUID(offset: Int) -> UUID { return Buffer.readUUID(buffer: _buffer.data, offset: _buffer.offset + offset) }
    func write(offset: Int, value: Bool) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Int8) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: UInt8) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Int16) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: UInt16) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Int32) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: UInt32) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Int64) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: UInt64) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Float) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Double) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Data) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    func write(offset: Int, value: Data, valueOffset: Int, valueSize: Int) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value, valueOffset: valueOffset, valueSize: valueSize) }
    func write(offset: Int, value: Data.Element, valueCount: Int) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value, valueCount: valueCount) }
    func write(offset: Int, value: UUID) { Buffer.write(buffer: &_buffer.data, offset: _buffer.offset + offset, value: value) }
    
}
