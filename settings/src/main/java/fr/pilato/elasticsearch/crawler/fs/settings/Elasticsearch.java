/*
 * Licensed to David Pilato (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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

package fr.pilato.elasticsearch.crawler.fs.settings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.pilato.elasticsearch.crawler.fs.framework.ByteSizeValue;
import fr.pilato.elasticsearch.crawler.fs.framework.TimeValue;
import jakarta.annotation.Nullable;
import org.github.gestalt.config.annotations.Config;

import java.util.List;
import java.util.Objects;

public class Elasticsearch {

    @Config
    @Nullable private List<ServerUrl> nodes;
    @Config
    @Nullable private String index;
    @Config
    @Nullable private String indexFolder;
    @Config(defaultVal = "100")
    @Nullable private Integer bulkSize;
    @Config(defaultVal = "5s")
    @Nullable private TimeValue flushInterval;
    @Config(defaultVal = "10mb")
    @Nullable private ByteSizeValue byteSize;
    @Config
    @Nullable private String apiKey;

    /**
     * Username
     * @deprecated Use apiKey or accessToken instead
     */
    @Config
    @Deprecated
    @Nullable private String username;
    /**
     * Password
     * @deprecated Use apiKey or accessToken instead
     */
    @Config
    @Deprecated
    @JsonIgnore
    @Nullable private String password;
    @Config
    @Nullable private String caCertificate;
    @Config
    @Nullable private String pipeline;
    @Config
    @Nullable private String pathPrefix;
    @Config(defaultVal = "true")
    private boolean sslVerification;
    @Config(defaultVal = "true")
    private boolean pushTemplates;
    @Config(defaultVal = "true")
    private boolean semanticSearch;

    public List<ServerUrl> getNodes() {
        return nodes;
    }

    public void setNodes(@Nullable List<ServerUrl> nodes) {
        this.nodes = nodes;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndexFolder() {
        return indexFolder;
    }

    public void setIndexFolder(String indexFolder) {
        this.indexFolder = indexFolder;
    }

    public int getBulkSize() {
        return bulkSize;
    }

    public void setBulkSize(@Nullable Integer bulkSize) {
        this.bulkSize = bulkSize;
    }

    public TimeValue getFlushInterval() {
        return flushInterval;
    }

    public void setFlushInterval(@Nullable TimeValue flushInterval) {
        this.flushInterval = flushInterval;
    }

    public ByteSizeValue getByteSize() {
        return byteSize;
    }

    public void setByteSize(@Nullable ByteSizeValue byteSize) {
        this.byteSize = byteSize;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Provide the username to connect to Elasticsearch
     * @param username The username
     * @deprecated Use {@link #setApiKey(String)} instead
     */
    @Deprecated
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * Provide the password to connect to Elasticsearch
     * @param password The password
     * @deprecated Use {@link #setApiKey(String)} instead
     */
    @Deprecated
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public boolean isSslVerification() {
        return sslVerification;
    }

    public void setSslVerification(boolean sslVerification) {
        this.sslVerification = sslVerification;
    }

    public boolean isPushTemplates() {
        return pushTemplates;
    }

    public void setPushTemplates(boolean pushTemplates) {
        this.pushTemplates = pushTemplates;
    }

    public String getCaCertificate() {
        return caCertificate;
    }

    public void setCaCertificate(String caCertificate) {
        this.caCertificate = caCertificate;
    }

    public boolean isSemanticSearch() {
        return semanticSearch;
    }

    public void setSemanticSearch(boolean semanticSearch) {
        this.semanticSearch = semanticSearch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elasticsearch that = (Elasticsearch) o;

        if (!Objects.equals(bulkSize, that.bulkSize)) return false;
        if (!Objects.equals(nodes, that.nodes)) return false;
        if (!Objects.equals(index, that.index)) return false;
        if (!Objects.equals(indexFolder, that.indexFolder)) return false;
        if (!Objects.equals(apiKey, that.apiKey)) return false;
        if (!Objects.equals(username, that.username)) return false;
        // We can't really test the password as it may be obfuscated
        if (!Objects.equals(pipeline, that.pipeline)) return false;
        if (!Objects.equals(pathPrefix, that.pathPrefix)) return false;
        if (!Objects.equals(sslVerification, that.sslVerification)) return false;
        if (!Objects.equals(caCertificate, that.caCertificate)) return false;
        if (!Objects.equals(pushTemplates, that.pushTemplates)) return false;
        return Objects.equals(flushInterval, that.flushInterval);

    }

    @Override
    public int hashCode() {
        int result = nodes != null ? nodes.hashCode() : 0;
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (indexFolder != null ? indexFolder.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (apiKey != null ? apiKey.hashCode() : 0);
        result = 31 * result + (pipeline != null ? pipeline.hashCode() : 0);
        result = 31 * result + (pathPrefix != null ? pathPrefix.hashCode() : 0);
        result = 31 * result + bulkSize;
        result = 31 * result + (flushInterval != null ? flushInterval.hashCode() : 0);
        result = 31 * result + (caCertificate != null ? caCertificate.hashCode() : 0);
        result = 31 * result + (sslVerification? 1: 0);
        result = 31 * result + (pushTemplates? 1: 0);
        return result;
    }

    @Override
    public String toString() {
        return "Elasticsearch{" +
                "nodes=" + nodes +
                ", index='" + index + '\'' +
                ", indexFolder='" + indexFolder + '\'' +
                ", bulkSize=" + bulkSize +
                ", flushInterval=" + flushInterval +
                ", byteSize=" + byteSize +
                ", apiKey='" + apiKey + '\'' +
                ", username='" + username + '\'' +
                ", pipeline='" + pipeline + '\'' +
                ", pathPrefix='" + pathPrefix + '\'' +
                ", sslVerification=" + sslVerification +
                ", caCertificate='" + caCertificate + '\'' +
                ", pushTemplates=" + pushTemplates +
                '}';
    }
}
