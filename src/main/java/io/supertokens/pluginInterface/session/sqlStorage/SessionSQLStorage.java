/*
 *    Copyright (c) 2020, VRAI Labs and/or its affiliates. All rights reserved.
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

package io.supertokens.pluginInterface.session.sqlStorage;

import io.supertokens.pluginInterface.KeyValueInfo;
import io.supertokens.pluginInterface.exceptions.StorageQueryException;
import io.supertokens.pluginInterface.multitenancy.AppIdentifier;
import io.supertokens.pluginInterface.multitenancy.TenantIdentifier;
import io.supertokens.pluginInterface.multitenancy.exceptions.TenantOrAppNotFoundException;
import io.supertokens.pluginInterface.session.SessionInfo;
import io.supertokens.pluginInterface.session.SessionStorage;
import io.supertokens.pluginInterface.sqlStorage.SQLStorage;
import io.supertokens.pluginInterface.sqlStorage.TransactionConnection;
import io.supertokens.pluginInterface.sqlStorage.SessionObject;

public interface SessionSQLStorage extends SessionStorage, SQLStorage {

    void removeLegacyAccessTokenSigningKey_Transaction(TransactionConnection con) throws StorageQueryException;

    void removeLegacyAccessTokenSigningKey_Transaction(SessionObject sessionInstance) throws StorageQueryException;

    KeyValueInfo getLegacyAccessTokenSigningKey_Transaction(TransactionConnection con) throws StorageQueryException;

    KeyValueInfo getLegacyAccessTokenSigningKey_Transaction(AppIdentifier appIdentifier,
                                                            TransactionConnection con) throws StorageQueryException;

    KeyValueInfo[] getAccessTokenSigningKeys_Transaction(TransactionConnection con) throws StorageQueryException;

    KeyValueInfo[] getAccessTokenSigningKeys_Transaction(AppIdentifier appIdentifier, TransactionConnection con)
            throws StorageQueryException;

    void addAccessTokenSigningKey_Transaction(TransactionConnection con, KeyValueInfo info)
            throws StorageQueryException;

    KeyValueInfo[] getAccessTokenSigningKeys_Transaction(SessionObject sessionInstance) throws StorageQueryException;

    void addAccessTokenSigningKey_Transaction(SessionObject sessionInstance, KeyValueInfo info)
            throws StorageQueryException;

    KeyValueInfo getRefreshTokenSigningKey_Transaction(SessionObject sessionInstance) throws StorageQueryException;

    void addAccessTokenSigningKey_Transaction(AppIdentifier appIdentifier, TransactionConnection con,
                                              KeyValueInfo info)
            throws StorageQueryException, TenantOrAppNotFoundException;

    void setRefreshTokenSigningKey_Transaction(SessionObject sessionInstance, KeyValueInfo info) throws StorageQueryException;

    KeyValueInfo getRefreshTokenSigningKey_Transaction(AppIdentifier appIdentifier, TransactionConnection con) throws StorageQueryException;

    SessionInfo getSessionInfo_Transaction(SessionObject sessionInstance, String sessionHandle);

    void setRefreshTokenSigningKey_Transaction(AppIdentifier appIdentifier, TransactionConnection con,
                                               KeyValueInfo info)
            throws StorageQueryException, TenantOrAppNotFoundException;

    SessionInfo getSessionInfo_Transaction(TenantIdentifier tenantIdentifier, TransactionConnection con,
                                           String sessionHandle)
            throws StorageQueryException;

    void updateSessionInfo_Transaction(SessionObject sessionInstance, String sessionHandle, String refreshTokenHash2,
            long expiry) throws StorageQueryException;

    void updateSessionInfo_Transaction(TenantIdentifier tenantIdentifier, TransactionConnection con,
                                       String sessionHandle, String refreshTokenHash2,
                                       long expiry) throws StorageQueryException;

    void deleteSessionsOfUser_Transaction(TransactionConnection con, AppIdentifier appIdentifier, String userId)
            throws StorageQueryException;

    void removeLegacyAccessTokenSigningKey_Transaction(AppIdentifier appIdentifier, TransactionConnection con)
            throws StorageQueryException;
}
