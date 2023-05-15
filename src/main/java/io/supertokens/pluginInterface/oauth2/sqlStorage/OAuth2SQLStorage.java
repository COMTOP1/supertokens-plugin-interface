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

package io.supertokens.pluginInterface.oauth2.sqlStorage;

import io.supertokens.pluginInterface.exceptions.StorageQueryException;
import io.supertokens.pluginInterface.oauth2.OAuth2AuthorizationCode;
import io.supertokens.pluginInterface.oauth2.OAuth2Client;
import io.supertokens.pluginInterface.oauth2.OAuth2Storage;
import io.supertokens.pluginInterface.oauth2.exception.UnknownOAuth2AuthorizationCodeHashException;
import io.supertokens.pluginInterface.oauth2.exception.UnknownOAuth2ClientIdException;
import io.supertokens.pluginInterface.sqlStorage.SQLStorage;

import javax.annotation.Nonnull;

public interface OAuth2SQLStorage extends OAuth2Storage, SQLStorage {
    OAuth2Client getOAuth2ClientByIdAndClientSecretHash_Transaction(String clientId, String clientSecretHash) throws StorageQueryException, UnknownOAuth2ClientIdException;
    OAuth2AuthorizationCode getOAuth2AuthorizationCodeByCodeHash_Transaction(String codeHash) throws StorageQueryException, UnknownOAuth2AuthorizationCodeHashException;
    void createOAuth2Token_Transaction(String clientId, String userId, String sessionHandle, String scope, String accessTokenHash,
                                       String refreshTokenHash, long createdAtMs, long accessTokenExpiresAtMs,
                                       Long refreshTokenHashExpiresAtMs) throws StorageQueryException, UnknownOAuth2ClientIdException;
}
