/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.plugin.task.api.loop.template.http.parser;

import org.apache.dolphinscheduler.plugin.task.api.loop.template.LoopTaskYamlDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class HttpTaskDefinitionParserTest {

    private static final String yamlFile = HttpTaskDefinitionParserTest.class.getResource("/mock_loop_task.yaml")
        .getFile();

    @Test
    public void parseYamlConfigFile() throws IOException {
        LoopTaskYamlDefinition loopTaskYamlDefinition = new HttpTaskDefinitionParser().parseYamlConfigFile(yamlFile);
        Assert.assertNotNull(loopTaskYamlDefinition);
        Assert.assertNotNull(loopTaskYamlDefinition.getService());
        LoopTaskYamlDefinition.LoopTaskServiceYamlDefinition service = loopTaskYamlDefinition.getService();
        Assert.assertEquals("MockService", service.getName());
        Assert.assertNotNull(service.getApi());
    }

    @Test
    public void validateYamlDefinition() throws IOException {
        HttpTaskDefinitionParser httpTaskDefinitionParser = new HttpTaskDefinitionParser();
        LoopTaskYamlDefinition loopTaskYamlDefinition = httpTaskDefinitionParser.parseYamlConfigFile(yamlFile);
        httpTaskDefinitionParser.validateYamlDefinition(loopTaskYamlDefinition);
        // if no exception assert true
        Assert.assertTrue(true);

    }
}