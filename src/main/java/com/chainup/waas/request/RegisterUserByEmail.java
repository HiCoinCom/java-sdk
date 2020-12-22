package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class RegisterUserByEmail extends CommonParam {

    /**
     * 邮箱，邮箱或虚拟账号，确保其唯一性,最多支持100字符, 是否必填：是
     */
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private RegisterUserByEmail createUserByEmail;

        private Builder() {
            createUserByEmail = new RegisterUserByEmail();
        }

        public Builder time(Long time) {
            createUserByEmail.setTime(time);
            return this;
        }

        public Builder email(String email) {
            createUserByEmail.setEmail(email);
            return this;
        }

        public Builder charset(String charset) {
            createUserByEmail.setCharset(charset);
            return this;
        }

        public Builder version(String version) {
            createUserByEmail.setVersion(version);
            return this;
        }

        public RegisterUserByEmail build() {
            return createUserByEmail;
        }
    }
}
