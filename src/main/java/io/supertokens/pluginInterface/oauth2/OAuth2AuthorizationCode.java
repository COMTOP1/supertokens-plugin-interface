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

import java.util.List;

public class OAuth2AuthorizationCode {
    public String codeHash;
    public String sessionHandle;
    public String clientId;
    public long createdAtMs;
    public long expiresAtMs;
    public List<String> scope;
    public String redirectUri;
    public AccessType accessType;
    public String codeChallenge;
    public String codeChallengeMethod;
    public String queryString;

    public OAuth2AuthorizationCode(String codeHash, String sessionHandle, String clientId, long createdAtMs,
                                   long expiresAtMs, List<String> scope, String redirectUri, AccessType accessType,
                                   String codeChallenge, String codeChallengeMethod, String queryString) {
        this.codeHash = codeHash;
        this.sessionHandle = sessionHandle;
        this.clientId = clientId;
        this.createdAtMs = createdAtMs;
        this.expiresAtMs = expiresAtMs;
        this.scope = scope;
        this.redirectUri = redirectUri;
        this.accessType = accessType;
        this.codeChallenge = codeChallenge;
        this.codeChallengeMethod = codeChallengeMethod;
        this.queryString = queryString;
    }

    public enum AccessType {
        offline , online
    }
}
