/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2020 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.sound;

import java.util.Objects;
import net.kyori.adventure.key.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

/* package */ final class SoundStopImpl implements SoundStop {
  /* package */ static final SoundStop ALL = new SoundStopImpl(null, null);
  private final @Nullable Key sound;
  private final Sound.@Nullable Source source;

  /* package */ SoundStopImpl(final @Nullable Key sound, final Sound.@Nullable Source source) {
    this.sound = sound;
    this.source = source;
  }

  @Override
  public @Nullable Key sound() {
    return this.sound;
  }

  @Override
  public Sound.@Nullable Source source() {
    return this.source;
  }

  @Override
  public boolean equals(final @Nullable Object other) {
    if(this == other) return true;
    if(other == null || this.getClass() != other.getClass()) return false;
    final SoundStopImpl that = (SoundStopImpl) other;
    return Objects.equals(this.sound, that.sound)
      && Objects.equals(this.source, that.source);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(this.sound);
    result = (31 * result) + Objects.hashCode(this.source);
    return result;
  }
}
