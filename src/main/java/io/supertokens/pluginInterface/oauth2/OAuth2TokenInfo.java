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

public class OAuth2TokenInfo {
    public String clientId;
    public String sessionHandle;
    public List<String> scope;
    public String accessTokenHash;
    public String refreshTokenHash;
    public long createdAtMs;
    public long lastUpdatedAtMs;
    public long accessTokenExpiresAtMs;
    public Long refreshTokenHashExpiresAtMs;
    public boolean clientSecretRequiredForRefresh;
    public GrantType grantType;

    public OAuth2TokenInfo(String clientId, String sessionHandle, List<String> scope, String accessTokenHash,
                           String refreshTokenHash, long createdAtMs, long lastUpdatedAtMs, long accessTokenExpiresAtMs,
                           Long refreshTokenHashExpiresAtMs, boolean clientSecretRequiredForRefresh,
                           GrantType grantType) {
        this.clientId = clientId;
        this.sessionHandle = sessionHandle;
        this.scope = scope;
        this.accessTokenHash = accessTokenHash;
        this.refreshTokenHash = refreshTokenHash;
        this.createdAtMs = createdAtMs;
        this.lastUpdatedAtMs = lastUpdatedAtMs;
        this.accessTokenExpiresAtMs = accessTokenExpiresAtMs;
        this.refreshTokenHashExpiresAtMs = refreshTokenHashExpiresAtMs;
        this.clientSecretRequiredForRefresh = clientSecretRequiredForRefresh;
        this.grantType = grantType;
    }

    public enum GrantType {
        CLIENT_CREDENTIALS, REFRESH_TOKEN, AUTH_CODE, AUTH_CODE_PKCE
    }
}
