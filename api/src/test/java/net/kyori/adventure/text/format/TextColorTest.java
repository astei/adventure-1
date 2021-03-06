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
package net.kyori.adventure.text.format;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TextColorTest {
  @Test
  void testFromHexString() {
    assertEquals(TextColor.of(0xaa00aa), TextColor.fromHexString("#aa00aa"));
  }

  @Test
  void testFromMalformedHexString() {
    assertNull(TextColor.fromHexString("aa00aa")); // does not begin with #
    assertNull(TextColor.fromHexString("#aa00az"));
  }

  @Test
  public void testPureColors() {
    final TextColor redInt = TextColor.of(0xff0000);
    final TextColor greenInt = TextColor.of(0x00ff00);
    final TextColor blueInt = TextColor.of(0x0000ff);

    final TextColor red = TextColor.of(0xff, 0x00, 0x00);
    final TextColor green = TextColor.of(0x00, 0xff, 0x00);
    final TextColor blue = TextColor.of(0x00, 0x00, 0xff);

    assertEquals(redInt, red);
    assertEquals(greenInt, green);
    assertEquals(blueInt, blue);
  }

  @Test
  public void testExtractComponents() {
    final TextColor purple = TextColor.of(0xff00ff);
    assertEquals(0xff, purple.red());
    assertEquals(0x00, purple.green());
    assertEquals(0xff, purple.blue());

    final TextColor color = TextColor.of(0xbada04);
    assertEquals(0xba, color.red());
    assertEquals(0xda, color.green());
    assertEquals(0x04, color.blue());
  }

  @Test
  public void testEquality() {
    new EqualsTester()
      .addEqualityGroup(
        TextColor.of(0xff0000),
        TextColor.of(0xff, 0x00, 0x00)
      )
      .addEqualityGroup(
        TextColor.of(0x00ff00),
        TextColor.of(0x00, 0xff, 0x00)
      )
      .testEquals();
  }
}
