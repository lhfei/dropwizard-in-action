/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package cn.lhfei.dropwizard.helloworld.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMultimap;

import io.dropwizard.servlets.tasks.Task;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 19, 2017
 */
public class EchoTask extends Task {

  public EchoTask() {
    super("echo");
  }

  public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output)
      throws Exception {
    output.flush();
  }

  @Override
  public void execute(Map<String, List<String>> parameters, PrintWriter output) throws Exception {
    output.flush();
  }

}
