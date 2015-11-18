// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.interactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.internal.KeysRelatedAction;
import org.openqa.selenium.interactions.internal.MultiAction;
import org.openqa.selenium.internal.Locatable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sending a sequence of keys to an element.
 *
 */
public class SendKeysAction extends KeysRelatedAction implements Action, MultiAction {
  private final CharSequence[] keysToSend;

  public SendKeysAction(Keyboard keyboard, Mouse mouse, Locatable locationProvider,
      CharSequence... keysToSend) {
    super(keyboard, mouse, locationProvider);
    this.keysToSend = keysToSend;
  }

  public SendKeysAction(Keyboard keyboard, Mouse mouse, CharSequence... keysToSend) {
    this(keyboard, mouse, null, keysToSend);
  }

  public void perform() {
    focusOnElement();

    keyboard.sendKeys(keysToSend);
  }

  public List<Action> getActions() {
    List<Action> actions = new ArrayList<>();
    for (CharSequence chars : keysToSend) {
      for (int i = 0; i < chars.length(); i++) {
        Keys key = Keys.getKeyFromUnicode(chars.charAt(i));
        actions.add(new KeyDownAction(keyboard, mouse, where, key));
        actions.add(new KeyUpAction(keyboard, mouse, where, key));
      }
    }
    return actions;
  }
}
