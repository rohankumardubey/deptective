/**
 *  Copyright 2019-2022 The ModiTect authors
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
package org.moditect.deptective.plugintest.packagecontainedtwiceanalyze;

import static com.google.testing.compile.CompilationSubject.assertThat;

import org.junit.Test;
import org.moditect.deptective.internal.options.DeptectiveOptions.Options;
import org.moditect.deptective.plugintest.PluginTestBase;
import org.moditect.deptective.plugintest.packagecontainedtwiceanalyze.foo.Foo;
import org.moditect.deptective.testutil.TestOptions;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;

public class AnalyzeWithDefinedComponentsTest extends PluginTestBase {

    @Test
    public void shouldFailUponAnalyzeWithPackageMatchedByMultipleComponents() throws Exception {
        Compilation compilation = Compiler.javac()
                .withOptions(
                        TestOptions.deptectiveOptions(
                                Options.MODE, "ANALYZE",
                                Options.COMPONENTS,
                                "foo1:org.moditect.deptective.plugintest.packagecontainedtwiceanalyze.foo;" +
                                        "foo2:org.moditect.deptective.plugintest.packagecontainedtwiceanalyze.foo"
                        )
                )
                .compile(forTestClass(Foo.class));

        assertThat(compilation).failed();
        assertThat(compilation).hadNoteCount(0);
        assertThat(compilation).hadErrorContaining(
                "Multiple components match package org.moditect.deptective.plugintest.packagecontainedtwiceanalyze.foo: foo1, foo2"
        );
    }
}
