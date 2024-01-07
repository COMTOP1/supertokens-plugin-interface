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

package io.supertokens.pluginInterface.emailverification.sqlStorage;

import io.supertokens.pluginInterface.authRecipe.AuthRecipeUserInfo;
import io.supertokens.pluginInterface.emailpassword.PasswordResetTokenInfo;
import io.supertokens.pluginInterface.emailpassword.exceptions.DuplicateEmailException;
import io.supertokens.pluginInterface.emailpassword.exceptions.DuplicatePasswordResetTokenException;
import io.supertokens.pluginInterface.emailpassword.exceptions.DuplicateUserIdException;
import io.supertokens.pluginInterface.emailpassword.exceptions.UnknownUserIdException;
import io.supertokens.pluginInterface.emailverification.EmailVerificationStorage;
import io.supertokens.pluginInterface.emailverification.EmailVerificationTokenInfo;
import io.supertokens.pluginInterface.exceptions.StorageQueryException;
import io.supertokens.pluginInterface.multitenancy.AppIdentifier;
import io.supertokens.pluginInterface.multitenancy.TenantIdentifier;
import io.supertokens.pluginInterface.multitenancy.exceptions.TenantOrAppNotFoundException;
import io.supertokens.pluginInterface.sqlStorage.SQLStorage;
import io.supertokens.pluginInterface.sqlStorage.SessionObject;
import io.supertokens.pluginInterface.sqlStorage.TransactionConnection;

public interface EmailVerificationSQLStorage extends EmailVerificationStorage, SQLStorage {

    EmailVerificationTokenInfo[] getAllEmailVerificationTokenInfoForUser_Transaction(SessionObject sessionInstance,
                                                                                     String userId, String email) throws StorageQueryException;

    void deleteAllEmailVerificationTokensForUser_Transaction(SessionObject sessionInstance, String userId, String email)
            throws StorageQueryException;

    void updateIsEmailVerified_Transaction(SessionObject sessionInstance, String userId, String email,
                                           boolean isEmailVerified) throws StorageQueryException;

    // we pass tenantIdentifier here cause this also adds to the userId <-> tenantId mapping
    AuthRecipeUserInfo signUp(TenantIdentifier tenantIdentifier, String id, String email, String passwordHash, long timeJoined)
            throws StorageQueryException, DuplicateUserIdException, DuplicateEmailException,
            TenantOrAppNotFoundException;

    // password reset stuff is app wide cause changing the password for a user affects all the tenants
    // across which it's shared.
    void addPasswordResetToken(AppIdentifier appIdentifier, PasswordResetTokenInfo passwordResetTokenInfo)
            throws StorageQueryException, UnknownUserIdException, DuplicatePasswordResetTokenException;

    PasswordResetTokenInfo getPasswordResetTokenInfo(AppIdentifier appIdentifier, String token)
            throws StorageQueryException;

    // we purposely do not add TenantIdentifier to this query cause
    // this is called from a cronjob that runs per user pool ID
    void deleteExpiredPasswordResetTokens() throws StorageQueryException;

    PasswordResetTokenInfo[] getAllPasswordResetTokenInfoForUser(AppIdentifier appIdentifier, String userId)
            throws StorageQueryException;

    EmailVerificationTokenInfo[] getAllEmailVerificationTokenInfoForUser_Transaction(TenantIdentifier tenantIdentifier,
                                                                                     TransactionConnection con,
                                                                                     String userId, String email)
            throws StorageQueryException;

    void deleteAllEmailVerificationTokensForUser_Transaction(TenantIdentifier tenantIdentifier,
                                                             TransactionConnection con,
                                                             String userId, String email)
            throws StorageQueryException;

    void updateIsEmailVerified_Transaction(AppIdentifier appIdentifier, TransactionConnection con, String userId,
                                           String email,
                                           boolean isEmailVerified)
            throws StorageQueryException, TenantOrAppNotFoundException;

    void deleteEmailVerificationUserInfo_Transaction(TransactionConnection con, AppIdentifier appIdentifier,
                                                     String userId) throws StorageQueryException;
}
