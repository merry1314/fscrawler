/*
 * Licensed to David Pilato under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package fr.pilato.elasticsearch.crawler.fs.framework;

/**
 * In case we need to throw a Runtime Exception when we detect something wrong
 */
public class FsCrawlerIllegalConfigurationException extends RuntimeException {
    public FsCrawlerIllegalConfigurationException(String s) {
        super(s);
    }

    public FsCrawlerIllegalConfigurationException(String s, Throwable e) {
        super(s, e);
    }
}
