#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*-
 * ${symbol_pound}%L
 * ${groupId}.bundles.dummy
 * %%
 * Copyright (C) 2019 maggu2810
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ${symbol_pound}L%
 */

package ${package}.jfx.standalone.launcher;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ${package}.jfx.standalone.main.HelloFX;

/**
 * The bundle activator that will launch a pseudo JavaFX application and hold the primary stage.
 */
@Component
public class AppComp {

    @Activate
    public AppComp(
            final @Reference(target = "(launcher.ready=true)") ServiceReference<Object> launcherRuntimeInformation,
            final BundleContext bc) {
        final Object launcherArgs = launcherRuntimeInformation.getProperty("launcher.arguments");
        final String[] args;
        if (launcherArgs == null) {
            args = null;
        } else if (launcherArgs.getClass().isArray()) {
            final Object[] argsTmp = (Object[]) launcherArgs;
            if (argsTmp.length == 0) {
                args = new String[0];
            } else {
                if (argsTmp[0] instanceof String) {
                    args = (String[]) argsTmp;
                } else {
                    throw new IllegalStateException(
                            "The arguments are provided by something different then a string array.");
                }
            }
            // } else if (launcherArgs instanceof String) {
            // args = new String[] { (String) launcherArgs };
        } else {
            throw new IllegalStateException("The arguments are provided by something different then a string array.");
        }

        for (final String key : launcherRuntimeInformation.getPropertyKeys()) {
            final Object value = launcherRuntimeInformation.getProperty(key);
            System.out.printf("%s=%s%n", key, value);
        }

        AppUtils.launch(bc, HelloFX.class, args);
    }

}
