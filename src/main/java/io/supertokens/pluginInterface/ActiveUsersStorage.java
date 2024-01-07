package io.supertokens.pluginInterface;

import io.supertokens.pluginInterface.exceptions.StorageQueryException;
import io.supertokens.pluginInterface.multitenancy.AppIdentifier;
import io.supertokens.pluginInterface.nonAuthRecipe.NonAuthRecipeStorage;

public interface ActiveUsersStorage extends NonAuthRecipeStorage {
    /* Update the last active time of a user to now */
    void updateLastActive(AppIdentifier appIdentifier, String userId) throws StorageQueryException;

    /* Count the number of users who did some activity after given timestamp */
    int countUsersActiveSince(AppIdentifier appIdentifier, long time) throws StorageQueryException;

    /* Count the number of users who have enabled TOTP */
    int countUsersEnabledTotp(AppIdentifier appIdentifier) throws StorageQueryException;

    int countUsersThatHaveMoreThanOneLoginMethodAndActiveSince(AppIdentifier appIdentifier, long sinceTime) throws StorageQueryException;

    int countUsersThatHaveMoreThanOneLoginMethodOrTOTPEnabledAndActiveSince(AppIdentifier appIdentifier, long timestamp) throws StorageQueryException;

    /* Count the number of users who have enabled TOTP and are active */
    int countUsersEnabledTotpAndActiveSince(AppIdentifier appIdentifier, long time) throws StorageQueryException;

    void deleteUserActive(AppIdentifier appIdentifier, String userId) throws StorageQueryException;

    /* Update the last active time of a user to now */
    void updateLastActive(String userId) throws StorageQueryException;

    /* Count the number of users who did some activity after given timestamp */
    int countUsersActiveSince(long time) throws StorageQueryException;

    /* Count the number of users who have enabled TOTP */
    int countUsersEnabledTotp() throws StorageQueryException;

    /* Count the number of users who have enabled TOTP and are active */
    int countUsersEnabledTotpAndActiveSince(long time) throws StorageQueryException;
}