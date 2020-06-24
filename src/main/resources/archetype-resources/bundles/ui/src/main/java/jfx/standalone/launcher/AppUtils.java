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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;

import javafx.application.Application;

public class AppUtils {

    private static void shutdown(final BundleContext context) {
        System.out.println("Shutdown hook invoked, stopping OSGi Framework.");
        try {
            final Bundle systemBundle = context.getBundle(0);
            final Framework framework = systemBundle.adapt(Framework.class);
            System.out.println("Waiting up to 2s for OSGi shutdown to complete...");
            framework.stop();
            framework.waitForStop(TimeUnit.MINUTES.toMillis(1));
        } catch (final Exception e) {
            System.err.println("Failed to cleanly shutdown OSGi Framework: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void launch(final BundleContext context, final Class<? extends Application> app,
            final String[] args) {
        // Use a scheduler to execute stuff asynchron.
        final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        try {
            scheduler.schedule(() -> {
                // Launch JavaFX application.
                Application.launch(app, args);
                // Shutdown after the application has been finished.
                shutdown(context);
            }, 0, TimeUnit.SECONDS);
        } finally {
            // Shutdown the scheduler.
            scheduler.shutdown();
        }
    }
}
