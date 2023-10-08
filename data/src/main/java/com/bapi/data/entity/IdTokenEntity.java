package com.bapi.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_token_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String deviceUniqueId;
    private String userName;
    private String deviceType;
    private Long expiresAt;
    private String accessToken;
    private String tokenType;
}
