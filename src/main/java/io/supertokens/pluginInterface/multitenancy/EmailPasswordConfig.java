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

package io.supertokens.pluginInterface.multitenancy;

public class EmailPasswordConfig {
    public boolean enabled;

    public EmailPasswordConfig(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof EmailPasswordConfig) {
            EmailPasswordConfig otherEmailPasswordConfig = (EmailPasswordConfig) other;
            return otherEmailPasswordConfig.enabled == this.enabled;
        }
        return false;
    }

}
