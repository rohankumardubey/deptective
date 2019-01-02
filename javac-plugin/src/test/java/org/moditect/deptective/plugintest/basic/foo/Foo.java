/**
 *  Copyright 2019 The ModiTect authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.moditect.deptective.plugintest.basic.foo;

import java.util.ArrayList;
import java.util.List;

import org.moditect.deptective.plugintest.basic.barctorcall.BarCtorCall;
import org.moditect.deptective.plugintest.basic.barfield.BarField;
import org.moditect.deptective.plugintest.basic.barlocalvar.BarLocalVar;
import org.moditect.deptective.plugintest.basic.barloopvar.BarLoopVar;
import org.moditect.deptective.plugintest.basic.barparameter.BarParameter;
import org.moditect.deptective.plugintest.basic.barretval.BarRetVal;
import org.moditect.deptective.plugintest.basic.bartypearg.BarTypeArg;

public class Foo {

    private String s;
    private final BarField bar = new BarField();

    public Foo(BarParameter bar) {
    }

    public BarRetVal doSomething(BarParameter bar) {
        BarLocalVar varLocalVar = new BarLocalVar();

        List<BarTypeArg> bars = new ArrayList<>();

        for (BarLoopVar oneBar : new ArrayList<BarLoopVar>()) {
        }

        new BarCtorCall();

        return null;
    }


}
