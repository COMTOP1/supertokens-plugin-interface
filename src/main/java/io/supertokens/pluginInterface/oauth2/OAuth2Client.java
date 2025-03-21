/*
 *    Copyright (c) 2023, VRAI Labs and/or its affiliates. All rights reserved.
 *
 *    This software is licensed under the Apache License, Version 2.0 (the
 *    "License") as published by the Apache Software Foundation.
 *
 *    You may not use this file except in compliance with the License. You may
 *    obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *    License for the specific language governing permissions and limitations
 *    under the License.
 */

package io.supertokens.pluginInterface.oauth2;

import java.util.HashSet;
import java.util.List;

public class OAuth2Client {
    public String clientId;
    public String name;
    public String clientSecretHash;
    public List<String> redirectUris;
    public long createdAtMs;
    public long updatedAtMs;

    public OAuth2Client(String clientId, String name, String clientSecretHash, List<String> redirectUris,
                        long createdAtMs, long updatedAtMs) {
        this.clientId = clientId;
        this.name = name;
        this.clientSecretHash = clientSecretHash;
        this.redirectUris = redirectUris;
        this.createdAtMs = createdAtMs;
        this.updatedAtMs = updatedAtMs;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OAuth2Client)) {
            return false;
        }
        OAuth2Client other = (OAuth2Client) obj;
        return other.clientId.equals(this.clientId) &&
                other.name.equals(this.name) &&
                other.clientSecretHash.equals(this.clientSecretHash) &&
                equalLists(other.redirectUris, this.redirectUris)  &&
                (other.createdAtMs == this.createdAtMs) &&
                (other.updatedAtMs == this.updatedAtMs);
    }

    private boolean equalLists(List<String> list1, List<String> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }
        return new HashSet<>(list1).containsAll(list2);
    }
}
