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


package org.openqa.selenium.interactions.internal;

import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

/**
 * Base class for all mouse-related actions.
 */
public class MouseAction extends BaseAction {
  public enum Button {
    LEFT(0),
    MIDDLE(1),
    RIGHT(2);

    private final int b;
    Button(int b) {
      this.b = b;
    }
  }

  protected final Mouse mouse;

  protected MouseAction(Mouse mouse, Locatable locationProvider) {
    super(locationProvider);
    this.mouse = mouse;
  }

  protected Coordinates getActionLocation() {
    if (where == null) {
      return null;
    }

    return where.getCoordinates();
  }

  protected void moveToLocation() {
    // Only call mouseMove if an actual location was provided. If not,
    // the action will happen in the last known location of the mouse
    // cursor.
    if (getActionLocation() != null) {
      mouse.mouseMove(getActionLocation());
    }
  }
}
