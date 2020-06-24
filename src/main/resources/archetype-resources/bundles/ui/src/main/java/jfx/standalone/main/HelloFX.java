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

package ${package}.jfx.standalone.main;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    private static void keepDim(final Stage stage, final Scene scene) {
        final double stageHeight = stage.getHeight();
        final double stageWidth = stage.getWidth();
        stage.setScene(scene);
        stage.setHeight(stageHeight);
        stage.setWidth(stageWidth);
    }

    @Override
    public void init() throws Exception {
        final Parameters params = getParameters();
        final Map<String, String> named = params.getNamed();
        final List<String> unnamed = params.getUnnamed();
        final List<String> raw = params.getRaw();

        System.out.printf("named: %s%nunnamed: %s%nraw: %s%n", named, unnamed, raw);
    }

    @Override
    public void start(final Stage stage) {
        // Instantiating the BorderPane class
        final BorderPane bPane = new BorderPane();

        // Creating a scene object
        final Scene scene = new Scene(bPane, 640, 480);

        // Setting title to the Stage
        stage.setTitle("BorderPane Example");

        // Setting the top, bottom, center, right and left nodes to the pane
        bPane.setTop(new TextField("Top"));
        bPane.setBottom(new Label(String.format("Hello, JavaFX %s, running on Java %s.",
                System.getProperty("javafx.version"), System.getProperty("java.version"))));
        bPane.setLeft(new TextField("Left"));
        bPane.setRight(new TextField("Right"));
        final Button testBtn = new Button("test");
        testBtn.setOnAction(testBtnEvent -> {
            System.out.printf("class: %s; %s%n", testBtnEvent.getClass(), testBtnEvent);
            final Button backBtn = new Button("back");
            backBtn.setOnAction(backBtnEvent -> {
                keepDim(stage, scene);
            });
            keepDim(stage, new Scene(backBtn));
        });
        bPane.setCenter(testBtn);

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }

}
