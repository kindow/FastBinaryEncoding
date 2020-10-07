// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: FBE
// Version: 1.4.0.0

import Foundation
public class Buffer {

    // Get bytes memory buffer
    public internal(set) var data = Data()

    // Get bytes memory buffer capacity
    public var capacity: Int {
        return data.count
    }

    // Is the buffer empty?
    public var empty: Bool {
        return size == 0
    }

    // Get bytes memory buffer size
    public private(set) var size: Int = 0
    // Get bytes memory buffer offset
    public private(set) var offset: Int = 0

    // Initialize a new expandable buffer with zero capacity
    public init() {}
    // Initialize a new expandable buffer with the given capacity
    public init(capacity: Int) { attach(capacity: capacity) }
    // Initialize a new buffer based on the specified byte array
    public init(buffer: Data) { attach(buffer: buffer) }
    // Initialize a new buffer based on the specified region (offset) of a byte array
    public init(buffer: Data, offset: Int) { attach(buffer: buffer, offset: offset) }
    // Initialize a new buffer based on the specified region (size and offset) of a byte array
    public init(buffer: Data, size: Int, offset: Int) { attach(buffer: buffer, size: size, offset: offset) }

    public func attach() {
        data = Data(capacity: 0)
        size = 0
        offset = 0
    }

    // Attach memory buffer methods
    public func attach(capacity: Int) {
        data = Data(capacity: capacity)
        size = 0
        offset = 0
    }

    public func attach(buffer: Data) {
        data = buffer
        size = buffer.count
        offset = 0
    }

    public func attach(buffer: Data, offset: Int) {
        data = buffer
        size = buffer.count
        self.offset = offset
    }

    public func attach(buffer: Data, size: Int, offset: Int) {
        data = buffer
        self.size = size
        self.offset = offset
    }

    // Allocate memory in the current buffer and return offset to the allocated memory block
    public func allocate(size: Int) throws -> Int {

        if size < 0 {
            throw NSException(name: .invalidArgumentException, reason: "Invalid allocation size!") as! Error
        }

        let offset = self.size

        // Calculate a new buffer size
        let total = Int(self.size + size)

        if total <= data.count {
            self.size = total
            return offset
        }

        var data = Data(count: max(total, 2 * self.size))
        data.withUnsafeMutableBytes { (body: UnsafeMutableRawBufferPointer) in
            if let baseAddress = body.baseAddress, body.count > 0 {
                let pointer = baseAddress.assumingMemoryBound(to: UInt8.self)
                self.data.copyBytes(to: pointer, count: self.data.count)
            }
        }
        self.data = data
        self.size += size

        return offset
    }

    // Remove some memory of the given size from the current buffer
    public func remove(offset: Int, size: Int) throws {
        if offset + size > self.size {
            throw NSException(name: .invalidArgumentException, reason: "Invalid offset & size!") as! Error
        }
        if size != 0 {
            if self.size - size - offset != 0 {
                data[offset...] = data[(offset + size)..<self.size]
            } else {
                data = data[0..<offset]
            }
        }
        self.size -= size
        if self.offset >= offset + size {
            self.offset -= size
        } else if self.offset >= offset {
            self.offset -= self.offset - offset
            if self.offset > self.size {
                self.offset = self.size
            }
        }
    }

    // Reserve memory of the given capacity in the current buffer
    public func reserve(capacity: Int) throws {
        if capacity < 0 {
            throw NSException(name: .invalidArgumentException, reason: "Invalid reserve capacity!") as! Error
        }

        if capacity > data.count {
            var data = Data(capacity: max(capacity, 2 * self.data.count))
            data[0...] = self.data[0...]
            self.data = data
        }
    }

    // Resize the current buffer
    public func resize(size: Int) throws {
        try reserve(capacity: size)

        self.size = size

        if offset > self.size {
            offset = self.size
        }
    }

    // Reset the current buffer and its offset
    public func reset() {
        size = 0
        offset = 0
    }

    // Shift the current buffer offset
    public func shift(offset: Int) { self.offset += offset }
    // Unshift the current buffer offset
    public func unshift(offset: Int) { self.offset -= offset }

    func withDataMutablePointer(offset: Int = 0, block: (UnsafeMutablePointer<UInt8>) -> Void) {
        self.data.withUnsafeMutableBytes { (body: UnsafeMutableRawBufferPointer) in
            if let baseAddress = body.baseAddress, body.count > 0 {
                block(baseAddress.assumingMemoryBound(to: UInt8.self).advanced(by: offset))
            } else {
                assertionFailure()
            }
        }
    }

    func withUnsafeBytes(block: (UnsafeRawPointer) -> Void) {
        self.data.withUnsafeBytes { body in
            if let baseAddress = body.baseAddress, body.count > 0 {
                block(baseAddress)
            } else {
                assertionFailure()
            }
        }
    }

    private func decodeByteNumber<T>(value: inout T, offset: Int, count: Int) {
        withUnsafeMutableBytes(of: &value) { dest -> Void in
            withUnsafeBytes { p in
                let src = p.advanced(by: offset)
                dest.copyMemory(from: UnsafeRawBufferPointer(start: src, count: count))
            }
        }
    }
}
// MARK: Buffer I/O methods
public extension Buffer {
    class func readBoolean(buffer: Data, offset: Int) -> Bool {
        let index = offset
        return buffer[index] != 0
    }

    class func readByte(buffer: Data, offset: Int) -> UInt8 {
        let index = offset
        return buffer[index]
    }

    class func readChar(buffer: Data, offset: Int) -> Character {
        return Character(UnicodeScalar(Buffer.readUInt8(buffer: buffer, offset: offset)))
    }

    class func readWChar(buffer: Buffer, offset: Int) -> Character {
        return Character(UnicodeScalar(Buffer.readUInt32(buffer: buffer, offset: offset))!)
    }

    class func readInt8(buffer: Buffer, offset: Int) -> Int8 {
        var i: Int8 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 1)
        return Int8(littleEndian: i)
    }

    class func readUInt8(buffer: Data, offset: Int) -> UInt8 {
        let index = offset
        return buffer[index]
    }

    class func readInt16(buffer: Buffer, offset: Int) -> Int16 {
        var i: Int16 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 2)
        return Int16(littleEndian: i)
    }

    class func readUInt16(buffer: Buffer, offset: Int) -> UInt16 {
        var i: UInt16 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 2)
        return UInt16(littleEndian: i)
    }

    class func readInt32(buffer: Buffer, offset: Int) -> Int32 {
        var i: Int32 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 4)
        return Int32(littleEndian: i)
    }

    class func readUInt32(buffer: Buffer, offset: Int) -> UInt32 {
        var i: UInt32 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 4)
        return UInt32(littleEndian: i)
    }

    class func readInt64(buffer: Buffer, offset: Int) -> Int64 {
        var i: Int64 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 8)
        return Int64(littleEndian: i)
    }

    class func readUInt64(buffer: Buffer, offset: Int) -> UInt64 {
        var i: UInt64 = 0
        buffer.decodeByteNumber(value: &i, offset: offset, count: 8)
        return UInt64(littleEndian: i)
    }

    class func readFloat(buffer: Buffer, offset: Int) -> Float {
        let bits = readUInt32(buffer: buffer, offset: offset)
        return Float(bitPattern: bits)
    }

    class func readDouble(buffer: Buffer, offset: Int) -> Double {
        let bitPattern = readUInt64(buffer: buffer, offset: offset)
        return Double(bitPattern: bitPattern)
    }

    class func readBytes(buffer: Data, offset: Int, size: Int) -> Data {
        var result = Data(capacity: size)
        result[0...] = buffer[offset..<(offset + size)]
        return result
    }

    class func readString(buffer: Buffer, offset: Int, size: Int) -> String {
        var value = ""

        buffer.withUnsafeBytes { p in
            let src = p.advanced(by: offset).assumingMemoryBound(to: UInt8.self)
            value = utf8ToString(bytes: src, count: size)
        }
        return value
    }

    class func utf8ToString(bytes: UnsafePointer<UInt8>, count: Int) -> String {
        if count == 0 {
            return String()
        }
        let codeUnits = UnsafeBufferPointer<UInt8>(start: bytes, count: count)
        let sourceEncoding = Unicode.UTF8.self

        //         Verify that the UTF-8 is valid.
        var p = sourceEncoding.ForwardParser()
        var i = codeUnits.makeIterator()
        Loop:
            while true {
                switch p.parseScalar(from: &i) {
                case .valid(_):
                    break
                case .error:
                    return ""
                case .emptyInput:
                    break Loop
                }
        }

        // This initializer is fast but does not reject broken
        // UTF-8 (which is why we validate the UTF-8 above).
        return String(decoding: codeUnits, as: sourceEncoding)
    }

    class func readUUID(buffer: Data, offset: Int) -> UUID {
        let bytes = readBytes(buffer: buffer, offset: offset, size: 16)
        let uuid: uuid_t = (
            bytes[15],
            bytes[14],
            bytes[13],
            bytes[12],
            bytes[11],
            bytes[10],
            bytes[9],
            bytes[8],
            bytes[7],
            bytes[6],
            bytes[5],
            bytes[4],
            bytes[3],
            bytes[2],
            bytes[1],
            bytes[0]
        )

        return UUID(uuid: uuid)
    }

    class func write(buffer: inout Buffer, offset: Int, value: Bool) {
        buffer.data[offset] = value ? 1 : 0
    }

    class func write(buffer: inout Buffer, offset: Int, value: Int8) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<UInt8>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: UInt8) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<UInt8>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: Int16) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<Int16>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: UInt16) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<UInt16>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: Int32) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<Int32>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: UInt32) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<UInt32>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: Int64) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<Int64>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: UInt64) {
        buffer.withDataMutablePointer(offset: offset) {
            var v = value.littleEndian
            let n = MemoryLayout<UInt64>.size
            memcpy($0, &v, n)
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: String) {
        buffer.withDataMutablePointer(offset: offset) {
            var pointer = $0
            var v = UInt32(value.count).littleEndian
            let n = MemoryLayout<UInt32>.size
            memcpy(pointer, &v, n)
            pointer = pointer.advanced(by: n)

            for b in value.utf8 {
                pointer.pointee = b
                pointer = pointer.successor()
            }
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: Float) {
        let bits = value.bitPattern
        Buffer.write(buffer: &buffer, offset: offset, value: bits)
    }

    class func write(buffer: inout Buffer, offset: Int, value: Double) {
        let bits = value.bitPattern
        Buffer.write(buffer: &buffer, offset: offset, value: bits)
    }

    class func write(buffer: inout Data, offset: Int, value: Data) {
        if value.isEmpty {
            return
        }
        buffer[offset...(offset + value.count - 1)] = value[0...value.count - 1]
    }

    class func write(buffer: inout Buffer, offset: Int, value: Data, valueOffset: Int, valueSize: Int) {
        if valueSize == 0 {
            return
        }

        let values = Array(value[valueOffset..<(valueOffset + valueSize)])
        for i in 0..<values.count {
            Buffer.write(buffer: &buffer, offset: offset + i, value: values[i])
        }
    }

    class func write(buffer: inout Buffer, offset: Int, value: UInt8, valueCount: Int) {
        buffer.withDataMutablePointer(offset: offset) {
            var pointer = $0

            var v = value.littleEndian
            let n = MemoryLayout<UInt8>.size

            for _ in 0..<valueCount {

                memcpy(pointer, &v, n)
                pointer = pointer.successor()
            }
        }
    }

    class func write(buffer: inout Data, offset: Int, value: UUID) {
        Buffer.write(buffer: &buffer, offset: offset, value: Data(Swift.withUnsafeBytes(of: value.uuid, { Data($0) }).reversed()))
    }
}