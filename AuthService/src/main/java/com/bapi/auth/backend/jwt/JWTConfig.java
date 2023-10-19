package com.bapi.auth.backend.jwt;

public class JWTConfig {
    private String secret;
    private String issuer;
    private String audience;
    private String myRealm;

    public JWTConfig(String secret, String issuer, String audience, String myRealm) {
        this.secret = secret;
        this.issuer = issuer;
        this.audience = audience;
        this.myRealm = myRealm;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getMyRealm() {
        return myRealm;
    }

    public void setMyRealm(String myRealm) {
        this.myRealm = myRealm;
    }

    public static JWTConfig getJwtConfig() {
        return new JWTConfig(
                "afafw2g13ggaeg13g1111QAWER29etziK0sgEdWe1euT6235pDGzc2_",
                "http://localhost:8080/",
                "http://localhost:8080/default",
                ""
        );
    }
}
