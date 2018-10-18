// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding

package fbe;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.time.*;
import java.util.*;

// Fast Binary Encoding timestamp final model class
public final class FinalModelTimestamp extends FinalModel
{
    public FinalModelTimestamp(Buffer buffer, long offset) { super(buffer, offset); }

    // Get the allocation size
    public long fbeAllocationSize(Instant value) { return fbeSize(); }

    // Get the final size
    @Override
    public long fbeSize() { return 8; }

    // Check if the value is valid
    @Override
    public long verify()
    {
        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return Long.MAX_VALUE;

        return fbeSize();
    }

    // Get the value
    public Instant get(Size size)
    {
        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return Instant.EPOCH;

        size.value = fbeSize();
        long nanoseconds = readInt64(fbeOffset());
        return Instant.ofEpochSecond(nanoseconds / 1000000000, nanoseconds % 1000000000);
    }

    // Set the value
    public long set(Instant value)
    {
        assert ((_buffer.getOffset() + fbeOffset() + fbeSize()) <= _buffer.getSize()) : "Model is broken!";
        if ((_buffer.getOffset() + fbeOffset() + fbeSize()) > _buffer.getSize())
            return 0;

        long nanoseconds = value.getEpochSecond() * 1000000000 + value.getNano();
        write(fbeOffset(), nanoseconds);
        return fbeSize();
    }
}