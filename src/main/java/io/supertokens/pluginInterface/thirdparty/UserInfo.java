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

package io.supertokens.pluginInterface.thirdparty;

import io.supertokens.pluginInterface.RECIPE_ID;
import io.supertokens.pluginInterface.authRecipe.AuthRecipeUserInfo;
import io.supertokens.pluginInterface.authRecipe.LoginMethod;

public class UserInfo extends AuthRecipeUserInfo {

    public ThirdParty thirdParty;

    public String email;

    public UserInfo(String id, String email, ThirdParty thirdParty, Boolean isPrimaryUser, LoginMethod loginMethod) {
        super(id, isPrimaryUser, loginMethod);
        this.thirdParty = thirdParty;
        this.email = email;
    }

    public static class ThirdParty {
        public String id;

        public String userId;

        public ThirdParty(String id, String userId) {
            this.id = id;
            this.userId = userId;
        }
    }

    public RECIPE_ID getRecipeId() {
        return RECIPE_ID.THIRD_PARTY;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof UserInfo) {
            UserInfo otherUserInfo = (UserInfo) other;
            return otherUserInfo.email.equals(this.email) && otherUserInfo.getSupertokensUserId().equals(this.getSupertokensUserId())
                    && otherUserInfo.timeJoined == this.timeJoined
                    && otherUserInfo.thirdParty.userId.equals(this.thirdParty.userId)
                    && otherUserInfo.thirdParty.id.equals(this.thirdParty.id);
        }
        return false;
    }
}