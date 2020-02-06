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

package ${package};

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple demo of a service.
 */
@Component(service = { DummyService.class }, immediate = true)
public class DummyService {

    private final Logger logger = LoggerFactory.getLogger(DummyService.class);

    /**
     * Constructor.
     */
    @Activate
    public DummyService() {
        logger.debug("debug");
        logger.error("error");
        logger.info("info");
        logger.trace("trace");
        logger.warn("warn");
    }

}
