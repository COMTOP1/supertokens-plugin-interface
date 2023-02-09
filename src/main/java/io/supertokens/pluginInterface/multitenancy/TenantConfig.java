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

import com.google.gson.JsonObject;

public class TenantConfig {
    public TenantIdentifier tenantIdentifier;
    public boolean appIdMarkedAsDeleted;
    public boolean connectionUriDomainMarkedAsDeleted;
    public EmailPasswordConfig emailPasswordConfig;
    public PasswordlessConfig passwordlessConfig;
    public ThirdPartyConfig thirdPartyConfig;

    public JsonObject coreConfig;

    public TenantConfig(TenantIdentifier tenantIdentifier, EmailPasswordConfig emailPasswordConfig,
                        ThirdPartyConfig thirdPartyConfig,
                        PasswordlessConfig passwordlessConfig, JsonObject coreConfig, boolean appIdMarkedAsDeleted,
                        boolean connectionUriDomainMarkedAsDeleted) {
        this.tenantIdentifier = tenantIdentifier;
        this.coreConfig = coreConfig;
        this.emailPasswordConfig = emailPasswordConfig;
        this.passwordlessConfig = passwordlessConfig;
        this.thirdPartyConfig = thirdPartyConfig;
        this.appIdMarkedAsDeleted = appIdMarkedAsDeleted;
        this.connectionUriDomainMarkedAsDeleted = connectionUriDomainMarkedAsDeleted;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TenantConfig) {
            TenantConfig otherTenantConfig = (TenantConfig) other;
            return otherTenantConfig.tenantIdentifier.equals(this.tenantIdentifier);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return tenantIdentifier.hashCode();
    }
}
