package io.supertokens.pluginInterface.totp;

public class TOTPDevice {
    public String deviceName;
    public String userId;
    public String secretKey;
    public int period;
    public int skew;
    public boolean verified;
    public long createdAt;

    public TOTPDevice(String userId, String deviceName, String secretKey, int period,
                      int skew, boolean verified, long createdAt) {
        this.userId = userId;
        this.deviceName = deviceName;
        this.secretKey = secretKey;
        this.period = period;
        this.skew = skew;
        this.verified = verified;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TOTPDevice)) {
            return false;
        }
        TOTPDevice other = (TOTPDevice) obj;
        return this.userId.equals(other.userId) &&
                this.deviceName.equals(other.deviceName)
                && this.secretKey.equals(other.secretKey) && this.period == other.period && this.skew == other.skew
                && this.verified == other.verified;
    }
}
