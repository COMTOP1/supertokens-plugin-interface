package io.supertokens.pluginInterface.totp;

public class TOTPUsedCode {
    public String userId;
    public String code;
    public boolean isValid;
    public long expiryTime;
    public long createdTime;

    public TOTPUsedCode(String userId, String code, Boolean isValidCode,
                        long expiryTime,
                        long createdTime) {
        this.userId = userId;
        this.code = code;
        this.isValid = isValidCode;
        this.expiryTime = expiryTime;
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TOTPUsedCode)) {
            return false;
        }
        TOTPUsedCode other = (TOTPUsedCode) obj;
        return this.userId.equals(other.userId) && this.code.equals(other.code)
                && this.isValid == other.isValid && this.expiryTime == other.expiryTime
                && this.createdTime == other.createdTime;
    }
}
